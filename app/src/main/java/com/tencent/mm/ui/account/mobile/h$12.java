package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.z.ar;

class h$12 implements OnCancelListener {
    final /* synthetic */ x xPb;
    final /* synthetic */ h xUN;

    h$12(h hVar, x xVar) {
        this.xUN = hVar;
        this.xPb = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xPb);
    }
}
