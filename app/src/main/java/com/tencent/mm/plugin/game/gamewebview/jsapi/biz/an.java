package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class an extends a {
    public static final int CTRL_BYTE = 251;
    public static final String NAME = "recordVideo";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiRecordVideo", "invoke");
        if (jSONObject == null) {
            dVar.E(i, a.e("chooseVideo:fail_invalid_data", null));
        } else {
            j.a(dVar, jSONObject, i, 1);
        }
    }
}
