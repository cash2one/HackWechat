package com.tencent.mm.modelvideo;

import com.tencent.mm.modelvideo.g.1.1;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class g$1$1$1 implements Runnable {
    final /* synthetic */ 1 hUx;

    g$1$1$1(1 1) {
        this.hUx = 1;
    }

    public final void run() {
        g.m(this.hUx.hUw.hUv);
        g.g(this.hUx.hUw.hUv).status = 104;
        g.g(this.hUx.hUw.hUv).hVE = bh.Wo();
        g.g(this.hUx.hUw.hUv).hVF = bh.Wo();
        g.g(this.hUx.hUw.hUv).hUp = 0;
        g.g(this.hUx.hUw.hUv).fDt = 1800;
        boolean e = t.e(g.g(this.hUx.hUw.hUv));
        x.i("MicroMsg.NetSceneUploadVideo", "%s summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[]{g.a(this.hUx.hUw.hUv), Boolean.valueOf(g.h(this.hUx.hUw.hUv)), Boolean.valueOf(e), Long.valueOf(g.g(this.hUx.hUw.hUv).hVE)});
        this.hUx.hUw.hUv.a(g.n(this.hUx.hUw.hUv), g.f(this.hUx.hUw.hUv));
    }
}
