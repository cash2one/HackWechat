package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class IPCallPackageUI$2 implements OnCancelListener {
    final /* synthetic */ IPCallPackageUI nLh;

    IPCallPackageUI$2(IPCallPackageUI iPCallPackageUI) {
        this.nLh = iPCallPackageUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        try {
            if (IPCallPackageUI.a(this.nLh) != null) {
                ar.CG().c(IPCallPackageUI.a(this.nLh));
            }
            this.nLh.finish();
        } catch (Exception e) {
            x.e("MicroMsg.IPCallPackageUI", "cancel getPackageProductListNetScene error: %s", new Object[]{e.getMessage()});
        }
    }
}
