package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ac extends a {
    public static final int CTRL_INDEX = 232;
    public static final String NAME = "getScreenBrightness";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiGetScreenBrightness", "JsApiGetScreenBrightness!");
        Context a = a(jVar);
        if (a == null) {
            jVar.E(i, e("fail", null));
            x.e("MicroMsg.JsApiGetScreenBrightness", "context is null, invoke fail!");
            return;
        }
        float f = a.getWindow().getAttributes().screenBrightness;
        if (f < 0.0f) {
            f = bT(a);
        }
        Map hashMap = new HashMap();
        hashMap.put(DownloadSettingTable$Columns.VALUE, Float.valueOf(f));
        jVar.E(i, e("ok", hashMap));
    }

    private static float bT(Context context) {
        float f = 0.0f;
        try {
            return ((float) System.getInt(context.getContentResolver(), "screen_brightness")) / 255.0f;
        } catch (SettingNotFoundException e) {
            return f;
        }
    }
}
