package com.tencent.mm.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.protocal.c.np;
import com.tencent.mm.protocal.c.nq;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    public static int hMG = 1;
    public static int hMH = 2;
    public static int hMI = 3;
    public static int hMJ = 4;
    private b gJQ;
    private e gJT;

    public h(int i) {
        a aVar = new a();
        aVar.hmj = new np();
        aVar.hmk = new nq();
        aVar.uri = "/cgi-bin/micromsg-bin/checkunbind";
        aVar.hmi = i.CTRL_BYTE;
        this.gJQ = aVar.JZ();
        ((np) this.gJQ.hmg.hmo).vWw = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final String RC() {
        try {
            String str = ((nq) this.gJQ.hmh.hmo).vWx;
            x.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() " + str);
            return str;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", e, "", new Object[0]);
            return null;
        }
    }

    public final int getType() {
        return i.CTRL_BYTE;
    }

    public final nq RD() {
        return (nq) this.gJQ.hmh.hmo;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.gJT.a(i2, i3, str, this);
    }
}
