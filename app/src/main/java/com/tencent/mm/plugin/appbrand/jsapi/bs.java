package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class bs extends a {
    public static final int CTRL_INDEX = 230;
    public static final String NAME = "vibrateShort";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
        bU(jVar.getContext());
        jVar.E(i, e("ok", null));
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort!");
        bU(pVar.mContext);
        pVar.E(i, e("ok", null));
    }

    private static void bU(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(15);
        }
    }
}
