package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class PayURemittanceDetailUI$1 implements a {
    final /* synthetic */ PayURemittanceDetailUI tdB;

    PayURemittanceDetailUI$1(PayURemittanceDetailUI payURemittanceDetailUI) {
        this.tdB = payURemittanceDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.tdB, this.tdB.getString(i.uNe), this.tdB.getString(i.dGt), this.tdB.getString(i.uOb), this.tdB.getString(i.dEn), new 1(this), new OnClickListener(this) {
            final /* synthetic */ PayURemittanceDetailUI$1 tdC;

            {
                this.tdC = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }
}
