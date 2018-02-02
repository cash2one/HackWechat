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

public final class gf extends c {
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
                a.setColor(-16139513);
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
                j.moveTo(32.582005f, 63.962925f);
                j.cubicTo(32.19982f, 63.567383f, 32.154182f, 62.887268f, 32.48211f, 62.44106f);
                j.lineTo(34.52614f, 59.65979f);
                j.cubicTo(34.853153f, 59.21483f, 35.480194f, 59.131527f, 35.906685f, 59.458405f);
                j.lineTo(50.22881f, 70.43549f);
                j.cubicTo(50.66425f, 70.76923f, 51.36269f, 70.752f, 51.77925f, 70.40497f);
                j.lineTo(87.55628f, 40.59981f);
                j.cubicTo(87.97712f, 40.249214f, 88.639626f, 40.282352f, 89.03474f, 40.672565f);
                j.lineTo(90.83008f, 42.44564f);
                j.cubicTo(91.22577f, 42.836422f, 91.23205f, 43.46271f, 90.83447f, 43.85398f);
                j.lineTo(51.728115f, 82.340485f);
                j.cubicTo(51.334854f, 82.72751f, 50.700047f, 82.714195f, 50.32405f, 82.325066f);
                j.lineTo(32.582005f, 63.962925f);
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
