package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.a;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ra extends c {
    private final int height = a.CTRL_INDEX;
    private final int width = a.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return a.CTRL_INDEX;
            case 1:
                return a.CTRL_INDEX;
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
                i2 = c.a(i2, looper);
                i2.setColor(-9207928);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(64.31f, 0.0f);
                j.lineTo(70.36f, 0.0f);
                j.cubicTo(86.13f, 0.75f, 101.58f, 7.05f, 113.16f, 17.81f);
                j.cubicTo(126.28f, 29.71f, 134.19f, 46.96f, 135.0f, 64.63f);
                j.lineTo(135.0f, 70.06f);
                j.cubicTo(134.29f, 87.85f, 126.34f, 105.24f, 113.14f, 117.21f);
                j.cubicTo(101.65f, 127.9f, 86.33f, 134.15f, 70.7f, 135.0f);
                j.lineTo(64.61f, 135.0f);
                j.cubicTo(48.84f, 134.24f, 33.37f, 127.94f, 21.8f, 117.16f);
                j.cubicTo(8.65f, 105.22f, 0.75f, 87.89f, 0.0f, 70.17f);
                j.lineTo(0.0f, 64.67f);
                j.cubicTo(0.8f, 47.0f, 8.69f, 29.74f, 21.81f, 17.84f);
                j.cubicTo(33.31f, 7.13f, 48.65f, 0.86f, 64.31f, 0.0f);
                j.lineTo(64.31f, 0.0f);
                j.close();
                j.moveTo(39.37f, 50.47f);
                j.cubicTo(37.77f, 51.38f, 38.02f, 53.4f, 37.98f, 54.96f);
                j.cubicTo(38.05f, 64.0f, 37.92f, 73.04f, 38.04f, 82.08f);
                j.cubicTo(37.95f, 83.58f, 39.36f, 85.08f, 40.89f, 84.96f);
                j.cubicTo(53.29f, 85.03f, 65.69f, 85.03f, 78.09f, 84.96f);
                j.cubicTo(79.61f, 85.08f, 81.04f, 83.62f, 80.96f, 82.12f);
                j.cubicTo(81.06f, 72.7f, 80.98f, 63.29f, 81.0f, 53.87f);
                j.cubicTo(81.29f, 52.11f, 80.14f, 49.93f, 78.14f, 50.05f);
                j.cubicTo(66.77f, 49.91f, 55.39f, 50.07f, 44.02f, 49.98f);
                j.cubicTo(42.49f, 50.13f, 40.76f, 49.67f, 39.37f, 50.47f);
                j.lineTo(39.37f, 50.47f);
                j.close();
                j.moveTo(84.01f, 64.47f);
                j.cubicTo(84.0f, 66.98f, 83.99f, 69.48f, 84.0f, 71.99f);
                j.cubicTo(89.66f, 76.01f, 95.34f, 80.0f, 101.01f, 84.01f);
                j.cubicTo(100.99f, 73.01f, 101.01f, 62.01f, 101.0f, 51.01f);
                j.cubicTo(95.32f, 55.47f, 89.7f, 60.01f, 84.01f, 64.47f);
                j.lineTo(84.01f, 64.47f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
