package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView.BufferType;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivity
        extends Activity
        implements View.OnClickListener
{
    public SharedPreferences prefs;

    public MainActivity() {}

    MainActivity(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
    }

    public String[][] load2DArray(String paramString)
    {
        Object localObject = $change;
        if (localObject != null) {
            return (String[][])((IncrementalChange)localObject).access$dispatch("load2DArray.(Ljava/lang/String;)[[Ljava/lang/String;", new Object[] { this, paramString });
        }
        localObject = getSharedPreferences("preferencename", 0);
        int k = ((SharedPreferences)localObject).getInt(paramString + "_size", 0);
        String[][] arrayOfString = new String[k][];
        int i = 0;
        while (i < k)
        {
            int m = ((SharedPreferences)localObject).getInt(paramString + "_size_" + i, 0);
            Log.d("I Loop", String.valueOf(i));
            String[] arrayOfString1 = new String[m];
            int j = 0;
            while (j < m)
            {
                Log.d("T Loop", ((SharedPreferences)localObject).getString(paramString + "_" + i + "_" + j, "hi"));
                arrayOfString1[j] = ((SharedPreferences)localObject).getString(paramString + "_" + i + "_" + j, "hi");
                j += 1;
            }
            arrayOfString[i] = arrayOfString1;
            i += 1;
        }
        return arrayOfString;
    }

    public int[] loadArrayInt(String paramString)
    {
        Object localObject = $change;
        if (localObject != null) {
            return (int[])((IncrementalChange)localObject).access$dispatch("loadArrayInt.(Ljava/lang/String;)[I", new Object[] { this, paramString });
        }
        localObject = getSharedPreferences("preferencename", 0);
        int j = ((SharedPreferences)localObject).getInt(paramString + "_size", 0);
        int[] arrayOfInt = new int[j];
        int i = 0;
        while (i < j)
        {
            arrayOfInt[i] = ((SharedPreferences)localObject).getInt(paramString + "_" + i, 1);
            i += 1;
        }
        return arrayOfInt;
    }

    public void onClick(View paramView)
    {
        Object localObject = $change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramView });
            return;
        }
        localObject = new Intent(this, info.class);
        int i = paramView.getId();
        this.prefs.edit().putString("choosenID", String.valueOf(i)).commit();
        startActivity((Intent)localObject);
    }

    @TargetApi(16)
    public void onCreate(Bundle paramBundle)
    {
        Object localObject1 = $change;
        if (localObject1 != null)
        {
            ((IncrementalChange)localObject1).access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
            return;
        }
        super.onCreate(paramBundle);
        setContentView(2130968616);
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        this.prefs.edit().putInt("zoom", 0).commit();
        paramBundle = Integer.valueOf(this.prefs.getInt("pathwayID", 0));
        localObject1 = Integer.valueOf(this.prefs.getInt("pathwaysubID", 0));
        Object localObject4 = this.prefs.getString("notifydate", "00/00/0000");
        final Object localObject3 = Calendar.getInstance();
        ((Calendar)localObject3).set(11, 0);
        ((Calendar)localObject3).set(12, 0);
        ((Calendar)localObject3).set(13, 1);
        ((Calendar)localObject3).set(14, 0);
        Object localObject2 = ((Calendar)localObject3).getTime();
        ((Calendar)localObject3).getTimeInMillis();
        Object localObject6 = ((String)localObject4).split("/");
        localObject4 = localObject6[2];
        Object localObject5 = localObject6[0];
        localObject6 = localObject6[1];
        int i = Integer.parseInt((String)localObject4);
        int j = Integer.parseInt((String)localObject5);
        int k = Integer.parseInt((String)localObject6);
        ((Calendar)localObject3).set(1, i);
        ((Calendar)localObject3).set(2, j);
        ((Calendar)localObject3).set(5, k - 1);
        localObject3 = ((Calendar)localObject3).getTime();
        Calendar localCalendar;
        if (((Date)localObject3).before((Date)localObject2))
        {
            localObject4 = this.prefs.edit();
            localObject5 = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
            ((Calendar)localObject5).set(11, 0);
            ((Calendar)localObject5).set(12, 0);
            ((Calendar)localObject5).set(13, 0);
            ((Calendar)localObject5).set(14, 0);
            j = Calendar.getInstance().get(2);
            i = Calendar.getInstance().get(1);
            Log.w("THIS YEAR", String.valueOf(j));
            if (j < 4)
            {
                k = 4;
                Log.w("THIS Month", "<4: year post is: " + i);
                j = i;
                i = k;
                localObject5 = (AlarmManager)getSystemService("alarm");
                localObject6 = new Intent("android.media.action.DISPLAY_NOTIFICATION");
                ((Intent)localObject6).addCategory("android.intent.category.DEFAULT");
                localObject6 = PendingIntent.getBroadcast(this, 100, (Intent)localObject6, 134217728);
                localCalendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
                localCalendar.set(5, 1);
                localCalendar.set(2, i);
                localCalendar.set(1, j);
                localCalendar.set(11, 10);
                localCalendar.set(12, 0);
                localCalendar.set(13, 0);
                if (Build.VERSION.SDK_INT < 19) {
                    break label773;
                }
                ((AlarmManager)localObject5).setExact(0, localCalendar.getTimeInMillis(), (PendingIntent)localObject6);
                label524:
                ((SharedPreferences.Editor)localObject4).putString("notifydate", String.valueOf(i) + "/01/" + String.valueOf(j)).commit();
                Log.w("NEW ALERT SET DATE", String.valueOf(i) + "/01/" + String.valueOf(j));
                Log.w("Date Calc", "Date specified [" + localObject3 + "] is before today [" + localObject2 + "]");
            }
        }
        for (;;)
        {
            if (((Integer)localObject1).intValue() != -1) {
                break label837;
            }
            startActivity(new Intent(this, choosePathway.class));
            return;
            if (j < 11)
            {
                k = 11;
                j = i;
                Log.w("THIS Month", "<10: year post is: " + j);
                i = k;
                break;
            }
            j = 4;
            k = i + 1;
            Log.w("THIS YEAR", "TRUE " + k);
            i = j;
            j = k;
            break;
            label773:
            ((AlarmManager)localObject5).set(0, localCalendar.getTimeInMillis(), (PendingIntent)localObject6);
            break label524;
            Log.w("Date Calc", "Date specified [" + localObject3 + "] is NOT before today [" + localObject2 + "]");
        }
        label837:
        load2DArray("courseName");
        localObject4 = loadArrayInt("courseStat");
        Integer.parseInt(this.prefs.getString("choosenID", "0"));
        new RelativeLayout(this);
        localObject2 = (LinearLayout)findViewById(2131624046);
        localObject3 = (ScrollView)findViewById(2131624045);
        ((ScrollView)localObject3).post(new Runnable()
        {
            public void run()
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("run.()V", new Object[] { this });
                    return;
                }
                localObject3.fullScroll(130);
            }
        });
        localObject5 = new ImageView(this);
        ((ImageView)localObject5).setImageResource(2130837591);
        ((ImageView)localObject5).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        localObject6 = (LinearLayout)findViewById(2131624046);
        localObject3 = getResources();
        ((ImageView)localObject5).getLayoutParams().height = Math.round(TypedValue.applyDimension(1, 70.0F, ((Resources)localObject3).getDisplayMetrics()));
        Math.round(TypedValue.applyDimension(1, 70.0F, ((Resources)localObject3).getDisplayMetrics()));
        ((LinearLayout)localObject6).addView((View)localObject5);
        int m = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()].length;
        i = m;
        if (i > 0)
        {
            f = getResources().getDisplayMetrics().density;
            j = (int)(13 * f);
            k = (int)(2.2D * f);
            localObject5 = new Button(this);
            int n = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()][(i - 1)];
            ((Button)localObject5).setText(choosePathway.courseNum[n]);
            localObject6 = new LinearLayout.LayoutParams(-2, -2);
            ((Button)localObject5).setPadding(j, j, j, j);
            ((Button)localObject5).setGravity(16);
            ((Button)localObject5).setGravity(1);
            ((Button)localObject5).setGravity(17);
            ((Button)localObject5).setTextSize(1, 14.0F);
            ((Button)localObject5).setTypeface(null, 1);
            label1193:
            int i1;
            if (i != m)
            {
                ((LinearLayout.LayoutParams)localObject6).setMargins(k, k, k, k);
                ((Button)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                ((Button)localObject5).setTag(Integer.valueOf(n));
                ((Button)localObject5).setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, ((Resources)localObject3).getDisplayMetrics())));
                ((Button)localObject5).setId(n);
                ((Button)localObject5).setOnClickListener(this);
                i1 = choosePathway.coursePreRec[n].length;
                Log.w("Prereclangth:", String.valueOf(i1));
                j = localObject4[n];
                ((Button)localObject5).setTextColor(Color.parseColor("#ffffff"));
                Log.w("Status", String.valueOf(j));
                if (j != 0) {
                    break label1368;
                }
                ((Button)localObject5).setBackgroundColor(Color.parseColor("#159b8a"));
            }
            for (;;)
            {
                ((LinearLayout)localObject2).addView((View)localObject5);
                localObject6 = (LinearLayout.LayoutParams)((Button)localObject5).getLayoutParams();
                ((LinearLayout.LayoutParams)localObject6).gravity = 17;
                ((Button)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                i -= 1;
                break;
                ((LinearLayout.LayoutParams)localObject6).setMargins(k, (int)(5.0F * f), k, k);
                break label1193;
                label1368:
                if ((j == 1) || (j == 4))
                {
                    ((Button)localObject5).setBackgroundColor(Color.parseColor("#644181"));
                }
                else if (j == 3)
                {
                    ((Button)localObject5).setTextColor(Color.parseColor("#000000"));
                    ((Button)localObject5).setBackgroundColor(Color.parseColor("#fcd054"));
                }
                else if (i1 == 0)
                {
                    ((Button)localObject5).setTextColor(Color.parseColor("#000000"));
                    ((Button)localObject5).setBackgroundColor(Color.parseColor("#fcd054"));
                    Log.w("if/else", "=0");
                }
                else
                {
                    Log.w("if/else", "!=0");
                    k = 1;
                    j = 0;
                    while (j < i1)
                    {
                        int i2 = localObject4[choosePathway.coursePreRec[n][j]];
                        if ((i2 == 2) || (i2 == 3)) {
                            k = 0;
                        }
                        j += 1;
                    }
                    if (k == 1)
                    {
                        ((Button)localObject5).setTextColor(Color.parseColor("#000000"));
                        ((Button)localObject5).setBackgroundColor(Color.parseColor("#fcd054"));
                    }
                    else
                    {
                        ((Button)localObject5).setBackgroundColor(Color.parseColor("#893f4e"));
                    }
                }
            }
        }
        float f = getResources().getDisplayMetrics().density;
        i = (int)(13 * f);
        j = (int)(2.2D * f);
        localObject4 = new NonBreakingPeriodTextView(this);
        ((NonBreakingPeriodTextView)localObject4).setText(choosePathway.sub_pathwayName[paramBundle.intValue()][localObject1.intValue()] + "\nPathway", TextView.BufferType.EDITABLE);
        paramBundle = new LinearLayout.LayoutParams(-2, -2);
        ((NonBreakingPeriodTextView)localObject4).setPadding(i, i, i, i);
        ((NonBreakingPeriodTextView)localObject4).setGravity(16);
        ((NonBreakingPeriodTextView)localObject4).setGravity(1);
        ((NonBreakingPeriodTextView)localObject4).setGravity(17);
        ((NonBreakingPeriodTextView)localObject4).setTextSize(1, 14.0F);
        ((NonBreakingPeriodTextView)localObject4).setTypeface(null, 1);
        paramBundle.setMargins(j, j, j, j);
        ((NonBreakingPeriodTextView)localObject4).setLayoutParams(paramBundle);
        ((NonBreakingPeriodTextView)localObject4).setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, ((Resources)localObject3).getDisplayMetrics())));
        ((NonBreakingPeriodTextView)localObject4).setTextColor(Color.parseColor("#ffffff"));
        ((LinearLayout)localObject2).addView((View)localObject4);
        paramBundle = (LinearLayout.LayoutParams)((NonBreakingPeriodTextView)localObject4).getLayoutParams();
        paramBundle.gravity = 17;
        ((NonBreakingPeriodTextView)localObject4).setLayoutParams(paramBundle);
        ((ImageButton)findViewById(2131624047)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                MainActivity.this.startActivity(new Intent(MainActivity.this, MainActivityZoomOut.class));
            }
        });
        ((ImageButton)findViewById(2131624022)).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                MainActivity.this.startActivity(new Intent(MainActivity.this, Settings.class));
            }
        });
    }

    public void onResume()
    {
        Object localObject1 = $change;
        if (localObject1 != null)
        {
            ((IncrementalChange)localObject1).access$dispatch("onResume.()V", new Object[] { this });
            return;
        }
        super.onResume();
        int i;
        Object localObject3;
        Object localObject2;
        Object localObject5;
        Object localObject4;
        int j;
        int k;
        int m;
        label427:
        Object localObject6;
        if (getIntent().getIntExtra("intVariableName", 1) == 0)
        {
            i = this.prefs.getInt("opencount", 1);
            Log.w("counter", String.valueOf(i));
            if (i == 5)
            {
                startActivity(new Intent(this, blackboardReminder.class));
                i = 1;
                this.prefs.edit().putInt("opencount", i).commit();
            }
        }
        else
        {
            if (this.prefs.getBoolean("firstrun", true)) {
                startActivity(new Intent(this, choosePathway.class));
            }
            localObject3 = this.prefs.getString("notifydate", "00/00/0000");
            localObject2 = Calendar.getInstance();
            ((Calendar)localObject2).set(11, 0);
            ((Calendar)localObject2).set(12, 0);
            ((Calendar)localObject2).set(13, 1);
            ((Calendar)localObject2).set(14, 0);
            localObject1 = ((Calendar)localObject2).getTime();
            ((Calendar)localObject2).getTimeInMillis();
            localObject5 = ((String)localObject3).split("/");
            localObject3 = localObject5[2];
            localObject4 = localObject5[0];
            localObject5 = localObject5[1];
            i = Integer.parseInt((String)localObject3);
            j = Integer.parseInt((String)localObject4);
            k = Integer.parseInt((String)localObject5);
            ((Calendar)localObject2).set(1, i);
            ((Calendar)localObject2).set(2, j);
            ((Calendar)localObject2).set(5, k - 1);
            localObject2 = ((Calendar)localObject2).getTime();
            if (!((Date)localObject2).before((Date)localObject1)) {
                break label1266;
            }
            localObject3 = this.prefs.edit();
            localObject4 = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
            ((Calendar)localObject4).set(11, 0);
            ((Calendar)localObject4).set(12, 0);
            ((Calendar)localObject4).set(13, 0);
            ((Calendar)localObject4).set(14, 0);
            m = Calendar.getInstance().get(2);
            i = Calendar.getInstance().get(1);
            j = 0;
            k = 0;
            Log.w("THIS YEAR", String.valueOf(m));
            if (m >= 4) {
                break label1073;
            }
            j = 4;
            Log.w("THIS Month", "<4: year post is: " + i);
            k = i;
            localObject4 = (AlarmManager)getSystemService("alarm");
            localObject5 = new Intent("android.media.action.DISPLAY_NOTIFICATION");
            ((Intent)localObject5).addCategory("android.intent.category.DEFAULT");
            localObject5 = PendingIntent.getBroadcast(this, 100, (Intent)localObject5, 134217728);
            localObject6 = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
            ((Calendar)localObject6).set(5, 1);
            ((Calendar)localObject6).set(2, j);
            ((Calendar)localObject6).set(1, k);
            ((Calendar)localObject6).set(11, 10);
            ((Calendar)localObject6).set(12, 0);
            ((Calendar)localObject6).set(13, 0);
            if (Build.VERSION.SDK_INT < 19) {
                break label1158;
            }
            ((AlarmManager)localObject4).setExact(0, ((Calendar)localObject6).getTimeInMillis(), (PendingIntent)localObject5);
            label551:
            localObject5 = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
            i = Calendar.getInstance().get(2);
            switch (i)
            {
                default:
                    label632:
                    Log.w("Cmonth", String.valueOf(i));
                    ((Calendar)localObject5).set(5, 1);
                    ((Calendar)localObject5).set(2, i);
                    ((Calendar)localObject5).set(11, 10);
                    ((Calendar)localObject5).set(12, 0);
                    ((Calendar)localObject5).set(13, 0);
                    localObject6 = new Intent("android.media.action.DISPLAY_NOTIFICATION");
                    ((Intent)localObject6).addCategory("android.intent.category.DEFAULT");
                    localObject6 = PendingIntent.getBroadcast(this, 100, (Intent)localObject6, 134217728);
                    if (Build.VERSION.SDK_INT >= 19)
                    {
                        ((AlarmManager)localObject4).setExact(0, ((Calendar)localObject5).getTimeInMillis(), (PendingIntent)localObject6);
                        label737:
                        ((SharedPreferences.Editor)localObject3).putString("notifydate", String.valueOf(j) + "/01/" + String.valueOf(k)).commit();
                        Log.w("NEW ALERT SET DATE", String.valueOf(j) + "/01/" + String.valueOf(k));
                        Log.w("Date Calc", "Date specified [" + localObject2 + "] is before today [" + localObject1 + "]");
                        label865:
                        localObject1 = (AlarmManager)getSystemService("alarm");
                        localObject2 = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
                        i = Calendar.getInstance().get(2);
                        switch (i)
                        {
                        }
                    }
                    break;
            }
        }
        for (;;)
        {
            Log.w("Cmonth", String.valueOf(i));
            ((Calendar)localObject2).set(5, 1);
            ((Calendar)localObject2).set(2, i);
            ((Calendar)localObject2).set(11, 10);
            ((Calendar)localObject2).set(12, 0);
            ((Calendar)localObject2).set(13, 0);
            localObject3 = new Intent("android.media.action.DISPLAY_Blackboard_NOTIFICATION");
            ((Intent)localObject3).addCategory("android.intent.category.DEFAULT_Blackboard");
            localObject3 = PendingIntent.getBroadcast(this, 100, (Intent)localObject3, 134217728);
            if (Build.VERSION.SDK_INT < 19) {
                break label1390;
            }
            ((AlarmManager)localObject1).setExact(0, ((Calendar)localObject2).getTimeInMillis(), (PendingIntent)localObject3);
            return;
            i += 1;
            break;
            label1073:
            if (m < 10)
            {
                j = 11;
                Log.w("THIS Month", "<10: year post is: " + i);
                k = i;
                break label427;
            }
            if (m != 11) {
                break label427;
            }
            j = 4;
            k = i + 1;
            Log.w("THIS YEAR (bottom)", "True" + k);
            break label427;
            label1158:
            ((AlarmManager)localObject4).set(0, ((Calendar)localObject6).getTimeInMillis(), (PendingIntent)localObject5);
            break label551;
            i += 1;
            break label632;
            i += 1;
            break label632;
            i += 1;
            break label632;
            i = 8;
            break label632;
            i = 8;
            break label632;
            i = 8;
            break label632;
            i = 8;
            break label632;
            i += 1;
            break label632;
            i += 1;
            break label632;
            i += 1;
            break label632;
            i = 1;
            break label632;
            i = 1;
            break label632;
            ((AlarmManager)localObject4).set(0, ((Calendar)localObject5).getTimeInMillis(), (PendingIntent)localObject6);
            break label737;
            label1266:
            Log.w("Date Calc", "Date specified [" + localObject2 + "] is NOT before today [" + localObject1 + "]");
            break label865;
            i += 1;
            continue;
            i += 1;
            continue;
            i += 1;
            continue;
            i = 8;
            continue;
            i = 8;
            continue;
            i = 8;
            continue;
            i = 8;
            continue;
            i += 1;
            continue;
            i += 1;
            continue;
            i += 1;
            continue;
            i = 1;
            continue;
            i = 1;
        }
        label1390:
        ((AlarmManager)localObject1).set(0, ((Calendar)localObject2).getTimeInMillis(), (PendingIntent)localObject3);
    }
}
