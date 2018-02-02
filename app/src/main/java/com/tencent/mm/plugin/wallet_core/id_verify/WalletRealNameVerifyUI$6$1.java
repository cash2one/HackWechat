package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.6;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h.d;

class WalletRealNameVerifyUI$6$1 implements d {
    final /* synthetic */ 6 sJP;

    WalletRealNameVerifyUI$6$1(6 6) {
        this.sJP = 6;
    }

    public final void cn(int i, int i2) {
        Intent intent = new Intent();
        switch (i) {
            case 0:
                intent.putExtra("rawUrl", this.sJP.sJO.getString(i.uOH, new Object[]{w.cfi()}));
                break;
            case 1:
                if (WalletRealNameVerifyUI.e(this.sJP.sJO) != null) {
                    intent.putExtra("rawUrl", this.sJP.sJO.getString(i.uOG, new Object[]{w.cfi(), WalletRealNameVerifyUI.e(this.sJP.sJO).oZz}));
                    break;
                }
                break;
        }
        intent.putExtra("showShare", false);
        com.tencent.mm.bm.d.b(this.sJP.sJO.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
