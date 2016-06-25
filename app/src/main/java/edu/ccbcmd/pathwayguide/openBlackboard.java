package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;

public class openBlackboard
        extends AppCompatActivity
{
    public openBlackboard() {}

    openBlackboard(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
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
        finish();
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://ccbcmd-bb.blackboard.com")));
    }
}
