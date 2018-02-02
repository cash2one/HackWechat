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

public final class rc extends c {
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
                j.moveTo(63.99f, 0.0f);
                j.lineTo(70.69f, 0.0f);
                j.cubicTo(86.82f, 0.87f, 102.6f, 7.52f, 114.2f, 18.79f);
                j.cubicTo(126.58f, 30.49f, 133.98f, 47.03f, 135.0f, 63.99f);
                j.lineTo(135.0f, 70.31f);
                j.cubicTo(134.21f, 87.99f, 126.31f, 105.25f, 113.19f, 117.17f);
                j.cubicTo(101.77f, 127.81f, 86.56f, 134.04f, 71.02f, 135.0f);
                j.lineTo(64.24f, 135.0f);
                j.cubicTo(48.36f, 134.12f, 32.82f, 127.66f, 21.28f, 116.67f);
                j.cubicTo(8.47f, 104.8f, 0.8f, 87.76f, 0.0f, 70.34f);
                j.lineTo(0.0f, 64.32f);
                j.cubicTo(0.92f, 47.02f, 8.54f, 30.13f, 21.28f, 18.33f);
                j.cubicTo(32.76f, 7.39f, 48.2f, 0.97f, 63.99f, 0.0f);
                j.lineTo(63.99f, 0.0f);
                j.close();
                j.moveTo(71.49f, 36.65f);
                j.cubicTo(68.92f, 37.77f, 68.74f, 41.46f, 70.85f, 43.14f);
                j.cubicTo(77.99f, 50.46f, 82.01f, 60.92f, 80.79f, 71.16f);
                j.cubicTo(79.99f, 79.17f, 75.99f, 86.56f, 70.51f, 92.35f);
                j.cubicTo(67.88f, 95.4f, 72.51f, 100.2f, 75.63f, 97.54f);
                j.cubicTo(84.15f, 89.54f, 88.9f, 77.7f, 88.47f, 66.03f);
                j.cubicTo(88.12f, 55.26f, 83.3f, 44.81f, 75.62f, 37.32f);
                j.cubicTo(74.59f, 36.21f, 72.83f, 35.99f, 71.49f, 36.65f);
                j.lineTo(71.49f, 36.65f);
                j.close();
                j.moveTo(59.31f, 46.29f);
                j.cubicTo(56.61f, 47.98f, 57.55f, 51.65f, 59.81f, 53.25f);
                j.cubicTo(67.48f, 60.25f, 68.05f, 73.25f, 60.75f, 80.72f);
                j.cubicTo(58.94f, 82.47f, 56.3f, 84.97f, 58.29f, 87.62f);
                j.cubicTo(59.72f, 89.79f, 63.0f, 89.59f, 64.51f, 87.62f);
                j.cubicTo(70.09f, 82.35f, 73.71f, 74.82f, 73.47f, 67.07f);
                j.cubicTo(73.45f, 59.15f, 69.42f, 51.65f, 63.57f, 46.48f);
                j.cubicTo(62.43f, 45.43f, 60.57f, 45.5f, 59.31f, 46.29f);
                j.lineTo(59.31f, 46.29f);
                j.close();
                j.moveTo(46.47f, 61.53f);
                j.cubicTo(48.7f, 62.97f, 51.32f, 65.05f, 50.98f, 68.04f);
                j.cubicTo(50.69f, 70.67f, 48.28f, 72.17f, 46.36f, 73.61f);
                j.cubicTo(45.64f, 77.0f, 49.16f, 79.97f, 52.29f, 78.28f);
                j.cubicTo(57.89f, 75.01f, 60.42f, 67.0f, 56.77f, 61.38f);
                j.cubicTo(55.09f, 58.85f, 52.6f, 55.46f, 49.12f, 56.41f);
                j.cubicTo(46.82f, 56.97f, 46.19f, 59.46f, 46.47f, 61.53f);
                j.lineTo(46.47f, 61.53f);
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
