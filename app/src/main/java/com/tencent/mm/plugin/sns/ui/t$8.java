package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.q;

class t$8 implements OnCancelListener {
    final /* synthetic */ t rtq;
    final /* synthetic */ q rtu;

    t$8(t tVar, q qVar) {
        this.rtq = tVar;
        this.rtu = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.rtq.ktJ != 0) {
            g.Dk();
            g.Di().gPJ.c(this.rtu);
            this.rtq.ktJ = 0;
        }
    }
}
