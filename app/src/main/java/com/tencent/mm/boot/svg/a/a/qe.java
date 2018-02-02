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

public final class qe extends c {
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
                a.setColor(-10526881);
                e = c.a(e, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(46.01f, 0.01f);
                j.cubicTo(53.34f, 6.17f, 60.67f, 12.34f, 68.0f, 18.5f);
                j.cubicTo(60.71f, 24.71f, 53.32f, 30.81f, 46.01f, 36.99f);
                j.cubicTo(45.99f, 33.32f, 46.0f, 29.65f, 46.0f, 25.98f);
                j.cubicTo(38.87f, 26.16f, 30.95f, 26.38f, 25.17f, 31.13f);
                j.cubicTo(21.73f, 33.95f, 19.85f, 38.09f, 17.96f, 42.0f);
                j.cubicTo(18.18f, 31.95f, 21.11f, 20.87f, 29.62f, 14.66f);
                j.cubicTo(34.26f, 11.04f, 40.36f, 10.72f, 45.99f, 11.02f);
                j.cubicTo(46.0f, 7.35f, 46.0f, 3.68f, 46.01f, 0.01f);
                j.lineTo(46.01f, 0.01f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.01f, 14.82f);
                j.cubicTo(0.72f, 13.08f, 1.91f, 10.96f, 3.85f, 11.06f);
                j.cubicTo(9.89f, 10.89f, 15.94f, 11.07f, 21.98f, 10.99f);
                j.cubicTo(20.17f, 13.11f, 18.65f, 15.46f, 17.46f, 17.99f);
                j.cubicTo(14.31f, 18.0f, 11.15f, 18.0f, 8.0f, 18.0f);
                j.lineTo(8.0f, 52.0f);
                j.lineTo(54.0f, 52.0f);
                j.lineTo(54.0f, 40.15f);
                j.cubicTo(56.32f, 38.16f, 58.66f, 36.19f, 60.99f, 34.23f);
                j.cubicTo(60.96f, 41.53f, 61.09f, 48.83f, 60.94f, 56.13f);
                j.cubicTo(61.0f, 58.1f, 58.89f, 59.32f, 57.1f, 59.0f);
                j.cubicTo(39.37f, 58.97f, 21.63f, 59.07f, 3.9f, 58.95f);
                j.cubicTo(1.9f, 59.06f, 0.69f, 56.9f, 1.01f, 55.11f);
                j.cubicTo(1.0f, 41.68f, 0.99f, 28.25f, 1.01f, 14.82f);
                j.lineTo(1.01f, 14.82f);
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
