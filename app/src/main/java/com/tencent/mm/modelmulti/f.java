package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adb;
import com.tencent.mm.protocal.c.adc;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    public String content = "";
    private b gJQ;
    private e gJT;
    public int hFj = 0;
    public String title = "";

    public f(int i) {
        a aVar = new a();
        aVar.hmj = new adb();
        aVar.hmk = new adc();
        aVar.uri = "/cgi-bin/micromsg-bin/getinvitefriendsmsg";
        aVar.hmi = 1803;
        this.gJQ = aVar.JZ();
        ((adb) this.gJQ.hmg.hmo).wlx = i;
        this.hFj = i;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetInviteFriendsMsg", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            adc com_tencent_mm_protocal_c_adc = (adc) this.gJQ.hmh.hmo;
            this.title = com_tencent_mm_protocal_c_adc.wly;
            this.content = com_tencent_mm_protocal_c_adc.wlz;
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1803;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetInviteFriendsMsg", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
