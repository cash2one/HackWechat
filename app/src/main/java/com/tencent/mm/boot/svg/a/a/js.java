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

public final class js extends c {
    private final int height = 294;
    private final int width = 300;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 300;
            case 1:
                return 294;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-657931);
                Path j = c.j(looper);
                j.moveTo(0.0f, 15.00912f);
                j.cubicTo(0.0f, 6.719812f, 6.722175f, 0.0f, 15.005396f, 0.0f);
                j.lineTo(284.9946f, 0.0f);
                j.cubicTo(293.28186f, 0.0f, 300.0f, 6.710611f, 300.0f, 15.00912f);
                j.lineTo(300.0f, 278.99088f);
                j.cubicTo(300.0f, 287.28018f, 293.27783f, 294.0f, 284.9946f, 294.0f);
                j.lineTo(15.005396f, 294.0f);
                j.cubicTo(6.718145f, 294.0f, 0.0f, 287.2894f, 0.0f, 278.99088f);
                j.lineTo(0.0f, 15.00912f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(e, 1.0f, 0.0f, 64.0f, 0.0f, 1.0f, 83.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(a, looper);
                a4.setColor(-3552823);
                a4.setStrokeWidth(20.0f);
                j = c.j(looper);
                j.moveTo(0.0f, 2.0f);
                j.cubicTo(0.0f, 0.89543045f, 0.89543045f, 0.0f, 2.0f, 0.0f);
                j.lineTo(163.0f, 0.0f);
                j.cubicTo(164.10457f, 0.0f, 165.0f, 0.89543045f, 165.0f, 2.0f);
                j.lineTo(165.0f, 118.0f);
                j.cubicTo(165.0f, 119.10457f, 164.10457f, 120.0f, 163.0f, 120.0f);
                j.lineTo(2.0f, 120.0f);
                j.cubicTo(0.89543045f, 120.0f, 0.0f, 119.10457f, 0.0f, 118.0f);
                j.lineTo(0.0f, 2.0f);
                j.close();
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-3552823);
                Path j2 = c.j(looper);
                j2.moveTo(126.73595f, 64.14897f);
                j2.lineTo(103.837265f, 81.98572f);
                j2.lineTo(111.876335f, 98.63208f);
                j2.lineTo(55.73088f, 46.75f);
                j2.lineTo(2.75f, 96.57307f);
                j2.lineTo(2.75f, 119.245766f);
                j2.lineTo(162.59375f, 119.245766f);
                j2.lineTo(162.59375f, 96.57307f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, i3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
