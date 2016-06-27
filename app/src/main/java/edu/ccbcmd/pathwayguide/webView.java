package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */


import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;
import java.net.InetAddress;

public class webView
        extends AppCompatActivity
{
    private Context c;
    private boolean isConnected;

    public webView() {}

    webView(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
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
        setContentView(R.layout.activity_web_view); //2130968623
        paramBundle = getIntent().getStringExtra("url");
        getSupportActionBar().setHomeButtonEnabled(true);
        localObject = (WebView)findViewById(R.id.webView); //2131624059
        ((WebView)localObject).setWebViewClient(new WebViewClient()
        {
            public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onReceivedError.(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V", new Object[] { this, paramAnonymousWebView, new Integer(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2 });
                    return;
                }
                paramAnonymousWebView.loadData("<h1 style='font-size:40px'>MESSAGE 2</h1><h4>Course Description could not be loaded. Please check your internet connection and try again</h4>", "text/html", "utf-8");
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
                boolean bool = false;
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null) {
                    bool = ((Boolean)localIncrementalChange.access$dispatch("shouldOverrideUrlLoading.(Landroid/webkit/WebView;Ljava/lang/String;)Z", new Object[] { this, paramAnonymousWebView, paramAnonymousString })).booleanValue();
                }
                while (webView.access$000(webView.this)) {
                    return bool;
                }
                paramAnonymousWebView.loadData("<h1>MESSAGE 1</h1><h4>Course Description could not be loaded. Please check your internet connection and try again</h4>", "text/html", "utf-8");
                return true;
            }
        });
        ((WebView)localObject).getSettings().setJavaScriptEnabled(true);
        ((WebView)localObject).setScrollContainer(false);
        ((WebView)localObject).getSettings().setSupportZoom(true);
        ((WebView)localObject).getSettings().setBuiltInZoomControls(true);
        ((WebView)localObject).getSettings().setDisplayZoomControls(false);
        ((WebView)localObject).setScrollbarFadingEnabled(false);
        if (Build.VERSION.SDK_INT >= 19)
        {
            ((WebView)localObject).getSettings().setLoadWithOverviewMode(true);
            ((WebView)localObject).getSettings().setUseWideViewPort(true);
            ((WebView)localObject).getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        }
        for (;;)
        {
            ((WebView)localObject).getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/4.0");
            ((WebView)localObject).loadUrl(paramBundle);
            Log.w("url:", paramBundle);
            return;
            ((WebView)localObject).getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        }
    }

    public void onResume()
    {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null) {
            localIncrementalChange.access$dispatch("onResume.()V", new Object[] { this });
        }
        do
        {
            return;
            super.onResume();
            this.c = this;
        } while ((ConnectivityManager)this.c.getSystemService("connectivity") == null);
        try
        {
            if (InetAddress.getByName("google.com").equals(""))
            {
                this.isConnected = false;
                return;
            }
        }
        catch (Exception localException)
        {
            this.isConnected = false;
            return;
        }
        this.isConnected = true;
    }
}
