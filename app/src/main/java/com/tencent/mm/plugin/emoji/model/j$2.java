package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.g.a.cq;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class j$2 extends c<cq> {
    final /* synthetic */ j lyp;

    j$2(j jVar) {
        this.lyp = jVar;
        this.xen = cq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cq cqVar = (cq) bVar;
        if (this.lyp.lyk.contains(cqVar.fqQ.fqR)) {
            this.lyp.lym.remove(cqVar.fqQ.fqR);
            if (cqVar.fqQ.success) {
                x.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s success", cqVar.fqQ.fqR);
                i.aBE().lwM.XQ(cqVar.fqQ.fqR);
                ar.CG().a(new q(cqVar.fqQ.fqR, 2), 0);
            } else {
                x.i("MicroMsg.emoji.WearEmojiLogic", "emoji downloaded %s fail", cqVar.fqQ.fqR);
            }
            this.lyp.aBI();
        }
        return false;
    }
}
