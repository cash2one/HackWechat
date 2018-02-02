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

public final class pw extends c {
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
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 11.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(35.23f, 1.25f);
                j.cubicTo(37.08f, 0.35f, 38.8f, 1.79f, 40.01f, 3.04f);
                j.cubicTo(46.31f, 9.38f, 52.63f, 15.7f, 58.97f, 22.0f);
                j.cubicTo(60.26f, 23.23f, 61.63f, 24.95f, 60.74f, 26.83f);
                j.cubicTo(59.31f, 28.98f, 57.27f, 30.63f, 55.48f, 32.47f);
                j.cubicTo(46.81f, 41.15f, 38.11f, 49.79f, 29.48f, 58.5f);
                j.cubicTo(28.24f, 59.68f, 26.96f, 61.22f, 25.05f, 60.97f);
                j.cubicTo(18.33f, 61.03f, 11.6f, 61.04f, 4.88f, 60.97f);
                j.cubicTo(2.66f, 61.25f, 0.75f, 59.24f, 1.03f, 57.05f);
                j.cubicTo(1.13f, 49.75f, 0.64f, 42.39f, 1.29f, 35.13f);
                j.cubicTo(9.14f, 26.42f, 17.85f, 18.46f, 26.03f, 10.03f);
                j.cubicTo(29.15f, 7.16f, 31.77f, 3.72f, 35.23f, 1.25f);
                j.lineTo(35.23f, 1.25f);
                j.close();
                j.moveTo(16.24f, 38.27f);
                j.cubicTo(12.02f, 39.37f, 10.54f, 45.33f, 13.78f, 48.25f);
                j.cubicTo(16.71f, 51.46f, 22.67f, 49.96f, 23.73f, 45.74f);
                j.cubicTo(25.3f, 41.39f, 20.58f, 36.69f, 16.24f, 38.27f);
                j.lineTo(16.24f, 38.27f);
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
