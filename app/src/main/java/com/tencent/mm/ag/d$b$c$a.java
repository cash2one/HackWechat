package com.tencent.mm.ag;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public class d$b$c$a {
    public long appid = 0;
    public String hpf;
    public String hpg;
    public int hph;
    public String hpi;
    public String hpj;

    public static d$b$c$a jG(String str) {
        x.i("MicroMsg.BizInfo", "EnterpriseBizInfo = " + str);
        d$b$c$a com_tencent_mm_ag_d_b_c_a = new d$b$c$a();
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                com_tencent_mm_ag_d_b_c_a.hpf = jSONObject.optString("belong");
                com_tencent_mm_ag_d_b_c_a.hpg = jSONObject.optString("freeze_wording");
                com_tencent_mm_ag_d_b_c_a.hph = jSONObject.optInt("child_type");
                com_tencent_mm_ag_d_b_c_a.hpi = jSONObject.optString("home_url");
                String optString = jSONObject.optString("exattr");
                if (bh.ov(optString)) {
                    com_tencent_mm_ag_d_b_c_a.hpj = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    com_tencent_mm_ag_d_b_c_a.hpj = jSONObject2.optString("chat_extension_url");
                    com_tencent_mm_ag_d_b_c_a.appid = jSONObject2.optLong("app_id");
                }
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return com_tencent_mm_ag_d_b_c_a;
    }
}
