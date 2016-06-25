package edu.ccbcmd.pathwayguide;

/**
 * Created by dixo8 on 6/24/2016.
 */
import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;

public final class BuildConfig
{
    public static final String APPLICATION_ID = "com.example.nicholas.buttontest";
    public static final String BUILD_TYPE = "debug";
    public static final boolean DEBUG = Boolean.parseBoolean("true");
    public static final String FLAVOR = "";
    public static final int VERSION_CODE = 1;
    public static final String VERSION_NAME = "1.0";

    public BuildConfig() {}

    BuildConfig(Object[] paramArrayOfObject, InstantReloadException paramInstantReloadException)
    {
        this();
    }
}
