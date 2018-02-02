package com.tencent.mm.ui.bindmobile;

import com.tencent.mm.modelfriend.a$b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class MobileFriendUI$10 implements a$b {
    final /* synthetic */ MobileFriendUI ymF;

    MobileFriendUI$10(MobileFriendUI mobileFriendUI) {
        this.ymF = mobileFriendUI;
    }

    public final void bM(boolean z) {
        x.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            System.currentTimeMillis();
            ar.CG().a(new aa(m.NU(), m.NT()), 0);
        } else if (MobileFriendUI.b(this.ymF) != null) {
            MobileFriendUI.b(this.ymF).dismiss();
            MobileFriendUI.c(this.ymF);
        }
    }
}
