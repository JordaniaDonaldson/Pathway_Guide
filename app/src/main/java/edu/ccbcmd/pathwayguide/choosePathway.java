package edu.ccbcmd.pathwayguide;




        import android.content.res.Resources;
        import android.preference.PreferenceManager;
        import android.util.TypedValue;

        import android.view.Gravity;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.graphics.drawable.BitmapDrawable;
        import android.graphics.BitmapFactory;
        import android.widget.Toast;
        import android.util.Log;

        import android.graphics.drawable.Drawable;

        import android.content.Context;

        import android.view.MenuItem;

        import android.view.View;
        import android.content.Intent;
        import android.os.Bundle;

        import android.content.SharedPreferences;

        import android.support.v7.app.AppCompatActivity;

public class choosePathway extends AppCompatActivity implements View.OnClickListener {

    public static final String[] courseInfo;
    public static final String[][] courseName;
    public static final String[][] courseNum;
    public static final int[][][] coursePreRec;
    public static final int[] pageSwitch;
    public static final String[] pathwayName;
    public static final String[][] sub_pathwayName;
    public static final int[][][] subpathwayCoursePath;
    public int[] courseStat;
    public SharedPreferences prefs;

    static {
        courseNum = new String[][]{{"ACDV 101", "ENGL 101", "Gen. Ed. MATH", "BIOL 110", "PSYC 101", "BIOL 220", "PSYC 103", "CMNS 101", "SOCL 101", "BIOL 230"},
                {"CSIT 101", "CSIT 111", "CSIT 121", "ENGL 101", "Gen. Ed. MATH", "CSIT 142", "CSIT 154", "CSIT 210", "CSIT 161", "CSIT 166", "DCOM 101/142"}};
        courseName = new String[][]{{"Transitioning to college", "English 101", "Gen. Ed. MATH", "Biology I: Molecular and Cells", "Introduction to Psychology", "Human Anatomy and Physiology I", "Principles of Human Growth and Development", "Fundamentals of Communication", "Introduction to Sociology", "Microbiology"},
                {"Technology and Information Systems", "Logic and OO Design", "Web Standards", "College Composition 1", "Gen. Ed. Math", "Introduction to MIS", "Database Concepts", "Introduction to Programming", "Introduction to Information Assurance", "Introduction to Mobile Applications Development", "DCOM Option"}};

        /*courseInfo seems a bit ...scattered?*/
        courseInfo = new String[]{"Credits: 1\nRecommended Semester: 1st*\n\n*This course may not be required for transfer students. Ask your adviser for more information.", "English 101", "Please meet with your advisor to find out what course(s) you need to take to meet this requirement.", "Biology I: Molecular and Cells", "Introduction to Psychology", "Human Anatomy and Physiology I", "Principles of Human Growth and Development", "Fundamentals of Communication", "Introduction to Sociology", "Microbiology"};
       /* prerec is a mess*/
        coursePreRec = new int[][][]{{new int[0], new int[0], new int[0], new int[0], new int[0], {3}, {4}, new int[0], new int[0], {3}},
                {new int[0],new int[0],new int[0],new int[0],new int[0],new int[0],new int[0],new int[0],new int[0],new int[0],new int[0]}};
        // TODO: 7/3/2016 make pageSwitch work with other paths. may crash as-is
        pageSwitch = new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0};
        pathwayName = new String[]{"Pre-Allied Health", "Technology, Science and Math", "Business, Law and Criminal Justice", "Arts and Humanities", "Behavior and Social Sciences"};
        sub_pathwayName = new String[][]{{"Nursing A.S.N.", "Occupational Therapy Assistant A.A.S.", "Dental Hygiene A.A.S.", "Medical Lab. Technology A.A.S.", "Veterinary Technology A.A.S.", "Emergency Medical Technology A.A.S.", "Respiratory Care Therapy A.A.S.", "Radiography A.A.S.", "Radiation Therapy A.A.S.", "Massage Therapy A.A.S.", "Mortuary Science A.A.S.", "Mental Health A.A.S"},
                {"Information Technology", "Computer-Aided Drafting and Design", "Network Technology" }};
        /*not entirely sure the necessity of this */
        subpathwayCoursePath = new int[][][]{{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
                {0,1,2,3,4,5,6,7,8,9,10, 11, 12, 13}}};
    }



    public void onClick(final View view) {

        //This shared preferences allows us to record the user choices. THIS shared preferences variable will be
        //for the courses that are done.
        SharedPreferences pathwayPref = getApplicationContext().getSharedPreferences("pathway", Context.MODE_PRIVATE);
        //The editor so we can save those preferences.
        SharedPreferences.Editor editor = pathwayPref.edit();



        switch (view.getId()){
            case 0: {
                Log.e("ChooseP","alliedHealth");
                editor.putInt("PathwayChoice", CourseContract.PRE_ALLIED_HEALTH._PRE_ALLIED_HEALTH);
                editor.apply();
                break;
            }
            case 1: {
                Log.e("ChooseP", "TSM");
                editor.putInt("PathwayChoice", CourseContract.TSM.TSM_COMPUTER_SCIENCE_IT);
                editor.apply();
                break;
            }
            default: {
                Log.e("ChooseP","DEFAULT!!!");
                editor.putInt("PathwayChoice", CourseContract.PRE_ALLIED_HEALTH._PRE_ALLIED_HEALTH);
                editor.apply();
                break;
            }
        }


        try {
            Log.w("pathID", String.valueOf(view.getId()));

            final int length = choosePathway.sub_pathwayName[view.getId()].length;
            this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
            this.prefs.edit().putInt("pathwayID", view.getId()).commit();

            final Intent intent = new Intent(this, (Class) chooseSub_Pathway.class);
            intent.putExtra("arrayID", String.valueOf(view.getId()));
            this.startActivity(intent);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Toast.makeText(this, "The Pathway you selected is not currently available in this app. Please visit ccbcmd.edu/pathways to view this pathway.", Toast.LENGTH_LONG).show(); //1
        }
    }

    public void onCreate(final Bundle bundle) {

        super.onCreate(bundle);
        this.setContentView(R.layout.activity_choose_pathway); //2130968606
        this.getSupportActionBar().show();
        this.getSupportActionBar().setTitle("Choose Your Pathway");
        final Resources resources = this.getResources();
        this.getSupportActionBar().setBackgroundDrawable(new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, R.drawable.header))); //2130837594
        this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
        if (this.prefs.getBoolean("firstrun", true)) {
                /* this code won't be necessary if the code in MainActivity is fixed */
            if (courseStat == null) {
                courseStat = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}; // copied this from MainActivity
            }

            this.saveArrayInt(this.courseStat, "courseStat");
            this.getSupportActionBar().setHomeButtonEnabled(false);
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            this.getSupportActionBar().setHomeButtonEnabled(true);
        }
        final LinearLayout linearLayout = (LinearLayout) this.findViewById(R.id.linearLayout3); //2131624024
        for (int length = choosePathway.pathwayName.length, i = 0; i < length; ++i) {
            final Button button = new Button(this);
            button.setOnClickListener(this);
            button.setText(choosePathway.pathwayName[i]);
            final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i != length) {
                layoutParams.setMargins(5, 5, 5, 5);
            } else {
                layoutParams.setMargins(5, 25, 5, 5);
            }
            button.setLayoutParams(layoutParams);
            button.setTag(i);
            button.setWidth(Math.round(TypedValue.applyDimension(1, 220.0f, this.getResources().getDisplayMetrics())));
            button.setId(i);
            linearLayout.addView(button);
            final LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button.getLayoutParams();
            layoutParams2.gravity = Gravity.CENTER; //17
            button.setLayoutParams(layoutParams2);
        }

    }

    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        boolean booleanValue = true;




        switch (menuItem.getItemId()) {
            default: {
                return super.onOptionsItemSelected(menuItem);
            }
            case 16908332: {
                final Integer value = this.prefs.getInt("zoom", 0);
                if (value == 0) {
                    this.startActivity(new Intent(this, (Class) MainActivity.class));
                    return true;
                }
                if (value == 1) {
                    this.startActivity(new Intent(this, (Class) MainActivityZoomOut.class));
                    return true;
                }
                break;
            }
        }

        return booleanValue;
    }

    public boolean save2DArray(final String[][] array, final String s) {

        final SharedPreferences.Editor edit = this.getSharedPreferences("preferencename", 0).edit();
        edit.putInt(s + "_size", array.length);
        for (int i = 0; i < array.length; ++i) {
            edit.putInt(s + "_size_" + i, array[i].length);
            for (int j = 0; j < array[i].length; ++j) {
                edit.putString(s + "_" + i + "_" + j, array[i][j]);
            }
        }
        Toast.makeText(this, "Array Has been saved", Toast.LENGTH_LONG).show(); //1
        return edit.commit();
    }

    public boolean save2DArrayInt(final int[][] array, final String s) {

        final SharedPreferences.Editor edit = this.getSharedPreferences("preferencename", 0).edit();
        edit.putInt(s + "_size", array.length);
        for (int i = 0; i < array.length; ++i) {
            edit.putInt(s + "_size_" + i, array[i].length);
            for (int j = 0; j < array[i].length; ++j) {
                edit.putInt(s + "_" + i + "_" + j, array[i][j]);
            }
        }
        Toast.makeText(this, "Array Has been saved", Toast.LENGTH_LONG).show(); //1
        return edit.commit();
    }

    public boolean saveArrayInt(final int[] array, final String s) {

        final SharedPreferences.Editor edit = this.getSharedPreferences("preferencename", 0).edit();
        edit.putInt(s + "_size", array.length);
        for (int i = 0; i < array.length; ++i) {
            edit.putInt(s + "_" + i, array[i]);
        }
        return edit.commit();
    }


    public String[][] load2DArray(String s) {

        SharedPreferences sharedPreferences = this.getSharedPreferences("preferencename", 0);
        int int1 = sharedPreferences.getInt(s + "_size", 0);
        String[][] array = new String[int1][];
        for (int i = 0; i < int1; ++i) {
            int int2 = sharedPreferences.getInt(s + "_size_" + i, 0);
            Log.d("I Loop", String.valueOf(i));
            String[] array2 = new String[int2];
            for (int j = 0; j < int2; ++j) {
                Log.d("T Loop", sharedPreferences.getString(s + "_" + i + "_" + j, "hi"));
                array2[j] = sharedPreferences.getString(s + "_" + i + "_" + j, "hi");
            }
            array[i] = array2;
        }
        return array;
    }

    public int[] loadArrayInt(String s) {

        SharedPreferences sharedPreferences = this.getSharedPreferences("preferencename", 0);
        int int1 = sharedPreferences.getInt(s + "_size", 0);
        int[] array = new int[int1];

        for (int i = 0; i < int1; ++i) {
            array[i] = sharedPreferences.getInt(s + "_" + i, 1);
        }

        return array;
    }

}


