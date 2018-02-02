package c.t.m.g;

import android.os.SystemClock;
import c.t.m.g.bo.a;
import org.json.JSONObject;

final class bt implements Runnable {
    private /* synthetic */ bo a;

    bt(bo boVar) {
        this.a = boVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        Throwable th;
        a a;
        int i = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            int i2;
            bg bgVar = new bg();
            for (bk a2 : bo.c(this.a).values()) {
                a2.a(bgVar);
            }
            byte[] a3 = bgVar.a();
            if (cg.a(a3)) {
                i2 = 0;
            } else {
                ag a4 = ag.a("https://yun-hl.3g.qq.com/halleycloud", null, a3, 15000, cg.d(), bx.c().d());
                a4.o = "platform";
                aj a5 = a4.a();
                int i3 = a5.a;
                try {
                    if (a5.a == 0 && a5.c == 200 && !cg.a(a5.d)) {
                        JSONObject jSONObject = new JSONObject(new String(a5.d));
                        p.e();
                        for (bk a22 : bo.c(this.a).values()) {
                            a22.a(jSONObject);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = i3;
                    a = bo.a(this.a, p.b());
                    a.a = SystemClock.elapsedRealtime();
                    a.b = i;
                    bo.b(this.a).removeCallbacks(bo.a(this.a));
                    throw th;
                }
                a4.k = SystemClock.elapsedRealtime() - elapsedRealtime;
                a4.a(false);
                i2 = i3;
            }
            a = bo.a(this.a, p.b());
            a.a = SystemClock.elapsedRealtime();
            a.b = i2;
            bo.b(this.a).removeCallbacks(bo.a(this.a));
        } catch (Throwable th3) {
            th = th3;
            a = bo.a(this.a, p.b());
            a.a = SystemClock.elapsedRealtime();
            a.b = i;
            bo.b(this.a).removeCallbacks(bo.a(this.a));
            throw th;
        }
    }
}
