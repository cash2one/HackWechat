package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.ui.account.mobile.f.3;
import com.tencent.mm.z.ar;

class f$3$1 implements OnCancelListener {
    final /* synthetic */ v xOp;
    final /* synthetic */ 3 xUG;

    f$3$1(3 3, v vVar) {
        this.xUG = 3;
        this.xOp = vVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xOp);
        ar.CG().b(701, this.xUG.xUF);
    }
}
