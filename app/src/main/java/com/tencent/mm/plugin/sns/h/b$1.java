package com.tencent.mm.plugin.sns.h;

import com.tencent.mm.g.a.qh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

class b$1 extends c<qh> {
    final /* synthetic */ b rdq;

    b$1(b bVar) {
        this.rdq = bVar;
        this.xen = qh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qh qhVar = (qh) bVar;
        if (qhVar instanceof qh) {
            x.i("MicroMsg.SnsBrowseInfoHelper", "IListener callback " + this.rdq.rbt);
            if (this.rdq.rbt != -1 && this.rdq.rbt < 0) {
                Iterator it = qhVar.fHS.fHT.iterator();
                while (it.hasNext()) {
                    if (((Long) it.next()).longValue() > this.rdq.rbt) {
                        b bVar2 = this.rdq;
                        bVar2.rbE++;
                    }
                }
            }
        }
        return false;
    }
}
