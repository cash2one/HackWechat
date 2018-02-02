package c.t.m.g;

import android.os.SystemClock;

final class an implements Runnable {
    private /* synthetic */ ag a;
    private /* synthetic */ long b;
    private /* synthetic */ am c;

    an(am amVar, ag agVar, long j) {
        this.c = amVar;
        this.a = agVar;
        this.b = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        boolean z = false;
        try {
            aj a = this.a.a();
            this.a.k = SystemClock.elapsedRealtime() - this.b;
            this.a.a(false);
            if (a.a == 0 && a.c == 200) {
                z = true;
            }
            am.a(this.c, z);
        } catch (Throwable th) {
            am.a(this.c, false);
        }
    }
}
