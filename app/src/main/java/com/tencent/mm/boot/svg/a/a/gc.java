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

public final class gc extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-564640);
                Path j = c.j(looper);
                j.moveTo(115.8f, 60.68889f);
                j.cubicTo(115.8f, 29.181868f, 90.81813f, 4.2f, 59.31111f, 4.2f);
                j.cubicTo(29.181868f, 4.2f, 4.2f, 29.181868f, 4.2f, 60.68889f);
                j.cubicTo(4.2f, 90.81813f, 29.181868f, 115.8f, 59.31111f, 115.8f);
                j.cubicTo(90.81813f, 115.8f, 115.8f, 90.81813f, 115.8f, 60.68889f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(57.790684f, 34.2f);
                j.lineTo(62.209316f, 34.2f);
                j.cubicTo(63.301052f, 34.2f, 64.16696f, 35.09441f, 64.12621f, 36.197716f);
                j.lineTo(62.836727f, 71.10812f);
                j.cubicTo(62.816696f, 71.650375f, 62.35176f, 72.10244f, 61.798832f, 72.10244f);
                j.lineTo(58.201168f, 72.10244f);
                j.cubicTo(57.639423f, 72.10244f, 57.183556f, 71.65727f, 57.163273f, 71.10812f);
                j.lineTo(55.87379f, 36.197716f);
                j.cubicTo(55.833225f, 35.099537f, 56.691257f, 34.2f, 57.790684f, 34.2f);
                j.close();
                j.moveTo(60.0f, 85.8f);
                j.cubicTo(57.680405f, 85.8f, 55.8f, 83.91959f, 55.8f, 81.6f);
                j.cubicTo(55.8f, 79.2804f, 57.680405f, 77.4f, 60.0f, 77.4f);
                j.cubicTo(62.319595f, 77.4f, 64.2f, 79.2804f, 64.2f, 81.6f);
                j.cubicTo(64.2f, 83.91959f, 62.319595f, 85.8f, 60.0f, 85.8f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
