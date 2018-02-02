package com.tencent.mm.pluginsdk.ui.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;

class k$6 implements OnCancelListener {
    final /* synthetic */ OnDismissListener vuJ;

    k$6(OnDismissListener onDismissListener) {
        this.vuJ = onDismissListener;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.vuJ != null) {
            this.vuJ.onDismiss(null);
        }
    }
}
