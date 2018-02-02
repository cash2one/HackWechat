package com.tencent.mapsdk.rastercore.b;

import com.tencent.mapsdk.rastercore.f.a;

public final class b {
    private c a;
    private c b;

    public b(c cVar, c cVar2) {
        a a = new a().a(cVar).a(cVar2);
        this.a = new c(a.a(a), a.b(a));
        this.b = new c(a.c(a), a.d(a));
    }

    public final c a() {
        return this.a;
    }

    public final c b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a.equals(bVar.a) && this.b.equals(bVar.b);
    }

    public final int hashCode() {
        return a.a(new Object[]{this.a, this.b});
    }

    public final String toString() {
        return a.a(new String[]{a.a("southwest", this.a), a.a("northeast", this.b)});
    }
}
