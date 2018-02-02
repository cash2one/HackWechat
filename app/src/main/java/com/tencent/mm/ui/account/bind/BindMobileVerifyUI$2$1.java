package com.tencent.mm.ui.account.bind;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.ui.account.bind.BindMobileVerifyUI.2;
import com.tencent.mm.z.ar;

class BindMobileVerifyUI$2$1 implements OnCancelListener {
    final /* synthetic */ t xTH;
    final /* synthetic */ 2 xTI;

    BindMobileVerifyUI$2$1(2 2, t tVar) {
        this.xTI = 2;
        this.xTH = tVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xTH);
    }
}
