package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.j;
import com.tencent.wcdb.FileUtils;
import java.util.Collections;

public final class k implements h {
    private com.google.android.exoplayer2.c.k alW;
    private String amW;
    private final n anA = new n(33);
    private final n anB = new n(34);
    private final j anE = new j();
    private boolean ana;
    private final boolean[] anm = new boolean[3];
    private long ano;
    private long anq;
    private final r anx;
    private a aof;
    private final n aog = new n(32);
    private final n aoh = new n(39);
    private final n aoi = new n(40);

    private static final class a {
        private final com.google.android.exoplayer2.c.k alW;
        long anK;
        long anL;
        boolean anO;
        long anj;
        long anr;
        boolean ans;
        boolean aoj;
        int aok;
        boolean aol;
        boolean aom;
        boolean aon;
        boolean aoo;

        public a(com.google.android.exoplayer2.c.k kVar) {
            this.alW = kVar;
        }

        final void cv(int i) {
            this.alW.a(this.anj, this.ans ? 1 : 0, (int) (this.anK - this.anr), i, null);
        }
    }

    public k(r rVar) {
        this.anx = rVar;
    }

    public final void jx() {
        h.a(this.anm);
        this.aog.reset();
        this.anA.reset();
        this.anB.reset();
        this.aoh.reset();
        this.aoi.reset();
        a aVar = this.aof;
        aVar.aol = false;
        aVar.aom = false;
        aVar.aon = false;
        aVar.anO = false;
        aVar.aoo = false;
        this.ano = 0;
    }

    public final void a(f fVar, d dVar) {
        dVar.jF();
        this.amW = dVar.jH();
        this.alW = fVar.ck(dVar.jG());
        this.aof = new a(this.alW);
        this.anx.a(fVar, dVar);
    }

    public final void c(long j, boolean z) {
        this.anq = j;
    }

    public final void b(j jVar) {
        while (jVar.lF() > 0) {
            int i = jVar.position;
            int i2 = jVar.asN;
            byte[] bArr = jVar.data;
            this.ano += (long) jVar.lF();
            this.alW.a(jVar, jVar.lF());
            while (i < i2) {
                int a = h.a(bArr, i, i2, this.anm);
                if (a == i2) {
                    e(bArr, i, i2);
                    return;
                }
                int j = h.j(bArr, a);
                int i3 = a - i;
                if (i3 > 0) {
                    e(bArr, i, a);
                }
                int i4 = i2 - a;
                long j2 = this.ano - ((long) i4);
                int i5 = i3 < 0 ? -i3 : 0;
                long j3 = this.anq;
                if (this.ana) {
                    a aVar = this.aof;
                    if (aVar.aoo && aVar.aom) {
                        aVar.ans = aVar.aoj;
                        aVar.aoo = false;
                    } else if (aVar.aon || aVar.aom) {
                        if (aVar.anO) {
                            aVar.cv(((int) (j2 - aVar.anK)) + i4);
                        }
                        aVar.anr = aVar.anK;
                        aVar.anj = aVar.anL;
                        aVar.anO = true;
                        aVar.ans = aVar.aoj;
                    }
                } else {
                    this.aog.cx(i5);
                    this.anA.cx(i5);
                    this.anB.cx(i5);
                    if (this.aog.aow && this.anA.aow && this.anB.aow) {
                        int i6;
                        int lO;
                        int lO2;
                        int lO3;
                        int lO4;
                        int i7;
                        float f;
                        com.google.android.exoplayer2.c.k kVar = this.alW;
                        String str = this.amW;
                        n nVar = this.aog;
                        n nVar2 = this.anA;
                        n nVar3 = this.anB;
                        Object obj = new byte[((nVar.aoy + nVar2.aoy) + nVar3.aoy)];
                        System.arraycopy(nVar.aox, 0, obj, 0, nVar.aoy);
                        System.arraycopy(nVar2.aox, 0, obj, nVar.aoy, nVar2.aoy);
                        System.arraycopy(nVar3.aox, 0, obj, nVar.aoy + nVar2.aoy, nVar3.aoy);
                        com.google.android.exoplayer2.i.k kVar2 = new com.google.android.exoplayer2.i.k(nVar2.aox, 0, nVar2.aoy);
                        kVar2.cS(44);
                        int cT = kVar2.cT(3);
                        kVar2.lL();
                        kVar2.cS(88);
                        kVar2.cS(8);
                        i3 = 0;
                        for (i6 = 0; i6 < cT; i6++) {
                            if (kVar2.lC()) {
                                i3 += 89;
                            }
                            if (kVar2.lC()) {
                                i3 += 8;
                            }
                        }
                        kVar2.cS(i3);
                        if (cT > 0) {
                            kVar2.cS((8 - cT) * 2);
                        }
                        kVar2.lO();
                        int lO5 = kVar2.lO();
                        if (lO5 == 3) {
                            kVar2.lL();
                        }
                        i6 = kVar2.lO();
                        int lO6 = kVar2.lO();
                        if (kVar2.lC()) {
                            lO = kVar2.lO();
                            lO2 = kVar2.lO();
                            lO3 = kVar2.lO();
                            lO4 = kVar2.lO();
                            i7 = (lO5 == 1 || lO5 == 2) ? 2 : 1;
                            i6 -= i7 * (lO + lO2);
                            lO6 -= (lO5 == 1 ? 2 : 1) * (lO3 + lO4);
                        }
                        kVar2.lO();
                        kVar2.lO();
                        lO = kVar2.lO();
                        i3 = kVar2.lC() ? 0 : cT;
                        while (i3 <= cT) {
                            kVar2.lO();
                            kVar2.lO();
                            kVar2.lO();
                            i3++;
                        }
                        kVar2.lO();
                        kVar2.lO();
                        kVar2.lO();
                        kVar2.lO();
                        kVar2.lO();
                        kVar2.lO();
                        if (kVar2.lC() && kVar2.lC()) {
                            i7 = 0;
                            while (i7 < 4) {
                                for (cT = 0; cT < 6; cT = (i7 == 3 ? 3 : 1) + cT) {
                                    if (kVar2.lC()) {
                                        lO5 = Math.min(64, 1 << ((i7 << 1) + 4));
                                        if (i7 > 1) {
                                            kVar2.lN();
                                        }
                                        for (i3 = 0; i3 < lO5; i3++) {
                                            kVar2.lN();
                                        }
                                    } else {
                                        kVar2.lO();
                                    }
                                }
                                i7++;
                            }
                        }
                        kVar2.cS(2);
                        if (kVar2.lC()) {
                            kVar2.cS(8);
                            kVar2.lO();
                            kVar2.lO();
                            kVar2.lL();
                        }
                        lO2 = kVar2.lO();
                        lO5 = 0;
                        i3 = 0;
                        boolean z = false;
                        while (lO5 < lO2) {
                            boolean lC;
                            if (lO5 != 0) {
                                lC = kVar2.lC();
                            } else {
                                lC = z;
                            }
                            if (lC) {
                                kVar2.lL();
                                kVar2.lO();
                                for (cT = 0; cT <= i3; cT++) {
                                    if (kVar2.lC()) {
                                        kVar2.lL();
                                    }
                                }
                            } else {
                                lO3 = kVar2.lO();
                                lO4 = kVar2.lO();
                                i3 = lO3 + lO4;
                                for (cT = 0; cT < lO3; cT++) {
                                    kVar2.lO();
                                    kVar2.lL();
                                }
                                for (cT = 0; cT < lO4; cT++) {
                                    kVar2.lO();
                                    kVar2.lL();
                                }
                            }
                            lO5++;
                            z = lC;
                        }
                        if (kVar2.lC()) {
                            for (i3 = 0; i3 < kVar2.lO(); i3++) {
                                kVar2.cS((lO + 4) + 1);
                            }
                        }
                        kVar2.cS(2);
                        float f2 = 1.0f;
                        if (kVar2.lC() && kVar2.lC()) {
                            cT = kVar2.cT(8);
                            if (cT == 255) {
                                cT = kVar2.cT(16);
                                i7 = kVar2.cT(16);
                                if (!(cT == 0 || i7 == 0)) {
                                    f2 = ((float) cT) / ((float) i7);
                                }
                                f = f2;
                            } else if (cT < h.aCe.length) {
                                f = h.aCe[cT];
                            }
                            kVar.f(Format.a(str, "video/hevc", i6, lO6, Collections.singletonList(obj), f));
                            this.ana = true;
                        }
                        f = 1.0f;
                        kVar.f(Format.a(str, "video/hevc", i6, lO6, Collections.singletonList(obj), f));
                        this.ana = true;
                    }
                }
                if (this.aoh.cx(i5)) {
                    this.anE.l(this.aoh.aox, h.h(this.aoh.aox, this.aoh.aoy));
                    this.anE.cV(5);
                    this.anx.a(j3, this.anE);
                }
                if (this.aoi.cx(i5)) {
                    this.anE.l(this.aoi.aox, h.h(this.aoi.aox, this.aoi.aoy));
                    this.anE.cV(5);
                    this.anx.a(j3, this.anE);
                }
                long j4 = this.anq;
                if (this.ana) {
                    a aVar2 = this.aof;
                    aVar2.aom = false;
                    aVar2.aon = false;
                    aVar2.anL = j4;
                    aVar2.aok = 0;
                    aVar2.anK = j2;
                    if (j >= 32) {
                        if (!aVar2.aoo && aVar2.anO) {
                            aVar2.cv(i4);
                            aVar2.anO = false;
                        }
                        if (j <= 34) {
                            aVar2.aon = !aVar2.aoo;
                            aVar2.aoo = true;
                        }
                    }
                    boolean z2 = j >= 16 && j <= 21;
                    aVar2.aoj = z2;
                    z2 = aVar2.aoj || j <= 9;
                    aVar2.aol = z2;
                } else {
                    this.aog.cw(j);
                    this.anA.cw(j);
                    this.anB.cw(j);
                }
                this.aoh.cw(j);
                this.aoi.cw(j);
                i = a + 3;
            }
        }
    }

    public final void jy() {
    }

    private void e(byte[] bArr, int i, int i2) {
        if (this.ana) {
            a aVar = this.aof;
            if (aVar.aol) {
                int i3 = (i + 2) - aVar.aok;
                if (i3 < i2) {
                    aVar.aom = (bArr[i3] & FileUtils.S_IWUSR) != 0;
                    aVar.aol = false;
                } else {
                    aVar.aok += i2 - i;
                }
            }
        } else {
            this.aog.f(bArr, i, i2);
            this.anA.f(bArr, i, i2);
            this.anB.f(bArr, i, i2);
        }
        this.aoh.f(bArr, i, i2);
        this.aoi.f(bArr, i, i2);
    }
}
