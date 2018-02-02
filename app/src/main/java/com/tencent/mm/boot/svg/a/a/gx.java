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

public final class gx extends c {
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
                i2.setColor(-8617851);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(48.0f, 80.0f);
                j.lineTo(44.0f, 76.0f);
                j.lineTo(48.0f, 64.0f);
                j.lineTo(52.0f, 76.0f);
                j.lineTo(48.0f, 80.0f);
                j.close();
                j.moveTo(78.666664f, 72.46489f);
                j.lineTo(78.666664f, 72.44444f);
                j.lineTo(58.234665f, 65.333336f);
                j.lineTo(58.666668f, 65.333336f);
                j.cubicTo(58.666668f, 65.333336f, 56.0f, 64.88355f, 56.0f, 62.666668f);
                j.lineTo(56.0f, 64.55556f);
                j.lineTo(56.0f, 64.55556f);
                j.lineTo(56.0f, 61.333332f);
                j.cubicTo(56.0f, 59.977333f, 57.333332f, 58.666668f, 57.333332f, 58.666668f);
                j.lineTo(57.319557f, 58.666668f);
                j.cubicTo(63.177776f, 54.190224f, 67.138664f, 45.516445f, 67.13022f, 35.05378f);
                j.cubicTo(67.11867f, 21.260445f, 58.55467f, 12.0f, 48.0f, 12.0f);
                j.cubicTo(37.44533f, 12.0f, 28.896444f, 21.260445f, 28.908f, 35.05378f);
                j.cubicTo(28.916445f, 45.514668f, 32.88978f, 54.189335f, 38.753777f, 58.666668f);
                j.lineTo(38.666668f, 58.666668f);
                j.cubicTo(38.666668f, 58.666668f, 40.0f, 59.977333f, 40.0f, 61.333332f);
                j.lineTo(40.0f, 62.666668f);
                j.cubicTo(40.0f, 64.88355f, 37.333332f, 65.333336f, 37.333332f, 65.333336f);
                j.lineTo(37.765335f, 65.333336f);
                j.lineTo(17.333334f, 72.44444f);
                j.lineTo(17.333334f, 72.46489f);
                j.cubicTo(14.228f, 73.564445f, 12.0f, 76.51822f, 12.0f, 80.0f);
                j.lineTo(12.0f, 84.0f);
                j.lineTo(84.0f, 84.0f);
                j.lineTo(84.0f, 80.0f);
                j.cubicTo(84.0f, 76.51822f, 81.77155f, 73.564445f, 78.666664f, 72.46489f);
                j.lineTo(78.666664f, 72.46489f);
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
