package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.p.c;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.l;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r extends a {
    public static final int CTRL_INDEX = 373;
    public static final String NAME = "canvasPutImageData";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        try {
            int i2 = jSONObject.getInt("canvasId");
            p b = b(jVar);
            if (b == null) {
                x.w("MicroMsg.JsApiCanvasPutImageData", "invoke JsApi canvasGetImageData failed, current page view is null.");
                jVar.E(i, e("fail:page is null", null));
                return;
            }
            View lo = b.aeF().lo(i2);
            if (lo == null) {
                x.w("MicroMsg.JsApiCanvasPutImageData", "view(%s) is null.", new Object[]{Integer.valueOf(i2)});
                jVar.E(i, e("fail:view is null", null));
            } else if (lo instanceof CoverViewContainer) {
                View w = ((CoverViewContainer) lo).w(View.class);
                if (w instanceof a) {
                    float alE = f.alE();
                    int optInt = jSONObject.optInt("x");
                    int optInt2 = jSONObject.optInt("y");
                    int optInt3 = jSONObject.optInt("width");
                    int optInt4 = jSONObject.optInt("height");
                    Math.round(((float) optInt) * alE);
                    Math.round(((float) optInt2) * alE);
                    Math.round(((float) optInt3) * alE);
                    Math.round(alE * ((float) optInt4));
                    if (optInt3 == 0 || optInt4 == 0) {
                        x.i("MicroMsg.JsApiCanvasPutImageData", "width(%s) or height(%s) is 0.(%s)", new Object[]{Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i2)});
                        jVar.E(i, e("fail:width or height is 0", null));
                        return;
                    }
                    if (optInt3 < 0) {
                        i2 = optInt + optInt3;
                        optInt = -optInt3;
                    } else {
                        i2 = optInt;
                        optInt = optInt3;
                    }
                    if (optInt4 < 0) {
                        optInt3 = optInt2 + optInt4;
                        optInt2 = -optInt4;
                    } else {
                        optInt3 = optInt2;
                        optInt2 = optInt4;
                    }
                    l.a(jVar, jSONObject, this);
                    try {
                        Object obj = jSONObject.get(SlookAirButtonFrequentContactAdapter.DATA);
                        if (obj instanceof ByteBuffer) {
                            ByteBuffer byteBuffer = (ByteBuffer) obj;
                            JSONArray jSONArray = new JSONArray();
                            int[] g = g(byteBuffer);
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(i2);
                                jSONArray2.put(optInt3);
                                jSONArray2.put(optInt);
                                jSONArray2.put(optInt2);
                                jSONArray2.put(Bitmap.createBitmap(g, optInt, optInt2, Config.ARGB_8888));
                                jSONObject2.put("method", "__setPixels");
                                jSONObject2.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray2);
                                jSONArray.put(jSONObject2);
                                a aVar = (a) w;
                                aVar.b(jSONArray, new 1(this, jVar, i));
                                aVar.abh();
                                return;
                            } catch (JSONException e) {
                                x.w("MicroMsg.JsApiCanvasPutImageData", "put json value error : %s", new Object[]{e});
                                jVar.E(i, e("fail:build action JSON error", null));
                                return;
                            }
                        }
                        x.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, value is not a ByteBuffer");
                        jVar.E(i, e("fail:illegal data", null));
                        return;
                    } catch (Throwable e2) {
                        x.i("MicroMsg.JsApiCanvasPutImageData", "get data failed, %s", new Object[]{Log.getStackTraceString(e2)});
                        jVar.E(i, e("fail:missing data", null));
                        return;
                    }
                }
                x.i("MicroMsg.JsApiCanvasPutImageData", "the view is not a instance of CanvasView.(%s)", new Object[]{Integer.valueOf(i2)});
                jVar.E(i, e("fail:illegal view type", null));
            } else {
                x.w("MicroMsg.JsApiCanvasPutImageData", "the viewId is not a canvas(%s).", new Object[]{Integer.valueOf(i2)});
                jVar.E(i, e("fail:illegal view type", null));
            }
        } catch (Throwable e22) {
            x.i("MicroMsg.JsApiCanvasPutImageData", "get canvas id failed, %s", new Object[]{Log.getStackTraceString(e22)});
            jVar.E(i, e("fail:illegal canvasId", null));
        }
    }

    private static int[] g(ByteBuffer byteBuffer) {
        int i = 0;
        byte[] j = c.j(byteBuffer);
        int[] iArr = new int[(j.length / 4)];
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            i2 = ((j[i2] & 255) << 16) | ((j[i3] & 255) << 8);
            i3 = i4 + 1;
            i4 = (j[i4] & 255) | i2;
            i2 = i3 + 1;
            iArr[i] = ((j[i3] & 255) << 24) | i4;
            i++;
        }
        return iArr;
    }
}
