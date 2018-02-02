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

public final class xh extends c {
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
                a.setColor(-6710887);
                e = c.a(e, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(32.15f, 1.21f);
                j.cubicTo(35.31f, 0.04f, 39.4f, 2.29f, 38.97f, 5.93f);
                j.cubicTo(38.98f, 15.62f, 39.11f, 25.32f, 38.91f, 35.01f);
                j.cubicTo(38.66f, 40.35f, 29.36f, 40.37f, 29.1f, 35.03f);
                j.cubicTo(28.84f, 25.66f, 29.08f, 16.28f, 28.99f, 6.91f);
                j.cubicTo(28.75f, 4.59f, 29.67f, 1.89f, 32.15f, 1.21f);
                j.lineTo(32.15f, 1.21f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(10.5f, 14.5f);
                j.cubicTo(13.31f, 12.04f, 18.2f, 14.27f, 18.4f, 17.95f);
                j.cubicTo(18.76f, 20.52f, 16.55f, 22.3f, 15.2f, 24.19f);
                j.cubicTo(10.43f, 29.93f, 8.89f, 38.04f, 10.82f, 45.2f);
                j.cubicTo(12.8f, 52.84f, 18.84f, 59.26f, 26.33f, 61.74f);
                j.cubicTo(34.52f, 64.55f, 44.17f, 62.52f, 50.42f, 56.49f);
                j.cubicTo(56.65f, 50.76f, 59.37f, 41.62f, 57.34f, 33.41f);
                j.cubicTo(56.41f, 29.04f, 53.92f, 25.26f, 50.99f, 21.97f);
                j.cubicTo(49.54f, 20.48f, 48.99f, 18.13f, 50.02f, 16.26f);
                j.cubicTo(51.35f, 13.27f, 55.79f, 12.49f, 57.98f, 14.96f);
                j.cubicTo(66.34f, 23.07f, 69.85f, 35.71f, 67.04f, 47.0f);
                j.cubicTo(63.74f, 61.51f, 49.98f, 72.8f, 35.06f, 72.95f);
                j.cubicTo(20.81f, 73.68f, 6.93f, 64.23f, 2.13f, 50.83f);
                j.cubicTo(-2.61f, 38.49f, 0.77f, 23.49f, 10.5f, 14.5f);
                j.lineTo(10.5f, 14.5f);
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
