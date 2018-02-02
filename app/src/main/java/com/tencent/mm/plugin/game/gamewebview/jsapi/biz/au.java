package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.graphics.Color;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public final class au extends a {
    public static final int CTRL_BYTE = 182;
    public static final String NAME = "setNavigationBarColor";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        boolean z;
        x.i("MicroMsg.GameJsApiSetNavigationBarColor", "invoke");
        int i2 = -1;
        try {
            i2 = Color.parseColor(jSONObject.optString("color")) | WebView.NIGHT_MODE_COLOR;
            z = jSONObject.optInt("actionCode") == 1;
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiSetNavigationBarColor", e.getMessage());
            z = true;
        }
        try {
            bh.getFloat(jSONObject.optString("alpha"), 1.0f);
        } catch (Exception e2) {
            x.e("MicroMsg.GameJsApiSetNavigationBarColor", e2.getMessage());
        }
        if (z) {
            dVar.jDW = android.support.v4.content.a.c(dVar.mYx, R.e.bre);
            dVar.jDY = "";
            dVar.aPn();
        } else {
            dVar.mZB = true;
            dVar.jDW = i2;
            dVar.aPn();
        }
        dVar.E(i, a.e("setNavigationBarColor:ok", null));
    }
}
