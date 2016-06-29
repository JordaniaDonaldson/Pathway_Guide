package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */

import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import fd.IncrementalChange;
import fd.InstantReloadException;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver() {}

    AlarmReceiver(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}

    public void onReceive(Context paramContext, Intent paramIntent)
    {
        TaskStackBuilder localObject = TaskStackBuilder.create(paramContext);
        ;
        paramIntent = new Intent(paramContext, NotificationActivity.class);
        localObject = TaskStackBuilder.create(paramContext);
        ((TaskStackBuilder)localObject).addParentStack(NotificationActivity.class);
        ((TaskStackBuilder)localObject).addNextIntent(paramIntent);
        paramIntent = localObject.getPendingIntent(0, 134217728);
        Notification.Builder _localObject = new Notification.Builder(paramContext);
        ((Notification.Builder)_localObject).setVibrate(new long[] { 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L });
        ((Notification.Builder)_localObject).setLights(65280, 3000, 3000);
        ((Notification.Builder)_localObject).setAutoCancel(true);
        ((Notification.Builder)_localObject).setStyle(new Notification.BigTextStyle().bigText("It is finally time for you to register for your next semester classes. Update your progress and figure out what to take next semster!"));
        paramIntent = ((Notification.Builder)_localObject).setContentTitle("Register for classes").setContentText("It's time for you to register!").setTicker("It's time to register for classes!").setSmallIcon(2130837579).setContentIntent(paramIntent).setAutoCancel(true).build();
        ((NotificationManager)paramContext.getSystemService(Context.NOTIFICATION_SERVICE)).notify(0, paramIntent);
    }
}
