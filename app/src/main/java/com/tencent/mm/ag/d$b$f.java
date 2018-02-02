package com.tencent.mm.ag;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class d$b$f {
    public String description;
    public String hpt;
    public String iconUrl;

    public static List<d$b$f> b(JSONArray jSONArray) {
        List linkedList = new LinkedList();
        if (jSONArray != null) {
            try {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    d$b$f com_tencent_mm_ag_d_b_f = new d$b$f();
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    com_tencent_mm_ag_d_b_f.iconUrl = optJSONObject.optString("icon");
                    com_tencent_mm_ag_d_b_f.description = optJSONObject.optString("description");
                    com_tencent_mm_ag_d_b_f.hpt = optJSONObject.optString("description_key");
                    linkedList.add(com_tencent_mm_ag_d_b_f);
                }
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return linkedList;
    }
}
