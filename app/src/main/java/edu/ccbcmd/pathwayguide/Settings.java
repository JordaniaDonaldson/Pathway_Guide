package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */


import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;

public class Settings
        extends AppCompatActivity
{
    public SharedPreferences prefs;

    public Settings() {}

    Settings(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
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
        setContentView(R.layout.activity_settings); //2130968621
        getSupportActionBar().show();
        getSupportActionBar().setTitle("Menu");
        paramBundle = getResources();
        paramBundle = new BitmapDrawable(paramBundle, BitmapFactory.decodeResource(paramBundle, R.drawable.header)); //2130837594
        getSupportActionBar().setBackgroundDrawable(paramBundle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ((TextView)findViewById(R.id.settings)).setVisibility(4); //2131624052
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        int i = this.prefs.getInt("pathwayID", 0);
        int j = this.prefs.getInt("pathwaysubID", 0);
        paramBundle = choosePathway.sub_pathwayName[Integer.valueOf(i).intValue()][Integer.valueOf(j).intValue()];
        paramBundle = new ArrayAdapter(this, R.layout.activity_settings, R.id.settings, new String[] { "Internet Setting", "Helpful Links", "Register For Courses", "Change Pathways", "Erase all progress", "Walkthrough", "Demo Blackboard Notification", "Demo Register Reminder" }); /* 2130968621, 2131624052*/
        localObject = (ListView)findViewById(R.id.settingslist); //2131624050
        ((ListView)localObject).setAdapter(paramBundle);
        ((ListView)localObject).setClickable(true);
        ((ListView)localObject).setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
                Object localObject = $change;
                if (localObject != null) {
                    ((IncrementalChange)localObject).access$dispatch("onItemClick.(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", new Object[] { this, paramAnonymousAdapterView, paramAnonymousView, new Integer(paramAnonymousInt), new Long(paramAnonymousLong) });
                }
                do
                {
                    do
                    {
                        return;
                        switch (paramAnonymousInt)
                        {
                            default:
                                return;
                            case 0:
                                Settings.this.startActivity(new Intent(Settings.this, internet_setting.class));
                                return;
                            case 1:
                                Settings.this.startActivity(new Intent(Settings.this, links.class));
                                return;
                            case 2:
                                Settings.this.startActivity(new Intent(Settings.this, NotificationActivity.class));
                                return;
                            case 3:
                                Settings.this.startActivity(new Intent(Settings.this, choosePathway.class));
                                return;
                            case 4:
                                new AlertDialog.Builder(new ContextThemeWrapper(Settings.this, 2131361978)).setTitle("Confirm Progress Erase").setMessage("This action will reset the app back to the very first time you installed it. Continuing with action will erase all saved information and your current pathway selection. This action cannot be undone. Are you sure you want to reset your progress?").setIcon(17301543).setPositiveButton(17039379, new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                                    {
                                        IncrementalChange localIncrementalChange = $change;
                                        if (localIncrementalChange != null)
                                        {
                                            localIncrementalChange.access$dispatch("onClick.(Landroid/content/DialogInterface;I)V", new Object[] { this, paramAnonymous2DialogInterface, new Integer(paramAnonymous2Int) });
                                            return;
                                        }
                                        paramAnonymous2DialogInterface = Settings.this.prefs.edit();
                                        paramAnonymous2DialogInterface.clear();
                                        paramAnonymous2DialogInterface.commit();
                                        Settings.this.startActivity(new Intent(Settings.this, choosePathway.class));
                                    }
                                }).setNegativeButton(17039369, null).show();
                                return;
                            case 5:
                                Settings.this.prefs.edit().putInt("demo", 1).commit();
                                Settings.this.startActivity(new Intent(Settings.this, demo_MainActivity.class));
                                return;
                            case 6:
                                paramAnonymousAdapterView = Settings.this;
                                paramAnonymousView = new Intent(Settings.this, openBlackboard.class);
                                localObject = TaskStackBuilder.create(paramAnonymousAdapterView);
                                ((TaskStackBuilder)localObject).addNextIntent(paramAnonymousView);
                                paramAnonymousView = ((TaskStackBuilder)localObject).getPendingIntent(0, 134217728);
                                localObject = new Notification.Builder(paramAnonymousAdapterView);
                                ((Notification.Builder)localObject).setVibrate(new long[] { 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L });
                                ((Notification.Builder)localObject).setLights(65280, 3000, 3000);
                                ((Notification.Builder)localObject).setAutoCancel(true);
                                ((Notification.Builder)localObject).setStyle(new Notification.BigTextStyle().bigText("Remember to check blackboard for newly posted information and events."));
                                paramAnonymousView = ((Notification.Builder)localObject).setContentTitle("Check Blackboard").setContentText("Remember to check blackboard for newly posted information and events.").setTicker("Remember to check blackboard for newly posted information and events.").setSmallIcon(R.drawable.appicon).setContentIntent(paramAnonymousView).setAutoCancel(true).build(); //2130837579
                                ((NotificationManager)paramAnonymousAdapterView.getSystemService("notification")).notify(0, paramAnonymousView);
                                paramAnonymousAdapterView = Integer.valueOf(Settings.this.prefs.getInt("zoom", 0));
                                if (paramAnonymousAdapterView.intValue() == 0)
                                {
                                    Settings.this.startActivity(new Intent(Settings.this, MainActivity.class));
                                    return;
                                }
                                break;
                        }
                    } while (paramAnonymousAdapterView.intValue() != 1);
                    Settings.this.startActivity(new Intent(Settings.this, MainActivityZoomOut.class));
                    return;
                    paramAnonymousAdapterView = Settings.this;
                    paramAnonymousView = new Intent(paramAnonymousAdapterView, NotificationActivity.class);
                    localObject = TaskStackBuilder.create(paramAnonymousAdapterView);
                    ((TaskStackBuilder)localObject).addParentStack(NotificationActivity.class);
                    ((TaskStackBuilder)localObject).addNextIntent(paramAnonymousView);
                    paramAnonymousView = ((TaskStackBuilder)localObject).getPendingIntent(0, 134217728);
                    localObject = new Notification.Builder(paramAnonymousAdapterView);
                    ((Notification.Builder)localObject).setVibrate(new long[] { 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L });
                    ((Notification.Builder)localObject).setLights(65280, 3000, 3000);
                    ((Notification.Builder)localObject).setAutoCancel(true);
                    ((Notification.Builder)localObject).setStyle(new Notification.BigTextStyle().bigText("It is finally time for you to register for your next semester classes. Update your progress and figure out what to take next semster!"));
                    paramAnonymousView = ((Notification.Builder)localObject).setContentTitle("Register for classes").setContentText("It's time for you to register!").setTicker("It's time to register for classes!").setSmallIcon(R.drawable.appicon).setContentIntent(paramAnonymousView).setAutoCancel(true).build();
                    ((NotificationManager)paramAnonymousAdapterView.getSystemService("notification")).notify(0, paramAnonymousView);
                    paramAnonymousAdapterView = Integer.valueOf(Settings.this.prefs.getInt("zoom", 0));
                    if (paramAnonymousAdapterView.intValue() == 0)
                    {
                        Settings.this.startActivity(new Intent(Settings.this, MainActivity.class));
                        return;
                    }
                } while (paramAnonymousAdapterView.intValue() != 1);
                Settings.this.startActivity(new Intent(Settings.this, MainActivityZoomOut.class));
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        boolean bool = true;
        IncrementalChange localIncrementalChange = $change;
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
