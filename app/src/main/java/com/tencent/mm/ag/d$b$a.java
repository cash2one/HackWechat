package com.tencent.mm.ag;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class d$b$a {
    public ArrayList<String> hoZ;

    public static d$b$a jD(String str) {
        if (bh.ov(str)) {
            return null;
        }
        d$b$a com_tencent_mm_ag_d_b_a = new d$b$a();
        x.d("MicroMsg.BizInfo", "BizAcctTransferInfo is [%s]", new Object[]{str});
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("origin_name_list");
            if (optJSONArray == null) {
                return com_tencent_mm_ag_d_b_a;
            }
            com_tencent_mm_ag_d_b_a.hoZ = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                com_tencent_mm_ag_d_b_a.hoZ.add(optJSONArray.optString(i));
            }
            return com_tencent_mm_ag_d_b_a;
        } catch (Throwable e) {
            x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bh.i(e)});
            return com_tencent_mm_ag_d_b_a;
        }
    }
}
