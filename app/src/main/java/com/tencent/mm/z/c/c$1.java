package com.tencent.mm.z.c;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

class c$1 implements a {
    final /* synthetic */ c hiE;

    c$1(c cVar) {
        this.hiE = cVar;
    }

    public final void a(d.a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        x.d("MicroMsg.SubCoreNewABTest", "Message content(abtest): %s" + a);
        a$a im = a.im(a);
        if (im != null) {
            c.IF().i(im.hiv, 1);
            c.IG().i(im.hiw, 2);
        }
    }
}
