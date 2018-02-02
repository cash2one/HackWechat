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

public final class mw extends c {
    private final int height = 240;
    private final int width = 240;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(114.11689f, 70.98039f);
                j.cubicTo(111.951485f, 70.98039f, 110.27686f, 72.72528f, 110.37761f, 74.90139f);
                j.lineTo(113.37151f, 139.56976f);
                j.cubicTo(113.42262f, 140.6737f, 114.36253f, 141.56863f, 115.46362f, 141.56863f);
                j.lineTo(124.53638f, 141.56863f);
                j.cubicTo(125.64071f, 141.56863f, 126.57727f, 140.67613f, 126.62849f, 139.56976f);
                j.lineTo(129.62239f, 74.90139f);
                j.cubicTo(129.72266f, 72.73588f, 128.0466f, 70.98039f, 125.88311f, 70.98039f);
                j.lineTo(114.11689f, 70.98039f);
                j.close();
                j.moveTo(120.0f, 172.94118f);
                j.cubicTo(125.41456f, 172.94118f, 129.80392f, 168.5518f, 129.80392f, 163.13725f);
                j.cubicTo(129.80392f, 157.7227f, 125.41456f, 153.33333f, 120.0f, 153.33333f);
                j.cubicTo(114.58544f, 153.33333f, 110.196075f, 157.7227f, 110.196075f, 163.13725f);
                j.cubicTo(110.196075f, 168.5518f, 114.58544f, 172.94118f, 120.0f, 172.94118f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 58.0f, 0.0f, 1.0f, 75.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-16139513);
                j = c.j(looper);
                j.moveTo(88.503105f, 63.260868f);
                j.cubicTo(81.83925f, 55.480328f, 72.46273f, 51.086956f, 62.509315f, 51.086956f);
                j.cubicTo(51.689445f, 51.086956f, 42.312923f, 55.480328f, 35.649067f, 63.260868f);
                j.lineTo(42.580746f, 70.21739f);
                j.cubicTo(47.99571f, 65.064156f, 54.781292f, 61.847816f, 62.509315f, 62.391304f);
                j.cubicTo(69.71429f, 61.847816f, 76.405556f, 64.96478f, 81.57143f, 70.21739f);
                j.lineTo(88.503105f, 63.260868f);
                j.close();
                j.moveTo(61.642857f, 25.869566f);
                j.cubicTo(44.52152f, 25.869566f, 28.799698f, 32.994526f, 17.453417f, 45.0f);
                j.lineTo(25.251553f, 52.826088f);
                j.cubicTo(35.159626f, 43.23779f, 48.249474f, 37.29962f, 62.509315f, 37.173912f);
                j.cubicTo(76.95079f, 37.29962f, 89.85206f, 43.048466f, 98.90062f, 51.95652f);
                j.lineTo(106.69876f, 45.0f);
                j.cubicTo(95.32615f, 33.14707f, 79.4547f, 25.869566f, 61.642857f, 25.869566f);
                j.close();
                j.moveTo(124.02795f, 26.73913f);
                j.cubicTo(108.21251f, 10.5176935f, 86.30065f, 0.65217394f, 62.509315f, 0.65217394f);
                j.cubicTo(37.861656f, 0.65217394f, 15.941242f, 10.526303f, 0.124223605f, 26.73913f);
                j.lineTo(7.9223604f, 34.565216f);
                j.cubicTo(22.125067f, 20.522926f, 41.417408f, 11.826344f, 62.509315f, 11.956522f);
                j.cubicTo(83.71855f, 11.826344f, 102.73295f, 20.24566f, 116.22981f, 33.695652f);
                j.lineTo(124.02795f, 26.73913f);
                j.close();
                j.moveTo(71.17391f, 80.652176f);
                j.cubicTo(68.97959f, 77.84855f, 65.76467f, 76.304344f, 62.509315f, 76.304344f);
                j.cubicTo(58.48254f, 76.304344f, 55.174686f, 77.95143f, 52.97826f, 80.652176f);
                j.lineTo(61.642857f, 89.347824f);
                j.lineTo(71.17391f, 80.652176f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                canvas.save();
                float[] a2 = c.a(e, 1.0f, 0.0f, 0.095238f, 0.0f, 1.0f, 0.652174f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
