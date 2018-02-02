package com.tencent.mm.loader.stub;

import android.content.Context;
import android.os.Environment;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.File;

public class a {
    public static String bnD = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static String bnE = "/tencent/MicroMsg/";
    public static String bnF = (bnD + bnE);
    public static final String gZJ;
    public static final String gZK = (gZJ + "MicroMsg/");
    public static final String gZL = (gZJ + "files/public/");
    public static String gZM = (bnF + "crash/");

    static {
        Context context = ac.getContext();
        if (context == null) {
            throw new RuntimeException("MMApplicationContext not initialized.");
        }
        gZJ = context.getFilesDir().getParentFile().getAbsolutePath() + "/";
        try {
            File file = new File(gZK);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Error e) {
        }
    }
}
