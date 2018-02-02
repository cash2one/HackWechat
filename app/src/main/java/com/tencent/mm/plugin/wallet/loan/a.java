package com.tencent.mm.plugin.wallet.loan;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.pay.ui.WalletLoanRepaymentUI;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.wallet_core.c;

public class a extends b {
    public final c a(Activity activity, Bundle bundle) {
        if (o.bLq().bLM()) {
            c(activity, WalletLoanCheckPwdUI.class, bundle);
        } else {
            super.a(activity, bundle);
        }
        return this;
    }

    public final void d(Activity activity, int i) {
        b(activity, this.msB);
    }

    public final void b(Activity activity, Bundle bundle) {
        int i = 0;
        if (bundle.getBoolean("intent_bind_end", false)) {
            i = -1;
        }
        a(activity, WalletLoanRepaymentUI.class, i, null, true);
    }
}
