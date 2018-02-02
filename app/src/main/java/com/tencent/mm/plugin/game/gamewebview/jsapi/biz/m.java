package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class m extends a {
    public static final int CTRL_BYTE = 17;
    public static final String NAME = "closeWindow";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiCloseWindow", "invoke");
        if (dVar == null || dVar.aPh() == null) {
            x.e("MicroMsg.GameJsApiCloseWindow", "page or activity is null");
            return;
        }
        dVar.fz(false);
        dVar.E(i, a.e("close_window:ok", null));
    }
}
