package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Parcelable;
import com.tencent.mm.g.a.sw;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WalletBindCardResultUI$1 extends c<sw> {
    final /* synthetic */ WalletBindCardResultUI sRR;

    WalletBindCardResultUI$1(WalletBindCardResultUI walletBindCardResultUI) {
        this.sRR = walletBindCardResultUI;
        this.xen = sw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sw swVar = (sw) bVar;
        if (!(swVar instanceof sw)) {
            return false;
        }
        if (!swVar.fLl.fLm.oXv) {
            x.i("MicroMsg.WalletBindCardResultUI", "block pass");
            return true;
        } else if (!"1".equals(swVar.fLl.fLm.fKP) && !"2".equals(swVar.fLl.fLm.fKP)) {
            return false;
        } else {
            Parcelable realnameGuideHelper = new RealnameGuideHelper();
            realnameGuideHelper.a(swVar.fLl.fLm.fKP, swVar.fLl.fLm.fKQ, swVar.fLl.fLm.fKR, swVar.fLl.fLm.fKS, swVar.fLl.fLm.fKT, WalletBindCardResultUI.a(this.sRR) == null ? 0 : WalletBindCardResultUI.a(this.sRR).fCV);
            x.i("MicroMsg.WalletBindCardResultUI", "receive guide");
            this.sRR.vf.putParcelable("key_realname_guide_helper", realnameGuideHelper);
            return false;
        }
    }
}
