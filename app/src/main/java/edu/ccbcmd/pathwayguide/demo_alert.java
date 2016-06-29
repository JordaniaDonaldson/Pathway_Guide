package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */


import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import fd.IncrementalChange;
import fd.InstantReloadException;

public class demo_alert
        extends Activity
{
    public demo_alert() {}

    demo_alert(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}

    public void onBackPressed()
    {
        Object localObject = IncrementalChange.$change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onBackPressed.()V", this);
            return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("edittextvalue", "value_here");
        setResult(-1, (Intent)localObject);
        finish();
    }

    public void onCreate(Bundle paramBundle)
    {
        Object localObject = IncrementalChange.$change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onCreate.(Landroid/os/Bundle;)V", this, paramBundle);
            return;
        }
        super.onCreate(paramBundle);
        setContentView(2130968608);
        paramBundle = (Button)findViewById(2131624021);
        localObject = findViewById(2131624022);
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
                paramAnonymousView = Toast.makeText(demo_alert.this, "For this walkthrough, please select 'I Passed'", 0);
                paramAnonymousView.setGravity(17, 0, 0);
                paramAnonymousView.show();
            }
        });
        ((Button)localObject).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = IncrementalChange.$change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", this, paramAnonymousView);
                    return;
                }
                demo_alert.this.startActivity(new Intent(demo_alert.this, demo_mainActivity_2.class));
            }
        });
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null) {
            return ((Boolean)localIncrementalChange.access$dispatch("onKeyDown.(ILandroid/view/KeyEvent;)Z", this, new Integer(paramInt), paramKeyEvent)).booleanValue();
        }
        if ((Integer.parseInt(Build.VERSION.SDK) > 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
        {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }
}

