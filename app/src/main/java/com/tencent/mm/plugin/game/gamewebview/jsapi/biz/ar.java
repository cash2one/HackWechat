package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.d.26;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class ar extends a {
    public static final int CTRL_BYTE = 218;
    public static final String NAME = "setBounceBackground";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiSetBounceBackground", "invoke");
        if (jSONObject == null || bh.ov(jSONObject.optString("backgroundColor"))) {
            dVar.E(i, a.e("setBounceBackground:fail_invalid_data", null));
            return;
        }
        dVar.runOnUiThread(new 26(dVar, jSONObject.optString("backgroundColor")));
        dVar.E(i, a.e("setBounceBackground:ok", null));
    }
}
