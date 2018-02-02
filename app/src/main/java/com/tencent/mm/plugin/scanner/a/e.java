package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.atm;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private com.tencent.mm.ae.e gJT;
    private byte[] pSK;
    private int pSL = 1;
    private String pSM = "en";
    private String pSN = "zh_CN";
    private int pSO;

    public e(byte[] bArr, String str, String str2, int i) {
        this.pSK = bArr;
        this.pSL = 1;
        this.pSM = str;
        this.pSN = str2;
        this.pSO = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        aVar.hmj = new atm();
        aVar.hmk = new atn();
        aVar.uri = "/cgi-bin/micromsg-bin/ocrtranslation";
        aVar.hmi = 392;
        aVar.hml = 199;
        aVar.hmm = 1000000199;
        this.gJQ = aVar.JZ();
        atm com_tencent_mm_protocal_c_atm = (atm) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_atm.vNT = ((int) bh.Wp()) & Integer.MAX_VALUE;
        com_tencent_mm_protocal_c_atm.vNU = new bdn().bj(this.pSK);
        com_tencent_mm_protocal_c_atm.vNX = this.pSL;
        com_tencent_mm_protocal_c_atm.wBB = this.pSM;
        com_tencent_mm_protocal_c_atm.wBC = this.pSN;
        com_tencent_mm_protocal_c_atm.vNY = this.pSO;
        return a(eVar, this.gJQ, this);
    }

    protected final int a(q qVar) {
        atm com_tencent_mm_protocal_c_atm = (atm) ((b) qVar).hmg.hmo;
        if (com_tencent_mm_protocal_c_atm.vNT > 0 && !bh.ov(com_tencent_mm_protocal_c_atm.wBC) && !bh.ov(com_tencent_mm_protocal_c_atm.wBB) && com_tencent_mm_protocal_c_atm.vNX >= 0 && com_tencent_mm_protocal_c_atm.vNU != null && com_tencent_mm_protocal_c_atm.vNU.wJB > 0) {
            return k.b.hmP;
        }
        x.e("MicroMsg.scanner.NetSceneOCRTranslate", "ERR: Security Check Failed");
        return k.b.hmQ;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.scanner.NetSceneOCRTranslate", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 392;
    }
}
