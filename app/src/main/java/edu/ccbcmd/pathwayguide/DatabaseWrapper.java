package edu.ccbcmd.pathwayguide;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseWrapper {

    protected static SQLiteDatabase db;

    public static final int NOT_A_CLASS = -2;
    public static final int NOT_AVAILABLE = -1;
    public static final int NOT_COMPLETED = 0;
    public static final int IN_PROGRESS = 1;
    public static final int COMPLETED = 2;

    // returns the classes (represented as class IDs) required for a subpathway as a string array
    // if the subpathway doesn't exist, it returns a string array of length 0
    // for a list of valid subpathway names, look in res/raw/pathwayvalues.txt
    public static String[] getSubPathwayClasses(String subpathway) {
        Cursor c = db.query(true, "subpathways", new String[] {"classes"}, "name = ?", new String[] {subpathway}, null, null, null, null);
        if (c.getCount() == 0) return new String[0];
        else {
            c.moveToNext();
            String classStr = c.getString(c.getColumnIndex("classes"));
            c.close();
            return classStr.split(" ");
        }
    }

    // returns the subpathways in a pathway as a string array
    // if the pathway doesn't exist, it returns a string array of length 0
    // for a list of valid pathway names, look in res/raw/pathwayvalues.txt
    public static String[] getSubPathways(String pathway) {
        Cursor c = db.query(true, "subpathways", new String[] {"name"}, "pathway = ?", new String[] {pathway}, null, null, null, null);
        String[] subpathways = new String[c.getCount()];
        for (int i=0; c.moveToNext(); i++) {
            subpathways[i] = c.getString(c.getColumnIndex("name"));
        }
        c.close();
        return subpathways;
    }

    // returns the status of a particular class as an int
    // if the class isn't valid, it returns NOT_A_CLASS (== -2)
    // for a list of valid class ids, look at res/raw/classvalues.txt
    public static int getClassStatus(String classID) {
        Cursor c = db.query(true, "classes", new String[] {"status"}, "id = ?", new String[] {classID}, null, null, null, null);
        if (c.getCount() == 0) return NOT_A_CLASS;
        c.moveToNext();
        int status = c.getInt(c.getColumnIndex("status"));
        c.close();
        return status;
    }

    // returns a list of prereqs for a class as a string array
    // if the class isn't valid, it returns a string array of length 0
    // the prereqs returned are valid class ids
    // for a list of all class ids, look at res/raw/classvalues.txt
    public static String[] getClassPrereqs(String classID) {
        Cursor c = db.query(true, "classes", new String[] {"prereqs"}, "id = ?", new String[] {classID}, null, null, null, null);
        if (c.getCount() == 0) return new String[0];
        c.moveToNext();
        String[] prereqs = c.getString(c.getColumnIndex("prereqs")).split(" ");
        c.close();
        return prereqs;
    }

    // returns all of the class's info as a string array
    // index 0: class ID    3: class prereqs (as single string)
    //       1: class name  4: class status (as int)
    //       2: class description
    // if the classID is invalid, it returns a string array of length 0
    // for a list of valid classIDs, see res/raw/classvalues.txt
    public static String[] getClassInfo(String classID) {
        Cursor c = db.query(true, "classes", null, "id = ?", new String[] {classID}, null, null, null, null);
        if (c.getCount() == 0) return new String[0];
        c.moveToNext();
        String[] info = new String[5];
        info[0] = c.getString(c.getColumnIndex("id"));
        info[1] = c.getString(c.getColumnIndex("name"));
        info[3] = c.getString(c.getColumnIndex("prereqs"));
        info[4] = c.getString(c.getColumnIndex("status"));

        // get the description from the descriptions table
        int des = c.getInt(c.getColumnIndex("description"));
        Cursor d = db.query(true, "descriptions", new String[] {"description"}, "id = ?", new String[] {((Integer) des).toString()}, null, null, null, null);
        d.moveToNext(); // guaranteed at least one record because of foreign key constraint
        info[2] = d.getString(d.getColumnIndex("description"));

        return info;
    }

    // updates a class status in the database and returns its success
    // use the constants in DatabaseWrapper for the status (NOT_AVAILABLE, NOT_COMPLETED, IN_PROGRESS, COMPLETED)
    // if the status isn't valid (ie isn't one of the constants), it throws an IllegalArgumentException
    // if the classID is invalid, it returns false
    // for a list of valid classIDs, see res/raw/classvalues.txt
    public static boolean writeClassStatus(String classID, int status) {
        if (status < -1 || status > 2) throw new IllegalArgumentException("Not a valid class status");
        ContentValues cv = new ContentValues();
        cv.put("status", status);
        if (db.update("classes", cv, "id = ?", new String[] {classID}) == 0) return false;
        return true;
    }

}
