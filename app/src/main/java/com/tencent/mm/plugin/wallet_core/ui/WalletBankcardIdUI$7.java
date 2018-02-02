package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.wallet_core.ui.e;

class WalletBankcardIdUI$7 implements OnClickListener {
    final /* synthetic */ WalletBankcardIdUI sRo;

    WalletBankcardIdUI$7(WalletBankcardIdUI walletBankcardIdUI) {
        this.sRo = walletBankcardIdUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11353, new Object[]{Integer.valueOf(2), Integer.valueOf(0)});
        e.e(this.sRo, o.bLq().azp());
    }
}
