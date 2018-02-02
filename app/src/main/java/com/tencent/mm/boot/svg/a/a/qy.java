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

public final class qy extends c {
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
                j.moveTo(64.37f, 0.0f);
                j.lineTo(70.41f, 0.0f);
                j.cubicTo(86.4f, 0.78f, 102.07f, 7.26f, 113.69f, 18.31f);
                j.cubicTo(126.46f, 30.13f, 134.11f, 47.06f, 135.0f, 64.4f);
                j.lineTo(135.0f, 70.11f);
                j.cubicTo(134.29f, 87.62f, 126.57f, 104.75f, 113.7f, 116.69f);
                j.cubicTo(102.14f, 127.69f, 86.56f, 134.15f, 70.66f, 135.0f);
                j.lineTo(64.54f, 135.0f);
                j.cubicTo(48.58f, 134.22f, 32.94f, 127.74f, 21.33f, 116.72f);
                j.cubicTo(8.45f, 104.8f, 0.75f, 87.69f, 0.0f, 70.19f);
                j.lineTo(0.0f, 64.6f);
                j.cubicTo(0.82f, 47.2f, 8.48f, 30.19f, 21.29f, 18.33f);
                j.cubicTo(32.86f, 7.32f, 48.45f, 0.85f, 64.37f, 0.0f);
                j.lineTo(64.37f, 0.0f);
                j.close();
                j.moveTo(32.34f, 64.88f);
                j.cubicTo(30.34f, 73.02f, 36.53f, 81.88f, 44.84f, 82.83f);
                j.cubicTo(51.28f, 83.27f, 57.75f, 82.79f, 64.2f, 83.08f);
                j.cubicTo(61.81f, 81.49f, 59.91f, 79.33f, 58.31f, 76.98f);
                j.cubicTo(54.19f, 76.94f, 50.06f, 77.15f, 45.95f, 76.91f);
                j.cubicTo(41.54f, 76.53f, 37.91f, 72.42f, 38.01f, 68.0f);
                j.cubicTo(37.91f, 63.56f, 41.57f, 59.46f, 46.01f, 59.09f);
                j.cubicTo(51.03f, 58.86f, 56.07f, 59.06f, 61.11f, 58.99f);
                j.cubicTo(64.5f, 58.8f, 68.02f, 60.4f, 69.73f, 63.4f);
                j.cubicTo(71.54f, 66.22f, 71.07f, 69.7f, 69.96f, 72.68f);
                j.cubicTo(71.75f, 73.73f, 73.78f, 74.09f, 75.83f, 74.09f);
                j.cubicTo(78.41f, 67.82f, 76.57f, 60.06f, 71.01f, 56.04f);
                j.cubicTo(64.73f, 51.05f, 56.35f, 53.63f, 49.03f, 52.99f);
                j.cubicTo(41.5f, 52.14f, 33.75f, 57.31f, 32.34f, 64.88f);
                j.lineTo(32.34f, 64.88f);
                j.close();
                j.moveTo(71.19f, 52.99f);
                j.cubicTo(73.28f, 54.72f, 75.14f, 56.72f, 76.64f, 58.99f);
                j.cubicTo(81.25f, 59.21f, 85.95f, 58.54f, 90.52f, 59.38f);
                j.cubicTo(96.63f, 60.87f, 99.12f, 69.28f, 94.82f, 73.86f);
                j.cubicTo(91.46f, 78.03f, 85.67f, 76.86f, 81.0f, 77.0f);
                j.cubicTo(76.2f, 76.7f, 70.4f, 78.25f, 66.64f, 74.36f);
                j.cubicTo(63.63f, 71.55f, 63.47f, 66.96f, 65.07f, 63.38f);
                j.cubicTo(63.3f, 62.26f, 61.24f, 61.92f, 59.17f, 61.91f);
                j.cubicTo(56.49f, 68.39f, 58.6f, 76.52f, 64.57f, 80.4f);
                j.cubicTo(69.63f, 84.08f, 76.16f, 82.78f, 81.99f, 83.0f);
                j.cubicTo(85.94f, 82.83f, 90.17f, 83.68f, 93.84f, 81.8f);
                j.cubicTo(99.98f, 79.33f, 103.92f, 72.4f, 102.84f, 65.85f);
                j.cubicTo(101.93f, 58.77f, 95.26f, 52.84f, 88.09f, 52.98f);
                j.cubicTo(82.45f, 53.0f, 76.82f, 53.02f, 71.19f, 52.99f);
                j.lineTo(71.19f, 52.99f);
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
