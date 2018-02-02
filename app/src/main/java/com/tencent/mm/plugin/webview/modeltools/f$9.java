package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.g.a.kw;
import com.tencent.mm.protocal.c.bzr;
import com.tencent.mm.protocal.c.ii;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class f$9 extends c<kw> {
    final /* synthetic */ f tuZ;

    f$9(f fVar) {
        this.tuZ = fVar;
        this.xen = kw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kw kwVar = (kw) bVar;
        if (kwVar.fCe.scene == 0) {
            f.bRz().tlN = 0;
            f.bRz().tke = null;
        } else {
            f.bRz().tlN = 1;
            f.bRz().tke = new bzr();
            f.bRz().tke.wZn = 1;
            f.bRz().tke.wZo = new ii();
            f.bRz().tke.wZo.fFm = kwVar.fCe.appId;
            f.bRz().tke.wZo.vOu = kwVar.fCe.type;
            f.bRz().tke.wZo.vOv = kwVar.fCe.version;
            f.bRz().tke.wZo.vOw = kwVar.fCe.fCg;
        }
        return false;
    }
}
