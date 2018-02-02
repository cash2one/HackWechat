package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.g.a.jx;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.rb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class d$6 extends c<rb> {
    final /* synthetic */ d kYZ;

    d$6(d dVar) {
        this.kYZ = dVar;
        this.xen = rb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rb rbVar = (rb) bVar;
        if (rbVar.fIQ.fIR.equals(ju.class.getName())) {
            if (rbVar.fIQ.fut == 1) {
                d.a(this.kYZ).bYj();
            } else {
                d.a(this.kYZ).aUT();
            }
        } else if (rbVar.fIQ.fIR.equals(jx.class.getName())) {
            if (rbVar.fIQ.fut == 1) {
                d.b(this.kYZ).bYj();
            } else {
                d.b(this.kYZ).aUT();
            }
        } else if (rbVar.fIQ.fIR.equals(jv.class.getName())) {
            if (rbVar.fIQ.fut == 1) {
                d.c(this.kYZ).bYj();
            } else {
                d.c(this.kYZ).aUT();
            }
        } else if (rbVar.fIQ.fIR.equals(jw.class.getName())) {
            if (rbVar.fIQ.fut == 1) {
                d.d(this.kYZ).bYj();
            } else {
                d.d(this.kYZ).aUT();
            }
        } else if (rbVar.fIQ.fIR.equals(kb.class.getName())) {
            if (rbVar.fIQ.fut == 1) {
                d.e(this.kYZ).bYj();
            } else {
                d.e(this.kYZ).aUT();
            }
        }
        return false;
    }
}
