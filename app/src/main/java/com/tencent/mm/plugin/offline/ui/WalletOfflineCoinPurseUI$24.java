package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$24 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$24(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
    }

    public final void onClick(View view) {
        Object[] objArr = new Object[1];
        k.bgX();
        k.bha();
        objArr[0] = Integer.valueOf(i.bgW());
        x.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", objArr);
        k.bgX();
        k.bha();
        if (i.bgW() <= 0) {
            this.oYH.r(new m(((int) (System.currentTimeMillis() / 1000)), 10));
            return;
        }
        WalletOfflineCoinPurseUI.I(this.oYH);
    }
}
