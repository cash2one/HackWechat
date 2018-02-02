package com.tencent.mm.plugin.appbrand;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.r.1;

class r$1$1 implements OnCancelListener {
    final /* synthetic */ 1 iCL;

    r$1$1(1 1) {
        this.iCL = 1;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        r.a(this.iCL.iCK, this.iCL.irZ, c.isi);
    }
}
