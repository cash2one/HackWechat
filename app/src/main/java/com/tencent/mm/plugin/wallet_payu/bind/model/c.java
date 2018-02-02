package com.tencent.mm.plugin.wallet_payu.bind.model;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUBankcardManageUI;
import com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI;
import com.tencent.mm.plugin.wallet_payu.pwd.ui.WalletPayUCheckPwdUI;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

public class c extends com.tencent.mm.wallet_core.c {
    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        x.d("MicroMsg.PayUBindProcess", "hy: start process: PayUBindProcess");
        c(activity, WalletPayUCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletPayUCheckPwdUI) {
            c(activity, WalletPayUCardElementUI.class, bundle);
        }
    }

    public final void d(Activity activity, int i) {
        C(activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        if (this.msB.getInt("key_errcode_payu", -1) == 0) {
            u.makeText(activity, a$i.uTD, 0).show();
            a(activity, WalletPayUBankcardManageUI.class, -1, false);
            return;
        }
        u.makeText(activity, a$i.uRx, 0).show();
        a(activity, WalletPayUBankcardManageUI.class, 0, false);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final e a(MMActivity mMActivity, g gVar) {
        if (mMActivity instanceof WalletPayUCheckPwdUI) {
            return new 1(this, mMActivity, gVar, this.msB);
        }
        return mMActivity instanceof WalletPayUCardElementUI ? new e(this, mMActivity, gVar) {
            final /* synthetic */ c tbD;

            public final boolean d(int i, int i2, String str, k kVar) {
                if ((kVar instanceof a) && i == 0 && i2 == 0) {
                    this.tbD.msB.putInt("key_errcode_payu", 0);
                    this.tbD.b(this.zHU, this.tbD.msB);
                }
                if (kVar instanceof NetScenePayUElementQuery) {
                    if (i == 0 && i2 == 0) {
                        PayUBankcardElement payUBankcardElement = ((NetScenePayUElementQuery) kVar).tbz;
                        if (bh.ov(payUBankcardElement.tbA)) {
                            payUBankcardElement.tbB = ac.getContext().getString(a$i.uVb);
                        }
                        this.tbD.msB.putParcelable("key_card_element", ((NetScenePayUElementQuery) kVar).tbz);
                    } else {
                        Parcelable payUBankcardElement2 = new PayUBankcardElement();
                        if (bh.ov(str)) {
                            str = "err card element";
                        }
                        payUBankcardElement2.tbB = str;
                        this.tbD.msB.putParcelable("key_card_element", payUBankcardElement2);
                    }
                }
                return false;
            }

            public final boolean k(Object... objArr) {
                PayUBankcardElement payUBankcardElement = (PayUBankcardElement) this.tbD.msB.getParcelable("key_card_element");
                this.zHV.a(new a(payUBankcardElement.pax, payUBankcardElement.tbB, this.tbD.msB.getString("key_bank_username"), this.tbD.msB.getString("key_card_id"), this.tbD.msB.getString("key_expire_data"), payUBankcardElement.cardType, this.tbD.msB.getString("key_cvv"), this.tbD.msB.getString("key_pwd1")), true);
                return false;
            }
        } : super.a(mMActivity, gVar);
    }

    public final String aKG() {
        return "PayUBindProcess";
    }
}
