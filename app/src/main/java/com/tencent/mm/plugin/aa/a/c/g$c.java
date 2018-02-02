package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class g$c implements e<Void, d<Long, String, String>> {
    final /* synthetic */ g ihL;

    public g$c(g gVar) {
        this.ihL = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        a aVar = this.ihL.ihE;
        long longValue = ((Long) dVar.get(0)).longValue();
        String str = (String) dVar.get(1);
        String str2 = (String) dVar.get(2);
        b czQ = g.czQ();
        String stringExtra = aVar.zAZ.getStringExtra("bill_no");
        int intExtra = aVar.zAZ.getIntExtra("enter_scene", 0);
        String stringExtra2 = aVar.zAZ.getStringExtra("chatroom");
        czQ.czP();
        new com.tencent.mm.plugin.aa.a.a.a(stringExtra, longValue, intExtra, stringExtra2, str, str2).JV().f(new f$1(aVar, czQ));
        return zBS;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
