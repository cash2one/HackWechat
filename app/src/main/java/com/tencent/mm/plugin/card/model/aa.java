package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aad;
import com.tencent.mm.protocal.c.aae;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.sdk.platformtools.x;

public final class aa extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String kLN;

    public aa(String str, int i, String str2, String str3, String str4, String str5, int i2, String str6, blp com_tencent_mm_protocal_c_blp) {
        a aVar = new a();
        aVar.hmj = new aad();
        aVar.hmk = new aae();
        aVar.uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
        aVar.hmi = 645;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aad com_tencent_mm_protocal_c_aad = (aad) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aad.fGU = str;
        com_tencent_mm_protocal_c_aad.fGW = i;
        com_tencent_mm_protocal_c_aad.kKY = str2;
        com_tencent_mm_protocal_c_aad.fGV = str3;
        com_tencent_mm_protocal_c_aad.vEH = str4;
        com_tencent_mm_protocal_c_aad.vEG = str5;
        com_tencent_mm_protocal_c_aad.vEI = i2;
        com_tencent_mm_protocal_c_aad.wjt = str6;
        com_tencent_mm_protocal_c_aad.vEK = com_tencent_mm_protocal_c_blp;
    }

    public final int getType() {
        return 645;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.kLN = ((aae) this.gJQ.hmh.hmo).kLN;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
