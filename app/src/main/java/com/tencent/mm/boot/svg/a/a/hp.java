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

public final class hp extends c {
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
                j.moveTo(87.0f, 26.0f);
                j.lineTo(81.0f, 32.0f);
                j.cubicTo(80.87885f, 32.277943f, 80.9f, 32.483356f, 81.0f, 33.0f);
                j.lineTo(81.0f, 65.0f);
                j.cubicTo(80.9f, 67.14137f, 79.08695f, 68.94447f, 77.0f, 69.0f);
                j.lineTo(20.0f, 69.0f);
                j.cubicTo(17.91305f, 68.94447f, 16.1f, 67.14137f, 16.0f, 65.0f);
                j.lineTo(16.0f, 33.0f);
                j.cubicTo(16.1f, 32.483356f, 16.12115f, 32.277943f, 16.0f, 32.0f);
                j.lineTo(10.0f, 26.0f);
                j.cubicTo(8.75645f, 27.917215f, 8.0f, 30.216175f, 8.0f, 33.0f);
                j.lineTo(8.0f, 65.0f);
                j.cubicTo(8.0f, 71.59026f, 13.4396f, 77.0f, 20.0f, 77.0f);
                j.lineTo(77.0f, 77.0f);
                j.cubicTo(83.5604f, 77.0f, 89.0f, 71.59026f, 89.0f, 65.0f);
                j.lineTo(89.0f, 33.0f);
                j.cubicTo(89.0f, 30.216175f, 88.24355f, 27.917215f, 87.0f, 26.0f);
                j.moveTo(17.0f, 22.0f);
                j.lineTo(24.0f, 29.0f);
                j.lineTo(24.0f, 29.0f);
                j.lineTo(49.0f, 53.0f);
                j.lineTo(73.0f, 29.0f);
                j.lineTo(73.0f, 29.0f);
                j.lineTo(80.0f, 22.0f);
                j.cubicTo(80.48633f, 21.519585f, 80.48227f, 21.517807f, 80.0f, 22.0f);
                j.lineTo(81.0f, 21.0f);
                j.lineTo(77.0f, 21.0f);
                j.cubicTo(77.00033f, 21.002222f, 76.96873f, 21.0f, 77.0f, 21.0f);
                j.lineTo(20.0f, 21.0f);
                j.cubicTo(20.031721f, 21.0f, 20.000126f, 21.002222f, 20.0f, 21.0f);
                j.lineTo(16.0f, 21.0f);
                j.lineTo(17.0f, 22.0f);
                j.cubicTo(16.517733f, 21.517807f, 16.514122f, 21.519585f, 17.0f, 22.0f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
