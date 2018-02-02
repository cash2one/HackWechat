package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.b;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class aw extends a {
    public static final int CTRL_BYTE = 270;
    public static final String NAME = "setScreenOrientation";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        int i2 = 1;
        x.i("MicroMsg.GameJsApiSetScreenOrientation", "invoke");
        if (jSONObject != null) {
            String optString = jSONObject.optString("orientation");
            if (!bh.ov(optString)) {
                if (optString.equals("horizontal")) {
                    i2 = 0;
                } else if (!optString.equals("vertical")) {
                    if (optString.equals("sensor")) {
                        i2 = 4;
                    } else if (optString.equals("horizontal_unforced")) {
                        i2 = 0;
                    } else if (!optString.equals("vertical_unforced")) {
                        i2 = -1;
                    }
                }
                b bVar = dVar.mYH;
                bVar.vf.putInt("screen_orientation", i2);
                if (bVar.mContext instanceof GameWebViewUI) {
                    ((GameWebViewUI) bVar.mContext).qK(i2);
                }
                dVar.E(i, a.e("setScreenOrientation:ok", null));
                return;
            }
        }
        x.e("MicroMsg.GameJsApiSetScreenOrientation", "data is null");
        dVar.E(i, a.e("setScreenOrientation:fail_invalid_data", null));
    }
}
