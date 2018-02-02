package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitDetailUI$2 implements OnClickListener {
    final /* synthetic */ BankRemitDetailUI pIP;

    BankRemitDetailUI$2(BankRemitDetailUI bankRemitDetailUI) {
        this.pIP = bankRemitDetailUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.BankRemitDetailUI", "click finish btn");
        this.pIP.finish();
    }
}
