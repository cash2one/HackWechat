package com.tencent.mm.bc;

import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class k {
    private static k hLf = new k();
    public a hLd = new a();
    public a hLe = new a();

    public static k Re() {
        return hLf;
    }

    private k() {
        ar.Hg();
        String str = (String) c.CU().get(a.xwd, "");
        ar.Hg();
        String str2 = (String) c.CU().get(a.xxA, "");
        this.hLd.parse(str);
        this.hLe.parse(str2);
    }

    public final void save() {
        Object Rf = this.hLd == null ? "" : this.hLd.Rf();
        ar.Hg();
        c.CU().a(a.xwd, Rf);
        Rf = this.hLe == null ? "" : this.hLe.Rf();
        ar.Hg();
        c.CU().a(a.xxA, Rf);
    }
}
