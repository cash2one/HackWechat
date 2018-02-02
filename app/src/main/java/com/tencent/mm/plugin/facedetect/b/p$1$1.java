package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.facedetect.b.p.1;
import com.tencent.mm.sdk.platformtools.x;

class p$1$1 implements e {
    final /* synthetic */ 1 mft;

    p$1$1(1 1) {
        this.mft = 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.NetSceneFaceRsaBase", "hy: summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            this.mft.mfs.g(this.mft.mfs.hmA);
            return;
        }
        x.e("MicroMsg.NetSceneFaceRsaBase", "hy: do scene err in rsa when get cert. clear ticket");
        p.mfr = null;
        this.mft.mfs.zH(p.NW());
        this.mft.mfs.gJT.a(i, i2, "", this.mft.mfs);
    }
}
