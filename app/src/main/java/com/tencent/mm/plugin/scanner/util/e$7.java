package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.z.ar;

class e$7 implements OnCancelListener {
    final /* synthetic */ l jed;
    final /* synthetic */ e qab;

    e$7(e eVar, l lVar) {
        this.qab = eVar;
        this.jed = lVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.jed);
        if (this.qab.pZY != null) {
            this.qab.pZY.m(1, null);
        }
    }
}
