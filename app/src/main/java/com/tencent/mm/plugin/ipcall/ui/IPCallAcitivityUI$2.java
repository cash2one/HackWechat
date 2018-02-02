package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class IPCallAcitivityUI$2 implements OnClickListener {
    final /* synthetic */ IPCallAcitivityUI nHI;

    IPCallAcitivityUI$2(IPCallAcitivityUI iPCallAcitivityUI) {
        this.nHI = iPCallAcitivityUI;
    }

    public final void onClick(View view) {
        if (IPCallAcitivityUI.a(this.nHI).ktN == 1) {
            x.i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
            Intent intent = new Intent();
            intent.setClass(this.nHI.mController.xIM, IPCallShareCouponUI.class);
            this.nHI.startActivity(intent);
            intent = new Intent();
            intent.setClass(this.nHI.mController.xIM, IPCallPackageUI.class);
            this.nHI.startActivity(intent);
        }
        IPCallAcitivityUI.b(this.nHI);
        this.nHI.finish();
    }
}
