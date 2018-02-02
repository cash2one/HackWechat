package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletSecuritySettingUI$3 implements OnClickListener {
    final /* synthetic */ WalletSecuritySettingUI sHN;

    WalletSecuritySettingUI$3(WalletSecuritySettingUI walletSecuritySettingUI) {
        this.sHN = walletSecuritySettingUI;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.WalletSecuritySettingUI", "alvinluo click close");
        this.sHN.finish();
    }
}
