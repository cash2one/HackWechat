package com.tencent.mm.plugin.safedevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.safedevice.ui.SecurityAccountVerifyUI.3;
import com.tencent.mm.z.ar;

class SecurityAccountVerifyUI$3$1 implements OnCancelListener {
    final /* synthetic */ k pRS;
    final /* synthetic */ 3 pSa;

    SecurityAccountVerifyUI$3$1(3 3, k kVar) {
        this.pSa = 3;
        this.pRS = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.pRS);
    }
}
