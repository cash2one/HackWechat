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

public final class ht extends c {
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
                j.moveTo(80.0f, 73.0f);
                j.lineTo(80.0f, 73.0f);
                j.lineTo(79.0f, 73.0f);
                j.cubicTo(79.29834f, 73.19833f, 79.27355f, 73.192024f, 79.0f, 73.0f);
                j.lineTo(57.0f, 67.0f);
                j.lineTo(57.0f, 62.0f);
                j.cubicTo(56.61111f, 60.643684f, 57.962963f, 59.314816f, 58.0f, 59.0f);
                j.lineTo(58.0f, 59.0f);
                j.cubicTo(63.88858f, 54.7762f, 67.90448f, 45.9815f, 68.0f, 35.0f);
                j.cubicTo(67.8842f, 21.389061f, 59.20126f, 12.0f, 49.0f, 12.0f);
                j.cubicTo(37.79874f, 12.0f, 29.131117f, 21.389061f, 29.0f, 35.0f);
                j.cubicTo(29.151396f, 45.98015f, 33.179913f, 54.775295f, 39.0f, 59.0f);
                j.lineTo(39.0f, 59.0f);
                j.cubicTo(39.037037f, 59.314816f, 40.38889f, 60.643684f, 40.0f, 62.0f);
                j.lineTo(40.0f, 65.0f);
                j.cubicTo(40.38889f, 66.18132f, 39.252434f, 66.882484f, 38.0f, 67.0f);
                j.lineTo(18.0f, 73.0f);
                j.cubicTo(17.725994f, 73.192024f, 17.70166f, 73.19833f, 18.0f, 73.0f);
                j.lineTo(17.0f, 73.0f);
                j.lineTo(17.0f, 73.0f);
                j.cubicTo(14.2589445f, 74.41951f, 12.0f, 77.41431f, 12.0f, 81.0f);
                j.lineTo(12.0f, 85.0f);
                j.lineTo(13.0f, 85.0f);
                j.lineTo(27.0f, 85.0f);
                j.lineTo(70.0f, 85.0f);
                j.lineTo(84.0f, 85.0f);
                j.lineTo(85.0f, 85.0f);
                j.lineTo(85.0f, 81.0f);
                j.cubicTo(85.0f, 77.41431f, 82.74061f, 74.41951f, 80.0f, 73.0f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
