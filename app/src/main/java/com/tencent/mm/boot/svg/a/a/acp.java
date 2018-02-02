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

public final class acp extends c {
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
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(44.10407f, 48.572086f);
                j.lineTo(20.999926f, 35.23115f);
                j.cubicTo(19.958965f, 34.62973f, 19.004f, 35.25858f, 19.0f, 36.462433f);
                j.lineTo(19.004f, 62.93198f);
                j.cubicTo(19.0f, 64.13482f, 19.846968f, 65.615f, 20.88693f, 66.21947f);
                j.lineTo(44.10907f, 79.74022f);
                j.cubicTo(45.149033f, 80.345695f, 46.0f, 79.85603f, 46.0f, 78.65319f);
                j.lineTo(46.0f, 51.85246f);
                j.cubicTo(45.999f, 50.648605f, 45.14603f, 49.17249f, 44.10407f, 48.572086f);
                j.close();
                j.moveTo(73.216934f, 29.458399f);
                j.lineTo(50.073246f, 16.4451f);
                j.cubicTo(49.02697f, 15.856779f, 47.311195f, 15.850846f, 46.259857f, 16.432247f);
                j.lineTo(22.789015f, 29.413904f);
                j.cubicTo(21.738686f, 29.994316f, 21.73666f, 30.948486f, 22.784964f, 31.533842f);
                j.lineTo(46.14338f, 44.56098f);
                j.cubicTo(47.19168f, 45.14634f, 48.90745f, 45.14634f, 49.956768f, 44.56098f);
                j.lineTo(73.21288f, 31.591192f);
                j.cubicTo(74.261185f, 31.006824f, 74.2622f, 30.046722f, 73.216934f, 29.458399f);
                j.close();
                j.moveTo(76.997f, 36.350918f);
                j.cubicTo(77.001f, 35.14774f, 76.151f, 34.6553f, 75.11f, 35.256382f);
                j.lineTo(51.895f, 48.66497f);
                j.cubicTo(50.853f, 49.267067f, 50.0f, 50.74337f, 50.0f, 51.94655f);
                j.lineTo(50.0f, 78.64493f);
                j.cubicTo(50.0f, 79.84912f, 50.854f, 80.34461f, 51.898f, 79.74556f);
                j.lineTo(74.994f, 66.51567f);
                j.cubicTo(76.037f, 65.91763f, 76.996f, 64.287f, 77.0f, 63.082806f);
                j.lineTo(76.997f, 36.350918f);
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
