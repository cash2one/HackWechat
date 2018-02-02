package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.buv;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.protocal.c.bvb;

public final class i extends n<buv, buw> {
    String TAG = "MicroMsg.NetSceneVoipShutDown";

    public i(int i, long j, String str) {
        a aVar = new a();
        aVar.hmj = new buv();
        aVar.hmk = new buw();
        aVar.uri = "/cgi-bin/micromsg-bin/voipshutdown";
        aVar.hmi = af.CTRL_BYTE;
        aVar.hml = 66;
        aVar.hmm = 1000000066;
        this.gJQ = aVar.JZ();
        buv com_tencent_mm_protocal_c_buv = (buv) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_buv.wbh = i;
        com_tencent_mm_protocal_c_buv.wbi = j;
        bvb com_tencent_mm_protocal_c_bvb = new bvb();
        bdo com_tencent_mm_protocal_c_bdo = new bdo();
        com_tencent_mm_protocal_c_bdo.UA(str);
        com_tencent_mm_protocal_c_bvb.wQf = com_tencent_mm_protocal_c_bdo;
        com_tencent_mm_protocal_c_buv.wVk = com_tencent_mm_protocal_c_bvb;
        com_tencent_mm_protocal_c_buv.wUq = System.currentTimeMillis();
    }

    public final int getType() {
        return af.CTRL_BYTE;
    }

    public final e bHJ() {
        return new 1(this);
    }
}
