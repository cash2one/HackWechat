package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Bundle;

class dd$1 implements Runnable {
    private /* synthetic */ dd a;

    dd$1(dd ddVar) {
        this.a = ddVar;
    }

    @SuppressLint({"MissingPermission"})
    public final void run() {
        try {
            dd.b(this.a).addGpsStatusListener(dd.a(this.a));
            Bundle bundle = new Bundle();
            dd.b(this.a).sendExtraCommand("gps", "force_xtra_injection", bundle);
            dd.b(this.a).sendExtraCommand("gps", "force_time_injection", bundle);
        } catch (Throwable th) {
            th.toString();
        }
    }
}
