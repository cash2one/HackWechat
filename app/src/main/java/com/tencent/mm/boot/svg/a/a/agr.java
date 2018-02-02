package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class agr extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.saveLayerAlpha(null, ar.CTRL_INDEX, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(57.64f, 0.0f);
                j.lineTo(62.28f, 0.0f);
                j.cubicTo(76.76f, 0.59f, 90.96f, 6.52f, 101.4f, 16.59f);
                j.cubicTo(112.61f, 27.16f, 119.33f, 42.17f, 120.0f, 57.54f);
                j.lineTo(120.0f, 62.43f);
                j.cubicTo(119.34f, 77.55f, 112.85f, 92.35f, 101.95f, 102.89f);
                j.cubicTo(91.57f, 113.17f, 77.33f, 119.24f, 62.78f, 120.0f);
                j.lineTo(57.65f, 120.0f);
                j.cubicTo(42.48f, 119.36f, 27.64f, 112.85f, 17.09f, 101.92f);
                j.cubicTo(6.78f, 91.48f, 0.68f, 77.16f, 0.0f, 62.53f);
                j.lineTo(0.0f, 57.62f);
                j.cubicTo(0.63f, 42.94f, 6.74f, 28.56f, 17.08f, 18.09f);
                j.cubicTo(27.63f, 7.16f, 42.47f, 0.64f, 57.64f, 0.0f);
                j.lineTo(57.64f, 0.0f);
                j.close();
                j.moveTo(51.51f, 4.65f);
                j.cubicTo(36.05f, 6.93f, 21.8f, 16.1f, 13.25f, 29.18f);
                j.cubicTo(4.8f, 41.83f, 1.96f, 58.0f, 5.48f, 72.79f);
                j.cubicTo(8.55f, 86.14f, 16.78f, 98.19f, 28.04f, 105.97f);
                j.cubicTo(39.28f, 113.88f, 53.5f, 117.33f, 67.12f, 115.54f);
                j.cubicTo(82.63f, 113.66f, 97.09f, 104.84f, 105.96f, 91.99f);
                j.cubicTo(114.35f, 80.09f, 117.7f, 64.82f, 115.18f, 50.48f);
                j.cubicTo(112.74f, 35.87f, 104.15f, 22.44f, 91.97f, 14.03f);
                j.cubicTo(80.35f, 5.86f, 65.54f, 2.46f, 51.51f, 4.65f);
                j.lineTo(51.51f, 4.65f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(42.01f, 32.0f);
                j.cubicTo(57.33f, 41.35f, 72.67f, 50.66f, 87.99f, 60.0f);
                j.cubicTo(72.67f, 69.34f, 57.34f, 78.67f, 42.01f, 87.99f);
                j.cubicTo(42.0f, 69.33f, 41.99f, 50.67f, 42.01f, 32.0f);
                j.lineTo(42.01f, 32.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
