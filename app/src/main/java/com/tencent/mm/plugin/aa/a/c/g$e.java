package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class g$e implements e<Void, d<String, String, String>> {
    final /* synthetic */ g ihL;

    public g$e(g gVar) {
        this.ihL = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        d dVar = (d) obj;
        a aVar = this.ihL.ihE;
        String str = (String) dVar.get(1);
        h.b(str, aVar.zAZ.getStringExtra("chatroom"), aVar.zAZ.getStringExtra("bill_no"), (String) dVar.get(0), (String) dVar.get(2));
        return zBS;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
