package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.g.a.pc;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class m$7 extends c<rb> {
    final /* synthetic */ m qoh;

    m$7(m mVar) {
        this.qoh = mVar;
        this.xen = rb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rb rbVar = (rb) bVar;
        if (rbVar.fIQ.fIR.equals(pc.class.getName())) {
            if (rbVar.fIQ.fut == 1) {
                this.qoh.qoc.aaZ();
            } else {
                this.qoh.qoc.unregister();
            }
        }
        return false;
    }
}
