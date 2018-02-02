package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e extends com.tencent.tinker.a.a.t.a.a<e> {
    public a[] Aen;
    public a[] Aeo;
    public b[] Aep;
    public b[] Aeq;

    public static class a implements Comparable<a> {
        public int Aer;
        public int Aes;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int fI = c.fI(this.Aer, aVar.Aer);
            return fI != 0 ? fI : c.fJ(this.Aes, aVar.Aes);
        }

        public a(int i, int i2) {
            this.Aer = i;
            this.Aes = i2;
        }
    }

    public static class b implements Comparable<b> {
        public int Aes;
        public int Aet;
        public int Aeu;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int fI = c.fI(this.Aet, bVar.Aet);
            if (fI != 0) {
                return fI;
            }
            fI = c.fJ(this.Aes, bVar.Aes);
            return fI == 0 ? c.fJ(this.Aeu, bVar.Aeu) : fI;
        }

        public b(int i, int i2, int i3) {
            this.Aet = i;
            this.Aes = i2;
            this.Aeu = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        e eVar = (e) obj;
        int a = c.a(this.Aen, eVar.Aen);
        if (a != 0) {
            return a;
        }
        a = c.a(this.Aeo, eVar.Aeo);
        if (a != 0) {
            return a;
        }
        a = c.a(this.Aep, eVar.Aep);
        return a == 0 ? c.a(this.Aeq, eVar.Aeq) : a;
    }

    public e(int i, a[] aVarArr, a[] aVarArr2, b[] bVarArr, b[] bVarArr2) {
        super(i);
        this.Aen = aVarArr;
        this.Aeo = aVarArr2;
        this.Aep = bVarArr;
        this.Aeq = bVarArr2;
    }
}
