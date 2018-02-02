package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.z.ar;

class e$6 implements OnCancelListener {
    final /* synthetic */ ac kBB;
    final /* synthetic */ e qab;

    e$6(e eVar, ac acVar) {
        this.qab = eVar;
        this.kBB = acVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.kBB);
        if (this.qab.pZY != null) {
            this.qab.pZY.m(1, null);
        }
    }
}
