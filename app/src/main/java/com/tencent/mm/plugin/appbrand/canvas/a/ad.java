package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.canvas.h;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;

public final class ad implements d {
    public final String getMethod() {
        return "__setPixels";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        int a = com.tencent.mm.plugin.appbrand.p.f.a(jSONArray, 0);
        int a2 = com.tencent.mm.plugin.appbrand.p.f.a(jSONArray, 1);
        int a3 = com.tencent.mm.plugin.appbrand.p.f.a(jSONArray, 2);
        int a4 = com.tencent.mm.plugin.appbrand.p.f.a(jSONArray, 3);
        if (canvas.isHardwareAccelerated()) {
            if (canvas instanceof h) {
                ((h) canvas).c((float) a, (float) a2, (float) (a + a3), (float) (a2 + a4));
                x.v("MicroMsg.SetPixelsAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", new Object[]{Integer.valueOf(a), Integer.valueOf(a2), Integer.valueOf(a3), Integer.valueOf(a4)});
            } else if (fVar.iKT != null) {
                canvas.drawRect((float) a, (float) a2, (float) (a + a3), (float) (a2 + a4), fVar.iKT);
                x.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[]{Integer.valueOf(a), Integer.valueOf(a2), Integer.valueOf(a3), Integer.valueOf(a4)});
            } else {
                x.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", new Object[]{Integer.valueOf(a), Integer.valueOf(a2), Integer.valueOf(a3), Integer.valueOf(a4)});
            }
        } else if (fVar.iKT != null) {
            canvas.drawRect((float) a, (float) a2, (float) (a + a3), (float) (a2 + a4), fVar.iKT);
            x.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[]{Integer.valueOf(a), Integer.valueOf(a2), Integer.valueOf(a3), Integer.valueOf(a4)});
        } else {
            canvas.drawRect((float) a, (float) a2, (float) (a + a3), (float) (a2 + a4), fVar.iKS);
            x.v("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", new Object[]{Integer.valueOf(a), Integer.valueOf(a2), Integer.valueOf(a3), Integer.valueOf(a4)});
        }
        try {
            Bitmap bitmap = (Bitmap) jSONArray.get(4);
            if (bitmap == null || bitmap.isRecycled()) {
                return false;
            }
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new RectF((float) a, (float) a2, (float) (a + a3), (float) (a2 + a4)), fVar.iKO);
            return true;
        } catch (Throwable e) {
            x.w("MicroMsg.SetPixelsAction", "get bitmap data error, %s", new Object[]{Log.getStackTraceString(e)});
            return false;
        }
    }
}
