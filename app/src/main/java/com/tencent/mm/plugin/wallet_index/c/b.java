package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.protocal.c.wz;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class b extends l {
    private com.tencent.mm.ae.b gJQ;
    private e gJT;
    public String tam;
    public String tan;

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2, String str9) {
        a aVar = new a();
        aVar.hmj = new wz();
        aVar.hmk = new xa();
        aVar.uri = "/cgi-bin/mmpay-bin/genmallprepay";
        aVar.hml = k.CTRL_BYTE;
        aVar.hmm = 1000000189;
        this.gJQ = aVar.JZ();
        wz wzVar = (wz) this.gJQ.hmg.hmo;
        wzVar.ngo = str;
        wzVar.vWh = str4;
        wzVar.vWg = str3;
        wzVar.vWi = str5;
        wzVar.vWj = str2;
        wzVar.vLX = str6;
        wzVar.vVu = str7;
        wzVar.whp = str8;
        wzVar.vDY = i;
        wzVar.nkB = str9;
        if (i2 > 0) {
            wzVar.rYW = i2;
        }
        x.d("MicroMsg.NetSceneGenMallPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,channel:%s,scene:%s", new Object[]{str, str4, str3, str5, str2, str6, str7, str8, Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneGenMallPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        xa xaVar = (xa) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneGenMallPrepay", "hy: errCode and errMsg in proto: errCode: %d, errMsg:%s", Integer.valueOf(xaVar.lOr), xaVar.lOs);
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneGenMallPrepay", "rr " + xaVar.whq);
            this.tam = xaVar.whq;
            this.tan = xaVar.whr;
        }
        String str2 = xaVar.lOs;
        this.gJT.a(i, xaVar.lOr, str2, this);
    }

    public final int getType() {
        return 2755;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
