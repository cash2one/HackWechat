package com.tencent.mm.plugin.setting;

import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.setting.b.1;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.c;

class b$1$1 implements Runnable {
    final /* synthetic */ String hpU;
    final /* synthetic */ 1 qfY;

    b$1$1(1 1, String str) {
        this.qfY = 1;
        this.hpU = str;
    }

    public final void run() {
        ar.Hg();
        af WO = c.EY().WO(this.hpU);
        if (WO != null && !a.fZ(WO.field_type) && WO.AD() && !WO.AE()) {
            au auVar = new au();
            auVar.eR(0);
            auVar.dS(this.hpU);
            auVar.eQ(6);
            auVar.setContent(ac.getContext().getString(R.l.eLz));
            auVar.aq(ba.n(this.hpU, System.currentTimeMillis() / 1000));
            auVar.setType(10000);
            ar.Hg();
            c.Fa().Q(auVar);
            x.i("MicroMsg.SubCoreSetting", "insert chatcontact verify sysmsg. %s", new Object[]{this.hpU});
        }
    }
}
