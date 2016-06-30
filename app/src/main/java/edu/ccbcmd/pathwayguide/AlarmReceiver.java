package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



        import android.app.Notification;
        import android.app.PendingIntent;
        import android.app.NotificationManager;
        import android.app.Notification.Style;
        import android.app.Notification.BigTextStyle;
        import android.app.Notification.Builder;
        import android.support.v4.app.TaskStackBuilder;
        import android.content.Intent;
        import android.content.Context;
        import android.os.Bundle;

        import android.content.BroadcastReceiver;

        import fd.IncrementalChange;

public class AlarmReceiver extends BroadcastReceiver
{
  /*

    public AlarmReceiver() {
        final IncrementalChange $change = AlarmReceiver.$change;
        if ($change != null) {
            final Object[] array = { null };
            array[0] = array;
            this((Object[])$change.access$dispatch("init$args.([Ljava/lang/Object;)Ljava/lang/Object;", array), null);
        }
        else {}
        if ($change != null) {
            $change.access$dispatch("init$body.(Lcom/example/nicholas/buttontest/AlarmReceiver;)V", new Object[] { this });
        }
    }

    AlarmReceiver(final Object[] array, final InstantReloadException ex) {
        final String s = (String)array[0];
        switch (s.hashCode()) {
            default: {
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", s, s.hashCode(), "com/example/nicholas/buttontest/AlarmReceiver"));
            }
            case -1885074391: {
                this();
            }
            case 1550206337: {}
        }
    }
*/
    public void onReceive(final Context context, Intent intent) {

        intent = new Intent(context, (Class)NotificationActivity.class);
        final TaskStackBuilder create = TaskStackBuilder.create(context);
        create.addParentStack((Class)NotificationActivity.class);
        create.addNextIntent(intent);
        final PendingIntent pendingIntent = create.getPendingIntent(0, 134217728);
        final Notification.Builder notificationBuilder = new Notification.Builder(context);
        notificationBuilder.setVibrate(new long[] { 100L });
        notificationBuilder.setLights(256, 3000, 3000); //color value -256, but IDE complained
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setStyle(new Notification.BigTextStyle().bigText("It is finally time for you to register for your next semester classes. Update your progress and figure out what to take next semester!"));
        ((NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE)).notify(0, notificationBuilder.setContentTitle("Register for classes").setContentText("It's time for you to register!").setTicker("It's time to register for classes!").setSmallIcon(R.drawable.appicon).setContentIntent(pendingIntent).setAutoCancel(true).build()); // "notification", 2130837579
    }
}
