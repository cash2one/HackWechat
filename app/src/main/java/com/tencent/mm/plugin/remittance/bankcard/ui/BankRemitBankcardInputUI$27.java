package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;

class BankRemitBankcardInputUI$27 extends r {
    final /* synthetic */ BankRemitBankcardInputUI pIo;

    BankRemitBankcardInputUI$27(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.pIo = bankRemitBankcardInputUI;
    }

    public final void ayX() {
        x.i("MicroMsg.BankRemitBankcardInputUI", "click next btn");
        this.pIo.aWs();
        BankRemitBankcardInputUI.v(this.pIo);
        if (!BankRemitBankcardInputUI.s(this.pIo)) {
            String text = BankRemitBankcardInputUI.w(this.pIo).getText();
            String text2 = BankRemitBankcardInputUI.p(this.pIo).getText();
            if (bh.ov(text) || text.trim().isEmpty() || bh.ov(text2) || text2.trim().isEmpty() || BankRemitBankcardInputUI.t(this.pIo) == null) {
                x.w("MicroMsg.BankRemitBankcardInputUI", "args is empty, payeeName: %s, bankCardNo: %s, bankcard: %s", new Object[]{text, text2, BankRemitBankcardInputUI.t(this.pIo)});
            } else if (BankRemitBankcardInputUI.j(this.pIo)) {
                x.i("MicroMsg.BankRemitBankcardInputUI", "from record goto next direct");
                BankRemitBankcardInputUI.x(this.pIo);
            } else {
                BankRemitBankcardInputUI.a(this.pIo, text, text2, BankRemitBankcardInputUI.t(this.pIo).nBM, BankRemitBankcardInputUI.t(this.pIo).oZz);
            }
        }
    }
}
