package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class r extends a<r> {
    public int Afl;
    public int Afm;
    public int Afn;

    public final /* synthetic */ int compareTo(Object obj) {
        r rVar = (r) obj;
        int fI = c.fI(this.Afl, rVar.Afl);
        if (fI != 0) {
            return fI;
        }
        fI = c.fI(this.Afm, rVar.Afm);
        return fI == 0 ? c.fJ(this.Afn, rVar.Afn) : fI;
    }

    public r(int i, int i2, int i3, int i4) {
        super(i);
        this.Afl = i2;
        this.Afm = i3;
        this.Afn = i4;
    }
}
