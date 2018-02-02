package com.tencent.mm.plugin.wallet_core.b;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class a extends c {
    public c a(Activity activity, Bundle bundle) {
        w("start", activity, bundle);
        if (bundle != null) {
            bundle.putBoolean("key_is_bind_reg_process", true);
        }
        c(activity, WalletBankcardIdUI.class, bundle);
        return this;
    }

    public void a(Activity activity, int i, Bundle bundle) {
        w("forward", activity, Integer.valueOf(i), bundle);
        if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            c(activity, WalletCardElementUI.class, bundle);
        } else if (activity instanceof WalletVerifyCodeUI) {
            c(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletOrderInfoUI) {
            b(activity, bundle);
        }
    }

    public void d(Activity activity, int i) {
        w("back", activity, Integer.valueOf(i));
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        } else {
            C(activity);
        }
    }

    public boolean c(Activity activity, Bundle bundle) {
        return activity instanceof WalletOrderInfoUI;
    }

    public boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                x.i("MicroMsg.ProcessManager", "404 bind error, cancel bind!");
                h.a(walletBaseUI, str, null, walletBaseUI.getString(i.uPT), false, new 1(this, walletBaseUI));
                return true;
            default:
                return false;
        }
    }

    public int b(MMActivity mMActivity, int i) {
        return i.uSg;
    }
}
