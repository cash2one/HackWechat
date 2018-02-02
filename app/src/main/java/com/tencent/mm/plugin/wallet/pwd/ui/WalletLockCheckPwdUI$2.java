package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.mm.plugin.wallet.pwd.a.i;
import com.tencent.mm.plugin.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView.a;

class WalletLockCheckPwdUI$2 implements a {
    final /* synthetic */ WalletLockCheckPwdUI sHg;

    WalletLockCheckPwdUI$2(WalletLockCheckPwdUI walletLockCheckPwdUI) {
        this.sHg = walletLockCheckPwdUI;
    }

    public final void hx(boolean z) {
        int i = 8;
        if (z && WalletLockCheckPwdUI.b(this.sHg) != null) {
            if (WalletLockCheckPwdUI.b(this.sHg).equals("action.close_wallet_lock")) {
                WalletLockCheckPwdUI.c(this.sHg);
            } else if (WalletLockCheckPwdUI.b(this.sHg).equals("action.verify_paypwd")) {
                if (WalletLockCheckPwdUI.d(this.sHg) == 1) {
                    i = 6;
                } else if (WalletLockCheckPwdUI.d(this.sHg) != 2) {
                    i = -1;
                }
                WalletLockCheckPwdUI.a(this.sHg, new r(WalletLockCheckPwdUI.e(this.sHg).getText(), i, this.sHg.bJQ()));
                this.sHg.r(WalletLockCheckPwdUI.f(this.sHg));
            } else if (WalletLockCheckPwdUI.b(this.sHg).equals("action.touchlock_verify_by_paypwd")) {
                this.sHg.r(new i(WalletLockCheckPwdUI.e(this.sHg).getText()));
            } else if (WalletLockCheckPwdUI.b(this.sHg).equals("action.touchlock_need_verify_paypwd")) {
                if (WalletLockCheckPwdUI.d(this.sHg) != 2) {
                    i = -1;
                }
                WalletLockCheckPwdUI.a(this.sHg, new r(WalletLockCheckPwdUI.e(this.sHg).getText(), i, this.sHg.bJQ()));
                this.sHg.r(WalletLockCheckPwdUI.f(this.sHg));
            }
        }
    }
}
