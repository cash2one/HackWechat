package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.remittance.bankcard.model.TransferRecordParcel;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitBankcardInputUI$18 implements OnItemClickListener {
    final /* synthetic */ BankRemitBankcardInputUI pIo;

    BankRemitBankcardInputUI$18(BankRemitBankcardInputUI bankRemitBankcardInputUI) {
        this.pIo = bankRemitBankcardInputUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.i("MicroMsg.BankRemitBankcardInputUI", "popup window click: %d", new Object[]{Integer.valueOf(i)});
        BankRemitBankcardInputUI.a(this.pIo, false);
        BankRemitBankcardInputUI.a(this.pIo, (TransferRecordParcel) adapterView.getAdapter().getItem(i));
        BankRemitBankcardInputUI.G(this.pIo);
        BankRemitBankcardInputUI.a(this.pIo, BankRemitBankcardInputUI.H(this.pIo).pHK, BankRemitBankcardInputUI.C(this.pIo), BankRemitBankcardInputUI.H(this.pIo).oZz);
        ag.h(new 1(this), 500);
        BankRemitBankcardInputUI.g(this.pIo).dismiss();
        this.pIo.aWs();
    }
}
