package com.tencent.mm.plugin.recharge.ui;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import android.view.View;
import android.view.View.OnClickListener;

class RechargeUI$13 implements OnClickListener {
    final /* synthetic */ RechargeUI pDQ;

    RechargeUI$13(RechargeUI rechargeUI) {
        this.pDQ = rechargeUI;
    }

    public final void onClick(View view) {
        if (RechargeUI.e(this.pDQ).pCq) {
            RechargeUI.e(this.pDQ).b(null);
            return;
        }
        this.pDQ.startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 1);
    }
}
