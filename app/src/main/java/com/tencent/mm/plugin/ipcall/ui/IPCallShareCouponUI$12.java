package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class IPCallShareCouponUI$12 implements OnClickListener {
    final /* synthetic */ IPCallShareCouponUI nMZ;

    IPCallShareCouponUI$12(IPCallShareCouponUI iPCallShareCouponUI) {
        this.nMZ = iPCallShareCouponUI;
    }

    public final void onClick(View view) {
        g.pQN.h(13340, new Object[]{Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1)});
        Intent intent = new Intent();
        intent.setClass(this.nMZ.mController.xIM, IPCallShareCouponCardUI.class);
        this.nMZ.mController.xIM.startActivity(intent);
    }
}
