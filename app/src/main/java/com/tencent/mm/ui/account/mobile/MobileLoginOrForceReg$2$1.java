package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.ui.account.mobile.MobileLoginOrForceReg.2;
import com.tencent.mm.z.ar;

class MobileLoginOrForceReg$2$1 implements OnCancelListener {
    final /* synthetic */ y xQY;
    final /* synthetic */ 2 xUB;

    MobileLoginOrForceReg$2$1(2 2, y yVar) {
        this.xUB = 2;
        this.xQY = yVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xQY);
    }
}
