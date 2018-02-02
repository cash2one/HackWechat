package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.protocal.c.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class g$d implements e<v, Void> {
    final /* synthetic */ g ihL;

    public g$d(g gVar) {
        this.ihL = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        a aVar = this.ihL.ihE;
        String stringExtra = aVar.zAZ.getStringExtra("bill_no");
        int intExtra = aVar.zAZ.getIntExtra("enter_scene", 0);
        String stringExtra2 = aVar.zAZ.getStringExtra("chatroom");
        String stringExtra3 = aVar.zAZ.getStringExtra("key_sign");
        int intExtra2 = aVar.zAZ.getIntExtra("key_ver", 0);
        x.i("MicroMsg.PaylistAAInteractor", "getPayListDetail, billNo: %s, scene: %s, chatRoom: %s", new Object[]{stringExtra, Integer.valueOf(intExtra), stringExtra2});
        g.a(g.a(stringExtra, Integer.valueOf(intExtra), stringExtra2, stringExtra3, Integer.valueOf(intExtra2)).b(aVar.ihA.igj));
        return null;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
