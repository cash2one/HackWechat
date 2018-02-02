package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.axn;
import com.tencent.mm.protocal.c.axo;
import com.tencent.mm.protocal.c.bos;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    private int hFj = 0;

    public i(int i, String str) {
        a aVar = new a();
        aVar.hmj = new axn();
        aVar.hmk = new axo();
        aVar.uri = "/cgi-bin/micromsg-bin/postinvitefriendsmsg";
        aVar.hmi = 1804;
        this.gJQ = aVar.JZ();
        axn com_tencent_mm_protocal_c_axn = (axn) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_axn.wlx = i;
        com_tencent_mm_protocal_c_axn.wlz = str;
        if ((i & 16) > 0) {
            com.tencent.mm.ui.i.a aVar2 = new com.tencent.mm.ui.i.a();
            bos com_tencent_mm_protocal_c_bos = new bos();
            if (aVar2.zpV == null) {
                com_tencent_mm_protocal_c_bos = null;
            } else if (!bh.ov(aVar2.zpV.token)) {
                com_tencent_mm_protocal_c_bos.wRe = aVar2.zpV.token;
                com_tencent_mm_protocal_c_bos.wRf = aVar2.zpV.wyk;
            }
            com_tencent_mm_protocal_c_axn.wEF = com_tencent_mm_protocal_c_bos;
        }
        this.hFj = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetScenePostInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1804;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetScenePostInviteFriendsMsg", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
