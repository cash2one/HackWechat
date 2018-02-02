package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet.a.n;

class PhoneRechargeUI$19 implements OnClickListener {
    final /* synthetic */ PhoneRechargeUI pDm;
    final /* synthetic */ n pDs;

    PhoneRechargeUI$19(PhoneRechargeUI phoneRechargeUI, n nVar) {
        this.pDm = phoneRechargeUI;
        this.pDs = nVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        PhoneRechargeUI.b(this.pDm, this.pDs.id);
    }
}
