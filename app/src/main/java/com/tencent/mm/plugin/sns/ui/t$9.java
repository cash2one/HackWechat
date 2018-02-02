package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.q;

class t$9 implements OnCancelListener {
    final /* synthetic */ t rtq;
    final /* synthetic */ q rtv;

    t$9(t tVar, q qVar) {
        this.rtq = tVar;
        this.rtv = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.Dk();
        g.Di().gPJ.c(this.rtv);
    }
}
