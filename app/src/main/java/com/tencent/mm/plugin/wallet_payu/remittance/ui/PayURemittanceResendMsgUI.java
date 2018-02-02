package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.os.Bundle;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.a;

@a(3)
public class PayURemittanceResendMsgUI extends RemittanceResendMsgUI {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void k(String str, String str2, int i, int i2) {
        l(new h(str, getIntent().getIntExtra("total_fee", 0), getIntent().getStringExtra("fee_type"), str2, i));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof h)) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.ui.base.h.bu(this, getString(i.uOd));
            finish();
            return true;
        }
        com.tencent.mm.ui.base.h.bu(this, str);
        finish();
        return true;
    }
}
