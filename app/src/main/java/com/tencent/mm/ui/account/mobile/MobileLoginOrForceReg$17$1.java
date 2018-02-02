package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.ui.account.mobile.MobileLoginOrForceReg.17;
import com.tencent.mm.z.ar;

class MobileLoginOrForceReg$17$1 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ 17 xUD;

    MobileLoginOrForceReg$17$1(17 17, v vVar) {
        this.xUD = 17;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
    }
}
