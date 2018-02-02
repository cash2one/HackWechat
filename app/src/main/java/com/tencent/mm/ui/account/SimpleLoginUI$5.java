package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.z.ar;

class SimpleLoginUI$5 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ SimpleLoginUI xSL;

    SimpleLoginUI$5(SimpleLoginUI simpleLoginUI, v vVar) {
        this.xSL = simpleLoginUI;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
    }
}
