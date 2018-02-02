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

public final class gg extends c {
    private final int height = 69;
    private final int width = 69;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 69;
            case 1:
                return 69;
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
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(41.076107f, 39.0f);
                j.lineTo(41.075874f, 39.00171f);
                j.lineTo(26.999348f, 38.992485f);
                j.cubicTo(26.693531f, 38.992287f, 26.404617f, 38.85216f, 26.21512f, 38.612133f);
                j.cubicTo(25.8729f, 38.178654f, 25.94688f, 37.549824f, 26.380358f, 37.207603f);
                j.lineTo(41.176712f, 25.526272f);
                j.cubicTo(41.389874f, 25.357986f, 41.66231f, 25.283638f, 41.931408f, 25.320316f);
                j.cubicTo(42.478634f, 25.394903f, 42.861782f, 25.898981f, 42.787193f, 26.446207f);
                j.lineTo(41.62131f, 35.0f);
                j.lineTo(59.995052f, 35.0f);
                j.cubicTo(61.102356f, 35.0f, 62.0f, 35.88773f, 62.0f, 37.0f);
                j.cubicTo(62.0f, 38.10457f, 61.102974f, 39.0f, 59.995052f, 39.0f);
                j.lineTo(41.076107f, 39.0f);
                j.close();
                j.moveTo(48.25757f, 43.016853f);
                j.lineTo(58.78785f, 43.02375f);
                j.cubicTo(59.093666f, 43.023952f, 59.382576f, 43.164078f, 59.572075f, 43.404106f);
                j.cubicTo(59.914295f, 43.837585f, 59.840317f, 44.466415f, 59.406837f, 44.808636f);
                j.lineTo(44.61048f, 56.489967f);
                j.cubicTo(44.39732f, 56.658253f, 44.12488f, 56.7326f, 43.855785f, 56.695923f);
                j.cubicTo(43.308563f, 56.621334f, 42.92541f, 56.117256f, 43.0f, 55.57003f);
                j.lineTo(44.1681f, 47.0f);
                j.lineTo(28.004946f, 47.0f);
                j.cubicTo(26.897646f, 47.0f, 26.0f, 46.11227f, 26.0f, 45.0f);
                j.cubicTo(26.0f, 43.89543f, 26.897026f, 43.0f, 28.004946f, 43.0f);
                j.lineTo(47.995052f, 43.0f);
                j.cubicTo(48.08403f, 43.0f, 48.171654f, 43.005733f, 48.25757f, 43.016853f);
                j.close();
                j.moveTo(57.0f, 31.0f);
                j.lineTo(53.0f, 31.0f);
                j.lineTo(53.0f, 18.0f);
                j.lineTo(13.0f, 18.0f);
                j.lineTo(13.0f, 50.0f);
                j.lineTo(37.96f, 50.0f);
                j.lineTo(37.32f, 54.0f);
                j.lineTo(12.0f, 54.0f);
                j.cubicTo(10.343145f, 54.0f, 9.0f, 52.656853f, 9.0f, 51.0f);
                j.lineTo(9.0f, 17.0f);
                j.lineTo(9.0f, 17.0f);
                j.cubicTo(9.0f, 15.343145f, 10.343145f, 14.0f, 12.0f, 14.0f);
                j.lineTo(12.0f, 14.0f);
                j.lineTo(54.0f, 14.0f);
                j.cubicTo(55.656853f, 14.0f, 57.0f, 15.343145f, 57.0f, 17.0f);
                j.lineTo(57.0f, 31.0f);
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
