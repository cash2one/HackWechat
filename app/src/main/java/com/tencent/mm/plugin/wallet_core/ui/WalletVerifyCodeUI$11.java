package com.tencent.mm.plugin.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;

class WalletVerifyCodeUI$11 implements OnMenuItemClickListener {
    final /* synthetic */ WalletVerifyCodeUI sWR;

    WalletVerifyCodeUI$11(WalletVerifyCodeUI walletVerifyCodeUI) {
        this.sWR = walletVerifyCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String string = this.sWR.vf.getString("key_QADNA_URL");
        if (bh.ov(string)) {
            e.l(this.sWR.mController.xIM, "https://kf.qq.com/touch/sappfaq/160830qY7NJJ1608307ZJzqy.html", false);
        } else {
            e.l(this.sWR.mController.xIM, string, false);
        }
        return true;
    }
}
