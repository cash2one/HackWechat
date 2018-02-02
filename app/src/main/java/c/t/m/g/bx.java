package c.t.m.g;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bx implements aw, bc {
    private static bx c = new bx();
    public Map<String, ax> a = new ConcurrentHashMap();
    public bu b;
    private Runnable d = new bz(this);
    private Runnable e = new ca(this);

    private bx() {
        ax bbVar = new bb();
        this.a.put(bbVar.a(), bbVar);
        bbVar = new ba();
        this.a.put(bbVar.a(), bbVar);
        bbVar = new ay();
        this.a.put(bbVar.a(), bbVar);
        Runnable runnable = this.d;
        if (!m.f() && m.g) {
            ab.a().a(runnable);
            ab.a().a(runnable, true, 30000);
        }
        runnable = this.e;
        if (!m.f() && m.g) {
            ab.a().a(runnable);
            ab.a().a(runnable, true, 30000);
        }
    }

    public static bx c() {
        return c;
    }

    public final void a() {
        this.b.a();
    }

    public final void a(int i) {
        m.i().post(new by(this, i));
    }

    public final void a(String str, String str2) {
        Runnable runnable = this.d;
        long a = (long) v.a("app_ipc_timertask_gap", 0, 3600000, 60000);
        if (!m.f() && m.g) {
            ab.a().a(runnable);
            ab.a().a(runnable, true, a);
        }
        for (ax a2 : this.a.values()) {
            a2.a(str, str2);
        }
    }

    public final void a(String str, byte[] bArr, String str2) {
        Runnable runnable = this.e;
        long a = (long) v.a("app_ipc_timertask_gap", 0, 3600000, 60000);
        if (!m.f() && m.g) {
            ab.a().a(runnable);
            ab.a().a(runnable, true, a);
        }
        for (ax a2 : this.a.values()) {
            a2.a(str, bArr, str2);
        }
    }

    public final void a_() {
        for (ax a_ : this.a.values()) {
            a_.a_();
        }
    }

    public final void b() {
        this.b.b();
    }

    public final s d() {
        return (s) this.a.get("accessscheduler");
    }
}
