package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class IPCallShareCouponUI$4 implements OnCancelListener {
    final /* synthetic */ IPCallShareCouponUI nMZ;

    IPCallShareCouponUI$4(IPCallShareCouponUI iPCallShareCouponUI) {
        this.nMZ = iPCallShareCouponUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        try {
            this.nMZ.finish();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallShareCouponUI", "IPCallShareCouponUI error: %s", e.getMessage());
        }
    }
}
