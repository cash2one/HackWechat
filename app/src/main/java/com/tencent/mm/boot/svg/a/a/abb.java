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

public final class abb extends c {
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
                i2.setColor(-16896);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(5.2080674f, 81.84925f);
                j.cubicTo(3.9541583f, 83.99987f, 4.9507284f, 85.7433f, 7.4474754f, 85.7433f);
                j.lineTo(88.74638f, 85.7433f);
                j.cubicTo(91.23708f, 85.7433f, 92.23893f, 83.99854f, 90.985794f, 81.84925f);
                j.lineTo(50.367332f, 12.183118f);
                j.cubicTo(49.113426f, 10.032495f, 47.07966f, 10.033827f, 45.826527f, 12.183118f);
                j.lineTo(5.2080674f, 81.84925f);
                j.close();
                j.moveTo(45.896564f, 36.946117f);
                j.cubicTo(45.070587f, 36.946117f, 44.432064f, 37.61737f, 44.470753f, 38.453403f);
                j.lineTo(45.63274f, 63.56276f);
                j.lineTo(50.5597f, 63.56276f);
                j.lineTo(51.721687f, 38.453403f);
                j.cubicTo(51.760212f, 37.620953f, 51.122555f, 36.946117f, 50.295876f, 36.946117f);
                j.lineTo(45.896564f, 36.946117f);
                j.close();
                j.moveTo(48.096222f, 75.39238f);
                j.cubicTo(50.137035f, 75.39238f, 51.791443f, 73.73729f, 51.791443f, 71.695625f);
                j.cubicTo(51.791443f, 69.65396f, 50.137035f, 67.99887f, 48.096222f, 67.99887f);
                j.cubicTo(46.055405f, 67.99887f, 44.401f, 69.65396f, 44.401f, 71.695625f);
                j.cubicTo(44.401f, 73.73729f, 46.055405f, 75.39238f, 48.096222f, 75.39238f);
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
