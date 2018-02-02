package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.h.a;
import com.google.android.exoplayer2.i.h.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class j implements h {
    private k alW;
    private String amW;
    private final n anA = new n(7);
    private final n anB = new n(8);
    private final n anC = new n(6);
    private a anD;
    private final com.google.android.exoplayer2.i.j anE = new com.google.android.exoplayer2.i.j();
    private boolean ana;
    private final boolean[] anm = new boolean[3];
    private long ano;
    private long anq;
    private final r anx;
    private final boolean any;
    private final boolean anz;

    public j(r rVar, boolean z, boolean z2) {
        this.anx = rVar;
        this.any = z;
        this.anz = z2;
    }

    public final void jx() {
        h.a(this.anm);
        this.anA.reset();
        this.anB.reset();
        this.anC.reset();
        this.anD.reset();
        this.ano = 0;
    }

    public final void a(f fVar, u$d com_google_android_exoplayer2_c_c_u_d) {
        com_google_android_exoplayer2_c_c_u_d.jF();
        this.amW = com_google_android_exoplayer2_c_c_u_d.jH();
        this.alW = fVar.ck(com_google_android_exoplayer2_c_c_u_d.jG());
        this.anD = new a(this.alW, this.any, this.anz);
        this.anx.a(fVar, com_google_android_exoplayer2_c_c_u_d);
    }

    public final void c(long j, boolean z) {
        this.anq = j;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.exoplayer2.i.j jVar) {
        int i = jVar.position;
        int i2 = jVar.asN;
        byte[] bArr = jVar.data;
        this.ano += (long) jVar.lF();
        this.alW.a(jVar, jVar.lF());
        while (true) {
            int a = h.a(bArr, i, i2, this.anm);
            if (a == i2) {
                e(bArr, i, i2);
                return;
            }
            a aVar;
            Object obj;
            boolean z;
            long j;
            a aVar2;
            int i3 = h.i(bArr, a);
            int i4 = a - i;
            if (i4 > 0) {
                e(bArr, i, a);
            }
            int i5 = i2 - a;
            long j2 = this.ano - ((long) i5);
            int i6 = i4 < 0 ? -i4 : 0;
            long j3 = this.anq;
            if (!this.ana || this.anD.anz) {
                this.anA.cx(i6);
                this.anB.cx(i6);
                if (this.ana) {
                    if (this.anA.aow) {
                        this.anD.a(h.j(this.anA.aox, 3, this.anA.aoy));
                        this.anA.reset();
                    } else if (this.anB.aow) {
                        this.anD.a(h.k(this.anB.aox, this.anB.aoy));
                        this.anB.reset();
                    }
                } else if (this.anA.aow && this.anB.aow) {
                    List arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.anA.aox, this.anA.aoy));
                    arrayList.add(Arrays.copyOf(this.anB.aox, this.anB.aoy));
                    b j4 = h.j(this.anA.aox, 3, this.anA.aoy);
                    a k = h.k(this.anB.aox, this.anB.aoy);
                    this.alW.f(Format.a(this.amW, "video/avc", j4.width, j4.height, arrayList, j4.aCj));
                    this.ana = true;
                    this.anD.a(j4);
                    this.anD.a(k);
                    this.anA.reset();
                    this.anB.reset();
                }
            }
            if (this.anC.cx(i6)) {
                this.anE.l(this.anC.aox, h.h(this.anC.aox, this.anC.aoy));
                this.anE.cR(4);
                this.anx.a(j3, this.anE);
            }
            a aVar3 = this.anD;
            if (aVar3.anJ != 9) {
                if (aVar3.anz) {
                    aVar = aVar3.anN;
                    a aVar4 = aVar3.anM;
                    obj = (!aVar.anP || (aVar4.anP && aVar.anU == aVar4.anU && aVar.anV == aVar4.anV && aVar.anW == aVar4.anW && (!(aVar.anX && aVar4.anX && aVar.anY != aVar4.anY) && ((aVar.anS == aVar4.anS || !(aVar.anS == 0 || aVar4.anS == 0)) && !((aVar.anR.aCn == 0 && aVar4.anR.aCn == 0 && (aVar.aob != aVar4.aob || aVar.aoc != aVar4.aoc)) || ((aVar.anR.aCn == 1 && aVar4.anR.aCn == 1 && (aVar.aod != aVar4.aod || aVar.aoe != aVar4.aoe)) || aVar.anZ != aVar4.anZ || (aVar.anZ && aVar4.anZ && aVar.aoa != aVar4.aoa))))))) ? null : 1;
                }
                z = aVar3.ans;
                if (aVar3.anJ != 5) {
                    if (aVar3.any && aVar3.anJ == 1) {
                        aVar = aVar3.anN;
                        obj = (aVar.anQ || !(aVar.anT == 7 || aVar.anT == 2)) ? null : 1;
                    }
                    i = 0;
                    aVar3.ans = i | z;
                    j = this.anq;
                    if (!this.ana || this.anD.anz) {
                        this.anA.cw(i3);
                        this.anB.cw(i3);
                    }
                    this.anC.cw(i3);
                    aVar2 = this.anD;
                    aVar2.anJ = i3;
                    aVar2.anL = j;
                    aVar2.anK = j2;
                    if ((aVar2.any && aVar2.anJ == 1) || (aVar2.anz && (aVar2.anJ == 5 || aVar2.anJ == 1 || aVar2.anJ == 2))) {
                        aVar = aVar2.anM;
                        aVar2.anM = aVar2.anN;
                        aVar2.anN = aVar;
                        aVar2.anN.clear();
                        aVar2.anI = 0;
                        aVar2.anv = true;
                    }
                    i = a + 3;
                }
                i = 1;
                aVar3.ans = i | z;
                j = this.anq;
                this.anA.cw(i3);
                this.anB.cw(i3);
                this.anC.cw(i3);
                aVar2 = this.anD;
                aVar2.anJ = i3;
                aVar2.anL = j;
                aVar2.anK = j2;
                aVar = aVar2.anM;
                aVar2.anM = aVar2.anN;
                aVar2.anN = aVar;
                aVar2.anN.clear();
                aVar2.anI = 0;
                aVar2.anv = true;
                i = a + 3;
            }
            if (aVar3.anO) {
                aVar3.alW.a(aVar3.anj, aVar3.ans ? 1 : 0, (int) (aVar3.anK - aVar3.anr), i5 + ((int) (j2 - aVar3.anK)), null);
            }
            aVar3.anr = aVar3.anK;
            aVar3.anj = aVar3.anL;
            aVar3.ans = false;
            aVar3.anO = true;
            z = aVar3.ans;
            if (aVar3.anJ != 5) {
                aVar = aVar3.anN;
                if (aVar.anQ) {
                }
            }
            i = 1;
            aVar3.ans = i | z;
            j = this.anq;
            this.anA.cw(i3);
            this.anB.cw(i3);
            this.anC.cw(i3);
            aVar2 = this.anD;
            aVar2.anJ = i3;
            aVar2.anL = j;
            aVar2.anK = j2;
            aVar = aVar2.anM;
            aVar2.anM = aVar2.anN;
            aVar2.anN = aVar;
            aVar2.anN.clear();
            aVar2.anI = 0;
            aVar2.anv = true;
            i = a + 3;
        }
    }

    public final void jy() {
    }

    private void e(byte[] bArr, int i, int i2) {
        if (!this.ana || this.anD.anz) {
            this.anA.f(bArr, i, i2);
            this.anB.f(bArr, i, i2);
        }
        this.anC.f(bArr, i, i2);
        a aVar = this.anD;
        if (aVar.anv) {
            int i3 = i2 - i;
            if (aVar.buffer.length < aVar.anI + i3) {
                aVar.buffer = Arrays.copyOf(aVar.buffer, (aVar.anI + i3) * 2);
            }
            System.arraycopy(bArr, i, aVar.buffer, aVar.anI, i3);
            aVar.anI = i3 + aVar.anI;
            aVar.anH.k(aVar.buffer, 0, aVar.anI);
            if (aVar.anH.cW(8)) {
                aVar.anH.lL();
                int cT = aVar.anH.cT(2);
                aVar.anH.cS(5);
                if (aVar.anH.lM()) {
                    aVar.anH.lO();
                    if (aVar.anH.lM()) {
                        int lO = aVar.anH.lO();
                        if (!aVar.anz) {
                            aVar.anv = false;
                            a aVar2 = aVar.anN;
                            aVar2.anT = lO;
                            aVar2.anQ = true;
                        } else if (aVar.anH.lM()) {
                            int lO2 = aVar.anH.lO();
                            if (aVar.anG.indexOfKey(lO2) < 0) {
                                aVar.anv = false;
                                return;
                            }
                            a aVar3 = (a) aVar.anG.get(lO2);
                            b bVar = (b) aVar.anF.get(aVar3.aCh);
                            if (bVar.aCk) {
                                if (aVar.anH.cW(2)) {
                                    aVar.anH.cS(2);
                                } else {
                                    return;
                                }
                            }
                            if (aVar.anH.cW(bVar.aCm)) {
                                int i4;
                                int i5;
                                boolean z = false;
                                boolean z2 = false;
                                boolean z3 = false;
                                int cT2 = aVar.anH.cT(bVar.aCm);
                                if (!bVar.aCl) {
                                    if (aVar.anH.cW(1)) {
                                        z = aVar.anH.lC();
                                        if (z) {
                                            if (aVar.anH.cW(1)) {
                                                z3 = aVar.anH.lC();
                                                z2 = true;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    return;
                                }
                                boolean z4 = aVar.anJ == 5;
                                int i6 = 0;
                                if (z4) {
                                    if (aVar.anH.lM()) {
                                        i6 = aVar.anH.lO();
                                    } else {
                                        return;
                                    }
                                }
                                int i7 = 0;
                                int i8 = 0;
                                if (bVar.aCn != 0) {
                                    if (bVar.aCn == 1 && !bVar.aCp) {
                                        if (aVar.anH.lM()) {
                                            i8 = aVar.anH.lN();
                                            if (aVar3.aCi && !z) {
                                                if (aVar.anH.lM()) {
                                                    i3 = aVar.anH.lN();
                                                    i4 = i8;
                                                    i8 = 0;
                                                    i5 = 0;
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                        return;
                                    }
                                    i3 = 0;
                                    i4 = i8;
                                    i8 = 0;
                                    i5 = i7;
                                } else if (aVar.anH.cW(bVar.aCo)) {
                                    i7 = aVar.anH.cT(bVar.aCo);
                                    if (aVar3.aCi && !z) {
                                        if (aVar.anH.lM()) {
                                            i5 = i7;
                                            i8 = aVar.anH.lN();
                                            i3 = 0;
                                            i4 = 0;
                                        } else {
                                            return;
                                        }
                                    }
                                    i3 = 0;
                                    i4 = i8;
                                    i8 = 0;
                                    i5 = i7;
                                } else {
                                    return;
                                }
                                a aVar4 = aVar.anN;
                                aVar4.anR = bVar;
                                aVar4.anS = cT;
                                aVar4.anT = lO;
                                aVar4.anU = cT2;
                                aVar4.anV = lO2;
                                aVar4.anW = z;
                                aVar4.anX = z2;
                                aVar4.anY = z3;
                                aVar4.anZ = z4;
                                aVar4.aoa = i6;
                                aVar4.aob = i5;
                                aVar4.aoc = i8;
                                aVar4.aod = i4;
                                aVar4.aoe = i3;
                                aVar4.anP = true;
                                aVar4.anQ = true;
                                aVar.anv = false;
                            }
                        }
                    }
                }
            }
        }
    }
}
