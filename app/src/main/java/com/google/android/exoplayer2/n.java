package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.f;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;

final class n {
    final b acL = new b();
    final a acM = new a();
    w acT;
    int repeatMode;

    public final f.b d(int i, long j) {
        this.acT.a(i, this.acM, false);
        int r = this.acM.r(j);
        if (r == -1) {
            return new f.b(i);
        }
        return new f.b(i, r, this.acM.afb[r]);
    }

    public final a a(a aVar, int i) {
        return a(aVar, aVar.aeq.cA(i));
    }

    final a a(a aVar, f.b bVar) {
        long j = aVar.adJ;
        long j2 = aVar.aer;
        boolean b = b(bVar, j2);
        boolean a = a(bVar, b);
        this.acT.a(bVar.arS, this.acM, false);
        long ao = bVar.kf() ? this.acM.ao(bVar.arT, bVar.arU) : j2 == Long.MIN_VALUE ? this.acM.aes : j2;
        return new a(bVar, j, j2, aVar.adK, ao, b, a, (byte) 0);
    }

    final a a(f.b bVar, long j, long j2) {
        this.acT.a(bVar.arS, this.acM, false);
        if (!bVar.kf()) {
            long j3;
            int s = this.acM.s(j2);
            if (s == -1) {
                j3 = Long.MIN_VALUE;
            } else {
                j3 = this.acM.aeY[s];
            }
            return b(bVar.arS, j2, j3);
        } else if (this.acM.an(bVar.arT, bVar.arU)) {
            return b(bVar.arS, bVar.arT, bVar.arU, j);
        } else {
            return null;
        }
    }

    final a b(int i, int i2, int i3, long j) {
        f.b bVar = new f.b(i, i2, i3);
        boolean b = b(bVar, Long.MIN_VALUE);
        boolean a = a(bVar, b);
        return new a(bVar, i3 == this.acM.afb[i2] ? this.acM.afd : 0, Long.MIN_VALUE, j, this.acT.a(bVar.arS, this.acM, false).ao(bVar.arT, bVar.arU), b, a, (byte) 0);
    }

    final a b(int i, long j, long j2) {
        long j3;
        f.b bVar = new f.b(i);
        boolean b = b(bVar, j2);
        boolean a = a(bVar, b);
        this.acT.a(bVar.arS, this.acM, false);
        if (j2 == Long.MIN_VALUE) {
            j3 = this.acM.aes;
        } else {
            j3 = j2;
        }
        return new a(bVar, j, j2, -9223372036854775807L, j3, b, a, (byte) 0);
    }

    private boolean b(f.b bVar, long j) {
        int iw = this.acT.a(bVar.arS, this.acM, false).iw();
        if (iw == 0) {
            return true;
        }
        int i = iw - 1;
        boolean kf = bVar.kf();
        if (this.acM.aeY[i] == Long.MIN_VALUE) {
            int i2 = this.acM.aeZ[i];
            if (i2 == -1) {
                return false;
            }
            boolean z;
            if (kf && bVar.arT == i && bVar.arU == i2 - 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
            if (kf || this.acM.afb[i] != i2) {
                return false;
            }
            return true;
        } else if (kf || j != Long.MIN_VALUE) {
            return false;
        } else {
            return true;
        }
    }

    private boolean a(f.b bVar, boolean z) {
        if (!this.acT.a(this.acT.a(bVar.arS, this.acM, false).adN, this.acL).afh) {
            if ((this.acT.a(bVar.arS, this.acM, this.acL, this.repeatMode) == -1) && z) {
                return true;
            }
        }
        return false;
    }
}
