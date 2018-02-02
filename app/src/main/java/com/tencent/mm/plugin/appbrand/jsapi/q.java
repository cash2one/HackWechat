package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.canvas.h;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q extends a {
    public static final int CTRL_INDEX = 372;
    public static final String NAME = "canvasGetImageData";

    public final void a(j jVar, JSONObject jSONObject, int i) {
        super.a(jVar, jSONObject, i);
        try {
            int i2 = jSONObject.getInt("canvasId");
            p b = b(jVar);
            if (b == null) {
                x.w("MicroMsg.JsApiCanvasGetImageData", "invoke JsApi canvasGetImageData failed, current page view is null.");
                jVar.E(i, e("fail:page is null", null));
                return;
            }
            View lo = b.aeF().lo(i2);
            if (lo == null) {
                x.w("MicroMsg.JsApiCanvasGetImageData", "view(%s) is null.", new Object[]{Integer.valueOf(i2)});
                jVar.E(i, e("fail:view is null", null));
            } else if (lo instanceof CoverViewContainer) {
                lo = ((CoverViewContainer) lo).w(View.class);
                if (lo instanceof a) {
                    float alE = f.alE();
                    int optInt = jSONObject.optInt("x");
                    int optInt2 = jSONObject.optInt("y");
                    int optInt3 = jSONObject.optInt("width");
                    int optInt4 = jSONObject.optInt("height");
                    if (optInt3 == 0 || optInt4 == 0) {
                        x.i("MicroMsg.JsApiCanvasGetImageData", "width(%s) or height(%s) is 0.(%s)", new Object[]{Integer.valueOf(optInt3), Integer.valueOf(optInt4), Integer.valueOf(i2)});
                        jVar.E(i, e("fail:width or height is 0", null));
                        return;
                    }
                    int i3;
                    int i4;
                    int i5;
                    int i6;
                    if (optInt3 < 0) {
                        optInt += optInt3;
                        optInt3 = -optInt3;
                        i3 = optInt;
                    } else {
                        i3 = optInt;
                    }
                    if (optInt4 < 0) {
                        i4 = -optInt4;
                        optInt4 = optInt2 + optInt4;
                    } else {
                        i4 = optInt4;
                        optInt4 = optInt2;
                    }
                    int round = Math.round(((float) i3) * alE);
                    int round2 = Math.round(((float) optInt4) * alE);
                    optInt = Math.round(((float) optInt3) * alE);
                    optInt2 = Math.round(((float) i4) * alE);
                    int measuredWidth = lo.getMeasuredWidth();
                    int measuredHeight = lo.getMeasuredHeight();
                    if (round < 0) {
                        i5 = 0;
                    } else if (round >= measuredWidth) {
                        jVar.E(i, a(jVar, "ok", b(new int[(optInt3 * i4)], optInt3, i4)));
                        return;
                    } else {
                        i5 = round;
                    }
                    if (round2 < 0) {
                        i6 = 0;
                    } else if (round2 >= measuredHeight) {
                        jVar.E(i, a(jVar, "ok", b(new int[(optInt3 * i4)], optInt3, i4)));
                        return;
                    } else {
                        i6 = round2;
                    }
                    if (round + optInt > measuredWidth) {
                        optInt = measuredWidth - i5;
                    } else if (round + optInt <= 0) {
                        jVar.E(i, a(jVar, "ok", b(new int[(optInt3 * i4)], optInt3, i4)));
                        return;
                    } else if (round < 0) {
                        optInt += round;
                    }
                    if (round2 + optInt2 > measuredHeight) {
                        optInt2 = measuredHeight - i6;
                    } else if (round2 + optInt2 <= 0) {
                        jVar.E(i, a(jVar, "ok", b(new int[(optInt3 * i4)], optInt3, i4)));
                        return;
                    } else if (round2 < 0) {
                        optInt2 += round2;
                    }
                    measuredWidth = Math.round(((float) i5) / alE);
                    measuredHeight = Math.round(((float) i6) / alE);
                    round2 = Math.round(((float) optInt) / alE);
                    round = Math.round(((float) optInt2) / alE);
                    try {
                        Bitmap createBitmap = Bitmap.createBitmap(optInt, optInt2, Config.ARGB_8888);
                        Canvas hVar = new h(createBitmap);
                        hVar.save();
                        hVar.translate((float) (-i5), (float) (-i6));
                        ((a) lo).d(hVar);
                        hVar.restore();
                        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, round2, round, false);
                        int[] iArr = new int[(optInt3 * i4)];
                        createScaledBitmap.getPixels(iArr, ((measuredHeight - optInt4) * optInt3) + (measuredWidth - i3), optInt3, 0, 0, round2, round);
                        jVar.E(i, a(jVar, "ok", b(iArr, optInt3, i4)));
                        return;
                    } catch (Exception e) {
                        x.w("MicroMsg.JsApiCanvasGetImageData", "create bitmap failed, viewId(%s). Exception : %s", new Object[]{Integer.valueOf(i2), e});
                        jVar.E(i, e("fail:create bitmap failed", null));
                        return;
                    }
                }
                x.i("MicroMsg.JsApiCanvasGetImageData", "the view is not a instance of CanvasView.(%s)", new Object[]{Integer.valueOf(i2)});
                jVar.E(i, e("fail:illegal view type", null));
            } else {
                x.w("MicroMsg.JsApiCanvasGetImageData", "the viewId is not a canvas(%s).", new Object[]{Integer.valueOf(i2)});
                jVar.E(i, e("fail:illegal view type", null));
            }
        } catch (Throwable e2) {
            x.i("MicroMsg.JsApiCanvasGetImageData", "get canvas id failed, %s", new Object[]{Log.getStackTraceString(e2)});
            jVar.E(i, e("fail:illegal canvasId", null));
        }
    }

    private static Map<String, Object> b(int[] iArr, int i, int i2) {
        int i3 = 0;
        byte[] bArr = new byte[(iArr.length * 4)];
        int i4 = 0;
        while (i3 < iArr.length) {
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((iArr[i3] >> 16) & 255);
            i4 = i5 + 1;
            bArr[i5] = (byte) ((iArr[i3] >> 8) & 255);
            i5 = i4 + 1;
            bArr[i4] = (byte) (iArr[i3] & 255);
            i4 = i5 + 1;
            bArr[i5] = (byte) ((iArr[i3] >> 24) & 255);
            i3++;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Map<String, Object> hashMap = new HashMap();
        hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, wrap);
        hashMap.put("width", Integer.valueOf(i));
        hashMap.put("height", Integer.valueOf(i2));
        return hashMap;
    }
}
