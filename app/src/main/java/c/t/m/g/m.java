package c.t.m.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.SystemClock;

public final class m {
    public static String a = "null";
    public static String b = "";
    public static int c = 0;
    public static String d = "";
    public static String e = "";
    public static int f = -1;
    public static boolean g = true;
    private static Context h = null;
    private static String i;
    private static long j;
    private static int k = 0;
    private static boolean l = false;
    private static String m = "";
    private static String n = "3.4.1.2";
    private static String o = "";
    private static boolean p = false;
    private static String q = "";
    private static Handler r;
    private static volatile boolean s = false;

    public static Context a() {
        return h;
    }

    public static void a(int i, b bVar, String str) {
        j = SystemClock.elapsedRealtime();
        f = Process.myPid();
        Context context = bVar.a;
        h = context.getApplicationContext();
        m = context.getPackageName();
        k = i;
        l = bVar.c;
        String str2 = bVar.d;
        if (cg.a(str2)) {
            str2 = "";
        }
        d = str2;
        str2 = bVar.e;
        if (cg.a(str2)) {
            str2 = "";
        }
        e = str2;
        n = "3.4.1.2";
        Handler handler = new Handler(h.getMainLooper());
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            a = packageInfo.versionName;
            c = packageInfo.versionCode;
            b = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
        }
        o = str;
        p = m.equals(o);
        i = cg.d();
        HandlerThread handlerThread = new HandlerThread("HalleyTempTaskThread");
        handlerThread.start();
        r = new Handler(handlerThread.getLooper());
        p.a();
        Runnable adVar = new ad("after initSDKBaseInfo");
        if (r != null) {
            try {
                r.post(adVar);
                return;
            } catch (Throwable th2) {
                return;
            }
        }
        adVar.run();
    }

    public static int b() {
        return k;
    }

    public static String c() {
        return i;
    }

    public static int d() {
        return (int) (SystemClock.elapsedRealtime() - j);
    }

    public static String e() {
        return m;
    }

    public static boolean f() {
        return l;
    }

    public static String g() {
        return n;
    }

    public static String h() {
        if (!cg.a(q)) {
            return q;
        }
        if (cg.a(o) || !o.contains(":")) {
            return "";
        }
        return o.substring(o.indexOf(":") + 1);
    }

    public static Handler i() {
        return r;
    }
}
