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

public final class qf extends c {
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
                a.setColor(-12632257);
                e = c.a(e, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(46.01f, 0.01f);
                j.cubicTo(53.34f, 6.17f, 60.67f, 12.33f, 68.0f, 18.5f);
                j.cubicTo(60.71f, 24.71f, 53.33f, 30.82f, 46.0f, 36.99f);
                j.lineTo(46.0f, 25.98f);
                j.cubicTo(38.85f, 26.16f, 30.92f, 26.38f, 25.14f, 31.16f);
                j.cubicTo(21.72f, 33.97f, 19.85f, 38.1f, 17.97f, 41.99f);
                j.cubicTo(18.18f, 31.93f, 21.12f, 20.86f, 29.63f, 14.65f);
                j.cubicTo(34.27f, 11.04f, 40.36f, 10.72f, 45.99f, 11.02f);
                j.cubicTo(46.0f, 7.35f, 45.99f, 3.68f, 46.01f, 0.01f);
                j.lineTo(46.01f, 0.01f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.0f, 14.89f);
                j.cubicTo(0.71f, 13.12f, 1.88f, 10.94f, 3.88f, 11.06f);
                j.cubicTo(9.91f, 10.89f, 15.95f, 11.07f, 21.98f, 10.99f);
                j.cubicTo(20.16f, 13.11f, 18.66f, 15.48f, 17.45f, 17.99f);
                j.cubicTo(14.3f, 18.0f, 11.15f, 18.0f, 8.0f, 18.0f);
                j.lineTo(8.0f, 52.0f);
                j.lineTo(54.0f, 52.0f);
                j.lineTo(54.0f, 40.15f);
                j.cubicTo(56.31f, 38.17f, 58.64f, 36.2f, 60.99f, 34.26f);
                j.cubicTo(60.97f, 41.54f, 61.08f, 48.82f, 60.94f, 56.1f);
                j.cubicTo(61.02f, 58.07f, 58.92f, 59.33f, 57.12f, 58.99f);
                j.cubicTo(39.71f, 59.0f, 22.31f, 59.0f, 4.91f, 59.0f);
                j.cubicTo(3.11f, 59.32f, 0.93f, 58.1f, 1.05f, 56.09f);
                j.cubicTo(0.93f, 42.36f, 1.03f, 28.62f, 1.0f, 14.89f);
                j.lineTo(1.0f, 14.89f);
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
