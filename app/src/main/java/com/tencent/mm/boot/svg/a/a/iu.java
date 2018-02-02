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

public final class iu extends c {
    private final int height = 102;
    private final int width = 102;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                j.moveTo(51.0f, 102.0f);
                j.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                j.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                j.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                j.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                j.lineTo(51.0f, 102.0f);
                j.close();
                j.moveTo(51.0f, 98.0f);
                j.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                j.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                j.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                j.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                j.lineTo(51.0f, 98.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(60.046738f, 37.910957f);
                j.cubicTo(69.13362f, 37.910957f, 76.5f, 45.204285f, 76.5f, 54.20548f);
                j.cubicTo(76.5f, 63.204693f, 69.13489f, 70.5f, 60.046738f, 70.5f);
                j.lineTo(29.047552f, 70.5f);
                j.cubicTo(28.745148f, 70.5f, 28.5f, 70.25656f, 28.5f, 69.968216f);
                j.lineTo(28.5f, 65.68932f);
                j.cubicTo(28.5f, 65.39562f, 28.735804f, 65.15753f, 29.047586f, 65.15753f);
                j.lineTo(60.048687f, 65.15753f);
                j.cubicTo(66.152725f, 65.15753f, 71.10674f, 60.25413f, 71.10674f, 54.20548f);
                j.cubicTo(71.10674f, 48.1555f, 66.15588f, 43.253426f, 60.048687f, 43.253426f);
                j.lineTo(40.83506f, 43.253426f);
                j.lineTo(40.83506f, 48.97156f);
                j.cubicTo(40.83506f, 49.56155f, 40.448963f, 49.755066f, 39.972683f, 49.402626f);
                j.lineTo(28.857897f, 41.177834f);
                j.cubicTo(28.379784f, 40.82404f, 28.38162f, 40.253983f, 28.857897f, 39.901543f);
                j.lineTo(39.972683f, 31.676752f);
                j.cubicTo(40.450798f, 31.322954f, 40.83506f, 31.517307f, 40.83506f, 32.107815f);
                j.lineTo(40.83506f, 37.910957f);
                j.lineTo(60.046738f, 37.910957f);
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
