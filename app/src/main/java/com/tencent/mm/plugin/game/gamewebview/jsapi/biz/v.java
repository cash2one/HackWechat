package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.game.gamewebview.ui.e;
import com.tencent.mm.plugin.game.gamewebview.ui.i;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class v extends a {
    public static final int CTRL_BYTE = 14;
    public static final String NAME = "hideOptionMenu";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiHideOptionMenu", "invoke");
        e eVar = dVar.mYI;
        if (eVar == null) {
            x.e("MicroMsg.GameJsApiHideOptionMenu", "actionBar is null");
            return;
        }
        if (eVar.mZR != null) {
            i iVar = eVar.mZR;
            iVar.nae.clear();
            iVar.nae.addAll(iVar.naf.values());
            iVar.nae.removeAll(iVar.nag);
        }
        dVar.E(i, a.e("hideOptionMenu:ok", null));
    }
}
