package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aay;
import com.tencent.mm.protocal.c.aaz;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private static boolean bgH = false;
    private static Object lock = new Object();
    private b gJQ;
    private e gJT;
    private a pPY = new a();
    private aay pQc = null;

    public static boolean isRunning() {
        boolean z;
        synchronized (lock) {
            z = bgH;
        }
        return z;
    }

    private static void hC(boolean z) {
        synchronized (lock) {
            bgH = z;
        }
    }

    public h() {
        hC(true);
        this.pQc = SmcProtoBufUtil.toMMGetStrategyReq();
        if (this.pQc != null) {
            this.pQc.vWQ = new akc();
            this.pQc.vWQ.wrm = this.pPY.vx(0);
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (g.Di().gPJ == null || g.Di().gPJ.hmV == null) {
            x.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.gJT.a(i2, i3, str, this);
        } else if (i2 != 0) {
            x.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnStrategyResp(i2, i3, null, 1);
            SmcLogic.OnStrategyResp(i2, i3, null, 2);
            this.gJT.a(i2, i3, str, this);
            hC(false);
        } else {
            x.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
            aaz com_tencent_mm_protocal_c_aaz = (aaz) this.gJQ.hmh.hmo;
            this.pPY.a(com_tencent_mm_protocal_c_aaz.vXa, 0);
            try {
                f toSmcKVStrategyResp = SmcProtoBufUtil.toSmcKVStrategyResp(com_tencent_mm_protocal_c_aaz);
                c toSmcIdkeyStrategyResp = SmcProtoBufUtil.toSmcIdkeyStrategyResp(com_tencent_mm_protocal_c_aaz);
                SmcLogic.OnStrategyResp(0, 0, toSmcKVStrategyResp.toByteArray(), 1);
                SmcLogic.OnStrategyResp(0, 0, toSmcIdkeyStrategyResp.toByteArray(), 2);
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bh.i(e));
            }
            this.gJT.a(i2, i3, str, this);
            hC(false);
        }
    }

    public final int getType() {
        g.Dh();
        return a.Cx() ? 988 : 989;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        g.Dh();
        boolean Cx = a.Cx();
        if (!Cx) {
            this.pQc.vWP = com.tencent.mm.bq.b.bc(bh.cgp());
        }
        b.a aVar = new b.a();
        aVar.hmn = false;
        aVar.hmj = this.pQc;
        aVar.hmk = new aaz();
        aVar.uri = Cx ? "/cgi-bin/micromsg-bin/getkvidkeystrategy" : "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
        aVar.hmi = getType();
        this.gJQ = aVar.JZ();
        if (!Cx) {
            this.gJQ.a(ac.cdM());
            this.gJQ.fJZ = 1;
        }
        int a = a(eVar, this.gJQ, this);
        if (a < 0) {
            x.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                SmcLogic.OnStrategyResp(3, -1, null, 1);
                SmcLogic.OnStrategyResp(3, -1, null, 2);
                hC(false);
            } catch (Throwable e) {
                x.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bh.i(e));
            }
        }
        return a;
    }
}
