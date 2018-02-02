package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.z.ar;

class c$4 implements OnCancelListener {
    final /* synthetic */ k flZ;
    final /* synthetic */ c piX;

    c$4(c cVar, k kVar) {
        this.piX = cVar;
        this.flZ = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().b(536, this.piX);
        b ctVar = new ct();
        ctVar.fqX.opType = 2;
        ctVar.fqX.frb = this.flZ;
        a.xef.m(ctVar);
    }
}
