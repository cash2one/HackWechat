package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class f$5 extends c<rb> {
    final /* synthetic */ f oOg;

    f$5(f fVar) {
        this.oOg = fVar;
        this.xen = rb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rb rbVar = (rb) bVar;
        if (rbVar.fIQ.fIR.equals(jy.class.getName())) {
            if (rbVar.fIQ.fut == 1) {
                this.oOg.oOc.bYj();
            } else {
                this.oOg.oOc.aUT();
            }
        } else if (rbVar.fIQ.fIR.equals(jz.class.getName())) {
            if (rbVar.fIQ.fut == 1) {
                this.oOg.oOd.bYj();
            } else {
                this.oOg.oOd.aUT();
            }
        } else if (rbVar.fIQ.fIR.equals(ip.class.getName())) {
            if (rbVar.fIQ.fut == 1) {
                this.oOg.oOe.aaZ();
            } else {
                this.oOg.oOe.unregister();
            }
        }
        return false;
    }
}
