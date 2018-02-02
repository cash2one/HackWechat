package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.ui.base.h.c;

class k$2 implements c {
    final /* synthetic */ Context val$context;
    final /* synthetic */ OnDismissListener vuJ;
    final /* synthetic */ String vuK;

    k$2(OnDismissListener onDismissListener, String str, Context context) {
        this.vuJ = onDismissListener;
        this.vuK = str;
        this.val$context = context;
    }

    public final void jl(int i) {
        if (this.vuJ != null) {
            this.vuJ.onDismiss(null);
        }
        String replace = this.vuK.replace(" ", "").replace("#", "@");
        switch (i) {
            case 0:
                k.bd(this.val$context, replace);
                return;
            default:
                return;
        }
    }
}
