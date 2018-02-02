package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.z.ar;

class LoginIndepPass$2 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ LoginIndepPass xPi;

    LoginIndepPass$2(LoginIndepPass loginIndepPass, v vVar) {
        this.xPi = loginIndepPass;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
    }
}
