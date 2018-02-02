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

public final class yo extends c {
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
                e = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 22.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(20.81f, 4.81f);
                j.cubicTo(23.86f, 3.28f, 26.6f, 0.97f, 29.96f, 0.16f);
                j.cubicTo(32.24f, 0.32f, 34.1f, 1.89f, 36.06f, 2.92f);
                j.cubicTo(42.71f, 7.01f, 49.79f, 10.4f, 56.18f, 14.9f);
                j.cubicTo(49.39f, 19.34f, 42.13f, 23.01f, 35.18f, 27.18f);
                j.cubicTo(32.87f, 28.52f, 30.02f, 30.57f, 27.42f, 28.62f);
                j.cubicTo(19.51f, 24.06f, 11.48f, 19.7f, 3.7f, 14.91f);
                j.cubicTo(9.07f, 11.02f, 15.13f, 8.22f, 20.81f, 4.81f);
                j.lineTo(20.81f, 4.81f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(0.96f, 19.47f);
                j.cubicTo(3.76f, 19.53f, 6.0f, 21.35f, 8.35f, 22.63f);
                j.cubicTo(13.69f, 25.65f, 18.99f, 28.73f, 24.35f, 31.7f);
                j.cubicTo(25.95f, 32.63f, 27.99f, 33.76f, 27.92f, 35.91f);
                j.cubicTo(28.15f, 42.61f, 27.91f, 49.32f, 28.01f, 56.02f);
                j.cubicTo(27.99f, 58.72f, 28.31f, 61.51f, 27.32f, 64.08f);
                j.cubicTo(19.59f, 59.67f, 11.88f, 55.24f, 4.15f, 50.84f);
                j.cubicTo(2.75f, 50.0f, 1.05f, 48.93f, 1.09f, 47.08f);
                j.cubicTo(0.83f, 37.88f, 1.13f, 28.67f, 0.96f, 19.47f);
                j.lineTo(0.96f, 19.47f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(54.91f, 20.81f);
                j.cubicTo(56.18f, 20.05f, 57.58f, 19.57f, 59.05f, 19.39f);
                j.cubicTo(58.9f, 28.3f, 59.08f, 37.21f, 58.98f, 46.11f);
                j.cubicTo(59.14f, 47.96f, 58.22f, 49.75f, 56.55f, 50.59f);
                j.cubicTo(50.46f, 54.2f, 44.18f, 57.49f, 38.08f, 61.08f);
                j.cubicTo(36.17f, 62.2f, 34.21f, 63.43f, 31.94f, 63.6f);
                j.cubicTo(32.14f, 54.37f, 31.84f, 45.13f, 32.07f, 35.91f);
                j.cubicTo(32.04f, 33.77f, 34.12f, 32.68f, 35.7f, 31.74f);
                j.cubicTo(42.13f, 28.15f, 48.52f, 24.47f, 54.91f, 20.81f);
                j.lineTo(54.91f, 20.81f);
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
