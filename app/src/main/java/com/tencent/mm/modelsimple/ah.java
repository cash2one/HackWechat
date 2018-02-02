package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.protocal.c.bhf;
import com.tencent.mm.protocal.c.bhg;
import com.tencent.mm.sdk.platformtools.x;

public final class ah extends k implements com.tencent.mm.network.k {
    private e gJT;
    public final b hFi;

    public ah(int i, bca com_tencent_mm_protocal_c_bca) {
        x.i("MicroMsg.NetSceneSetMsgRemind", "[NetSceneSetMsgRemind] opType:%s RemindId:%s time:%s Type:%s SubType:%s", new Object[]{Integer.valueOf(i), com_tencent_mm_protocal_c_bca.wIn, Integer.valueOf(com_tencent_mm_protocal_c_bca.lOD), Integer.valueOf(com_tencent_mm_protocal_c_bca.ktN), Integer.valueOf(com_tencent_mm_protocal_c_bca.wFj)});
        a aVar = new a();
        aVar.hmj = new bhf();
        aVar.hmk = new bhg();
        aVar.uri = "/cgi-bin/micromsg-bin/setmsgremind";
        aVar.hmi = 525;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hFi = aVar.JZ();
        bhf com_tencent_mm_protocal_c_bhf = (bhf) this.hFi.hmg.hmo;
        if (i == 0) {
            i = 1;
        }
        com_tencent_mm_protocal_c_bhf.nhx = i;
        com_tencent_mm_protocal_c_bhf.wLc = com_tencent_mm_protocal_c_bca;
    }

    public final int getType() {
        return 525;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hFi, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] RemindId:%s", new Object[]{((bhg) this.hFi.hmh.hmo).wIn});
        } else {
            x.e("MicroMsg.NetSceneSetMsgRemind", "[onGYNetEnd] errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        }
        this.gJT.a(i2, i3, str, this);
    }
}
