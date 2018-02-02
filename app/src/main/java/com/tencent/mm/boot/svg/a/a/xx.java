package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class xx extends c {
    private final int height = 240;
    private final int width = 240;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
                Paint i2 = c.i(looper);
                i2.setFlags(385);
                i2.setStyle(Style.FILL);
                Paint i3 = c.i(looper);
                i3.setFlags(385);
                i3.setStyle(Style.STROKE);
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, d.CTRL_INDEX, 4);
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 83.0f, 0.0f, 1.0f, 91.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(32.8514f, 18.0f);
                j.lineTo(15.0f, 18.0f);
                j.lineTo(15.0f, 30.0f);
                j.lineTo(0.0f, 15.0f);
                j.lineTo(15.0f, 0.0f);
                j.lineTo(15.0f, 12.0f);
                j.lineTo(52.5f, 12.0f);
                j.cubicTo(64.92641f, 12.0f, 75.0f, 22.073593f, 75.0f, 34.5f);
                j.cubicTo(75.0f, 46.926407f, 64.92641f, 57.0f, 52.5f, 57.0f);
                j.lineTo(28.0f, 57.0f);
                j.lineTo(28.0f, 51.0f);
                j.lineTo(28.5f, 51.0f);
                j.lineTo(32.8514f, 51.0f);
                j.lineTo(37.202793f, 51.0f);
                j.lineTo(52.5f, 51.0f);
                j.cubicTo(61.612698f, 51.0f, 69.0f, 43.612698f, 69.0f, 34.5f);
                j.cubicTo(69.0f, 25.387302f, 61.612698f, 18.0f, 52.5f, 18.0f);
                j.lineTo(32.8514f, 18.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
