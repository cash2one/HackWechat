package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.z.ar;

class LoginSmsUI$5 implements OnCancelListener {
    final /* synthetic */ s xPl;
    final /* synthetic */ LoginSmsUI xPx;

    LoginSmsUI$5(LoginSmsUI loginSmsUI, s sVar) {
        this.xPx = loginSmsUI;
        this.xPl = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xPl);
    }
}
