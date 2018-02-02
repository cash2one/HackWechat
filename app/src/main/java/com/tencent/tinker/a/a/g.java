package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class g extends com.tencent.tinker.a.a.t.a.a<g> {
    public int AeC;
    public int AeD;
    public int AeE;
    public int AeF;
    public short[] AeG;
    public b[] AeH;
    public a[] AeI;

    public static class a implements Comparable<a> {
        public int[] AeJ;
        public int[] AeK;
        public int AeL;
        public int offset;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int a = c.a(this.AeJ, aVar.AeJ);
            if (a != 0) {
                return a;
            }
            a = c.a(this.AeK, aVar.AeK);
            return a == 0 ? c.fJ(this.AeL, aVar.AeL) : a;
        }

        public a(int[] iArr, int[] iArr2, int i, int i2) {
            this.AeJ = iArr;
            this.AeK = iArr2;
            this.AeL = i;
            this.offset = i2;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int fJ = c.fJ(this.AeC, gVar.AeC);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.fJ(this.AeD, gVar.AeD);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.fJ(this.AeE, gVar.AeE);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.fJ(this.AeF, gVar.AeF);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.a(this.AeG, gVar.AeG);
        if (fJ != 0) {
            return fJ;
        }
        fJ = c.a(this.AeH, gVar.AeH);
        return fJ == 0 ? c.a(this.AeI, gVar.AeI) : fJ;
    }

    public g(int i, int i2, int i3, int i4, int i5, short[] sArr, b[] bVarArr, a[] aVarArr) {
        super(i);
        this.AeC = i2;
        this.AeD = i3;
        this.AeE = i4;
        this.AeF = i5;
        this.AeG = sArr;
        this.AeH = bVarArr;
        this.AeI = aVarArr;
    }
}
