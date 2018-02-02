package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class p extends a<p> {
    public int Afi;
    public int Afj;
    public int Afk;

    public final /* synthetic */ int compareTo(Object obj) {
        p pVar = (p) obj;
        if (this.Afi != pVar.Afi) {
            return c.fI(this.Afi, pVar.Afi);
        }
        return this.Afj != pVar.Afj ? c.fI(this.Afj, pVar.Afj) : c.fI(this.Afk, pVar.Afk);
    }

    public p(int i, int i2, int i3, int i4) {
        super(i);
        this.Afi = i2;
        this.Afk = i3;
        this.Afj = i4;
    }
}
