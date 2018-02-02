package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class m$3 implements a {
    final /* synthetic */ m sni;

    m$3(m mVar) {
        this.sni = mVar;
    }

    public final boolean uF() {
        x.v("MicroMsg.Voip.VoipService", "voip repeat check is foreground");
        if (m.b(this.sni) == null) {
            m.c(this.sni);
            m.d(this.sni).TG();
            return false;
        } else if (m.dC(ac.getContext())) {
            this.sni.N(m.b(this.sni).wbh, m.b(this.sni).wbi);
            this.sni.a(m.b(this.sni));
            m.e(this.sni);
            m.c(this.sni);
            m.d(this.sni).TG();
            g.pQN.a(500, 5, 1, false);
            return false;
        } else if (System.currentTimeMillis() - m.f(this.sni) < 60000) {
            return true;
        } else {
            m.e(this.sni);
            m.c(this.sni);
            m.d(this.sni).TG();
            return false;
        }
    }
}
