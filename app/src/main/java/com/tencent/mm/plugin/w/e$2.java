package com.tencent.mm.plugin.w;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.io.File;

class e$2 implements e {
    final /* synthetic */ e oFJ;

    e$2(e eVar) {
        this.oFJ = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(222, this.oFJ.oFI);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.MsgSynchronizeServer", "msgSynchronize success. ");
            com.tencent.mm.a.e.g(new File(f.bbO()));
            com.tencent.mm.a.e.g(new File(f.bbP()));
            long bz = bh.bz(this.oFJ.oFD);
            g.pQN.a(466, 1, 1, false);
            g.pQN.a(466, 5, this.oFJ.oFG, false);
            g.pQN.a(466, 7, bz, false);
            g.pQN.a(466, 11, this.oFJ.oFF, false);
            g.pQN.a(466, 12, this.oFJ.oFE, false);
            g.pQN.h(14108, Long.valueOf(this.oFJ.oFG), Long.valueOf(bz), Long.valueOf(this.oFJ.oFF), Long.valueOf(this.oFJ.oFE), Integer.valueOf(0), Integer.valueOf(this.oFJ.fAo));
            return;
        }
        x.e("MicroMsg.MsgSynchronizeServer", "msgSynchronize appmsg.  errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        g.pQN.a(466, 3, 1, false);
        g.pQN.h(14108, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(this.oFJ.fAo));
    }
}
