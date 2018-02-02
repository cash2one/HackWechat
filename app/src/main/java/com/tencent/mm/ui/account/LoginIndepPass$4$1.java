package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.ui.account.LoginIndepPass.4;
import com.tencent.mm.z.ar;

class LoginIndepPass$4$1 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ 4 xPj;

    LoginIndepPass$4$1(4 4, v vVar) {
        this.xPj = 4;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
        ar.CG().b(701, this.xPj.xPi);
    }
}
