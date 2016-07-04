package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */




import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import showcaseview.ShowcaseView;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class demo_MainActivity extends Activity
{

    public Button b;
    public Button b1;
    public Button b2;
    public Button b3;
    public ShowcaseView.Builder showCaseView;

    private void presentShowcaseSequence(final int n) {

        final MaterialShowcaseSequence materialShowcaseSequence = new MaterialShowcaseSequence(this);
        materialShowcaseSequence.setOnItemShownListener(new MaterialShowcaseSequence.OnSequenceItemShownListener() {

            public void onShow(final MaterialShowcaseView materialShowcaseView, final int n) {

            }
        });


        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder(this).setDelay(n).setTarget(new View(this)).setDismissText("Next").setContentText("We want to start by providing you with a simple tutorial. Please follow the prompts.").setTitleText("Welcome").withRectangleShape().setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).build());
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder(this).setDelay(n).setTarget(this.b).setDismissText("Next").setContentText("Shown here will be basic course information.").setTitleText("Red Colored Courses").setContentText("Notice this course's background color is red. This indicates that the course can not be registered without permission. Courses are typically red because of missing course requirements.").withRectangleShape().setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).build());
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(this.b1).setDismissText("Next").setTitleText("Yellow Colored Courses").setContentText("Courses that have a yellow background are courses that you are currently able to register for.").withRectangleShape().setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).build());
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(this.b2).withRectangleShape().setTitleText("Purple Colored Courses").setContentText("Courses that have a purple background indicate the courses that you are currently taking.").setDismissText("Next").setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).build());
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(this.b3).withRectangleShape().setDismissText("Next").setShapePadding(pxToDp(5)).setTitleText("Green Colored Courses").setMaskColour(Color.parseColor("#F1335075")).setContentText("Courses that have a green background indicate the courses that you have successfully passed.").build());
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(this.findViewById(R.id.button2)).withRectangleShape().setDismissText("Next").setShapePadding(pxToDp(5)).setTitleText("Menu").setMaskColour(Color.parseColor("#F1335075")).setContentText("Clicking on the menu button will provide you with useful features and options.").build()); //2131624022
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(this.findViewById(R.id.zoomout)).withRectangleShape().setDismissText("Next").setShapePadding(pxToDp(5)).setTitleText("Zoom").setMaskColour(Color.parseColor("#F1335075")).setContentText("The zoom button allows you to see all your courses and sorts it by color in order to see your progress.").build()); //2131624047
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(this.b2).withRectangleShape().setTargetTouchable(true).setTitleText("Let's view more info about ENGL 101").setDismissOnTargetTouch(true).setTargetTouchable(true).setMaskColour(Color.parseColor("#F1335075")).setShapePadding(pxToDp(5)).setContentText("Click on ENGL 101 to open the details page for the course.").build());
        materialShowcaseSequence.start();
    }

    public static int pxToDp(final int n) {

        return (int)(n * Resources.getSystem().getDisplayMetrics().density);
    }

    public void onActivityResult(final int n, final int n2, final Intent intent) {


            super.onActivityResult(n, n2, intent);
            if (n == 1 && n2 == -1) {
                new MaterialShowcaseView.Builder(this).setTarget(this.b2).withRectangleShape().setTargetTouchable(true).setTitleText("Let's view detailed information about ENGL 101").setDismissOnTargetTouch(true).setTargetTouchable(true).setMaskColour(Color.parseColor("#F1335075")).setShapePadding(pxToDp(5)).setContentText("Click on ENGL to open the details page for the course.").show();
            }

    }

    public void onCreate(final Bundle bundle) {

        super.onCreate(bundle);
        this.setContentView(R.layout.activity_main_demo); //2130968618
        final Resources resources = this.getResources();
        final LinearLayout linearLayout = (LinearLayout)this.findViewById(R.id.linearLayout2); //2131624046
        final float density = this.getResources().getDisplayMetrics().density;
        final int n = (int)(13 * density);
        final int n2 = (int)(2.2 * density);
        (this.b = new Button(this)).setText("ENGL 102");
        this.b.setTextColor(Color.parseColor("#ffffff"));
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.b.setPadding(n, n, n, n);
        this.b.setGravity(16);
        this.b.setGravity(1);
        this.b.setGravity(17);
        this.b.setTextSize(1, 14.0f);
        this.b.setTypeface(null, 1);
        layoutParams.setMargins(n2, n2, n2, n2);
        this.b.setLayoutParams(layoutParams);
        this.b.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
        this.b.setId(0);
        this.b.setBackgroundColor(Color.parseColor("#893f4e"));
        linearLayout.addView(this.b);
        final LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
        layoutParams2.gravity = Gravity.CENTER; //17
        this.b.setLayoutParams(layoutParams2);
        (this.b1 = new Button(this)).setText("CHEM 101");
        final LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.b1.setPadding(n, n, n, n);
        this.b1.setGravity(16);
        this.b1.setGravity(1);
        this.b1.setGravity(17);
        this.b1.setTextSize(1, 14.0f);
        this.b1.setTypeface(null, 1);
        layoutParams3.setMargins(n2, n2, n2, n2);
        this.b1.setLayoutParams(layoutParams3);
        this.b1.setId(1);
        this.b1.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
        this.b1.setBackgroundColor(Color.parseColor("#fcd054"));
        linearLayout.addView(this.b1);
        final LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams)this.b1.getLayoutParams();
        layoutParams4.gravity = Gravity.CENTER; //17
        this.b1.setLayoutParams(layoutParams4);
        (this.b2 = new Button(this)).setText("ENGL 101");
        this.b2.setTextColor(Color.parseColor("#ffffff"));
        this.b2.setId(2);
        final LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        this.b2.setPadding(n, n, n, n);
        this.b2.setGravity(16);
        this.b2.setGravity(1);
        this.b2.setGravity(17);
        this.b2.setTextSize(1, 14.0f);
        this.b2.setTypeface(null, 1);
        layoutParams5.setMargins(n2, n2, n2, n2);
        this.b2.setLayoutParams(layoutParams5);
        this.b2.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
        this.b2.setBackgroundColor(Color.parseColor("#644181"));
        linearLayout.addView(this.b2);
        final LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams)this.b2.getLayoutParams();
        layoutParams6.gravity = Gravity.CENTER; //17
        this.b2.setLayoutParams(layoutParams6);
        this.b2.setOnClickListener(new View.OnClickListener() {


            public void onClick(final View view) {

                demo_MainActivity.this.startActivityForResult(new Intent(demo_MainActivity.this, (Class)demo_info.class), 1);
            }
        });
        (this.b3 = new Button(this)).setText("ACDV 101");
        this.b3.setTextColor(Color.parseColor("#ffffff"));
        this.b3.setId(3);
        final LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        this.b3.setPadding(n, n, n, n);
        this.b3.setGravity(16);
        this.b3.setGravity(1);
        this.b3.setGravity(17);
        this.b3.setTextSize(1, 14.0f);
        this.b3.setTypeface(null, 1);
        layoutParams7.setMargins(n2, n2, n2, n2);
        this.b3.setLayoutParams(layoutParams7);
        this.b3.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
        this.b3.setBackgroundColor(Color.parseColor("#159b8a"));
        linearLayout.addView(this.b3);
        final LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams)this.b3.getLayoutParams();
        layoutParams8.gravity = Gravity.CENTER; //17
        this.b3.setLayoutParams(layoutParams8);
        this.findViewById(R.id.zoomout).setOnClickListener(new View.OnClickListener() { //2131624047

            public void onClick(final View view) {

            }
        });

        this.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() { //2131624022


            public void onClick(final View view) {

            }
        });
        this.presentShowcaseSequence(500);
    }
}
