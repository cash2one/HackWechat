package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.z.ar;

class LoginFaceUI$2 implements OnCancelListener {
    final /* synthetic */ LoginFaceUI xOo;
    final /* synthetic */ v xOp;

    LoginFaceUI$2(LoginFaceUI loginFaceUI, v vVar) {
        this.xOo = loginFaceUI;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
        this.xOo.cnO();
    }
}
