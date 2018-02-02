package com.tencent.mm.plugin.wallet.bind;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet.bind.a.d;
import com.tencent.mm.plugin.wallet_core.c.x;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

class a$1 extends e {
    private String fuH = null;
    final /* synthetic */ a sBJ;

    a$1(a aVar, MMActivity mMActivity, g gVar) {
        this.sBJ = aVar;
        super(mMActivity, gVar);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof d) {
            if (i == 0 && i2 == 0) {
                this.sBJ.msB.putInt("key_process_result_code", -1);
                if (this.sBJ.c(this.zHU, null)) {
                    this.zHV.a(new x(this.fuH, 14), true, 1);
                } else {
                    this.sBJ.a(this.zHU, 0, null);
                    if (this.zHU instanceof WalletBaseUI) {
                        ((WalletBaseUI) this.zHU).uw(0);
                    }
                    this.zHU.finish();
                }
                return true;
            }
            this.sBJ.msB.putInt("key_process_result_code", 1);
        }
        return false;
    }

    public final boolean p(Object... objArr) {
        Bankcard bankcard = (Bankcard) a.a(this.sBJ).getParcelable("key_bankcard");
        if (bankcard == null || bankcard.field_bankcardState != 1) {
            this.sBJ.msB.putInt("key_process_result_code", 1);
            return super.p(objArr);
        }
        this.zHV.a(new d(bankcard.field_bankcardType, bankcard.field_bindSerial, a.b(this.sBJ).getInt("scene", -1) == 2), true, 1);
        a.c(this.sBJ).putBoolean("key_is_expired_bankcard", true);
        return true;
    }

    public final boolean k(Object... objArr) {
        Bankcard bankcard = (Bankcard) a.d(this.sBJ).getParcelable("key_bankcard");
        String str = (String) objArr[0];
        this.fuH = (String) objArr[1];
        if (bankcard != null) {
            this.zHV.a(new d(bankcard.field_bankcardType, bankcard.field_bindSerial, str, a.e(this.sBJ).getInt("scene", -1) == 2), true, 1);
            return true;
        }
        this.sBJ.msB.putInt("key_process_result_code", 1);
        return false;
    }

    public final CharSequence um(int i) {
        switch (i) {
            case 1:
                return this.zHU.getString(i.uSd);
            default:
                return super.um(i);
        }
    }
}
