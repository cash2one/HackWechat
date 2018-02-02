package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class agc extends c {
    private final int height = 64;
    private final int width = 64;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 64;
            case 1:
                return 64;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                i2 = c.a(i2, looper);
                i2.setColor(-12082593);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(32.0f, 64.0f);
                j.cubicTo(49.67311f, 64.0f, 64.0f, 49.67311f, 64.0f, 32.0f);
                j.cubicTo(64.0f, 14.326888f, 49.67311f, 0.0f, 32.0f, 0.0f);
                j.cubicTo(14.326888f, 0.0f, 0.0f, 14.326888f, 0.0f, 32.0f);
                j.cubicTo(0.0f, 49.67311f, 14.326888f, 64.0f, 32.0f, 64.0f);
                j.lineTo(32.0f, 64.0f);
                j.close();
                j.moveTo(3.0553617f, 31.019482f);
                j.cubicTo(2.559515f, 38.25722f, 5.4354253f, 45.386047f, 10.036881f, 50.881187f);
                j.cubicTo(14.08299f, 46.57419f, 20.043064f, 45.029606f, 24.71394f, 41.613712f);
                j.cubicTo(26.132061f, 40.73251f, 26.608074f, 38.811687f, 25.626297f, 37.415623f);
                j.cubicTo(23.623077f, 34.207653f, 20.757084f, 31.088789f, 21.104177f, 27.009516f);
                j.cubicTo(20.63808f, 20.05891f, 27.689018f, 13.524151f, 34.63087f, 15.623195f);
                j.cubicTo(41.850395f, 17.46481f, 45.093235f, 26.979813f, 41.13638f, 33.078922f);
                j.cubicTo(39.926514f, 35.42549f, 37.06052f, 37.47503f, 38.012543f, 40.415672f);
                j.cubicTo(42.495f, 45.019707f, 49.63519f, 46.00982f, 53.849884f, 51.0f);
                j.cubicTo(60.008297f, 43.910778f, 62.497448f, 33.890816f, 60.09755f, 24.80156f);
                j.cubicTo(57.16214f, 13.048896f, 46.14443f, 3.652706f, 33.9466f, 3.127945f);
                j.cubicTo(18.21835f, 1.5239588f, 3.015694f, 15.23705f, 3.0553617f, 31.019482f);
                j.lineTo(3.0553617f, 31.019482f);
                j.lineTo(3.0553617f, 31.019482f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
