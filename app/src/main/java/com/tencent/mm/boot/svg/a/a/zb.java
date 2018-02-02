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

public final class zb extends c {
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
                e = c.a(e, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 25.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(43.01f, 0.01f);
                j.cubicTo(50.34f, 6.18f, 57.67f, 12.34f, 65.0f, 18.5f);
                j.cubicTo(57.67f, 24.67f, 50.34f, 30.83f, 43.01f, 36.99f);
                j.cubicTo(43.0f, 33.32f, 43.0f, 29.64f, 43.0f, 25.97f);
                j.cubicTo(36.32f, 26.17f, 29.09f, 26.33f, 23.36f, 30.22f);
                j.cubicTo(19.21f, 33.0f, 17.04f, 37.67f, 14.94f, 42.01f);
                j.cubicTo(15.22f, 31.95f, 18.09f, 20.86f, 26.63f, 14.65f);
                j.cubicTo(31.27f, 11.04f, 37.36f, 10.73f, 43.0f, 11.02f);
                j.cubicTo(42.99f, 7.35f, 43.0f, 3.68f, 43.01f, 0.01f);
                j.lineTo(43.01f, 0.01f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.01f, 13.9f);
                j.cubicTo(0.71f, 12.13f, 1.86f, 9.97f, 3.86f, 10.06f);
                j.cubicTo(9.23f, 9.86f, 14.62f, 10.09f, 20.0f, 9.98f);
                j.cubicTo(17.97f, 12.06f, 16.28f, 14.44f, 14.88f, 16.99f);
                j.cubicTo(12.59f, 17.01f, 10.29f, 17.0f, 8.0f, 17.0f);
                j.lineTo(8.0f, 51.0f);
                j.lineTo(54.0f, 51.0f);
                j.lineTo(54.0f, 37.59f);
                j.cubicTo(56.34f, 35.63f, 58.66f, 33.65f, 61.0f, 31.69f);
                j.cubicTo(60.94f, 39.5f, 61.11f, 47.31f, 60.93f, 55.12f);
                j.cubicTo(61.01f, 57.09f, 58.92f, 58.3f, 57.14f, 57.99f);
                j.cubicTo(39.7f, 58.0f, 22.26f, 58.01f, 4.83f, 57.99f);
                j.cubicTo(3.07f, 58.29f, 0.95f, 57.08f, 1.06f, 55.12f);
                j.cubicTo(0.92f, 41.38f, 1.03f, 27.64f, 1.01f, 13.9f);
                j.lineTo(1.01f, 13.9f);
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
