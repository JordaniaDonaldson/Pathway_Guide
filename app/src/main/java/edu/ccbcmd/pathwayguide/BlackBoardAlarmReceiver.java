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

public class BlackBoardAlarmReceiver
        extends BroadcastReceiver
{
    public BlackBoardAlarmReceiver() {}

    BlackBoardAlarmReceiver(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}

    public void onReceive(Context paramContext, Intent paramIntent)
    {
        Object localObject = IncrementalChange.$change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onReceive.(Landroid/content/Context;Landroid/content/Intent;)V", new Object[] { this, paramContext, paramIntent });
            return;
        }
        paramIntent = new Intent(paramContext, openBlackboard.class);
        localObject = TaskStackBuilder.create(paramContext);
        ((TaskStackBuilder)localObject).addNextIntent(paramIntent);
        paramIntent = ((TaskStackBuilder)localObject).getPendingIntent(0, 134217728);
        localObject = new Notification.Builder(paramContext);
        ((Notification.Builder)localObject).setVibrate(new long[] { 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L });
        ((Notification.Builder)localObject).setLights(65280, 3000, 3000);
        ((Notification.Builder)localObject).setAutoCancel(true);
        ((Notification.Builder)localObject).setStyle(new Notification.BigTextStyle().bigText("Remember to check blackboard for newly posted information and events."));
        paramIntent = ((Notification.Builder)localObject).setContentTitle("Check Blackboard").setContentText("Remember to check blackboard for newly posted information and events.").setTicker("Remember to check blackboard for newly posted information and events.").setSmallIcon(2130837579).setContentIntent(paramIntent).setAutoCancel(true).build();
        ((NotificationManager)paramContext.getSystemService("notification")).notify(0, paramIntent);
    }
}
