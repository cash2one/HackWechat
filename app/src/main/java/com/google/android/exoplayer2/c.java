package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.t;

public final class c implements m {
    private final j acr;
    private final long acs;
    private final long act;
    private final long acu;
    private final long acv;
    private final m acw;
    private int acx;
    private boolean isBuffering;

    public c() {
        this(new j());
    }

    private c(j jVar) {
        this(jVar, (byte) 0);
    }

    private c(j jVar, byte b) {
        this(jVar, 15000, 30000, 2500, 5000);
    }

    private c(j jVar, int i, int i2, long j, long j2) {
        this.acr = jVar;
        this.acs = 15000000;
        this.act = 30000000;
        this.acu = 2500000;
        this.acv = 5000000;
        this.acw = null;
    }

    public final void hX() {
        reset(false);
    }

    public final void a(r[] rVarArr, f fVar) {
        int i = 0;
        this.acx = 0;
        while (i < rVarArr.length) {
            if (fVar.aAu[i] != null) {
                this.acx += t.da(rVarArr[i].getTrackType());
            }
            i++;
        }
        this.acr.cP(this.acx);
    }

    public final void onStopped() {
        reset(true);
    }

    public final void hY() {
        reset(true);
    }

    public final b hZ() {
        return this.acr;
    }

    public final boolean b(long j, boolean z) {
        long j2 = z ? this.acv : this.acu;
        return j2 <= 0 || j >= j2;
    }

    public final boolean l(long j) {
        boolean z = false;
        boolean z2 = j > this.act ? false : j < this.acs ? true : true;
        boolean z3;
        if (this.acr.lr() >= this.acx) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z4 = this.isBuffering;
        if (z2 || (z2 && this.isBuffering && !r4)) {
            z = true;
        }
        this.isBuffering = z;
        if (!(this.acw == null || this.isBuffering == z4)) {
            if (this.isBuffering) {
                m mVar = this.acw;
                synchronized (mVar.lock) {
                    mVar.aCt.add(Integer.valueOf(0));
                    mVar.aCu = Math.max(mVar.aCu, 0);
                }
            } else {
                this.acw.lP();
            }
        }
        return this.isBuffering;
    }

    private void reset(boolean z) {
        this.acx = 0;
        if (this.acw != null && this.isBuffering) {
            this.acw.lP();
        }
        this.isBuffering = false;
        if (z) {
            this.acr.reset();
        }
    }
}
