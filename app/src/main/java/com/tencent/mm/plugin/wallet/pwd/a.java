package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdBindNewUI;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a extends com.tencent.mm.plugin.wallet_core.b.a {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.ProcessManager", "start Process : ForgotPwdProcess");
        Bundle bundle2 = this.msB;
        String str = "key_is_oversea";
        p.bJN();
        bundle2.putBoolean(str, !p.bJO().bLR());
        bundle2 = this.msB;
        str = "key_support_bankcard";
        p.bJN();
        bundle2.putInt(str, p.bJO().bLR() ? 1 : 2);
        this.msB.putBoolean("key_is_forgot_process", true);
        c(activity, WalletForgotPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletForgotPwdUI) {
            if (bundle.containsKey("key_is_force_bind") && bundle.getBoolean("key_is_force_bind")) {
                c(activity, WalletForgotPwdBindNewUI.class, bundle);
            } else {
                c(activity, WalletCardElementUI.class, bundle);
            }
        } else if (activity instanceof WalletCardElementUI) {
            if (bMX()) {
                c(activity, WalletSetPasswordUI.class, bundle);
            } else {
                c(activity, WalletVerifyCodeUI.class, bundle);
            }
        } else if (activity instanceof WalletVerifyCodeUI) {
            c(activity, WalletSetPasswordUI.class, bundle);
        } else if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, bundle);
        } else if ((activity instanceof WalletBankcardIdUI) || (activity instanceof WalletConfirmCardIDUI)) {
            w(new Object[]{"startActivity2", activity, WalletCardElementUI.class, bundle, new StringBuilder("flag: 67108864").toString()});
            Intent intent = new Intent(activity, WalletCardElementUI.class);
            intent.putExtra("process_id", getClass().hashCode());
            intent.addFlags(67108864);
            activity.startActivity(intent);
            if (bundle != null) {
                this.msB.putAll(bundle);
            }
            x.d("MicroMsg.ProcessManager", "bankcard tag :" + cBi());
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        a(activity, WalletForgotPwdUI.class, -1, false);
    }

    public final e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletForgotPwdUI) {
            return new 1(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletCardElementUI) {
            return new 2(this, mMActivity, gVar);
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new 3(this, mMActivity, gVar);
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new 4(this, mMActivity, gVar) : super.a(mMActivity, gVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return activity instanceof WalletPwdConfirmUI;
    }

    public final boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                h.a(walletBaseUI, str, null, walletBaseUI.getString(i.uRN), false, new 5(this, walletBaseUI));
                return true;
            default:
                return false;
        }
    }

    public final int b(MMActivity mMActivity, int i) {
        return i.uRN;
    }

    public final String aKG() {
        return "ForgotPwdProcess";
    }
}
