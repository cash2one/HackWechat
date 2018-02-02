package com.tencent.mm.au;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ Runnable hHO;

    a$1(Runnable runnable) {
        this.hHO = runnable;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.hHO != null) {
            this.hHO.run();
        }
    }
}
