package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r extends i {
    private int asN;
    public boolean hik = false;
    public long liA;
    public int liB;
    public int liC;
    public List<a> lje = new ArrayList();
    public int type;

    public r(int i, long j, String str, int i2) {
        this.asN = i2;
        Map hashMap = new HashMap();
        hashMap.put(DownloadSettingTable$Columns.TYPE, String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("last_bill_id", str);
        hashMap.put("num", String.valueOf(i2));
        D(hashMap);
    }

    public final int ayQ() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvdlist";
    }

    public final int Hr() {
        return 1963;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.liB = jSONObject.optInt("total_num");
        this.liC = jSONObject.optInt("total_amt");
        this.liA = jSONObject.optLong("from_timestamp", 0);
        this.type = jSONObject.optInt(DownloadSettingTable$Columns.TYPE, 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.i("MicroMsg.NetSceneTenpayF2fRecordList", "empty records");
        } else {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    a aVar = new a();
                    aVar.lid = jSONObject2.optString("bill_id");
                    aVar.lie = jSONObject2.optString("trans_id");
                    aVar.timestamp = jSONObject2.optLong("timestamp", 0);
                    aVar.desc = jSONObject2.optString("desc");
                    aVar.fpO = jSONObject2.optInt("fee", 0);
                    this.lje.add(aVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneTenpayF2fRecordList", e, "", new Object[0]);
                }
            }
        }
        if (this.lje.size() < this.asN) {
            x.i("MicroMsg.NetSceneTenpayF2fRecordList", "finish query");
            this.hik = true;
        }
    }
}
