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

public final class afz extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(59.0f, 65.0f);
                j.lineTo(73.0f, 65.0f);
                j.lineTo(73.0f, 56.0f);
                j.lineTo(78.0f, 56.0f);
                j.lineTo(78.0f, 40.0f);
                j.lineTo(73.0f, 40.0f);
                j.lineTo(73.0f, 31.0f);
                j.lineTo(59.0f, 31.0f);
                j.lineTo(59.0f, 25.0f);
                j.lineTo(38.0f, 25.0f);
                j.lineTo(38.0f, 31.0f);
                j.lineTo(23.0f, 31.0f);
                j.lineTo(23.0f, 40.0f);
                j.lineTo(18.0f, 40.0f);
                j.lineTo(18.0f, 56.0f);
                j.lineTo(23.0f, 56.0f);
                j.lineTo(23.0f, 65.0f);
                j.lineTo(38.0f, 65.0f);
                j.lineTo(38.0f, 71.0f);
                j.lineTo(59.0f, 71.0f);
                j.lineTo(59.0f, 65.0f);
                j.close();
                j.moveTo(18.0f, 28.000444f);
                j.cubicTo(18.0f, 26.343344f, 19.337309f, 25.0f, 20.995937f, 25.0f);
                j.lineTo(75.00406f, 25.0f);
                j.cubicTo(76.658676f, 25.0f, 78.0f, 26.35178f, 78.0f, 28.000444f);
                j.lineTo(78.0f, 67.99956f);
                j.cubicTo(78.0f, 69.656654f, 76.66269f, 71.0f, 75.00406f, 71.0f);
                j.lineTo(20.995937f, 71.0f);
                j.cubicTo(19.341328f, 71.0f, 18.0f, 69.64822f, 18.0f, 67.99956f);
                j.lineTo(18.0f, 28.000444f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                i2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(37.75862f, 45.672413f);
                j2.lineTo(36.0f, 49.189655f);
                j2.lineTo(43.91379f, 58.86207f);
                j2.lineTo(61.5f, 37.75862f);
                j2.lineTo(59.74138f, 36.0f);
                j2.lineTo(43.91379f, 50.948277f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
