package com.tencent.mm.plugin.wallet.pay;

import android.os.Parcelable;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet.pay.b.a;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$12 extends a {
    final /* synthetic */ b sEl;

    b$12(b bVar, WalletBaseUI walletBaseUI, g gVar) {
        this.sEl = bVar;
        super(bVar, walletBaseUI, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (super.d(i, i2, str, kVar)) {
            return true;
        }
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof b) {
            b bVar = (b) kVar;
            b.c(this.sEl).putString("kreq_token", bVar.token);
            if (bVar.sFA) {
                b.d(this.sEl).putParcelable("key_orders", bVar.sEs);
            }
            Parcelable parcelable = bVar.oWt;
            if (parcelable != null) {
                b.e(this.sEl).putParcelable("key_realname_guide_helper", parcelable);
            }
        } else if (kVar instanceof c) {
            c cVar = (c) kVar;
            b.f(this.sEl).putString("kreq_token", cVar.token);
            if (cVar.sFA) {
                b.g(this.sEl).putParcelable("key_orders", cVar.sEs);
            }
        }
        if (this.sEl.c(this.zHU, null)) {
            this.zHV.a(new x(b.h(this.sEl), 13), true, 1);
            return true;
        }
        this.sEl.a(this.zHU, 0, b.i(this.sEl));
        return true;
    }

    public final boolean k(Object... objArr) {
        Authen authen = (Authen) objArr[0];
        Orders orders = (Orders) objArr[1];
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.PayProcess", "WalletCardElementUI onNext pay_flag : " + this.sEl.msB.getInt("key_pay_flag", 0));
        switch (this.sEl.msB.getInt("key_pay_flag", 0)) {
            case 1:
                if (this.sEl.bMX()) {
                    authen.fDt = 4;
                } else {
                    authen.fDt = 1;
                }
                this.zHV.a(new b(authen, orders), true, 1);
                return true;
            case 2:
                if (this.sEl.bMX()) {
                    authen.fDt = 5;
                } else {
                    authen.fDt = 2;
                }
                if (this.sEl.msB.getBoolean("key_is_changing_balance_phone_num", false)) {
                    this.zHV.a(new c(authen, orders, this.sEl.msB.getBoolean("key_isbalance", false)), true, 1);
                } else {
                    this.zHV.a(new b(authen, orders), true, 1);
                }
                return true;
            case 3:
                if (this.sEl.bMX()) {
                    authen.fDt = 6;
                } else {
                    authen.fDt = 3;
                }
                this.zHV.a(new b(authen, orders), true, 1);
                return true;
            default:
                return false;
        }
    }
}
