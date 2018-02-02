package com.tencent.mm.plugin.wallet_core.c.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.avu;
import com.tencent.mm.protocal.c.avv;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new avu();
        aVar.hmk = new avv();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgcheckjsapisign";
        this.gJQ = aVar.JZ();
        avu com_tencent_mm_protocal_c_avu = (avu) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_avu.ngo = str;
        com_tencent_mm_protocal_c_avu.vWh = str4;
        com_tencent_mm_protocal_c_avu.vWg = str2;
        com_tencent_mm_protocal_c_avu.vWi = str5;
        com_tencent_mm_protocal_c_avu.vWj = str6;
        com_tencent_mm_protocal_c_avu.vLX = str3;
        com_tencent_mm_protocal_c_avu.vVu = str7;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIbgCheckJsapi", "check jsapi: errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        avv com_tencent_mm_protocal_c_avv = (avv) ((b) qVar).hmh.hmo;
        if (i3 == 0 && i2 == 0) {
            i3 = com_tencent_mm_protocal_c_avv.lOr;
            str = com_tencent_mm_protocal_c_avv.lOs;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1767;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
