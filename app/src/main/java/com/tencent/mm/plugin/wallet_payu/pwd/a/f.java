package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wallet_payu.security_question.model.a;
import com.tencent.mm.plugin.wallet_payu.security_question.ui.WalletPayUSecurityQuestionAnswerUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class f extends e {
    public final c a(Activity activity, Bundle bundle) {
        c(activity, WalletPayUSecurityQuestionAnswerUI.class, bundle);
        return super.a(activity, bundle);
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUSecurityQuestionAnswerUI) {
            c(activity, WalletPayUSetPasswordUI.class, bundle);
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletPayUSecurityQuestionAnswerUI) {
            return new a(mMActivity, gVar, this.msB);
        }
        return super.a(mMActivity, gVar);
    }

    public final String aKG() {
        return "PayUForgotPwdProcess";
    }
}
