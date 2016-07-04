package edu.ccbcmd.pathwayguide;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    private InputStream classes, pathways;

    public PathwaysDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        classes = context.getResources().openRawResource(R.raw.classvalues);
        pathways = context.getResources().openRawResource(R.raw.pathwayvalues);

    }

    public PathwaysDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public PathwaysDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                            int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public void onCreate(SQLiteDatabase db) {
        Log.w("in", "oncreate");
        Log.w("input streams", classes.toString());
        // create tables
        db.execSQL("create table descriptions (id int auto_increment, description text unique)");
        db.execSQL("create table classes (id text, name text, description int, prereqs text, status int, foreign key(description) references description(id))");
        db.execSQL("create table subpathways  (id int auto_increment, name text, degree text, pathway text, classes text)");

        db.execSQL("insert into descriptions (id, description) values (0, \' \')");
        db.execSQL("insert into classes values (\'CSIT211\', \'Advanced Programming\', 0, \'CSIT210\', -1)");

        // populate all the classes from file
            BufferedReader rd = new BufferedReader(new InputStreamReader(classes));
            try {
                String line = rd.readLine();
                while (line != null) {
                    Log.w("line", line);
                    String[] values = line.split("|");
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

                    line = rd.readLine();
                }

            // the pathways too
            rd = new BufferedReader(new InputStreamReader(classes));
            line = rd.readLine();
                Log.w("line", "m"+line);
            while (line != null) {
                Log.w("line", line);
                String[] values = line.split("|");
                ContentValues cv = new ContentValues();

                // indices 0: name of major 1: degree type 2: pathway name 3: class sequence
                cv.put("name", values[0]);
                cv.put("degree", values[1]);
                cv.put("pathway", values[2]);
                cv.put("classes", values[3]);
                db.insert("subpathways", null, cv);
                line = rd.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
    public void onOpen(SQLiteDatabase db) {}

}
