package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    public int fFn;
    private b gJQ = null;
    private e gJT = null;
    public String hcp;
    public String lPj;

    public l(String str, String str2, int i, String str3) {
        this.lPj = str3;
        this.hcp = str2;
        this.fFn = i;
        this.lPj = str3;
        a aVar = new a();
        aVar.hmj = new aop();
        aVar.hmk = new aoq();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/addlike";
        aVar.hmi = 1041;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aop com_tencent_mm_protocal_c_aop = (aop) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aop.lWn = str2;
        com_tencent_mm_protocal_c_aop.username = str;
        com_tencent_mm_protocal_c_aop.fFn = i;
        com_tencent_mm_protocal_c_aop.hbH = str3;
    }

    public final int getType() {
        return 1041;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneUpdateLikeStatus", "hy: end. errType: %d, errCode: %d, errMsg: %s, ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gJT.a(i2, i3, str, this);
    }
}
