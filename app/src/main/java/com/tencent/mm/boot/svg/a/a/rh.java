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

public final class rh extends c {
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
                i2 = c.a(i2, looper);
                i2.setColor(-13824);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(21.0f, 54.0f);
                j.cubicTo(21.0f, 72.226f, 35.773f, 87.0f, 53.999f, 87.0f);
                j.cubicTo(72.225f, 87.0f, 87.0f, 72.226f, 87.0f, 54.0f);
                j.cubicTo(87.0f, 35.774f, 72.225f, 21.0f, 53.999f, 21.0f);
                j.cubicTo(35.773f, 21.0f, 21.0f, 35.774f, 21.0f, 54.0f);
                j.close();
                j.moveTo(68.0f, 37.0f);
                j.cubicTo(70.762f, 37.0f, 73.0f, 39.462f, 73.0f, 42.5f);
                j.cubicTo(73.0f, 45.538f, 70.762f, 48.0f, 68.0f, 48.0f);
                j.cubicTo(65.238f, 48.0f, 63.0f, 45.538f, 63.0f, 42.5f);
                j.cubicTo(63.0f, 39.462f, 65.238f, 37.0f, 68.0f, 37.0f);
                j.lineTo(68.0f, 37.0f);
                j.close();
                j.moveTo(41.0f, 37.0f);
                j.cubicTo(43.762f, 37.0f, 46.0f, 39.462f, 46.0f, 42.5f);
                j.cubicTo(46.0f, 45.538f, 43.762f, 48.0f, 41.0f, 48.0f);
                j.cubicTo(38.238f, 48.0f, 36.0f, 45.538f, 36.0f, 42.5f);
                j.cubicTo(36.0f, 39.462f, 38.238f, 37.0f, 41.0f, 37.0f);
                j.lineTo(41.0f, 37.0f);
                j.close();
                j.moveTo(54.0f, 77.0f);
                j.cubicTo(34.667f, 77.0f, 32.0f, 59.0f, 32.0f, 59.0f);
                j.cubicTo(32.0f, 59.0f, 46.361f, 57.0f, 54.0f, 57.0f);
                j.cubicTo(61.639f, 57.0f, 76.0f, 59.0f, 76.0f, 59.0f);
                j.cubicTo(76.0f, 59.0f, 73.333f, 77.0f, 54.0f, 77.0f);
                j.lineTo(54.0f, 77.0f);
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
