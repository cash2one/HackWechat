package c.t.m.g;

import android.os.Handler;
import android.os.HandlerThread;
import c.t.m.g.ar.a;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class al {
    AtomicInteger a = new AtomicInteger(0);
    public AtomicInteger b = new AtomicInteger(0);
    public Handler c;
    ar d;
    AtomicInteger e = new AtomicInteger(0);
    List<String> f = new ArrayList();
    volatile boolean g = false;
    volatile boolean h = false;
    public AtomicInteger i = new AtomicInteger(0);
    public int j;
    a k = new ao(this);
    private final String l = a();
    private final Runnable m = new ap(this);
    private final Runnable n = new aq(this);

    public al() {
        as.a(m.a());
        HandlerThread handlerThread = new HandlerThread(this.l);
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
        this.d = new am();
        b(true, false);
        this.j = b();
    }

    public abstract String a();

    final synchronized void a(boolean z, boolean z2) {
        if (z && z2) {
            b(false, true);
        } else {
            b(false, false);
        }
        if (!this.g) {
            if (!z) {
                this.e.set(0);
            }
            this.g = true;
            try {
                new d(this, z, z2).a(true);
            } catch (Throwable th) {
                this.g = false;
            }
        } else if (z) {
            this.h = true;
        }
    }

    public abstract int b();

    final void b(boolean z, boolean z2) {
        ab a;
        Runnable runnable;
        long a2;
        if (!z2) {
            a = ab.a();
            runnable = this.n;
            a2 = z ? 10000 : (long) v.a("report_timer_interval", 30000, 600000, 60000);
        } else if (this.a.get() > 3) {
            this.a.set(0);
            return;
        } else {
            a = ab.a();
            runnable = this.m;
            a2 = (long) (v.a("report_real_timer_interval", 1, 60, 5) * 1000);
        }
        a.a(runnable, false, a2);
    }

    public abstract String c();
}
