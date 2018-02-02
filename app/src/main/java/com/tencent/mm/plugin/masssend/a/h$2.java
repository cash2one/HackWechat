package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.ae.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.bs.a;

class h$2 implements a {
    final /* synthetic */ h onb;

    h$2(h hVar) {
        this.onb = hVar;
    }

    public final void a(d.a aVar) {
        String a = n.a(aVar.hmq.vGZ);
        x.i("MicroMsg.SubCoreMassSend", "MassSendTopConfXml:" + a);
        h.aYE().Ef(a);
        h.aYE().aYz();
        h.aYE();
        c.dG(bh.Wp());
    }
}
