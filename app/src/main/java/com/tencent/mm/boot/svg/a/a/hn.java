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

public final class hn extends c {
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
                j.moveTo(69.0f, 73.0f);
                j.cubicTo(69.0f, 75.18871f, 67.16411f, 77.0f, 65.0f, 77.0f);
                j.lineTo(57.0f, 77.0f);
                j.lineTo(57.0f, 57.0f);
                j.lineTo(40.0f, 57.0f);
                j.lineTo(40.0f, 77.0f);
                j.lineTo(32.0f, 77.0f);
                j.cubicTo(29.835434f, 77.0f, 28.0f, 75.18871f, 28.0f, 73.0f);
                j.lineTo(28.0f, 38.0f);
                j.lineTo(49.0f, 18.0f);
                j.lineTo(69.0f, 38.0f);
                j.lineTo(69.0f, 73.0f);
                j.close();
                j.moveTo(52.0f, 9.0f);
                j.lineTo(52.0f, 9.0f);
                j.cubicTo(50.78988f, 8.532246f, 49.708397f, 8.0f, 49.0f, 8.0f);
                j.cubicTo(47.291603f, 8.0f, 46.21012f, 8.532246f, 45.0f, 9.0f);
                j.lineTo(45.0f, 9.0f);
                j.lineTo(8.0f, 47.0f);
                j.lineTo(14.0f, 53.0f);
                j.lineTo(20.0f, 46.0f);
                j.lineTo(20.0f, 73.0f);
                j.cubicTo(20.146534f, 79.55686f, 25.5868f, 85.0f, 32.0f, 85.0f);
                j.lineTo(40.0f, 85.0f);
                j.lineTo(57.0f, 85.0f);
                j.lineTo(65.0f, 85.0f);
                j.cubicTo(71.4132f, 85.0f, 76.85346f, 79.55686f, 77.0f, 73.0f);
                j.lineTo(77.0f, 46.0f);
                j.lineTo(83.0f, 53.0f);
                j.lineTo(89.0f, 47.0f);
                j.lineTo(52.0f, 9.0f);
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
