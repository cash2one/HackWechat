package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitBankcardInputUI$20 implements OnClickListener {
    final /* synthetic */ BankRemitBankcardInputUI pIo;

    BankRemitBankcardInputUI$20(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.pIo = bankRemitBankcardInputUI;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.BankRemitBankcardInputUI", "name iv click");
        if (BankRemitBankcardInputUI.I(this.pIo) || !BankRemitBankcardInputUI.J(this.pIo)) {
            BankRemitBankcardInputUI.K(this.pIo);
        } else {
            Intent intent = new Intent(this.pIo.mController.xIM, BankRemitSelectPayeeUI.class);
            if (BankRemitBankcardInputUI.D(this.pIo) != null) {
                intent.putParcelableArrayListExtra("key_self_transfer_record_list", BankRemitBankcardInputUI.D(this.pIo));
            }
            if (BankRemitBankcardInputUI.E(this.pIo) != null) {
                intent.putParcelableArrayListExtra("key_freq_transfer_record_list", BankRemitBankcardInputUI.E(this.pIo));
            }
            this.pIo.startActivityForResult(intent, 1);
        }
        g.pQN.h(14673, new Object[]{Integer.valueOf(3)});
    }
}
