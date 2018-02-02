package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelsimple.al;
import com.tencent.mm.ui.j.12;
import com.tencent.mm.z.ar;

class j$12$2 implements OnCancelListener {
    final /* synthetic */ al qiJ;
    final /* synthetic */ 12 xFU;

    j$12$2(12 12, al alVar) {
        this.xFU = 12;
        this.qiJ = alVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().b(384, this.xFU.xFL.xFH);
        this.xFU.xFL.xFH = null;
        ar.CG().c(this.qiJ);
    }
}
