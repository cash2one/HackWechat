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

public final class aby extends c {
    private final int height = 52;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 52;
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
                e = c.a(e, 1.0f, 0.0f, -8.0f, 0.0f, 1.0f, -6.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(24.80435f, 38.659184f);
                j.cubicTo(24.637218f, 38.487045f, 24.6045f, 38.174816f, 24.726532f, 37.968803f);
                j.lineTo(25.386211f, 36.854485f);
                j.cubicTo(25.510012f, 36.644806f, 25.781488f, 36.56881f, 25.990181f, 36.682346f);
                j.lineTo(30.773296f, 39.283638f);
                j.cubicTo(31.195103f, 39.513462f, 31.854782f, 39.464016f, 32.22972f, 39.1875f);
                j.lineTo(45.16686f, 29.642105f);
                j.cubicTo(45.357864f, 29.501099f, 45.648796f, 29.51758f, 45.827423f, 29.688803f);
                j.lineTo(46.070602f, 29.922287f);
                j.cubicTo(46.24481f, 30.08893f, 46.248344f, 30.366365f, 46.0821f, 30.538502f);
                j.lineTo(32.136868f, 44.987984f);
                j.cubicTo(31.805262f, 45.331345f, 31.269382f, 45.33409f, 30.92451f, 44.977913f);
                j.lineTo(24.80435f, 38.659184f);
                j.close();
                j.moveTo(12.888889f, 32.348488f);
                j.cubicTo(12.644444f, 32.348488f, 12.444445f, 32.550213f, 12.444445f, 32.796764f);
                j.lineTo(12.444445f, 52.988007f);
                j.cubicTo(12.444445f, 53.237247f, 12.636444f, 53.43449f, 12.881778f, 53.436283f);
                j.cubicTo(19.092443f, 53.477524f, 37.99289f, 53.602146f, 40.093334f, 53.425526f);
                j.cubicTo(42.373333f, 53.23366f, 45.365334f, 52.000904f, 46.518223f, 51.02725f);
                j.cubicTo(52.352f, 46.09711f, 51.52178f, 32.061592f, 50.393776f, 29.480421f);
                j.cubicTo(49.748444f, 28.0038f, 46.894222f, 27.45511f, 45.588444f, 27.417456f);
                j.cubicTo(45.08889f, 27.41656f, 43.112f, 27.308973f, 41.523556f, 25.757938f);
                j.cubicTo(40.651554f, 24.90711f, 39.612446f, 23.31842f, 39.612446f, 20.58125f);
                j.cubicTo(39.612446f, 16.276007f, 39.393776f, 13.897455f, 38.152f, 12.019179f);
                j.cubicTo(37.90489f, 11.644421f, 36.045334f, 10.231455f, 34.06222f, 11.176421f);
                j.cubicTo(33.340443f, 11.520697f, 33.217777f, 12.341938f, 33.112f, 15.418903f);
                j.cubicTo(33.096f, 15.881524f, 33.079113f, 16.366558f, 33.05511f, 16.874903f);
                j.cubicTo(32.905777f, 20.137455f, 32.761776f, 21.871386f, 32.098667f, 23.672558f);
                j.cubicTo(31.076445f, 26.449179f, 29.518223f, 28.351662f, 27.046223f, 29.838144f);
                j.cubicTo(25.94489f, 30.4998f, 24.438223f, 31.40711f, 22.61511f, 31.817732f);
                j.cubicTo(20.514668f, 32.292904f, 18.948444f, 32.348488f, 17.953777f, 32.348488f);
                j.lineTo(12.888889f, 32.348488f);
                j.close();
                j.moveTo(31.533333f, 57.99973f);
                j.cubicTo(26.16711f, 57.99973f, 19.216888f, 57.96028f, 12.852445f, 57.91904f);
                j.cubicTo(10.176888f, 57.90111f, 8.0f, 55.68842f, 8.0f, 52.988007f);
                j.lineTo(8.0f, 32.796764f);
                j.cubicTo(8.0f, 30.07842f, 10.193778f, 27.86573f, 12.888889f, 27.86573f);
                j.lineTo(17.953777f, 27.86573f);
                j.cubicTo(18.803556f, 27.86573f, 19.990223f, 27.817318f, 21.644444f, 27.443455f);
                j.cubicTo(22.773333f, 27.188835f, 23.88f, 26.523594f, 24.769777f, 25.987455f);
                j.cubicTo(26.107555f, 25.183249f, 27.158222f, 24.21587f, 27.932444f, 22.111662f);
                j.cubicTo(28.355556f, 20.963179f, 28.473778f, 19.74387f, 28.616f, 16.666903f);
                j.cubicTo(28.63911f, 16.176489f, 28.654222f, 15.708489f, 28.670221f, 15.2638f);
                j.cubicTo(28.786667f, 11.879317f, 28.896f, 8.682214f, 32.161777f, 7.1240067f);
                j.lineTo(32.162666f, 7.1240067f);
                j.cubicTo(36.176888f, 5.2089725f, 40.366222f, 7.2907653f, 41.84889f, 9.531248f);
                j.cubicTo(43.716446f, 12.353593f, 44.05689f, 15.466421f, 44.05689f, 20.58125f);
                j.cubicTo(44.05689f, 21.225868f, 44.153778f, 22.087456f, 44.614223f, 22.537523f);
                j.cubicTo(44.981335f, 22.894352f, 45.532444f, 22.935593f, 45.538666f, 22.935593f);
                j.lineTo(45.539555f, 22.935593f);
                j.lineTo(45.595554f, 22.9338f);
                j.lineTo(45.651554f, 22.934696f);
                j.cubicTo(46.34667f, 22.948145f, 52.499557f, 23.185732f, 54.460445f, 27.671179f);
                j.cubicTo(56.191113f, 31.631248f, 57.154667f, 47.886627f, 49.372444f, 54.462833f);
                j.cubicTo(47.397335f, 56.132214f, 43.484444f, 57.63842f, 40.46311f, 57.892143f);
                j.cubicTo(39.526222f, 57.971043f, 36.10311f, 57.99973f, 31.533333f, 57.99973f);
                j.lineTo(31.533333f, 57.99973f);
                j.close();
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
