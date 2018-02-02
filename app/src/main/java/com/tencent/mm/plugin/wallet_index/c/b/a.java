package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.protocal.c.aws;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class a extends l {
    private b gJQ;
    private e gJT;
    public String tam;
    public String tan;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new awr();
        aVar.hmk = new aws();
        aVar.uri = "/cgi-bin/mmpay-bin/payugenprepay";
        aVar.hmi = 1521;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        awr com_tencent_mm_protocal_c_awr = (awr) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_awr.ngo = str;
        com_tencent_mm_protocal_c_awr.vWh = str4;
        com_tencent_mm_protocal_c_awr.vWg = str3;
        com_tencent_mm_protocal_c_awr.vWi = str5;
        com_tencent_mm_protocal_c_awr.vWj = str2;
        com_tencent_mm_protocal_c_awr.vLX = str6;
        com_tencent_mm_protocal_c_awr.vVu = str7;
        com_tencent_mm_protocal_c_awr.whp = str8;
        com_tencent_mm_protocal_c_awr.vDY = i;
        x.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[]{str, str4, str3, str5, str2, str6, str7, str8}));
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        aws com_tencent_mm_protocal_c_aws = (aws) ((b) qVar).hmh.hmo;
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetScenePayUGenPrepay", "rr " + com_tencent_mm_protocal_c_aws.whq);
            this.tam = com_tencent_mm_protocal_c_aws.whq;
            this.tan = com_tencent_mm_protocal_c_aws.whr;
        }
        this.gJT.a(i, i2, com_tencent_mm_protocal_c_aws.lOs, this);
    }

    public final int getType() {
        return 1521;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
