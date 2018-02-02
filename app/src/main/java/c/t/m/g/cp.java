package c.t.m.g;

import android.location.Location;
import java.util.List;

public final class cp {
    public final cr a;
    public volatile boolean b = false;
    public cq c;
    public dn d;
    public List<dn> e;
    public dr f;
    public do g;
    public Location h;

    public cp(cr crVar) {
        this.a = crVar;
    }

    public final void a() {
        this.e = null;
        this.d = null;
        this.g = null;
        this.g = null;
    }

    public final boolean b() {
        if (this.g != null) {
            boolean z;
            do doVar = this.g;
            if (doVar.a == null || doVar.a.getAltitude() == 0.0d || System.currentTimeMillis() - doVar.b > 10000) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final void c() {
        if (b()) {
            if (this.e == null || this.e.size() == 0) {
                this.e = ea.a(this.a);
            }
            if (this.e != null && this.e.size() != 0) {
                if (this.c != null) {
                    this.c.a(this.g, null, this.e);
                }
                if (this.h == null) {
                    this.h = new Location(this.g.a);
                } else {
                    this.h.set(this.g.a);
                }
            }
        }
    }
}
