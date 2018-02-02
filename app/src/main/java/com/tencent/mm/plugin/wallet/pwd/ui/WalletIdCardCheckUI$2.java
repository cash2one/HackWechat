package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.wallet_core.c.f;

class WalletIdCardCheckUI$2 implements OnClickListener {
    final /* synthetic */ WalletIdCardCheckUI sHd;

    WalletIdCardCheckUI$2(WalletIdCardCheckUI walletIdCardCheckUI) {
        this.sHd = walletIdCardCheckUI;
    }

    public final void onClick(View view) {
        if (WalletIdCardCheckUI.a(this.sHd)) {
            g.pQN.h(13731, new Object[]{Integer.valueOf(2)});
            this.sHd.l(new f(WalletIdCardCheckUI.b(this.sHd).getText(), WalletIdCardCheckUI.c(this.sHd), o.bLq().azp()));
        }
    }
}
