package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

class m$4 implements a {
    final /* synthetic */ m qoh;

    m$4(m mVar) {
        this.qoh = mVar;
    }

    public final void a(d.a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        if (a == null || a.length() == 0) {
            x.e("MicroMsg.SubCoreShake", "onReceiveMsg, ShakeCardEntranceMsg msgContent is null");
        } else {
            m.a(this.qoh).post(new 1(this, a, aVar));
        }
    }
}
