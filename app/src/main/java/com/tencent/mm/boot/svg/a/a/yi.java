package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class yi extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-5460820);
                e = c.a(e, 1.0f, 0.0f, 27.0f, 0.0f, 1.0f, 23.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(19.37f, 3.98f);
                j.cubicTo(20.17f, 3.03f, 20.35f, 0.92f, 21.98f, 1.08f);
                j.cubicTo(25.32f, 0.9f, 28.67f, 0.9f, 32.01f, 1.08f);
                j.cubicTo(33.65f, 0.92f, 33.84f, 3.02f, 34.63f, 3.98f);
                j.cubicTo(40.07f, 4.15f, 45.54f, 3.71f, 50.96f, 4.18f);
                j.cubicTo(53.77f, 5.17f, 52.82f, 8.73f, 53.06f, 11.0f);
                j.lineTo(0.94f, 11.0f);
                j.cubicTo(1.2f, 8.73f, 0.19f, 5.16f, 3.03f, 4.19f);
                j.cubicTo(8.46f, 3.71f, 13.93f, 4.15f, 19.37f, 3.98f);
                j.lineTo(19.37f, 3.98f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(6.0f, 14.0f);
                j.lineTo(48.0f, 14.0f);
                j.cubicTo(47.98f, 28.03f, 48.02f, 42.06f, 47.99f, 56.1f);
                j.cubicTo(48.22f, 57.86f, 47.15f, 60.03f, 45.13f, 59.93f);
                j.cubicTo(33.39f, 60.09f, 21.63f, 59.97f, 9.89f, 59.99f);
                j.cubicTo(8.12f, 60.24f, 5.99f, 59.17f, 6.07f, 57.15f);
                j.cubicTo(5.89f, 42.77f, 6.06f, 28.38f, 6.0f, 14.0f);
                j.lineTo(6.0f, 14.0f);
                j.close();
                j.moveTo(14.93f, 23.51f);
                j.cubicTo(15.04f, 32.5f, 15.06f, 41.5f, 14.92f, 50.49f);
                j.cubicTo(16.3f, 50.92f, 17.69f, 50.94f, 19.07f, 50.51f);
                j.cubicTo(18.86f, 41.95f, 19.13f, 33.4f, 18.96f, 24.85f);
                j.cubicTo(19.2f, 22.36f, 16.37f, 23.08f, 14.93f, 23.51f);
                j.lineTo(14.93f, 23.51f);
                j.close();
                j.moveTo(24.93f, 23.5f);
                j.cubicTo(25.04f, 32.48f, 25.07f, 41.46f, 24.91f, 50.44f);
                j.cubicTo(26.09f, 50.68f, 27.39f, 51.35f, 28.56f, 50.68f);
                j.cubicTo(29.29f, 48.89f, 28.94f, 46.9f, 29.03f, 45.02f);
                j.cubicTo(28.85f, 37.99f, 29.24f, 30.95f, 28.86f, 23.94f);
                j.cubicTo(28.15f, 22.28f, 26.18f, 23.37f, 24.93f, 23.5f);
                j.lineTo(24.93f, 23.5f);
                j.close();
                j.moveTo(34.93f, 23.5f);
                j.cubicTo(35.03f, 32.47f, 35.08f, 41.43f, 34.9f, 50.4f);
                j.cubicTo(36.39f, 51.04f, 39.3f, 51.61f, 38.96f, 49.03f);
                j.cubicTo(39.04f, 41.01f, 39.04f, 32.97f, 38.96f, 24.94f);
                j.cubicTo(39.29f, 22.39f, 36.43f, 23.04f, 34.93f, 23.5f);
                j.lineTo(34.93f, 23.5f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}