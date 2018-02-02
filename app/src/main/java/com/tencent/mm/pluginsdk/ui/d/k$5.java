package com.tencent.mm.pluginsdk.ui.d;

import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.pluginsdk.ui.d.k.a.a;
import com.tencent.mm.ui.base.m;

class k$5 implements a {
    final /* synthetic */ OnDismissListener vuJ;
    final /* synthetic */ m vuM;

    k$5(m mVar, OnDismissListener onDismissListener) {
        this.vuM = mVar;
        this.vuJ = onDismissListener;
    }

    public final void gf(boolean z) {
        if (z) {
            this.vuM.dismiss();
            if (this.vuJ != null) {
                this.vuJ.onDismiss(null);
            }
        }
    }
}
