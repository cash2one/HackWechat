package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.protocal.c.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class g$a implements e<o, Long> {
    final /* synthetic */ g ihL;

    public g$a(g gVar) {
        this.ihL = gVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        Long l = (Long) obj;
        a aVar = this.ihL.ihE;
        long longValue = l.longValue();
        String stringExtra = aVar.zAZ.getStringExtra("bill_no");
        String stringExtra2 = aVar.zAZ.getStringExtra("chatroom");
        int i = aVar.zAZ.getIntExtra("enter_scene", 0) == 1 ? com.tencent.mm.plugin.aa.a.a.ifZ : com.tencent.mm.plugin.aa.a.a.iga;
        x.i("MicroMsg.PaylistAAInteractor", "aaPay, payAmount: %s, billNo: %s, chatroom: %s", new Object[]{Long.valueOf(longValue), stringExtra, stringExtra2});
        g.a(g.a(stringExtra, Long.valueOf(longValue), Integer.valueOf(i), stringExtra2).b(aVar.ihB.igx));
        return null;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
