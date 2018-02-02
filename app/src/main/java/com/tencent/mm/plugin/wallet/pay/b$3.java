package com.tencent.mm.plugin.wallet.pay;

import android.os.Parcelable;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.b.a;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class b$3 extends a {
    final /* synthetic */ b sEl;

    b$3(b bVar, WalletBaseUI walletBaseUI, g gVar) {
        this.sEl = bVar;
        super(bVar, walletBaseUI, gVar);
    }

    public final boolean k(Object... objArr) {
        x.i("MicroMsg.PayProcess", "start do authen");
        ew ewVar = (ew) objArr[0];
        Authen authen = (Authen) this.sEl.msB.getParcelable("key_authen");
        Parcelable bankcard = new Bankcard();
        bankcard.field_bindSerial = ewVar.oZA;
        bankcard.field_mobile = ewVar.sIF;
        bankcard.field_desc = ewVar.nBM;
        bankcard.field_bankcardType = authen.oZz;
        x.d("MicroMsg.PayProcess", "tft: bank_type: %s, bank_serial: %s, authen.serial: %s", new Object[]{authen.oZz, ewVar.oZA, authen.oZA});
        this.sEl.msB.putString("key_mobile", bankcard.field_mobile);
        this.sEl.msB.putParcelable("key_bankcard", bankcard);
        Orders orders = (Orders) this.sEl.msB.getParcelable("key_orders");
        authen.sKF = ewVar.vKD;
        authen.sKG = ewVar.oZA;
        authen.sKH = ewVar.oZz;
        authen.sKI = "1";
        k a = com.tencent.mm.plugin.wallet.pay.a.a.a(authen, orders, false);
        if (a != null) {
            this.zHV.a(a, true, 1);
        }
        return false;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof b)) {
            return false;
        }
        x.i("MicroMsg.PayProcess", "finish auth");
        Authen authen = ((b) kVar).sEt;
        Parcelable parcelable = ((b) kVar).sEs;
        this.sEl.msB.putParcelable("key_authen", authen);
        this.sEl.msB.putParcelable("key_orders", parcelable);
        this.sEl.msB.putString("kreq_token", ((b) kVar).token);
        this.sEl.msB.putBoolean("key_is_return_from_switch_phone", true);
        this.sEl.msB.putInt("key_err_code", 0);
        Bankcard bankcard = (Bankcard) this.sEl.msB.getParcelable("key_bankcard");
        bankcard.field_bankcardType = authen.oZz;
        bankcard.field_bindSerial = authen.oZA;
        this.sEl.a(this.zHU, 0, this.sEl.msB);
        this.sEl.C(this.zHU);
        return true;
    }
}
