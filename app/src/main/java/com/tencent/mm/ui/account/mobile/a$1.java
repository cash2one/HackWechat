package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.z.ar;

class a$1 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ a xTL;

    a$1(a aVar, v vVar) {
        this.xTL = aVar;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
    }
}
