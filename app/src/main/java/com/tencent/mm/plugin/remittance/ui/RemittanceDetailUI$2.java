package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;

class RemittanceDetailUI$2 implements a {
    final /* synthetic */ RemittanceDetailUI pOO;

    RemittanceDetailUI$2(RemittanceDetailUI remittanceDetailUI) {
        this.pOO = remittanceDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.pOO, this.pOO.getString(i.uNe), this.pOO.getString(i.dGt), this.pOO.getString(i.uOb), this.pOO.getString(i.dEn), new OnClickListener(this) {
            final /* synthetic */ RemittanceDetailUI$2 pOR;

            {
                this.pOR = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("transaction_id", this.pOR.pOO.pOF);
                intent.putExtra("receiver_name", RemittanceDetailUI.b(this.pOR.pOO));
                this.pOR.pOO.T(intent);
            }
        }, new 2(this));
    }
}
