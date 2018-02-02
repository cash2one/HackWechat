package c.t.m.g;

import android.annotation.SuppressLint;

class dd$3 implements Runnable {
    private /* synthetic */ dd a;

    dd$3(dd ddVar) {
        this.a = ddVar;
    }

    @SuppressLint({"MissingPermission"})
    public final void run() {
        try {
            dd.b(this.a).requestLocationUpdates("passive", 1000, 0.0f, dd.a(this.a));
        } catch (Throwable th) {
            th.toString();
        }
    }
}
