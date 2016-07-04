package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



import android.content.res.Resources;
import android.util.Log;
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



                try {
                    this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
                    final int pathID = this.prefs.getInt("pathwayID", -1);
                    Log.w("pathwayID", String.valueOf(pathID));
                    final int length = choosePathway.subpathwayCoursePath[0][view.getId()].length;
                    this.prefs.edit().putInt("pathwaysubID", view.getId()).commit();
                    if (this.prefs.getBoolean("firstrun", true)) {
                        final Intent intent = new Intent(this, (Class)chooseCompletedClasses.class);
                        intent.putExtra("arrayID", String.valueOf(view.getId() - 1)); //figure out what this is used for and why subtract 1?
                        this.startActivity(intent);
                        return;
                    }
                    final Intent intent = new Intent(this, MainActivity.class);
                    this.startActivity(intent);
                }
                catch (ArrayIndexOutOfBoundsException ex) {
                    (this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0)).getInt("pathwayID", -1);
                    Toast.makeText(this, "The Sub-Pathway you selected is not currently available in this app. Please visit ccbcmd.edu/pathways to view more info on this pathway.", Toast.LENGTH_LONG).show(); //1

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
            final Integer pathID = this.prefs.getInt("pathwayID", 0);
            final LinearLayout linearLayout = (LinearLayout)this.findViewById(R.id.linearLayout4); //2131624035
            for (int length = choosePathway.sub_pathwayName[pathID].length, i = 0; i < length; ++i) {
                final Button button = new Button(this);
                button.setOnClickListener(this);
                button.setText(choosePathway.sub_pathwayName[pathID][i]);
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
