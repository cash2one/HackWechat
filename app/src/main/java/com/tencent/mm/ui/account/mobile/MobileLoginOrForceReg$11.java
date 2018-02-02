package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.z.ar;

class MobileLoginOrForceReg$11 implements OnCancelListener {
    final /* synthetic */ y xQY;
    final /* synthetic */ MobileLoginOrForceReg xUx;

    MobileLoginOrForceReg$11(MobileLoginOrForceReg mobileLoginOrForceReg, y yVar) {
        this.xUx = mobileLoginOrForceReg;
        this.xQY = yVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xQY);
    }
}
