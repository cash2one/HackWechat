package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.9;
import com.tencent.mm.plugin.wallet_core.id_verify.model.f;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a.a;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$9$2 implements a {
    final /* synthetic */ 9 oYU;

    WalletOfflineCoinPurseUI$9$2(9 9) {
        this.oYU = 9;
    }

    public final boolean b(int i, int i2, String str, boolean z) {
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "getDisclaimer   resultCode=" + i + ";errCode=" + i2 + ";errMsg=" + str + ";hadAgree = " + z);
        if (i == 2) {
            this.oYU.oYH.b(new f("reward"), false);
        } else if (i == 0 && z) {
            this.oYU.oYH.b(new f("reward"), false);
        } else if (WalletOfflineCoinPurseUI.o(this.oYU.oYH) != null) {
            WalletOfflineCoinPurseUI.o(this.oYU.oYH).dismiss();
        }
        return true;
    }
}
