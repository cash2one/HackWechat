package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class av extends a {
    public static final int CTRL_BYTE = 113;
    public static final String NAME = "setPageTitle";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiSetPageTitle", "invoke");
        if (jSONObject == null) {
            x.i("MicroMsg.GameJsApiSetPageTitle", "data is null");
            dVar.E(i, "setPageTitle:fail");
            return;
        }
        GameWebViewUI aPh = dVar.aPh();
        dVar.mHandler.post(new d$23(dVar, jSONObject.optString("title"), com.tencent.mm.plugin.webview.ui.tools.d.aK(jSONObject.optString("color"), aPh.getResources().getColor(R.e.brf))));
        dVar.E(i, a.e("setPageTitle:ok", null));
    }
}
