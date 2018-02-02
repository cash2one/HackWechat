package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class PayURemittanceDetailUI$8 implements OnClickListener {
    final /* synthetic */ PayURemittanceDetailUI tdB;

    PayURemittanceDetailUI$8(PayURemittanceDetailUI payURemittanceDetailUI) {
        this.tdB = payURemittanceDetailUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.bu(this.tdB.mController.xIM, this.tdB.getString(i.uNk));
    }
}
