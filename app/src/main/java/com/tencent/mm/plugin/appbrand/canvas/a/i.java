package com.tencent.mm.plugin.appbrand.canvas.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import com.tencent.mm.plugin.appbrand.canvas.b.a.a;
import com.tencent.mm.plugin.appbrand.canvas.f;
import org.json.JSONArray;

public final class i implements d {
    public final String getMethod() {
        return "strokeText";
    }

    public final boolean a(f fVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 3) {
            return false;
        }
        String optString = jSONArray.optString(0);
        float d = com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 1);
        float d2 = com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 2);
        float d3 = com.tencent.mm.plugin.appbrand.p.f.d(jSONArray, 3);
        FontMetrics fontMetrics = fVar.iKO.getFontMetrics();
        if (fVar.iKO.iLb == a.iLg) {
            d2 += Math.abs(fontMetrics.ascent);
        } else if (fVar.iKO.iLb == a.iLi) {
            d2 += Math.abs((((-fontMetrics.ascent) + fontMetrics.descent) / 2.0f) - fontMetrics.descent);
        } else if (fVar.iKO.iLb == a.iLh) {
            d2 -= Math.abs(fontMetrics.descent);
        }
        Paint paint = fVar.iKO;
        float measureText = paint.measureText(optString);
        if (d3 <= 0.0f || d3 >= measureText) {
            canvas.drawText(optString, d, d2, paint);
        } else {
            canvas.save();
            d3 /= measureText;
            canvas.translate(d, d2);
            canvas.scale(d3, 1.0f);
            canvas.drawText(optString, 0.0f, 0.0f, paint);
            canvas.restore();
        }
        return true;
    }
}
