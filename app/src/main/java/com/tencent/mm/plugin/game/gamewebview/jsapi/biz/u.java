package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.e;
import com.tencent.mm.plugin.game.gamewebview.ui.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class u extends a {
    public static final int CTRL_BYTE = 85;
    public static final String NAME = "hideMenuItems";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiHideMenuItems", "invoke");
        GameWebViewUI aPh = dVar.aPh();
        if (aPh == null || aPh.isFinishing()) {
            x.e("MicroMsg.GameJsApiHideMenuItems", "activity is finish");
            return;
        }
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("menuList");
            if (optJSONArray != null) {
                e eVar = dVar.mYI;
                if (!(eVar == null || eVar.mZR == null)) {
                    i iVar = eVar.mZR;
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            int e = bh.e((Integer) iVar.naf.get(optJSONArray.optString(i2)));
                            if (e > 0 && !iVar.nag.contains(Integer.valueOf(e))) {
                                iVar.nae.add(Integer.valueOf(e));
                            }
                        }
                    }
                }
                dVar.E(i, a.e("hideMenuItems:ok", null));
                return;
            }
        }
        x.i("MicroMsg.GameJsApiHideMenuItems", "data is null");
        dVar.E(i, a.e("hideMenuItems:fail_invalid_data", null));
    }
}
