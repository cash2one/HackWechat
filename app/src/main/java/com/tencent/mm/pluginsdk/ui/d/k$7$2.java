package com.tencent.mm.pluginsdk.ui.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.pluginsdk.ui.d.k.7;

class k$7$2 implements OnCancelListener {
    final /* synthetic */ 7 vuO;

    k$7$2(7 7) {
        this.vuO = 7;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.vuO.vuJ != null) {
            this.vuO.vuJ.onDismiss(null);
        }
    }
}
