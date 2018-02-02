package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.z.q;

class f$4 implements OnClickListener {
    final /* synthetic */ WalletBaseUI sEm;

    f$4(WalletBaseUI walletBaseUI) {
        this.sEm = walletBaseUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (q.Gf()) {
            a.b(this.sEm, "PayUForgotPwdProcess", null);
        } else {
            a.b(this.sEm, "ForgotPwdProcess", null);
        }
        if (this.sEm.aYf()) {
            this.sEm.finish();
        }
    }
}
