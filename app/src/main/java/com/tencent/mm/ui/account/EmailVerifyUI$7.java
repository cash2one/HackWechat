package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.u;
import com.tencent.mm.z.ar;

class EmailVerifyUI$7 implements OnCancelListener {
    final /* synthetic */ EmailVerifyUI xNK;
    final /* synthetic */ u xNM;

    EmailVerifyUI$7(EmailVerifyUI emailVerifyUI, u uVar) {
        this.xNK = emailVerifyUI;
        this.xNM = uVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xNM);
    }
}
