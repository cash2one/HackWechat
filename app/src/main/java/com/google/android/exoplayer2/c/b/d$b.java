package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.a;

final class d$b {
    public final g alV = new g();
    public final k alW;
    public e alX;
    public c alY;
    public int alZ;
    public int ama;
    public int amb;

    public d$b(k kVar) {
        this.alW = kVar;
    }

    public final void a(e eVar, c cVar) {
        this.alX = (e) a.Y(eVar);
        this.alY = (c) a.Y(cVar);
        this.alW.f(eVar.aeo);
        reset();
    }

    public final void reset() {
        g gVar = this.alV;
        gVar.amr = 0;
        gVar.amE = 0;
        gVar.amy = false;
        gVar.amD = false;
        gVar.amA = null;
        this.alZ = 0;
        this.amb = 0;
        this.ama = 0;
    }
}
