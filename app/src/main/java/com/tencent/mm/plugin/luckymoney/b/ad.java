package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ad extends aa {
    public a fHg;
    public int liB;
    public String nZa;
    public String ods;
    public String odt;
    public String odu;
    public String odv;
    public String odw = "";
    public String odx = "";
    public String ody = "";
    public String odz;

    public ad(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3) {
        this.liB = i;
        Map hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i));
        hashMap.put("totalAmount", String.valueOf(j));
        hashMap.put("perValue", String.valueOf(j2));
        hashMap.put("hbType", String.valueOf(i2));
        hashMap.put("wishing", URLEncoder.encode(bh.ou(str)));
        hashMap.put("sendUserName", str5);
        if (!bh.ov(str3)) {
            hashMap.put("username", str3);
        }
        if (!bh.ov(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
            hashMap.put("nickName", URLEncoder.encode(bh.ou(str6)));
            if (!bh.ov(str4)) {
                hashMap.put("receiveNickName", URLEncoder.encode(str4));
            }
        }
        hashMap.put("inWay", String.valueOf(i3));
        if (i3 == 0 || i3 == 1 || i3 == 7) {
            hashMap.put("needSendToMySelf", "0");
        }
        D(hashMap);
    }

    public final int getType() {
        return 1575;
    }

    public final String ayN() {
        return "/cgi-bin/mmpay-bin/requestwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        this.nZa = jSONObject.optString("sendId");
        this.ods = jSONObject.optString("reqkey");
        this.odt = jSONObject.optString("sendMsgXml");
        this.odu = jSONObject.optString("guide_flag", "0");
        this.odv = jSONObject.optString("guide_wording");
        this.odw = jSONObject.optString("left_button_wording", "");
        this.odx = jSONObject.optString("right_button_wording", "");
        this.ody = jSONObject.optString("upload_credit_url", "");
        this.odz = jSONObject.optString("id_sign", "");
        if (jSONObject.has("showmess")) {
            x.i("MicroMsg.NetSceneLuckyMoneyNormalBase", "has alert item");
            this.fHg = K(jSONObject);
        }
    }

    public static a K(JSONObject jSONObject) {
        a aVar = new a();
        aVar.fyY = jSONObject.optString("retmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("showmess");
        aVar.odw = optJSONObject.optString("left_button_wording");
        aVar.odx = optJSONObject.optString("right_button_wording");
        aVar.liO = optJSONObject.optString("right_button_url");
        return aVar;
    }
}
