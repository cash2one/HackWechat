package com.d.a.a;

import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class o {
    private static String bju;
    private static final SimpleDateFormat bjv = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", Locale.US);
    private static final SimpleDateFormat bjw = new SimpleDateFormat("yyyMMddHHmmss", Locale.US);

    protected static boolean o(String str, String str2) {
        String str3 = null;
        if (bju == null) {
            boolean z;
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(Environment.getExternalStorageDirectory() + "/" + y.bmN);
                boolean exists = file.exists();
                if (!exists) {
                    exists = file.mkdir();
                }
                if (exists) {
                    str3 = file.toString();
                }
                bju = str3;
                z = exists;
            } else {
                bju = null;
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(bju + "/" + str + ".txt", true);
            fileWriter.write("\n" + bjv.format(new Date()) + ',' + str2);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected static String sb() {
        return bjw.format(new Date());
    }
}
