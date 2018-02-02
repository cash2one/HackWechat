package c.t.m.g;

import android.annotation.SuppressLint;

class dd$2 implements Runnable {
    private /* synthetic */ dd a;

    dd$2(dd ddVar) {
        this.a = ddVar;
    }

    @SuppressLint({"MissingPermission"})
    public final void run() {
        try {
            dd.b(this.a).requestLocationUpdates("gps", dd.c(this.a), 0.0f, dd.a(this.a));
        } catch (Throwable th) {
            ea.a = true;
        }
    }
}
