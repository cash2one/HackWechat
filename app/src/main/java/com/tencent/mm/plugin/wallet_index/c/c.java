package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.protocal.c.xc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class c extends l {
    private b gJQ;
    private e gJT;
    public String tam;
    public String tan;

    public c(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2) {
        a aVar = new a();
        aVar.hmj = new xb();
        aVar.hmk = new xc();
        aVar.uri = "/cgi-bin/mmpay-bin/genprepay";
        aVar.hmi = 398;
        aVar.hml = k.CTRL_BYTE;
        aVar.hmm = 1000000189;
        this.gJQ = aVar.JZ();
        com.tencent.mm.plugin.soter.c.c bCP = com.tencent.mm.plugin.soter.c.b.bCP();
        String str9 = bCP.rSm;
        String str10 = bCP.rSn;
        xb xbVar = (xb) this.gJQ.hmg.hmo;
        xbVar.ngo = str;
        xbVar.vWh = str4;
        xbVar.vWg = str3;
        xbVar.vWi = str5;
        xbVar.vWj = str2;
        xbVar.vLX = str6;
        xbVar.vVu = str7;
        xbVar.whp = str8;
        xbVar.vDY = i;
        xbVar.whs = str9;
        xbVar.nku = str10;
        xbVar.vQS = i.bLf();
        if (i2 > 0) {
            xbVar.rYW = i2;
        }
        x.d("MicroMsg.NetSceneGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[]{str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        xc xcVar = (xc) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneGenPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", new Object[]{Integer.valueOf(xcVar.lOr), xcVar.lOs});
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneGenPrepay", "rr " + xcVar.whq);
            this.tam = xcVar.whq;
            this.tan = xcVar.whr;
        }
        String str2 = xcVar.lOs;
        this.gJT.a(i, xcVar.lOr, str2, this);
    }

    public final int getType() {
        return 398;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
