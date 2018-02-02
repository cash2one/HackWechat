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

public final class q extends i {
    private int asN;
    public boolean hik;
    public String jcO;
    public long liA;
    public boolean liZ;
    public int lja;
    public int ljb;
    public int ljc;
    public int ljd;
    public List<h> lje;

    public q(int i, long j, int i2, int i3) {
        this.hik = false;
        this.liZ = false;
        this.lje = new ArrayList();
        this.asN = i2;
        this.ljb = 0;
        Map hashMap = new HashMap();
        hashMap.put(DownloadSettingTable$Columns.TYPE, String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("direction_flag", new StringBuilder("0").toString());
        hashMap.put("num", String.valueOf(i2));
        hashMap.put("choose_flag", String.valueOf(i3));
        D(hashMap);
    }

    public q(int i, long j, int i2, int i3, int i4, int i5) {
        this.hik = false;
        this.liZ = false;
        this.lje = new ArrayList();
        this.liZ = true;
        this.asN = i3;
        this.ljb = i2;
        Map hashMap = new HashMap();
        hashMap.put(DownloadSettingTable$Columns.TYPE, String.valueOf(i));
        hashMap.put("from_timestamp", String.valueOf(j));
        hashMap.put("direction_flag", String.valueOf(i2));
        hashMap.put("num", String.valueOf(i3));
        hashMap.put("choose_flag", String.valueOf(i4));
        hashMap.put("try_num", String.valueOf(i5));
        D(hashMap);
    }

    public final int ayQ() {
        return 0;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/f2frcvrcdhissta";
    }

    public final int Hr() {
        return 1993;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "json: %s", new Object[]{jSONObject.toString()});
        this.lja = jSONObject.optInt("choose_flag", 0);
        this.liA = jSONObject.optLong("from_timestamp", -1);
        this.ljc = jSONObject.optInt("finish_flag", 0);
        this.ljd = jSONObject.optInt("try_num", 0);
        this.jcO = jSONObject.optString("retmsg", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("records");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            x.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "empty records");
        } else {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    h hVar = new h();
                    hVar.type = jSONObject2.optInt(DownloadSettingTable$Columns.TYPE, 0);
                    hVar.liA = jSONObject2.optLong("from_timestamp", 0);
                    hVar.liB = jSONObject2.optInt("total_num", 0);
                    hVar.liC = jSONObject2.optInt("total_amt", 0);
                    this.lje.add(hVar);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NetSceneTenpayF2fHistoryRecordList", e, "", new Object[0]);
                }
            }
        }
        if (this.ljc == 1) {
            x.i("MicroMsg.NetSceneTenpayF2fHistoryRecordList", "finish query");
            this.hik = true;
        }
    }
}
