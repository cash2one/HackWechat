package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WalletIdCardCheckUI$3 implements OnClickListener {
    final /* synthetic */ WalletIdCardCheckUI sHd;

    WalletIdCardCheckUI$3(WalletIdCardCheckUI walletIdCardCheckUI) {
        this.sHd = walletIdCardCheckUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.sHd.setResult(-1);
        this.sHd.finish();
    }
}
