package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahb;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public f() {
        a aVar = new a();
        aVar.hmj = new ahb();
        aVar.hmk = new ahc();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/getinfo";
        this.gJQ = aVar.JZ();
        ahb com_tencent_mm_protocal_c_ahb = (ahb) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ahb.cOY = 2;
        LinkedList linkedList = new LinkedList();
        linkedList.add("invoice_info.title");
        linkedList.add("invoice_info.tax_number");
        linkedList.add("invoice_info.bank_number");
        linkedList.add("invoice_info.bank_name");
        linkedList.add("invoice_info.type");
        linkedList.add("invoice_info.email");
        linkedList.add("invoice_info.company_address");
        linkedList.add("invoice_info.company_address_detail");
        linkedList.add("invoice_info.company_address_postcode");
        linkedList.add("invoice_info.phone");
        com_tencent_mm_protocal_c_ahb.wov = linkedList;
        com_tencent_mm_protocal_c_ahb.wou = false;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "return is 0.now we parse the json and resetList..");
            ahc com_tencent_mm_protocal_c_ahc = (ahc) ((b) qVar).hmh.hmo;
            if (com_tencent_mm_protocal_c_ahc.wow != null) {
                try {
                    boolean z = new JSONObject(com_tencent_mm_protocal_c_ahc.wow).getBoolean("has_invoice_info");
                    x.i("MicroMsg.NetSceneGetUserAutoFillInfo", "has_invoice_info is .." + z);
                    ar.Hg();
                    c.CU().a(w.a.USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN, Boolean.valueOf(z));
                } catch (JSONException e) {
                    x.e("MicroMsg.NetSceneGetUserAutoFillInfo", "error parse this json");
                }
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1191;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
