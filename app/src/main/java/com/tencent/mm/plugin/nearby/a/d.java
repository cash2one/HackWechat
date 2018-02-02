package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aon;
import com.tencent.mm.protocal.c.aoo;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String oNY;
    public String oNZ;

    public d(float f, float f2, int i, String str, String str2) {
        a aVar = new a();
        aVar.hmj = new aon();
        aVar.hmk = new aoo();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        aVar.hmi = 376;
        aVar.hml = 183;
        aVar.hmm = 1000000183;
        this.gJQ = aVar.JZ();
        aon com_tencent_mm_protocal_c_aon = (aon) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aon.vDW = 1;
        com_tencent_mm_protocal_c_aon.vQt = f;
        com_tencent_mm_protocal_c_aon.vQu = f2;
        com_tencent_mm_protocal_c_aon.wcr = i;
        com_tencent_mm_protocal_c_aon.wcs = str;
        com_tencent_mm_protocal_c_aon.wct = str2;
        com_tencent_mm_protocal_c_aon.wcu = 0;
        x.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1" + " lon:" + f + " lat:" + f2 + " pre:" + i + " gpsSource:0 mac" + str + " cell:" + str2);
    }

    public d(String str, int i, int i2) {
        a aVar = new a();
        aVar.hmj = new aon();
        aVar.hmk = new aoo();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        aVar.hmi = 376;
        aVar.hml = 183;
        aVar.hmm = 1000000183;
        this.gJQ = aVar.JZ();
        aon com_tencent_mm_protocal_c_aon = (aon) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aon.vQt = 0.0f;
        com_tencent_mm_protocal_c_aon.vQu = 0.0f;
        com_tencent_mm_protocal_c_aon.wcr = 0;
        com_tencent_mm_protocal_c_aon.wcu = 0;
        com_tencent_mm_protocal_c_aon.wcs = "";
        com_tencent_mm_protocal_c_aon.wct = "";
        com_tencent_mm_protocal_c_aon.vDW = 2;
        com_tencent_mm_protocal_c_aon.hIz = str;
        com_tencent_mm_protocal_c_aon.wvx = i;
        com_tencent_mm_protocal_c_aon.wvw = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return 376;
    }

    public final int IS() {
        return ((aon) this.gJQ.hmg.hmo).vDW;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " opCode:" + IS());
        aoo com_tencent_mm_protocal_c_aoo = (aoo) ((b) qVar).hmh.hmo;
        if (i2 != 0) {
            this.gJT.a(i2, i3, str, this);
        } else if (IS() == 1) {
            this.oNY = com_tencent_mm_protocal_c_aoo.hIz;
            this.oNZ = com_tencent_mm_protocal_c_aoo.wvy;
            this.gJT.a(i2, i3, str, this);
        } else if (IS() == 2) {
            b.Gz(((aon) ((b) qVar).hmg.hmo).hIz);
            this.gJT.a(i2, i3, str, this);
        }
    }
}
