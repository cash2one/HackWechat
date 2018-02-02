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

public final class pv extends c {
    private final int height = 84;
    private final int width = 84;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 84;
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
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 11.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(35.18f, 1.25f);
                j.cubicTo(37.03f, 0.39f, 38.77f, 1.7f, 39.98f, 3.0f);
                j.cubicTo(46.58f, 9.72f, 53.34f, 16.29f, 59.91f, 23.03f);
                j.cubicTo(61.61f, 24.5f, 61.14f, 27.15f, 59.49f, 28.45f);
                j.cubicTo(49.33f, 38.64f, 39.13f, 48.78f, 28.98f, 58.99f);
                j.cubicTo(27.92f, 60.05f, 26.72f, 61.2f, 25.07f, 60.98f);
                j.cubicTo(19.04f, 61.07f, 13.0f, 60.94f, 6.97f, 61.03f);
                j.cubicTo(5.32f, 60.88f, 3.3f, 61.34f, 2.04f, 59.98f);
                j.cubicTo(0.69f, 58.72f, 1.09f, 56.7f, 0.97f, 55.06f);
                j.cubicTo(1.06f, 49.01f, 0.93f, 42.95f, 1.02f, 36.9f);
                j.cubicTo(0.82f, 35.29f, 1.94f, 34.09f, 2.99f, 33.05f);
                j.cubicTo(12.19f, 23.88f, 21.37f, 14.69f, 30.54f, 5.51f);
                j.cubicTo(32.04f, 4.04f, 33.4f, 2.39f, 35.18f, 1.25f);
                j.lineTo(35.18f, 1.25f);
                j.close();
                j.moveTo(16.16f, 38.3f);
                j.cubicTo(12.0f, 39.44f, 10.56f, 45.35f, 13.77f, 48.24f);
                j.cubicTo(16.69f, 51.44f, 22.64f, 49.97f, 23.72f, 45.78f);
                j.cubicTo(25.35f, 41.39f, 20.52f, 36.64f, 16.16f, 38.3f);
                j.lineTo(16.16f, 38.3f);
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
