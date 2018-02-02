package com.tencent.mm.plugin.report.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.af;
import com.tencent.mm.protocal.c.ag;
import com.tencent.mm.protocal.c.xk;
import com.tencent.mm.protocal.c.xl;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    private static boolean bgH = false;
    private static Object lock = new Object();
    private b gJQ;
    private e gJT;
    private xk pQa = null;
    public ag pQb;

    private static void hC(boolean z) {
        synchronized (lock) {
            bgH = z;
        }
    }

    public g(int i, int i2) {
        hC(true);
        af afVar = new af();
        this.pQa = new xk();
        try {
            afVar.vEA = i;
            afVar.vEB = i2;
            this.pQa.wid = afVar;
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        try {
            this.pQb = null;
            if (com.tencent.mm.kernel.g.Di().gPJ == null || com.tencent.mm.kernel.g.Di().gPJ.hmV == null) {
                x.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
                this.gJT.a(i2, i3, str, this);
            } else if (i2 != 0) {
                x.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
                this.gJT.a(i2, i3, str, this);
                hC(false);
            } else {
                x.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
                this.pQb = ((xl) this.gJQ.hmh.hmo).wie;
                this.gJT.a(i2, i3, str, this);
                hC(false);
            }
        } finally {
            hC(false);
        }
    }

    public final int getType() {
        return 914;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        com.tencent.mm.kernel.g.Dh();
        if (a.Cx()) {
            b.a aVar = new b.a();
            aVar.hmn = false;
            aVar.hmj = this.pQa;
            aVar.hmk = new xl();
            aVar.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
            aVar.hmi = 914;
            this.gJQ = aVar.JZ();
            int a = a(eVar, this.gJQ, this);
            if (a >= 0) {
                return a;
            }
            x.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                this.pQb = null;
                hC(false);
                return a;
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bh.i(e));
                return a;
            }
        }
        x.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
        return -1;
    }
}
