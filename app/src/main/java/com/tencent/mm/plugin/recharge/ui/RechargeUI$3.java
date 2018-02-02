package com.tencent.mm.plugin.recharge.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;

class RechargeUI$3 implements OnCancelListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ RechargeUI pDQ;

    RechargeUI$3(RechargeUI rechargeUI, k kVar) {
        this.pDQ = rechargeUI;
        this.flZ = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Dk();
        g.Di().gPJ.c(this.flZ);
    }
}
