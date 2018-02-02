package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.remittance.bankcard.a.m;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.g$a;

class BankRemitBankcardInputUI$9 implements g$a {
    final /* synthetic */ BankRemitBankcardInputUI pIo;
    final /* synthetic */ m pIr;

    BankRemitBankcardInputUI$9(BankRemitBankcardInputUI bankRemitBankcardInputUI, m mVar) {
        this.pIo = bankRemitBankcardInputUI;
        this.pIr = mVar;
    }

    public final void f(int i, int i2, String str, k kVar) {
        BankRemitBankcardInputUI.b(this.pIo, false);
        BankRemitBankcardInputUI.b(this.pIo, this.pIr.pHo.vII);
        x.d("MicroMsg.BankRemitBankcardInputUI", "timing_id: %s", new Object[]{BankRemitBankcardInputUI.C(this.pIo)});
        BankRemitBankcardInputUI.a(this.pIo, TransferRecordParcel.bx(this.pIr.pHo.wHd));
        BankRemitBankcardInputUI.b(this.pIo, TransferRecordParcel.bx(this.pIr.pHo.wHc));
        x.i("MicroMsg.BankRemitBankcardInputUI", "selfList: %d, freqList: %d", new Object[]{Integer.valueOf(BankRemitBankcardInputUI.D(this.pIo).size()), Integer.valueOf(BankRemitBankcardInputUI.E(this.pIo).size())});
        BankRemitBankcardInputUI.F(this.pIo);
    }
}
