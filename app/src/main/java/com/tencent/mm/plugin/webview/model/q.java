package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.apn;
import com.tencent.mm.protocal.c.apo;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gOB;
    public String sign;
    public String tse;
    public String tsf;
    public String tsg;
    public int tsh;

    public q(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hmj = new apn();
        aVar.hmk = new apo();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
        aVar.hmi = 1177;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        apn com_tencent_mm_protocal_c_apn = (apn) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_apn.kJT = str;
        com_tencent_mm_protocal_c_apn.wim = str2;
        com_tencent_mm_protocal_c_apn.kNz = str3;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            apo com_tencent_mm_protocal_c_apo = (apo) this.gJQ.hmh.hmo;
            this.tse = com_tencent_mm_protocal_c_apo.tse;
            this.sign = com_tencent_mm_protocal_c_apo.sign;
            this.tsf = com_tencent_mm_protocal_c_apo.tsf;
            this.tsg = com_tencent_mm_protocal_c_apo.tsg;
            this.tsh = com_tencent_mm_protocal_c_apo.tsh;
            x.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[]{this.tse, this.sign, this.tsf, this.tsg, Integer.valueOf(this.tsh)});
        }
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1177;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
