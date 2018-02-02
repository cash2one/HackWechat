package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.e;

class WalletForgotPwdUI$3 implements OnClickListener {
    final /* synthetic */ WalletForgotPwdUI sGW;

    WalletForgotPwdUI$3(WalletForgotPwdUI walletForgotPwdUI) {
        this.sGW = walletForgotPwdUI;
    }

    public final void onClick(View view) {
        g.pQN.h(11353, Integer.valueOf(2), Integer.valueOf(0));
        MMActivity mMActivity = this.sGW;
        p.bJN();
        e.e(mMActivity, p.bJO().azp());
    }
}
