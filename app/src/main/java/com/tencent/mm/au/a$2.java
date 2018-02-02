package com.tencent.mm.au;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class a$2 implements OnCancelListener {
    final /* synthetic */ Runnable hHO;

    a$2(Runnable runnable) {
        this.hHO = runnable;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.hHO != null) {
            this.hHO.run();
        }
    }
}
