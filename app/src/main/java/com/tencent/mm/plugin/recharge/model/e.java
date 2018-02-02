package com.tencent.mm.plugin.recharge.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.protocal.c.aeg;
import com.tencent.mm.protocal.c.aeh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONObject;

public final class e extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    public String pBK;
    public ArrayList<MallRechargeProduct> pBX = null;
    public String pBY;
    public String pBZ;
    public String pCa;
    public String pCb;

    public e(String str) {
        a aVar = new a();
        aVar.hmj = new aeg();
        aVar.hmk = new aeh();
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionproductlist";
        aVar.hmi = 496;
        aVar.hml = JsApiOpenWeRunSetting.CTRL_INDEX;
        aVar.hmm = 1000000228;
        this.gJQ = aVar.JZ();
        aeg com_tencent_mm_protocal_c_aeg = (aeg) this.gJQ.hmg.hmo;
        this.pBK = str;
        com_tencent_mm_protocal_c_aeg.wgs = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetPayFunctionProductList", "errType " + i2 + ", errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            aeh com_tencent_mm_protocal_c_aeh = (aeh) ((b) qVar).hmh.hmo;
            String str2 = com_tencent_mm_protocal_c_aeh.wlF;
            x.d("MicroMsg.NetSceneGetPayFunctionProductList", "resp.ProductList " + str2);
            if (!bh.ov(str2)) {
                try {
                    this.pBX = b.a(this.pBK, new JSONObject(str2).getJSONArray("pay_product_list"));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e, "", new Object[0]);
                }
            }
            if (!bh.ov(com_tencent_mm_protocal_c_aeh.wmE)) {
                try {
                    JSONObject jSONObject = new JSONObject(com_tencent_mm_protocal_c_aeh.wmE);
                    this.pBY = jSONObject.optString("balance_link");
                    this.pCa = jSONObject.optString("recharge_link");
                    this.pBZ = jSONObject.optString("balance_wording");
                    this.pCb = jSONObject.optString("recharge_wording");
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.NetSceneGetPayFunctionProductList", e2, "", new Object[0]);
                }
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 496;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
