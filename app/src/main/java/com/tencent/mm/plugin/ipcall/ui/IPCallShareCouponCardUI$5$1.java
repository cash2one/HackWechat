package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallShareCouponCardUI.5;
import com.tencent.mm.z.ar;

class IPCallShareCouponCardUI$5$1 implements OnCancelListener {
    final /* synthetic */ i nMv;
    final /* synthetic */ 5 nMw;

    IPCallShareCouponCardUI$5$1(5 5, i iVar) {
        this.nMw = 5;
        this.nMv = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.nMv);
    }
}
