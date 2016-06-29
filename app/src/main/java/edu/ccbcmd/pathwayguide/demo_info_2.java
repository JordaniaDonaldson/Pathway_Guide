package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import fd.IncrementalChange;
import fd.InstantReloadException;
import showcaseview.ShowcaseView;
import materialshowcaseview.MaterialShowcaseView;

public class demo_info_2
        extends AppCompatActivity
        implements View.OnClickListener
{
    private int counter;
    public SharedPreferences prefs;
    private ShowcaseView showcaseView;

    public demo_info_2() {}

    demo_info_2(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
    }

    public static int pxToDp(int paramInt)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null) {
            return ((Number)localIncrementalChange.access$dispatch("pxToDp.(I)I", new Integer(paramInt))).intValue();
        }
        return (int)(paramInt * Resources.getSystem().getDisplayMetrics().density);
    }

    public int[] loadArrayInt(String paramString)
    {
        Object localObject = IncrementalChange.$change;
        if (localObject != null) {
            return (int[])((IncrementalChange)localObject).access$dispatch("loadArrayInt.(Ljava/lang/String;)[I", this, paramString);
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

    public void onClick(View paramView)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", this, paramView);
            return;
        }
        new MaterialShowcaseView.Builder(this).setTarget(findViewById(2131624038)).setDismissText("Okay").setTitleText("Click Here").withRectangleShape().setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).setContentText("Click on 'I'm currently taking this class' to update the course status to indicate that your are currently taking the class.").setDelay(100).show();
    }

    public void onCreate(Bundle paramBundle)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onCreate.(Landroid/os/Bundle;)V", this, paramBundle);
            return;
        }
        super.onCreate(paramBundle);
        setContentView(2130968609);
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        this.prefs.getInt("pathwayID", -1);
        this.prefs.getInt("pathwaysubID", -1);
        Integer.parseInt(this.prefs.getString("choosenID", "0"));
        ((TextView)findViewById(2131624036)).setText("Transitioning to College");
        ((TextView)findViewById(2131624042)).setText("Credits: 1\nRecommended Semester: 1st*\n\n*This course may not be required for transfer students. Ask your adviser for more information.");
        getSupportActionBar().setTitle("ACDV 101");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcd054")));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        findViewById(2131624037).setOnClickListener(this);
        findViewById(2131624041).setOnClickListener(this);
        paramBundle = (Button)findViewById(2131624038);
        paramBundle.setText("I'm currently taking this class");
        paramBundle.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = IncrementalChange.$change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", this, paramAnonymousView);
                    return;
                }
                demo_info_2.this.startActivity(new Intent(demo_info_2.this, demo_mainActivity_3.class));
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null) {
            return ((Boolean)localIncrementalChange.access$dispatch("onOptionsItemSelected.(Landroid/view/MenuItem;)Z", this, paramMenuItem)).booleanValue();
        }
        switch (paramMenuItem.getItemId())
        {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        finish();
        return true;
    }
}


