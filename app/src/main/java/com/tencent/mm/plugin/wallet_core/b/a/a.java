package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends i {
    private Map<String, String> oWX = new HashMap();
    public String sEE = null;
    private Map<String, String> sEq = new HashMap();
    public String token = null;

    public a(Authen authen) {
        a(authen.pCn, this.oWX, this.sEq);
        this.oWX.put("flag", authen.fDt);
        this.oWX.put("bank_type", authen.oZz);
        if (!bh.ov(authen.sKs)) {
            this.oWX.put("passwd", authen.sKs);
        }
        if (!bh.ov(authen.token)) {
            this.oWX.put("token", authen.token);
        }
        if (!bh.ov(authen.sBQ)) {
            g.Dk();
            o oVar = new o(bh.a((Integer) g.Dj().CU().get(9, null), 0));
            this.oWX.put("import_code", authen.sBQ);
            this.oWX.put("qqid", oVar.toString());
            if (authen.sKv > 0) {
                this.oWX.put("cre_type", authen.sKv);
            }
            this.oWX.put("bind_serailno", authen.oZA);
        }
        if (!bh.ov(authen.sKB)) {
            this.oWX.put("first_name", authen.sKB);
            this.oWX.put("last_name", authen.sKC);
            this.oWX.put("country", authen.country);
            this.oWX.put("area", authen.fWp);
            this.oWX.put("city", authen.fWq);
            this.oWX.put("address", authen.hxu);
            this.oWX.put("phone_number", authen.nBO);
            this.oWX.put("zip_code", authen.ilY);
            this.oWX.put("email", authen.fWi);
            this.oWX.put(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, w.cfi());
        }
        if (!bh.ov(authen.sKt)) {
            this.oWX.put("true_name", authen.sKt);
        }
        if (!bh.ov(authen.sKu)) {
            this.oWX.put("identify_card", authen.sKu);
        }
        if (authen.sKv > 0) {
            this.oWX.put("cre_type", authen.sKv);
        }
        if (!bh.ov(authen.sIF)) {
            this.oWX.put("mobile_no", authen.sIF);
        }
        this.oWX.put("bank_card_id", authen.sKw);
        if (!bh.ov(authen.sKx)) {
            this.oWX.put("cvv2", authen.sKx);
        }
        if (!bh.ov(authen.sKy)) {
            this.oWX.put("valid_thru", authen.sKy);
        }
        if (com.tencent.mm.wallet_core.c.o.cBs()) {
            this.sEq.put("uuid_for_bindcard", com.tencent.mm.wallet_core.c.o.cBu());
            this.sEq.put("bindcard_scene", com.tencent.mm.wallet_core.c.o.cBt());
        }
        D(this.oWX);
        aB(this.sEq);
    }

    public final boolean bhc() {
        super.bhc();
        this.oWX.put("is_repeat_send", "1");
        D(this.oWX);
        return true;
    }

    public final int ayQ() {
        return 12;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.sEE = jSONObject.optString("req_key");
            this.token = jSONObject.optString("token");
        }
    }

    public final String bhV() {
        return this.token;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/bindauthen";
    }

    public final int Hr() {
        return 471;
    }
}
