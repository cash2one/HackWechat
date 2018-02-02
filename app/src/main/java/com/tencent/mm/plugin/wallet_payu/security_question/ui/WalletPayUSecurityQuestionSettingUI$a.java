package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import com.tencent.mm.sdk.platformtools.bh;

protected class WalletPayUSecurityQuestionSettingUI$a {
    final /* synthetic */ WalletPayUSecurityQuestionSettingUI tdR;

    protected WalletPayUSecurityQuestionSettingUI$a(WalletPayUSecurityQuestionSettingUI walletPayUSecurityQuestionSettingUI) {
        this.tdR = walletPayUSecurityQuestionSettingUI;
    }

    static /* synthetic */ void a(WalletPayUSecurityQuestionSettingUI$a walletPayUSecurityQuestionSettingUI$a) {
        if (walletPayUSecurityQuestionSettingUI$a.bNw()) {
            WalletPayUSecurityQuestionSettingUI.g(walletPayUSecurityQuestionSettingUI$a.tdR).setEnabled(true);
        } else {
            WalletPayUSecurityQuestionSettingUI.g(walletPayUSecurityQuestionSettingUI$a.tdR).setEnabled(false);
        }
    }

    protected final boolean bNw() {
        boolean z;
        if (bh.ov(WalletPayUSecurityQuestionSettingUI.b(this.tdR).tdU)) {
            z = false;
        } else {
            z = true;
        }
        return z && WalletPayUSecurityQuestionSettingUI.c(this.tdR).XO();
    }
}
