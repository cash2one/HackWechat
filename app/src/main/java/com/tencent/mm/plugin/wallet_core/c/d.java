package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.wallet_core.tenpay.model.i;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends i {
    public d() {
        o.bLu().gJP.fx("WalletBulletin", "delete from WalletBulletin");
        D(new HashMap());
    }

    public final int ayQ() {
        return 1679;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/getbannerinfo";
    }

    public final int Hr() {
        return 1679;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        x.i("MicroMsg.NetSceneGetBannerInfo", "NetSceneGetBannerInfo errCode = " + i + " " + jSONObject);
        if (i == 0) {
            r.aa(jSONObject);
            long optLong = jSONObject.optLong("banner_update_interval", 0);
            x.i("MicroMsg.NetSceneGetBannerInfo", "update_interval=" + optLong);
            g.Dk();
            g.Dj().CU().a(a.xqC, Long.valueOf(optLong));
            JSONObject optJSONObject = jSONObject.optJSONObject("lbs_info");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("config_array");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    com.tencent.mm.plugin.wallet_core.model.i bLd = com.tencent.mm.plugin.wallet_core.model.i.bLd();
                    if (optJSONArray != null) {
                        x.d("MicroMsg.GpsReportHelper", optJSONArray.toString());
                        bLd.sNc = optJSONArray;
                        g.Dk();
                        g.Dj().CU().a(a.xrt, optJSONArray.toString());
                    }
                }
                g.Dk();
                g.Dj().CU().a(a.xru, optJSONObject.optString("title"));
                g.Dk();
                g.Dj().CU().a(a.xrv, optJSONObject.optString("content"));
            }
            optJSONObject = jSONObject.optJSONObject("realname_info");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("title");
                String optString2 = optJSONObject.optString("balance_title");
                g.Dk();
                g.Dj().CU().a(a.xrw, optString);
                g.Dk();
                g.Dj().CU().a(a.xrx, optString2);
            }
        }
    }
}
