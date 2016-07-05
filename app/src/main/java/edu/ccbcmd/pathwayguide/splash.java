package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class splash extends AppCompatActivity
{



    public void onCreate(final Bundle bundle) {

        super.onCreate(bundle);
        this.setContentView(R.layout.activity_splash); //2130968622

        final AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(this.getResources().getDrawable(R.drawable.health), 2000); //2130837595
        animationDrawable.addFrame(this.getResources().getDrawable(R.drawable.tech), 1500); //2130837602
        animationDrawable.addFrame(this.getResources().getDrawable(R.drawable.business), 1500); //2130837583
        animationDrawable.addFrame(this.getResources().getDrawable(R.drawable.social), 1500); //2130837600
        animationDrawable.addFrame(this.getResources().getDrawable(R.drawable.arts), 1500); //2130837580
        animationDrawable.addFrame(this.getResources().getDrawable(R.drawable.splash), 2000); //2130837601
        animationDrawable.setOneShot(true);
        final ImageView imageView = (ImageView)this.findViewById(R.id.imageView); //2131624058
        if (Build.VERSION.SDK_INT < 16) {
            imageView.setImageDrawable(animationDrawable);
        }
        else {
            imageView.setImageDrawable(animationDrawable);
        }
        animationDrawable.start();

        // set-up the database
        Thread th = new Thread() {
            public void run() {
                DatabaseWrapper.db = new PathwaysDBHelper(splash.this).getWritableDatabase();
            }
        };
        th.start();

        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {

                final SharedPreferences sharedPreferences = splash.this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
                Log.w("First Run:", String.valueOf(sharedPreferences.getBoolean("firstrun", true)));
                if (sharedPreferences.getBoolean("firstrun", true)) {
                    splash.this.startActivity(new Intent(splash.this, (Class)demo_MainActivity.class));
                }
                else {
                    final Intent intent = new Intent(splash.this, (Class)MainActivity.class);
                    intent.putExtra("intVariableName", 0);
                    splash.this.startActivity(intent);
                }
                splash.this.finish();
            }
        }, 10500L);
    }
}
