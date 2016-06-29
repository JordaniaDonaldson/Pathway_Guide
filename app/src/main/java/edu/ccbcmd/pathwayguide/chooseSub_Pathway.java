package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



import android.content.res.Resources;
import android.util.TypedValue;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import android.graphics.drawable.Drawable;

import android.content.Context;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;

import android.content.SharedPreferences;

import android.support.v7.app.AppCompatActivity;

public class chooseSub_Pathway extends AppCompatActivity implements View.OnClickListener
{

    public SharedPreferences prefs;



    public void onClick(final View view) {

        while (true) { // FIXME: 6/29/2016 is this structure intended?
            while (true) {
                try {
                    this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
                    final int length = choosePathway.subpathwayCoursePath[this.prefs.getInt("pathwayID", -1)][view.getId()].length;
                    this.prefs.edit().putInt("pathwaysubID", view.getId()).commit();
                    if (this.prefs.getBoolean("firstrun", true)) {
                        final Intent intent = new Intent(this, (Class)chooseCompletedClasses.class);
                        intent.putExtra("arrayID", String.valueOf(view.getId() - 1));
                        this.startActivity(intent);
                        return;
                    }
                }
                catch (ArrayIndexOutOfBoundsException ex) {
                    (this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0)).getInt("pathwayID", -1);
                    Toast.makeText(this, "The Sub-Pathway you selected is not currently available in this app. Please visit ccbcmd.edu/pathways to view more info on this pathway.", Toast.LENGTH_LONG).show(); //1
                    return;
                }
                final Intent intent = new Intent(this, (Class)MainActivity.class);
                continue;
            }
        }
    }

    public void onCreate(final Bundle bundle) {


            super.onCreate(bundle);
            this.setContentView(R.layout.activity_choose_sub__pathway); //2130968607
            this.getSupportActionBar().show();
            this.getSupportActionBar().setTitle("Choose Your Pathway");
            this.getSupportActionBar().setHomeButtonEnabled(true);
            final Resources resources = this.getResources();
            this.getSupportActionBar().setBackgroundDrawable(new BitmapDrawable(resources, BitmapFactory.decodeResource(resources, R.drawable.header ))); //2130837594
            this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
            final Integer value = this.prefs.getInt("pathwayID", -1);
            final LinearLayout linearLayout = (LinearLayout)this.findViewById(R.id.linearLayout4); //2131624035
            for (int length = choosePathway.sub_pathwayName[value].length, i = 0; i < length; ++i) {
                final Button button = new Button(this);
                button.setOnClickListener(this);
                button.setText(choosePathway.sub_pathwayName[value][i]);
                final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins(5, 5, 5, 5);
                button.setLayoutParams(layoutParams);
                button.setTag(i);
                button.setWidth(Math.round(TypedValue.applyDimension(1, 220.0f, this.getResources().getDisplayMetrics())));
                button.setId(i);
                linearLayout.addView(button);
                final LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)button.getLayoutParams();
                layoutParams2.gravity = Gravity.CENTER; //17
                button.setLayoutParams(layoutParams2);
            }

    }
}
