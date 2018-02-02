package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;

class WalletOfflineCoinPurseUI$14 implements OnClickListener {
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;

    WalletOfflineCoinPurseUI$14(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI) {
        this.oYH = walletOfflineCoinPurseUI;
    }

    public final void onClick(View view) {
        if (view.getId() != f.uAa && view.getId() != f.uyf && view.getId() != f.uyg) {
            return;
        }
        if (view.getId() == f.uAa && WalletOfflineCoinPurseUI.u(this.oYH) != null && WalletOfflineCoinPurseUI.u(this.oYH).isShowing()) {
            x.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if ((WalletOfflineCoinPurseUI.u(this.oYH) == null || !WalletOfflineCoinPurseUI.u(this.oYH).isShowing()) && currentTimeMillis - WalletOfflineCoinPurseUI.v(this.oYH) >= 400 && a.bhH() && !WalletOfflineCoinPurseUI.w(this.oYH)) {
            if (view.getId() == f.uAa) {
                WalletOfflineCoinPurseUI.a(this.oYH, false);
            } else if (view.getId() == f.uyf || view.getId() == f.uyg) {
                g.pQN.h(13958, new Object[]{Integer.valueOf(4)});
                WalletOfflineCoinPurseUI.a(this.oYH, true);
            }
            if (WalletOfflineCoinPurseUI.x(this.oYH) != null) {
                WalletOfflineCoinPurseUI.y(this.oYH);
                WalletOfflineCoinPurseUI.x(this.oYH).u(view, WalletOfflineCoinPurseUI.z(this.oYH));
            }
            WalletOfflineCoinPurseUI.a(this.oYH, currentTimeMillis);
        }
    }
}
