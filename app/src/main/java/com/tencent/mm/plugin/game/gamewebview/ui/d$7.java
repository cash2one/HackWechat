package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewInputFooter.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class d$7 implements a {
    final /* synthetic */ d mZC;

    d$7(d dVar) {
        this.mZC = dVar;
    }

    public final boolean uX(String str) {
        d dVar = this.mZC;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("smiley", str);
            dVar.cH("onGetSmiley", jSONObject.toString());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebviewJsLoader", "onGetA8Key, e:" + e.getMessage());
        }
        return true;
    }
}
