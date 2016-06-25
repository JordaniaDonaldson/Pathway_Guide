package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;

public class links
        extends AppCompatActivity
{
    public SharedPreferences prefs;

    public links() {}

    links(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
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
        setContentView(2130968615);
        getSupportActionBar().show();
        getSupportActionBar().setTitle("Links");
        paramBundle = getResources();
        paramBundle = new BitmapDrawable(paramBundle, BitmapFactory.decodeResource(paramBundle, 2130837594));
        getSupportActionBar().setBackgroundDrawable(paramBundle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        ((TextView)findViewById(2131624052)).setVisibility(4);
        this.prefs = getSharedPreferences("com.mycompany.CCBCPathway", 0);
        int i = this.prefs.getInt("pathwayID", 0);
        int j = this.prefs.getInt("pathwaysubID", 0);
        paramBundle = choosePathway.sub_pathwayName[Integer.valueOf(i).intValue()][Integer.valueOf(j).intValue()];
        paramBundle = new ArrayAdapter(this, 2130968621, 2131624052, new String[] { "CCBC", "Blackboard", "My CCBC", "Simon", "Book Store", "Meet With An Advisor", "Resources For Students", "Course Catalog", "Flex-Reg", "Tutoring and Academic Coaching", "Disability Programs and Services" });
        localObject = (ListView)findViewById(2131624050);
        ((ListView)localObject).setAdapter(paramBundle);
        ((ListView)localObject).setClickable(true);
        ((ListView)localObject).setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
                IncrementalChange localIncrementalChange = $change;
                if (localIncrementalChange != null)
                {
                    localIncrementalChange.access$dispatch("onItemClick.(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", new Object[] { this, paramAnonymousAdapterView, paramAnonymousView, new Integer(paramAnonymousInt), new Long(paramAnonymousLong) });
                    return;
                }
                switch (paramAnonymousInt)
                {
                    default:
                        return;
                    case 0:
                        links.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://ccbcmd.edu")));
                        return;
                    case 1:
                        links.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://ccbcmd-bb.blackbaord.com")));
                        return;
                    case 2:
                        links.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://myccbc.ccbcmd.edu/_layouts/ccbc/default.aspx?ReturnUrl=%2f_layouts%2fAuthenticate.aspx%3fSource%3d%252F&Source=%2F")));
                        return;
                    case 3:
                        links.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://simon.ccbcmd.edu/pls/PROD/twbkwbis.P_WWWLogin")));
                        return;
                    case 4:
                        links.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.bookstore.ccbcmd.edu/catonsville/main/")));
                        return;
                    case 5:
                        links.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/resources-for-students/academic-advisement")));
                        return;
                    case 6:
                        links.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/resources-for-students/")));
                        return;
                    case 7:
                        links.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://catalog.ccbcmd.edu/")));
                        return;
                    case 8:
                        links.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/Resources-for-Students/Registering-for-Classes/Flexreg.aspx")));
                        return;
                    case 9:
                        links.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/Resources-for-Students/Tutoring-and-Academic-Coaching.aspx")));
                        return;
                }
                links.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.ccbcmd.edu/Resources-for-Students/Disability-Programs-and-Services.aspx")));
            }
        });
    }
}