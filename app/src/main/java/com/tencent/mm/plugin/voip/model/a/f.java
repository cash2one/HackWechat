package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.protocal.c.buk;
import com.tencent.mm.protocal.c.bul;

public final class f extends n<buk, bul> {
    String TAG = "MicroMsg.NetSceneVoipHeartBeat";

    public f(int i, long j, int i2) {
        a aVar = new a();
        aVar.hmj = new buk();
        aVar.hmk = new bul();
        aVar.uri = "/cgi-bin/micromsg-bin/voipheartbeat";
        aVar.hmi = 178;
        aVar.hml = 81;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        buk com_tencent_mm_protocal_c_buk = (buk) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_buk.wbh = i;
        com_tencent_mm_protocal_c_buk.wbi = j;
        com_tencent_mm_protocal_c_buk.wUq = System.currentTimeMillis();
        com_tencent_mm_protocal_c_buk.wVv = i2;
    }

    public final int getType() {
        return 178;
    }

    public final e bHJ() {
        return new 1(this);
    }
}
