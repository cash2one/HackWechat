package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.a.ck;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class an$4 extends c<ck> {
    final /* synthetic */ an vft;

    an$4(an anVar) {
        this.vft = anVar;
        this.xen = ck.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = bh.getInt(g.zY().getValue("AndroidUseUnicodeEmoji"), 0);
        b crVar = new cr();
        crVar.fqS.fqT = i;
        a.xef.m(crVar);
        return false;
    }
}
