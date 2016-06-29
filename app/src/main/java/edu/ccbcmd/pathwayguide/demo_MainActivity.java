package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import fd.IncrementalChange;
import fd.InstantReloadException;

import showcaseview.ShowcaseView;
import materialshowcaseview.MaterialShowcaseSequence;
import materialshowcaseview.MaterialShowcaseSequence.OnSequenceItemShownListener;
import materialshowcaseview.MaterialShowcaseView;
import materialshowcaseview.MaterialShowcaseView.Builder;

public class demo_MainActivity
        extends Activity
{
    public Button b;
    public Button b1;
    public Button b2;
    public Button b3;
    public ShowcaseView.Builder showCaseView;

    public demo_MainActivity() {}

    demo_MainActivity(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
    }

    private void presentShowcaseSequence(int paramInt)
    {
        Object localObject = IncrementalChange.$change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("presentShowcaseSequence.(I)V", new Object[] { this, new Integer(paramInt) });
            return;
        }
        localObject = new MaterialShowcaseSequence(this);
        ((MaterialShowcaseSequence)localObject).setOnItemShownListener(new MaterialShowcaseSequence.OnSequenceItemShownListener()
        {
            public void onShow(MaterialShowcaseView paramAnonymousMaterialShowcaseView, int paramAnonymousInt)
            {
                IncrementalChange localIncrementalChange = IncrementalChange.$change;
                if (localIncrementalChange != null) {
                    localIncrementalChange.access$dispatch("onShow.(Luk/co/deanwild/materialshowcaseview/MaterialShowcaseView;I)V", new Object[] { this, paramAnonymousMaterialShowcaseView, new Integer(paramAnonymousInt) });
                }
            }
        });
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setDelay(paramInt).setTarget(new View(this)).setDismissText("Next").setContentText("We want to start by providing you with a simple tutorial. Please follow the prompts.").setTitleText("Welcome").withRectangleShape().setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setDelay(paramInt).setTarget(this.b).setDismissText("Next").setContentText("Shown here will be basic course information.").setTitleText("Red Colored Courses").setContentText("Notice this course's background color is red. This indicates that the course can not be registered without permission. Courses are typically red because of missing course requirements.").withRectangleShape().setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(this.b1).setDismissText("Next").setTitleText("Yellow Colored Courses").setContentText("Courses that have a yellow background are courses that you are currently able to register for.").withRectangleShape().setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(this.b2).withRectangleShape().setTitleText("Purple Colored Courses").setContentText("Courses that have a purple background indicate the courses that you are currently taking.").setDismissText("Next").setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(this.b3).withRectangleShape().setDismissText("Next").setShapePadding(pxToDp(5)).setTitleText("Green Colored Courses").setMaskColour(Color.parseColor("#F1335075")).setContentText("Courses that have a green background indicate the courses that you have successfully passed.").build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(findViewById(2131624022)).withRectangleShape().setDismissText("Next").setShapePadding(pxToDp(5)).setTitleText("Menu").setMaskColour(Color.parseColor("#F1335075")).setContentText("Clicking on the menu button will provide you with useful features and options.").build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(findViewById(2131624047)).withRectangleShape().setDismissText("Next").setShapePadding(pxToDp(5)).setTitleText("Zoom").setMaskColour(Color.parseColor("#F1335075")).setContentText("The zoom button allows you to see all your courses and sorts it by color in order to see your progress.").build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(this.b2).withRectangleShape().setTargetTouchable(true).setTitleText("Let's view more info about ENGL 101").setDismissOnTargetTouch(true).setTargetTouchable(true).setMaskColour(Color.parseColor("#F1335075")).setShapePadding(pxToDp(5)).setContentText("Click on ENGL 101 to open the details page for the course.").build());
        ((MaterialShowcaseSequence)localObject).start();
    }

    public static int pxToDp(int paramInt)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null) {
            return ((Number)localIncrementalChange.access$dispatch("pxToDp.(I)I", new Object[] { new Integer(paramInt) })).intValue();
        }
        return (int)(paramInt * Resources.getSystem().getDisplayMetrics().density);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null) {
            localIncrementalChange.access$dispatch("onActivityResult.(IILandroid/content/Intent;)V", new Object[] { this, new Integer(paramInt1), new Integer(paramInt2), paramIntent });
        }
        do
        {
            return;
            super.onActivityResult(paramInt1, paramInt2, paramIntent);
        } while ((paramInt1 != 1) || (paramInt2 != -1));
        new MaterialShowcaseView.Builder(this).setTarget(this.b2).withRectangleShape().setTargetTouchable(true).setTitleText("Let's view detailed information about ENGL 101").setDismissOnTargetTouch(true).setTargetTouchable(true).setMaskColour(Color.parseColor("#F1335075")).setShapePadding(pxToDp(5)).setContentText("Click on ENGL to open the details page for the course.").show();
    }

    public void onCreate(Bundle paramBundle)
    {
        Object localObject = IncrementalChange.$change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
            return;
        }
        super.onCreate(paramBundle);
        setContentView(2130968618);
        paramBundle = getResources();
        localObject = (LinearLayout)findViewById(2131624046);
        float f = getResources().getDisplayMetrics().density;
        int i = (int)(13 * f);
        int j = (int)(2.2D * f);
        this.b = new Button(this);
        this.b.setText("ENGL 102");
        this.b.setTextColor(Color.parseColor("#ffffff"));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.b.setPadding(i, i, i, i);
        this.b.setGravity(16);
        this.b.setGravity(1);
        this.b.setGravity(17);
        this.b.setTextSize(1, 14.0F);
        this.b.setTypeface(null, 1);
        localLayoutParams.setMargins(j, j, j, j);
        this.b.setLayoutParams(localLayoutParams);
        this.b.setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, paramBundle.getDisplayMetrics())));
        this.b.setId(0);
        this.b.setBackgroundColor(Color.parseColor("#893f4e"));
        ((LinearLayout)localObject).addView(this.b);
        localLayoutParams = (LinearLayout.LayoutParams)this.b.getLayoutParams();
        localLayoutParams.gravity = 17;
        this.b.setLayoutParams(localLayoutParams);
        this.b1 = new Button(this);
        this.b1.setText("CHEM 101");
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.b1.setPadding(i, i, i, i);
        this.b1.setGravity(16);
        this.b1.setGravity(1);
        this.b1.setGravity(17);
        this.b1.setTextSize(1, 14.0F);
        this.b1.setTypeface(null, 1);
        localLayoutParams.setMargins(j, j, j, j);
        this.b1.setLayoutParams(localLayoutParams);
        this.b1.setId(1);
        this.b1.setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, paramBundle.getDisplayMetrics())));
        this.b1.setBackgroundColor(Color.parseColor("#fcd054"));
        ((LinearLayout)localObject).addView(this.b1);
        localLayoutParams = (LinearLayout.LayoutParams)this.b1.getLayoutParams();
        localLayoutParams.gravity = 17;
        this.b1.setLayoutParams(localLayoutParams);
        this.b2 = new Button(this);
        this.b2.setText("ENGL 101");
        this.b2.setTextColor(Color.parseColor("#ffffff"));
        this.b2.setId(2);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.b2.setPadding(i, i, i, i);
        this.b2.setGravity(16);
        this.b2.setGravity(1);
        this.b2.setGravity(17);
        this.b2.setTextSize(1, 14.0F);
        this.b2.setTypeface(null, 1);
        localLayoutParams.setMargins(j, j, j, j);
        this.b2.setLayoutParams(localLayoutParams);
        this.b2.setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, paramBundle.getDisplayMetrics())));
        this.b2.setBackgroundColor(Color.parseColor("#644181"));
        ((LinearLayout)localObject).addView(this.b2);
        localLayoutParams = (LinearLayout.LayoutParams)this.b2.getLayoutParams();
        localLayoutParams.gravity = 17;
        this.b2.setLayoutParams(localLayoutParams);
        this.b2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = IncrementalChange.$change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                paramAnonymousView = new Intent(demo_MainActivity.this, demo_info.class);
                demo_MainActivity.this.startActivityForResult(paramAnonymousView, 1);
            }
        });
        this.b3 = new Button(this);
        this.b3.setText("ACDV 101");
        this.b3.setTextColor(Color.parseColor("#ffffff"));
        this.b3.setId(3);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.b3.setPadding(i, i, i, i);
        this.b3.setGravity(16);
        this.b3.setGravity(1);
        this.b3.setGravity(17);
        this.b3.setTextSize(1, 14.0F);
        this.b3.setTypeface(null, 1);
        localLayoutParams.setMargins(j, j, j, j);
        this.b3.setLayoutParams(localLayoutParams);
        this.b3.setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, paramBundle.getDisplayMetrics())));
        this.b3.setBackgroundColor(Color.parseColor("#159b8a"));
        ((LinearLayout)localObject).addView(this.b3);
        paramBundle = (LinearLayout.LayoutParams)this.b3.getLayoutParams();
        paramBundle.gravity = 17;
        this.b3.setLayoutParams(paramBundle);
        ((ImageButton)findViewById(2131624047)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = IncrementalChange.$change;
                if (localIncrementalChange != null) {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                }
            }
        });
        ((ImageButton)findViewById(2131624022)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = IncrementalChange.$change;
                if (localIncrementalChange != null) {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                }
            }
        });
        presentShowcaseSequence(500);
    }
}