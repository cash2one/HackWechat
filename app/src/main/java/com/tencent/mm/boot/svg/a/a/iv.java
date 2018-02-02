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

public final class iv extends c {
    private final int height = 102;
    private final int width = 102;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(51.0f, 102.0f);
                j.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                j.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                j.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                j.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                j.close();
                j.moveTo(51.0f, 98.0f);
                j.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                j.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                j.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                j.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(e, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 14.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(39.52522f, 40.28733f);
                j.lineTo(9.866667f, 40.28733f);
                j.lineTo(9.866667f, 44.853653f);
                j.cubicTo(9.866667f, 45.975304f, 10.76179f, 46.86199f, 11.865981f, 46.86199f);
                j.lineTo(37.883682f, 46.86199f);
                j.lineTo(36.885212f, 57.796623f);
                j.cubicTo(36.735928f, 59.43152f, 37.682396f, 59.961784f, 39.00135f, 58.95761f);
                j.lineTo(58.255604f, 44.29855f);
                j.cubicTo(61.15963f, 42.087593f, 60.55669f, 40.28733f, 56.896053f, 40.28733f);
                j.lineTo(39.52522f, 40.28733f);
                j.close();
                j.moveTo(32.008507f, 33.71267f);
                j.lineTo(61.99695f, 33.71267f);
                j.lineTo(61.99695f, 29.146349f);
                j.cubicTo(61.99695f, 28.024696f, 61.104416f, 27.138008f, 60.003418f, 27.138008f);
                j.lineTo(33.649654f, 27.138008f);
                j.lineTo(34.64812f, 16.203377f);
                j.cubicTo(34.797405f, 14.5684805f, 33.850937f, 14.038217f, 32.531982f, 15.04239f);
                j.lineTo(13.277731f, 29.701452f);
                j.cubicTo(10.373704f, 31.912409f, 10.9766445f, 33.71267f, 14.637279f, 33.71267f);
                j.lineTo(32.008507f, 33.71267f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
