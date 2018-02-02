package com.tencent.mm.ag;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.List;
import org.json.JSONObject;

public class d$b$c {
    public int hpd;
    public List<j> hpe = null;
    public int type;

    public static d$b$c jF(String str) {
        x.i("MicroMsg.BizInfo", "MenuInfo = " + str);
        d$b$c com_tencent_mm_ag_d_b_c = new d$b$c();
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                com_tencent_mm_ag_d_b_c.hpd = jSONObject.optInt("update_time");
                com_tencent_mm_ag_d_b_c.type = jSONObject.optInt(DownloadSettingTable$Columns.TYPE, 0);
                com_tencent_mm_ag_d_b_c.hpe = j.c(jSONObject.optJSONArray("button_list"));
            } catch (Throwable e) {
                x.e("MicroMsg.BizInfo", "exception:%s", new Object[]{bh.i(e)});
            }
        }
        return com_tencent_mm_ag_d_b_c;
    }
}
