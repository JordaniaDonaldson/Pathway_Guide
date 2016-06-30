package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */




import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Settings extends AppCompatActivity
{

    public SharedPreferences prefs;


    public void onCreate(final Bundle bundle) {

        super.onCreate(bundle);
        this.setContentView(R.layout.activity_settings); //2130968621
        this.getSupportActionBar().show();
        this.getSupportActionBar().setTitle("Menu");
        final Resources resources = this.getResources();
        this.getSupportActionBar().setBackgroundDrawable(new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, 2130837594))); // TODO: 6/29/2016 Does this actually call the header? everywhere else I've replaced it with R.id.etc
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        this.findViewById(R.id.settings).setVisibility(View.INVISIBLE); //2131624052, 4
        this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
        final String s = choosePathway.sub_pathwayName[this.prefs.getInt("pathwayID", 0)][this.prefs.getInt("pathwaysubID", 0)];
        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_settings, R.id.settings, new String[] { "Internet Setting", "Helpful Links", "Register For Courses", "Change Pathways", "Erase all progress", "Walkthrough", "Demo Blackboard Notification", "Demo Register Reminder" }); //2130968621, 2131624052
        final ListView listView = (ListView)this.findViewById(R.id.settingslist); //2131624050
        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {


                    switch (n) {
                        default: {}
                        case 0: {
                            Settings.this.startActivity(new Intent(Settings.this, (Class)internet_setting.class));
                            break;
                        }
                        case 1: {
                            Settings.this.startActivity(new Intent(Settings.this, (Class)links.class));
                            break;
                        }
                        case 2: {
                            Settings.this.startActivity(new Intent(Settings.this, (Class)NotificationActivity.class));
                            break;
                        }
                        case 3: {
                            Settings.this.startActivity(new Intent(Settings.this, (Class)choosePathway.class));
                            break;
                        }
                        case 4: {
                            new AlertDialog.Builder(new ContextThemeWrapper(Settings.this, R.style.SplashTheme)).setTitle("Confirm Progress Erase").setMessage("This action will reset the app back to the very first time you installed it. Continuing with action will erase all saved information and your current pathway selection. This action cannot be undone. Are you sure you want to reset your progress?").setIcon(17301543).setPositiveButton(17039379, new DialogInterface.OnClickListener() { //2131361978,


                                public void onClick(final DialogInterface dialogInterface, final int n) {

                                    final SharedPreferences.Editor edit = Settings.this.prefs.edit();
                                    edit.clear();
                                    edit.commit();
                                    Settings.this.startActivity(new Intent(Settings.this, (Class)choosePathway.class));
                                }
                            }).setNegativeButton(17039369, null).show();
                            break;
                        }
                        case 5: {
                            Settings.this.prefs.edit().putInt("demo", 1).commit();
                            Settings.this.startActivity(new Intent(Settings.this, (Class)demo_MainActivity.class));
                            break;
                        }
                        case 6: {
                            final Settings this$0 = Settings.this; // FIXME: 6/29/2016 decompilation artifact?
                            final Intent intent = new Intent(Settings.this, (Class)openBlackboard.class);
                            final android.support.v4.app.TaskStackBuilder create = android.support.v4.app.TaskStackBuilder.create(this$0);
                            create.addNextIntent(intent);
                            final PendingIntent pendingIntent = create.getPendingIntent(0, 134217728);
                            final Notification.Builder notificationBuilder = new Notification.Builder(this$0);
                            notificationBuilder.setVibrate(new long[] { 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L });
                            notificationBuilder.setLights(256, 3000, 3000); //Color was -256
                            notificationBuilder.setAutoCancel(true);
                            notificationBuilder.setStyle(new Notification.BigTextStyle().bigText("Remember to check blackboard for newly posted information and events."));
                            ((NotificationManager)(this$0).getSystemService(NOTIFICATION_SERVICE)).notify(0, notificationBuilder.setContentTitle("Check Blackboard").setContentText("Remember to check blackboard for newly posted information and events.").setTicker("Remember to check blackboard for newly posted information and events.").setSmallIcon(R.drawable.appicon).setContentIntent(pendingIntent).setAutoCancel(true).build()); //"notification", 2130837579
                            final Integer value = Settings.this.prefs.getInt("zoom", 0);
                            if (value == 0) {
                                Settings.this.startActivity(new Intent(Settings.this, (Class)MainActivity.class));
                                return;
                            }
                            if (value == 1) {
                                Settings.this.startActivity(new Intent(Settings.this, (Class)MainActivityZoomOut.class));
                                return;
                            }
                            break;
                        }
                        case 7: {
                            final Settings this$2 = Settings.this;
                            final Intent intent2 = new Intent(this$2, (Class)NotificationActivity.class);
                            final android.support.v4.app.TaskStackBuilder create2 = android.support.v4.app.TaskStackBuilder.create(this$2);
                            create2.addParentStack((Class)NotificationActivity.class);
                            create2.addNextIntent(intent2);
                            final PendingIntent pendingIntent2 = create2.getPendingIntent(0, 134217728);
                            final Notification.Builder notificationBuilder2 = new Notification.Builder(this$2);
                            notificationBuilder2.setVibrate(new long[] { 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L });
                            notificationBuilder2.setLights(256, 3000, 3000); //Color was -256
                            notificationBuilder2.setAutoCancel(true);
                            notificationBuilder2.setStyle(new Notification.BigTextStyle().bigText("It is finally time for you to register for your next semester classes. Update your progress and figure out what to take next semster!"));
                            ((NotificationManager)(this$2).getSystemService(NOTIFICATION_SERVICE)).notify(0, notificationBuilder2.setContentTitle("Register for classes").setContentText("It's time for you to register!").setTicker("It's time to register for classes!").setSmallIcon(R.drawable.appicon).setContentIntent(pendingIntent2).setAutoCancel(true).build()); //"notification", 2130837579
                            final Integer value2 = Settings.this.prefs.getInt("zoom", 0);
                            if (value2 == 0) {
                                Settings.this.startActivity(new Intent(Settings.this, (Class)MainActivity.class));
                                return;
                            }
                            if (value2 == 1) {
                                Settings.this.startActivity(new Intent(Settings.this, (Class)MainActivityZoomOut.class));
                                return;
                            }
                            break;
                        }
                    }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        boolean booleanValue = true;


        Log.e("Hey",menuItem.getItemId() +"");
            switch (menuItem.getItemId()) {

                /*case 16908333: {
                    final Integer value = this.prefs.getInt("zoom", 0);
                    if (value == 0) {
                        this.startActivity(new Intent(this, (Class)MainActivity.class));
                        return true;
                    }
                    if (value == 1) {
                        this.startActivity(new Intent(this, (Class)MainActivityZoomOut.class));
                        return true;
                    }
                    break;
                }*/
                default: {
                    return super.onOptionsItemSelected(menuItem);

                }
            }

        //return booleanValue;
    }
}
