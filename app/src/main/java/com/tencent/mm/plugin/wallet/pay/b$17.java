package com.tencent.mm.plugin.wallet.pay;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.pay.a.a.c;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;

class b$17 extends e {
    final /* synthetic */ b sEl;

    b$17(b bVar, MMActivity mMActivity, g gVar) {
        this.sEl = bVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i == 0 && i2 == 0 && (kVar instanceof c)) {
            x.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, forward");
            this.sEl.a(this.zHU, 0, this.sEl.msB);
            return true;
        } else if (i != 0 || i2 != 0 || !(kVar instanceof t)) {
            return false;
        } else {
            x.i("MicroMsg.PayProcess", "onSceneEnd for select bank card, directToNext");
            bJR();
            return false;
        }
    }

    public final boolean k(Object... objArr) {
        x.i("MicroMsg.PayProcess", "onNext for select bank card");
        this.sEl.msB.putInt("key_err_code", 0);
        Bankcard bankcard = (Bankcard) this.sEl.msB.getParcelable("key_bankcard");
        if (bankcard == null) {
            x.i("MicroMsg.PayProcess", "directToBindNew()");
            this.sEl.msB.putInt("key_pay_flag", 2);
            this.sEl.a(this.zHU, 0, this.sEl.msB);
        } else if (o.bLy().MT(bankcard.field_bankcardType) != null) {
            bJR();
        } else {
            this.zHV.a(new t("", "", null), true, 1);
        }
        return false;
    }

    private void bJR() {
        x.i("MicroMsg.PayProcess", "directToNext()");
        boolean z = this.sEl.msB.getBoolean("key_balance_change_phone_need_confirm_phone", false);
        Authen authen = (Authen) this.sEl.msB.getParcelable("key_authen");
        Orders orders = (Orders) this.sEl.msB.getParcelable("key_orders");
        Bankcard bankcard = (Bankcard) this.sEl.msB.getParcelable("key_bankcard");
        ElementQuery MT = o.bLy().MT(bankcard.field_bankcardType);
        this.sEl.msB.putParcelable("elemt_query", MT);
        if (z) {
            authen.oZz = bankcard.field_bankcardType;
            authen.oZA = bankcard.field_bindSerial;
            this.sEl.a(this.zHU, 0, this.sEl.msB);
            return;
        }
        authen.sIF = "";
        authen.oZz = bankcard.field_bankcardType;
        authen.oZA = bankcard.field_bindSerial;
        this.sEl.msB.putString("key_mobile", bankcard.field_mobile);
        if (MT == null || MT.sMu || MT.sMv) {
            x.i("MicroMsg.PayProcess", "hy: need rewrite cvv or validThru");
            this.sEl.a(this.zHU, 0, this.sEl.msB);
            return;
        }
        this.zHV.a(new c(authen, orders, this.sEl.msB.getBoolean("key_isbalance", false)), true);
    }
}
