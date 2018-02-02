package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.wallet_core.tenpay.model.i;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends i {
    public long liA;
    public int liB;
    public int liC;
    public String lid;
    public int type;

    public p(String str, int i, long j) {
        this.lid = str;
        Map hashMap = new HashMap();
        hashMap.put("bill_id", str);
        hashMap.put(DownloadSettingTable$Columns.TYPE, String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        D(hashMap);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frmrcvdrcd";
    }

    public final int Hr() {
        return 1964;
    }

    public final int ayQ() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.liB = jSONObject.optInt("total_num", 0);
        this.liC = jSONObject.optInt("total_amt", 0);
        this.type = jSONObject.optInt(DownloadSettingTable$Columns.TYPE, 0);
        this.liA = jSONObject.optLong("from_timestamp", 0);
    }
}
