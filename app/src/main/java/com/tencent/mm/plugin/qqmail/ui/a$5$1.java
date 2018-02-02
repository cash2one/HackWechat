package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.qqmail.b.n;
import com.tencent.mm.plugin.qqmail.ui.a.5;
import com.tencent.mm.z.ar;

class a$5$1 implements OnCancelListener {
    final /* synthetic */ n prZ;
    final /* synthetic */ 5 psb;

    a$5$1(5 5, n nVar) {
        this.psb = 5;
        this.prZ = nVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.prZ);
    }
}
