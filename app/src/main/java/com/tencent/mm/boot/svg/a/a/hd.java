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

public final class hd extends c {
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
                j.moveTo(77.0f, 40.0f);
                j.lineTo(77.0f, 48.0f);
                j.cubicTo(79.00536f, 48.166668f, 80.833336f, 49.995094f, 81.0f, 52.0f);
                j.lineTo(81.0f, 77.0f);
                j.cubicTo(80.833336f, 79.00536f, 79.00536f, 80.833336f, 77.0f, 81.0f);
                j.lineTo(52.0f, 81.0f);
                j.cubicTo(49.99464f, 80.833336f, 48.166668f, 79.00536f, 48.0f, 77.0f);
                j.lineTo(40.0f, 77.0f);
                j.cubicTo(40.0f, 83.51563f, 45.48437f, 89.0f, 52.0f, 89.0f);
                j.lineTo(77.0f, 89.0f);
                j.cubicTo(83.51563f, 89.0f, 89.0f, 83.51563f, 89.0f, 77.0f);
                j.lineTo(89.0f, 52.0f);
                j.cubicTo(89.0f, 45.48437f, 83.51563f, 40.0f, 77.0f, 40.0f);
                j.moveTo(16.0f, 57.0f);
                j.lineTo(16.0f, 20.0f);
                j.cubicTo(16.0f, 17.831364f, 17.831364f, 16.0f, 20.0f, 16.0f);
                j.lineTo(57.0f, 16.0f);
                j.cubicTo(59.168636f, 16.0f, 61.0f, 17.831364f, 61.0f, 20.0f);
                j.lineTo(61.0f, 57.0f);
                j.cubicTo(61.0f, 59.168636f, 59.168636f, 61.0f, 57.0f, 61.0f);
                j.lineTo(20.0f, 61.0f);
                j.cubicTo(17.831364f, 61.0f, 16.0f, 59.168636f, 16.0f, 57.0f);
                j.moveTo(69.0f, 57.0f);
                j.lineTo(69.0f, 20.0f);
                j.cubicTo(69.0f, 13.462437f, 63.538013f, 8.0f, 57.0f, 8.0f);
                j.lineTo(20.0f, 8.0f);
                j.cubicTo(13.461986f, 8.0f, 8.0f, 13.462437f, 8.0f, 20.0f);
                j.lineTo(8.0f, 57.0f);
                j.cubicTo(8.0f, 63.538013f, 13.461986f, 69.0f, 20.0f, 69.0f);
                j.lineTo(57.0f, 69.0f);
                j.cubicTo(63.538013f, 69.0f, 69.0f, 63.538013f, 69.0f, 57.0f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
