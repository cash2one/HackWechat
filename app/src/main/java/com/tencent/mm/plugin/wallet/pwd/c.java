package com.tencent.mm.plugin.wallet.pwd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pwd.ui.WalletResetPwdAdapterUI;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.ResetPwdProcessByToken", "start Process : ResetPwdProcessByToken");
        c(activity, WalletSetPasswordUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletSetPasswordUI) {
            c(activity, WalletPwdConfirmUI.class, bundle);
        } else if (activity instanceof WalletPwdConfirmUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity instanceof WalletPwdConfirmUI) {
            a(activity, WalletSetPasswordUI.class, i);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, WalletResetPwdAdapterUI.class);
        intent.putExtra("RESET_PWD_USER_ACTION", bundle.getInt("RESET_PWD_USER_ACTION", 0));
        a(activity, WalletResetPwdAdapterUI.class, -1, intent, false);
    }

    public final e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new 1(this, mMActivity, gVar);
        }
        return mMActivity instanceof WalletPwdConfirmUI ? new e(this, mMActivity, gVar) {
            final /* synthetic */ c sGs;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i == 0 && i2 == 0) {
                    if (!(kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.g)) {
                        return true;
                    }
                    this.sGs.msB.putInt("RESET_PWD_USER_ACTION", 1);
                    this.sGs.a(this.zHU, 0, this.sGs.msB);
                    h.bu(this.zHU, this.zHU.getString(i.uUg));
                    return true;
                } else if (!(kVar instanceof com.tencent.mm.plugin.wallet.pwd.a.g)) {
                    return false;
                } else {
                    h.a(this.zHU, str, "", false, new 1(this));
                    return true;
                }
            }

            public final boolean k(Object... objArr) {
                p pVar = (p) objArr[0];
                this.sGs.msB.getString("key_pwd1");
                this.zHV.a(new com.tencent.mm.plugin.wallet.pwd.a.g(pVar.sPj, pVar.token), true, 1);
                return true;
            }
        } : super.a(mMActivity, gVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        switch (i) {
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                h.a(walletBaseUI, str, null, walletBaseUI.getString(i.uWJ), false, new 3(this, walletBaseUI));
                return true;
            default:
                return false;
        }
    }

    public final int b(MMActivity mMActivity, int i) {
        return i.uWJ;
    }

    public final String aKG() {
        return "ResetPwdProcessByToken";
    }
}
