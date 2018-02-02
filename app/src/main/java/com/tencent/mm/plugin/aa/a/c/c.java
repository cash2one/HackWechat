package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.z.q;

public class c extends a {
    static /* synthetic */ a a(c cVar) {
        String stringExtra = cVar.zAZ.getStringExtra("chatroom");
        if (bh.ov(stringExtra)) {
            return null;
        }
        a aVar = new a(cVar);
        aVar.gIW = h.oA(stringExtra);
        if (aVar.gIW == null || aVar.gIW.size() <= 0) {
            return aVar;
        }
        aVar.gIW.remove(q.FS());
        return aVar;
    }

    protected final void onCreate() {
        super.onCreate();
        a(a.class, new 1(this));
    }
}
