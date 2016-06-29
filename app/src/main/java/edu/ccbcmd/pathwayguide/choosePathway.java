package edu.ccbcmd.pathwayguide;




        import android.content.res.Resources;
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

public class choosePathway extends AppCompatActivity implements View.OnClickListener
{

    public static final String[] courseInfo;
    public static final String[] courseName;
    public static final String[] courseNum;
    public static final int[][] coursePreRec;
    public static final int[] pageSwitch;
    public static final String[] pathwayName;
    public static final String[][] sub_pathwayName;
    public static final int[][][] subpathwayCoursePath;
    public int[] courseStat;
    public SharedPreferences prefs;

    static {
        courseNum = new String[] { "ACDV 101", "ENGL 101", "Gen. Ed. MATH", "BIOL 110", "PSYC 101", "BIOL 220", "PSYC 103", "CMNS 101", "SOCL 101", "BIOL 230" };
        courseName = new String[] { "Transitioning to college", "English 101", "Gen. Ed. MATH", "Biology I: Molecular and Cells", "Introduction to Psychology", "Human Anatomy and Physiology I", "Principles of Human Growth and Development", "Fundamentals of Communication", "Introduction to Sociology", "Microbiology" };
        courseInfo = new String[] { "Credits: 1\nRecommended Semester: 1st*\n\n*This course may not be required for transfer students. Ask your adviser for more information.", "English 101", "Please meet with your advisor to find out what course(s) you need to take to meet this requirement.", "Biology I: Molecular and Cells", "Introduction to Psychology", "Human Anatomy and Physiology I", "Principles of Human Growth and Development", "Fundamentals of Communication", "Introduction to Sociology", "Microbiology" };
        coursePreRec = new int[][] { new int[0], new int[0], new int[0], new int[0], new int[0], { 3 }, { 4 }, new int[0], new int[0], { 3 } };
        pageSwitch = new int[] { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 };
        pathwayName = new String[] { "Pre-Allied Health", "Technology, Science and Math", "Business, Law and Criminal Justice", "Arts and Humanities", "Behavior and Social Sciences" };
        sub_pathwayName = new String[][] { { "Nursing A.S.N.", "Occupational Therapy Assistant A.A.S.", "Dental Hygiene A.A.S.", "Medical Lab. Technology A.A.S.", "Veterinary Technology A.A.S.", "Emergency Medical Technology A.A.S.", "Respiratory Care Therapy A.A.S.", "Radiography A.A.S.", "Radiation Therapy A.A.S.", "Massage Therapy A.A.S.", "Mortuary Science A.A.S.", "Mental Health A.A.S" } };
        subpathwayCoursePath = new int[][][] { { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } } };
    }
/*
    public choosePathway() {
        final IncrementalChange $change = choosePathway.$change;
        if ($change != null) {
            final Object[] array = { null };
            array[0] = array;
            this((Object[])$change.access$dispatch("init$args.([Ljava/lang/Object;)Ljava/lang/Object;", array), null);
        }
        else {}
        if ($change != null) {
            $change.access$dispatch("init$body.(Lcom/example/nicholas/buttontest/choosePathway;)V", new Object[] { this });
            return;
        }
        this.prefs = null;
        this.courseStat = new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
    } */
    public choosePathway() {
        this.prefs = null;
        this.courseStat = new int []{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
    }

        /*

    choosePathway(final Object[] array, final InstantReloadException ex) {
        final String s = (String)array[0];
        switch (s.hashCode()) {
            default: {
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", s, s.hashCode(), "com/example/nicholas/buttontest/choosePathway"));
            }
            case -2089128195: {}
            case -2066401796: {
                this();
            }
        }
    }
*/



/* Deleted load2DArray() and loadArrayInt() methods, they can be found in MainActivity and others. */

    public void onClick(final View view) {
      /*  final IncrementalChange $change = choosePathway.$change;
        if ($change != null) {
            $change.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, view });
            return;
        } */
        try {
            final int length = choosePathway.sub_pathwayName[view.getId()].length;
            this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
            this.prefs.edit().putInt("pathwayID", view.getId()).commit();
            this.prefs.edit();
            final Intent intent = new Intent(this, (Class)chooseSub_Pathway.class);
            intent.putExtra("arrayID", String.valueOf(view.getId()));
            this.startActivity(intent);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            Toast.makeText(this, "The Pathway you selected is not currently available in this app. Please visit ccbcmd.edu/pathways to view this pathway.", Toast.LENGTH_LONG).show(); //1
        }
    }

    public void onCreate(final Bundle bundle) {
      /*  final IncrementalChange $change = choosePathway.$change;
        if ($change != null) {
            $change.access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, bundle });
        } */

            super.onCreate(bundle);
            this.setContentView(R.layout.activity_choose_pathway); //2130968606
            this.getSupportActionBar().show();
            this.getSupportActionBar().setTitle("Choose Your Pathway");
            final Resources resources = this.getResources();
            this.getSupportActionBar().setBackgroundDrawable(new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, R.drawable.header))); //2130837594
            this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
            if (this.prefs.getBoolean("firstrun", true)) {
                this.saveArrayInt(this.courseStat, "courseStat");
                this.getSupportActionBar().setHomeButtonEnabled(false);
                this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            }
            else {
                this.getSupportActionBar().setHomeButtonEnabled(true);
            }
            final LinearLayout linearLayout = (LinearLayout)this.findViewById(R.id.linearLayout3); //2131624024
            for (int length = choosePathway.pathwayName.length, i = 0; i < length; ++i) {
                final Button button = new Button(this);
                button.setOnClickListener(this);
                button.setText(choosePathway.pathwayName[i]);
                final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i != length) {
                    layoutParams.setMargins(5, 5, 5, 5);
                }
                else {
                    layoutParams.setMargins(5, 25, 5, 5);
                }
                button.setLayoutParams(layoutParams);
                button.setTag(i);
                button.setWidth(Math.round(TypedValue.applyDimension(1, 220.0f, this.getResources().getDisplayMetrics())));
                button.setId(i);
                linearLayout.addView(button);
                final LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)button.getLayoutParams();
                layoutParams2.gravity = Gravity.CENTER; //17
                button.setLayoutParams(layoutParams2);
            }

    }

    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        boolean booleanValue = true;

       //TODO: check this weird shit.
            switch (menuItem.getItemId()) {
                default: {
                    return super.onOptionsItemSelected(menuItem);
                }
                case 16908332: {
                    final Integer value = this.prefs.getInt("zoom", 0);
                    if (value == 0) {
                        this.startActivity(new Intent(this, (Class)MainActivity.class));
                        return true;
                    }
                    if (value == 1) {
                        this.startActivity(new Intent(this, (Class)MainActivityZoomOut.class));
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
}


