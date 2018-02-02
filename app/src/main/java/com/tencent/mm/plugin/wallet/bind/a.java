package com.tencent.mm.plugin.wallet.bind;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class a extends c {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.ProcessManager", "start Process : UnbindProcess");
        if (bundle.getBoolean("key_is_show_detail", true)) {
            d(activity, bundle);
        } else {
            c(activity, WalletCheckPwdUI.class, bundle);
        }
        return this;
    }

    public void d(Activity activity, Bundle bundle) {
        c(activity, WalletBankcardDetailUI.class, bundle);
    }

    public void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBankcardDetailUI) {
            c(activity, WalletCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletCheckPwdUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public void b(Activity activity, Bundle bundle) {
        if (this.msB.getInt("scene", -1) == 1) {
            Activity activity2 = activity;
            a(activity2, "wallet", ".bind.ui.WalletUnbindBankCardProxyUI", bundle.getInt("key_process_result_code", 0), false);
        } else if (this.msB.getInt("scene", -1) == 2) {
            d(activity, "wallet", ".balance.ui.WalletBalanceManagerUI");
        } else {
            d(activity, "mall", ".ui.MallIndexUI");
        }
    }

    public e a(MMActivity mMActivity, g gVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new 1(this, mMActivity, gVar) : super.a(mMActivity, gVar);
    }

    public boolean c(Activity activity, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            return true;
        }
        return false;
    }

    public final String aKG() {
        return "UnbindProcess";
    }
}
