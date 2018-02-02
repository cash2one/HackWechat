package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bo implements bu, Runnable {
    private static bo b = new bo();
    public bc a;
    private Handler c;
    private Map<String, bk> d = new ConcurrentHashMap();
    private Runnable e = new br(this);
    private Runnable f = new bt(this);
    private Map<String, a> g = new HashMap();

    private bo() {
    }

    static /* synthetic */ int b(int i) {
        String str;
        int i2;
        if (i == 0) {
            str = "http_platform_update_interval_succ";
        } else {
            str = (i == -4 || i == -3) ? "http_platform_update_interval_nonet" : "http_platform_update_interval_fail";
        }
        if (i == 0) {
            i2 = 1800000;
        } else {
            i2 = (i == -4 || i == -3) ? 60000 : 300000;
        }
        return v.a(str, 60000, 3600000, i2);
    }

    public static bo c() {
        return b;
    }

    public final void a() {
        ((bk) this.d.get("accessscheduler")).a();
    }

    public final void a(int i) {
        if (i == 1 || i == 2) {
            this.c.removeCallbacks(this.e);
            this.c.post(this.e);
        }
    }

    public final void a(bc bcVar) {
        this.a = bcVar;
        bk bsVar = new bs();
        this.d.put(bsVar.c(), bsVar);
        bsVar = new bm();
        this.d.put(bsVar.c(), bsVar);
        bsVar = new bp();
        this.d.put(bsVar.c(), bsVar);
    }

    public final void b() {
        ((bk) this.d.get("settings")).b();
    }

    public final void d() {
        HandlerThread handlerThread = new HandlerThread("HttpPlatformConnection");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
        this.c.post(this);
        this.a.a_();
    }

    public final void run() {
        if (v.a("http_platform_start_update_on", 0, 1, 1) == 1) {
            this.c.post(this.f);
        }
    }

    static /* synthetic */ a a(bo boVar, String str) {
        a aVar = (a) boVar.g.get(str);
        if (aVar != null) {
            return aVar;
        }
        aVar = new a((byte) 0);
        boVar.g.put(str, aVar);
        return aVar;
    }
}
