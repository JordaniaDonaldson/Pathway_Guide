package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;

public class alert
        extends Activity {
    public SharedPreferences prefs;

    public alert() {
    }

    alert(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException) {
        this();
    }

    public int[] loadArrayInt(String paramString) {
        Object localObject = $change;
        if (localObject != null) {
            return (int[]) ((IncrementalChange) localObject).access$dispatch("loadArrayInt.(Ljava/lang/String;)[I", new Object[]{this, paramString});
        }
        localObject = getSharedPreferences("preferencename", 0);
        int j = ((SharedPreferences) localObject).getInt(paramString + "_size", 0);
        int[] arrayOfInt = new int[j];
        int i = 0;
        while (i < j) {
            arrayOfInt[i] = ((SharedPreferences) localObject).getInt(paramString + "_" + i, 1);
            i += 1;
        }
        return arrayOfInt;
    }

    public void onCreate(Bundle paramBundle) {
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null) {
            localIncrementalChange.access$dispatch("onCreate.(Landroid/os/Bundle;)V", new Object[]{this, paramBundle});
            return;
        }
        super.onCreate(paramBundle);
        setContentView(2130968601);
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        final int j = this.prefs.getInt("pathwayID", -1);
        int k = this.prefs.getInt("pathwaysubID", -1);
        final int i = Integer.parseInt(this.prefs.getString("choosenID", "0"));
        j = choosePathway.subpathwayCoursePath[Integer.valueOf(j).intValue()][Integer.valueOf(k).intValue()][i];
        j = loadArrayInt("courseStat")[j];
        paramBundle = (Button) findViewById(2131624021);
        ((Button) findViewById(2131624022)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null) {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[]{this, paramAnonymousView});
                    return;
                }
                alert.this.getSharedPreferences("preferencename", 0).edit().putInt("courseStat_" + i, 0).commit();
                alert.this.startActivity(new Intent(alert.this, MainActivity.class));
            }
        });
        paramBundle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null) {
                    localIncrementalChange.access$dispatch("onClick.(Landroid/view/View;)V", new Object[]{this, paramAnonymousView});
                    return;
                }
                paramAnonymousView = alert.this.getSharedPreferences("preferencename", 0).edit();
                if (j == 4) {
                    paramAnonymousView.putInt("courseStat_" + i, 3).commit();
                }
                for (; ; ) {
                    alert.this.startActivity(new Intent(alert.this, MainActivity.class));
                    return;
                    paramAnonymousView.putInt("courseStat_" + i, 2).commit();
                }
            }
        });
    }
}