package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */

        import android.app.Notification;
        import android.app.PendingIntent;
        import android.app.NotificationManager;

        import android.support.v4.app.TaskStackBuilder;
        import android.content.Intent;
        import android.content.Context;

        import android.content.BroadcastReceiver;

public class BlackBoardAlarmReceiver extends BroadcastReceiver
{

/*
    public BlackBoardAlarmReceiver() {
        final IncrementalChange .change = BlackBoardAlarmReceiver..change;
        if (.change != null) {
            final Object[] array = { null };
            array[0] = array;
            this((Object[]).change.access.dispatch("init.args.([Ljava/lang/Object;)Ljava/lang/Object;", array), null);
        }
        else {}
        if (.change != null) {
            .change.access.dispatch("init.body.(Lcom/example/nicholas/buttontest/BlackBoardAlarmReceiver;)V", new Object[] { this });
        }
    }

    BlackBoardAlarmReceiver(final Object[] array, final InstantReloadException ex) {
        final String s = (String)array[0];
        switch (s.hashCode()) {
            default: {
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", s, s.hashCode(), "com/example/nicholas/buttontest/BlackBoardAlarmReceiver"));
            }
            case 177143362: {
                this();
            }
            case 1550206337: {}
        }
    }
*/
    public void onReceive(final Context context, Intent intent) {

        intent = new Intent(context, (Class)openBlackboard.class);
        final TaskStackBuilder create = TaskStackBuilder.create(context);
        create.addNextIntent(intent);
        final PendingIntent pendingIntent = create.getPendingIntent(0, 134217728);
        final Notification.Builder notificationBuilder = new Notification.Builder(context);
        notificationBuilder.setVibrate(new long[] { 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L, 1000L });
        notificationBuilder.setLights(256, 3000, 3000); //color changed from -256
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setStyle(new Notification.BigTextStyle().bigText("Remember to check blackboard for newly posted information and events."));
        ((NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE)).notify(0, notificationBuilder.setContentTitle("Check Blackboard").setContentText("Remember to check blackboard for newly posted information and events.").setTicker("Remember to check blackboard for newly posted information and events.").setSmallIcon(R.drawable.appicon).setContentIntent(pendingIntent).setAutoCancel(true).build()); //"notification", 2130837579
    }
}
