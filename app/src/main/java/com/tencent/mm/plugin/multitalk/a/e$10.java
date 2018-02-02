package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class e$10 implements a {
    final /* synthetic */ e oGz;

    e$10(e eVar) {
        this.oGz = eVar;
    }

    public final boolean uF() {
        x.v("MicroMsg.MT.MultiTalkManager", "voip repeat check is foreground");
        if (this.oGz.oGt == null) {
            this.oGz.oGu = 0;
            this.oGz.oGv.TG();
            return false;
        } else if (e.df(ac.getContext())) {
            this.oGz.b(this.oGz.oGt);
            this.oGz.oGt = null;
            this.oGz.oGu = 0;
            this.oGz.oGv.TG();
            g.pQN.a(500, 7, 1, false);
            return false;
        } else if (System.currentTimeMillis() - this.oGz.oGu < 60000) {
            return true;
        } else {
            this.oGz.oGt = null;
            this.oGz.oGu = 0;
            this.oGz.oGv.TG();
            return false;
        }
    }
}
