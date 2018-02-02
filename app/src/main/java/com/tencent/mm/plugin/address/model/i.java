package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajk;
import com.tencent.mm.protocal.c.bdt;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class i extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public bdu ilV;

    public i(com.tencent.mm.plugin.o.a.b bVar) {
        a aVar = new a();
        aVar.hmj = new bdt();
        aVar.hmk = new bdu();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/saveinfo";
        aVar.hmi = 1180;
        this.gJQ = aVar.JZ();
        bdt com_tencent_mm_protocal_c_bdt = (bdt) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bdt.cOY = 2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("{\"user_uin\":");
        ar.Hg();
        stringBuilder.append(stringBuilder2.append(c.Cg()).append(" ,\"user_data_list\": [").toString());
        if (bVar.type.equals("0")) {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.nBI + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.title + "\"},{\"key\": \"tax_number\",\"value\": \"" + bVar.nBK + "\"},{\"key\": \"bank_number\",\"value\": \"" + bVar.nBL + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.nBO + "\"},{\"key\": \"company_address_detail\",\"value\": \"" + bVar.nBQ + "\"},{\"key\": \"bank_name\",\"value\": \"" + bVar.nBM + "\"}]}}");
        } else {
            stringBuilder.append("{\"group_key\": \"invoice_info\",\"group_info\": {\"group_id\": " + bVar.nBI + ",\"field_list\": [{\"key\": \"type\",\"value\": \"" + bVar.type + "\"},{\"key\": \"title\",\"value\": \"" + bVar.nBJ + "\"},{\"key\": \"phone\",\"value\": \"" + bVar.nBP + "\"},{\"key\": \"email\",\"value\": \"" + bVar.fWi + "\"}]}}");
        }
        stringBuilder.append("]}");
        com_tencent_mm_protocal_c_bdt.wow = stringBuilder.toString();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSaveUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            this.ilV = (bdu) ((b) qVar).hmh.hmo;
            if (!(this.ilV == null || this.ilV.wJJ == null || this.ilV.wJJ.size() <= 0 || this.ilV.wJJ.get(0) == null)) {
                x.i("MicroMsg.NetSceneSaveUserAutoFillInfo", "resp groupId is.." + ((ajk) this.ilV.wJJ.get(0)).vYZ);
            }
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1180;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
