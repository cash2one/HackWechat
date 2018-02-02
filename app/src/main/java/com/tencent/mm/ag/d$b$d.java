package com.tencent.mm.ag;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class d$b$d {
    public int hpk = 0;
    public String hpl;
    public String hpm;
    public String hpn;
    public String hpo;

    public static d$b$d jH(String str) {
        if (bh.ov(str)) {
            return null;
        }
        x.i("MicroMsg.BizInfo", "biz verify info is [%s]", new Object[]{str});
        d$b$d com_tencent_mm_ag_d_b_d = new d$b$d();
        try {
            JSONObject jSONObject = new JSONObject(str);
            com_tencent_mm_ag_d_b_d.hpk = jSONObject.optInt("Type");
            com_tencent_mm_ag_d_b_d.hpl = jSONObject.optString("Description");
            com_tencent_mm_ag_d_b_d.hpm = jSONObject.optString("Name");
            com_tencent_mm_ag_d_b_d.hpn = jSONObject.optString("IntroUrl");
            com_tencent_mm_ag_d_b_d.hpo = jSONObject.optString("VerifySubTitle");
        } catch (Throwable e) {
            x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bh.i(e)});
        }
        x.i("MicroMsg.BizInfo", "type[%d],desc[%s],name[%s],url[%s]", new Object[]{Integer.valueOf(com_tencent_mm_ag_d_b_d.hpk), com_tencent_mm_ag_d_b_d.hpl, com_tencent_mm_ag_d_b_d.hpm, com_tencent_mm_ag_d_b_d.hpn});
        return com_tencent_mm_ag_d_b_d;
    }
}
