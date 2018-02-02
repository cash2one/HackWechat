package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s extends i {
    public String sID;
    public int sIE;
    public String sIF;
    public String sIG;

    public s(String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("token", str);
        hashMap.put("use_touch", new StringBuilder("1").toString());
        D(hashMap);
        hashMap = new HashMap();
        hashMap.put("soter_req", str2);
        aB(hashMap);
    }

    public s(String str, String str2, byte b) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        D(hashMap);
        aB(new HashMap());
    }

    public s(String str, String str2, char c) {
        Map hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("token", str2);
        hashMap.put("resend", "1");
        D(hashMap);
        aB(new HashMap());
    }

    public final int ayQ() {
        return 100;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.d("Micromsg.NetSceneTenpayCheckPwdByToken", "errCode " + i + " errMsg: " + str);
        this.sID = jSONObject.optString("usertoken");
        this.sIE = jSONObject.optInt("is_free_sms");
        this.sIF = jSONObject.optString("mobile_no");
        this.sIG = jSONObject.optString("relation_key");
    }

    public final boolean bKI() {
        return this.sIE == 0;
    }

    public final int Hr() {
        return 1515;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getusertoken";
    }
}
