package edu.ccbcmd.pathwayguide;




/**
 * Created by dixo8 on 6/24/2016.
 */

        import android.os.Build;

        import android.content.res.Resources;

        import java.util.Date;

        import android.view.Gravity;
        import android.widget.ImageButton;
        import android.graphics.Color;
        import android.widget.TextView;
        import android.util.TypedValue;
        import android.widget.ImageView;
        import android.widget.ScrollView;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.app.PendingIntent;
        import android.app.AlarmManager;
        import java.util.Locale;
        import java.util.TimeZone;
        import java.util.Calendar;
        import android.util.Log;

        import android.content.Context;
        import android.view.View;
        import android.content.Intent;
        import android.os.Bundle;
        import android.content.SharedPreferences;
        import android.app.Activity;

public class MainActivityZoomOut extends Activity implements View.OnClickListener
{

    public SharedPreferences prefs;


    public String[][] load2DArray(String s) {

        SharedPreferences sharedPreferences = this.getSharedPreferences("preferencename", 0);
        int int1 = sharedPreferences.getInt(s + "_size", 0);
        String[][] array = new String[int1][];
        for (int i = 0; i < int1; ++i) {
            int int2 = sharedPreferences.getInt(s + "_size_" + i, 0);
            Log.d("I Loop", String.valueOf(i));
            String[] array2 = new String[int2];
            for (int j = 0; j < int2; ++j) {
                Log.d("T Loop", sharedPreferences.getString(s + "_" + i + "_" + j, "hi"));
                array2[j] = sharedPreferences.getString(s + "_" + i + "_" + j, "hi");
            }
            array[i] = array2;
        }
        return array;
    }

    public int[] loadArrayInt(String s) {

        SharedPreferences sharedPreferences = this.getSharedPreferences("preferencename", 0);
        int int1 = sharedPreferences.getInt(s + "_size", 0);
        int[] array = new int[int1];
        for (int i = 0; i < int1; ++i) {
            array[i] = sharedPreferences.getInt(s + "_" + i, 1);
        }
        return array;
    }



    public void onClick(final View view) {

        final Intent intent = new Intent(this, (Class)info.class);
        final String value = String.valueOf(view.getId());
        this.prefs.edit().putString("choosenID", value).commit();
        intent.putExtra("arrayID", value);
        this.startActivity(intent);
    }

    public void onCreate(final Bundle bundle) {

        super.onCreate(bundle);
        this.setContentView(R.layout.activity_main_activity_zoom_out); //2130968617
        this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
        this.prefs.edit().putInt("zoom", 1).commit();
        final Integer value = this.prefs.getInt("pathwayID", 0);
        final Integer value2 = this.prefs.getInt("pathwaysubID", 0);
        final String string = this.prefs.getString("notifydate", "00/00/0000");
        final Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, 0); //11
        instance.set(Calendar.MINUTE, 0); //12
        instance.set(Calendar.SECOND, 1); //13
        instance.set(Calendar.MILLISECOND, 0); //14
        final Date time = instance.getTime();
        instance.getTimeInMillis();
        final String[] split = string.split("/");
        final String s = split[2];
        final String s2 = split[0];
        final String s3 = split[1];
        final int int1 = Integer.parseInt(s);
        final int int2 = Integer.parseInt(s2);
        final int int3 = Integer.parseInt(s3);
        instance.set(Calendar.YEAR, int1); //1
        instance.set(Calendar.MONTH, int2); //2
        instance.set(Calendar.DATE, int3 - 1); //5
        final Date time2 = instance.getTime();
        if (time2.before(time)) {
            final SharedPreferences.Editor edit = this.prefs.edit();
            final Calendar instance2 = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
            instance2.set(Calendar.HOUR_OF_DAY, 0); //11
            instance2.set(Calendar.MINUTE, 0); //12
            instance2.set(Calendar.SECOND, 0); //13
            instance2.set(Calendar.MILLISECOND, 0); //14
            int value3 = Calendar.getInstance().get(Calendar.MONTH); //2
            int value4 = Calendar.getInstance().get(Calendar.YEAR); //1
            Log.w("THIS YEAR", String.valueOf(value3));
            int n2;
            int n3;
            if (value3 < 4) {
                final int n = 4;
                Log.w("THIS Month", "<4: year post is: " + value4);
                n2 = value4;
                n3 = n;
            }
            else if (value3 < 11) {
                final int n4 = 11;
                n2 = value4;
                Log.w("THIS Month", "<10: year post is: " + n2);
                n3 = n4;
            }
            else {
                final int n5 = 4;
                final int n6 = value4 + 1;
                Log.w("THIS YEAR", "TRUE " + n6);
                n3 = n5;
                n2 = n6;
            }
            final AlarmManager alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE); //"alarm"
            final Intent intent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
            intent.addCategory("android.intent.category.DEFAULT");
            PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT); //134217728
            final Calendar instance3 = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
            instance3.set(Calendar.DATE, 1); //5
            instance3.set(Calendar.MONTH, n3); //2
            instance3.set(Calendar.YEAR, n2); //1
            instance3.set(Calendar.HOUR_OF_DAY, 10); //11
            instance3.set(Calendar.MINUTE, 0); //12
            instance3.set(Calendar.SECOND, 0); //13
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, instance3.getTimeInMillis(), broadcast);
            }
            else {
                alarmManager.set(0, instance3.getTimeInMillis(), broadcast);
            }
            edit.putString("notifydate", String.valueOf(n3) + "/01/" + String.valueOf(n2)).commit();
            Log.w("NEW ALERT SET DATE", String.valueOf(n3) + "/01/" + String.valueOf(n2));
            Log.w("Date Calc", "Date specified [" + time2 + "] is before today [" + time + "]");
        }
        else {
            Log.w("Date Calc", "Date specified [" + time2 + "] is NOT before today [" + time + "]");
        }
        if (value2 == -1) {
            this.startActivity(new Intent(this, (Class)choosePathway.class));
        }
        else {
            this.load2DArray("courseName");
            final int[] loadArrayInt = this.loadArrayInt("courseStat");
            Integer.parseInt(this.prefs.getString("choosenID", "0"));
            new RelativeLayout(this);

            /*Refactored linearLayout2, was originally named linearLayout but it calls the same obj
        * as the commented out line a page down. just making note in case of problems*/
            final LinearLayout linearLayout2 = (LinearLayout)this.findViewById(R.id.linearLayout2); //2131624046
            final ScrollView scrollView = (ScrollView)this.findViewById(R.id.scrollView1); //2131624045
            scrollView.post(new Runnable() {

                @Override
                public void run() {

                    scrollView.fullScroll(130);
                }
            });
            final int heightPixels = this.getResources().getDisplayMetrics().heightPixels;
            final ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.grad); //2130837591
            imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            //final LinearLayout linearLayout2 = (LinearLayout)this.findViewById(2131624046);
            final Resources resources = this.getResources();
            imageView.getLayoutParams().height = Math.round(TypedValue.applyDimension(1, 70.0f, resources.getDisplayMetrics()));
            final int round = Math.round(TypedValue.applyDimension(1, 70.0f, resources.getDisplayMetrics()));
            linearLayout2.addView(imageView);
            final int length = choosePathway.subpathwayCoursePath[value][value2].length;
            final int n7 = (heightPixels - round * 2) / length;
            for (int i = length; i > 0; --i) {
                final int n8 = choosePathway.subpathwayCoursePath[value][value2][i - 1];
                final int length2 = choosePathway.coursePreRec[n8].length;
                final int n9 = loadArrayInt[n8];
                if (n9 != 0 && n9 != 1 && n9 != 4 && n9 != 3 && length2 != 0) {
                    int n10 = 1;
                    for (int j = 0; j < length2; ++j) {
                        final int n11 = loadArrayInt[choosePathway.coursePreRec[n8][j]];
                        if (n11 == 2 || n11 == 3) {
                            n10 = 0;
                        }
                    }
                    if (n10 != 1) {
                        final TextView textView = new TextView(this);
                        final int id = choosePathway.subpathwayCoursePath[value][value2][i - 1];
                        textView.setText(choosePathway.courseNum[id]);
                        textView.setTextColor(Color.parseColor("#ffffff"));
                        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        if (i != length) {
                            layoutParams.setMargins(5, 0, 5, 0);
                            layoutParams.height = n7;
                        }
                        else {
                            layoutParams.setMargins(5, 5, 5, 0);
                            layoutParams.height = n7;
                        }
                        textView.setLayoutParams(layoutParams);
                        textView.setTag(id);
                        textView.setGravity(16);
                        textView.setGravity(1);
                        textView.setGravity(17);
                        textView.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
                        textView.setId(id);
                        textView.setOnClickListener(this);
                        Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[id].length));
                        Log.w("Status", String.valueOf(loadArrayInt[id]));
                        textView.setBackgroundColor(Color.parseColor("#893f4e"));
                        linearLayout2.addView(textView);
                        final LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)textView.getLayoutParams();
                        layoutParams2.gravity = Gravity.CENTER; //17
                        textView.setLayoutParams(layoutParams2);
                    }
                }
            }
            for (int k = length; k > 0; --k) {
                final int n12 = choosePathway.subpathwayCoursePath[value][value2][k - 1];
                final int length3 = choosePathway.coursePreRec[n12].length;
                final int n13 = loadArrayInt[n12];
                if (n13 != 0 && n13 != 1 && n13 != 4) {
                    if (n13 == 3) {
                        final TextView textView2 = new TextView(this);
                        final int id2 = choosePathway.subpathwayCoursePath[value][value2][k - 1];
                        textView2.setText(choosePathway.courseNum[id2]);
                        textView2.setTextColor(Color.parseColor("#ffffff"));
                        final LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
                        if (k != length) {
                            layoutParams3.setMargins(5, 0, 5, 0);
                            layoutParams3.height = n7;
                        }
                        else {
                            layoutParams3.setMargins(5, 5, 5, 0);
                            layoutParams3.height = n7;
                        }
                        textView2.setLayoutParams(layoutParams3);
                        textView2.setTag(id2);
                        textView2.setGravity(16);
                        textView2.setGravity(1);
                        textView2.setGravity(17);
                        textView2.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
                        textView2.setId(id2);
                        textView2.setOnClickListener(this);
                      //  Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[id2].length));
                     //   Log.w("Status", String.valueOf(loadArrayInt[id2]));
                        textView2.setBackgroundColor(Color.parseColor("#fcd054"));
                        textView2.setTextColor(Color.parseColor("#000000"));
                        linearLayout2.addView(textView2);
                        final LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams)textView2.getLayoutParams();
                        layoutParams4.gravity = Gravity.CENTER; //17
                        textView2.setLayoutParams(layoutParams4);
                    }
                    else if (length3 == 0) {
                        final TextView textView3 = new TextView(this);
                        final int id3 = choosePathway.subpathwayCoursePath[value][value2][k - 1];
                        textView3.setText(choosePathway.courseNum[id3]);
                        textView3.setTextColor(Color.parseColor("#ffffff"));
                        final LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
                        if (k != length) {
                            layoutParams5.setMargins(5, 0, 5, 0);
                            layoutParams5.height = n7;
                        }
                        else {
                            layoutParams5.setMargins(5, 5, 5, 0);
                            layoutParams5.height = n7;
                        }
                        textView3.setLayoutParams(layoutParams5);
                        textView3.setTag(id3);
                        textView3.setGravity(16);
                        textView3.setGravity(1);
                        textView3.setGravity(17);
                        textView3.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
                        textView3.setId(id3);
                        textView3.setOnClickListener(this);
                      //  Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[id3].length));
                   //     Log.w("Status", String.valueOf(loadArrayInt[id3]));
                        textView3.setBackgroundColor(Color.parseColor("#fcd054"));
                        textView3.setTextColor(Color.parseColor("#000000"));
                        linearLayout2.addView(textView3);
                        final LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams)textView3.getLayoutParams();
                        layoutParams6.gravity = Gravity.CENTER; //17
                        textView3.setLayoutParams(layoutParams6);
                    }
                    else {
                        int n14 = 1;
                        for (int l = 0; l < length3; ++l) {
                            final int n15 = loadArrayInt[choosePathway.coursePreRec[n12][l]];
                            if (n15 == 2 || n15 == 3) {
                                n14 = 0;
                            }
                        }
                        if (n14 == 1) {
                            final TextView textView4 = new TextView(this);
                            final int id4 = choosePathway.subpathwayCoursePath[value][value2][k - 1];
                            textView4.setText(choosePathway.courseNum[id4]);
                            textView4.setTextColor(Color.parseColor("#ffffff"));
                            final LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
                            if (k != length) {
                                layoutParams7.setMargins(5, 0, 5, 0);
                                layoutParams7.height = n7;
                            }
                            else {
                                layoutParams7.setMargins(5, 5, 5, 0);
                                layoutParams7.height = n7;
                            }
                            textView4.setLayoutParams(layoutParams7);
                            textView4.setTag(id4);
                            textView4.setGravity(16);
                            textView4.setGravity(1);
                            textView4.setGravity(17);
                            textView4.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
                            textView4.setId(id4);
                            textView4.setOnClickListener(this);
                            Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[id4].length));
                            Log.w("Status", String.valueOf(loadArrayInt[id4]));
                            textView4.setBackgroundColor(Color.parseColor("#fcd054"));
                            textView4.setTextColor(Color.parseColor("#000000"));
                            linearLayout2.addView(textView4);
                            final LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams)textView4.getLayoutParams();
                            layoutParams8.gravity = Gravity.CENTER; //17
                            textView4.setLayoutParams(layoutParams8);
                        }
                    }
                }
            }
            for (int n16 = length; n16 > 0; --n16) {
                final int n17 = choosePathway.subpathwayCoursePath[value][value2][n16 - 1];
                final int length4 = choosePathway.coursePreRec[n17].length; // TODO: 6/30/2016 review these
                final int n18 = loadArrayInt[n17];
                if (n18 != 0 && (n18 == 1 || n18 == 4)) {
                    final TextView textView5 = new TextView(this);
                    final int id5 = choosePathway.subpathwayCoursePath[value][value2][n16 - 1];
                    textView5.setText(choosePathway.courseNum[id5]);
                    textView5.setTextColor(Color.parseColor("#ffffff"));
                    final LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
                    if (n16 != length) {
                        layoutParams9.setMargins(5, 0, 5, 0);
                        layoutParams9.height = n7;
                    }
                    else {
                        layoutParams9.setMargins(5, 5, 5, 0);
                        layoutParams9.height = n7;
                    }
                    textView5.setLayoutParams(layoutParams9);
                    textView5.setTag(id5);
                    textView5.setGravity(16);
                    textView5.setGravity(1);
                    textView5.setGravity(17);
                    textView5.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
                    textView5.setId(id5);
                    textView5.setOnClickListener(this);
                  //  Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[id5].length));
                 //   Log.w("Status", String.valueOf(loadArrayInt[id5]));
                    textView5.setBackgroundColor(Color.parseColor("#644181"));
                    linearLayout2.addView(textView5);
                    final LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams)textView5.getLayoutParams();
                    layoutParams10.gravity = Gravity.CENTER; //17
                    textView5.setLayoutParams(layoutParams10);
                }
            }
            for (int n19 = length; n19 > 0; --n19) {
                final int n20 = choosePathway.subpathwayCoursePath[value][value2][n19 - 1];
                final int length5 = choosePathway.coursePreRec[n20].length;
                if (loadArrayInt[n20] == 0) {
                    final TextView textView6 = new TextView(this);
                    final int id6 = choosePathway.subpathwayCoursePath[value][value2][n19 - 1];
                    textView6.setText(choosePathway.courseNum[id6]);
                    textView6.setTextColor(Color.parseColor("#ffffff"));
                    final LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
                    if (n19 != length) {
                        layoutParams11.setMargins(5, 0, 5, 0);
                        layoutParams11.height = n7;
                    }
                    else {
                        layoutParams11.setMargins(5, 5, 5, 0);
                        layoutParams11.height = n7;
                    }
                    textView6.setLayoutParams(layoutParams11);
                    textView6.setTag(id6);
                    textView6.setGravity(16);
                    textView6.setGravity(1);
                    textView6.setGravity(17);
                    textView6.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
                    textView6.setId(id6);
                    textView6.setOnClickListener(this);
               //     Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[id6].length));
               //     Log.w("Status", String.valueOf(loadArrayInt[id6]));
                    textView6.setBackgroundColor(Color.parseColor("#159b8a"));
                    linearLayout2.addView(textView6);
                    final LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams)textView6.getLayoutParams();
                    layoutParams12.gravity = Gravity.CENTER; //17
                    textView6.setLayoutParams(layoutParams12);
                }
            }
        }
        this.findViewById(R.id.zoom).setOnClickListener(new View.OnClickListener() { //2131624053


            public void onClick(final View view) {
                MainActivityZoomOut.this.startActivity(new Intent(MainActivityZoomOut.this, (Class)MainActivity.class));
            }
        });
        this.findViewById(R.id.menu).setOnClickListener(new View.OnClickListener() { //2131624054

            public void onClick(final View view) {
                MainActivityZoomOut.this.startActivity(new Intent(MainActivityZoomOut.this, (Class)Settings.class));
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (this.getIntent().getIntExtra("intVariableName", 1) == 0) {
            final int int1 = this.prefs.getInt("opencount", 1);
            Log.w("counter", String.valueOf(int1));
            int n;
            if (int1 == 5) {
                this.startActivity(new Intent(this, (Class)blackboardReminder.class));
                n = 1;
            }
            else {
                n = int1 + 1;
            }
            this.prefs.edit().putInt("opencount", n).commit();
        }
        if (this.prefs.getBoolean("firstrun", true)) {
            this.startActivity(new Intent(this, (Class)choosePathway.class));
        }
        final String string = this.prefs.getString("notifydate", "00/00/0000");
        final Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, 0); //11
        instance.set(Calendar.MINUTE, 0); //12
        instance.set(Calendar.SECOND, 1); //13
        instance.set(Calendar.MILLISECOND, 0); //14
        final Date time = instance.getTime();
        instance.getTimeInMillis();
        final String[] split = string.split("/");
        final String s = split[2];
        final String s2 = split[0];
        final String s3 = split[1];
        final int int2 = Integer.parseInt(s);
        final int int3 = Integer.parseInt(s2);
        final int int4 = Integer.parseInt(s3);
        instance.set(Calendar.YEAR, int2); //1
        instance.set(Calendar.MONTH, int3); //2
        instance.set(Calendar.DATE, int4 - 1); //5
        final Date time2 = instance.getTime();
        if (time2.before(time)) {
            final SharedPreferences.Editor edit = this.prefs.edit();
            final Calendar instance2 = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
            instance2.set(Calendar.HOUR_OF_DAY, 0); //11
            instance2.set(Calendar.MINUTE, 0); //12
            instance2.set(Calendar.SECOND, 0); //13
            instance2.set(Calendar.MILLISECOND, 0); //14
            int value = Calendar.getInstance().get(Calendar.MONTH); //2
            int value2 = Calendar.getInstance().get(Calendar.YEAR); //1
            int n2 = 0;
            int n3 = 0;
            Log.w("THIS YEAR", String.valueOf(value));
            if (value < 4) {
                n2 = 4;
                n3 = value2;
                Log.w("THIS Month", "<4: year post is: " + n3);
            }
            else if (value < 10) {
                n2 = 11;
                n3 = value2;
                Log.w("THIS Month", "<10: year post is: " + n3);
            }
            else if (value == 11) {
                n2 = 4;
                n3 = value2 + 1;
                Log.w("THIS YEAR (bottom)", "True" + n3);
            }
            final AlarmManager alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE); //"alarm"
            final Intent intent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
            intent.addCategory("android.intent.category.DEFAULT");
            PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, intent, PendingIntent.FLAG_UPDATE_CURRENT); //134217728
            final Calendar instance3 = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
            instance3.set(Calendar.DATE, 1); //5
            instance3.set(Calendar.MONTH, n2); //2
            instance3.set(Calendar.YEAR, n3); //1
            instance3.set(Calendar.HOUR_OF_DAY, 10); //11
            instance3.set(Calendar.MINUTE, 0); //12
            instance3.set(Calendar.SECOND, 0); //13
            if (Build.VERSION.SDK_INT >= 19) {
                alarmManager.setExact(0, instance3.getTimeInMillis(), broadcast);
            }
            else {
                alarmManager.set(0, instance3.getTimeInMillis(), broadcast);
            }
            edit.putString("notifydate", String.valueOf(n2) + "/01/" + String.valueOf(n3)).commit();
            Log.w("NEW ALERT SET DATE", String.valueOf(n2) + "/01/" + String.valueOf(n3));
            Log.w("Date Calc", "Date specified [" + time2 + "] is before today [" + time + "]");
            return;
        }
        Log.w("Date Calc", "Date specified [" + time2 + "] is NOT before today [" + time + "]");
    }
}
