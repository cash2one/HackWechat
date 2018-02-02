package com.tencent.mm.plugin.webwx.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webwx.a.e;
import com.tencent.mm.z.ar;

class ExtDeviceWXLoginUI$5 implements OnCancelListener {
    final /* synthetic */ ExtDeviceWXLoginUI tOD;
    final /* synthetic */ e tOE;

    ExtDeviceWXLoginUI$5(ExtDeviceWXLoginUI extDeviceWXLoginUI, e eVar) {
        this.tOD = extDeviceWXLoginUI;
        this.tOE = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.tOE);
        if (ExtDeviceWXLoginUI.e(this.tOD) != null) {
            ExtDeviceWXLoginUI.e(this.tOD).cancel();
        }
    }
}
