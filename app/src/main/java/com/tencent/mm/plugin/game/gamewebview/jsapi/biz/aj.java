package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class aj extends a {
    public static final int CTRL_BYTE = -2;
    public static final String NAME = "preRequestData";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiPreRequestData", "invoke");
        if (Uri.parse(dVar.aPk()).getHost().equals("game.weixin.qq.com")) {
            String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            String optString2 = jSONObject.optString("method");
            JSONObject optJSONObject = jSONObject.optJSONObject(SlookAirButtonFrequentContactAdapter.DATA);
            x.i("MicroMsg.GameJsApiPreRequestData", "reqUrl = %s, method = %s", new Object[]{optString, optString2});
            if (bh.ov(optString) || bh.ov(optString2)) {
                x.i("MicroMsg.GameJsApiPreRequestData", "reqUrl or method is null");
                dVar.E(i, a.e("preRequestData:fail", null));
                return;
            }
            com.tencent.mm.plugin.game.gamewebview.c.a.c(optString, optString2, optJSONObject);
            dVar.E(i, a.e("preRequestData:ok", null));
            return;
        }
        x.i("MicroMsg.GameJsApiPreRequestData", "host is not game");
        dVar.E(i, a.e("preRequestData:fail", null));
    }
}
