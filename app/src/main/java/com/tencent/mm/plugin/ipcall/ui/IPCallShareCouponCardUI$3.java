package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bm.d;

class IPCallShareCouponCardUI$3 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponCardUI nMs;

    IPCallShareCouponCardUI$3(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        this.nMs = iPCallShareCouponCardUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        d.a(this.nMs.mController.xIM, ".ui.account.FacebookAuthUI", new Intent());
    }
}
