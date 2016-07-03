package edu.ccbcmd.pathwayguide;





        import android.widget.Button;

        import android.content.Context;

        import android.view.View;
        import android.content.Intent;
        import android.os.Bundle;

        import android.content.SharedPreferences;

        import android.app.Activity;

        import fd.IncrementalChange;

public class alert extends Activity
{
   // public static volatile /* synthetic */ IncrementalChange $change;
    public SharedPreferences prefs;

    public int[] loadArrayInt(final String s) {

        final SharedPreferences sharedPreferences = this.getSharedPreferences("preferencename", 0);
        final int int1 = sharedPreferences.getInt(s + "_size", 0);
        final int[] array = new int[int1];
        for (int i = 0; i < int1; ++i) {
            array[i] = sharedPreferences.getInt(s + "_" + i, 1);
        }
        return array;
    }

    public void onCreate(final Bundle bundle) {

        super.onCreate(bundle);
        this.setContentView(R.layout.activity_alert); //2130968601
        this.prefs = this.getSharedPreferences("com.mycompany.CCBCPathway", 0);
        final int int1 = this.prefs.getInt("pathwayID", -1);
        final int int2 = this.prefs.getInt("pathwaysubID", -1);
        final int int3 = Integer.parseInt(this.prefs.getString("choosenID", "0"));
        final int n = this.loadArrayInt("courseStat")[choosePathway.subpathwayCoursePath[0][int1][int3]];
        final Button button = (Button)this.findViewById(R.id.buttonCollect); //2131624021
        this.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() { //2131624022


            public void onClick(final View view) {

                alert.this.getSharedPreferences("preferencename", 0).edit().putInt("courseStat_" + int3, 0).commit();
                alert.this.startActivity(new Intent(alert.this, (Class)MainActivity.class));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {


            public void onClick(final View view) {

                final SharedPreferences.Editor edit = alert.this.getSharedPreferences("preferencename", 0).edit();
                if (n == 4) {
                    edit.putInt("courseStat_" + int3, 3).commit();
                }
                else {
                    edit.putInt("courseStat_" + int3, 2).commit();
                }
                alert.this.startActivity(new Intent(alert.this, (Class)MainActivity.class));
            }
        });
    }
}
