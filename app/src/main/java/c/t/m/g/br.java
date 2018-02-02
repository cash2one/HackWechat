package c.t.m.g;

import android.os.SystemClock;
import c.t.m.g.bo.a;

final class br implements Runnable {
    private /* synthetic */ bo a;

    br(bo boVar) {
        this.a = boVar;
    }

    public final void run() {
        try {
            p.e();
            a a = bo.a(this.a, p.b());
            if (SystemClock.elapsedRealtime() - a.a > ((long) bo.b(a.b))) {
                this.a.c.removeCallbacks(this.a.f);
                this.a.c.post(this.a.f);
            }
        } catch (Throwable th) {
        }
    }
}
