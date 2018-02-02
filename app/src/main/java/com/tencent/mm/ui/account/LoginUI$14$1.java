package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.ui.account.LoginUI.14;
import com.tencent.mm.z.ar;

class LoginUI$14$1 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ 14 xPK;

    LoginUI$14$1(14 14, v vVar) {
        this.xPK = 14;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
        ar.CG().b(701, this.xPK.xPJ);
    }
}
