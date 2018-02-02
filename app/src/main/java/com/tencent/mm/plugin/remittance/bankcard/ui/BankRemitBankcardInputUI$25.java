package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class BankRemitBankcardInputUI$25 implements OnClickListener {
    final /* synthetic */ BankRemitBankcardInputUI pIo;

    BankRemitBankcardInputUI$25(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.pIo = bankRemitBankcardInputUI;
    }

    public final void onClick(View view) {
        this.pIo.aWs();
        String text = BankRemitBankcardInputUI.p(this.pIo).getText();
        if (!BankRemitBankcardInputUI.q(this.pIo) || bh.ov(text)) {
            BankRemitBankcardInputUI.r(this.pIo);
            return;
        }
        BankRemitBankcardInputUI.a(this.pIo, text, BankRemitBankcardInputUI.p(this.pIo).cCl());
    }
}
