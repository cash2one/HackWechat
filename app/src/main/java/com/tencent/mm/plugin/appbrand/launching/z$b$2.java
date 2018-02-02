package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.g.a.tw;
import com.tencent.mm.plugin.appbrand.launching.z.b;
import com.tencent.mm.sdk.b.c;

class z$b$2 extends c<tw> {
    final /* synthetic */ b jyl;

    z$b$2(b bVar) {
        this.jyl = bVar;
        this.xen = tw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        tw twVar = (tw) bVar;
        if (twVar.fMH.fMI.startsWith("WxaPkg_" + this.jyl.jyj.appId)) {
            if (twVar.fMH.fMJ >= 100) {
                dead();
            }
            this.jyl.jyj.kO(twVar.fMH.fMJ);
        }
        return false;
    }
}
