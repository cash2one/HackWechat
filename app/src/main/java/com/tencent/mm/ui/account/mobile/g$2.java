package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.t;
import com.tencent.mm.z.ar;

class g$2 implements OnCancelListener {
    final /* synthetic */ t xTH;
    final /* synthetic */ g xUK;

    g$2(g gVar, t tVar) {
        this.xUK = gVar;
        this.xTH = tVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xTH);
        ar.CG().b(132, this.xUK);
    }
}
