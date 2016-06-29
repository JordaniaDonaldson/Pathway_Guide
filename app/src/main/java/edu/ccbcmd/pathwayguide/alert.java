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
/*
    public alert() {
        final IncrementalChange $change = alert.$change;
        if ($change != null) {
            final Object[] array = { null };
            array[0] = array;
            this((Object[])$change.access$dispatch("init$args.([Ljava/lang/Object;)Ljava/lang/Object;", array), null);
        }
        else {}
        if ($change != null) {
            $change.access$dispatch("init$body.(Lcom/example/nicholas/buttontest/alert;)V", new Object[] { this });
            return;
        }
        this.prefs = null;
    }

    alert(final Object[] array, final InstantReloadException ex) {
        final String s = (String)array[0];
        switch (s.hashCode()) {
            default: {
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", s, s.hashCode(), "com/example/nicholas/buttontest/alert"));
            }
            case -1230767868: {}
            case 1037210181: {
                this();
            }
        }
    }
*/
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
        final int n = this.loadArrayInt("courseStat")[choosePathway.subpathwayCoursePath[int1][int2][int3]];
        final Button button = (Button)this.findViewById(R.id.buttonCollect); //2131624021
        ((Button)this.findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() { //2131624022


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
