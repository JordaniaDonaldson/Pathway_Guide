package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */


import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;
import java.net.InetAddress;
import java.util.Calendar;

public class info
        extends AppCompatActivity
{
    private Context c;
    private boolean isConnected;
    private ProgressBar mPbar;
    public SharedPreferences prefs;

    public info() {}

    info(Object[] paramArrayOfObject)
    {
        this();
    }

    private int getScale()
    {
        Object localObject = $change;
        if (localObject != null) {
            return ((Number)((IncrementalChange)localObject).access$dispatch("getScale.()I", new Object[] { this })).intValue();
        }
        localObject = new Point();
        getWindowManager().getDefaultDisplay().getSize((Point)localObject);
        return Double.valueOf(Double.valueOf(new Double(((Point)localObject).x).doubleValue() / new Double(355.0D).doubleValue()).doubleValue() * 100.0D).intValue();
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

    public void onCreate(Bundle paramBundle)
    {
        Object localObject = $change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
            return;
        }
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_info); //2130968613
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        final int i = this.prefs.getInt("pathwayID", -1);
        int j = this.prefs.getInt("pathwaysubID", -1);
        paramBundle = this.prefs.getString("choosenID", "0");
        this.mPbar = ((ProgressBar)findViewById(R.id.progressBar2)); //2131624040
        final int k = Integer.parseInt(paramBundle);
        ((TextView)findViewById(R.id.textView)).setText(choosePathway.courseName[k]); //2131624036
        getSupportActionBar().setTitle(choosePathway.courseNum[k]);
        final int m = choosePathway.subpathwayCoursePath[Integer.valueOf(i).intValue()][Integer.valueOf(j).intValue()][k];
        paramBundle = loadArrayInt("courseStat");
        int i1 = choosePathway.coursePreRec[m].length;
        Log.w("Prereclangth:", String.valueOf(i1));
        final int n = paramBundle[m];
        if (n == 0)
        {
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#159b8a")));
            i = 0;
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            paramBundle = (Button)findViewById(R.id.button); //2131624037
            if (choosePathway.pageSwitch[m] == 1) {
                paramBundle.setText("Meet with an Adviser");
            }
            paramBundle.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View paramAnonymousView)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                        return;
                    }
                    paramAnonymousView = choosePathway.courseNum[k].replace(" ", "/");
                    if (choosePathway.pageSwitch[m] == 1)
                    {
                        info.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/Resources-for-Students/Academic-Advisement.aspx")));
                        return;
                    }
                    info.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/Programs-and-Courses-Finder/course/" + paramAnonymousView)));
                }
            });
            localObject = (Button)findViewById(2131624038);
            if (i != 0) {
                break label949;
            }
            paramBundle.setVisibility(4);
            ((Button)localObject).setText("I have not successfully completed this class");
            label339:
            ((Button)localObject).setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View paramAnonymousView)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                        return;
                    }
                    if (i == 0)
                    {
                        info.this.getSharedPreferences("preferencename", 0).edit().putInt("courseStat_" + k, 2).commit();
                        info.this.startActivity(new Intent(info.this, MainActivity.class));
                        return;
                    }
                    if (i == 1)
                    {
                        info.this.startActivity(new Intent(info.this, alert.class));
                        return;
                    }
                    if (i == 1)
                    {
                        paramAnonymousView = new AlertDialog.Builder(info.this);
                        paramAnonymousView.setPositiveButton("Class Passed", new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                                IncrementalChange localIncrementalChange = $change;
                                if (localIncrementalChange != null)
                                {
                                    localIncrementalChange.access$dispatch("onClick.(Landroid/content/DialogInterface;I)V", new Object[] { this, paramAnonymous2DialogInterface, new Integer(paramAnonymous2Int) });
                                    return;
                                }
                                info.this.getSharedPreferences("preferencename", 0).edit().putInt("courseStat_" + info.2.this.val$arrayID, 0).commit();
                                info.this.startActivity(new Intent(info.this, MainActivity.class));
                            }
                        });
                        paramAnonymousView.setNegativeButton("Class Failed", new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                            {
                                IncrementalChange localIncrementalChange = $change;
                                if (localIncrementalChange != null)
                                {
                                    localIncrementalChange.access$dispatch("onClick.(Landroid/content/DialogInterface;I)V", new Object[] { this, paramAnonymous2DialogInterface, new Integer(paramAnonymous2Int) });
                                    return;
                                }
                                paramAnonymous2DialogInterface = info.this.getSharedPreferences("preferencename", 0).edit();
                                if (info.2.this.val$currentCourseStatus == 4) {
                                paramAnonymous2DialogInterface.putInt("courseStat_" + info.2.this.val$arrayID, 3).commit();
                            }
                                for (;;)
                                {
                                    info.this.startActivity(new Intent(info.this, MainActivity.class));
                                    return;
                                    paramAnonymous2DialogInterface.putInt("courseStat_" + info.2.this.val$arrayID, 2).commit();
                                }
                            }
                        });
                        paramAnonymousView.setMessage("How did you finish the class?").setTitle("Class Result");
                        paramAnonymousView.create().show();
                        return;
                    }
                    if (i == 3)
                    {
                        info.this.getSharedPreferences("preferencename", 0).edit().putInt("courseStat_" + k, 3).commit();
                        info.this.startActivity(new Intent(info.this, MainActivity.class));
                        return;
                    }
                    paramAnonymousView = info.this.getSharedPreferences("preferencename", 0).edit();
                    if (n == 3) {
                        paramAnonymousView.putInt("courseStat_" + k, 4).commit();
                    }
                    for (;;)
                    {
                        info.this.startActivity(new Intent(info.this, MainActivity.class));
                        return;
                        paramAnonymousView.putInt("courseStat_" + k, 1).commit();
                    }
                }
            });
            paramBundle = Calendar.getInstance();
            j = paramBundle.get(1);
            i = paramBundle.get(1) % 100;
            if (paramBundle.get(2) < 5) {
                break label997;
            }
            i += 1;
            label390:
            paramBundle = choosePathway.courseNum[k].replace(" ", "&code=");
            paramBundle = String.valueOf("http://catalog.ccbcmd.edu/preview_course_incoming.php?catname=Catalog%20" + j + "-" + i + "&prefix=" + paramBundle);
            getSupportActionBar().setHomeButtonEnabled(true);
            localObject = (WebView)findViewById(2131624039);
            ((WebView)localObject).loadData("<h1>Loading, please wait...</h1>", "text/html", "utf-8");
            ((WebView)localObject).setWebViewClient(new WebViewClient()
            {
                public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onPageFinished.(Landroid/webkit/WebView;Ljava/lang/String;)V", new Object[] { this, paramAnonymousWebView, paramAnonymousString });
                        return;
                    }
                    info.access$100(info.this).setVisibility(8);
                }

                public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onPageStarted.(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", new Object[] { this, paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap });
                        return;
                    }
                    info.access$100(info.this).getIndeterminateDrawable().setColorFilter(Color.parseColor("#1ba9d8"), PorterDuff.Mode.MULTIPLY);
                    info.access$100(info.this).setVisibility(0);
                }

                public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onReceivedError.(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V", new Object[] { this, paramAnonymousWebView, new Integer(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
                        return;
                    }
                    paramAnonymousWebView.loadData("<h1 style='font-size:40px'>Connection Time Out</h1><h3>Course Description could not be loaded. Please check your internet connection and try again.</h3>", "text/html", "utf-8");
                }

                @TargetApi(23)
                public void onReceivedError(WebView paramAnonymousWebView, WebResourceRequest paramAnonymousWebResourceRequest, WebResourceError paramAnonymousWebResourceError)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onReceivedError.(Landroid/webkit/WebView;Landroid/webkit/WebResourceRequest;Landroid/webkit/WebResourceError;)V", new Object[] { this, paramAnonymousWebView, paramAnonymousWebResourceRequest, paramAnonymousWebResourceError });
                        return;
                    }
                    onReceivedError(paramAnonymousWebView, paramAnonymousWebResourceError.getErrorCode(), paramAnonymousWebResourceError.getDescription().toString(), paramAnonymousWebResourceRequest.getUrl().toString());
                }

                public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
                {
                    Object localObject = $change;
                    if (localObject != null) {
                        return ((Boolean)((IncrementalChange)localObject).access$dispatch("shouldOverrideUrlLoading.(Landroid/webkit/WebView;Ljava/lang/String;)Z", new Object[] { this, paramAnonymousWebView, paramAnonymousString })).booleanValue();
                    }
                    localObject = Calendar.getInstance();
                    int j = ((Calendar)localObject).get(1);
                    int i = ((Calendar)localObject).get(1) % 100;
                    if (((Calendar)localObject).get(2) >= 5) {
                        i += 1;
                    }
                    for (;;)
                    {
                        localObject = choosePathway.courseNum[k].replace(" ", "&code=");
                        localObject = String.valueOf("http://catalog.ccbcmd.edu/preview_course_incoming.php?catname=Catalog%20" + j + "-" + i + "&prefix=" + (String)localObject);
                        Integer localInteger = Integer.valueOf(info.this.prefs.getInt("internet", 1));
                        Toast.makeText(info.this, String.valueOf(localInteger), 1);
                        if (localInteger.intValue() != 1) {
                            break label277;
                        }
                        if (Uri.parse(paramAnonymousString).getHost().equals(localObject)) {
                            break;
                        }
                        Log.w("Url GOT", paramAnonymousString);
                        Log.w("Url3", (String)localObject);
                        return true;
                        j -= 1;
                    }
                    Log.w("Url GOT", paramAnonymousString);
                    Log.w("Url3", (String)localObject);
                    if (info.access$000(info.this)) {
                        return false;
                    }
                    paramAnonymousWebView.loadData("<h1 style='font-size:40px'>No Internet Connection</h1><h3>Course Description could not be loaded. Please check your internet connection and try again.</h3>", "text/html", "utf-8");
                    return true;
                    label277:
                    paramAnonymousWebView.loadData("<h1 >Internet Use Disabled</h1><h3>You have disabled internet. To view course descriptions, go to internet settings found in the menu.</h3>", "text/html", "utf-8");
                    return true;
                }
            });
            CookieManager.getInstance().setAcceptCookie(false);
            ((WebView)localObject).getSettings().setJavaScriptEnabled(true);
            ((WebView)localObject).getSettings().setUserAgentString("User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
            ((WebView)localObject).getSettings();
            getResources();
            float f = getResources().getDisplayMetrics().density;
            i = (int)(6 * f);
            ((WebView)localObject).setFocusableInTouchMode(false);
            ((WebView)localObject).setFocusable(false);
            ((WebView)localObject).setScrollContainer(false);
            ((WebView)localObject).getSettings().setSupportZoom(true);
            ((WebView)localObject).getSettings().setBuiltInZoomControls(true);
            ((WebView)localObject).getSettings().setDisplayZoomControls(false);
            ((WebView)localObject).setScrollbarFadingEnabled(false);
            if (Build.VERSION.SDK_INT < 19) {
                break label1006;
            }
            ((WebView)localObject).getSettings().setLoadWithOverviewMode(true);
            ((WebView)localObject).getSettings().setUseWideViewPort(true);
            ((WebView)localObject).getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        }
        for (;;)
        {
            i = this.prefs.getInt("internet", 1);
            if (choosePathway.pageSwitch[m] != 1) {
                break label1020;
            }
            ((WebView)localObject).setInitialScale(getScale());
            ((WebView)localObject).getSettings().setLoadWithOverviewMode(false);
            ((WebView)localObject).getSettings().setUseWideViewPort(false);
            ((WebView)localObject).getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            ((WebView)localObject).loadDataWithBaseURL("", choosePathway.courseInfo[k], "text/html", "utf-8", "");
            return;
            if ((n == 1) || (n == 4))
            {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#644181")));
                i = 1;
                break;
            }
            if (n == 3)
            {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcd054")));
                i = 2;
                break;
            }
            if (i1 == 0)
            {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcd054")));
                i = 2;
                Log.w("if/else", "=0");
                break;
            }
            Log.w("if/else", "!=0");
            j = 1;
            i = 0;
            while (i < i1)
            {
                int i2 = paramBundle[choosePathway.coursePreRec[m][i]];
                if ((i2 == 2) || (i2 == 3)) {
                    j = 0;
                }
                i += 1;
            }
            if (j == 1)
            {
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcd054")));
                i = 2;
                break;
            }
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#893f4e")));
            i = 3;
            break;
            label949:
            if (i == 1)
            {
                ((Button)localObject).setText("Class End Results");
                break label339;
            }
            if (i == 2)
            {
                ((Button)localObject).setText("I am currently taking this class");
                break label339;
            }
            if (i != 3) {
                break label339;
            }
            ((Button)localObject).setText("I have permission to take this class");
            break label339;
            label997:
            j -= 1;
            break label390;
            label1006:
            ((WebView)localObject).getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        }
        label1020:
        if (Integer.valueOf(i).intValue() == 1)
        {
            ((WebView)localObject).loadUrl(paramBundle);
            Log.w("url:", paramBundle);
            return;
        }
        ((WebView)localObject).setInitialScale(getScale());
        ((WebView)localObject).getSettings().setLoadWithOverviewMode(false);
        ((WebView)localObject).getSettings().setUseWideViewPort(false);
        ((WebView)localObject).getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        ((WebView)localObject).loadDataWithBaseURL("", "<h1 >Internet Use Disabled</h1><h3>You have disabled internet. To view course descriptions, go to internet settings found in the menu.</h3>", "text/html", "utf-8", "");
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        boolean bool = true;
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null) {
            bool = ((Boolean)localIncrementalChange.access$dispatch("onOptionsItemSelected.(Landroid/view/MenuItem;)Z", new Object[] { this, paramMenuItem })).booleanValue();
        }
        do
        {
            return bool;
            switch (paramMenuItem.getItemId())
            {
                default:
                    return super.onOptionsItemSelected(paramMenuItem);
            }
            paramMenuItem = Integer.valueOf(this.prefs.getInt("zoom", 0));
            if (paramMenuItem.intValue() == 0)
            {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            }
        } while (paramMenuItem.intValue() != 1);
        startActivity(new Intent(this, MainActivityZoomOut.class));
        return true;
    }

    public void onResume()
    {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null) {
            localIncrementalChange.access$dispatch("onResume.()V", new Object[] { this });
        }
        for (;;)
        {
            return;
            super.onResume();
            this.c = this;
            if ((ConnectivityManager)this.c.getSystemService("connectivity") != null) {
                try
                {
                    boolean bool = InetAddress.getByName("google.com").equals("");
                    if (bool) {}
                }
                catch (Exception localException) {}
            }
        }
    }
}