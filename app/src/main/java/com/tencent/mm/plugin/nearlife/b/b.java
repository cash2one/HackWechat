package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aog;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.po;
import com.tencent.mm.protocal.c.pp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.b hmb;
    private e oPD;
    public String oPE;

    public b(String str, String str2, String str3, aog com_tencent_mm_protocal_c_aog, int i, LinkedList<bdo> linkedList, String str4) {
        a aVar = new a();
        aVar.hmj = new po();
        aVar.hmk = new pp();
        aVar.uri = "/cgi-bin/micromsg-bin/createpoi";
        aVar.hmi = 650;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hmb = aVar.JZ();
        String az = bh.az(str4, "");
        String az2 = bh.az(null, "");
        po poVar = (po) this.hmb.hmg.hmo;
        poVar.nfp = str;
        poVar.vYy = str2;
        poVar.vYA = com_tencent_mm_protocal_c_aog;
        poVar.ksO = i;
        if (linkedList != null) {
            poVar.vYB = linkedList;
        }
        poVar.vYC = az;
        poVar.vYD = az2;
        poVar.vYz = str3;
        x.d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", new Object[]{str, str2, str3, Float.valueOf(com_tencent_mm_protocal_c_aog.vQu), Float.valueOf(com_tencent_mm_protocal_c_aog.vQt), Integer.valueOf(i), az, az2});
    }

    public final int getType() {
        return 650;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.oPD = eVar2;
        return a(eVar, this.hmb, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        pp ppVar = (pp) this.hmb.hmh.hmo;
        if (this.hmb.hmh.vBp != 0) {
            this.oPD.a(i2, i3, str, this);
            return;
        }
        this.oPE = ppVar.vYE;
        x.d("MicroMsg.NetSceneCreatePoi", "poi:" + this.oPE);
        this.oPD.a(i2, i3, str, this);
    }
}
