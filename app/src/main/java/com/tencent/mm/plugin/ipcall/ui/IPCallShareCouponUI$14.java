package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class IPCallShareCouponUI$14 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponUI nMZ;

    IPCallShareCouponUI$14(IPCallShareCouponUI iPCallShareCouponUI) {
        this.nMZ = iPCallShareCouponUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.nMZ.mController.xIM, IPCallMyGiftCardUI.class);
        this.nMZ.mController.xIM.startActivity(intent);
    }
}
