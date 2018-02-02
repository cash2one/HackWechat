package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.d.20;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class az extends a {
    public static final int CTRL_BYTE = 187;
    public static final String NAME = "showKeyboard";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiShowKeyBoard", "invoke");
        String optString = jSONObject.optString("placeholder");
        int optInt = jSONObject.optInt("maxLength");
        dVar.mZg = i;
        if (dVar.mYO != null) {
            dVar.mHandler.post(new 20(dVar, optString, optInt));
        }
    }
}
