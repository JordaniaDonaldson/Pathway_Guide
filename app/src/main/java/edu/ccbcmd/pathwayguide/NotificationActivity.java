package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import fd.IncrementalChange;
import fd.InstantReloadException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class NotificationActivity
        extends AppCompatActivity
{
    public SharedPreferences prefs;

    public NotificationActivity() {}

    NotificationActivity(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
    }

    public void onCreate(Bundle paramBundle)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
            return;
        }
        super.onCreate(paramBundle);
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        setContentView(R.layout.activity_notification); //2130968619
        getSupportActionBar().show();
        getSupportActionBar().setTitle("It's time to register!");
        paramBundle = getResources();
        getSupportActionBar().setHomeButtonEnabled(true);
        paramBundle = new BitmapDrawable(paramBundle, BitmapFactory.decodeResource(paramBundle, R.drawable.header));
        getSupportActionBar().setBackgroundDrawable(paramBundle);
        ((Button)findViewById(R.id.button7)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            { //2131624057
                IncrementalChange localIncrementalChange = IncrementalChange.$change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                NotificationActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://ccbcmd-bb.blackboard.com")));
            }
        });
        ((Button)findViewById(R.id.cant)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            { //2131624055
                IncrementalChange localIncrementalChange = IncrementalChange.$change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                NotificationActivity.this.startActivity(new Intent(NotificationActivity.this, cantRegister.class));
            }
        });
        ((Button)findViewById(R.id.this1)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            { //2131624056
                Object localObject = IncrementalChange.$change;
                if (localObject != null)
                {
                    ((IncrementalChange)localObject).access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                paramAnonymousView = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
                paramAnonymousView.set(1, Calendar.getInstance().get(1));
                paramAnonymousView.set(2, Calendar.getInstance().get(2));
                paramAnonymousView.set(5, Calendar.getInstance().get(5));
                paramAnonymousView.add(5, 1);
                int i = paramAnonymousView.get(2);
                int j = paramAnonymousView.get(1);
                int k = paramAnonymousView.get(5);
                Log.w("Notify Cal", i + "/" + k + "/" + j);
                paramAnonymousView = (AlarmManager)NotificationActivity.this.getSystemService("alarm");
                localObject = new Intent("android.media.action.DISPLAY_NOTIFICATION");
                ((Intent)localObject).addCategory("android.intent.category.DEFAULT");
                localObject = PendingIntent.getBroadcast(NotificationActivity.this, 100, (Intent)localObject, 134217728);
                Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
                localCalendar.set(5, k);
                localCalendar.set(2, i);
                localCalendar.set(1, j);
                localCalendar.set(11, 10);
                localCalendar.set(12, 0);
                localCalendar.set(13, 0);
                if (Build.VERSION.SDK_INT >= 19) {
                    paramAnonymousView.setExact(0, localCalendar.getTimeInMillis(), (PendingIntent)localObject);
                }
                for (;;)
                {
                    NotificationActivity.this.startActivity(new Intent(NotificationActivity.this, MainActivity.class));
                    return;
                    paramAnonymousView.set(0, localCalendar.getTimeInMillis(), (PendingIntent)localObject);
                }
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        boolean bool = true;
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null) {
            bool = ((Boolean)localIncrementalChange.access$dispatch("onOptionsItemSelected.(Landroid/view/MenuItem;)Z", new Object[] { this, paramMenuItem })).booleanValue();
        }
        do
        {
            return bool;
            switch (paramMenuItem.getItemId())
            {
                default:
                    return super.onOptionsItemSelected(paramMenuItem);
            }
            paramMenuItem = Integer.valueOf(this.prefs.getInt("zoom", 0));
            if (paramMenuItem.intValue() == 0)
            {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            }
        } while (paramMenuItem.intValue() != 1);
        startActivity(new Intent(this, MainActivityZoomOut.class));
        return true;
    }
}
