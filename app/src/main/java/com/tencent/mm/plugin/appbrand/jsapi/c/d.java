package com.tencent.mm.plugin.appbrand.jsapi.c;

import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends l {
    public static final int CTRL_INDEX = 436;
    public static final String NAME = "measureText";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String a(j jVar, JSONObject jSONObject) {
        String string;
        int i = -1;
        if (jSONObject == null) {
            x.e("MicroMsg.JsApiMeasureText", "measureText, data is null");
            return e("fail:data is null", null);
        }
        Object optString = jSONObject.optString("text");
        float optDouble = (float) jSONObject.optDouble("fontSize", 16.0d);
        x.i("MicroMsg.JsApiMeasureText", "measureText data:%s", new Object[]{jSONObject.toString()});
        if (TextUtils.isEmpty(optString) || optDouble <= 0.0f) {
            x.e("MicroMsg.JsApiMeasureText", "measureText, param is illegal");
            return e("fail:param is illegal", null);
        }
        a aVar = new a();
        aVar.setTextSize(f.ac(optDouble));
        try {
            aVar.qg(jSONObject.getString("fontFamily"));
        } catch (JSONException e) {
            x.i("MicroMsg.JsApiMeasureText", "get 'fontFamily' error");
        }
        try {
            string = jSONObject.getString("fontStyle");
            int i2;
            switch (string.hashCode()) {
                case -1657669071:
                    if (string.equals("oblique")) {
                        i2 = 0;
                        break;
                    }
                case -1178781136:
                    if (string.equals("italic")) {
                        i2 = 1;
                        break;
                    }
                case -1039745817:
                    if (string.equals("normal")) {
                        i2 = 2;
                        break;
                    }
            }
        } catch (JSONException e2) {
            x.i("MicroMsg.JsApiMeasureText", "get 'fontStyle' error.");
        }
        try {
            string = jSONObject.getString("fontWeight");
            switch (string.hashCode()) {
                case -1039745817:
                    if (string.equals("normal")) {
                        i = 1;
                    }
                case 3029637:
                    if (string.equals("bold")) {
                        i = 0;
                    }
            }
            switch (i) {
                case 0:
                    aVar.setFakeBoldText(true);
                    break;
                case 1:
                    aVar.setFakeBoldText(false);
                    break;
            }
        } catch (JSONException e3) {
            x.i("MicroMsg.JsApiMeasureText", "get 'fontWeight' error.");
        }
        float measureText = aVar.measureText(optString);
        FontMetrics fontMetrics = aVar.getFontMetrics();
        x.i("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", new Object[]{Float.valueOf(fontMetrics.bottom), Float.valueOf(fontMetrics.top), Float.valueOf(measureText), Float.valueOf(Math.abs(fontMetrics.bottom - fontMetrics.top))});
        measureText = f.ab(measureText);
        optDouble = f.ab(r5);
        Map hashMap = new HashMap();
        hashMap.put("width", Float.valueOf(measureText));
        hashMap.put("height", Float.valueOf(optDouble));
        x.i("MicroMsg.JsApiMeasureText", "map:%s", new Object[]{hashMap.toString()});
        return e("ok", hashMap);
        float measureText2 = aVar.measureText(optString);
        FontMetrics fontMetrics2 = aVar.getFontMetrics();
        x.i("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", new Object[]{Float.valueOf(fontMetrics2.bottom), Float.valueOf(fontMetrics2.top), Float.valueOf(measureText2), Float.valueOf(Math.abs(fontMetrics2.bottom - fontMetrics2.top))});
        measureText2 = f.ab(measureText2);
        optDouble = f.ab(r5);
        Map hashMap2 = new HashMap();
        hashMap2.put("width", Float.valueOf(measureText2));
        hashMap2.put("height", Float.valueOf(optDouble));
        x.i("MicroMsg.JsApiMeasureText", "map:%s", new Object[]{hashMap2.toString()});
        return e("ok", hashMap2);
    }
}
