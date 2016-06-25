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
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView.Builder;

public class chooseCurrentClasses
        extends AppCompatActivity
{
    public SharedPreferences prefs;

    public chooseCurrentClasses() {}

    chooseCurrentClasses(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
    }

    public static final int getColor(Context paramContext, int paramInt)
    {
        IncrementalChange localIncrementalChange = $change;
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
        Object localObject = $change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("loopQuestions.(Landroid/view/ViewGroup;)V", new Object[] { this, paramViewGroup });
            return;
        }
        int i = this.prefs.getInt("pathwayID", 0);
        int j = this.prefs.getInt("pathwaysubID", 0);
        int k = choosePathway.subpathwayCoursePath[Integer.valueOf(i).intValue()][Integer.valueOf(j).intValue()].length;
        i = 0;
        if (i < k) {
            for (;;)
            {
                try
                {
                    localObject = (CheckBox)paramViewGroup.getChildAt(i);
                    if (!((CheckBox)localObject).isChecked()) {
                        continue;
                    }
                    j = 1;
                    int m = ((CheckBox)localObject).getId();
                    if (j == 1) {
                        getSharedPreferences("preferencename", 0).edit().putInt("courseStat_" + m, 1).commit();
                    }
                }
                catch (Exception localException)
                {
                    continue;
                }
                i += 1;
                break;
                j = 0;
            }
        }
        startActivity(new Intent(this, MainActivity.class));
    }

    public int[] loadArrayInt(String paramString)
    {
        Object localObject = $change;
        if (localObject != null) {
            return (int[])((IncrementalChange)localObject).access$dispatch("loadArrayInt.(Ljava/lang/String;)[I", new Object[] { this, paramString });
        }
        localObject = getSharedPreferences("preferencename", 0);
        int j = ((SharedPreferences)localObject).getInt(paramString + "_size", 0);
        int[] arrayOfInt = new int[j];
        int i = 0;
        while (i < j)
        {
            arrayOfInt[i] = ((SharedPreferences)localObject).getInt(paramString + "_" + i, 1);
            i += 1;
        }
        return arrayOfInt;
    }

    @TargetApi(23)
    public void onCreate(Bundle paramBundle)
    {
        Object localObject = $change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
            return;
        }
        super.onCreate(paramBundle);
        setContentView(2130968605);
        getSupportActionBar().show();
        getSupportActionBar().setTitle("Choose Classes");
        paramBundle = getResources();
        paramBundle = new BitmapDrawable(paramBundle, BitmapFactory.decodeResource(paramBundle, 2130837594));
        getSupportActionBar().setBackgroundDrawable(paramBundle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getResources();
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        paramBundle = loadArrayInt("courseStat");
        localObject = Integer.valueOf(this.prefs.getInt("pathwayID", 0));
        Integer localInteger = Integer.valueOf(this.prefs.getInt("pathwaysubID", 0));
        new RelativeLayout(this);
        LinearLayout localLinearLayout = (LinearLayout)findViewById(2131624032);
        int j = choosePathway.subpathwayCoursePath[localObject.intValue()][localInteger.intValue()].length;
        int i = 0;
        while (i < j)
        {
            int k = choosePathway.subpathwayCoursePath[localObject.intValue()][localInteger.intValue()][i];
            if (paramBundle[i] == 2)
            {
                CheckBox localCheckBox = new CheckBox(this);
                localCheckBox.setText(choosePathway.courseNum[k] + ": " + choosePathway.courseName[k]);
                localCheckBox.setId(k);
                localCheckBox.setButtonTintList(ColorStateList.valueOf(getColor(this, 2131558446)));
                localLinearLayout.addView(localCheckBox);
            }
            i += 1;
        }
        new MaterialShowcaseView.Builder(this).setTarget(new View(this)).setDismissText("Okay").setTitleText("Please select the courses that you are currently taking").withRectangleShape().setMaskColour(Color.parseColor("#F1335075")).setContentText("Please check any of the courses that your are currently taking. If you are not currently taking any courses, please leave everything blank.").setDelay(100).show();
        ((Button)findViewById(2131624033)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                paramAnonymousView = (LinearLayout)chooseCurrentClasses.this.findViewById(2131624032);
                chooseCurrentClasses.access$000(chooseCurrentClasses.this, paramAnonymousView);
            }
        });
    }
}