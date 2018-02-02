package com.tencent.mm.plugin.safedevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.z.ar;

class MySafeDeviceListUI$3 implements OnCancelListener {
    final /* synthetic */ MySafeDeviceListUI pRA;
    final /* synthetic */ r pRB;

    MySafeDeviceListUI$3(MySafeDeviceListUI mySafeDeviceListUI, r rVar) {
        this.pRA = mySafeDeviceListUI;
        this.pRB = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.pRB);
    }
}
