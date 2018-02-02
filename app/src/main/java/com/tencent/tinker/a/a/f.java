package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class f extends a<f> {
    public int AeA;
    public int AeB;
    public int Aes;
    public int Aev;
    public int Aew;
    public int Aex;
    public int Aey;
    public int Aez;

    public final /* synthetic */ int compareTo(Object obj) {
        f fVar = (f) obj;
        int fI = c.fI(this.Aev, fVar.Aev);
        if (fI != 0) {
            return fI;
        }
        fI = c.fJ(this.Aes, fVar.Aes);
        if (fI != 0) {
            return fI;
        }
        fI = c.fI(this.Aew, fVar.Aew);
        if (fI != 0) {
            return fI;
        }
        fI = c.fJ(this.Aex, fVar.Aex);
        if (fI != 0) {
            return fI;
        }
        fI = c.fI(this.Aey, fVar.Aey);
        if (fI != 0) {
            return fI;
        }
        fI = c.fJ(this.Aez, fVar.Aez);
        if (fI != 0) {
            return fI;
        }
        fI = c.fJ(this.AeA, fVar.AeA);
        return fI == 0 ? c.fJ(this.AeB, fVar.AeB) : fI;
    }

    public f(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(i);
        this.Aev = i2;
        this.Aes = i3;
        this.Aew = i4;
        this.Aex = i5;
        this.Aey = i6;
        this.Aez = i7;
        this.AeA = i8;
        this.AeB = i9;
    }
}
