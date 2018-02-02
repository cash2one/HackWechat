package com.tencent.mm.plugin.safedevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.safedevice.a.b;
import com.tencent.mm.plugin.safedevice.ui.MySafeDeviceListUI.9;
import com.tencent.mm.z.ar;

class MySafeDeviceListUI$9$1 implements OnCancelListener {
    final /* synthetic */ 9 pRE;
    final /* synthetic */ b pRs;

    MySafeDeviceListUI$9$1(9 9, b bVar) {
        this.pRE = 9;
        this.pRs = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.pRs);
    }
}
