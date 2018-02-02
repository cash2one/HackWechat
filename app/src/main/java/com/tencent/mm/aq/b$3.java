package com.tencent.mm.aq;

import com.tencent.mm.g.a.u;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<u> {
    final /* synthetic */ b hzz;

    b$3(b bVar) {
        this.hzz = bVar;
        this.xen = u.class.getName().hashCode();
    }

    private boolean a(u uVar) {
        this.hzz.hzv = uVar.fnM.mode;
        x.d("MicroMsg.AutoGetBigImgLogic", "mode = " + this.hzz.hzv);
        com.tencent.mm.modelcontrol.c.MR();
        if (!com.tencent.mm.modelcontrol.c.MS()) {
            synchronized (this.hzz.hzl) {
                this.hzz.hzl.clear();
            }
        }
        return false;
    }
}
