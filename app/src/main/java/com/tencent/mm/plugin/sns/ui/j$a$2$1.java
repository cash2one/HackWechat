package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.ui.j.a.2;

class j$a$2$1 implements OnCancelListener {
    final /* synthetic */ q rrT;
    final /* synthetic */ 2 rrU;

    j$a$2$1(2 2, q qVar) {
        this.rrU = 2;
        this.rrT = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Dk();
        g.Di().gPJ.c(this.rrT);
    }
}
