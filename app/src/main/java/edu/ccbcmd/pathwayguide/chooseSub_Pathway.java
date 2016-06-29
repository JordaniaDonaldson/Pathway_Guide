package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import fd.IncrementalChange;
import fd.InstantReloadException;

public class chooseSub_Pathway
        extends AppCompatActivity
        implements View.OnClickListener
{
    public SharedPreferences prefs;

    public chooseSub_Pathway() {}

    chooseSub_Pathway(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
    }

    public void onClick(View paramView)
    {
        Object localObject = IncrementalChange.$change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramView });
            return;
        }
        for (;;)
        {
            try
            {
                this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
                int i = this.prefs.getInt("pathwayID", -1);
                i = choosePathway.subpathwayCoursePath[Integer.valueOf(i).intValue()][paramView.getId()].length;
                this.prefs.edit().putInt("pathwaysubID", paramView.getId()).commit();
                if (this.prefs.getBoolean("firstrun", true) == true)
                {
                    localObject = new Intent(this, chooseCompletedClasses.class);
                    ((Intent)localObject).putExtra("arrayID", String.valueOf(paramView.getId() - 1));
                    startActivity((Intent)localObject);
                    return;
                }
            }
            catch (ArrayIndexOutOfBoundsException paramView)
            {
                this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
                this.prefs.getInt("pathwayID", -1);
                Toast.makeText(this, "The Sub-Pathway you selected is not currently available in this app. Please visit ccbcmd.edu/pathways to view more info on this pathway.", 1).show();
                return;
            }
            localObject = new Intent(this, MainActivity.class);
        }
    }

    public void onCreate(Bundle paramBundle)
    {
        Object localObject = IncrementalChange.$change;
        if (localObject != null) {
            ((IncrementalChange)localObject).access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
        }
        for (;;)
        {
            return;
            super.onCreate(paramBundle);
            setContentView(2130968607);
            getSupportActionBar().show();
            getSupportActionBar().setTitle("Choose Your Pathway");
            getSupportActionBar().setHomeButtonEnabled(true);
            paramBundle = getResources();
            paramBundle = new BitmapDrawable(paramBundle, BitmapFactory.decodeResource(paramBundle, 2130837594));
            getSupportActionBar().setBackgroundDrawable(paramBundle);
            this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
            paramBundle = Integer.valueOf(this.prefs.getInt("pathwayID", -1));
            localObject = (LinearLayout)findViewById(2131624035);
            int j = choosePathway.sub_pathwayName[paramBundle.intValue()].length;
            int i = 0;
            while (i < j)
            {
                Button localButton = new Button(this);
                localButton.setOnClickListener(this);
                localButton.setText(choosePathway.sub_pathwayName[paramBundle.intValue()][i]);
                LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
                localLayoutParams.setMargins(5, 5, 5, 5);
                localButton.setLayoutParams(localLayoutParams);
                localButton.setTag(Integer.valueOf(i));
                localButton.setWidth(Math.round(TypedValue.applyDimension(1, 220.0F, getResources().getDisplayMetrics())));
                localButton.setId(i);
                ((LinearLayout)localObject).addView(localButton);
                localLayoutParams = (LinearLayout.LayoutParams)localButton.getLayoutParams();
                localLayoutParams.gravity = 17;
                localButton.setLayoutParams(localLayoutParams);
                i += 1;
            }
        }
    }
}