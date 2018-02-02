package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class s extends q {
    public int fLD;
    public int fLE;
    public long fLR;
    public int liB;
    public String nZa;
    public String obL;
    public String ocI;
    public String ocJ;
    public int ocK;
    public String ocL;
    public int ocM;
    public String ocN;
    public String ocO;
    public int ocP;
    public e ocQ = null;
    public RealnameGuideHelper ocR;
    public a ocb;

    public s(String str, String str2, int i, String str3, String str4) {
        this.nZa = str;
        Map hashMap = new HashMap();
        hashMap.put("sendId", str);
        if (!bh.ov(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        hashMap.put("way", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, "2");
        hashMap.put("package", str3);
        hashMap.put("sessionUserName", str4);
        D(hashMap);
    }

    public final int ayO() {
        return 1;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.ocI = jSONObject.optString("spidName");
        this.fLD = jSONObject.optInt("hbStatus");
        this.fLE = jSONObject.optInt("receiveStatus");
        this.obL = jSONObject.optString("statusMess");
        this.ocJ = jSONObject.optString("hintMess");
        this.fLR = jSONObject.optLong("amount");
        this.ocK = jSONObject.optInt("recNum");
        this.liB = jSONObject.optInt("totalNum");
        this.ocb = new a();
        JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
        if (optJSONObject != null) {
            this.ocb.gEx = optJSONObject.optInt("enable");
            this.ocb.obw = optJSONObject.optString("fissionContent");
            this.ocb.obv = optJSONObject.optString("fissionUrl");
        }
        this.ocM = jSONObject.optInt("focusFlag");
        this.ocN = jSONObject.optString("focusWording");
        this.ocO = jSONObject.optString("focusAppidUserName");
        this.ocP = jSONObject.optInt("isFocus");
        this.ocL = jSONObject.optString("smallHbButtonMess");
        try {
            this.ocQ = l.H(jSONObject);
            this.ocQ.obP = jSONObject.optString("spidLogo");
            this.ocQ.obO = jSONObject.optString("spidName");
            this.ocQ.obN = jSONObject.optString("spidWishing");
        } catch (JSONException e) {
            x.w("MicroMsg.NetSceneLuckyMoneyBusiBase", "parse luckyMoneyDetail fail: " + e.getLocalizedMessage());
        }
        if (i == 0 && jSONObject.has("real_name_info")) {
            optJSONObject = jSONObject.optJSONObject("real_name_info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("guide_flag");
                String optString2 = optJSONObject.optString("guide_wording");
                String optString3 = optJSONObject.optString("left_button_wording");
                String optString4 = optJSONObject.optString("right_button_wording");
                String optString5 = optJSONObject.optString("upload_credit_url");
                this.ocR = new RealnameGuideHelper();
                this.ocR.a(optString, optString2, optString3, optString4, optString5, 1005);
            }
        }
    }
}
