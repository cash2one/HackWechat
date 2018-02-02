package com.tencent.mm.plugin.ext.c;

import com.tencent.mm.g.a.bc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class c$1 extends c<bc> {
    c$1() {
        this.xen = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bc bcVar = (bc) bVar;
        if (bcVar.fpl.fpm == 46 && bcVar.fpl.fpn == 0) {
            x.i("MicroMsg.ExtQbarDataManager", "hy: got ext qrcode config. trigger copy");
            c.ej(bcVar.fpl.filePath);
            c.uc();
        }
        return false;
    }
}
