package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.z.ar;

class e$15 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ e xTT;

    e$15(e eVar, v vVar) {
        this.xTT = eVar;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
    }
}
