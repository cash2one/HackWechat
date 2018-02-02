package com.tencent.mm.bd;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.bgn;
import com.tencent.mm.protocal.c.bgo;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    String hLo;

    public a(float f, float f2, int i, int i2, String str, String str2, int i3, int i4, String str3) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bgn();
        aVar.hmk = new bgo();
        aVar.uri = "/cgi-bin/micromsg-bin/sensewhere";
        aVar.hmi = 752;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aog com_tencent_mm_protocal_c_aog = new aog();
        com_tencent_mm_protocal_c_aog.wct = str2;
        com_tencent_mm_protocal_c_aog.wcu = i2;
        com_tencent_mm_protocal_c_aog.vQu = f2;
        com_tencent_mm_protocal_c_aog.vQt = f;
        com_tencent_mm_protocal_c_aog.wcs = str;
        com_tencent_mm_protocal_c_aog.wcr = i;
        bgn com_tencent_mm_protocal_c_bgn = (bgn) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bgn.vYA = com_tencent_mm_protocal_c_aog;
        com_tencent_mm_protocal_c_bgn.wKS = i3;
        com_tencent_mm_protocal_c_bgn.rYW = i4;
        com_tencent_mm_protocal_c_bgn.nje = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.hLo = ((bgo) ((b) qVar).hmh.hmo).nje;
        } else {
            x.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 752;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
