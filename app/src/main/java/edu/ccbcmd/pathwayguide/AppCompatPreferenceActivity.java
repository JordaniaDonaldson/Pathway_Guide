package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



        import android.support.annotation.Nullable;
        import android.support.annotation.LayoutRes;
        import android.support.v7.app.ActionBar;
        import android.view.MenuInflater;
        import android.support.v7.app.AppCompatCallback;

        import android.view.ViewGroup;

        import android.content.res.Configuration;

        import android.app.Activity;

        import android.view.View;

        import android.os.Bundle;

        import android.support.v7.app.AppCompatDelegate;

        import android.preference.PreferenceActivity;

public abstract class AppCompatPreferenceActivity extends PreferenceActivity
{

    private AppCompatDelegate mDelegate;
/*
    public AppCompatPreferenceActivity() {
        final IncrementalChange .change = AppCompatPreferenceActivity..change;
        if (.change != null) {
            final Object[] array = { null };
            array[0] = array;
            this((Object[]).change.access.dispatch("init.args.([Ljava/lang/Object;)Ljava/lang/Object;", array), null);
        }
        else {}
        if (.change != null) {
            .change.access.dispatch("init.body.(Lcom/example/nicholas/buttontest/AppCompatPreferenceActivity;)V", new Object[] { this });
        }
    }

    AppCompatPreferenceActivity(final Object[] array, final InstantReloadException ex) {
        final String s = (String)array[0];
        switch (s.hashCode()) {
            default: {
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", s, s.hashCode(), "com/example/nicholas/buttontest/AppCompatPreferenceActivity"));
            }
            case -1269620170: {
                this();
            }
            case 1824235717: {}
        }
    }
*/
    private AppCompatDelegate getDelegate() {

        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.create((Activity)this, (AppCompatCallback)null);
        }
        return this.mDelegate;
    }

    public void addContentView(final View view, final ViewGroup.LayoutParams viewGroupParams) {

        this.getDelegate().addContentView(view, viewGroupParams);
    }

    public MenuInflater getMenuInflater() {

        return this.getDelegate().getMenuInflater();
    }

    public ActionBar getSupportActionBar() {

        return this.getDelegate().getSupportActionBar();
    }

    public void invalidateOptionsMenu() {

        this.getDelegate().invalidateOptionsMenu();
    }

    public void onConfigurationChanged(final Configuration configuration) {

        super.onConfigurationChanged(configuration);
        this.getDelegate().onConfigurationChanged(configuration);
    }

    public void onCreate(final Bundle bundle) {

        this.getDelegate().installViewFactory();
        this.getDelegate().onCreate(bundle);
        super.onCreate(bundle);
    }

    public void onDestroy() {

        super.onDestroy();
        this.getDelegate().onDestroy();
    }

    public void onPostCreate(final Bundle bundle) {

        super.onPostCreate(bundle);
        this.getDelegate().onPostCreate(bundle);
    }

    public void onPostResume() {

        super.onPostResume();
        this.getDelegate().onPostResume();
    }

    public void onStop() {

        super.onStop();
        this.getDelegate().onStop();
    }

    public void onTitleChanged(final CharSequence title, final int n) {

        super.onTitleChanged(title, n);
        this.getDelegate().setTitle(title);
    }

    public void setContentView(@LayoutRes final int contentView) {

        this.getDelegate().setContentView(contentView);
    }

    public void setContentView(final View contentView) {

        this.getDelegate().setContentView(contentView);
    }

    public void setContentView(final View view, final ViewGroup.LayoutParams viewGroupLayoutParams) {

        this.getDelegate().setContentView(view, viewGroupLayoutParams);
    }

    public void setSupportActionBar(@Nullable final android.support.v7.widget.Toolbar supportActionBar) {

        this.getDelegate().setSupportActionBar(supportActionBar);
    }
}
