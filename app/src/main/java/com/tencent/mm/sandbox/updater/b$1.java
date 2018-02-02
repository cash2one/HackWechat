package com.tencent.mm.sandbox.updater;

import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.c.agy;
import com.tencent.mm.protocal.c.bdf;
import com.tencent.mm.sandbox.b.a;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$1 implements a {
    final /* synthetic */ b xcA;

    b$1(b bVar) {
        this.xcA = bVar;
    }

    public final void a(int i, int i2, bdf com_tencent_mm_protocal_c_bdf) {
        if (i == 200 && i2 == 0 && (com_tencent_mm_protocal_c_bdf == null || com_tencent_mm_protocal_c_bdf.wJr.vJU == 0)) {
            agy com_tencent_mm_protocal_c_agy = (agy) com_tencent_mm_protocal_c_bdf;
            x.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : file dir = " + e.bnD);
            x.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : total len = " + com_tencent_mm_protocal_c_agy.vIB);
            x.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : start pos = " + com_tencent_mm_protocal_c_agy.vIC);
            x.d("MicroMsg.NetSceneGetUpdatePack", "onGYNetEnd : data len = " + com_tencent_mm_protocal_c_agy.vID);
            if (com_tencent_mm_protocal_c_agy.vID <= 0 || com_tencent_mm_protocal_c_agy.vXz == null) {
                x.e("MicroMsg.NetSceneGetUpdatePack", "data is null");
                b.c(this.xcA).a(i, -1, null);
            } else if (com_tencent_mm_protocal_c_agy.vXz.wJB != com_tencent_mm_protocal_c_agy.vID) {
                x.e("MicroMsg.NetSceneGetUpdatePack", "data len not match with data buf, dataLen = " + com_tencent_mm_protocal_c_agy.vID + " data buf len = " + com_tencent_mm_protocal_c_agy.vXz.wJB);
                b.c(this.xcA).a(4, -1, null);
            } else if (com_tencent_mm_protocal_c_agy.vIC < 0 || com_tencent_mm_protocal_c_agy.vIC + com_tencent_mm_protocal_c_agy.vID > com_tencent_mm_protocal_c_agy.vIB) {
                x.e("MicroMsg.NetSceneGetUpdatePack", "startPos = " + com_tencent_mm_protocal_c_agy.vIC + " dataLen = " + com_tencent_mm_protocal_c_agy.vID + " totalLen = " + com_tencent_mm_protocal_c_agy.vIB);
                b.c(this.xcA).a(4, -1, null);
            } else if (com_tencent_mm_protocal_c_agy.vIB <= 0) {
                x.e("MicroMsg.NetSceneGetUpdatePack", "totalLen is invalid: totalLen = " + com_tencent_mm_protocal_c_agy.vIB);
                b.c(this.xcA).a(4, -1, null);
            } else {
                int a = com.tencent.mm.a.e.a(c.xca, b.d(this.xcA), ".temp", com_tencent_mm_protocal_c_agy.vXz.wJD.toByteArray());
                if (a != 0) {
                    x.e("MicroMsg.NetSceneGetUpdatePack", "appendBuf failed : " + a);
                    b.c(this.xcA).a(4, -1, null);
                    return;
                }
                b.a(this.xcA, com_tencent_mm_protocal_c_agy.vID + com_tencent_mm_protocal_c_agy.vIC);
                b.b(this.xcA, com_tencent_mm_protocal_c_agy.vIB);
                b.c(this.xcA).cj(com_tencent_mm_protocal_c_agy.vIB, com_tencent_mm_protocal_c_agy.vIC);
                if (com_tencent_mm_protocal_c_agy.vIC + com_tencent_mm_protocal_c_agy.vID >= com_tencent_mm_protocal_c_agy.vIB) {
                    try {
                        if (b.f(this.xcA).equalsIgnoreCase(g.bV(b.e(this.xcA)))) {
                            com.tencent.mm.a.e.g(c.xca, b.g(this.xcA) + ".temp", b.h(this.xcA) + ".apk");
                            b.c(this.xcA).a(200, 0, com_tencent_mm_protocal_c_bdf);
                            return;
                        }
                        x.e("MicroMsg.NetSceneGetUpdatePack", "update pack check error");
                        new File(b.i(this.xcA)).delete();
                        b.c(this.xcA).a(-1, -1, com_tencent_mm_protocal_c_bdf);
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.NetSceneGetUpdatePack", e, "", new Object[0]);
                        return;
                    }
                }
                this.xcA.a(b.c(this.xcA));
            }
        } else if (this.xcA.ceh() || b.a(this.xcA) >= b.b(this.xcA).length * 5) {
            b.c(this.xcA).a(i, i2, com_tencent_mm_protocal_c_bdf);
        } else {
            this.xcA.a(b.c(this.xcA));
        }
    }

    public final void fD(long j) {
        b.c(this.xcA).fD(j);
    }

    public final void fE(long j) {
        b.c(this.xcA).fE(j);
    }

    public final void cj(int i, int i2) {
    }
}
