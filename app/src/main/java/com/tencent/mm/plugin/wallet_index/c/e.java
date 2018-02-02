package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.avm;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class e extends l {
    public b gJQ;
    private com.tencent.mm.ae.e gJT;

    public e(PayReq payReq, String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hmj = new avm();
        aVar.hmk = new avn();
        aVar.uri = "/cgi-bin/mmpay-bin/payauthapp";
        aVar.hml = n.CTRL_BYTE;
        aVar.hmm = 1000000188;
        this.gJQ = aVar.JZ();
        avm com_tencent_mm_protocal_c_avm = (avm) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_avm.ngo = payReq.appId;
        com_tencent_mm_protocal_c_avm.wDg = payReq.partnerId;
        com_tencent_mm_protocal_c_avm.whq = payReq.prepayId;
        com_tencent_mm_protocal_c_avm.vWg = payReq.nonceStr;
        com_tencent_mm_protocal_c_avm.wDh = payReq.timeStamp;
        com_tencent_mm_protocal_c_avm.vWh = payReq.packageValue;
        com_tencent_mm_protocal_c_avm.vWi = payReq.sign;
        com_tencent_mm_protocal_c_avm.vWj = payReq.signType;
        com_tencent_mm_protocal_c_avm.wDi = str;
        com_tencent_mm_protocal_c_avm.nfr = str2;
        com_tencent_mm_protocal_c_avm.niZ = str3;
        com_tencent_mm_protocal_c_avm.vQS = i.bLf();
        com_tencent_mm_protocal_c_avm.wDk = str4;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayAuthApp", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return 397;
    }
}
