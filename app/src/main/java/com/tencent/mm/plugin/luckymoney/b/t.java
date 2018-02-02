package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.w.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class t extends q {
    public String fLC;
    public int fLD;
    public int fLE;
    public String nZa;
    public int obK;
    public String obL;
    public String ocI;
    public String ocJ;
    public int ocM;
    public String ocN;
    public String ocO;
    public int ocP;
    public int ocS;
    public String ocT;
    public String ocU;
    public int ocV = 1;
    public String ocW = null;
    public String ocX = null;
    public String ocY = null;
    public String ocZ = null;
    public ah ocd;
    public String oce;
    public String oda = null;
    public long odb = 0;

    public t(String str, String str2, int i, String str3) {
        this.fLC = str2;
        this.nZa = str;
        this.ocS = i;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!bh.ov(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, "2");
        hashMap.put("package", str3);
        g.Dk();
        long longValue = ((Long) g.Dj().CU().get(a.xrp, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            if (System.currentTimeMillis() < longValue) {
                hashMap.put("agreeDuty", "0");
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                g.Dk();
                hashMap.put("agreeDuty", stringBuilder.append((Integer) g.Dj().CU().get(a.xrq, Integer.valueOf(1))).toString());
            }
        }
        D(hashMap);
    }

    public final int ayO() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.ocT = jSONObject.optString("spidLogo");
        this.ocU = jSONObject.optString("spidWishing");
        this.ocI = jSONObject.optString("spidName");
        this.ocT = jSONObject.optString("spidLogo");
        this.fLD = jSONObject.optInt("hbStatus");
        this.fLE = jSONObject.optInt("receiveStatus");
        this.obL = jSONObject.optString("statusMess");
        this.ocJ = jSONObject.optString("hintMess");
        this.oce = jSONObject.optString("watermark");
        this.nZa = jSONObject.optString("sendId");
        this.ocM = jSONObject.optInt("focusFlag");
        this.ocN = jSONObject.optString("focusWording");
        this.ocO = jSONObject.optString("focusAppidUserName");
        this.ocP = jSONObject.optInt("isFocus");
        this.obK = jSONObject.optInt("hbType");
        JSONObject optJSONObject = jSONObject.optJSONObject("agree_duty");
        if (optJSONObject != null) {
            this.ocW = optJSONObject.optString("agreed_flag", "-1");
            this.ocX = optJSONObject.optString("title", "");
            this.ocY = optJSONObject.optString("service_protocol_wording", "");
            this.ocZ = optJSONObject.optString("service_protocol_url", "");
            this.oda = optJSONObject.optString("button_wording", "");
            this.odb = optJSONObject.optLong("delay_expired_time", 0);
        }
        if (this.odb > 0) {
            g.Dk();
            g.Dj().CU().a(a.xrp, Long.valueOf(System.currentTimeMillis() + (this.odb * 1000)));
        }
        this.ocd = l.J(jSONObject.optJSONObject("operationTail"));
    }
}
