package com.tencent.mm.plugin.fps_lighter.b;

import com.tencent.mm.g.a.fo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;

class g$1 extends c<fo> {
    final /* synthetic */ g mBk;

    g$1(g gVar) {
        this.mBk = gVar;
        this.xen = fo.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fo foVar = (fo) bVar;
        if (foVar.fuU.fpr == 1) {
            this.mBk.stop();
            this.mBk.start();
            ar.Hg();
            com.tencent.mm.z.c.CU().a(a.xuq, Boolean.valueOf(true));
        } else if (foVar.fuU.fpr == 0) {
            this.mBk.stop();
            ar.Hg();
            com.tencent.mm.z.c.CU().a(a.xuq, Boolean.valueOf(false));
        }
        return true;
    }
}
