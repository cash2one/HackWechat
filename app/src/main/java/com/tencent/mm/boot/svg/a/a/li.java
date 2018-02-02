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

public final class li extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(11.71f, 0.65f);
                j.cubicTo(13.16f, -0.49f, 15.54f, 0.4f, 15.97f, 2.18f);
                j.cubicTo(16.66f, 4.08f, 14.73f, 5.41f, 13.74f, 6.74f);
                j.cubicTo(7.06f, 13.89f, 4.53f, 24.79f, 7.91f, 34.05f);
                j.cubicTo(9.17f, 38.24f, 11.95f, 41.66f, 14.49f, 45.11f);
                j.cubicTo(15.89f, 47.78f, 11.79f, 50.5f, 9.92f, 48.17f);
                j.cubicTo(5.54f, 42.99f, 2.1f, 36.8f, 1.12f, 30.01f);
                j.cubicTo(-0.61f, 19.28f, 3.6f, 7.83f, 11.71f, 0.65f);
                j.lineTo(11.71f, 0.65f);
                j.lineTo(11.71f, 0.65f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(21.54f, 8.56f);
                j.cubicTo(23.03f, 7.48f, 25.01f, 8.49f, 25.71f, 10.02f);
                j.cubicTo(26.07f, 11.88f, 24.53f, 13.18f, 23.6f, 14.56f);
                j.cubicTo(19.87f, 19.22f, 18.8f, 25.83f, 20.84f, 31.44f);
                j.cubicTo(21.6f, 33.87f, 23.29f, 35.83f, 24.47f, 38.05f);
                j.cubicTo(25.03f, 39.94f, 23.0f, 41.56f, 21.24f, 40.92f);
                j.cubicTo(12.08f, 32.68f, 12.35f, 16.7f, 21.54f, 8.56f);
                j.lineTo(21.54f, 8.56f);
                j.lineTo(21.54f, 8.56f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(30.63f, 15.39f);
                j.cubicTo(32.52f, 13.6f, 36.11f, 15.44f, 35.66f, 18.01f);
                j.cubicTo(35.07f, 20.61f, 32.21f, 22.23f, 32.25f, 25.08f);
                j.cubicTo(31.82f, 27.77f, 34.27f, 29.5f, 34.98f, 31.86f);
                j.cubicTo(35.37f, 34.54f, 31.58f, 36.31f, 29.8f, 34.27f);
                j.cubicTo(25.33f, 28.87f, 26.03f, 20.48f, 30.63f, 15.39f);
                j.lineTo(30.63f, 15.39f);
                j.lineTo(30.63f, 15.39f);
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
