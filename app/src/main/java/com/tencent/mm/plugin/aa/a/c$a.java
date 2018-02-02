package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.j;
import com.tencent.mm.protocal.c.v;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public class c$a implements e<v, f<String, Integer, String, String, Integer>> {
    final /* synthetic */ c igk;

    public c$a(c cVar) {
        this.igk = cVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        f fVar = (f) obj;
        b bVar = this.igk.igi;
        k jVar = new j((String) fVar.get(0), ((Integer) fVar.get(1)).intValue(), (String) fVar.get(2), (String) fVar.get(3), ((Integer) fVar.get(4)).intValue());
        g.Dk();
        g.Di().gPJ.a(jVar, 0);
        bVar.igh = com.tencent.mm.vending.g.g.czX();
        return null;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
