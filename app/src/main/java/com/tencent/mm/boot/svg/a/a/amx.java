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

public final class amx extends c {
    private final int height = 63;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                i2.setColor(-14624737);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(21.0f, 21.0f);
                j.lineTo(43.5f, 21.0f);
                j.lineTo(43.5f, 21.127842f);
                j.cubicTo(51.115696f, 22.108934f, 57.0f, 28.61729f, 57.0f, 36.5f);
                j.cubicTo(57.0f, 44.209316f, 51.37172f, 50.604076f, 44.0f, 51.79944f);
                j.lineTo(44.0f, 52.0f);
                j.lineTo(20.0f, 52.0f);
                j.lineTo(20.0f, 46.0f);
                j.lineTo(44.0f, 46.0f);
                j.lineTo(44.0f, 46.16791f);
                j.cubicTo(47.53181f, 44.624798f, 50.0f, 41.10064f, 50.0f, 37.0f);
                j.cubicTo(50.0f, 32.07876f, 46.445118f, 27.987804f, 41.763157f, 27.15494f);
                j.lineTo(41.763157f, 27.0f);
                j.lineTo(21.0f, 27.0f);
                j.lineTo(21.0f, 32.99984f);
                j.cubicTo(21.0f, 34.664913f, 19.933712f, 35.176052f, 18.61838f, 34.159657f);
                j.lineTo(6.88162f, 25.090343f);
                j.cubicTo(5.5572495f, 24.066965f, 5.5662875f, 22.42605f, 6.88162f, 21.409657f);
                j.lineTo(18.61838f, 12.3403425f);
                j.cubicTo(19.94275f, 11.316965f, 21.0f, 11.843217f, 21.0f, 13.500159f);
                j.lineTo(21.0f, 21.0f);
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
