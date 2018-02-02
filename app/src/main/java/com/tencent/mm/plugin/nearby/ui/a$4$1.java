package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.nearby.ui.a.4;
import com.tencent.mm.z.ar;

class a$4$1 implements OnCancelListener {
    final /* synthetic */ 4 oOv;

    a$4$1(4 4) {
        this.oOv = 4;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(a.c(this.oOv.oOu));
    }
}
