package com.tencent.mm.ui.chatting.e;

import com.tencent.mm.plugin.appbrand.p.b.a;
import com.tencent.mm.plugin.appbrand.p.d;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Iterator;
import java.util.LinkedList;

class a$1 implements a {
    final /* synthetic */ boolean yHb = true;
    final /* synthetic */ a yHc;

    a$1(a aVar, boolean z) {
        this.yHc = aVar;
    }

    public final void t(LinkedList<d> linkedList) {
        if (!bh.cA(linkedList)) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                this.yHc.jRt.add(new a.a(this.yHc, dVar.timestamp, dVar.type, dVar.title, dVar.fqm, dVar.username, dVar.fpL, dVar.bgp, dVar.jRH, dVar.hdy, dVar.fEt, dVar.fFo, dVar.desc, dVar.imagePath));
            }
        }
        this.yHc.yHi = this.yHc.jRt;
        if (this.yHc.yHf != null) {
            this.yHc.yHf.z(this.yHb, this.yHc.jRt.size());
        }
    }
}
