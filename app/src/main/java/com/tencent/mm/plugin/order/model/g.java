package com.tencent.mm.plugin.order.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.az;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class g extends l {
    private b gJQ;
    private e gJT;

    public g(String str, String str2, int i) {
        a aVar = new a();
        aVar.hmj = new avq();
        aVar.hmk = new avr();
        aVar.uri = "/cgi-bin/micromsg-bin/paydeluserroll";
        aVar.hmi = bf.CTRL_INDEX;
        aVar.hml = az.CTRL_BYTE;
        aVar.hmm = 1000000187;
        this.gJQ = aVar.JZ();
        avq com_tencent_mm_protocal_c_avq = (avq) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_avq.wDo = 1;
        if (!bh.ov(str)) {
            com_tencent_mm_protocal_c_avq.pbi = str;
        }
        if (!bh.ov(str2)) {
            com_tencent_mm_protocal_c_avq.pbB = str2;
        }
        com_tencent_mm_protocal_c_avq.vQS = i.bLf();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayDelUserRoll", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gJT.a(i, i2, str, this);
    }

    public final int biC() {
        return ((avq) this.gJQ.hmg.hmo).wDo;
    }

    public final String biD() {
        return ((avq) this.gJQ.hmg.hmo).pbi;
    }

    public final int getType() {
        return bf.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
