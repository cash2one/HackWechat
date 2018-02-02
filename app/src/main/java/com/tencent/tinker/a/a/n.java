package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class n extends a<n> {
    public int Aev;
    public int Afi;
    public int Afj;

    public final /* synthetic */ int compareTo(Object obj) {
        n nVar = (n) obj;
        if (this.Afi != nVar.Afi) {
            return c.fI(this.Afi, nVar.Afi);
        }
        return this.Afj != nVar.Afj ? c.fI(this.Afj, nVar.Afj) : c.fI(this.Aev, nVar.Aev);
    }

    public n(int i, int i2, int i3, int i4) {
        super(i);
        this.Afi = i2;
        this.Aev = i3;
        this.Afj = i4;
    }
}
