package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class IPCallShareCouponCardUI$10 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponCardUI nMs;

    IPCallShareCouponCardUI$10(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        this.nMs = iPCallShareCouponCardUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.nMs.finish();
    }
}
