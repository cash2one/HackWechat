package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class gv extends c {
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
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
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
                a.setColor(-8617851);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 10.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(20.0f, 65.0f);
                j.cubicTo(15.581831f, 65.0f, 12.0f, 61.418266f, 12.0f, 57.00022f);
                j.cubicTo(12.0f, 52.581734f, 15.581831f, 49.0f, 20.0f, 49.0f);
                j.cubicTo(24.418169f, 49.0f, 28.0f, 52.581734f, 28.0f, 57.00022f);
                j.cubicTo(28.0f, 61.418266f, 24.418169f, 65.0f, 20.0f, 65.0f);
                j.moveTo(75.81466f, 29.779163f);
                j.lineTo(47.19909f, 1.1844771f);
                j.cubicTo(45.618633f, -0.3948257f, 43.056522f, -0.3948257f, 41.476063f, 1.1844771f);
                j.lineTo(1.252038f, 41.379147f);
                j.cubicTo(0.3639593f, 42.26658f, -0.024743835f, 43.463757f, 0.08502881f, 44.62272f);
                j.lineTo(0.004948767f, 44.70319f);
                j.lineTo(0.0f, 76.91503f);
                j.lineTo(0.08502881f, 77.0f);
                j.cubicTo(5.8085027f, 77.0f, 23.96283f, 76.97392f, 32.275406f, 76.961334f);
                j.lineTo(32.376633f, 76.86018f);
                j.cubicTo(33.526546f, 76.95999f, 34.71065f, 76.57157f, 35.59063f, 75.69268f);
                j.lineTo(75.81466f, 35.49801f);
                j.cubicTo(77.39511f, 33.91871f, 77.39511f, 31.358015f, 75.81466f, 29.779163f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
