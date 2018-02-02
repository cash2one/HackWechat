package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.r.1;
import com.tencent.mm.plugin.webview.wepkg.model.g.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class r$1$1 implements a {
    final /* synthetic */ 1 mWL;

    r$1$1(1 1) {
        this.mWL = 1;
    }

    public final void G(JSONObject jSONObject) {
        Map hashMap = new HashMap();
        hashMap.put("wepkg_info", jSONObject);
        this.mWL.mWu.sj(r.e("getLocalWePkgInfo:ok", hashMap));
    }
}
