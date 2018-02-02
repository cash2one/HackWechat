package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class j$11 implements e {
    final /* synthetic */ j xFL;

    j$11(j jVar) {
        this.xFL = jVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + kVar.getType());
        if (this.xFL.iln != null) {
            this.xFL.iln.dismiss();
            this.xFL.iln = null;
        }
        if (kVar.getType() == 255) {
            ar.CG().b(255, this.xFL.xFH);
            if (i == 0 && i2 == 0) {
                this.xFL.hN(true);
            } else if (!a.a(this.xFL.xFE, i, i2, str, 4)) {
                this.xFL.hN(false);
            }
        } else if (kVar.getType() != 384) {
        } else {
            if (i == 0 && i2 == 0) {
                ar.Hg();
                c.CU().set(77830, ((al) kVar).NW());
                Intent intent = new Intent();
                intent.putExtra("kintent_hint", this.xFL.getString(R.l.eLU));
                d.b(this.xFL.xFE, "accountsync", "com.tencent.mm.ui.account.RegByMobileSetPwdUI", intent);
                return;
            }
            this.xFL.qiE = true;
            h.a(this.xFL.xFE, R.l.eMi, R.l.dGO, new 1(this));
        }
    }
}
