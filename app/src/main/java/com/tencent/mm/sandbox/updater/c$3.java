package com.tencent.mm.sandbox.updater;

import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sandbox.b$a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class c$3 implements b$a {
    final /* synthetic */ c xcI;

    c$3(c cVar) {
        this.xcI = cVar;
    }

    public final void cj(int i, int i2) {
        x.d("MicroMsg.NetSceneGetUpdatePackFromCDN", "progress, total=" + i + ", offset=" + i2);
        c.b(this.xcI).cj(i, i2);
    }

    public final void a(int i, int i2, bdf com_tencent_mm_protocal_c_bdf) {
        if (i != 0) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene error. netRet=" + i);
            if (i == -2) {
                new File(this.xcI.baW()).delete();
            }
            c.e(this.xcI);
            this.xcI.a(c.b(this.xcI));
            return;
        }
        x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene success");
        try {
            if (e.bN(this.xcI.baW()) < c.f(this.xcI)) {
                x.i("MicroMsg.NetSceneGetUpdatePackFromCDN", "scene continue;");
                this.xcI.a(c.b(this.xcI));
            } else if (c.g(this.xcI)) {
                if (c.h(this.xcI).equalsIgnoreCase(g.bV(this.xcI.baW()))) {
                    c.a(this.xcI, com_tencent_mm_protocal_c_bdf);
                    return;
                }
                x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "pack md5 check error");
                new File(this.xcI.baW()).delete();
                c.b(this.xcI).a(2, -1, com_tencent_mm_protocal_c_bdf);
            } else if (c.i(this.xcI).equalsIgnoreCase(g.bV(this.xcI.baW()))) {
                e.g(c.xca, c.j(this.xcI) + ".temp", c.k(this.xcI) + ".apk");
                c.b(this.xcI).a(200, 0, com_tencent_mm_protocal_c_bdf);
            } else {
                x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "update pack check error");
                new File(this.xcI.baW()).delete();
                c.b(this.xcI).a(-1, -1, com_tencent_mm_protocal_c_bdf);
            }
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneGetUpdatePackFromCDN", "error occured during pack processing");
            x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePackFromCDN", e, "", new Object[0]);
            c.b(this.xcI).a(-1, -1, com_tencent_mm_protocal_c_bdf);
        }
    }

    public final void fD(long j) {
        c.b(this.xcI).fD(j);
    }

    public final void fE(long j) {
        c.b(this.xcI).fE(j);
    }
}
