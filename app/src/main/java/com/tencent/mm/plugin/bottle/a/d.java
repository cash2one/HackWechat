package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.zr;
import com.tencent.mm.protocal.c.zs;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public final class d extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;

    public d() {
        a aVar = new a();
        aVar.hmj = new zr();
        aVar.hmk = new zs();
        aVar.uri = "/cgi-bin/micromsg-bin/getbottlecount";
        aVar.hmi = com.tencent.mm.plugin.appbrand.jsapi.contact.d.CTRL_INDEX;
        aVar.hml = 49;
        aVar.hmm = 1000000049;
        aVar.hmn = false;
        this.gJQ = aVar.JZ();
        zr zrVar = (zr) this.gJQ.hmg.hmo;
        zrVar.ksU = q.FS();
        zrVar.wjk = (int) bh.Wo();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.contact.d.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        zs zsVar = (zs) this.gJQ.hmh.hmo;
        if (i2 == 0 && i3 == 0) {
            c.nh(zsVar.wjm);
            c.ng(zsVar.wjl);
        } else if (zsVar.vJU == -2002 || zsVar.vJU == -56) {
            c.nh(0);
            c.ng(0);
        }
        x.d("MicroMsg.NetSceneGetBottleCount", "onGYNetEnd type:" + i2 + " code:" + i3 + " ret:" + zsVar.vJU + " pickCnt:" + zsVar.wjm + " throwCnt:" + zsVar.wjl);
        this.gJT.a(0, zsVar.vJU, str, this);
    }
}
