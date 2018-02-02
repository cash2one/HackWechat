package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.d;

class BankRemitSelectBankUI$1 implements OnItemClickListener {
    final /* synthetic */ BankRemitSelectBankUI pJH;

    BankRemitSelectBankUI$1(BankRemitSelectBankUI bankRemitSelectBankUI) {
        this.pJH = bankRemitSelectBankUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ez ezVar = (ez) ((d) adapterView.getAdapter().getItem(i)).data;
        if (ezVar != null) {
            Parcelable bankcardElemParcel = new BankcardElemParcel(ezVar);
            Intent intent = new Intent();
            intent.putExtra("key_bank_card_elem_parcel", bankcardElemParcel);
            this.pJH.setResult(-1, intent);
            this.pJH.finish();
            return;
        }
        x.w("MicroMsg.BankRemitSelectBankUI", "bankcardelem is null, : %s", new Object[]{Integer.valueOf(i)});
    }
}
