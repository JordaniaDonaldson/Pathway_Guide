package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



import java.net.InetAddress;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.widget.Toast;
        import android.annotation.TargetApi;

        import android.webkit.WebResourceError;

        import android.webkit.WebResourceRequest;

        import android.webkit.WebViewClient;
        import android.webkit.WebView;
        import java.util.Calendar;
import java.util.List;

import android.content.DialogInterface;

        import android.widget.Button;
        import android.graphics.drawable.ColorDrawable;
        import android.graphics.Color;
        import android.util.Log;
        import android.widget.TextView;
        import android.graphics.Point;

        import android.graphics.drawable.Drawable;

        import android.view.MenuItem;

        import android.net.Uri;

        import android.graphics.Bitmap;

        import android.view.View;
        import android.content.Intent;
        import android.os.Bundle;

        import android.content.SharedPreferences;
        import android.widget.ProgressBar;
        import android.content.Context;

        import android.support.v7.app.AppCompatActivity;


public class info extends AppCompatActivity
{

    private Context c;
    private boolean isConnected;
    private ProgressBar mPbar;
    public SharedPreferences prefs;


    public static /* synthetic */ boolean access$000(final info info) {

        return info.isConnected;
    }

    public static /* synthetic */ ProgressBar access$100(final info info) {

        return info.mPbar;
    }


    private int getScale() {

        final Point point = new Point();
        this.getWindowManager().getDefaultDisplay().getSize(point);
        return (int)((point.x / 355.0) * 100.0);
    }

    public int[] loadArrayInt(final String s) {
Log.w("loadArInt string", s);
        final SharedPreferences sharedPreferences = this.getSharedPreferences("preferencename", 0);
        final int int1 = 14; //sharedPreferences.getInt(s + "_size", 0);
        Log.w("loadArInt s+size", String.valueOf(int1));
        final int[] array = new int[int1];
        for (int i = 0; i < int1; ++i) {
            array[i] = sharedPreferences.getInt(s + "_" + i, 1);
        }
        return array;
    }

    public void onCreate(final Bundle bundle) {

        super.onCreate(bundle);
        this.setContentView(R.layout.activity_info); //2130968613

        final List<CourseClass> classesList = MainActivity.courseClassLoader.loadClassObjects();

        this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
        final int pathID = this.prefs.getInt("pathwayID", -1);
        final int pathSubID = this.prefs.getInt("pathwaysubID", -1);
        final String string = this.prefs.getString("choosenID", "0");
        this.mPbar = (ProgressBar)this.findViewById(R.id.progressBar2); //2131624040
        final int int3 = Integer.parseInt(string);
        ((TextView)this.findViewById(R.id.textView)).setText(classesList.get(int3).getFullTitle()); //2131624036
        this.getSupportActionBar().setTitle(classesList.get(int3).getTitle());

        //This is where we are setting the color of the dialog box.
        final int n =  int3; // choosePathway.subpathwayCoursePath[0][pathID][int3];
        final int[] loadArrayInt = this.loadArrayInt("courseStat");
        //final int length = choosePathway.coursePreRec[pathID][n].length;
        //Log.w("Prereclength:", String.valueOf(length));
        //Log.w("n value", String.valueOf(n));


        final int n2 = loadArrayInt[n];
        final int n3;
        if (classesList.get(int3).getDone()) {
            this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#159b8a"))); //Green
            n3 = 0;
        }
        else if (classesList.get(int3).getInProgress()) {
            this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#644181"))); //Purple
            n3 = 1;
        }
        else if (classesList.get(int3).getIsOpenForRegistration()) {
            this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcd054"))); //Yellow
            n3 = 2;
        }
        //else if (length == 0) {
        //    this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcd054"))); //Yello
        //    n3 = 2;
        //    Log.w("if/else", "=0");
        //}
        else {
            Log.w("if/else", "!=0");
            int n4 = 1;
            //for (int i = 0; i < length; ++i) {
              //  final int n5 = loadArrayInt[choosePathway.coursePreRec[pathID][n][i]];
               // if (n5 == 2 || n5 == 3) {
                //    n4 = 0;
                //}
            //}
            //if (n4 == 1) {
            //    this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#fcd054")));
            //    n3 = 2;
            //}
            //else {
                this.getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#893f4e"))); //RED
                n3 = 3;
            //}
        }
        this.getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.getSupportActionBar().setDisplayShowTitleEnabled(true);
        this.getSupportActionBar().setHomeButtonEnabled(true);
        final Button button = (Button) findViewById(R.id.button); //2131624037
        if (classesList.get(int3).getAnyPreReqs()) {
            button.setText("Meet with an Adviser");
        }
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(final View view) {

                final String replace = MainActivity.courseClassLoader.loadClassObjects().get(int3).getTitle().replace(" ", "/");

                if (choosePathway.pageSwitch[n] == 1) {
                    info.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/Resources-for-Students/Academic-Advisement.aspx")));
                    return;
                }
                info.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/Programs-and-Courses-Finder/course/" + replace)));
            }
        });
        final Button button2 = (Button)this.findViewById(R.id.colorChange); //2131624038
        if (n3 == 0) {
            button.setVisibility(View.INVISIBLE); //4
            button2.setText("I have not successfully completed this class");

        }
        else if (n3 == 1) {
            button2.setText("Class End Results");
        }
        else if (n3 == 2) {
            button2.setText("I am currently taking this class");
        }
        else if (n3 == 3) {
            button2.setText("I have permission to take this class");
        }
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(final View view) {
            //TODO: PUT IN SAVE FUNCTIONALITY FOR MY DATA STRUCTURE!!!
                if (n3 == 0) {
                    info.this.getSharedPreferences("preferencename", 0).edit().putInt("courseStat_" + int3, 2).commit();
                    info.this.startActivity(new Intent(info.this, (Class)MainActivity.class));
                    return;
                }
                if (n3 == 1) {
                    info.this.startActivity(new Intent(info.this, (Class)alert.class));
                    return;
                }
                if (n3 == 1) {
                    final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(info.this);
                    alertDialogBuilder.setPositiveButton("Class Passed", new DialogInterface.OnClickListener() {


                        public void onClick(final DialogInterface dialogInterface, final int n) {

                            info.this.getSharedPreferences("preferencename", 0).edit().putInt("courseStat_" + int3, 0).commit();
                            info.this.startActivity(new Intent(info.this, (Class)MainActivity.class));
                        }
                    });
                    alertDialogBuilder.setNegativeButton("Class Failed", new DialogInterface.OnClickListener() {


                        public void onClick(final DialogInterface dialogInterface, final int n) {

                            final SharedPreferences.Editor edit = info.this.getSharedPreferences("preferencename", 0).edit();
                            if (n2 == 4) {
                                edit.putInt("courseStat_" + int3, 3).commit();
                            }
                            else {
                                edit.putInt("courseStat_" + int3, 2).commit();
                            }
                            info.this.startActivity(new Intent(info.this, (Class)MainActivity.class));
                        }
                    });
                    alertDialogBuilder.setMessage("How did you finish the class?").setTitle("Class Result");
                    alertDialogBuilder.create().show();
                    return;
                }
                if (n3 == 3) {
                    info.this.getSharedPreferences("preferencename", 0).edit().putInt("courseStat_" + int3, 3).commit();
                    info.this.startActivity(new Intent(info.this, (Class)MainActivity.class));
                    return;
                }
                final SharedPreferences.Editor edit = info.this.getSharedPreferences("preferencename", 0).edit();
                if (n2 == 3) {
                    edit.putInt("courseStat_" + int3, 4).commit();
                }
                else {
                    edit.putInt("courseStat_" + int3, 1).commit();
                }
                info.this.startActivity(new Intent(info.this, (Class)MainActivity.class));
            }
        });
        final Calendar instance = Calendar.getInstance();
        int value = instance.get(Calendar.YEAR); //1
        int n6 = instance.get(Calendar.YEAR) % 100;
        if (instance.get(Calendar.MONTH) >= 5) { //5
            ++n6;
        }
        else {
            --value;
        }
        final String value2 = String.valueOf("http://catalog.ccbcmd.edu/preview_course_incoming.php?catname=Catalog%20" + value + "-" + n6 + "&prefix=" + classesList.get(int3).getTitle().replace(" ", "&code="));
        this.getSupportActionBar().setHomeButtonEnabled(true);
        final WebView webView = (WebView)this.findViewById(R.id.descriptionwebview);
        webView.loadData("<h1>Loading, please wait...</h1>", "text/html", "utf-8");
        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(final WebView webView, final String s) {

                info.access$100(info.this).setVisibility(View.GONE); //8
            }

            public void onPageStarted(final WebView webView, final String s, final Bitmap bitmap) {

                info.access$100(info.this).getIndeterminateDrawable().setColorFilter(Color.parseColor("#1ba9d8"), PorterDuff.Mode.MULTIPLY);
                info.access$100(info.this).setVisibility(View.VISIBLE); //0
            }

            public void onReceivedError(final WebView webView, final int n, final String s, final String s2) {

                webView.loadData("<h1 style='font-size:40px'>Connection Time Out</h1><h3>Course Description could not be loaded. Please check your internet connection and try again.</h3>", "text/html", "utf-8");
            }

            @TargetApi(23)
            public void onReceivedError(final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceError webResourceError) {

                this.onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
            }

            public boolean shouldOverrideUrlLoading(final WebView webView, final String s) {

                final Calendar instance = Calendar.getInstance();
                int value = instance.get(Calendar.YEAR); //1
                int n = instance.get(Calendar.YEAR) % 100; //1
                if (instance.get(Calendar.MONTH) >= 5) {  //2
                    ++n;
                }
                else {
                    --value;
                }
                final String value2 = String.valueOf("http://catalog.ccbcmd.edu/preview_course_incoming.php?catname=Catalog%20" + value + "-" + n + "&prefix=" + classesList.get(int3).getTitle().replace(" ", "&code="));
                final Integer value3 = info.this.prefs.getInt("internet", 1);
                Toast.makeText(info.this, String.valueOf(value3), Toast.LENGTH_LONG);
                if (value3 != 1) {
                    webView.loadData("<h1 >Internet Use Disabled</h1><h3>You have disabled internet. To view course descriptions, go to internet settings found in the menu.</h3>", "text/html", "utf-8");
                    return true;
                }
                if (!Uri.parse(s).getHost().equals(value2)) {
                    Log.w("Url GOT", s);
                    Log.w("Url3", value2);
                    return true;
                }
                Log.w("Url GOT", s);
                Log.w("Url3", value2);
                if (info.access$000(info.this)) {
                    return false;
                }
                webView.loadData("<h1 style='font-size:40px'>No Internet Connection</h1><h3>Course Description could not be loaded. Please check your internet connection and try again.</h3>", "text/html", "utf-8");
                return true;
            }
        });
        CookieManager.getInstance().setAcceptCookie(false);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUserAgentString("User-Agent: Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
        webView.getSettings();
        this.getResources();
        final int n7 = (int)(6 * this.getResources().getDisplayMetrics().density);
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
        final int int4 = this.prefs.getInt("internet", 1);
        if (classesList.get(int3).getIsOpenForRegistration()) {
            webView.setInitialScale(this.getScale());
            webView.getSettings().setLoadWithOverviewMode(false);
            webView.getSettings().setUseWideViewPort(false);
            webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            webView.loadDataWithBaseURL("", classesList.get(int3).getUrl(), "text/html", "utf-8", "");
            return;
        }
        if (int4 == 1) {
            webView.loadUrl(value2);
            Log.w("url:", value2);
            return;
        }
        webView.setInitialScale(this.getScale());
        webView.getSettings().setLoadWithOverviewMode(false);
        webView.getSettings().setUseWideViewPort(false);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.loadDataWithBaseURL("", "<h1 >Internet Use Disabled</h1><h3>You have disabled internet. To view course descriptions, go to internet settings found in the menu.</h3>", "text/html", "utf-8", "");
    }

    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        boolean booleanValue = true;


            switch (menuItem.getItemId()) {
                default: {
                    return super.onOptionsItemSelected(menuItem);
                }

                case 16908332: {
                    final Integer value = this.prefs.getInt("zoom", 0);
                    if (value == 0) {
                        this.startActivity(new Intent(this, (Class)MainActivity.class));
                        return true;
                    }
                    if (value == 1) {
                        this.startActivity(new Intent(this, (Class)MainActivityZoomOut.class));
                        return true;
                    }
                    break;
                }
            }

        return booleanValue;
    }

    public void onResume() {


            super.onResume();
            this.c = this;
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