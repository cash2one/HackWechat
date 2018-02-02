package com.tencent.mm.plugin.wxcredit;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountResultUI;
import com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditChangeAmountUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class b extends c {
    public final c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.WXCreditChangeAmountProcess", "start Process : WXCreditChangeAmountProcess");
        c(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            c(activity, WalletWXCreditChangeAmountUI.class, bundle);
        } else if (activity instanceof WalletWXCreditChangeAmountUI) {
            c(activity, WalletWXCreditChangeAmountResultUI.class, bundle);
        } else if (activity instanceof WalletWXCreditChangeAmountResultUI) {
            b(activity, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        d(activity, "wallet", ".bind.ui.WalletBankcardManageUI");
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletWXCreditChangeAmountUI) {
            return new e(this, mMActivity, gVar) {
                final /* synthetic */ b tYR;

                public final boolean d(int i, int i2, String str, k kVar) {
                    if (i != 0 || i2 != 0) {
                        return false;
                    }
                    if (kVar instanceof com.tencent.mm.plugin.wxcredit.a.e) {
                        this.tYR.msB.putString("kreq_token", ((com.tencent.mm.plugin.wxcredit.a.e) kVar).token);
                        return false;
                    } else if (!(kVar instanceof com.tencent.mm.plugin.wxcredit.a.c)) {
                        return false;
                    } else {
                        this.tYR.msB.putDouble("key_credit_amount", ((com.tencent.mm.plugin.wxcredit.a.c) kVar).tYZ);
                        this.tYR.a(this.zHU, 0, this.tYR.msB);
                        return true;
                    }
                }

                public final boolean k(Object... objArr) {
                    this.zHV.a(new com.tencent.mm.plugin.wxcredit.a.e(((Bankcard) this.tYR.msB.getParcelable("key_bankcard")).field_bindSerial), true, 1);
                    return true;
                }
            };
        }
        return mMActivity instanceof WalletCheckPwdUI ? new 2(this, mMActivity, gVar) : null;
    }

    public final String aKG() {
        return "WXCreditChangeAmountProcess";
    }
}
