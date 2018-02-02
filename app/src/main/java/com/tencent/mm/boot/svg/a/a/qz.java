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

public final class qz extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-10589839);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(64.3f, 0.0f);
                j.lineTo(70.33f, 0.0f);
                j.cubicTo(86.35f, 0.75f, 102.06f, 7.25f, 113.7f, 18.31f);
                j.cubicTo(126.44f, 30.12f, 134.09f, 47.01f, 135.0f, 64.32f);
                j.lineTo(135.0f, 70.32f);
                j.cubicTo(134.22f, 87.75f, 126.53f, 104.78f, 113.72f, 116.67f);
                j.cubicTo(102.17f, 127.67f, 86.61f, 134.13f, 70.72f, 135.0f);
                j.lineTo(64.63f, 135.0f);
                j.cubicTo(48.62f, 134.25f, 32.92f, 127.74f, 21.28f, 116.68f);
                j.cubicTo(8.55f, 104.88f, 0.93f, 88.0f, 0.0f, 70.7f);
                j.lineTo(0.0f, 64.71f);
                j.cubicTo(0.79f, 47.24f, 8.48f, 30.17f, 21.34f, 18.28f);
                j.cubicTo(32.89f, 7.31f, 48.43f, 0.87f, 64.3f, 0.0f);
                j.lineTo(64.3f, 0.0f);
                j.close();
                j.moveTo(57.53f, 3.77f);
                j.cubicTo(42.74f, 6.04f, 28.85f, 13.69f, 19.02f, 24.98f);
                j.cubicTo(9.09f, 36.21f, 3.31f, 51.0f, 3.03f, 65.99f);
                j.cubicTo(2.6f, 81.5f, 8.04f, 97.07f, 18.06f, 108.91f);
                j.cubicTo(28.44f, 121.4f, 43.71f, 129.71f, 59.86f, 131.54f);
                j.cubicTo(73.46f, 133.18f, 87.57f, 130.37f, 99.45f, 123.53f);
                j.cubicTo(112.28f, 116.24f, 122.47f, 104.41f, 127.72f, 90.62f);
                j.cubicTo(133.42f, 75.88f, 133.41f, 59.02f, 127.68f, 44.29f);
                j.cubicTo(121.91f, 29.17f, 110.18f, 16.45f, 95.6f, 9.44f);
                j.cubicTo(83.88f, 3.71f, 70.41f, 1.77f, 57.53f, 3.77f);
                j.lineTo(57.53f, 3.77f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(39.39f, 50.47f);
                j.cubicTo(40.75f, 49.66f, 42.45f, 50.14f, 43.95f, 49.98f);
                j.cubicTo(55.32f, 50.06f, 66.69f, 49.92f, 78.05f, 50.04f);
                j.cubicTo(80.05f, 49.9f, 81.29f, 52.08f, 81.0f, 53.87f);
                j.cubicTo(81.01f, 63.3f, 81.01f, 72.73f, 81.0f, 82.15f);
                j.cubicTo(81.28f, 83.92f, 80.07f, 86.09f, 78.08f, 85.95f);
                j.cubicTo(65.99f, 86.06f, 53.9f, 85.97f, 41.8f, 86.0f);
                j.cubicTo(40.0f, 86.34f, 37.93f, 84.99f, 38.04f, 83.03f);
                j.cubicTo(37.92f, 73.7f, 38.05f, 64.36f, 37.98f, 55.02f);
                j.cubicTo(38.0f, 53.42f, 37.8f, 51.43f, 39.39f, 50.47f);
                j.lineTo(39.39f, 50.47f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(84.0f, 64.11f);
                j.cubicTo(89.32f, 59.76f, 94.61f, 55.37f, 99.97f, 51.07f);
                j.cubicTo(100.02f, 61.68f, 100.02f, 72.29f, 99.97f, 82.89f);
                j.cubicTo(94.57f, 79.15f, 89.33f, 75.2f, 84.0f, 71.36f);
                j.lineTo(84.0f, 64.11f);
                j.lineTo(84.0f, 64.11f);
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
