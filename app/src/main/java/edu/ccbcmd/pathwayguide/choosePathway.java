package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */



import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;

public class choosePathway
        extends AppCompatActivity
        implements View.OnClickListener
{
    public static final String[] courseInfo;
    public static final String[] courseName;
    public static final String[] courseNum = { "ACDV 101", "ENGL 101", "Gen. Ed. MATH", "BIOL 110", "PSYC 101", "BIOL 220", "PSYC 103", "CMNS 101", "SOCL 101", "BIOL 230" };
    public static final int[][] coursePreRec;
    public static final int[] pageSwitch = { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 };
    public static final String[] pathwayName = { "Pre-Allied Health", "Technology, Science and Math", "Business, Law and Criminal Justice", "Arts and Humanities", "Behavior and Social Sciences" };
    public static final String[][] sub_pathwayName = { { "Nursing A.S.N.", "Occupational Therapy Assistant A.A.S.", "Dental Hygiene A.A.S.", "Medical Lab. Technology A.A.S.", "Veterinary Technology A.A.S.", "Emergency Medical Technology A.A.S.", "Respiratory Care Therapy A.A.S.", "Radiography A.A.S.", "Radiation Therapy A.A.S.", "Massage Therapy A.A.S.", "Mortuary Science A.A.S.", "Mental Health A.A.S" } };
    public static final int[][][] subpathwayCoursePath = { { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 } } };
    public int[] courseStat;
    public SharedPreferences prefs;

    static
    {
        courseName = new String[] { "Transitioning to college", "English 101", "Gen. Ed. MATH", "Biology I: Molecular and Cells", "Introduction to Psychology", "Human Anatomy and Physiology I", "Principles of Human Growth and Development", "Fundamentals of Communication", "Introduction to Sociology", "Microbiology" };
        courseInfo = new String[] { "Credits: 1\nRecommended Semester: 1st*\n\n*This course may not be required for transfer students. Ask your adviser for more information.", "English 101", "Please meet with your advisor to find out what course(s) you need to take to meet this requirement.", "Biology I: Molecular and Cells", "Introduction to Psychology", "Human Anatomy and Physiology I", "Principles of Human Growth and Development", "Fundamentals of Communication", "Introduction to Sociology", "Microbiology" };
        int[] arrayOfInt1 = new int[0];
        int[] arrayOfInt2 = new int[0];
        int[] arrayOfInt3 = new int[0];
        int[] arrayOfInt4 = new int[0];
        int[] arrayOfInt5 = new int[0];
        int[] arrayOfInt6 = { 3 };
        int[] arrayOfInt7 = new int[0];
        int[] arrayOfInt8 = new int[0];
        int[] arrayOfInt9 = { 3 };
        coursePreRec = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, { 4 }, arrayOfInt7, arrayOfInt8, arrayOfInt9 };
    }

    public choosePathway() {}

    choosePathway(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
    }

    public String[][] load2DArray(String paramString)
    {
        Object localObject = $change;
        if (localObject != null) {
            return (String[][])((IncrementalChange)localObject).access$dispatch("load2DArray.(Ljava/lang/String;)[[Ljava/lang/String;", new Object[] { this, paramString });
        }
        localObject = getSharedPreferences("preferencename", 0);
        int k = ((SharedPreferences)localObject).getInt(paramString + "_size", 0);
        String[][] arrayOfString = new String[k][];
        int i = 0;
        while (i < k)
        {
            int m = ((SharedPreferences)localObject).getInt(paramString + "_size_" + i, 0);
            Log.d("I Loop", String.valueOf(i));
            String[] arrayOfString1 = new String[m];
            int j = 0;
            while (j < m)
            {
                Log.d("T Loop", ((SharedPreferences)localObject).getString(paramString + "_" + i + "_" + j, "hi"));
                arrayOfString1[j] = ((SharedPreferences)localObject).getString(paramString + "_" + i + "_" + j, "hi");
                j += 1;
            }
            arrayOfString[i] = arrayOfString1;
            i += 1;
        }
        return arrayOfString;
    }

    public int[] loadArrayInt(String paramString)
    {
        Object localObject = $change;
        if (localObject != null) {
            return (int[])((IncrementalChange)localObject).access$dispatch("loadArrayInt.(Ljava/lang/String;)[I", new Object[] { this, paramString });
        }
        localObject = getSharedPreferences("preferencename", 0);
        int j = ((SharedPreferences)localObject).getInt(paramString + "_size", 0);
        int[] arrayOfInt = new int[j];
        int i = 0;
        while (i < j)
        {
            arrayOfInt[i] = ((SharedPreferences)localObject).getInt(paramString + "_" + i, 2);
            i += 1;
        }
        return arrayOfInt;
    }

    public void onClick(View paramView)
    {
        Object localObject = $change;
        if (localObject != null)
        {
            ((IncrementalChange)localObject).access$dispatch("onClick.(Landroid/view/View;)V", new Object[] { this, paramView });
            return;
        }
        try
        {
            int i = sub_pathwayName[paramView.getId()].length;
            this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
            this.prefs.edit().putInt("pathwayID", paramView.getId()).commit();
            this.prefs.edit();
            localObject = new Intent(this, chooseSub_Pathway.class);
            ((Intent)localObject).putExtra("arrayID", String.valueOf(paramView.getId()));
            startActivity((Intent)localObject);
            return;
        }
        catch (ArrayIndexOutOfBoundsException paramView)
        {
            Toast.makeText(this, "The Pathway you selected is not currently available in this app. Please visit ccbcmd.edu/pathways to view this pathway.", 1).show();
        }
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
        setContentView(2130968606);
        getSupportActionBar().show();
        getSupportActionBar().setTitle("Choose Your Pathway");
        paramBundle = getResources();
        paramBundle = new BitmapDrawable(paramBundle, BitmapFactory.decodeResource(paramBundle, 2130837594));
        getSupportActionBar().setBackgroundDrawable(paramBundle);
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        label149:
        int i;
        label167:
        LinearLayout.LayoutParams localLayoutParams;
        if (this.prefs.getBoolean("firstrun", true) == true)
        {
            saveArrayInt(this.courseStat, "courseStat");
            getSupportActionBar().setHomeButtonEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            paramBundle = (LinearLayout)findViewById(2131624024);
            int j = pathwayName.length;
            i = 0;
            if (i < j)
            {
                localObject = new Button(this);
                ((Button)localObject).setOnClickListener(this);
                ((Button)localObject).setText(pathwayName[i]);
                localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
                if (i == j) {
                    break label317;
                }
                localLayoutParams.setMargins(5, 5, 5, 5);
            }
        }
        for (;;)
        {
            ((Button)localObject).setLayoutParams(localLayoutParams);
            ((Button)localObject).setTag(Integer.valueOf(i));
            ((Button)localObject).setWidth(Math.round(TypedValue.applyDimension(1, 220.0F, getResources().getDisplayMetrics())));
            ((Button)localObject).setId(i);
            paramBundle.addView((View)localObject);
            localLayoutParams = (LinearLayout.LayoutParams)((Button)localObject).getLayoutParams();
            localLayoutParams.gravity = 17;
            ((Button)localObject).setLayoutParams(localLayoutParams);
            i += 1;
            break label167;
            break;
            getSupportActionBar().setHomeButtonEnabled(true);
            break label149;
            label317:
            localLayoutParams.setMargins(5, 25, 5, 5);
        }
    }

    public boolean onOptionsItemSelected(MenuItem paramMenuItem)
    {
        boolean bool = true;
        IncrementalChange localIncrementalChange = $change;
        if (localIncrementalChange != null) {
            bool = ((Boolean)localIncrementalChange.access$dispatch("onOptionsItemSelected.(Landroid/view/MenuItem;)Z", new Object[] { this, paramMenuItem })).booleanValue();
        }
        do
        {
            return bool;
            switch (paramMenuItem.getItemId())
            {
                default:
                    return super.onOptionsItemSelected(paramMenuItem);
            }
            paramMenuItem = Integer.valueOf(this.prefs.getInt("zoom", 0));
            if (paramMenuItem.intValue() == 0)
            {
                startActivity(new Intent(this, MainActivity.class));
                return true;
            }
        } while (paramMenuItem.intValue() != 1);
        startActivity(new Intent(this, MainActivityZoomOut.class));
        return true;
    }

    public boolean save2DArray(String[][] paramArrayOfString, String paramString)
    {
        Object localObject = $change;
        if (localObject != null) {
            return ((Boolean)((IncrementalChange)localObject).access$dispatch("save2DArray.([[Ljava/lang/String;Ljava/lang/String;)Z", new Object[] { this, paramArrayOfString, paramString })).booleanValue();
        }
        localObject = getSharedPreferences("preferencename", 0).edit();
        ((SharedPreferences.Editor)localObject).putInt(paramString + "_size", paramArrayOfString.length);
        int i = 0;
        while (i < paramArrayOfString.length)
        {
            ((SharedPreferences.Editor)localObject).putInt(paramString + "_size_" + i, paramArrayOfString[i].length);
            int j = 0;
            while (j < paramArrayOfString[i].length)
            {
                ((SharedPreferences.Editor)localObject).putString(paramString + "_" + i + "_" + j, paramArrayOfString[i][j]);
                j += 1;
            }
            i += 1;
        }
        Toast.makeText(this, "Array Has been saved", 1).show();
        return ((SharedPreferences.Editor)localObject).commit();
    }

    public boolean save2DArrayInt(int[][] paramArrayOfInt, String paramString)
    {
        Object localObject = $change;
        if (localObject != null) {
            return ((Boolean)((IncrementalChange)localObject).access$dispatch("save2DArrayInt.([[ILjava/lang/String;)Z", new Object[] { this, paramArrayOfInt, paramString })).booleanValue();
        }
        localObject = getSharedPreferences("preferencename", 0).edit();
        ((SharedPreferences.Editor)localObject).putInt(paramString + "_size", paramArrayOfInt.length);
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
            ((SharedPreferences.Editor)localObject).putInt(paramString + "_size_" + i, paramArrayOfInt[i].length);
            int j = 0;
            while (j < paramArrayOfInt[i].length)
            {
                ((SharedPreferences.Editor)localObject).putInt(paramString + "_" + i + "_" + j, paramArrayOfInt[i][j]);
                j += 1;
            }
            i += 1;
        }
        Toast.makeText(this, "Array Has been saved", 1).show();
        return ((SharedPreferences.Editor)localObject).commit();
    }

    public boolean saveArrayInt(int[] paramArrayOfInt, String paramString)
    {
        Object localObject = $change;
        if (localObject != null) {
            return ((Boolean)((IncrementalChange)localObject).access$dispatch("saveArrayInt.([ILjava/lang/String;)Z", new Object[] { this, paramArrayOfInt, paramString })).booleanValue();
        }
        localObject = getSharedPreferences("preferencename", 0).edit();
        ((SharedPreferences.Editor)localObject).putInt(paramString + "_size", paramArrayOfInt.length);
        int i = 0;
        while (i < paramArrayOfInt.length)
        {
            ((SharedPreferences.Editor)localObject).putInt(paramString + "_" + i, paramArrayOfInt[i]);
            i += 1;
        }
        return ((SharedPreferences.Editor)localObject).commit();
    }
}


