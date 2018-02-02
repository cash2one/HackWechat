package com.tencent.mm.plugin.safedevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.safedevice.ui.SecurityAccountVerifyUI.6;
import com.tencent.mm.z.ar;

class SecurityAccountVerifyUI$6$1 implements OnCancelListener {
    final /* synthetic */ k pSb;
    final /* synthetic */ 6 pSc;

    SecurityAccountVerifyUI$6$1(6 6, k kVar) {
        this.pSc = 6;
        this.pSb = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.pSb);
    }
}
