package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.wallet_core.ui.e;

class WalletForgotPwdUI$2 implements OnClickListener {
    final /* synthetic */ WalletForgotPwdUI sGW;

    WalletForgotPwdUI$2(WalletForgotPwdUI walletForgotPwdUI) {
        this.sGW = walletForgotPwdUI;
    }

    public final void onClick(View view) {
        e.l(this.sGW, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
    }
}
