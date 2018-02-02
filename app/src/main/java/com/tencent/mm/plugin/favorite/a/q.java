package com.tencent.mm.plugin.favorite.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.acg;
import com.tencent.mm.protocal.c.ach;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT = null;

    public q() {
        a aVar = new a();
        aVar.hmj = new acg();
        aVar.hmk = new ach();
        aVar.uri = "/cgi-bin/micromsg-bin/getfavinfo";
        aVar.hmi = 438;
        aVar.hml = com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX;
        aVar.hmm = 1000000217;
        this.gJQ = aVar.JZ();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetFavInfo", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ach com_tencent_mm_protocal_c_ach = (ach) ((b) qVar).hmh.hmo;
            x.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[]{Long.valueOf(com_tencent_mm_protocal_c_ach.vGU), Long.valueOf(com_tencent_mm_protocal_c_ach.ktl), Integer.valueOf(com_tencent_mm_protocal_c_ach.wlc), Integer.valueOf(com_tencent_mm_protocal_c_ach.wlb), Integer.valueOf(com_tencent_mm_protocal_c_ach.wla)});
            j.di(com_tencent_mm_protocal_c_ach.vGU);
            j.dj(com_tencent_mm_protocal_c_ach.ktl);
            j.dk((long) com_tencent_mm_protocal_c_ach.wlc);
            j.dl((long) com_tencent_mm_protocal_c_ach.wlb);
            j.dm((long) com_tencent_mm_protocal_c_ach.wla);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 438;
    }
}
