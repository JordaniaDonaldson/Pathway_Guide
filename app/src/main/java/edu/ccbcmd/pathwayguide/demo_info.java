package edu.ccbcmd.pathwayguide;




import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
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
import com.github.amlcurran.showcaseview.ShowcaseView;
import java.net.InetAddress;
import java.util.Calendar;
import materialshowcaseview.MaterialShowcaseSequence;
import materialshowcaseview.MaterialShowcaseSequence.OnSequenceItemShownListener;
import materialshowcaseview.MaterialShowcaseView;
import materialshowcaseview.MaterialShowcaseView.Builder;

public class demo_info
        extends AppCompatActivity
{
    private Context c;
    private int counter;
    private boolean isConnected;
    private ProgressBar mPbar;
    public SharedPreferences prefs;
    private ShowcaseView showcaseView;

    public demo_info() {}

    demo_info(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
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

    private void presentShowcaseSequence(int paramInt)
    {
        Object localObject = $change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("presentShowcaseSequence.(I)V", new Object[] { this, new Integer(paramInt) });
            return;
        }
        localObject = new MaterialShowcaseSequence(this);
        ((MaterialShowcaseSequence)localObject).setOnItemShownListener(new MaterialShowcaseSequence.OnSequenceItemShownListener()
        {
            public void onShow(MaterialShowcaseView paramAnonymousMaterialShowcaseView, int paramAnonymousInt)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null) {
                    localIncrementalChange.access$dispatch("onShow.(Luk/co/deanwild/materialshowcaseview/MaterialShowcaseView;I)V", new Object[] { this, paramAnonymousMaterialShowcaseView, new Integer(paramAnonymousInt) });
                }
            }
        });
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setDelay(paramInt).setTarget(findViewById(2131624039)).setDismissText("Next").setTitleText("Course Info").setContentText("Shown here will be the CCBC Catalog listing for the course.").withRectangleShape().build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setDelay(paramInt).setTarget(new View(this)).setDismissText("Next").setTitleText("Course Info").setContentText("Displaying the course info requires data. You may disable this feature in the menu to prevent using any data. Please note however that the course info will not be displayed.").withRectangleShape().build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(findViewById(2131624037)).withRectangleShape().setDismissText("Next").setContentText("This button will take you to the CCBC registration page for the course.").build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(findViewById(2131624038)).withRectangleShape().setDismissText("Next").setContentText("This button will update the course status accordingly. Because this course is currently purple (you are currently taking this course), the course update is asking how you did in the course.").build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(new View(this)).withRectangleShape().setDismissText("Let's Go").setContentText("Now let's try updating this course to indicate that you passed the course!").build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(findViewById(2131624038)).withRectangleShape().setTargetTouchable(true).setTitleText("Update Course Status").setDismissOnTargetTouch(true).setTargetTouchable(true).setContentText("Click the button to update the course status").build());
        ((MaterialShowcaseSequence)localObject).start();
    }

    public static int pxToDp(int paramInt)
    {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null) {
            return ((Number)localIncrementalChange.access$dispatch("pxToDp.(I)I", new Object[] { new Integer(paramInt) })).intValue();
        }
        return (int)(paramInt * Resources.getSystem().getDisplayMetrics().density);
    }

    public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null) {
            localIncrementalChange.access$dispatch("onActivityResult.(IILandroid/content/Intent;)V", new Object[] { this, new Integer(paramInt1), new Integer(paramInt2), paramIntent });
        }
        do
        {
            return;
            super.onActivityResult(paramInt1, paramInt2, paramIntent);
        } while ((paramInt1 != 2) || (paramInt2 != -1));
        new MaterialShowcaseView.Builder(this).setTarget(findViewById(2131624038)).withRectangleShape().setTargetTouchable(true).setTitleText("Update Course Status").setDismissOnTargetTouch(true).setDismissOnTouch(true).setTargetTouchable(true).setContentText("Click the button to update the course status").show();
    }

    public void onBackPressed()
    {
        Object localObject = $change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onBackPressed.()V", new Object[] { this });
            return;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("edittextvalue", "value_here");
        setResult(-1, (Intent)localObject);
        finish();
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
        setContentView(2130968609);
        this.mPbar = ((ProgressBar)findViewById(2131624040));
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        this.prefs.getInt("pathwayID", -1);
        this.prefs.getInt("pathwaysubID", -1);
        final int k = Integer.parseInt(this.prefs.getString("choosenID", "0"));
        ((TextView)findViewById(2131624036)).setText("Introduction to College Writing");
        getSupportActionBar().setTitle("ENGL 101");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#644181")));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        paramBundle = (Button)findViewById(2131624037);
        localObject = Calendar.getInstance();
        int j = ((Calendar)localObject).get(1);
        int i = ((Calendar)localObject).get(1) % 100;
        WebView localWebView;
        if (((Calendar)localObject).get(2) >= 5)
        {
            i += 1;
            localObject = String.valueOf("http://catalog.ccbcmd.edu/preview_course_incoming.php?catname=Catalog%20" + j + "-" + i + "&prefix=" + "ENGL&code=101");
            getSupportActionBar().setHomeButtonEnabled(true);
            localWebView = (WebView)findViewById(2131624039);
            localWebView.loadData("<h1>Loading, please wait...</h1>", "text/html", "utf-8");
            localWebView.setWebViewClient(new WebViewClient()
            {
                public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onPageFinished.(Landroid/webkit/WebView;Ljava/lang/String;)V", new Object[] { this, paramAnonymousWebView, paramAnonymousString });
                        return;
                    }
                    demo_info.access$100(demo_info.this).setVisibility(8);
                }

                public void onPageStarted(WebView paramAnonymousWebView, String paramAnonymousString, Bitmap paramAnonymousBitmap)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onPageStarted.(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V", new Object[] { this, paramAnonymousWebView, paramAnonymousString, paramAnonymousBitmap });
                        return;
                    }
                    demo_info.access$100(demo_info.this).getIndeterminateDrawable().setColorFilter(Color.parseColor("#1ba9d8"), PorterDuff.Mode.MULTIPLY);
                    demo_info.access$100(demo_info.this).setVisibility(0);
                }

                public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
                {
                    IncrementalChange localIncrementalChange = $change;
                    if (localIncrementalChange != null)
                    {
                        localIncrementalChange.access$dispatch("onReceivedError.(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V", new Object[] { this, paramAnonymousWebView, new Integer(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
                        return;
                    }
                    paramAnonymousWebView.loadData("<h1 style='font-size:40px'>Connection Time Out</h1><h3>Course Description could not be loaded. Please check your internet connection and try again</h3>", "text/html", "utf-8");
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
                        Integer localInteger = Integer.valueOf(demo_info.this.prefs.getInt("internet", 1));
                        Toast.makeText(demo_info.this, String.valueOf(localInteger), 1);
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
                    if (demo_info.access$000(demo_info.this)) {
                        return false;
                    }
                    paramAnonymousWebView.loadData("<h1 style='font-size:40px'>No Internet Connection</h1><h3>Course Description could not be loaded. Please check your internet connection and try again</h3>", "text/html", "utf-8");
                    return true;
                    label277:
                    paramAnonymousWebView.loadData("<h1 >Internet Use Disabled</h1><h3>You have disabled internet. To view course descriptions, go to internet setting's found in the menu.</h3>", "text/html", "utf-8");
                    return true;
                }
            });
            CookieManager.getInstance().setAcceptCookie(false);
            localWebView.getSettings().setJavaScriptEnabled(true);
            localWebView.getSettings().setUserAgentString("User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
            localWebView.getSettings();
            getResources();
            float f = getResources().getDisplayMetrics().density;
            i = (int)(6 * f);
            localWebView.setFocusableInTouchMode(false);
            localWebView.setFocusable(false);
            localWebView.setScrollContainer(false);
            localWebView.getSettings().setSupportZoom(true);
            localWebView.getSettings().setBuiltInZoomControls(true);
            localWebView.getSettings().setDisplayZoomControls(false);
            localWebView.setScrollbarFadingEnabled(false);
            if (Build.VERSION.SDK_INT < 19) {
                break label592;
            }
            localWebView.getSettings().setLoadWithOverviewMode(true);
            localWebView.getSettings().setUseWideViewPort(true);
            localWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);

            label479:
            Integer localInteger = Integer.valueOf(this.prefs.getInt("internet", 1));
            Toast.makeText(this, String.valueOf(localInteger), 1);
            if (localInteger.intValue() != 1) {
                break label606;
            }
            localWebView.loadUrl((String)localObject);
            Log.w("url:", (String)localObject);
        }
        for (;;)
        {
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
                    new MaterialShowcaseView.Builder(demo_info.this).setTarget(demo_info.this.findViewById(2131624038)).withRectangleShape().setTargetTouchable(true).setTitleText("Update Course Status").setDismissOnTargetTouch(true).setDismissOnTouch(true).setTargetTouchable(true).setContentText("Click the button to update the course status").show();
                }
            });
            paramBundle = (Button)findViewById(2131624038);
            paramBundle.setText("Class End Results");
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
                    paramAnonymousView = new Intent(demo_info.this, demo_alert.class);
                    demo_info.this.startActivityForResult(paramAnonymousView, 2);
                }
            });
            presentShowcaseSequence(500);
            return;
            j -= 1;
            break;
            label592:
            localWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            break label479;
            label606:
            localWebView.setInitialScale(getScale());
            localWebView.getSettings().setLoadWithOverviewMode(false);
            localWebView.getSettings().setUseWideViewPort(false);
            localWebView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            localWebView.loadDataWithBaseURL("", "<h1 >Internet Use Disabled</h1><h3>You have disabled internet. To view course descriptions, go to internet setting's found in the menu.</h3>", "text/html", "utf-8", "");
        }
    }

    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
    {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null) {
            return ((Boolean)localIncrementalChange.access$dispatch("onKeyDown.(ILandroid/view/KeyEvent;)Z", new Object[] { this, new Integer(paramInt), paramKeyEvent })).booleanValue();
        }
        if ((Integer.parseInt(Build.VERSION.SDK) > 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
        {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null) {
            return ((Boolean)localIncrementalChange.access$dispatch("onOptionsItemSelected.(Landroid/view/MenuItem;)Z", new Object[] { this, paramMenuItem })).booleanValue();
        }
        switch (paramMenuItem.getItemId())
        {
            default:
                return super.onOptionsItemSelected(paramMenuItem);
        }
        finish();
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
