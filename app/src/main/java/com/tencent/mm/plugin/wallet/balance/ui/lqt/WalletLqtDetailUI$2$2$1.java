package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.2.2;

class WalletLqtDetailUI$2$2$1 implements OnClickListener {
    final /* synthetic */ 2 sAO;

    WalletLqtDetailUI$2$2$1(2 2) {
        this.sAO = 2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        WalletLqtDetailUI.g(this.sAO.sAN.sAM);
        this.sAO.sAN.sAM.startActivityForResult(new Intent(this.sAO.sAN.sAM, WalletLqtSimpleCheckPwdUI.class), 123);
    }
}
