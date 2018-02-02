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

public final class yk extends c {
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
                a.setColor(-12632257);
                e = c.a(e, 1.0f, 0.0f, 27.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(21.18f, 1.19f);
                j.cubicTo(25.06f, 0.83f, 28.99f, 0.81f, 32.86f, 1.21f);
                j.cubicTo(33.54f, 2.1f, 34.17f, 3.02f, 34.74f, 3.98f);
                j.cubicTo(40.18f, 4.16f, 45.65f, 3.69f, 51.07f, 4.21f);
                j.cubicTo(53.73f, 5.33f, 52.78f, 8.74f, 53.11f, 11.0f);
                j.lineTo(0.89f, 11.0f);
                j.cubicTo(1.23f, 8.75f, 0.22f, 5.23f, 2.97f, 4.21f);
                j.cubicTo(8.38f, 3.68f, 13.83f, 4.16f, 19.25f, 3.98f);
                j.cubicTo(19.84f, 3.01f, 20.49f, 2.08f, 21.18f, 1.19f);
                j.lineTo(21.18f, 1.19f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(6.0f, 14.0f);
                j.lineTo(48.0f, 14.0f);
                j.cubicTo(48.0f, 27.68f, 47.99f, 41.37f, 48.02f, 55.06f);
                j.cubicTo(47.94f, 56.59f, 48.16f, 58.56f, 46.64f, 59.5f);
                j.cubicTo(45.23f, 60.25f, 43.52f, 59.9f, 41.99f, 60.03f);
                j.cubicTo(31.28f, 59.94f, 20.56f, 60.06f, 9.85f, 59.98f);
                j.cubicTo(8.08f, 60.22f, 5.97f, 59.13f, 6.09f, 57.12f);
                j.cubicTo(5.87f, 42.75f, 6.07f, 28.37f, 6.0f, 14.0f);
                j.lineTo(6.0f, 14.0f);
                j.close();
                j.moveTo(14.95f, 23.34f);
                j.cubicTo(15.03f, 32.42f, 15.03f, 41.5f, 14.95f, 50.58f);
                j.cubicTo(16.27f, 50.55f, 18.19f, 51.75f, 18.83f, 50.02f);
                j.cubicTo(19.28f, 41.14f, 18.82f, 32.23f, 19.04f, 23.34f);
                j.cubicTo(17.68f, 23.31f, 16.32f, 23.31f, 14.95f, 23.34f);
                j.lineTo(14.95f, 23.34f);
                j.close();
                j.moveTo(25.16f, 23.99f);
                j.cubicTo(24.73f, 32.86f, 25.19f, 41.77f, 24.95f, 50.65f);
                j.cubicTo(26.31f, 50.69f, 27.68f, 50.69f, 29.04f, 50.67f);
                j.cubicTo(28.98f, 41.59f, 28.96f, 32.5f, 29.05f, 23.42f);
                j.cubicTo(27.74f, 23.45f, 25.79f, 22.25f, 25.16f, 23.99f);
                j.lineTo(25.16f, 23.99f);
                j.close();
                j.moveTo(35.54f, 23.46f);
                j.cubicTo(34.51f, 24.64f, 35.21f, 26.57f, 34.97f, 28.03f);
                j.cubicTo(35.09f, 35.07f, 34.88f, 42.11f, 35.05f, 49.15f);
                j.cubicTo(34.79f, 50.89f, 36.76f, 51.32f, 38.06f, 51.01f);
                j.cubicTo(39.31f, 50.05f, 38.89f, 48.36f, 39.03f, 47.0f);
                j.cubicTo(38.93f, 39.63f, 39.11f, 32.24f, 38.95f, 24.87f);
                j.cubicTo(39.31f, 23.0f, 36.6f, 22.3f, 35.54f, 23.46f);
                j.lineTo(35.54f, 23.46f);
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
