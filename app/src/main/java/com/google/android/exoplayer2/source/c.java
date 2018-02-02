package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.k;

public final class c implements e, com.google.android.exoplayer2.source.e.a {
    public final e adx;
    private com.google.android.exoplayer2.source.e.a arJ;
    public long arK = -9223372036854775807L;
    public long arL = -9223372036854775807L;
    private a[] arM = new a[0];
    private boolean arN = true;

    private static final class a implements i {
        final i acj;
        private final e adx;
        private final long arK;
        private final long arL;
        boolean arO;
        boolean arP;

        public a(e eVar, i iVar, long j, long j2, boolean z) {
            this.adx = eVar;
            this.acj = iVar;
            this.arK = j;
            this.arL = j2;
            this.arO = z;
        }

        public final boolean is() {
            return this.acj.is();
        }

        public final void kc() {
            this.acj.kc();
        }

        public final int b(k kVar, e eVar, boolean z) {
            if (this.arO) {
                return -3;
            }
            if (this.arP) {
                eVar.flags = 4;
                return -4;
            }
            int b = this.acj.b(kVar, eVar, z);
            if (this.arL == Long.MIN_VALUE || ((b != -4 || eVar.aig < this.arL) && !(b == -3 && this.adx.ka() == Long.MIN_VALUE))) {
                if (b == -4 && !eVar.iY()) {
                    eVar.aig -= this.arK;
                }
                return b;
            }
            eVar.clear();
            eVar.flags = 4;
            this.arP = true;
            return -4;
        }

        public final void D(long j) {
            this.acj.D(this.arK + j);
        }
    }

    public c(e eVar) {
        this.adx = eVar;
    }

    public final void a(com.google.android.exoplayer2.source.e.a aVar, long j) {
        this.arJ = aVar;
        this.adx.a(this, this.arK + j);
    }

    public final void jX() {
        this.adx.jX();
    }

    public final m jY() {
        return this.adx.jY();
    }

    public final long a(com.google.android.exoplayer2.g.e[] eVarArr, boolean[] zArr, i[] iVarArr, boolean[] zArr2, long j) {
        boolean z;
        this.arM = new a[iVarArr.length];
        i[] iVarArr2 = new i[iVarArr.length];
        for (int i = 0; i < iVarArr.length; i++) {
            this.arM[i] = (a) iVarArr[i];
            iVarArr2[i] = this.arM[i] != null ? this.arM[i].acj : null;
        }
        long a = this.adx.a(eVarArr, zArr, iVarArr2, zArr2, j + this.arK);
        if (this.arN) {
            if (this.arK != 0) {
                Object obj;
                for (com.google.android.exoplayer2.g.e eVar : eVarArr) {
                    if (eVar != null && !g.Z(eVar.lh().adV)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    z = true;
                    this.arN = z;
                }
            }
            z = false;
            this.arN = z;
        }
        z = a == this.arK + j || (a >= this.arK && (this.arL == Long.MIN_VALUE || a <= this.arL));
        com.google.android.exoplayer2.i.a.an(z);
        int i2 = 0;
        while (i2 < iVarArr.length) {
            if (iVarArr2[i2] == null) {
                this.arM[i2] = null;
            } else if (iVarArr[i2] == null || this.arM[i2].acj != iVarArr2[i2]) {
                this.arM[i2] = new a(this, iVarArr2[i2], this.arK, this.arL, this.arN);
            }
            iVarArr[i2] = this.arM[i2];
            i2++;
        }
        return a - this.arK;
    }

    public final void A(long j) {
        this.adx.A(this.arK + j);
    }

    public final long jZ() {
        boolean z = false;
        if (this.arN) {
            for (a aVar : this.arM) {
                if (aVar != null) {
                    aVar.arO = false;
                }
            }
            this.arN = false;
            long jZ = jZ();
            if (jZ != -9223372036854775807L) {
                return jZ;
            }
            return 0;
        }
        long jZ2 = this.adx.jZ();
        if (jZ2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z2;
        if (jZ2 >= this.arK) {
            z2 = true;
        } else {
            z2 = false;
        }
        com.google.android.exoplayer2.i.a.an(z2);
        if (this.arL == Long.MIN_VALUE || jZ2 <= this.arL) {
            z = true;
        }
        com.google.android.exoplayer2.i.a.an(z);
        return jZ2 - this.arK;
    }

    public final long ka() {
        long ka = this.adx.ka();
        if (ka == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        if (this.arL == Long.MIN_VALUE || ka < this.arL) {
            return Math.max(0, ka - this.arK);
        }
        return Long.MIN_VALUE;
    }

    public final long B(long j) {
        boolean z = false;
        for (a aVar : this.arM) {
            if (aVar != null) {
                aVar.arP = false;
            }
        }
        long B = this.adx.B(this.arK + j);
        if (B == this.arK + j || (B >= this.arK && (this.arL == Long.MIN_VALUE || B <= this.arL))) {
            z = true;
        }
        com.google.android.exoplayer2.i.a.an(z);
        return B - this.arK;
    }

    public final long kb() {
        long kb = this.adx.kb();
        if (kb == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        if (this.arL == Long.MIN_VALUE || kb < this.arL) {
            return kb - this.arK;
        }
        return Long.MIN_VALUE;
    }

    public final boolean C(long j) {
        return this.adx.C(this.arK + j);
    }

    public final void a(e eVar) {
        boolean z = (this.arK == -9223372036854775807L || this.arL == -9223372036854775807L) ? false : true;
        com.google.android.exoplayer2.i.a.an(z);
        this.arJ.a(this);
    }
}
