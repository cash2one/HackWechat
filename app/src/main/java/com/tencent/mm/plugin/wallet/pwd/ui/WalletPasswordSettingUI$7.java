package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.x;

class WalletPasswordSettingUI$7 implements OnClickListener {
    final /* synthetic */ WalletPasswordSettingUI sHq;
    final /* synthetic */ l sHt;

    WalletPasswordSettingUI$7(WalletPasswordSettingUI walletPasswordSettingUI, l lVar) {
        this.sHq = walletPasswordSettingUI;
        this.sHt = lVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.WalletPasswordSettingUI", "user click the button to set system fingerprint");
        this.sHt.cC(this.sHq);
    }
}
