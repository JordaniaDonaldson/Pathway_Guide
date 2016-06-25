package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;

public class cantRegister
        extends AppCompatActivity
{
    public cantRegister() {}

    cantRegister(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
    }

    public void onCreate(Bundle paramBundle)
    {
        Object localObject = $change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
            return;
        }
        super.onCreate(paramBundle);
        setContentView(2130968603);
        getSupportActionBar().show();
        getSupportActionBar().setTitle("What's the issue?");
        paramBundle = getResources();
        paramBundle = new BitmapDrawable(paramBundle, BitmapFactory.decodeResource(paramBundle, 2130837594));
        getSupportActionBar().setBackgroundDrawable(paramBundle);
        getSupportActionBar().setHomeButtonEnabled(true);
        paramBundle = (Button)findViewById(2131624028);
        localObject = (Button)findViewById(2131624027);
        Button localButton = (Button)findViewById(2131624026);
        paramBundle.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                cantRegister.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/financialaid")));
            }
        });
        ((Button)localObject).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                cantRegister.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/Resources-for-Students/Childcare-Services.aspx")));
            }
        });
        localButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                cantRegister.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/resources-for-students")));
            }
        });
    }
}
