package c.t.m.g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import java.util.HashMap;

public class ck {
    private static String b = ("ACTION." + ck.class.getSimpleName() + "." + System.nanoTime());
    private static ck c = null;
    private static Context d = null;
    public cj a = null;
    private volatile boolean e = false;
    private PendingIntent f = null;
    private a g = null;

    private ck() {
        if (d == null || d.getApplicationContext() == null) {
            throw new IllegalStateException("Please invoke initial(context,...) first when app started!");
        }
        try {
            b = d.getPackageName() + ".cc." + System.nanoTime();
        } catch (Throwable th) {
        }
        this.g = new a(this, (byte) 0);
        this.f = PendingIntent.getBroadcast(d, 0, i(), 134217728);
    }

    public static void a(HashMap<String, String> hashMap) {
        cl.a(hashMap);
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || context.getApplicationContext() == null) {
            throw new NullPointerException("context cannot be null!");
        }
        Context applicationContext = context.getApplicationContext();
        d = applicationContext;
        cm.a(applicationContext, str);
        cl.a(str, str2);
        new 1().start();
    }

    public static void a(String str) {
        cl.a(str);
    }

    public static synchronized ck a() {
        ck ckVar;
        synchronized (ck.class) {
            if (c == null) {
                synchronized (ck.class) {
                    if (c == null) {
                        c = new ck();
                    }
                }
            }
            ckVar = c;
        }
        return ckVar;
    }

    public final synchronized void b() {
        if (!this.e) {
            this.e = true;
            ch.a("CC_", "startUp()");
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(b);
                d.registerReceiver(this.g, intentFilter);
                a(true);
            } catch (Throwable th) {
            }
        }
    }

    public final synchronized void c() {
        if (this.e) {
            this.e = false;
            try {
                cl.a().d.clear();
                ch.a("CC_", "shutdown:pull immediately");
                a(0);
            } catch (Throwable th) {
            }
        }
    }

    private void a(boolean z) {
        try {
            int b = cl.a().b("cc_version");
            ch.a("CC_", "schedule :" + z + "," + b);
            long g = b == -1 ? z ? 5000 : 10800000 : g();
            a(g);
        } catch (Exception e) {
            ch.b("CC_", e.toString());
        }
    }

    private static long g() {
        long j = 86400000;
        long c = cl.a().c("cc_req_interval");
        if (c <= 86400000) {
            j = c;
        }
        if (j < 3600000) {
            return 3600000;
        }
        return j;
    }

    private void a(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + j;
        ch.a("CC_", "startSchedule: delay: " + j + "ms,at: " + (System.currentTimeMillis() + j) + "ms");
        if (j <= 0) {
            new Thread(new b(this), "Th_CC").start();
        } else {
            h().set(2, elapsedRealtime, this.f);
        }
    }

    private static AlarmManager h() {
        return (AlarmManager) d.getSystemService("alarm");
    }

    private static Intent i() {
        Intent intent = new Intent(b);
        try {
            intent.setPackage(d.getPackageName());
        } catch (Throwable th) {
            intent.setPackage(null);
        }
        return intent;
    }

    static /* synthetic */ void d(ck ckVar) {
        try {
            d.unregisterReceiver(ckVar.g);
        } catch (Throwable th) {
        }
        try {
            h().cancel(ckVar.f);
            ckVar.f.cancel();
        } catch (Throwable th2) {
            ch.a("CC_", th2.getMessage(), th2);
        } finally {
            ch.a("CC_", "shutdown:cc");
        }
    }
}
