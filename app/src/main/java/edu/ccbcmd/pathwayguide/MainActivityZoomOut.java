package edu.ccbcmd.pathwayguide;



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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MainActivityZoomOut
        extends Activity
        implements View.OnClickListener
{
    public SharedPreferences prefs;

    public MainActivityZoomOut() {}

    MainActivityZoomOut(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}

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
        paramView = String.valueOf(paramView.getId());
        this.prefs.edit().putString("choosenID", paramView).commit();
        ((Intent)localObject).putExtra("arrayID", paramView);
        startActivity((Intent)localObject);
    }

    public void onCreate(Bundle paramBundle)
    {
        Object localObject1 = $change;
        if (localObject1 != null)
        {
            ((IncrementalChange)localObject1).access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
            return;
        }
        super.onCreate(paramBundle);
        setContentView(2130968617);
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        this.prefs.edit().putInt("zoom", 1).commit();
        paramBundle = Integer.valueOf(this.prefs.getInt("pathwayID", 0));
        localObject1 = Integer.valueOf(this.prefs.getInt("pathwaysubID", 0));
        final Object localObject4 = this.prefs.getString("notifydate", "00/00/0000");
        Object localObject3 = Calendar.getInstance();
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
                    break label800;
                }
                ((AlarmManager)localObject5).setExact(0, localCalendar.getTimeInMillis(), (PendingIntent)localObject6);
                label517:
                ((SharedPreferences.Editor)localObject4).putString("notifydate", String.valueOf(i) + "/01/" + String.valueOf(j)).commit();
                Log.w("NEW ALERT SET DATE", String.valueOf(i) + "/01/" + String.valueOf(j));
                Log.w("Date Calc", "Date specified [" + localObject3 + "] is before today [" + localObject2 + "]");
            }
        }
        for (;;)
        {
            if (((Integer)localObject1).intValue() != -1) {
                break label864;
            }
            startActivity(new Intent(this, choosePathway.class));
            ((ImageButton)findViewById(2131624053)).setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View paramAnonymousView)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                        return;
                    }
                    MainActivityZoomOut.this.startActivity(new Intent(MainActivityZoomOut.this, MainActivity.class));
                }
            });
            ((ImageButton)findViewById(2131624054)).setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View paramAnonymousView)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                        return;
                    }
                    MainActivityZoomOut.this.startActivity(new Intent(MainActivityZoomOut.this, Settings.class));
                }
            });
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
            label800:
            ((AlarmManager)localObject5).set(0, localCalendar.getTimeInMillis(), (PendingIntent)localObject6);
            break label517;
            Log.w("Date Calc", "Date specified [" + localObject3 + "] is NOT before today [" + localObject2 + "]");
        }
        label864:
        load2DArray("courseName");
        localObject2 = loadArrayInt("courseStat");
        Integer.parseInt(this.prefs.getString("choosenID", "0"));
        new RelativeLayout(this);
        localObject3 = (LinearLayout)findViewById(2131624046);
        localObject4 = (ScrollView)findViewById(2131624045);
        ((ScrollView)localObject4).post(new Runnable()
        {
            public void run()
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("run.()V", new Object[] { this });
                    return;
                }
                localObject4.fullScroll(130);
            }
        });
        j = getResources().getDisplayMetrics().heightPixels;
        localObject5 = new ImageView(this);
        ((ImageView)localObject5).setImageResource(2130837591);
        ((ImageView)localObject5).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        localObject6 = (LinearLayout)findViewById(2131624046);
        localObject4 = getResources();
        ((ImageView)localObject5).getLayoutParams().height = Math.round(TypedValue.applyDimension(1, 70.0F, ((Resources)localObject4).getDisplayMetrics()));
        k = Math.round(TypedValue.applyDimension(1, 70.0F, ((Resources)localObject4).getDisplayMetrics()));
        ((LinearLayout)localObject6).addView((View)localObject5);
        i = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()].length;
        int n = (j - k * 2) / i;
        j = i;
        int i1;
        int i2;
        int m;
        int i3;
        if (j > 0)
        {
            i1 = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()][(j - 1)];
            i2 = choosePathway.coursePreRec[i1].length;
            k = localObject2[i1];
            if (k == 0) {}
            do
            {
                do
                {
                    j -= 1;
                    break;
                } while ((k == 1) || (k == 4) || (k == 3) || (i2 == 0));
                m = 1;
                k = 0;
                while (k < i2)
                {
                    i3 = localObject2[choosePathway.coursePreRec[i1][k]];
                    if ((i3 == 2) || (i3 == 3)) {
                        m = 0;
                    }
                    k += 1;
                }
            } while (m == 1);
            localObject5 = new TextView(this);
            k = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()][(j - 1)];
            ((TextView)localObject5).setText(choosePathway.courseNum[k]);
            ((TextView)localObject5).setTextColor(Color.parseColor("#ffffff"));
            localObject6 = new LinearLayout.LayoutParams(-2, -2);
            if (j != i) {
                ((LinearLayout.LayoutParams)localObject6).setMargins(5, 0, 5, 0);
            }
            for (((LinearLayout.LayoutParams)localObject6).height = n;; ((LinearLayout.LayoutParams)localObject6).height = n)
            {
                ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                ((TextView)localObject5).setTag(Integer.valueOf(k));
                ((TextView)localObject5).setGravity(16);
                ((TextView)localObject5).setGravity(1);
                ((TextView)localObject5).setGravity(17);
                ((TextView)localObject5).setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, ((Resources)localObject4).getDisplayMetrics())));
                ((TextView)localObject5).setId(k);
                ((TextView)localObject5).setOnClickListener(this);
                Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[k].length));
                Log.w("Status", String.valueOf(localObject2[k]));
                ((TextView)localObject5).setBackgroundColor(Color.parseColor("#893f4e"));
                ((LinearLayout)localObject3).addView((View)localObject5);
                localObject6 = (LinearLayout.LayoutParams)((TextView)localObject5).getLayoutParams();
                ((LinearLayout.LayoutParams)localObject6).gravity = 17;
                ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                break;
                ((LinearLayout.LayoutParams)localObject6).setMargins(5, 5, 5, 0);
            }
        }
        j = i;
        if (j > 0)
        {
            i1 = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()][(j - 1)];
            i2 = choosePathway.coursePreRec[i1].length;
            k = localObject2[i1];
            if (k == 0) {}
            do
            {
                do
                {
                    j -= 1;
                    break;
                } while ((k == 1) || (k == 4));
                if (k == 3)
                {
                    localObject5 = new TextView(this);
                    k = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()][(j - 1)];
                    ((TextView)localObject5).setText(choosePathway.courseNum[k]);
                    ((TextView)localObject5).setTextColor(Color.parseColor("#ffffff"));
                    localObject6 = new LinearLayout.LayoutParams(-2, -2);
                    if (j != i) {
                        ((LinearLayout.LayoutParams)localObject6).setMargins(5, 0, 5, 0);
                    }
                    for (((LinearLayout.LayoutParams)localObject6).height = n;; ((LinearLayout.LayoutParams)localObject6).height = n)
                    {
                        ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                        ((TextView)localObject5).setTag(Integer.valueOf(k));
                        ((TextView)localObject5).setGravity(16);
                        ((TextView)localObject5).setGravity(1);
                        ((TextView)localObject5).setGravity(17);
                        ((TextView)localObject5).setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, ((Resources)localObject4).getDisplayMetrics())));
                        ((TextView)localObject5).setId(k);
                        ((TextView)localObject5).setOnClickListener(this);
                        Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[k].length));
                        Log.w("Status", String.valueOf(localObject2[k]));
                        ((TextView)localObject5).setBackgroundColor(Color.parseColor("#fcd054"));
                        ((TextView)localObject5).setTextColor(Color.parseColor("#000000"));
                        ((LinearLayout)localObject3).addView((View)localObject5);
                        localObject6 = (LinearLayout.LayoutParams)((TextView)localObject5).getLayoutParams();
                        ((LinearLayout.LayoutParams)localObject6).gravity = 17;
                        ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                        break;
                        ((LinearLayout.LayoutParams)localObject6).setMargins(5, 5, 5, 0);
                    }
                }
                if (i2 == 0)
                {
                    localObject5 = new TextView(this);
                    k = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()][(j - 1)];
                    ((TextView)localObject5).setText(choosePathway.courseNum[k]);
                    ((TextView)localObject5).setTextColor(Color.parseColor("#ffffff"));
                    localObject6 = new LinearLayout.LayoutParams(-2, -2);
                    if (j != i) {
                        ((LinearLayout.LayoutParams)localObject6).setMargins(5, 0, 5, 0);
                    }
                    for (((LinearLayout.LayoutParams)localObject6).height = n;; ((LinearLayout.LayoutParams)localObject6).height = n)
                    {
                        ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                        ((TextView)localObject5).setTag(Integer.valueOf(k));
                        ((TextView)localObject5).setGravity(16);
                        ((TextView)localObject5).setGravity(1);
                        ((TextView)localObject5).setGravity(17);
                        ((TextView)localObject5).setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, ((Resources)localObject4).getDisplayMetrics())));
                        ((TextView)localObject5).setId(k);
                        ((TextView)localObject5).setOnClickListener(this);
                        Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[k].length));
                        Log.w("Status", String.valueOf(localObject2[k]));
                        ((TextView)localObject5).setBackgroundColor(Color.parseColor("#fcd054"));
                        ((TextView)localObject5).setTextColor(Color.parseColor("#000000"));
                        ((LinearLayout)localObject3).addView((View)localObject5);
                        localObject6 = (LinearLayout.LayoutParams)((TextView)localObject5).getLayoutParams();
                        ((LinearLayout.LayoutParams)localObject6).gravity = 17;
                        ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                        break;
                        ((LinearLayout.LayoutParams)localObject6).setMargins(5, 5, 5, 0);
                    }
                }
                m = 1;
                k = 0;
                while (k < i2)
                {
                    i3 = localObject2[choosePathway.coursePreRec[i1][k]];
                    if ((i3 == 2) || (i3 == 3)) {
                        m = 0;
                    }
                    k += 1;
                }
            } while (m != 1);
            localObject5 = new TextView(this);
            k = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()][(j - 1)];
            ((TextView)localObject5).setText(choosePathway.courseNum[k]);
            ((TextView)localObject5).setTextColor(Color.parseColor("#ffffff"));
            localObject6 = new LinearLayout.LayoutParams(-2, -2);
            if (j != i) {
                ((LinearLayout.LayoutParams)localObject6).setMargins(5, 0, 5, 0);
            }
            for (((LinearLayout.LayoutParams)localObject6).height = n;; ((LinearLayout.LayoutParams)localObject6).height = n)
            {
                ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                ((TextView)localObject5).setTag(Integer.valueOf(k));
                ((TextView)localObject5).setGravity(16);
                ((TextView)localObject5).setGravity(1);
                ((TextView)localObject5).setGravity(17);
                ((TextView)localObject5).setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, ((Resources)localObject4).getDisplayMetrics())));
                ((TextView)localObject5).setId(k);
                ((TextView)localObject5).setOnClickListener(this);
                Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[k].length));
                Log.w("Status", String.valueOf(localObject2[k]));
                ((TextView)localObject5).setBackgroundColor(Color.parseColor("#fcd054"));
                ((TextView)localObject5).setTextColor(Color.parseColor("#000000"));
                ((LinearLayout)localObject3).addView((View)localObject5);
                localObject6 = (LinearLayout.LayoutParams)((TextView)localObject5).getLayoutParams();
                ((LinearLayout.LayoutParams)localObject6).gravity = 17;
                ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                break;
                ((LinearLayout.LayoutParams)localObject6).setMargins(5, 5, 5, 0);
            }
        }
        j = i;
        if (j > 0)
        {
            k = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()][(j - 1)];
            m = choosePathway.coursePreRec[k].length;
            k = localObject2[k];
            if (k == 0) {}
            while ((k != 1) && (k != 4))
            {
                j -= 1;
                break;
            }
            localObject5 = new TextView(this);
            k = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()][(j - 1)];
            ((TextView)localObject5).setText(choosePathway.courseNum[k]);
            ((TextView)localObject5).setTextColor(Color.parseColor("#ffffff"));
            localObject6 = new LinearLayout.LayoutParams(-2, -2);
            if (j != i) {
                ((LinearLayout.LayoutParams)localObject6).setMargins(5, 0, 5, 0);
            }
            for (((LinearLayout.LayoutParams)localObject6).height = n;; ((LinearLayout.LayoutParams)localObject6).height = n)
            {
                ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                ((TextView)localObject5).setTag(Integer.valueOf(k));
                ((TextView)localObject5).setGravity(16);
                ((TextView)localObject5).setGravity(1);
                ((TextView)localObject5).setGravity(17);
                ((TextView)localObject5).setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, ((Resources)localObject4).getDisplayMetrics())));
                ((TextView)localObject5).setId(k);
                ((TextView)localObject5).setOnClickListener(this);
                Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[k].length));
                Log.w("Status", String.valueOf(localObject2[k]));
                ((TextView)localObject5).setBackgroundColor(Color.parseColor("#644181"));
                ((LinearLayout)localObject3).addView((View)localObject5);
                localObject6 = (LinearLayout.LayoutParams)((TextView)localObject5).getLayoutParams();
                ((LinearLayout.LayoutParams)localObject6).gravity = 17;
                ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
                break;
                ((LinearLayout.LayoutParams)localObject6).setMargins(5, 5, 5, 0);
            }
        }
        j = i;
        label2713:
        if (j > 0)
        {
            k = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()][(j - 1)];
            m = choosePathway.coursePreRec[k].length;
            if (localObject2[k] == 0)
            {
                localObject5 = new TextView(this);
                k = choosePathway.subpathwayCoursePath[paramBundle.intValue()][localObject1.intValue()][(j - 1)];
                ((TextView)localObject5).setText(choosePathway.courseNum[k]);
                ((TextView)localObject5).setTextColor(Color.parseColor("#ffffff"));
                localObject6 = new LinearLayout.LayoutParams(-2, -2);
                if (j == i) {
                    break label2991;
                }
                ((LinearLayout.LayoutParams)localObject6).setMargins(5, 0, 5, 0);
            }
        }
        for (((LinearLayout.LayoutParams)localObject6).height = n;; ((LinearLayout.LayoutParams)localObject6).height = n)
        {
            ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
            ((TextView)localObject5).setTag(Integer.valueOf(k));
            ((TextView)localObject5).setGravity(16);
            ((TextView)localObject5).setGravity(1);
            ((TextView)localObject5).setGravity(17);
            ((TextView)localObject5).setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, ((Resources)localObject4).getDisplayMetrics())));
            ((TextView)localObject5).setId(k);
            ((TextView)localObject5).setOnClickListener(this);
            Log.w("Prereclangth:", String.valueOf(choosePathway.coursePreRec[k].length));
            Log.w("Status", String.valueOf(localObject2[k]));
            ((TextView)localObject5).setBackgroundColor(Color.parseColor("#159b8a"));
            ((LinearLayout)localObject3).addView((View)localObject5);
            localObject6 = (LinearLayout.LayoutParams)((TextView)localObject5).getLayoutParams();
            ((LinearLayout.LayoutParams)localObject6).gravity = 17;
            ((TextView)localObject5).setLayoutParams((ViewGroup.LayoutParams)localObject6);
            j -= 1;
            break label2713;
            break;
            label2991:
            ((LinearLayout.LayoutParams)localObject6).setMargins(5, 5, 5, 0);
        }
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
        Calendar localCalendar;
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
                break label788;
            }
            localObject3 = this.prefs.edit();
            localObject4 = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
            ((Calendar)localObject4).set(11, 0);
            ((Calendar)localObject4).set(12, 0);
            ((Calendar)localObject4).set(13, 0);
            ((Calendar)localObject4).set(14, 0);
            m = Calendar.getInstance().get(2);
            k = Calendar.getInstance().get(1);
            i = 0;
            j = 0;
            Log.w("THIS YEAR", String.valueOf(m));
            if (m >= 4) {
                break label687;
            }
            i = 4;
            j = k;
            Log.w("THIS Month", "<4: year post is: " + j);
            localObject4 = (AlarmManager)getSystemService("alarm");
            localObject5 = new Intent("android.media.action.DISPLAY_NOTIFICATION");
            ((Intent)localObject5).addCategory("android.intent.category.DEFAULT");
            localObject5 = PendingIntent.getBroadcast(this, 100, (Intent)localObject5, 134217728);
            localCalendar = Calendar.getInstance(TimeZone.getDefault(), Locale.getDefault());
            localCalendar.set(5, 1);
            localCalendar.set(2, i);
            localCalendar.set(1, j);
            localCalendar.set(11, 10);
            localCalendar.set(12, 0);
            localCalendar.set(13, 0);
            if (Build.VERSION.SDK_INT < 19) {
                break label772;
            }
            ((AlarmManager)localObject4).setExact(0, localCalendar.getTimeInMillis(), (PendingIntent)localObject5);
        }
        for (;;)
        {
            ((SharedPreferences.Editor)localObject3).putString("notifydate", String.valueOf(i) + "/01/" + String.valueOf(j)).commit();
            Log.w("NEW ALERT SET DATE", String.valueOf(i) + "/01/" + String.valueOf(j));
            Log.w("Date Calc", "Date specified [" + localObject2 + "] is before today [" + localObject1 + "]");
            return;
            i += 1;
            break;
            label687:
            if (m < 10)
            {
                i = 11;
                j = k;
                Log.w("THIS Month", "<10: year post is: " + j);
                break label427;
            }
            if (m != 11) {
                break label427;
            }
            i = 4;
            j = k + 1;
            Log.w("THIS YEAR (bottom)", "True" + j);
            break label427;
            label772:
            ((AlarmManager)localObject4).set(0, localCalendar.getTimeInMillis(), (PendingIntent)localObject5);
        }
        label788:
        Log.w("Date Calc", "Date specified [" + localObject2 + "] is NOT before today [" + localObject1 + "]");
    }
}
