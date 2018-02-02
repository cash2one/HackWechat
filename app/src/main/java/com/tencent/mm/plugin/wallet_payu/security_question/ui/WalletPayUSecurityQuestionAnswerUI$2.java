package com.tencent.mm.plugin.wallet_payu.security_question.ui;

import android.view.View;
import android.view.View.OnClickListener;

class WalletPayUSecurityQuestionAnswerUI$2 implements OnClickListener {
    final /* synthetic */ WalletPayUSecurityQuestionAnswerUI tdN;

    WalletPayUSecurityQuestionAnswerUI$2(WalletPayUSecurityQuestionAnswerUI walletPayUSecurityQuestionAnswerUI) {
        this.tdN = walletPayUSecurityQuestionAnswerUI;
    }

    public final void onClick(View view) {
        if (WalletPayUSecurityQuestionAnswerUI.b(this.tdN).XO()) {
            this.tdN.vf.putString("key_question_answer", WalletPayUSecurityQuestionAnswerUI.b(this.tdN).getText());
            this.tdN.cCd().k(new Object[0]);
        }
    }
}
