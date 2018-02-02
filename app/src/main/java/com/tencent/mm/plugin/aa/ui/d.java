package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.List;

public final class d extends o {
    private String chatroomName;
    private List<String> iiE = h.oA(this.chatroomName);

    public d(l lVar, String str) {
        super(lVar, null, true, true);
        this.chatroomName = str;
        x.i("MicroMsg.AASelectInitAdapter", "resetData");
    }

    protected final a jb(int i) {
        String str = (String) this.iiE.get(i);
        g.Dk();
        com.tencent.mm.storage.x WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(str);
        a cVar = new c(i);
        cVar.fpF = this.chatroomName;
        cVar.jLe = WO;
        cVar.ySW = true;
        return cVar;
    }

    public final int getCount() {
        return this.iiE.size();
    }
}
