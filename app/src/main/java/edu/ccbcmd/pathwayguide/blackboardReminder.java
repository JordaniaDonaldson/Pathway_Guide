package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;

public class blackboardReminder
        extends AppCompatActivity
{
    public blackboardReminder() {}

    blackboardReminder(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
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
        setContentView(2130968602);
        paramBundle = (Button)findViewById(2131624021);
        ((Button)findViewById(2131624022)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                blackboardReminder.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://ccbcmd-bb.blackboard.com/")));
            }
        });
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
                blackboardReminder.this.startActivity(new Intent(blackboardReminder.this, MainActivity.class));
            }
        });
    }
}
