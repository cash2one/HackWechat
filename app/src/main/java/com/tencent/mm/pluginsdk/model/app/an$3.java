package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.g.a.hd;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class an$3 extends c<hd> {
    final /* synthetic */ an vft;

    an$3(an anVar) {
        this.vft = anVar;
        this.xen = hd.class.getName().hashCode();
    }

    private static boolean a(hd hdVar) {
        int i;
        try {
            if (g.zY() == null) {
                i = 0;
            } else {
                i = bh.getInt(g.zY().getValue("AndroidUseUnicodeEmoji"), 0);
            }
        } catch (Exception e) {
            i = 0;
        }
        hdVar.fxp.fqT = i;
        return false;
    }
}
