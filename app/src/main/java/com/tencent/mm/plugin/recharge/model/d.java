package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.protocal.c.adf;
import com.tencent.mm.protocal.c.adg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;
import org.json.JSONObject;

public final class d extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;
    public String ikY;
    public String pBK;
    public String pBL = null;
    public int pBR;
    public MallRechargeProduct pBU = null;
    public List<MallRechargeProduct> pBV = null;
    public String pBW;

    public d(int i, String str, String str2, String str3, String str4, String str5) {
        this.pBK = str;
        this.pBR = i;
        this.ikY = str5;
        this.pBW = str2;
        a aVar = new a();
        aVar.hmj = new adf();
        aVar.hmk = new adg();
        aVar.uri = "/cgi-bin/micromsg-bin/getlatestpayproductinfo";
        aVar.hmi = 497;
        aVar.hml = be.CTRL_INDEX;
        aVar.hmm = 1000000229;
        this.gJQ = aVar.JZ();
        adf com_tencent_mm_protocal_c_adf = (adf) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_adf.wgs = str;
        com_tencent_mm_protocal_c_adf.wgt = str3;
        com_tencent_mm_protocal_c_adf.wlD = str2;
        com_tencent_mm_protocal_c_adf.wgu = str4;
        com_tencent_mm_protocal_c_adf.vZK = c.bMe().Na(str);
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("funcId:%s, appId:%s, productId:%s, remark:%s", new Object[]{str, str3, str2, str4}));
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", "errCode " + i3 + ", errMsg " + str);
        adg com_tencent_mm_protocal_c_adg = (adg) ((b) qVar).hmh.hmo;
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.OurterRemark " + com_tencent_mm_protocal_c_adg.wgx);
        String str2 = com_tencent_mm_protocal_c_adg.wgx;
        this.pBL = "";
        if (!bh.ov(str2)) {
            String[] split = str2.split("&");
            if (split != null && split.length > 0) {
                Object obj = 1;
                for (String split2 : split) {
                    String[] split3 = split2.split("=");
                    if (split3.length == 2) {
                        if (obj == null) {
                            this.pBL += " ";
                        } else {
                            obj = null;
                        }
                        this.pBL += split3[1];
                    }
                }
            }
        }
        if (!bh.ov(com_tencent_mm_protocal_c_adg.wlF)) {
            try {
                this.pBV = b.a(this.pBK, new JSONObject(com_tencent_mm_protocal_c_adg.wlF).optJSONArray("product_info"));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e, "", new Object[0]);
            }
        }
        if (i2 == 0 && i3 == 0) {
            str2 = com_tencent_mm_protocal_c_adg.wlE;
            x.d("MicroMsg.NetSceneGetLatestPayProductInfo", "resp.Product " + str2);
            if (!bh.ov(str2)) {
                try {
                    this.pBU = b.d(this.pBK, new JSONObject(str2));
                    this.pBU.pBL = this.pBL;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetLatestPayProductInfo", e2, "", new Object[0]);
                }
            }
        }
        x.d("MicroMsg.NetSceneGetLatestPayProductInfo", String.format("OutErrCode : %d ,OutErrMsg : %s , WxErrCode : %d , WxErrMsg : %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_adg.wgv), com_tencent_mm_protocal_c_adg.wgw, Integer.valueOf(com_tencent_mm_protocal_c_adg.wgy), com_tencent_mm_protocal_c_adg.wgz}));
        if (i3 == 0) {
            if (com_tencent_mm_protocal_c_adg.wgy != 0) {
                i3 = com_tencent_mm_protocal_c_adg.wgy;
            } else {
                i3 = com_tencent_mm_protocal_c_adg.wgv;
            }
        }
        if (bh.ov(str)) {
            if (bh.ov(com_tencent_mm_protocal_c_adg.wgz)) {
                str = com_tencent_mm_protocal_c_adg.wgw;
            } else {
                str = com_tencent_mm_protocal_c_adg.wgz;
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 497;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
