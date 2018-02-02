package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class WalletLqtCheckPwdInputDialogUI$3 implements OnCancelListener {
    final /* synthetic */ WalletLqtCheckPwdInputDialogUI sAp;

    WalletLqtCheckPwdInputDialogUI$3(WalletLqtCheckPwdInputDialogUI walletLqtCheckPwdInputDialogUI) {
        this.sAp = walletLqtCheckPwdInputDialogUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.WalletLqtCheckPwdInputDialogUI", "hy: dialog cancel. finish");
        WalletLqtCheckPwdInputDialogUI.a(this.sAp).dismiss();
        this.sAp.finish();
    }
}
