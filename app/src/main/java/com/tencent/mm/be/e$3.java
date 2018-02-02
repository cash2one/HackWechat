package com.tencent.mm.be;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class e$3 implements e {
    final /* synthetic */ e hPt;

    e$3(e eVar) {
        this.hPt = eVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (e.c(this.hPt) != null) {
            x.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a) kVar).filename + " filepath " + e.c(this.hPt) + " errCode " + i2);
            if (((a) kVar).filename.equals(e.c(this.hPt))) {
                g.CG().b(240, e.d(this.hPt));
                if (i2 == 0) {
                    d.SD();
                    d.SF();
                }
                try {
                    x.d("MicroMsg.SpeexUploadCore", "delete " + e.c(this.hPt) + " delete " + new File(e.c(this.hPt)).delete() + " errCode " + i2);
                } catch (Throwable e) {
                    x.e("MicroMsg.SpeexUploadCore", "exception:%s", bh.i(e));
                } finally {
                    e.SL().start();
                    e.e(this.hPt);
                }
            }
        }
    }
}
