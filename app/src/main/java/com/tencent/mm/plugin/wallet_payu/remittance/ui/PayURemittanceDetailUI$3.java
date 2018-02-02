package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class PayURemittanceDetailUI$3 implements a {
    final /* synthetic */ PayURemittanceDetailUI tdB;

    PayURemittanceDetailUI$3(PayURemittanceDetailUI payURemittanceDetailUI) {
        this.tdB = payURemittanceDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.tdB, this.tdB.getString(i.uNq, new Object[]{PayURemittanceDetailUI.Nz(PayURemittanceDetailUI.e(this.tdB))}), this.tdB.getString(i.dGt), this.tdB.getString(i.uNv), this.tdB.getString(i.dEn), new 1(this), new OnClickListener(this) {
            final /* synthetic */ PayURemittanceDetailUI$3 tdD;

            {
                this.tdD = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
