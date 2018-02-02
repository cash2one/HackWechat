package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class g$b implements e<Boolean, Void> {
    final /* synthetic */ g ihL;

    public g$b(g gVar) {
        this.ihL = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        a aVar = this.ihL.ihE;
        String stringExtra = aVar.zAZ.getStringExtra("bill_no");
        int intExtra = aVar.zAZ.getIntExtra("enter_scene", 0);
        g.a(g.a(stringExtra, Integer.valueOf(intExtra), aVar.zAZ.getStringExtra("chatroom")).b(aVar.ihC.igA));
        return null;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
