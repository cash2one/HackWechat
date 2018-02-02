package com.tencent.mm.plugin.game.gamewebview.a;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a {
    public static void a(d dVar, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("height", i);
            dVar.cH("onGetKeyboardHeight", jSONObject.toString());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebviewJsLoader", "onGetA8Key, e:" + e.getMessage());
        }
    }
}
