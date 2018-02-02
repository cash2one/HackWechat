package com.tencent.mm.plugin.wallet_index.b.a;

import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.ArrayList;
import org.json.JSONObject;

public final class c {
    public String hzj;
    public String lyH;
    String mPackageName;
    public String rLk;
    String tac;
    public String tad;
    long tae;
    int taf;
    public String tah;
    public String tai;
    public String taj;
    public String tak;

    public c(String str, String str2, String str3) {
        this.tac = str;
        this.tai = str2;
        JSONObject jSONObject = new JSONObject(this.tai);
        this.tad = jSONObject.optString("orderId");
        this.mPackageName = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        this.lyH = jSONObject.optString("productId");
        this.tae = jSONObject.optLong("purchaseTime");
        this.taf = jSONObject.optInt("purchaseState");
        String optString = jSONObject.optString("developerPayload");
        ArrayList Nw = Nw(optString);
        if (Nw.size() == 3) {
            this.tah = (String) Nw.get(0);
            this.tak = (String) Nw.get(1);
            this.taj = (String) Nw.get(2);
        } else {
            this.tah = optString;
        }
        this.hzj = jSONObject.optString("token", jSONObject.optString("purchaseToken"));
        this.rLk = str3;
    }

    public c(String str, String str2, String str3, String str4) {
        this.lyH = str;
        this.tah = str2;
        this.taj = str3;
        this.tak = str4;
    }

    private static ArrayList<String> Nw(String str) {
        ArrayList<String> arrayList = new ArrayList();
        while (str.indexOf("[#]") >= 0) {
            String substring = str.substring(0, str.indexOf("[#]"));
            str = str.substring(substring.length() + 3);
            arrayList.add(substring);
        }
        arrayList.add(str);
        return arrayList;
    }

    public final String toString() {
        return "PurchaseInfo(type:" + this.tac + "):" + this.tai;
    }
}
