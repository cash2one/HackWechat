package com.tencent.mm.plugin.wallet_payu.pwd.a;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.p;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUPwdConfirmUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUSetPasswordUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.g;

public abstract class e extends c {
    public void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUSetPasswordUI) {
            c(activity, WalletPayUPwdConfirmUI.class, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        if (activity instanceof WalletPayUPwdConfirmUI) {
            a(activity, WalletPayUSetPasswordUI.class, i);
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        if (this.msB.getInt("key_errcode_payu", -1) == 0) {
            u.makeText(activity, i.uTD, 0).show();
        } else {
            u.makeText(activity, i.uRx, 0).show();
        }
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public com.tencent.mm.wallet_core.d.e a(MMActivity mMActivity, g gVar) {
        return mMActivity instanceof WalletPayUPwdConfirmUI ? new com.tencent.mm.wallet_core.d.e(this, mMActivity, gVar) {
            final /* synthetic */ e tdn;

            public final boolean d(int i, int i2, String str, k kVar) {
                if (!(kVar instanceof d)) {
                    return false;
                }
                x.d("MicroMsg.PayUBaseChangePwdProcess", "hy: forget pwd user success");
                if (i != 0 || i2 != 0) {
                    return false;
                }
                this.tdn.msB.putInt("key_errcode_payu", 0);
                a.c(this.zHU, this.tdn.msB, 0);
                return true;
            }

            public final boolean k(Object... objArr) {
                p pVar = (p) objArr[0];
                this.zHV.a(new d(this.tdn.msB.getString("payu_reference"), pVar.sPj), true);
                return true;
            }
        } : super.a(mMActivity, gVar);
    }
}
