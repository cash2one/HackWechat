package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;

public final class as {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";

    private static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            return "null";
        }
    }

    private static String b() {
        try {
            return VERSION.RELEASE;
        } catch (Throwable th) {
            return "null";
        }
    }

    private static String b(Context context) {
        int i = 0;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i2 = packageInfo.versionCode;
            if (str == null || str.trim().length() <= 0) {
                return String.valueOf(i2);
            }
            String replace = str.trim().replace('\n', ' ').replace('\r', ' ').replace("|", "%7C");
            char[] toCharArray = replace.toCharArray();
            for (char c : toCharArray) {
                if (c == '.') {
                    i++;
                }
            }
            return i < 3 ? replace + "." + i2 : replace;
        } catch (Throwable th) {
            return "";
        }
    }

    private static String c() {
        try {
            return VERSION.SDK;
        } catch (Throwable th) {
            return "null";
        }
    }

    private static String d() {
        String str = null;
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            return str;
        }
    }

    public static void a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a());
        stringBuffer.append(";Android ");
        stringBuffer.append(b());
        stringBuffer.append(",level ");
        stringBuffer.append(c());
        a = stringBuffer.toString();
        b = b(context);
        context.getPackageName();
        c = d();
        d = a();
    }
}
