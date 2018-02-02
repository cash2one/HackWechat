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

public final class bc extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-10197008);
                Path j = c.j(looper);
                j.moveTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.lineTo(68.0f, 87.0f);
                j.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                j.lineTo(3.0f, 90.0f);
                j.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                j.lineTo(0.0f, 3.0f);
                j.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                j.lineTo(46.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                j = c.j(looper);
                j.moveTo(68.0f, 22.0f);
                j.lineTo(49.0f, 22.0f);
                j.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                j.lineTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.close();
                canvas.saveLayerAlpha(null, 51, 4);
                i3 = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(46.252487f, 44.839684f);
                j.lineTo(26.667143f, 48.85265f);
                j.lineTo(26.667143f, 66.858986f);
                j.lineTo(26.667143f, 68.5715f);
                j.cubicTo(26.667143f, 70.166306f, 25.580133f, 71.72134f, 24.118086f, 72.391304f);
                j.cubicTo(23.846298f, 72.51585f, 22.129362f, 72.89289f, 21.905174f, 72.9372f);
                j.cubicTo(19.751049f, 73.36299f, 18.095936f, 71.55011f, 18.004787f, 69.71689f);
                j.cubicTo(17.913637f, 67.88367f, 19.13724f, 66.35503f, 20.556929f, 66.07441f);
                j.lineTo(22.858772f, 65.61942f);
                j.cubicTo(24.065191f, 65.38096f, 24.934671f, 64.32279f, 24.934671f, 63.09303f);
                j.lineTo(24.934671f, 46.618843f);
                j.cubicTo(24.935736f, 46.618027f, 24.936798f, 46.617214f, 24.93786f, 46.6164f);
                j.lineTo(24.93786f, 45.481544f);
                j.cubicTo(24.93786f, 44.873074f, 25.365826f, 44.34853f, 25.961914f, 44.226395f);
                j.lineTo(46.461594f, 40.026085f);
                j.cubicTo(47.154797f, 39.88405f, 47.83189f, 40.330856f, 47.973923f, 41.02406f);
                j.cubicTo(47.991264f, 41.10869f, 48.0f, 41.19485f, 48.0f, 41.28124f);
                j.lineTo(48.0f, 44.02073f);
                j.lineTo(48.0f, 62.217106f);
                j.lineTo(48.0f, 63.929623f);
                j.cubicTo(48.0f, 65.52442f, 46.903553f, 67.07946f, 45.42881f, 67.74942f);
                j.cubicTo(45.15466f, 67.87396f, 43.422817f, 68.251015f, 43.196682f, 68.29533f);
                j.cubicTo(41.023853f, 68.721115f, 39.35437f, 66.908226f, 39.26243f, 65.075005f);
                j.cubicTo(39.170486f, 63.241783f, 40.404713f, 61.713146f, 41.836727f, 61.432526f);
                j.lineTo(44.172447f, 60.97482f);
                j.cubicTo(45.380814f, 60.738026f, 46.252487f, 59.67896f, 46.252487f, 58.447613f);
                j.lineTo(46.252487f, 44.839684f);
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
