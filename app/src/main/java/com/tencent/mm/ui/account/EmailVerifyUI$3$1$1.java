package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.ui.account.EmailVerifyUI.3.1;
import com.tencent.mm.z.ar;

class EmailVerifyUI$3$1$1 implements OnCancelListener {
    final /* synthetic */ u xNM;
    final /* synthetic */ 1 xNN;

    EmailVerifyUI$3$1$1(1 1, u uVar) {
        this.xNN = 1;
        this.xNM = uVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xNM);
    }
}
