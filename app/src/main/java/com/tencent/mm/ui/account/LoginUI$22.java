package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.z.ar;

class LoginUI$22 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ LoginUI xPJ;

    LoginUI$22(LoginUI loginUI, v vVar) {
        this.xPJ = loginUI;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
        ar.CG().b(701, this.xPJ);
    }
}
