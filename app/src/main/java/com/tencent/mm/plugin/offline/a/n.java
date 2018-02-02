package com.tencent.mm.plugin.offline.a;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class n extends i {
    public static String oWA = "";
    public static String oWT = "";
    private int liH = -1;
    private String liI = "";
    public String oWU = "";
    public String oWV = "";
    public String oWW = "";
    final Map<String, String> oWX = new HashMap();
    public int oWq = -1;
    public String oWr = "";

    public n(String str, int i) {
        this.oWX.put("device_id", q.yF());
        this.oWX.put("timestamp", str);
        this.oWX.put("scene", String.valueOf(i));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(q.yF());
        stringBuilder.append("&");
        stringBuilder.append(str);
        this.oWX.put("sign", ab.UZ(stringBuilder.toString()));
        StringBuilder stringBuilder2 = new StringBuilder();
        g.Dk();
        this.oWX.put("code_ver", stringBuilder2.append(g.Dj().CU().get(a.xmP, "")).toString());
        D(this.oWX);
    }

    public final int ayQ() {
        return 49;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            oWA = jSONObject.optString("limit_fee");
            oWT = jSONObject.optString("is_show_order_detail");
            String optString = jSONObject.optString("pay_amount");
            String optString2 = jSONObject.optString("pay_number");
            String optString3 = jSONObject.optString("card_logos");
            k.bgX();
            k.au(196629, oWA);
            k.bgX();
            k.au(196641, oWT);
            k.bgX();
            k.au(196645, optString);
            k.bgX();
            k.au(196646, optString2);
            com.tencent.mm.plugin.offline.c.a.GY(optString3);
            this.liH = jSONObject.optInt("retcode");
            this.liI = jSONObject.optString("retmsg");
            this.oWq = jSONObject.optInt("wx_error_type");
            this.oWr = jSONObject.optString("wx_error_msg");
            this.oWU = jSONObject.optString("get_code_flag");
            this.oWV = jSONObject.optString("micropay_pause_flag");
            this.oWW = jSONObject.optString("micropay_pause_word");
        }
    }

    public final int Hr() {
        return 568;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinequeryuser";
    }
}
