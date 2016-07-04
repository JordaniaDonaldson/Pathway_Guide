package edu.ccbcmd.pathwayguide;

import java.util.Scanner;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.*;
import android.database.Cursor;
import android.content.ContentValues;
import android.util.Log;

/**
 * Created by dorothy on 7/3/16.
 */
public class PathwaysDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "pathways.db";
    public static final int DATABASE_VERSION = 1;

    public PathwaysDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public PathwaysDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public PathwaysDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                            int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public void onCreate(SQLiteDatabase db) {
        // create tables
        db.execSQL("create table descriptions (id int auto_increment, description text unique)");
        db.execSQL("create table classes (id text, name text, description int, prereqs text, status int, foreign key(description) references description(id))");
        db.execSQL("create table subpathways  (id int auto_increment, name text, degree text, pathway text, classes text)");

        // populate all the classes from file
        Scanner classes = new Scanner("classvalues.txt");
        while(classes.hasNextLine()) {
            String[] values = classes.nextLine().split("|");
            ContentValues cv = new ContentValues();

            // indices 0: id 1: name 2: description 3: prereqs
            // take care of description - first check to see if in the table
            long id = -1;
            Cursor c = db.query(false, "descriptions", new String[]{"id"}, "description = ?", new String[]{values[2]}, null, null, null, null);
            if (c.getCount() == 0) { // it's not already in the table
                cv.put("description", values[2]);
                id = db.insert("descriptions", null, cv);
                cv.clear();
            } else {
                c.moveToNext();
                id = c.getInt(0);
            }

            // now the rest of the data
            cv.put("id", values[0]);
            cv.put("name", values[1]);
            cv.put("description", id);
            cv.put("prereqs", values[3]);
            cv.put("status", -1);
            db.insert("classes", null, cv);
        }

        // the pathways too
        Scanner pathways = new Scanner("pathwayvalues.txt");
        while(pathways.hasNextLine()) {
            String[] values = pathways.nextLine().split("|");
            ContentValues cv = new ContentValues();

            // indices 0: name of major 1: degree type 2: pathway name 3: class sequence
            cv.put("name", values[0]);
            cv.put("degree", values[1]);
            cv.put("pathway", values[2]);
            cv.put("classes", values[3]);
            db.insert("subpathways", null, cv);
        }
        classes.close();
        pathways.close();
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    public void onOpen(SQLiteDatabase db) {}

}
