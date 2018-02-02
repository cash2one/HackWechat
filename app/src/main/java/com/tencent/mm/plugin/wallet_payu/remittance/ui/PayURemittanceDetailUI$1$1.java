package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI.1;

class PayURemittanceDetailUI$1$1 implements OnClickListener {
    final /* synthetic */ 1 tdC;

    PayURemittanceDetailUI$1$1(1 1) {
        this.tdC = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("transaction_id", PayURemittanceDetailUI.a(this.tdC.tdB));
        intent.putExtra("receiver_name", PayURemittanceDetailUI.b(this.tdC.tdB));
        intent.putExtra("total_fee", PayURemittanceDetailUI.c(this.tdC.tdB));
        intent.putExtra("fee_type", PayURemittanceDetailUI.d(this.tdC.tdB));
        this.tdC.tdB.T(intent);
    }
}
