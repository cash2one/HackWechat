package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.z.ar;

class f$1 implements OnCancelListener {
    final /* synthetic */ s xPl;
    final /* synthetic */ f xUF;

    f$1(f fVar, s sVar) {
        this.xUF = fVar;
        this.xPl = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xPl);
        ar.CG().b((int) c.CTRL_INDEX, this.xUF);
    }
}
