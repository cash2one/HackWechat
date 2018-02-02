package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.5;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h.d;

class WalletCardImportUI$5$1 implements d {
    final /* synthetic */ 5 sSK;

    WalletCardImportUI$5$1(5 5) {
        this.sSK = 5;
    }

    public final void cn(int i, int i2) {
        Intent intent = new Intent();
        switch (i) {
            case 0:
                intent.putExtra("rawUrl", this.sSK.sSH.getString(i.uOH, new Object[]{w.cfi()}));
                break;
            case 1:
                if (WalletCardImportUI.c(this.sSK.sSH) != null) {
                    intent.putExtra("rawUrl", this.sSK.sSH.getString(i.uOG, new Object[]{w.cfi(), WalletCardImportUI.c(this.sSK.sSH).oZz}));
                    break;
                }
                break;
        }
        intent.putExtra("showShare", false);
        com.tencent.mm.bm.d.b(this.sSK.sSH.mController.xIM, "webview", ".ui.tools.WebViewUI", intent);
    }
}
