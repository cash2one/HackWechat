package com.tencent.mm.plugin.product.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aeu;
import com.tencent.mm.protocal.c.aev;
import com.tencent.mm.protocal.c.rc;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public String mUrl;
    public LinkedList<rc> pei;

    public i(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new aeu();
        aVar.hmk = new aev();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdiscount";
        this.gJQ = aVar.JZ();
        aeu com_tencent_mm_protocal_c_aeu = (aeu) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_aeu.vQO = str;
        this.mUrl = str2;
        com_tencent_mm_protocal_c_aeu.nfX = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        aev com_tencent_mm_protocal_c_aev = (aev) ((b) qVar).hmh.hmo;
        if (i2 == 0 && i3 == 0 && com_tencent_mm_protocal_c_aev.vQP == 0) {
            x.d("MicroMsg.NetSceneMallGetProductDiscount", "resp.ProductInfo " + com_tencent_mm_protocal_c_aev.wmL);
            try {
                JSONArray optJSONArray = new JSONObject(com_tencent_mm_protocal_c_aev.wmL).optJSONArray("discount_list");
                if (optJSONArray != null) {
                    this.pei = new LinkedList();
                    int length = optJSONArray.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i4);
                        rc rcVar = new rc();
                        rcVar.fon = jSONObject.getString("title");
                        rcVar.vPD = jSONObject.getInt("fee");
                        this.pei.add(rcVar);
                    }
                }
            } catch (Exception e) {
            }
        }
        if (i3 == 0 && com_tencent_mm_protocal_c_aev.vQP != 0) {
            i3 = com_tencent_mm_protocal_c_aev.vQP;
            str = com_tencent_mm_protocal_c_aev.vQQ;
        }
        x.d("MicroMsg.NetSceneMallGetProductDiscount", "errCode " + i3 + ", errMsg " + str);
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 579;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
