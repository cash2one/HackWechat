package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.ui.account.LoginHistoryUI.17;
import com.tencent.mm.z.ar;

class LoginHistoryUI$17$1 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ 17 xPc;

    LoginHistoryUI$17$1(17 17, v vVar) {
        this.xPc = 17;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
        ar.CG().b(701, this.xPc.xPa);
    }
}
