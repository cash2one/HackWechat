package com.tencent.mm.plugin.remittance.bankcard.ui;

import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.b;

class BankRemitSelectPayeeUI$4 implements b {
    final /* synthetic */ BankRemitSelectPayeeUI pJR;
    final /* synthetic */ TransferRecordParcel pJT;

    BankRemitSelectPayeeUI$4(BankRemitSelectPayeeUI bankRemitSelectPayeeUI, TransferRecordParcel transferRecordParcel) {
        this.pJR = bankRemitSelectPayeeUI;
        this.pJT = transferRecordParcel;
    }

    public final boolean v(CharSequence charSequence) {
        if (!(this.pJT.pHN == null && charSequence == null) && (this.pJT.pHN == null || !this.pJT.pHN.equals(charSequence))) {
            BankRemitSelectPayeeUI.a(this.pJR, this.pJT.pHK, String.valueOf(charSequence));
        } else {
            x.i("MicroMsg.BankRemitSelectPayeeUI", "no change: %s, %s", new Object[]{this.pJT.pHN, charSequence});
        }
        return true;
    }
}
