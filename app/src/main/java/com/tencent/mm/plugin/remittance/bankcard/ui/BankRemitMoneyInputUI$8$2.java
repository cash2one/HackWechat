package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI.8;
import com.tencent.mm.sdk.platformtools.ag;

class BankRemitMoneyInputUI$8$2 implements OnClickListener {
    final /* synthetic */ 8 pJz;

    BankRemitMoneyInputUI$8$2(8 8) {
        this.pJz = 8;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ag.h(new Runnable(this) {
            final /* synthetic */ BankRemitMoneyInputUI$8$2 pJA;

            {
                this.pJA = r1;
            }

            public final void run() {
                this.pJA.pJz.pJw.aWs();
            }
        }, 500);
    }
}
