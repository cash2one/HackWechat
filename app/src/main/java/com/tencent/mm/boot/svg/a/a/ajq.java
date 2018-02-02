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

public final class ajq extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                float[] a = c.a(e, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(-11962667);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(0.04f, 6.94f);
                j.cubicTo(8.881784E-16f, 2.86f, 4.0f, -0.44f, 7.99f, 0.0f);
                j.cubicTo(20.37f, 0.04f, 32.75f, -0.07f, 45.12f, 0.05f);
                j.cubicTo(48.71f, 0.04f, 51.97f, 3.27f, 51.94f, 6.87f);
                j.cubicTo(52.12f, 18.57f, 51.89f, 30.28f, 52.04f, 41.99f);
                j.cubicTo(46.03f, 42.0f, 40.01f, 42.01f, 34.0f, 41.99f);
                j.lineTo(34.0f, 36.0f);
                j.cubicTo(36.66f, 36.01f, 39.33f, 35.99f, 42.0f, 36.0f);
                j.lineTo(42.0f, 26.0f);
                j.cubicTo(39.33f, 26.01f, 36.65f, 25.99f, 33.98f, 26.0f);
                j.cubicTo(33.98f, 23.98f, 33.91f, 21.94f, 34.17f, 19.93f);
                j.cubicTo(35.74f, 17.24f, 39.43f, 18.28f, 42.0f, 17.94f);
                j.lineTo(42.0f, 8.01f);
                j.cubicTo(36.9f, 8.27f, 30.84f, 6.82f, 26.7f, 10.63f);
                j.cubicTo(22.53f, 14.63f, 24.4f, 20.89f, 24.01f, 26.0f);
                j.lineTo(18.0f, 26.0f);
                j.lineTo(18.0f, 36.0f);
                j.lineTo(24.0f, 36.0f);
                j.cubicTo(24.0f, 38.0f, 23.99f, 39.99f, 24.0f, 41.99f);
                j.cubicTo(15.99f, 42.0f, 7.97f, 42.0f, -0.04f, 41.99f);
                j.cubicTo(0.09f, 30.31f, -0.1f, 18.62f, 0.04f, 6.94f);
                j.lineTo(0.04f, 6.94f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-9398565);
                e = c.a(a, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 42.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(-0.04f, -0.01f);
                j.cubicTo(7.97f, 0.0f, 15.99f, 0.0f, 24.0f, -0.01f);
                j.lineTo(24.0f, 10.0f);
                j.cubicTo(17.69f, 9.83f, 11.35f, 10.34f, 5.07f, 9.75f);
                j.cubicTo(0.85f, 8.58f, -0.57f, 3.92f, -0.04f, -0.01f);
                j.lineTo(-0.04f, -0.01f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(34.0f, -0.01f);
                j.cubicTo(40.01f, 0.01f, 46.03f, 0.0f, 52.04f, -0.01f);
                j.cubicTo(52.55f, 3.89f, 51.21f, 8.51f, 47.03f, 9.72f);
                j.cubicTo(42.72f, 10.34f, 38.34f, 9.85f, 34.0f, 10.0f);
                j.lineTo(34.0f, -0.01f);
                j.lineTo(34.0f, -0.01f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
