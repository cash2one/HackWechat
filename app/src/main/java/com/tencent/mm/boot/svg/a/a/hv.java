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

public final class hv extends c {
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
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 10.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-13032);
                Path j = c.j(looper);
                j.moveTo(80.04755f, 28.325209f);
                j.lineTo(56.156776f, 25.964645f);
                j.cubicTo(54.329502f, 25.794123f, 53.919743f, 25.509708f, 53.34809f, 24.029768f);
                j.lineTo(43.131153f, 1.436689f);
                j.cubicTo(42.196808f, -0.47889635f, 40.668846f, -0.47889635f, 39.735756f, 1.436689f);
                j.lineTo(28.844881f, 24.029768f);
                j.cubicTo(28.10255f, 25.28193f, 27.759935f, 25.565722f, 25.960896f, 25.736866f);
                j.lineTo(2.8181033f, 28.325209f);
                j.cubicTo(0.69213665f, 28.536808f, 0.21711986f, 29.913439f, 1.76265f, 31.384047f);
                j.lineTo(19.921844f, 48.020016f);
                j.cubicTo(20.777754f, 48.817863f, 20.79156f, 49.157665f, 20.549345f, 50.254242f);
                j.lineTo(15.893301f, 74.66893f);
                j.cubicTo(15.499859f, 76.76437f, 16.692736f, 77.6033f, 18.542603f, 76.53722f);
                j.lineTo(39.269524f, 64.60993f);
                j.cubicTo(40.725323f, 63.699436f, 42.067543f, 63.672676f, 43.495102f, 64.55392f);
                j.lineTo(64.322426f, 76.53722f);
                j.cubicTo(66.173546f, 77.6033f, 67.37081f, 76.76189f, 66.98364f, 74.66831f);
                j.lineTo(63.421963f, 55.188213f);
                j.cubicTo(65.55483f, 54.46878f, 67.621185f, 53.588158f, 68.85673f, 52.591778f);
                j.lineTo(68.35536f, 52.689487f);
                j.cubicTo(66.16225f, 53.104595f, 64.444786f, 53.42386f, 63.106956f, 53.669064f);
                j.cubicTo(63.014088f, 52.996304f, 63.002163f, 52.988216f, 63.002163f, 52.988216f);
                j.lineTo(62.52464f, 50.28785f);
                j.cubicTo(62.335133f, 49.07365f, 62.52464f, 48.654808f, 63.44016f, 47.781654f);
                j.lineTo(81.07351f, 31.351685f);
                j.cubicTo(82.63599f, 29.90037f, 82.174774f, 28.536808f, 80.04755f, 28.325209f);
                j.lineTo(80.04755f, 28.325209f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(15.39444f, 33.37369f);
                j.cubicTo(15.39444f, 33.37369f, 37.508133f, 28.2163f, 62.77564f, 32.517963f);
                j.cubicTo(62.856586f, 32.531654f, 62.796974f, 32.706535f, 62.877293f, 32.72147f);
                j.cubicTo(62.877293f, 32.72147f, 55.036694f, 38.18817f, 47.961014f, 43.054306f);
                j.cubicTo(42.398235f, 46.880497f, 37.30796f, 50.276646f, 36.87248f, 50.75025f);
                j.cubicTo(36.87248f, 50.75025f, 36.560608f, 50.806263f, 36.962208f, 51.00666f);
                j.cubicTo(37.262154f, 51.156025f, 37.981266f, 51.21577f, 37.981266f, 51.21577f);
                j.cubicTo(37.981266f, 51.21577f, 56.060143f, 53.18239f, 68.62267f, 52.667084f);
                j.cubicTo(68.62267f, 52.667084f, 50.095764f, 58.072792f, 22.619463f, 54.425217f);
                j.cubicTo(22.619463f, 54.425217f, 22.295673f, 54.306347f, 22.56236f, 54.132713f);
                j.cubicTo(24.73037f, 52.718117f, 43.409134f, 39.430378f, 48.48435f, 35.899178f);
                j.cubicTo(48.48435f, 35.899178f, 48.836372f, 35.622856f, 48.522625f, 35.565598f);
                j.cubicTo(48.772995f, 35.611652f, 45.382618f, 34.984947f, 40.362f, 34.538727f);
                j.cubicTo(33.066067f, 33.89086f, 22.360306f, 33.546703f, 15.55759f, 33.412277f);
                j.cubicTo(15.4885645f, 33.409786f, 15.460955f, 33.37307f, 15.39444f, 33.37369f);
                j.lineTo(15.39444f, 33.37369f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
