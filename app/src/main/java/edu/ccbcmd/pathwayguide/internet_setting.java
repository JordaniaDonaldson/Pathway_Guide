package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */


import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import fd.IncrementalChange;
import fd.InstantReloadException;

public class internet_setting
        extends AppCompatActivity
{
    public SharedPreferences prefs;

    public internet_setting() {}

    internet_setting(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
    }

    public void onCreate(Bundle paramBundle)
    {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
            return;
        }
        super.onCreate(paramBundle);
        setContentView(2130968614);
        getSupportActionBar().show();
        getSupportActionBar().setTitle("Internet Setting");
        paramBundle = getResources();
        paramBundle = new BitmapDrawable(paramBundle, BitmapFactory.decodeResource(paramBundle, 2130837594));
        getSupportActionBar().setBackgroundDrawable(paramBundle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        paramBundle = (Switch)findViewById(2131624048);
        if (Integer.valueOf(this.prefs.getInt("internet", 1)).intValue() == 1) {
            paramBundle.setChecked(true);
        }
        for (;;)
        {
            paramBundle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
            {
                public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onCheckedChanged.(Landroid/widget/CompoundButton;Z)V", new Object[] { this, paramAnonymousCompoundButton, new Boolean(paramAnonymousBoolean) });
                        return;
                    }
                    if (paramAnonymousBoolean)
                    {
                        internet_setting.this.prefs.edit().putInt("internet", 1).commit();
                        internet_setting.this.prefs.getInt("internet", 1);
                        return;
                    }
                    internet_setting.this.prefs.edit().putInt("internet", 0).commit();
                    internet_setting.this.prefs.getInt("internet", 1);
                }
            });
            return;
            paramBundle.setChecked(false);
        }
    }
}
