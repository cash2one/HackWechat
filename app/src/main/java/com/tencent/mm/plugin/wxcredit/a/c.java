package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class c extends i {
    public double tYZ = 0.0d;

    public c(List<l> list, String str) {
        Map hashMap = new HashMap();
        hashMap.put("session_key", str);
        int i = 0;
        for (l lVar : list) {
            int i2;
            hashMap.put("qt_id_" + i, lVar.id);
            hashMap.put("ans_cont_" + i, lVar.ocF);
            hashMap.put("level_" + i, lVar.level);
            hashMap.put("parent_id_" + i, lVar.tZv);
            i++;
            if (lVar.tZx == null || !"Y".equals(lVar.ocF)) {
                i2 = i;
            } else {
                hashMap.put("qt_id_" + i, lVar.tZx.id);
                hashMap.put("ans_cont_" + i, lVar.tZx.ocF);
                hashMap.put("level_" + i, lVar.tZx.level);
                hashMap.put("parent_id_" + i, lVar.tZx.tZv);
                i2 = i + 1;
            }
            i = i2;
        }
        hashMap.put("total_num", String.valueOf(i));
        D(hashMap);
    }

    public final int ayQ() {
        return 60;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i + " errMsg: " + str);
        if (i == 0) {
            try {
                this.tYZ = ((double) jSONObject.getInt("credit_amount")) / 100.0d;
            } catch (Throwable e) {
                x.printErrStackTrace("Micromsg.NetSceneTenpayCheckPwd", e, "", new Object[0]);
            }
        }
    }
}
