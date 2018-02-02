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

public final class qv extends c {
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
                j.moveTo(63.94f, 0.0f);
                j.lineTo(70.81f, 0.0f);
                j.cubicTo(86.67f, 0.91f, 102.18f, 7.35f, 113.71f, 18.32f);
                j.cubicTo(126.37f, 30.04f, 133.96f, 46.78f, 135.0f, 63.96f);
                j.lineTo(135.0f, 70.81f);
                j.cubicTo(134.04f, 88.09f, 126.4f, 104.93f, 113.68f, 116.71f);
                j.cubicTo(102.22f, 127.61f, 86.83f, 134.01f, 71.08f, 135.0f);
                j.lineTo(64.17f, 135.0f);
                j.cubicTo(48.32f, 134.09f, 32.82f, 127.65f, 21.3f, 116.69f);
                j.cubicTo(8.63f, 104.98f, 1.05f, 88.23f, 0.0f, 71.06f);
                j.lineTo(0.0f, 64.21f);
                j.cubicTo(0.96f, 46.94f, 8.58f, 30.08f, 21.3f, 18.31f);
                j.cubicTo(32.77f, 7.4f, 48.18f, 0.99f, 63.94f, 0.0f);
                j.lineTo(63.94f, 0.0f);
                j.close();
                j.moveTo(57.48f, 3.78f);
                j.cubicTo(40.34f, 6.39f, 24.51f, 16.32f, 14.64f, 30.56f);
                j.cubicTo(5.98f, 42.81f, 1.91f, 58.16f, 3.25f, 73.09f);
                j.cubicTo(4.37f, 86.66f, 9.99f, 99.8f, 19.01f, 110.01f);
                j.cubicTo(29.36f, 121.91f, 44.22f, 129.77f, 59.9f, 131.54f);
                j.cubicTo(73.73f, 133.21f, 88.08f, 130.26f, 100.07f, 123.17f);
                j.cubicTo(112.84f, 115.73f, 122.91f, 103.76f, 128.0f, 89.88f);
                j.cubicTo(133.43f, 75.31f, 133.31f, 58.76f, 127.67f, 44.26f);
                j.cubicTo(121.81f, 28.94f, 109.83f, 16.09f, 94.97f, 9.14f);
                j.cubicTo(83.39f, 3.63f, 70.14f, 1.8f, 57.48f, 3.78f);
                j.lineTo(57.48f, 3.78f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(39.32f, 45.3f);
                j.cubicTo(40.83f, 44.79f, 42.47f, 45.06f, 44.03f, 44.98f);
                j.cubicTo(60.06f, 45.04f, 76.09f, 44.96f, 92.11f, 45.02f);
                j.cubicTo(93.76f, 44.78f, 95.27f, 46.26f, 94.99f, 47.92f);
                j.cubicTo(95.01f, 60.63f, 95.01f, 73.34f, 94.99f, 86.06f);
                j.cubicTo(95.26f, 87.75f, 93.75f, 89.25f, 92.06f, 88.98f);
                j.cubicTo(75.02f, 89.01f, 57.98f, 89.01f, 40.94f, 88.98f);
                j.cubicTo(39.28f, 89.24f, 37.73f, 87.77f, 38.02f, 86.09f);
                j.cubicTo(37.97f, 73.72f, 38.03f, 61.34f, 37.99f, 48.96f);
                j.cubicTo(37.98f, 47.67f, 37.9f, 45.94f, 39.32f, 45.3f);
                j.lineTo(39.32f, 45.3f);
                j.close();
                j.moveTo(43.0f, 50.0f);
                j.lineTo(43.0f, 73.62f);
                j.cubicTo(46.44f, 68.93f, 50.54f, 64.63f, 55.48f, 61.5f);
                j.cubicTo(57.29f, 60.32f, 59.61f, 59.41f, 61.69f, 60.53f);
                j.cubicTo(68.61f, 63.77f, 71.39f, 71.39f, 76.27f, 76.76f);
                j.cubicTo(75.33f, 74.74f, 74.33f, 72.75f, 73.33f, 70.77f);
                j.cubicTo(75.67f, 69.26f, 77.98f, 66.88f, 80.96f, 67.06f);
                j.cubicTo(85.06f, 68.1f, 87.56f, 71.89f, 90.01f, 75.03f);
                j.cubicTo(89.98f, 66.69f, 90.01f, 58.34f, 90.0f, 50.0f);
                j.lineTo(43.0f, 50.0f);
                j.lineTo(43.0f, 50.0f);
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
