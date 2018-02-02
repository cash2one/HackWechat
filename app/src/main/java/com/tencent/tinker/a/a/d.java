package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class d extends t$a$a<d> {
    public int Aej;
    public int[][] Aek;
    public int[][] Ael;
    public int[][] Aem;

    public final /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        if (this.Aej != dVar.Aej) {
            return c.fI(this.Aej, dVar.Aej);
        }
        int length = this.Aek.length;
        int length2 = this.Ael.length;
        int length3 = this.Aem.length;
        int length4 = dVar.Aek.length;
        int length5 = dVar.Ael.length;
        int length6 = dVar.Aem.length;
        if (length != length4) {
            return c.fJ(length, length4);
        }
        if (length2 != length5) {
            return c.fJ(length2, length5);
        }
        if (length3 != length6) {
            return c.fJ(length3, length6);
        }
        for (length4 = 0; length4 < length; length4++) {
            length5 = this.Aek[length4][0];
            length6 = this.Aek[length4][1];
            int i = dVar.Aek[length4][0];
            int i2 = dVar.Aek[length4][1];
            if (length5 != i) {
                return c.fI(length5, i);
            }
            if (length6 != i2) {
                return c.fJ(length6, i2);
            }
        }
        for (length4 = 0; length4 < length2; length4++) {
            length = this.Ael[length4][0];
            length5 = this.Ael[length4][1];
            length6 = dVar.Ael[length4][0];
            i = dVar.Ael[length4][1];
            if (length != length6) {
                return c.fI(length, length6);
            }
            if (length5 != i) {
                return c.fJ(length5, i);
            }
        }
        for (length4 = 0; length4 < length3; length4++) {
            length = this.Aem[length4][0];
            length2 = this.Aem[length4][1];
            length5 = dVar.Aem[length4][0];
            length6 = dVar.Aem[length4][1];
            if (length != length5) {
                return c.fI(length, length5);
            }
            if (length2 != length6) {
                return c.fJ(length2, length6);
            }
        }
        return 0;
    }

    public d(int i, int i2, int[][] iArr, int[][] iArr2, int[][] iArr3) {
        super(i);
        this.Aej = i2;
        this.Aek = iArr;
        this.Ael = iArr2;
        this.Aem = iArr3;
    }
}
