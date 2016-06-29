package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;

public class demo_mainActivity_2 extends AppCompatActivity implements View.OnClickListener
{

    public Button b;
    public Button b1;
    public Button b2;
    public Button b3;
    public SharedPreferences prefs;


    private void presentShowcaseSequence(final int delay) {

        final MaterialShowcaseSequence materialShowcaseSequence = new MaterialShowcaseSequence(this);
        materialShowcaseSequence.setOnItemShownListener(new MaterialShowcaseSequence.OnSequenceItemShownListener() {


            public void onShow(final MaterialShowcaseView materialShowcaseView, final int n) {

            }
        });
        materialShowcaseSequence.addSequenceItem(new MaterialShowcaseView.Builder(this).setDelay(delay).setTarget(this.b2).setDismissText("Next").setContentText("Notice ENGL 101 has turned green, indicating you have passed the class!").setTitleText("Good Job!").withRectangleShape().setShapePadding(pxToDp(5)).setMaskColour(Color.parseColor("#F1335075")).build());
        materialShowcaseSequence.start();
    }

    public static int pxToDp(final int n) {

        return (int)(n * Resources.getSystem().getDisplayMetrics().density);
    }

    public void onClick(final View view) {

    }

    public void onCreate(final Bundle bundle) {

        super.onCreate(bundle);
        this.setContentView(R.layout.activity_demo_main_activity_2); //2130968611
        this.getSupportActionBar().hide();
        final Resources resources = this.getResources();
        final LinearLayout linearLayout = (LinearLayout)this.findViewById(R.id.linearLayout2); //2131624046
        this.findViewById(R.id.zoomout).setOnClickListener(new View.OnClickListener() { //2131624047

            public void onClick(final View view) {

            }
        });
        this.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() { //2131624022


            public void onClick(final View view) {

            }
        });
        final float density = this.getResources().getDisplayMetrics().density;
        final int n = (int)(13 * density);
        final int n2 = (int)(2.2 * density);
        (this.b = new Button(this)).setText("ENGL 102");
        this.b.setTextColor(Color.parseColor("#ffffff"));
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.b.setPadding(n, n, n, n);
        this.b.setGravity(16);
        this.b.setGravity(1);
        this.b.setGravity(17);
        this.b.setTextSize(1, 14.0f);
        this.b.setTypeface(null, 1);
        layoutParams.setMargins(n2, n2, n2, n2);
        this.b.setLayoutParams(layoutParams);
        this.b.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
        this.b.setId(0);
        this.b.setBackgroundColor(Color.parseColor("#893f4e"));
        this.b.setOnClickListener(this);
        linearLayout.addView(this.b);
        final LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
        layoutParams2.gravity = Gravity.CENTER; //17
        this.b.setLayoutParams(layoutParams2);
        (this.b1 = new Button(this)).setText("CHEM 101");
        final LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.b1.setPadding(n, n, n, n);
        this.b1.setGravity(16);
        this.b1.setGravity(1);
        this.b1.setGravity(17);
        this.b1.setTextSize(1, 14.0f);
        this.b1.setTypeface(null, 1);
        layoutParams3.setMargins(n2, n2, n2, n2);
        this.b1.setLayoutParams(layoutParams3);
        this.b1.setId(1);
        this.b1.setOnClickListener(new View.OnClickListener() {


            public void onClick(final View view) {

                demo_mainActivity_2.this.startActivity(new Intent(demo_mainActivity_2.this, (Class)demo_info_2.class));
            }
        });
        this.b1.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
        this.b1.setBackgroundColor(Color.parseColor("#fcd054"));
        linearLayout.addView(this.b1);
        final LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams)this.b1.getLayoutParams();
        layoutParams4.gravity = Gravity.CENTER; //17
        this.b1.setLayoutParams(layoutParams4);
        (this.b2 = new Button(this)).setText("ENGL 101");
        this.b2.setTextColor(Color.parseColor("#ffffff"));
        this.b2.setId(2);
        final LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        this.b2.setPadding(n, n, n, n);
        this.b2.setGravity(16);
        this.b2.setGravity(1);
        this.b2.setGravity(17);
        this.b2.setTextSize(1, 14.0f);
        this.b2.setTypeface(null, 1);
        layoutParams5.setMargins(n2, n2, n2, n2);
        this.b2.setLayoutParams(layoutParams5);
        this.b2.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
        this.b2.setBackgroundColor(Color.parseColor("#159b8a"));
        linearLayout.addView(this.b2);
        final LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams)this.b2.getLayoutParams();
        layoutParams6.gravity = Gravity.CENTER; //17
        this.b2.setLayoutParams(layoutParams6);
        this.b2.setOnClickListener(this);
        (this.b3 = new Button(this)).setText("ACDV 101");
        this.b3.setTextColor(Color.parseColor("#ffffff"));
        this.b3.setId(3);
        final LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        this.b3.setPadding(n, n, n, n);
        this.b3.setGravity(16);
        this.b3.setGravity(1);
        this.b3.setGravity(17);
        this.b3.setTextSize(1, 14.0f);
        this.b3.setTypeface(null, 1);
        layoutParams7.setMargins(n2, n2, n2, n2);
        this.b3.setLayoutParams(layoutParams7);
        this.b3.setWidth(Math.round(TypedValue.applyDimension(1, 100.0f, resources.getDisplayMetrics())));
        this.b3.setBackgroundColor(Color.parseColor("#159b8a"));
        linearLayout.addView(this.b3);
        final LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams)this.b3.getLayoutParams();
        layoutParams8.gravity = Gravity.CENTER; //17
        this.b3.setLayoutParams(layoutParams8);
        this.b3.setOnClickListener(this);
        this.presentShowcaseSequence(500);
        this.findViewById(R.id.tv_dismiss).setOnClickListener(new View.OnClickListener() { //2131624083


            public void onClick(final View view) {


                    demo_mainActivity_2.this.prefs = demo_mainActivity_2.this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
                    if (Integer.valueOf(demo_mainActivity_2.this.prefs.getInt("demo", 0)) != 1) {
                        demo_mainActivity_2.this.startActivity(new Intent(demo_mainActivity_2.this, (Class)welcome.class));
                        return;
                    }
                    final Integer value = demo_mainActivity_2.this.prefs.getInt("zoom", 0);
                    if (value == 0) {
                        demo_mainActivity_2.this.startActivity(new Intent(demo_mainActivity_2.this, (Class)MainActivity.class));
                        return;
                    }
                    if (value == 1) {
                        demo_mainActivity_2.this.startActivity(new Intent(demo_mainActivity_2.this, (Class)MainActivityZoomOut.class));
                    }

            }
        });
    }
}
