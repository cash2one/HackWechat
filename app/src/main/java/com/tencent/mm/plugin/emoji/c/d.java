package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.g.a.nz;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<nz> {
    public d() {
        this.xen = nz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nz nzVar = (nz) bVar;
        if (nzVar instanceof nz) {
            if (nzVar.fFS.fqm == 0) {
                com.tencent.mm.plugin.emoji.model.d aBy = i.aBy();
                long j = nzVar.fFS.fFV;
                aBy.lxs.put(Long.valueOf(j), nzVar.fFS.fFT);
            } else {
                x.i("MicroMsg.emoji.EmojiRevokeMsgListener", "has handle in sys cmd msg extension.");
            }
        }
        return false;
    }
}
