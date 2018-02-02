package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.z.ar;

class j$10 implements OnCancelListener {
    final /* synthetic */ x qiH;
    final /* synthetic */ j xFL;

    j$10(j jVar, x xVar) {
        this.xFL = jVar;
        this.qiH = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.qiH);
    }
}
