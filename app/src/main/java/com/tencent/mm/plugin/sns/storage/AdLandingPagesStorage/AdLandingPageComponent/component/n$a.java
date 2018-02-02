package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Looper;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.d.d;
import java.io.Serializable;

class n$a extends d implements Serializable {
    final /* synthetic */ n rjH;
    c rjK = new c(this);
    c rjL = new g(this);
    c rjM = new e(this);
    c rjN = new h(this);
    c rjO = new i(this);
    c rjP = new f(this);
    c rjQ = new b(this);
    c rjR = new a(this);
    c rjS = new d(this);

    protected n$a(n nVar, String str) {
        this.rjH = nVar;
        super(str, Looper.getMainLooper());
        a(this.rjL);
        a(this.rjK);
        a(this.rjM);
        a(this.rjN);
        a(this.rjO);
        a(this.rjP);
        a(this.rjQ);
        a(this.rjR);
        a(this.rjS);
        b(this.rjS);
        AdLandingPagesProxy.getInstance().addReportInfo(n.b(nVar).fFm, n.b(nVar).reb, n.b(nVar).rea);
    }
}
