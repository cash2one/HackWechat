package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.sdk.platformtools.x;

class BankRemitHistoryUI$1 implements OnItemLongClickListener {
    final /* synthetic */ BankRemitHistoryUI pIU;

    BankRemitHistoryUI$1(BankRemitHistoryUI bankRemitHistoryUI) {
        this.pIU = bankRemitHistoryUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        x.d("MicroMsg.BankRemitHistoryUI", "click item, %s", new Object[]{((ake) adapterView.getAdapter().getItem(i)).title});
        BankRemitHistoryUI.a(this.pIU).a(view, i, j, this.pIU, this.pIU);
        return false;
    }
}
