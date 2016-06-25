package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence.OnSequenceItemShownListener;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView.Builder;

public class demo_mainActivity_3
        extends AppCompatActivity
        implements View.OnClickListener
{
    public Button b;
    public Button b1;
    public Button b2;
    public Button b3;

    public demo_mainActivity_3() {}

    demo_mainActivity_3(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
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
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setDelay(paramInt).setTarget(this.b2).setDismissText("Next").setContentText("Notice <put class name here> has turned green, indicating you have passed the class!").setTitleText("Good Job!").withRectangleShape().setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).build());
        ((MaterialShowcaseSequence)localObject).addSequenceItem(new MaterialShowcaseView.Builder(this).setTarget(new View(this)).setDismissText("Let's Go!").setTitleText("Now Try Yourself").setContentText("Try to update <put course name here> to indicate that your are currently taking it!").withRectangleShape().setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).build());
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

    public void onClick(View paramView)
    {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramView });
            return;
        }
        new MaterialShowcaseView.Builder(this).setTarget(this.b1).withRectangleShape().setDismissText("Okay").setTitleText("Click Here").setContentText("Click on <put class name here> to open the classes detail window.").setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).setDelay(100).show();
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
        setContentView(2130968611);
        getSupportActionBar().hide();
        paramBundle = getResources();
        localObject = (LinearLayout)findViewById(2131624046);
        ((Button)findViewById(2131624022)).setOnClickListener(this);
        float f = getResources().getDisplayMetrics().density;
        int i = (int)(13 * f);
        int j = (int)(2.2D * f);
        this.b = new Button(this);
        this.b.setText("CLASS 1");
        this.b.setTextColor(Color.parseColor("#ffffff"));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.b.setPadding(i, i, i, i);
        this.b.setGravity(16);
        this.b.setGravity(1);
        this.b.setGravity(17);
        this.b.setTextSize(1, 14.0F);
        this.b.setTypeface(null, 1);
        localLayoutParams.setMargins(j, j, j, j);
        this.b.setLayoutParams(localLayoutParams);
        this.b.setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, paramBundle.getDisplayMetrics())));
        this.b.setId(0);
        this.b.setBackgroundColor(Color.parseColor("#893f4e"));
        this.b.setOnClickListener(this);
        ((LinearLayout)localObject).addView(this.b);
        localLayoutParams = (LinearLayout.LayoutParams)this.b.getLayoutParams();
        localLayoutParams.gravity = 17;
        this.b.setLayoutParams(localLayoutParams);
        this.b1 = new Button(this);
        this.b1.setText("CLASS 2");
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.b1.setPadding(i, i, i, i);
        this.b1.setGravity(16);
        this.b1.setGravity(1);
        this.b1.setGravity(17);
        this.b1.setTextSize(1, 14.0F);
        this.b1.setTypeface(null, 1);
        localLayoutParams.setMargins(j, j, j, j);
        this.b1.setLayoutParams(localLayoutParams);
        this.b1.setId(1);
        this.b1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View paramAnonymousView)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramAnonymousView });
                    return;
                }
                demo_mainActivity_3.this.startActivity(new Intent(demo_mainActivity_3.this, demo_info_2.class));
            }
        });
        this.b1.setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, paramBundle.getDisplayMetrics())));
        this.b1.setBackgroundColor(Color.parseColor("#644181"));
        ((LinearLayout)localObject).addView(this.b1);
        localLayoutParams = (LinearLayout.LayoutParams)this.b1.getLayoutParams();
        localLayoutParams.gravity = 17;
        this.b1.setLayoutParams(localLayoutParams);
        this.b2 = new Button(this);
        this.b2.setText("CLASS 3");
        this.b2.setTextColor(Color.parseColor("#ffffff"));
        this.b2.setId(2);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.b2.setPadding(i, i, i, i);
        this.b2.setGravity(16);
        this.b2.setGravity(1);
        this.b2.setGravity(17);
        this.b2.setTextSize(1, 14.0F);
        this.b2.setTypeface(null, 1);
        localLayoutParams.setMargins(j, j, j, j);
        this.b2.setLayoutParams(localLayoutParams);
        this.b2.setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, paramBundle.getDisplayMetrics())));
        this.b2.setBackgroundColor(Color.parseColor("#159b8a"));
        ((LinearLayout)localObject).addView(this.b2);
        localLayoutParams = (LinearLayout.LayoutParams)this.b2.getLayoutParams();
        localLayoutParams.gravity = 17;
        this.b2.setLayoutParams(localLayoutParams);
        this.b2.setOnClickListener(this);
        this.b3 = new Button(this);
        this.b3.setText("CLASS 4");
        this.b3.setTextColor(Color.parseColor("#ffffff"));
        this.b3.setId(3);
        localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.b3.setPadding(i, i, i, i);
        this.b3.setGravity(16);
        this.b3.setGravity(1);
        this.b3.setGravity(17);
        this.b3.setTextSize(1, 14.0F);
        this.b3.setTypeface(null, 1);
        localLayoutParams.setMargins(j, j, j, j);
        this.b3.setLayoutParams(localLayoutParams);
        this.b3.setWidth(Math.round(TypedValue.applyDimension(1, 100.0F, paramBundle.getDisplayMetrics())));
        this.b3.setBackgroundColor(Color.parseColor("#159b8a"));
        ((LinearLayout)localObject).addView(this.b3);
        paramBundle = (LinearLayout.LayoutParams)this.b3.getLayoutParams();
        paramBundle.gravity = 17;
        this.b3.setLayoutParams(paramBundle);
        this.b3.setOnClickListener(this);
    }

    public void onResume()
    {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null)
        {
            localIncrementalChange.access$dispatch("onResume.()V", new Object[] { this });
            return;
        }
        super.onResume();
        presentShowcaseSequence(500);
    }
}
