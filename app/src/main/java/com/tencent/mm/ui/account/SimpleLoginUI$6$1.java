package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.ui.account.SimpleLoginUI.6;
import com.tencent.mm.z.ar;

class SimpleLoginUI$6$1 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ 6 xSM;

    SimpleLoginUI$6$1(6 6, v vVar) {
        this.xSM = 6;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
    }
}
