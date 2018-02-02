package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class IPCallShareCouponCardUI$9 implements OnCancelListener {
    final /* synthetic */ IPCallShareCouponCardUI nMs;

    IPCallShareCouponCardUI$9(IPCallShareCouponCardUI iPCallShareCouponCardUI) {
        this.nMs = iPCallShareCouponCardUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        try {
            this.nMs.finish();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallShareCouponCardUI", "loadFromSystemAddressBook error: %s", e.getMessage());
        }
    }
}
