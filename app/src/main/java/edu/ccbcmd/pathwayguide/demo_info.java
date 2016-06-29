package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



        import android.graphics.PorterDuff;
        import android.os.Build;

        import java.net.InetAddress;

        import android.webkit.WebSettings;

        import android.webkit.CookieManager;
        import android.util.Log;
        import android.widget.Toast;
        import android.annotation.TargetApi;

        import android.webkit.WebResourceError;

        import android.webkit.WebResourceRequest;

        import android.webkit.WebViewClient;
        import android.webkit.WebView;
        import java.util.Calendar;
        import android.widget.Button;
        import android.graphics.drawable.ColorDrawable;
        import android.graphics.Color;
        import android.widget.TextView;
        import android.content.res.Resources;

        import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

        import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
        import android.graphics.Point;

        import android.graphics.drawable.Drawable;

        import android.view.MenuItem;

        import android.net.Uri;

        import android.graphics.Bitmap;

        import android.app.Activity;
        import android.view.KeyEvent;

        import android.view.View;
        import android.content.Intent;
        import android.os.Bundle;

        import com.github.amlcurran.showcaseview.ShowcaseView;
        import android.content.SharedPreferences;
        import android.widget.ProgressBar;
        import android.content.Context;

        import android.support.v7.app.AppCompatActivity;

public class demo_info extends AppCompatActivity
{

    private Context c;
    private int counter;
    private boolean isConnected;
    private ProgressBar mPbar;
    public SharedPreferences prefs;
    private ShowcaseView showcaseView;

    public demo_info() {

        this.counter = 0;
        this.prefs = null;
        this.mPbar = null;
        this.isConnected = true;
    }



  // public static /* synthetic */ boolean access.000(final demo_info demo_info) {
  //     final IncrementalChange .change = demo_info..change;
 //      if (.change != null) {
 //          return (boolean).change.access.dispatch("access.000.(Lcom/example/nicholas/buttontest/demo_info;)Z", new Object[] { demo_info });
 //      }
 //      return demo_info.isConnected;
 //  }

 //   public static /* synthetic */ ProgressBar access.100(final demo_info demo_info) {
//        final IncrementalChange .change = demo_info..change;
//        if (.change != null) {
 //           return (ProgressBar).change.access.dispatch("access.100.(Lcom/example/nicholas/buttontest/demo_info;)Landroid/widget/ProgressBar;", new Object[] { demo_info });
//        }
 //       return demo_info.mPbar;
 //   }

    private int getScale() {

        final Point point = new Point();
        this.getWindowManager().getDefaultDisplay().getSize(point);
        return (int)(Object) ((point.x / 355.0) * 100.0);
    }

    private void presentShowcaseSequence(final int n) {

        final MaterialShowcaseSequence materialShowcaseSequence = new MaterialShowcaseSequence(this);
        materialShowcaseSequence.setOnItemShownListener(new MaterialShowcaseSequence.OnSequenceItemShownListener() {


            public void onShow(final MaterialShowcaseView materialShowcaseView, final int n) {

            }
        });
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder((Activity)this).setDelay(n).setTarget(this.findViewById(R.id.descriptionwebview)).setDismissText((CharSequence)"Next").setTitleText((CharSequence)"Course Info").setContentText((CharSequence)"Shown here will be the CCBC Catalog listing for the course.").withRectangleShape().build()); //2131624039
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder((Activity)this).setDelay(n).setTarget(new View((Context)this)).setDismissText((CharSequence)"Next").setTitleText((CharSequence)"Course Info").setContentText((CharSequence)"Displaying the course info requires data. You may disable this feature in the menu to prevent using any data. Please note however that the course info will not be displayed.").withRectangleShape().build());
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder((Activity)this).setTarget(this.findViewById(R.id.button)).withRectangleShape().setDismissText((CharSequence)"Next").setContentText((CharSequence)"This button will take you to the CCBC registration page for the course.").build()); //2131624037
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder((Activity)this).setTarget(this.findViewById(R.id.colorChange)).withRectangleShape().setDismissText((CharSequence)"Next").setContentText((CharSequence)"This button will update the course status accordingly. Because this course is currently purple (you are currently taking this course), the course update is asking how you did in the course.").build()); //2131624038
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder((Activity)this).setTarget(new View((Context)this)).withRectangleShape().setDismissText((CharSequence)"Let's Go").setContentText((CharSequence)"Now let's try updating this course to indicate that you passed the course!").build());
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder((Activity)this).setTarget(this.findViewById(R.id.colorChange)).withRectangleShape().setTargetTouchable(true).setTitleText((CharSequence)"Update Course Status").setDismissOnTargetTouch(true).setTargetTouchable(true).setContentText((CharSequence)"Click the button to update the course status").build()); //2131624038
        materialShowcaseSequence.start();
    }

    public static int pxToDp(final int n) {

        return (int)(n * Resources.getSystem().getDisplayMetrics().density);
    }

    public void onActivityResult(final int n, final int n2, final Intent intent) {


            super.onActivityResult(n, n2, intent);
            if (n == 2 && n2 == -1) {
                new MaterialShowcaseView.Builder((Activity)this).setTarget(this.findViewById(R.id.colorChange)).withRectangleShape().setTargetTouchable(true).setTitleText((CharSequence)"Update Course Status").setDismissOnTargetTouch(true).setDismissOnTouch(true).setTargetTouchable(true).setContentText((CharSequence)"Click the button to update the course status").show(); //2131624038
            }

    }

    public void onBackPressed() {

        final Intent intent = new Intent();
        intent.putExtra("edittextvalue", "value_here");
        this.setResult(-1, intent);
        this.finish();
    }

    public void onCreate(final Bundle bundle) {

        super.onCreate(bundle);
        this.setContentView(R.layout.activity_demo_info); //2130968609
        this.mPbar = (ProgressBar)this.findViewById(R.id.progressBar2); //2131624040
        (this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0)).getInt("pathwayID", -1);
        this.prefs.getInt("pathwaysubID", -1);
        final int int1 = Integer.parseInt(this.prefs.getString("choosenID", "0"));
        ((TextView)this.findViewById(R.id.textView)).setText((CharSequence)"Introduction to College Writing"); //2131624036
        this.getSupportActionBar().setTitle((CharSequence)"ENGL 101");
        this.getSupportActionBar().setBackgroundDrawable((Drawable)new ColorDrawable(Color.parseColor("#644181")));
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.getSupportActionBar().setDisplayShowTitleEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        final Button button = (Button)this.findViewById(R.id.button); //2131624037
        final Calendar instance = Calendar.getInstance();
        int value = instance.get(Calendar.YEAR); //1
        int n = instance.get(Calendar.YEAR) % 100; //1
        if (instance.get(Calendar.MONTH) >= 5) { //2
            ++n;
        }
        else {
            --value;
        }
        final String value2 = String.valueOf("http://catalog.ccbcmd.edu/preview_course_incoming.php?catname=Catalog%20" + value + "-" + n + "&prefix=" + "ENGL&code=101");
        this.getSupportActionBar().setHomeButtonEnabled(true);
        final WebView webView = (WebView)this.findViewById(R.id.descriptionwebview); //2131624039
        webView.loadData("<h1>Loading, please wait...</h1>", "text/html", "utf-8");
        webView.setWebViewClient((WebViewClient)new WebViewClient() {


            public void onPageFinished(final WebView webView, final String s) {

                demo_info.access.100(demo_info.this).setVisibility(8); // FIXME: 6/28/2016
            }

            public void onPageStarted(final WebView webView, final String s, final Bitmap bitmap) { // FIXME: 6/28/2016

                demo_info.access.100(demo_info.this).getIndeterminateDrawable().setColorFilter(Color.parseColor("#1ba9d8"), PorterDuff.Mode.MULTIPLY);
                demo_info.access.100(demo_info.this).setVisibility(0);
            }

            public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {

                webView.loadData("<h1 style='font-size:40px'>Connection Time Out</h1><h3>Course Description could not be loaded. Please check your internet connection and try again</h3>", "text/html", "utf-8");
            }

            @TargetApi(23)
            public void onReceivedError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {

                this.onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }

            public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {

                final Calendar instance = Calendar.getInstance();
                int value = instance.get(Calendar.YEAR); //1
                int n = instance.get(Calendar.YEAR) % 100; //1
                if (instance.get(Calendar.MONTH) >= 5) { //2
                    ++n;
                }
                else {
                    --value;
                }
                final String value2 = String.valueOf("http://catalog.ccbcmd.edu/preview_course_incoming.php?catname=Catalog%20" + value + "-" + n + "&prefix=" + choosePathway.courseNum[int1].replace(" ", "&code="));
                final Integer value3 = demo_info.this.prefs.getInt("internet", 1);
                Toast.makeText((Context)demo_info.this, (CharSequence)String.valueOf(value3), Toast.LENGTH_LONG); //1
                if (value3 != 1) {
                    webView.loadData("<h1 >Internet Use Disabled</h1><h3>You have disabled internet. To view course descriptions, go to internet setting's found in the menu.</h3>", "text/html", "utf-8");
                    return true;
                }
                if (!Uri.parse(s).getHost().equals(value2)) {
                    Log.w("Url GOT", s);
                    Log.w("Url3", value2);
                    return true;
                }
                Log.w("Url GOT", s);
                Log.w("Url3", value2);
                if (demo_info.access.000(demo_info.this)) { // FIXME: 6/28/2016
                    return false;
                }
                webView.loadData("<h1 style='font-size:40px'>No Internet Connection</h1><h3>Course Description could not be loaded. Please check your internet connection and try again</h3>", "text/html", "utf-8");
                return true;
            }
        });
        CookieManager.getInstance().setAcceptCookie(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUserAgentString("User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
        webView.getSettings();
        this.getResources();
        final int n2 = (int)(6 * this.getResources().getDisplayMetrics().density);
        webView.setFocusableInTouchMode(false);
        webView.setFocusable(false);
        webView.setScrollContainer(false);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.setScrollbarFadingEnabled(false);
        if (Build.VERSION.SDK_INT >= 19) {
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        }
        else {
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        }
        final Integer value3 = this.prefs.getInt("internet", 1);
        Toast.makeText((Context)this, (CharSequence)String.valueOf(value3), Toast.LENGTH_LONG); //1
        if (value3 == 1) {
            webView.loadUrl(value2);
            Log.w("url:", value2);
        }
        else {
            webView.setInitialScale(this.getScale());
            webView.getSettings().setLoadWithOverviewMode(false);
            webView.getSettings().setUseWideViewPort(false);
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            webView.loadDataWithBaseURL("", "<h1 >Internet Use Disabled</h1><h3>You have disabled internet. To view course descriptions, go to internet setting's found in the menu.</h3>", "text/html", "utf-8", "");
        }
        button.setOnClickListener((View.OnClickListener)new View.OnClickListener() {


            public void onClick(final View view) {

                new MaterialShowcaseView.Builder((Activity)demo_info.this).setTarget(demo_info.this.findViewById(R.id.colorChange)).withRectangleShape().setTargetTouchable(true).setTitleText((CharSequence)"Update Course Status").setDismissOnTargetTouch(true).setDismissOnTouch(true).setTargetTouchable(true).setContentText((CharSequence)"Click the button to update the course status").show(); //2131624038
            }
        });
        final Button button2 = (Button)this.findViewById(R.id.colorChange); //2131624038
        button2.setText((CharSequence)"Class End Results");
        button2.setOnClickListener((View.OnClickListener)new View.OnClickListener() {


            public void onClick(final View view) {

                demo_info.this.startActivityForResult(new Intent((Context)demo_info.this, (Class)demo_alert.class), 2);
            }
        });
        this.presentShowcaseSequence(500);
    }

    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {

        if (Integer.parseInt(Build.VERSION.SDK) > 5 && n == 4 && keyEvent.getRepeatCount() == 0) {
            this.onBackPressed();
            return true;
        }
        return super.onKeyDown(n, keyEvent);
    }

    public boolean onOptionsItemSelected(final MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            default: {
                return super.onOptionsItemSelected(menuItem);
            }
            case 16908332: { // FIXME: 6/28/2016
                this.finish();
                return true;
            }
        }
    }

    public void onResume() {


            super.onResume();
            this.c = (Context)this;
            if (this.c.getSystemService(CONNECTIVITY_SERVICE) != null) { //"connectivity"
                try {
                    if (InetAddress.getByName("google.com").equals("")) {
                        return;
                    }
                }
                catch (Exception ex) {}
            }

    }
}
