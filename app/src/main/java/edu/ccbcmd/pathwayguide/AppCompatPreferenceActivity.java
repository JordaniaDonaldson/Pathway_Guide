package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */

import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import fd.IncrementalChange;
import fd.InstantReloadException;

public abstract class AppCompatPreferenceActivity
        extends PreferenceActivity
{
    private AppCompatDelegate mDelegate;

    public AppCompatPreferenceActivity() {}

    AppCompatPreferenceActivity(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {}

    private AppCompatDelegate getDelegate()
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null) {
            return (AppCompatDelegate)localIncrementalChange.access$dispatch("getDelegate.()Landroid/support/v7/app/AppCompatDelegate;", new Object[] { this });
        }
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.create(this, null);
        }
        return this.mDelegate;
    }

    public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("addContentView.(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", new Object[] { this, paramView, paramLayoutParams });
            return;
        }
        getDelegate().addContentView(paramView, paramLayoutParams);
    }

    public MenuInflater getMenuInflater()
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null) {
            return (MenuInflater)localIncrementalChange.access$dispatch("getMenuInflater.()Landroid/view/MenuInflater;", new Object[] { this });
        }
        return getDelegate().getMenuInflater();
    }

    public ActionBar getSupportActionBar()
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null) {
            return (ActionBar)localIncrementalChange.access$dispatch("getSupportActionBar.()Landroid/support/v7/app/ActionBar;", new Object[] { this });
        }
        return getDelegate().getSupportActionBar();
    }

    public void invalidateOptionsMenu()
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("invalidateOptionsMenu.()V", new Object[] { this });
            return;
        }
        getDelegate().invalidateOptionsMenu();
    }

    public void onConfigurationChanged(Configuration paramConfiguration)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onConfigurationChanged.(Landroid/content/res/Configuration;)V", new Object[] { this, paramConfiguration });
            return;
        }
        super.onConfigurationChanged(paramConfiguration);
        getDelegate().onConfigurationChanged(paramConfiguration);
    }

    public void onCreate(Bundle paramBundle)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
            return;
        }
        getDelegate().installViewFactory();
        getDelegate().onCreate(paramBundle);
        super.onCreate(paramBundle);
    }

    public void onDestroy()
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onDestroy.()V", new Object[] { this });
            return;
        }
        super.onDestroy();
        getDelegate().onDestroy();
    }

    public void onPostCreate(Bundle paramBundle)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onPostCreate.(Landroid/os/Bundle;)V", new Object[] { this, paramBundle });
            return;
        }
        super.onPostCreate(paramBundle);
        getDelegate().onPostCreate(paramBundle);
    }

    public void onPostResume()
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onPostResume.()V", new Object[] { this });
            return;
        }
        super.onPostResume();
        getDelegate().onPostResume();
    }

    public void onStop()
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onStop.()V", new Object[] { this });
            return;
        }
        super.onStop();
        getDelegate().onStop();
    }

    public void onTitleChanged(CharSequence paramCharSequence, int paramInt)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onTitleChanged.(Ljava/lang/CharSequence;I)V", new Object[] { this, paramCharSequence, new Integer(paramInt) });
            return;
        }
        super.onTitleChanged(paramCharSequence, paramInt);
        getDelegate().setTitle(paramCharSequence);
    }

    public void setContentView(@LayoutRes int paramInt)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("setContentView.(I)V", new Object[] { this, new Integer(paramInt) });
            return;
        }
        getDelegate().setContentView(paramInt);
    }

    public void setContentView(View paramView)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("setContentView.(Landroid/view/View;)V", new Object[] { this, paramView });
            return;
        }
        getDelegate().setContentView(paramView);
    }

    public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("setContentView.(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V", new Object[] { this, paramView, paramLayoutParams });
            return;
        }
        getDelegate().setContentView(paramView, paramLayoutParams);
    }

    public void setSupportActionBar(@Nullable Toolbar paramToolbar)
    {
        IncrementalChange localIncrementalChange = IncrementalChange.$change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("setSupportActionBar.(Landroid/support/v7/widget/Toolbar;)V", new Object[] { this, paramToolbar });
            return;
        }
        getDelegate().setSupportActionBar(paramToolbar);
    }
}