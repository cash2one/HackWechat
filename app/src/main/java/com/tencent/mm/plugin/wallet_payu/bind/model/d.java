package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.bind.a;
import com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardDetailUI;
import com.tencent.mm.plugin.wallet_payu.pwd.a.c;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class d extends a {
    protected final void d(Activity activity, Bundle bundle) {
        c(activity, WalletPayUBankcardDetailUI.class, bundle);
    }

    public final void b(Activity activity, Bundle bundle) {
        if (this.msB.getInt("key_errcode_payu", -1) == 0) {
            u.makeText(activity, i.uTD, 0).show();
        } else {
            u.makeText(activity, i.uRx, 0).show();
        }
        d(activity, "mall", ".ui.MallIndexUI");
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletBankcardDetailUI) {
            c(activity, WalletPayUCheckPwdUI.class, bundle);
        } else if (activity instanceof WalletPayUCheckPwdUI) {
            b(activity, bundle);
        }
    }

    public final e a(MMActivity mMActivity, g gVar) {
        return mMActivity instanceof WalletPayUCheckPwdUI ? new e(this, mMActivity, gVar) {
            final /* synthetic */ d tbE;

            public final CharSequence um(int i) {
                if (i == 0) {
                    return this.zHU.getString(i.uQZ);
                }
                return super.um(i);
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (kVar instanceof c) {
                    if (i2 == 0 && i == 0) {
                        c cVar = (c) kVar;
                        this.tbE.msB.putString("payu_reference", cVar.token);
                        if (bh.ov(cVar.token)) {
                            x.w("MicroMsg.PayUUnbindProcess", "hy: check pwd failed");
                        } else {
                            x.d("MicroMsg.PayUUnbindProcess", "hy: check pwd pass");
                            Bankcard bankcard = (Bankcard) this.tbE.msB.getParcelable("key_bankcard");
                            if (bankcard != null) {
                                this.zHV.a(new b(bankcard.field_bindSerial, this.tbE.msB.getString("payu_reference")), true);
                            }
                        }
                    }
                } else if ((kVar instanceof b) && i == 0 && i2 == 0) {
                    this.tbE.msB.putInt("key_errcode_payu", 0);
                    this.tbE.b(this.zHU, this.tbE.msB);
                }
                return false;
            }

            public final boolean k(Object... objArr) {
                this.tbE.msB.putString("key_pwd1", (String) objArr[0]);
                this.zHV.a(new c(this.tbE.msB.getString("key_pwd1")), true);
                return true;
            }
        } : super.a(mMActivity, gVar);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }
}
