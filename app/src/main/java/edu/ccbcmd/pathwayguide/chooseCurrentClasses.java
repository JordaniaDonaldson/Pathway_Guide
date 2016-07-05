package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */




import android.annotation.TargetApi;
import android.content.res.Resources;

import android.os.Build;
import android.util.Log;
import android.widget.Button;
import android.graphics.Color;

import android.content.res.ColorStateList;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.BitmapFactory;
import android.widget.CheckBox;
import android.support.v4.content.ContextCompat;

import android.content.Context;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import materialshowcaseview.MaterialShowcaseView;

public class chooseCurrentClasses extends AppCompatActivity
{

    public SharedPreferences prefs;




    public static int getColor(final Context context, final int n) {

        if (Build.VERSION.SDK_INT >= 23) {
            return ContextCompat.getColor(context, n);
        }
        return context.getResources().getColor(n);
    }

    private void loopQuestions(final ViewGroup viewGroup) {

        final int length = choosePathway.subpathwayCoursePath[0][this.prefs.getInt("pathwayID", 0)].length;
        int n = 0;
        Label_0170_Outer:
        while (n < length-1) {
            Label_0182: {
                if (n>length-2){  break Label_0170_Outer;}
                while (n < length) {

                    try {
                        final CheckBox checkBox = (CheckBox) viewGroup.getChildAt(n);
                        int n2;
                        if (checkBox.isChecked()) {
                            n2 = 1;
                        } else {
                            n2 = 0;
                        }
                        final int id = checkBox.getId();
                        if (n2 == 1) {
                            this.getSharedPreferences("preferencename", 0).edit().putInt("courseStat_" + id, 1).commit();
                        }
                        n++;
                        continue Label_0170_Outer;
                    } catch (NullPointerException e) {
                        // it's probably the checkBox
                        // for right now, I'm just going to increase n -- Dorothy
                        n++;
                    } catch (Exception ex) {
                        System.err.println(ex); // at least for debugging, let's see what the error is
                        continue;
                    }
                }
                break;
            }

        }

        //Getting a handle for the shared preference editor
        SharedPreferences sharedPrefDone = getSharedPreferences("courses", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPrefDone.edit();

        String[] courseLabels = getResources().getStringArray(R.array.AlliedHealthPathway);
        List<CheckBox> checkBoxesInProgress = new ArrayList<CheckBox>();
        for (int i = 0; i<viewGroup.getChildCount(); i++){
            checkBoxesInProgress.add((CheckBox) viewGroup.getChildAt(i));
        }


        //My code
        SharedPreferences sharedPrefInProgress = getSharedPreferences("coursesInProgress", Context.MODE_PRIVATE);
        SharedPreferences.Editor editorIP = sharedPrefInProgress.edit();

        //In this for loop you will find it saving the state of the check box to the shared preferences.
        int counter = 0;

        //TODO FIX THIS SO IT COUNTS THE COURSES RIGHT!
        //I"M LEAVING IT BROKEN SO I CAN FIX OTHER PARTS OF THE PROJECT
        for (int i = 0; i < checkBoxesInProgress.size(); i++) {

                CheckBox box = checkBoxesInProgress.get(counter);
                counter++;
                if (box.isChecked()) {
                    editorIP.putBoolean(courseLabels[i], true);

                    editorIP.commit();
                } else {
                    editorIP.putBoolean(courseLabels[i], false);

                    editorIP.commit();
                }
        }






        this.startActivity(new Intent(this, (Class)MainActivity.class));
    }

    public int[] loadArrayInt(final String s) {

        final SharedPreferences sharedPreferences = this.getSharedPreferences("preferencename", 0);
        final int int1 = sharedPreferences.getInt(s + "_size", 0);
        final int[] array = new int[int1];
        for (int i = 0; i < int1; ++i) {
            array[i] = sharedPreferences.getInt(s + "_" + i, 1);
        }
        return array;
    }

    private static int length_of_classes;

    @TargetApi(23)
    public void onCreate(final Bundle bundle) {

        super.onCreate(bundle);
        this.setContentView(R.layout.activity_choose_current_classes); //2130968605

        CourseClassLoader courseClassLoader = new CourseClassLoader(getApplicationContext());
        List<CourseClass> courseList = courseClassLoader.loadClassObjects();
        length_of_classes = courseClassLoader.howManyCourses();

        this.getSupportActionBar().show();
        this.getSupportActionBar().setTitle("Choose Classes");
        final Resources resources = this.getResources();
        this.getSupportActionBar().setBackgroundDrawable(new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, R.drawable.header))); //2130837594
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.getResources();
        this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
        final int[] loadArrayInt = this.loadArrayInt("courseStat");
        final Integer pathID = this.prefs.getInt("pathwayID", 0);
        final Integer pathSubID = this.prefs.getInt("pathwaysubID", 0);
        new RelativeLayout(this);
        final LinearLayout linearLayout = (LinearLayout)this.findViewById(R.id.linearLayout16); //2131624032
        int length = length_of_classes;
        for (int i = 0; i < length; ++i) {
            CourseClass course = courseList.get(i);
            final int id = i;
            if (!course.getDone() && !course.getPreReqs().equals("PERMISSION")) {
                final CheckBox checkBox = new CheckBox(this);
                checkBox.setText((course.getTitle() + ": " + course.getFullTitle()));
                checkBox.setId(id);
                checkBox.setButtonTintList(ColorStateList.valueOf(getColor(this, R.color.pathwayblue))); //2131558446
                linearLayout.addView(checkBox);
            }
        }
        new MaterialShowcaseView.Builder(this).setTarget(new View(this)).setDismissText("Okay").setTitleText("Please select the courses that you are currently taking").withRectangleShape().setMaskColour(Color.parseColor("#F1335075")).setContentText("Please check any of the courses that your are currently taking. If you are not currently taking any courses, please leave everything blank.").setDelay(100).show();
        this.findViewById(R.id.current).setOnClickListener(new View.OnClickListener() { //2131624033


            public void onClick(final View view) {

                loopQuestions((ViewGroup)chooseCurrentClasses.this.findViewById(R.id.linearLayout16));//2131624032
            }
        });
    }
}
