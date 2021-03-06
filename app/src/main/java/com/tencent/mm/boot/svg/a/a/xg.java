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

public final class xg extends c {
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
                j.moveTo(36.0f, 14.048469f);
                j.lineTo(36.0f, 22.694517f);
                j.cubicTo(26.54021f, 27.188381f, 20.0f, 36.830418f, 20.0f, 48.0f);
                j.cubicTo(20.0f, 63.463974f, 32.536026f, 76.0f, 48.0f, 76.0f);
                j.cubicTo(63.463974f, 76.0f, 76.0f, 63.463974f, 76.0f, 48.0f);
                j.cubicTo(76.0f, 36.830418f, 69.45979f, 27.188381f, 60.0f, 22.694525f);
                j.lineTo(60.0f, 14.048469f);
                j.cubicTo(73.98231f, 18.990505f, 84.0f, 32.325375f, 84.0f, 48.0f);
                j.cubicTo(84.0f, 67.88225f, 67.88225f, 84.0f, 48.0f, 84.0f);
                j.cubicTo(28.117748f, 84.0f, 12.0f, 67.88225f, 12.0f, 48.0f);
                j.cubicTo(12.0f, 32.325375f, 22.01769f, 18.990505f, 36.0f, 14.048469f);
                j.close();
                j.moveTo(44.0f, 6.0f);
                j.lineTo(52.0f, 6.0f);
                j.lineTo(52.0f, 48.0f);
                j.lineTo(44.0f, 48.0f);
                j.lineTo(44.0f, 6.0f);
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
