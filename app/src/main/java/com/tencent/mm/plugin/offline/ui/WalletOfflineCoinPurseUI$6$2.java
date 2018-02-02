package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.6;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$6$2 implements a {
    final /* synthetic */ 6 oYQ;

    WalletOfflineCoinPurseUI$6$2(6 6) {
        this.oYQ = 6;
    }

    public final boolean b(int i, int i2, String str, boolean z) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
        if (i == 2) {
            this.oYQ.oYH.b(new f("collect"), false);
        } else if (i == 0 && z) {
            this.oYQ.oYH.b(new f("collect"), false);
        } else if (WalletOfflineCoinPurseUI.o(this.oYQ.oYH) != null) {
            WalletOfflineCoinPurseUI.o(this.oYQ.oYH).dismiss();
        }
        return true;
    }
}
