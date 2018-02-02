package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bcn;
import com.tencent.mm.protocal.c.bco;
import com.tencent.mm.sdk.platformtools.x;

public final class ai extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public ai(String str, byte[] bArr, float f, float f2, float f3, boolean z, boolean z2) {
        a aVar = new a();
        aVar.hmj = new bcn();
        aVar.hmk = new bco();
        aVar.uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
        aVar.hmi = 2574;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bcn com_tencent_mm_protocal_c_bcn = (bcn) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bcn.fGU = str;
        com_tencent_mm_protocal_c_bcn.wIE = com.tencent.mm.bq.b.bc(bArr);
        com_tencent_mm_protocal_c_bcn.fBc = f;
        com_tencent_mm_protocal_c_bcn.fzt = f2;
        com_tencent_mm_protocal_c_bcn.wID = f3;
        com_tencent_mm_protocal_c_bcn.wIF = z;
        com_tencent_mm_protocal_c_bcn.wIG = z2;
    }

    public final int getType() {
        return 2574;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.gJT.a(i2, i3, str, this);
    }
}
