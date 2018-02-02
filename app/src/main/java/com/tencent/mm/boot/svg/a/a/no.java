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

public final class no extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-14187817);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(108.0f, 0.0f);
                j.lineTo(108.0f, 108.0f);
                j.lineTo(0.0f, 108.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(59.0f, 27.0f);
                j2.lineTo(80.0f, 27.0f);
                j2.cubicTo(81.327415f, 27.113115f, 82.9685f, 28.671097f, 83.0f, 30.0f);
                j2.lineTo(83.0f, 51.0f);
                j2.cubicTo(82.946f, 51.277657f, 82.61898f, 52.063435f, 81.5f, 52.5f);
                j2.lineTo(48.5f, 85.5f);
                j2.cubicTo(47.35823f, 87.322365f, 45.247627f, 87.3284f, 44.0f, 85.5f);
                j2.lineTo(24.5f, 66.0f);
                j2.cubicTo(23.321037f, 65.400536f, 22.99702f, 64.616264f, 23.0f, 63.0f);
                j2.cubicTo(23.00152f, 62.774742f, 23.328537f, 61.988964f, 24.5f, 61.5f);
                j2.lineTo(57.5f, 28.5f);
                j2.cubicTo(57.912754f, 27.405708f, 59.0f, 27.0f, 59.0f, 27.0f);
                j2.close();
                j2.moveTo(67.77778f, 36.0f);
                j2.cubicTo(70.865555f, 36.0f, 74.0f, 39.134445f, 74.0f, 43.77778f);
                j2.cubicTo(74.0f, 46.865555f, 70.865555f, 50.0f, 67.77778f, 50.0f);
                j2.cubicTo(63.134445f, 50.0f, 60.0f, 46.865555f, 60.0f, 43.77778f);
                j2.cubicTo(60.0f, 39.134445f, 63.134445f, 36.0f, 67.77778f, 36.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
