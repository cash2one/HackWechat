package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class y extends aa {
    public String odd;
    public g odn;
    public List<String> odo;
    public String odp;
    public String odq = null;

    public y(int i, int i2, int i3, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("limit", String.valueOf(i));
        hashMap.put("offset", String.valueOf(i2));
        hashMap.put(DownloadSettingTable$Columns.TYPE, String.valueOf(i3));
        hashMap.put("year", str);
        hashMap.put("ver", str2);
        hashMap.put("processContent", str3);
        D(hashMap);
    }

    public final int getType() {
        return 1514;
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/qrylistwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        try {
            int i2;
            g gVar = new g();
            gVar.ocl = jSONObject.optInt("recTotalNum");
            gVar.ocm = jSONObject.optLong("recTotalAmount");
            gVar.ocn = jSONObject.optInt("sendTotalNum");
            gVar.oco = jSONObject.optLong("sendTotalAmount");
            gVar.obY = jSONObject.optInt("isContinue");
            gVar.hKN = jSONObject.optInt("gameCount");
            JSONArray optJSONArray = jSONObject.optJSONArray("record");
            LinkedList linkedList = new LinkedList();
            if (optJSONArray != null) {
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    h hVar = new h();
                    hVar.ocp = jSONObject2.optString("sendName");
                    hVar.obP = jSONObject2.optString("sendHeadImg");
                    hVar.ocq = jSONObject2.optLong("receiveAmount");
                    hVar.ocr = jSONObject2.optString("receiveTime");
                    hVar.obK = jSONObject2.optInt("hbType");
                    hVar.ocs = jSONObject2.optString("sendTitle");
                    hVar.oct = jSONObject2.optString("sendTime");
                    hVar.obU = jSONObject2.optLong("totalAmount");
                    hVar.ocu = jSONObject2.optLong("totalNum");
                    hVar.obS = jSONObject2.optLong("recNum");
                    hVar.status = jSONObject2.optInt(DownloadInfo.STATUS);
                    hVar.ocv = jSONObject2.optInt("thxCount");
                    hVar.obV = jSONObject2.optString("receiveId");
                    hVar.nZa = jSONObject2.optString("sendId");
                    hVar.ocg = jSONObject2.optInt("hbKind");
                    linkedList.add(hVar);
                }
            }
            gVar.och = linkedList;
            this.odn = gVar;
            this.odo = new ArrayList();
            String optString = jSONObject.optString("years");
            if (!bh.ov(optString)) {
                String[] split = optString.split("\\|");
                if (split != null) {
                    for (Object add : split) {
                        this.odo.add(add);
                    }
                }
            }
            this.odp = jSONObject.optString("recordYear");
            this.odq = jSONObject.optString("clickedUrl");
            this.odd = jSONObject.optString("processContent");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneLuckyMoneyNormalBase", e, "", new Object[0]);
        }
    }

    public final boolean aXi() {
        if (this.odn == null || this.odn.obY == 1) {
            return true;
        }
        return false;
    }
}
