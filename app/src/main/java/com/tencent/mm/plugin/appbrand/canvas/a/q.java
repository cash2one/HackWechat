package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.tencent.mm.plugin.appbrand.canvas.b.a;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;

public final class q implements d {
    public final String getMethod() {
        return "setFillStyle";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        String optString = jSONArray.optString(0);
        a aVar = fVar.iKP;
        JSONArray optJSONArray;
        float d;
        float d2;
        float d3;
        JSONArray optJSONArray2;
        int i;
        if ("linear".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                return false;
            }
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 4) {
                return false;
            }
            d = com.tencent.mm.plugin.appbrand.p.f.d(optJSONArray, 0);
            d2 = com.tencent.mm.plugin.appbrand.p.f.d(optJSONArray, 1);
            d3 = com.tencent.mm.plugin.appbrand.p.f.d(optJSONArray, 2);
            float d4 = com.tencent.mm.plugin.appbrand.p.f.d(optJSONArray, 3);
            optJSONArray2 = jSONArray.optJSONArray(2);
            if (optJSONArray2 == null || optJSONArray2.length() == 0) {
                return false;
            }
            int[] iArr = new int[optJSONArray2.length()];
            float[] fArr = new float[optJSONArray2.length()];
            for (i = 0; i < optJSONArray2.length(); i++) {
                JSONArray optJSONArray3 = optJSONArray2.optJSONArray(i);
                if (optJSONArray3.length() >= 2) {
                    fArr[i] = (float) optJSONArray3.optDouble(0);
                    iArr[i] = com.tencent.mm.plugin.appbrand.p.f.i(optJSONArray3.optJSONArray(1));
                }
            }
            aVar.setShader(new LinearGradient(d, d2, d3, d4, iArr, fArr, TileMode.CLAMP));
        } else if ("radial".equalsIgnoreCase(optString)) {
            if (jSONArray.length() < 3) {
                return false;
            }
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 3) {
                return false;
            }
            d = com.tencent.mm.plugin.appbrand.p.f.d(optJSONArray, 0);
            d2 = com.tencent.mm.plugin.appbrand.p.f.d(optJSONArray, 1);
            d3 = com.tencent.mm.plugin.appbrand.p.f.d(optJSONArray, 2);
            if (d3 <= 0.0f) {
                x.i("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle(radial) failed, sr(%s) <= 0.", new Object[]{Float.valueOf(d3)});
                return false;
            }
            JSONArray optJSONArray4 = jSONArray.optJSONArray(2);
            int[] iArr2 = new int[optJSONArray4.length()];
            float[] fArr2 = new float[optJSONArray4.length()];
            for (i = 0; i < optJSONArray4.length(); i++) {
                optJSONArray2 = optJSONArray4.optJSONArray(i);
                if (optJSONArray2.length() >= 2) {
                    fArr2[i] = (float) optJSONArray2.optDouble(0);
                    iArr2[i] = com.tencent.mm.plugin.appbrand.p.f.i(optJSONArray2.optJSONArray(1));
                }
            }
            aVar.setShader(new RadialGradient(d, d2, d3, iArr2, fArr2, TileMode.CLAMP));
        } else if ("normal".equalsIgnoreCase(optString)) {
            optJSONArray = jSONArray.optJSONArray(1);
            if (optJSONArray == null || optJSONArray.length() < 4) {
                return false;
            }
            aVar.setShader(null);
            aVar.setColor(com.tencent.mm.plugin.appbrand.p.f.i(optJSONArray));
        } else if ("pattern".equalsIgnoreCase(optString)) {
            optString = jSONArray.optString(1);
            String optString2 = jSONArray.optString(2);
            if (bh.ov(optString)) {
                x.w("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle failed, type is pattern but image path is null or nil.");
                return false;
            }
            Bitmap aQ = fVar.iKU.aQ(fVar.gOP, optString);
            if (!(aQ == null || aQ.isRecycled())) {
                Shader bitmapShader;
                int lI = com.tencent.mm.plugin.appbrand.p.f.lI(aQ.getWidth());
                int lI2 = com.tencent.mm.plugin.appbrand.p.f.lI(aQ.getHeight());
                Object obj = -1;
                switch (optString2.hashCode()) {
                    case -934531685:
                        if (optString2.equals("repeat")) {
                            obj = null;
                            break;
                        }
                        break;
                    case -724648153:
                        if (optString2.equals("no-repeat")) {
                            obj = 3;
                            break;
                        }
                        break;
                    case -436782906:
                        if (optString2.equals("repeat-x")) {
                            obj = 1;
                            break;
                        }
                        break;
                    case -436782905:
                        if (optString2.equals("repeat-y")) {
                            obj = 2;
                            break;
                        }
                        break;
                }
                Bitmap createBitmap;
                switch (obj) {
                    case null:
                        bitmapShader = new BitmapShader(Bitmap.createScaledBitmap(aQ, lI, lI2, false), TileMode.REPEAT, TileMode.REPEAT);
                        break;
                    case 1:
                        createBitmap = Bitmap.createBitmap(lI, lI2 + 1, Config.ARGB_8888);
                        new Canvas(createBitmap).drawBitmap(aQ, new Rect(0, 0, aQ.getWidth(), aQ.getHeight()), new RectF(0.0f, 0.0f, (float) lI, (float) lI2), null);
                        bitmapShader = new BitmapShader(createBitmap, TileMode.REPEAT, TileMode.CLAMP);
                        break;
                    case 2:
                        createBitmap = Bitmap.createBitmap(lI + 1, lI2, Config.ARGB_8888);
                        new Canvas(createBitmap).drawBitmap(aQ, new Rect(0, 0, aQ.getWidth(), aQ.getHeight()), new RectF(0.0f, 0.0f, (float) lI, (float) lI2), null);
                        bitmapShader = new BitmapShader(createBitmap, TileMode.CLAMP, TileMode.REPEAT);
                        break;
                    case 3:
                        createBitmap = Bitmap.createBitmap(lI + 1, lI2 + 1, Config.ARGB_8888);
                        new Canvas(createBitmap).drawBitmap(aQ, new Rect(0, 0, aQ.getWidth(), aQ.getHeight()), new RectF(0.0f, 0.0f, (float) lI, (float) lI2), null);
                        bitmapShader = new BitmapShader(createBitmap, TileMode.CLAMP, TileMode.CLAMP);
                        break;
                    default:
                        bitmapShader = null;
                        break;
                }
                aVar.setShader(bitmapShader);
            }
        }
        return true;
    }
}
