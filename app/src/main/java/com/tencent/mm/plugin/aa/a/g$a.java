package com.tencent.mm.plugin.aa.a;

import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;

public class g$a implements e<c<String, String>, com.tencent.mm.vending.j.e<String, Long, Integer, String>> {
    final /* synthetic */ g igy;

    public g$a(g gVar) {
        this.igy = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
        f fVar = this.igy.igw;
        String str = (String) eVar.get(0);
        long longValue = ((Long) eVar.get(1)).longValue();
        int intValue = ((Integer) eVar.get(2)).intValue();
        String str2 = (String) eVar.get(3);
        if (fVar.igv) {
            x.e("MicroMsg.AAPayLogic", "aaPay, isPaying!");
        } else {
            k iVar = new i(str, longValue, intValue, str2);
            g.Dk();
            g.Di().gPJ.a(iVar, 0);
            fVar.igh = com.tencent.mm.vending.g.g.czX();
            fVar.igv = true;
        }
        return null;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
