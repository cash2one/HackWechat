package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.e;

public class g extends e {
    public final c a(Activity activity, Bundle bundle) {
        c(activity, WalletPayUCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUCheckPwdUI) {
            c(activity, WalletPayUSetPasswordUI.class, bundle);
        } else {
            super.a(activity, i, bundle);
        }
    }

    public final e a(MMActivity mMActivity, com.tencent.mm.wallet_core.d.g gVar) {
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            return new 1(this, mMActivity, gVar, this.msB);
        }
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new 2(this, mMActivity, gVar) : super.a(mMActivity, gVar);
    }

    public final String aKG() {
        return "PayUModifyPasswordProcess";
    }
}
