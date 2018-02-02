package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitBankcardInputUI$26 implements OnClickListener {
    final /* synthetic */ BankRemitBankcardInputUI pIo;

    BankRemitBankcardInputUI$26(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.pIo = bankRemitBankcardInputUI;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.BankRemitBankcardInputUI", "click arrive time et");
        this.pIo.aWs();
        BankRemitBankcardInputUI.p(this.pIo).bmJ();
        if (!BankRemitBankcardInputUI.s(this.pIo)) {
            Intent intent = new Intent(this.pIo.mController.xIM, BankRemitSelectArriveTimeUI.class);
            if (!(BankRemitBankcardInputUI.t(this.pIo) == null || BankRemitBankcardInputUI.t(this.pIo).pHw == null)) {
                intent.putParcelableArrayListExtra("key_arrive_time_parcel_list", BankRemitBankcardInputUI.t(this.pIo).pHw);
            }
            if (BankRemitBankcardInputUI.u(this.pIo) != null) {
                intent.putExtra("key_select_arrive_time", BankRemitBankcardInputUI.u(this.pIo).pHx);
            }
            this.pIo.startActivityForResult(intent, 3);
        }
    }
}
