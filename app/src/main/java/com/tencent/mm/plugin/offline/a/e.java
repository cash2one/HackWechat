package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.protocal.c.atv;
import com.tencent.mm.protocal.c.atw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;
import org.json.JSONObject;

public final class e extends l {
    private final b gJQ;
    private com.tencent.mm.ae.e gJT;
    public int liH = -1;
    private String liI = "";
    public String oWp = "";
    public int oWq = -1;
    public String oWr = "";
    public int oWs = 1;
    public RealnameGuideHelper oWt;
    private String oWu;
    private String oWv;
    private String oWw;
    private String oWx;
    private String oWy;

    public e(int i, String str, String str2) {
        a aVar = new a();
        aVar.hmj = new atv();
        aVar.hmk = new atw();
        aVar.uri = "/cgi-bin/mmpay-bin/offlinepayconfirm";
        aVar.hmi = 609;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        atv com_tencent_mm_protocal_c_atv = (atv) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_atv.wBR = i;
        com_tencent_mm_protocal_c_atv.nGJ = str;
        com_tencent_mm_protocal_c_atv.sPj = str2;
        com_tencent_mm_protocal_c_atv.vQS = i.bLf();
        this.oWs = i;
    }

    public final int getType() {
        return 609;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        if (i != 0) {
            x.e("MicroMsg.NetSceneOfflinePayConfirm", "Cmd : 609" + ", errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        atw com_tencent_mm_protocal_c_atw = (atw) ((b) qVar).hmh.hmo;
        if (i == 0 && i2 == 0) {
            try {
                if (com_tencent_mm_protocal_c_atw.wmn != null) {
                    JSONObject jSONObject = new JSONObject(com_tencent_mm_protocal_c_atw.wmn);
                    this.oWp = jSONObject.optString("transaction_id");
                    this.liH = jSONObject.optInt("retcode");
                    this.liI = jSONObject.optString("retmsg");
                    this.oWq = jSONObject.optInt("wx_error_type");
                    this.oWr = jSONObject.optString("wx_error_msg");
                    x.d("MicroMsg.NetSceneOfflinePayConfirm", "onGYNetEnd %s", new Object[]{jSONObject.toString()});
                    if (jSONObject.has("real_name_info")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                        this.oWu = optJSONObject.optString("guide_flag");
                        this.oWv = optJSONObject.optString("guide_wording");
                        this.oWw = optJSONObject.optString("left_button_wording");
                        this.oWx = optJSONObject.optString("right_button_wording");
                        this.oWy = optJSONObject.optString("upload_credit_url");
                        if ("1".equals(this.oWu) || "2".equals(this.oWu)) {
                            this.oWt = new RealnameGuideHelper();
                            this.oWt.a(this.oWu, this.oWv, this.oWw, this.oWx, this.oWy, 0);
                        }
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneOfflinePayConfirm", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = ac.getContext().getString(a$i.uRf);
            }
        }
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }
}
