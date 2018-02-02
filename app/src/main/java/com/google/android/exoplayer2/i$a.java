package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.source.c;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.source.i;

final class i$a {
    private final r[] acF;
    private final g acG;
    public final boolean[] adA;
    public final long adB;
    public n$a adC;
    public boolean adD;
    public boolean adE;
    public i$a adF;
    public h adG;
    private h adH;
    private final s[] add;
    final m ade;
    private final f adl;
    public final e adx;
    public final Object ady;
    public final i[] adz;
    public final int index;

    public i$a(r[] rVarArr, s[] sVarArr, long j, g gVar, m mVar, f fVar, Object obj, int i, n$a com_google_android_exoplayer2_n_a) {
        e cVar;
        this.acF = rVarArr;
        this.add = sVarArr;
        this.adB = j;
        this.acG = gVar;
        this.ade = mVar;
        this.adl = fVar;
        this.ady = a.Y(obj);
        this.index = i;
        this.adC = com_google_android_exoplayer2_n_a;
        this.adz = new i[rVarArr.length];
        this.adA = new boolean[rVarArr.length];
        e a = fVar.a(com_google_android_exoplayer2_n_a.aeq, mVar.hZ());
        if (com_google_android_exoplayer2_n_a.aer != Long.MIN_VALUE) {
            cVar = new c(a);
            long j2 = com_google_android_exoplayer2_n_a.aer;
            cVar.arK = 0;
            cVar.arL = j2;
        } else {
            cVar = a;
        }
        this.adx = cVar;
    }

    public final long ik() {
        return this.index == 0 ? this.adB : this.adB - this.adC.adJ;
    }

    public final boolean il() {
        return this.adD && (!this.adE || this.adx.ka() == Long.MIN_VALUE);
    }

    public final boolean im() {
        boolean z;
        h a = this.acG.a(this.add, this.adx.jY());
        h hVar = this.adH;
        if (hVar == null) {
            z = false;
        } else {
            for (int i = 0; i < a.aAx.length; i++) {
                if (!a.a(hVar, i)) {
                    z = false;
                    break;
                }
            }
            z = true;
        }
        if (z) {
            return false;
        }
        this.adG = a;
        return true;
    }

    public final long p(long j) {
        return a(j, false, new boolean[this.acF.length]);
    }

    public final long a(long j, boolean z, boolean[] zArr) {
        com.google.android.exoplayer2.g.f fVar = this.adG.aAx;
        int i = 0;
        while (i < fVar.length) {
            boolean z2;
            boolean[] zArr2 = this.adA;
            if (z || !this.adG.a(this.adH, i)) {
                z2 = false;
            } else {
                z2 = true;
            }
            zArr2[i] = z2;
            i++;
        }
        long a = this.adx.a(fVar.lk(), this.adA, this.adz, zArr, j);
        this.adH = this.adG;
        this.adE = false;
        for (int i2 = 0; i2 < this.adz.length; i2++) {
            if (this.adz[i2] != null) {
                boolean z3;
                if (fVar.aAu[i2] != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                a.an(z3);
                this.adE = true;
            } else {
                a.an(fVar.aAu[i2] == null);
            }
        }
        this.ade.a(this.acF, fVar);
        return a;
    }

    public final void release() {
        try {
            if (this.adC.aer != Long.MIN_VALUE) {
                this.adl.b(((c) this.adx).adx);
            } else {
                this.adl.b(this.adx);
            }
        } catch (RuntimeException e) {
        }
    }
}
