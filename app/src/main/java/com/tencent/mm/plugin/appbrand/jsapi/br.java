package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Vibrator;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class br extends a {
    public static final int CTRL_INDEX = 231;
    public static final String NAME = "vibrateLong";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
        Vibrator vibrator = (Vibrator) jVar.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(400);
        }
        jVar.E(i, e("ok", null));
    }
}
