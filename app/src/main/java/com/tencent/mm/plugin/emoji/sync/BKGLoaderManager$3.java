package com.tencent.mm.plugin.emoji.sync;

import com.tencent.mm.g.a.cq;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class BKGLoaderManager$3 extends c<cq> {
    final /* synthetic */ BKGLoaderManager lzX;

    BKGLoaderManager$3(BKGLoaderManager bKGLoaderManager) {
        this.lzX = bKGLoaderManager;
        this.xen = cq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cq cqVar = (cq) bVar;
        if ((cqVar instanceof cq) && !bh.ov(cqVar.fqQ.fqR)) {
            this.lzX.k(cqVar.fqQ.fqR, cqVar.fqQ.fpr, cqVar.fqQ.success);
        }
        return false;
    }
}
