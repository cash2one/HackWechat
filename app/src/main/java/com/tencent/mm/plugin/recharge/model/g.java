package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.bmn;
import com.tencent.mm.protocal.c.bmo;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public final class g extends l {
    private b gJQ;
    private e gJT;
    public String mAppId;
    public PayInfo pCn;

    public g(MallRechargeProduct mallRechargeProduct, String str) {
        this(mallRechargeProduct.appId, mallRechargeProduct.pBK, mallRechargeProduct.fqV, str);
    }

    public g(String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hmj = new bmn();
        aVar.hmk = new bmo();
        aVar.uri = "/cgi-bin/micromsg-bin/submitpayproductbuyinfo";
        aVar.hmi = 498;
        aVar.hml = bs.CTRL_INDEX;
        aVar.hmm = 1000000230;
        this.gJQ = aVar.JZ();
        bmn com_tencent_mm_protocal_c_bmn = (bmn) this.gJQ.hmg.hmo;
        x.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "remark: %s", new Object[]{str4});
        this.mAppId = str;
        com_tencent_mm_protocal_c_bmn.wgt = str;
        com_tencent_mm_protocal_c_bmn.wgs = str2;
        com_tencent_mm_protocal_c_bmn.wlD = str3;
        com_tencent_mm_protocal_c_bmn.wgu = str4;
        com_tencent_mm_protocal_c_bmn.vZK = c.bMe().Na(str2);
    }

    public final void e(int i, int i2, String str, q qVar) {
        this.pCn = new PayInfo();
        bmo com_tencent_mm_protocal_c_bmo = (bmo) ((b) qVar).hmh.hmo;
        if (i == 0 && i2 == 0) {
            x.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "resp.ReqKey " + com_tencent_mm_protocal_c_bmo.vIT);
            this.pCn.appId = this.mAppId;
            this.pCn.tan = com_tencent_mm_protocal_c_bmo.whr;
            this.pCn.fuH = com_tencent_mm_protocal_c_bmo.vIT;
        }
        if (i2 == 0) {
            i2 = com_tencent_mm_protocal_c_bmo.wgv;
        }
        if (bh.ov(str)) {
            str = com_tencent_mm_protocal_c_bmo.wgw;
        }
        this.pCn.vzw = String.valueOf(i2);
        this.pCn.fnL = str != null ? str : "";
        x.d("MicroMsg.NetSceneSubmitPayProductBuyInfo", "errCode " + i2 + ", errMsg " + str);
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return 498;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
