package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.protocal.c.aii;
import com.tencent.mm.protocal.c.aij;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class a extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public String phe;

    public a(String str, String str2) {
        this.phe = str;
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new aii();
        aVar.hmk = new aij();
        aVar.uri = "/cgi-bin/micromsg-bin/getwburl";
        aVar.hmi = g.CTRL_INDEX;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        aii com_tencent_mm_protocal_c_aii = (aii) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aii.ksU = str2;
        ar.Hg();
        String ou = bh.ou((String) c.CU().get(46, null));
        com_tencent_mm_protocal_c_aii.vJi = new bdn().bj(bh.VD(ou));
        ar.Hg();
        String ou2 = bh.ou((String) c.CU().get(72, null));
        com_tencent_mm_protocal_c_aii.whC = new bdn().bj(bh.VD(ou2));
        x.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + str + ", a2=" + ou + " , newa2:" + ou2);
    }

    public final int getType() {
        return g.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), getURL()});
        this.gJT.a(i2, i3, str, this);
    }

    public final String getURL() {
        return ((aij) this.gJQ.hmh.hmo).URL;
    }
}
