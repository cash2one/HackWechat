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

public final class iy extends c {
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
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(20.001331f, 33.0f);
                j.cubicTo(17.239172f, 33.0f, 15.0f, 35.236286f, 15.0f, 38.00532f);
                j.lineTo(15.0f, 67.994675f);
                j.cubicTo(15.0f, 70.75904f, 17.233757f, 73.0f, 20.001331f, 73.0f);
                j.lineTo(75.998665f, 73.0f);
                j.cubicTo(78.760826f, 73.0f, 81.0f, 70.76372f, 81.0f, 67.994675f);
                j.lineTo(81.0f, 38.00532f);
                j.cubicTo(81.0f, 35.24096f, 78.76624f, 33.0f, 75.998665f, 33.0f);
                j.lineTo(20.001331f, 33.0f);
                j.close();
                j.moveTo(41.230534f, 24.0f);
                j.lineTo(48.0f, 24.0f);
                j.lineTo(48.0f, 33.0f);
                j.lineTo(27.74054f, 33.0f);
                j.cubicTo(33.113003f, 33.0f, 35.999054f, 24.0f, 41.230534f, 24.0f);
                j.close();
                j.moveTo(68.25946f, 33.0f);
                j.cubicTo(62.886997f, 33.0f, 60.000946f, 24.0f, 54.7683f, 24.0f);
                j.lineTo(48.0f, 24.0f);
                j.lineTo(48.0f, 33.0f);
                j.lineTo(68.25946f, 33.0f);
                j.close();
                j.moveTo(48.0f, 36.0f);
                j.cubicTo(56.83692f, 36.0f, 64.0f, 43.16308f, 64.0f, 52.0f);
                j.cubicTo(64.0f, 60.83692f, 56.83692f, 68.0f, 48.0f, 68.0f);
                j.cubicTo(39.16308f, 68.0f, 32.0f, 60.83692f, 32.0f, 52.0f);
                j.cubicTo(32.0f, 43.16308f, 39.16308f, 36.0f, 48.0f, 36.0f);
                j.close();
                j.moveTo(58.0f, 52.0f);
                j.cubicTo(58.0f, 57.523f, 53.523f, 62.0f, 48.0f, 62.0f);
                j.cubicTo(42.477f, 62.0f, 38.0f, 57.523f, 38.0f, 52.0f);
                j.cubicTo(38.0f, 46.477f, 42.477f, 42.0f, 48.0f, 42.0f);
                j.cubicTo(53.523f, 42.0f, 58.0f, 46.477f, 58.0f, 52.0f);
                j.close();
                j.moveTo(18.0f, 27.0f);
                j.lineTo(27.0f, 27.0f);
                j.lineTo(27.0f, 30.0f);
                j.lineTo(18.0f, 30.0f);
                j.lineTo(18.0f, 27.0f);
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
