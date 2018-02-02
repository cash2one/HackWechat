package com.tencent.mm.plugin.safedevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.safedevice.ui.SecurityAccountIntroUI.1;
import com.tencent.mm.z.ar;

class SecurityAccountIntroUI$1$1 implements OnCancelListener {
    final /* synthetic */ k pRS;
    final /* synthetic */ 1 pRT;

    SecurityAccountIntroUI$1$1(1 1, k kVar) {
        this.pRT = 1;
        this.pRS = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.pRS);
    }
}
