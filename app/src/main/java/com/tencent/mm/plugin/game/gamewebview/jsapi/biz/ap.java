package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class ap extends a {
    public static final int CTRL_BYTE = -2;
    public static final String NAME = "requestData";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiRequestData", "invoke");
        if (Uri.parse(dVar.aPk()).getHost().equals("game.weixin.qq.com")) {
            String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            String optString2 = jSONObject.optString("method");
            JSONObject optJSONObject = jSONObject.optJSONObject(SlookAirButtonFrequentContactAdapter.DATA);
            x.i("MicroMsg.GameJsApiRequestData", "reqUrl = %s, method = %s", new Object[]{optString, optString2});
            if (bh.ov(optString) || bh.ov(optString2)) {
                x.i("MicroMsg.GameJsApiRequestData", "reqUrl or method is null");
                return;
            }
            optString = com.tencent.mm.plugin.game.gamewebview.c.a.b(optString, optString2, optJSONObject);
            if (optString == null) {
                dVar.E(i, a.e("requestData:fail", null));
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(optString);
                Map hashMap = new HashMap();
                hashMap.put("respData", jSONObject2);
                dVar.E(i, e("requestData:ok", hashMap));
                return;
            } catch (JSONException e) {
                x.e("MicroMsg.GameJsApiRequestData", e.getMessage());
                dVar.E(i, a.e("requestData:fail_parse_json_fail", null));
                return;
            }
        }
        x.i("MicroMsg.GameJsApiRequestData", "host is not game");
        dVar.E(i, a.e("requestData:fail", null));
    }
}
