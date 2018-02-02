package com.tencent.mm.plugin.sns.ui.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.q;

class a$1 implements OnCancelListener {
    final /* synthetic */ a rPo;
    final /* synthetic */ q rrT;

    a$1(a aVar, q qVar) {
        this.rPo = aVar;
        this.rrT = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Dk();
        g.Di().gPJ.c(this.rrT);
    }
}
