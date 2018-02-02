package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.z.ar;

class MobileLoginOrForceReg$19 implements OnCancelListener {
    final /* synthetic */ x xPb;
    final /* synthetic */ MobileLoginOrForceReg xUx;

    MobileLoginOrForceReg$19(MobileLoginOrForceReg mobileLoginOrForceReg, x xVar) {
        this.xUx = mobileLoginOrForceReg;
        this.xPb = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xPb);
    }
}
