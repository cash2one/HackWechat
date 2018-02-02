package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ad.h;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aok;
import com.tencent.mm.protocal.c.aol;
import com.tencent.mm.protocal.c.aom;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class e extends k implements com.tencent.mm.network.k {
    final b gJQ;
    private com.tencent.mm.ae.e gJT;

    public e(String str) {
        a aVar = new a();
        aVar.hmj = new aol();
        aVar.hmk = new aom();
        aVar.uri = "/cgi-bin/micromsg-bin/getroommember";
        aVar.hmi = 377;
        aVar.hml = 184;
        aVar.hmm = 1000000184;
        this.gJQ = aVar.JZ();
        ((aol) this.gJQ.hmg.hmo).hIz = str;
        x.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:" + str);
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 377;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        aom com_tencent_mm_protocal_c_aom = (aom) this.gJQ.hmh.hmo;
        if (i2 != 0) {
            this.gJT.a(i2, i3, str, this);
            return;
        }
        List arrayList = new ArrayList();
        for (int i4 = 0; i4 < com_tencent_mm_protocal_c_aom.vGF.size(); i4++) {
            h hVar = new h();
            hVar.username = ((aok) com_tencent_mm_protocal_c_aom.vGF.get(i4)).ksU;
            hVar.hly = ((aok) com_tencent_mm_protocal_c_aom.vGF.get(i4)).vUU;
            hVar.hlx = ((aok) com_tencent_mm_protocal_c_aom.vGF.get(i4)).vUV;
            hVar.bA(true);
            arrayList.add(hVar);
        }
        n.JQ().H(arrayList);
        this.gJT.a(i2, i3, str, this);
    }
}
