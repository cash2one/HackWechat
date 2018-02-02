package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class IPCallShareCouponCardUI$16 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponCardUI nMs;

    IPCallShareCouponCardUI$16(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        this.nMs = iPCallShareCouponCardUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        IPCallShareCouponCardUI iPCallShareCouponCardUI = this.nMs;
        Context context = this.nMs.mController.xIM;
        this.nMs.mController.xIM.getString(R.l.dGO);
        IPCallShareCouponCardUI.a(iPCallShareCouponCardUI, h.a(context, this.nMs.mController.xIM.getString(R.l.eRz), true, new 1(this)));
        IPCallShareCouponCardUI.c(this.nMs).a(this.nMs, this.nMs.mController.xIM);
    }
}
