package c.t.m.g;

import android.os.Looper;
import c.t.m.g.de.b;

class de$2 implements Runnable {
    private /* synthetic */ de a;

    de$2(de deVar) {
        this.a = deVar;
    }

    public final void run() {
        try {
            Looper looper = de.a(this.a) == null ? null : de.a(this.a).getLooper();
            if (looper != null && looper.getThread().isAlive()) {
                de.a(this.a, b.b);
                de.a(this.a, looper);
            }
        } catch (Throwable th) {
        }
    }
}
