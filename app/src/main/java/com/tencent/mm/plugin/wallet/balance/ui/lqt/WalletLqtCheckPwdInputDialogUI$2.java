package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Intent;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.m.c;

class WalletLqtCheckPwdInputDialogUI$2 implements c {
    final /* synthetic */ WalletLqtCheckPwdInputDialogUI sAp;

    WalletLqtCheckPwdInputDialogUI$2(WalletLqtCheckPwdInputDialogUI walletLqtCheckPwdInputDialogUI) {
        this.sAp = walletLqtCheckPwdInputDialogUI;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        WalletLqtCheckPwdInputDialogUI.a(this.sAp).dismiss();
        Intent intent = new Intent();
        intent.putExtra("lqt_fetch_enc_pwd", str);
        this.sAp.setResult(-1, intent);
        this.sAp.finish();
    }
}
