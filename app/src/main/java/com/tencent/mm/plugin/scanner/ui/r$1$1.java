package com.tencent.mm.plugin.scanner.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.scanner.ui.r.1;
import com.tencent.mm.z.ar;

class r$1$1 implements OnCancelListener {
    final /* synthetic */ 1 pZB;

    r$1$1(1 1) {
        this.pZB = 1;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.pZB.pZA.pZz);
        this.pZB.pZA.mIl = null;
    }
}
