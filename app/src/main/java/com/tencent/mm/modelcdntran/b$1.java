package com.tencent.mm.modelcdntran;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak;

class b$1 implements a {
    final /* synthetic */ b hso;

    b$1(b bVar) {
        this.hso = bVar;
    }

    public final boolean uF() {
        if (b.a(this.hso) == 0 && b.b(this.hso) == 0) {
            return false;
        }
        x.i("MicroMsg.CdnTransportEngine", "CdnDataFlowStat id:%s send:%d recv:%d", b.c(this.hso), Integer.valueOf(b.a(this.hso)), Integer.valueOf(b.b(this.hso)));
        if (ak.a.hfM == null) {
            x.e("MicroMsg.CdnTransportEngine", "getNetStat null");
            return false;
        }
        ak.a.hfM.aV(b.b(this.hso), b.a(this.hso));
        b.d(this.hso);
        b.e(this.hso);
        return true;
    }
}
