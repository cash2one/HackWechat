package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.scanner.a.f;
import com.tencent.mm.z.ar;

class p$5 implements OnCancelListener {
    final /* synthetic */ p pYq;
    final /* synthetic */ f pYr;

    p$5(p pVar, f fVar) {
        this.pYq = pVar;
        this.pYr = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.pYr);
        this.pYq.pXp.hG(false);
        this.pYq.pYh = false;
    }
}
