package com.tencent.mm.plugin.soter.d;

import com.tencent.d.b.f.d;
import com.tencent.mm.plugin.soter.c.f;
import com.tencent.mm.plugin.soter.c.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.j.c;

public final class a implements com.tencent.mm.vending.c.a<c<Boolean, Boolean>, c<Boolean, Boolean>> {
    private b igh = null;

    public final /* synthetic */ Object call(Object obj) {
        c cVar = (c) obj;
        x.v("MicroMsg.SoterInitFunc", "alvinluo SoterInitFunc call");
        com.tencent.d.b.f.e.a aVar = new com.tencent.d.b.f.e.a();
        aVar.Adi.Ade = h.bCR();
        aVar.Adi.Adh = "WechatASK";
        aVar.Adi.Adf = new int[]{1, 2, 3};
        aVar.Adi.Add = null;
        aVar.Adi.Adg = new f();
        d eVar = new e(ac.getContext(), aVar.Adi);
        this.igh = g.czQ();
        this.igh.czP();
        eVar.Ada = new 1(this);
        if (!com.tencent.d.b.f.f.cGi().a(eVar, new com.tencent.d.b.a.d())) {
            x.e("MicroMsg.SoterInitFunc", "alvinluo: add soterTaskInitForWX failed.");
        }
        x.v("MicroMsg.SoterInitFunc", "alvinluo pending %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        return cVar;
    }
}
