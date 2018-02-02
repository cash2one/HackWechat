package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import org.json.JSONObject;

public final class e extends i {
    public String sJR;
    public String sJS;
    public String sJT;
    public String sJU;
    public int sJV;
    public long sJW;
    public String title;

    public final int ayQ() {
        return 1614;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneRealnameGetDuty", "errCode=" + i + ";errMsg=" + str);
        if (i == 0 && jSONObject != null) {
            this.sJR = jSONObject.optString("agreed_flag", "0");
            this.title = jSONObject.optString("title", "");
            this.sJS = jSONObject.optString("service_protocol_wording", "");
            this.sJT = jSONObject.optString("service_protocol_url", "");
            this.sJU = jSONObject.optString("button_wording", "");
            this.sJW = jSONObject.optLong("delay_expired_time", 0);
            if (this.sJW > 0) {
                g.Dk();
                g.Dj().CU().a(a.xrp, Long.valueOf(System.currentTimeMillis() + (this.sJW * 1000)));
            }
        }
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/realnamegetduty";
    }

    public final int Hr() {
        return 1614;
    }
}
