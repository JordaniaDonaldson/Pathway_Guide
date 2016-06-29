package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import fd.IncrementalChange;
import fd.InstantReloadException;

public class welcome
        extends AppCompatActivity
{
    public SharedPreferences prefs;

    public welcome() {}

    welcome(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
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
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().show();
        getSupportActionBar().setTitle("Welcome");
        Resources _paramBundle = getResources();
        BitmapDrawable __paramBundle = new BitmapDrawable(_paramBundle, BitmapFactory.decodeResource(_paramBundle, 2130837594));
        getSupportActionBar().setBackgroundDrawable(__paramBundle);
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        Button ___paramBundle = (Button)findViewById(R.id.button4);
        Button _localObject = (Button) findViewById(R.id.button5);
        Button _localButton = (Button) findViewById(R.id.button6);
        ___paramBundle.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = IncrementalChange.$change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", this, paramAnonymousView);
                    return;
                }
                welcome.this.startActivity(new Intent(welcome.this, choosePathway.class));
            }
        });
        ((Button) _localObject).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = IncrementalChange.$change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", this, paramAnonymousView);
                    return;
                }
                welcome.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/Resources-for-Students/Academic-Advisement.aspx")));
            }
        });
        _localButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = IncrementalChange.$change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", this, paramAnonymousView);
                    return;
                }
                welcome.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/pathways")));
            }
        });
    }
}