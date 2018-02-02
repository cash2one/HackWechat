package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.z.ar;

class LoginPasswordUI$6 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ LoginPasswordUI xPn;

    LoginPasswordUI$6(LoginPasswordUI loginPasswordUI, v vVar) {
        this.xPn = loginPasswordUI;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
        this.xPn.cnO();
    }
}
