package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.d.21;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class bc extends a {
    public static final int CTRL_BYTE = 238;
    public static final String NAME = "showSmileyPanel";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        int i2 = 0;
        x.i("MicroMsg.GameJsApiShowSmileyPanel", "invoke");
        if (dVar.mYO != null) {
            i2 = Thread.currentThread().getId() == dVar.mHandler.getLooper().getThread().getId() ? dVar.mYO.bUU() : ((Integer) new 21(dVar, Integer.valueOf(0)).b(dVar.mHandler)).intValue();
        }
        if (i2 > 0) {
            Map hashMap = new HashMap();
            hashMap.put("height", Integer.valueOf(com.tencent.mm.bv.a.ad(dVar.getContext(), i2)));
            dVar.E(i, e("showSmileyPanel:ok", hashMap));
            return;
        }
        dVar.E(i, a.e("showSmileyPanel:fail", null));
    }
}
