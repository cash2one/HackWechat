package com.tencent.mm.plugin.wallet.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;

class WalletBankcardManageUI$6 implements OnClickListener {
    final /* synthetic */ WalletBankcardManageUI sCF;
    final /* synthetic */ f sCH;

    WalletBankcardManageUI$6(WalletBankcardManageUI walletBankcardManageUI, f fVar) {
        this.sCF = walletBankcardManageUI;
        this.sCH = fVar;
    }

    public final void onClick(View view) {
        if (!bh.ov(this.sCH.sLB)) {
            e.l(this.sCF.mController.xIM, this.sCH.sLB, false);
        }
    }
}
