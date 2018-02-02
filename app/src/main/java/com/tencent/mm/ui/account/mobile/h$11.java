package com.tencent.mm.ui.account.mobile;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.modelfriend.s;
import com.tencent.mm.plugin.appbrand.jsapi.contact.c;
import com.tencent.mm.z.ar;

class h$11 implements OnCancelListener {
    final /* synthetic */ s xPl;
    final /* synthetic */ h xUN;

    h$11(h hVar, s sVar) {
        this.xUN = hVar;
        this.xPl = sVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.xPl);
        ar.CG().b(c.CTRL_INDEX, this.xUN);
    }
}
