package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.protocal.c.cg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.ui.e;

class BankRemitMoneyInputUI$9 implements OnClickListener {
    final /* synthetic */ cg pJB;
    final /* synthetic */ BankRemitMoneyInputUI pJw;
    final /* synthetic */ n pJy;

    BankRemitMoneyInputUI$9(BankRemitMoneyInputUI bankRemitMoneyInputUI, n nVar, cg cgVar) {
        this.pJw = bankRemitMoneyInputUI;
        this.pJy = nVar;
        this.pJB = cgVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.pJy.pHp.liH == 0) {
            BankRemitMoneyInputUI.a(this.pJw, this.pJy.pHp.ods, this.pJy.pHp.pHM, this.pJy.pHp.nBM, this.pJy.pHp.pHL);
        } else if (!bh.ov(this.pJB.liO)) {
            e.l(this.pJw.mController.xIM, this.pJB.liO, false);
        }
    }
}
