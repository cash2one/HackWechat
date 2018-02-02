package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bll;
import com.tencent.mm.protocal.c.btg;
import com.tencent.mm.protocal.c.bux;
import com.tencent.mm.protocal.c.buy;

public final class j extends n<bux, buy> {
    public j(long j, long j2, int i, String str, String str2, int i2, int i3, int[] iArr) {
        a aVar = new a();
        aVar.hmj = new bux();
        aVar.hmk = new buy();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedresult";
        aVar.hmi = 901;
        aVar.hml = 901;
        aVar.hmm = 1000000901;
        this.gJQ = aVar.JZ();
        bux com_tencent_mm_protocal_c_bux = (bux) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bux.wWw = j;
        com_tencent_mm_protocal_c_bux.wbi = j2;
        com_tencent_mm_protocal_c_bux.vWK = i;
        com_tencent_mm_protocal_c_bux.wWx = new bdo().UA(str);
        com_tencent_mm_protocal_c_bux.wWy = new bdo().UA(str2);
        com_tencent_mm_protocal_c_bux.vNO = 0.0d;
        com_tencent_mm_protocal_c_bux.vNP = 0.0d;
        com_tencent_mm_protocal_c_bux.wbh = i2;
        com_tencent_mm_protocal_c_bux.wWz = i3;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            bll com_tencent_mm_protocal_c_bll = new bll();
            int i6 = i4 + 1;
            com_tencent_mm_protocal_c_bll.wOB = iArr[i4];
            i4 = i6 + 1;
            com_tencent_mm_protocal_c_bll.wOC = iArr[i6];
            i6 = i4 + 1;
            com_tencent_mm_protocal_c_bll.wOD = iArr[i4];
            com_tencent_mm_protocal_c_bll.wOE = new btg();
            int i7 = i6 + 1;
            com_tencent_mm_protocal_c_bll.wOE.wQd = iArr[i6];
            i4 = i7 + 1;
            com_tencent_mm_protocal_c_bll.wOE.wFo = iArr[i7];
            i6 = i4 + 1;
            com_tencent_mm_protocal_c_bll.wOF = iArr[i4];
            i4 = i6 + 1;
            com_tencent_mm_protocal_c_bll.wOG = iArr[i6];
            i6 = i4 + 1;
            com_tencent_mm_protocal_c_bll.wOH = iArr[i4];
            i4 = i6 + 1;
            com_tencent_mm_protocal_c_bll.wOI = iArr[i6];
            for (i6 = 0; i6 < com_tencent_mm_protocal_c_bll.wOI; i6++) {
                if (i4 < iArr.length) {
                    i7 = i4 + 1;
                    com_tencent_mm_protocal_c_bll.wOJ.add(Integer.valueOf(iArr[i4]));
                    i4 = i7;
                }
            }
            if (i4 < iArr.length) {
                i6 = i4 + 1;
                com_tencent_mm_protocal_c_bll.wOK = iArr[i4];
                i4 = i6;
            }
            for (i6 = 0; i6 < com_tencent_mm_protocal_c_bll.wOK; i6++) {
                if (i4 < iArr.length) {
                    i7 = i4 + 1;
                    com_tencent_mm_protocal_c_bll.wOL.add(Integer.valueOf(iArr[i4]));
                    i4 = i7;
                }
            }
            if (i4 < iArr.length) {
                i6 = i4 + 1;
                com_tencent_mm_protocal_c_bll.wOM = iArr[i4];
                i4 = i6;
            }
            for (i6 = 0; i6 < com_tencent_mm_protocal_c_bll.wOM; i6++) {
                if (i4 < iArr.length) {
                    i7 = i4 + 1;
                    com_tencent_mm_protocal_c_bll.wON.add(Integer.valueOf(iArr[i4]));
                    i4 = i7;
                }
            }
            com_tencent_mm_protocal_c_bux.wlt.add(com_tencent_mm_protocal_c_bll);
        }
    }

    public final int getType() {
        return 901;
    }

    public final e bHJ() {
        return new e(this) {
            final /* synthetic */ j snS;

            {
                this.snS = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.voip.b.a.et("MicroMsg.NetSceneVoipSpeedResult", "VoipContext onVoipSpeedResultResp errType=" + i + " errCode=" + i2 + " errMsg=" + str);
                this.snS.skx.bGm();
            }
        };
    }
}
