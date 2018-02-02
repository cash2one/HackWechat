package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.c.f.2;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class g$f implements e<Boolean, Void> {
    final /* synthetic */ g ihL;

    public g$f(g gVar) {
        this.ihL = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        a aVar = this.ihL.ihE;
        String stringExtra = aVar.zAZ.getStringExtra("bill_no");
        String stringExtra2 = aVar.zAZ.getStringExtra("chatroom");
        int intExtra = aVar.zAZ.getIntExtra("enter_scene", 0);
        x.i("MicroMsg.PaylistAAInteractor", "urgeAAPay");
        b czQ = g.czQ();
        czQ.czP();
        new com.tencent.mm.plugin.aa.a.a.b(stringExtra, stringExtra2, intExtra).JV().f(new 2(aVar, czQ));
        return null;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
