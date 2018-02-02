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

public final class abu extends c {
    private final int height = 165;
    private final int width = 165;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 165;
            case 1:
                return 165;
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
                i2.setColor(-4671304);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(165.0f, 83.51852f);
                j.cubicTo(165.0f, 36.935555f, 128.06444f, 0.0f, 81.48148f, 0.0f);
                j.cubicTo(36.935555f, 0.0f, 0.0f, 36.935555f, 0.0f, 83.51852f);
                j.cubicTo(0.0f, 128.06444f, 36.935555f, 165.0f, 81.48148f, 165.0f);
                j.cubicTo(128.06444f, 165.0f, 165.0f, 128.06444f, 165.0f, 83.51852f);
                j.close();
                j.moveTo(156.0f, 83.40741f);
                j.cubicTo(156.0f, 41.906223f, 123.09378f, 9.0f, 81.59259f, 9.0f);
                j.cubicTo(41.906223f, 9.0f, 9.0f, 41.906223f, 9.0f, 83.40741f);
                j.cubicTo(9.0f, 123.09378f, 41.906223f, 156.0f, 81.59259f, 156.0f);
                j.cubicTo(123.09378f, 156.0f, 156.0f, 123.09378f, 156.0f, 83.40741f);
                j.close();
                j.moveTo(81.06782f, 123.30645f);
                j.cubicTo(79.40914f, 123.30645f, 78.03121f, 121.96418f, 77.99018f, 120.31069f);
                j.lineTo(76.660355f, 66.71527f);
                j.cubicTo(76.6193f, 65.06076f, 77.919846f, 63.719513f, 79.586006f, 63.719513f);
                j.lineTo(85.413994f, 63.719513f);
                j.cubicTo(87.07084f, 63.719513f, 88.38068f, 65.06178f, 88.339645f, 66.71527f);
                j.lineTo(87.00982f, 120.31069f);
                j.cubicTo(86.968765f, 121.9652f, 85.58817f, 123.30645f, 83.93218f, 123.30645f);
                j.lineTo(81.06782f, 123.30645f);
                j.close();
                j.moveTo(82.5f, 41.693546f);
                j.cubicTo(86.41944f, 41.693546f, 89.59677f, 44.87088f, 89.59677f, 48.79032f);
                j.cubicTo(89.59677f, 52.709763f, 86.41944f, 55.887096f, 82.5f, 55.887096f);
                j.cubicTo(78.58056f, 55.887096f, 75.40323f, 52.709763f, 75.40323f, 48.79032f);
                j.cubicTo(75.40323f, 44.87088f, 78.58056f, 41.693546f, 82.5f, 41.693546f);
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
