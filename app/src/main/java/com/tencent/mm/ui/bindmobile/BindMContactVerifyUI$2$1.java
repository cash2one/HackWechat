package com.tencent.mm.ui.bindmobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.ui.bindmobile.BindMContactVerifyUI.2;
import com.tencent.mm.z.ar;

class BindMContactVerifyUI$2$1 implements OnCancelListener {
    final /* synthetic */ t xTH;
    final /* synthetic */ 2 ylW;

    BindMContactVerifyUI$2$1(2 2, t tVar) {
        this.ylW = 2;
        this.xTH = tVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xTH);
    }
}
