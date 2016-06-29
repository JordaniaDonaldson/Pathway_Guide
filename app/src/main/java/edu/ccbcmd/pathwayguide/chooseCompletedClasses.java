package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import fd.IncrementalChange;
import fd.InstantReloadException;
import materialshowcaseview.MaterialShowcaseView;
import materialshowcaseview.MaterialShowcaseView.Builder;

public class chooseCompletedClasses
        extends AppCompatActivity
{
    public SharedPreferences prefs;

    public chooseCompletedClasses() {}

    chooseCompletedClasses(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
    }

    public static final int getColor(Context paramContext, int paramInt)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null) {
            return ((Number)localIncrementalChange.access$dispatch("getColor.(Landroid/content/Context;I)I", new Object[] { paramContext, new Integer(paramInt) })).intValue();
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return ContextCompat.getColor(paramContext, paramInt);
        }
        return paramContext.getResources().getColor(paramInt);
    }

    private void loopQuestions(ViewGroup paramViewGroup)
    {
        Object localObject = IncrementalChange.$change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("loopQuestions.(Landroid/view/ViewGroup;)V", new Object[] { this, paramViewGroup });
            return;
        }
        int i = 0;
        if (i < paramViewGroup.getChildCount())
        {
            localObject = (CheckBox)paramViewGroup.getChildAt(i);
            if (((CheckBox)localObject).isChecked()) {}
            for (int j = 1;; j = 0)
            {
                ((CheckBox)localObject).getId();
                if (j == 1) {
                    getSharedPreferences("preferencename", 0).edit().putInt("courseStat_" + i, 0).commit();
                }
                i += 1;
                break;
            }
        }
        startActivity(new Intent(this, chooseCurrentClasses.class));
    }

    @TargetApi(23)
    public void onCreate(Bundle paramBundle)
    {
        Object localObject = IncrementalChange.$change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
            return;
        }
        super.onCreate(paramBundle);
        setContentView(2130968604);
        getSupportActionBar().show();
        getSupportActionBar().setTitle("Choose Completed Courses");
        paramBundle = getResources();
        paramBundle = new BitmapDrawable(paramBundle, BitmapFactory.decodeResource(paramBundle, 2130837594));
        getSupportActionBar().setBackgroundDrawable(paramBundle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getResources();
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        this.prefs.edit().putBoolean("firstrun", false).commit();
        paramBundle = Integer.valueOf(this.prefs.getInt("pathwayID", 0));
        localObject = Integer.valueOf(this.prefs.getInt("pathwaysubID", 0));
        new RelativeLayout(this);
        LinearLayout localLinearLayout = (LinearLayout)findViewById(2131624031);
        int j = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject.intValue()].length;
        int i = 0;
        while (i < j)
        {
            int k = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject.intValue()][i];
            CheckBox localCheckBox = new CheckBox(this);
            localCheckBox.setText(choosePathway.courseNum[k] + ": " + choosePathway.courseName[k]);
            localCheckBox.setId(k);
            if (Build.VERSION.SDK_INT >= 16) {
                localCheckBox.setButtonTintList(ColorStateList.valueOf(getColor(this, 2131558446)));
            }
            localLinearLayout.addView(localCheckBox);
            i += 1;
        }
        new MaterialShowcaseView.Builder(this).setTarget(new View(this)).setDismissText("Okay").setTitleText("Please select the courses that you have completed").withRectangleShape().setMaskColour(Color.parseColor("#F1335075")).setContentText("Please select the courses that you are sure you have successfully completed. If you are a transfer student, talk with your advisor to determine what courses will transfer.").setDelay(100).show();
        ((Button)findViewById(2131624030)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                paramAnonymousView = (LinearLayout)chooseCompletedClasses.this.findViewById(2131624031);
                chooseCompletedClasses.access$000(chooseCompletedClasses.this, paramAnonymousView);
            }
        });
    }
}
