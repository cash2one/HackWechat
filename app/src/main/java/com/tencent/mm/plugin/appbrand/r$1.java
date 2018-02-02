package com.tencent.mm.plugin.appbrand;

import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.p.h;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.plugin.appbrand.widget.c.f;

class r$1 implements Runnable {
    final /* synthetic */ h iCJ;
    final /* synthetic */ r iCK;
    final /* synthetic */ String irZ;

    r$1(r rVar, String str, h hVar) {
        this.iCK = rVar;
        this.irZ = str;
        this.iCJ = hVar;
    }

    public final void run() {
        OnCancelListener 1 = new 1(this);
        com.tencent.mm.plugin.appbrand.widget.c.h fVar = new f(this.iCK.irF.iqt);
        fVar.setMessage(this.iCK.irF.iqt.getString(j.iAg));
        fVar.setOnCancelListener(1);
        fVar.setCanceledOnTouchOutside(false);
        this.iCJ.jRK = fVar;
        this.iCK.irF.a(fVar);
    }
}
