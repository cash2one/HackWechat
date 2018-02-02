package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;

public final class a extends o {
    private String chatroomName;
    private List<String> iiE = c.Fh().hH(this.chatroomName);

    public a(l lVar, String str) {
        super(lVar, null, true, true);
        this.chatroomName = str;
        x.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
        ar.Hg();
        if (this.iiE == null) {
            this.iiE = new ArrayList();
        }
    }

    protected final com.tencent.mm.ui.contact.a.a jb(int i) {
        String str = (String) this.iiE.get(i);
        ar.Hg();
        com.tencent.mm.storage.x WO = c.EY().WO(str);
        com.tencent.mm.ui.contact.a.a aVar = new com.tencent.mm.plugin.multitalk.ui.widget.a(i);
        aVar.jLe = WO;
        aVar.ySW = btz();
        return aVar;
    }

    public final int getCount() {
        return this.iiE.size();
    }
}
