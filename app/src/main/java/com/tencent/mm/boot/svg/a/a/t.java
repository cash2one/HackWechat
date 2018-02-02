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

public final class t extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 23.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2.11f, 1.14f);
                j.cubicTo(21.75f, 0.82f, 41.42f, 1.08f, 61.06f, 1.0f);
                j.cubicTo(62.34f, 0.79f, 64.15f, 1.37f, 63.95f, 2.98f);
                j.cubicTo(64.04f, 17.98f, 64.03f, 33.0f, 63.95f, 48.01f);
                j.cubicTo(64.14f, 49.6f, 62.39f, 50.21f, 61.11f, 49.99f);
                j.cubicTo(41.73f, 49.98f, 22.35f, 50.07f, 2.97f, 49.95f);
                j.cubicTo(1.37f, 50.15f, 0.79f, 48.35f, 1.0f, 47.09f);
                j.cubicTo(0.98f, 33.07f, 1.02f, 19.04f, 0.99f, 5.01f);
                j.cubicTo(1.1f, 3.66f, 0.63f, 1.9f, 2.11f, 1.14f);
                j.lineTo(2.11f, 1.14f);
                j.close();
                j.moveTo(40.12f, 8.16f);
                j.cubicTo(39.87f, 8.41f, 39.38f, 8.92f, 39.13f, 9.18f);
                j.cubicTo(38.91f, 14.42f, 38.89f, 19.7f, 39.14f, 24.95f);
                j.cubicTo(39.4f, 25.18f, 39.93f, 25.63f, 40.2f, 25.86f);
                j.cubicTo(45.41f, 26.11f, 50.67f, 26.09f, 55.88f, 25.87f);
                j.cubicTo(56.13f, 25.62f, 56.61f, 25.12f, 56.85f, 24.87f);
                j.cubicTo(57.11f, 19.64f, 57.11f, 14.35f, 56.85f, 9.12f);
                j.cubicTo(56.61f, 8.87f, 56.13f, 8.39f, 55.89f, 8.15f);
                j.cubicTo(50.65f, 7.9f, 45.36f, 7.88f, 40.12f, 8.16f);
                j.lineTo(40.12f, 8.16f);
                j.close();
                j.moveTo(7.15f, 27.14f);
                j.cubicTo(7.13f, 27.81f, 7.1f, 29.15f, 7.08f, 29.82f);
                j.cubicTo(16.02f, 30.11f, 24.98f, 30.13f, 33.91f, 29.81f);
                j.cubicTo(33.89f, 29.14f, 33.86f, 27.82f, 33.84f, 27.15f);
                j.cubicTo(24.95f, 26.9f, 16.04f, 26.91f, 7.15f, 27.14f);
                j.lineTo(7.15f, 27.14f);
                j.close();
                j.moveTo(7.1f, 37.16f);
                j.cubicTo(7.12f, 37.84f, 7.14f, 39.19f, 7.15f, 39.87f);
                j.cubicTo(16.06f, 40.06f, 24.99f, 40.14f, 33.9f, 39.82f);
                j.cubicTo(33.88f, 39.15f, 33.84f, 37.79f, 33.82f, 37.12f);
                j.cubicTo(24.92f, 36.94f, 16.0f, 36.88f, 7.1f, 37.16f);
                j.lineTo(7.1f, 37.16f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(42.3f, 11.32f);
                j.cubicTo(46.01f, 10.77f, 49.94f, 10.79f, 53.66f, 11.31f);
                j.cubicTo(54.26f, 15.03f, 54.2f, 18.98f, 53.69f, 22.72f);
                j.cubicTo(49.93f, 23.17f, 46.01f, 23.26f, 42.28f, 22.68f);
                j.cubicTo(41.82f, 18.94f, 41.77f, 15.04f, 42.3f, 11.32f);
                j.lineTo(42.3f, 11.32f);
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
