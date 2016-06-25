package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;

public class ShowNotification
        extends Service
{
    private static final String TAG = "ShowNotification";

    public ShowNotification() {}

    ShowNotification(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}

    public IBinder onBind(Intent paramIntent)
    {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null) {
            return (IBinder)localIncrementalChange.access$dispatch("onBind.(Landroid/content/Intent;)Landroid/os/IBinder;", new Object[] { this, paramIntent });
        }
        return null;
    }

    public void onCreate()
    {
        Object localObject = $change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onCreate.()V", new Object[] { this });
            return;
        }
        super.onCreate();
        localObject = new Intent(this, MainActivity.class);
        ((NotificationManager)getSystemService("notification")).notify(0, new NotificationCompat.Builder(this).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, 0, (Intent)localObject, 134217728)).setContentTitle("HELLO " + System.currentTimeMillis()).setContentText("PLEASE CHECK WE HAVE UPDATED NEWS").setDefaults(-1).setTicker("ticker message").setWhen(System.currentTimeMillis()).build());
        Log.i("ShowNotification", "Notification created");
    }
}
