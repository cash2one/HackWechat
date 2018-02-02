package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.ui.account.LoginIndepPass.13.1;
import com.tencent.mm.z.ar;

class LoginIndepPass$13$1$1 implements OnCancelListener {
    final /* synthetic */ s xPl;
    final /* synthetic */ 1 xPm;

    LoginIndepPass$13$1$1(1 1, s sVar) {
        this.xPm = 1;
        this.xPl = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xPl);
        ar.CG().b(701, this.xPm.xPk.xPi);
    }
}
