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

public final class ala extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-723724);
                Path j = c.j(looper);
                j.moveTo(0.0f, 30.0f);
                j.cubicTo(0.0f, 13.4314575f, 13.4314575f, 0.0f, 30.0f, 0.0f);
                j.lineTo(30.0f, 0.0f);
                j.cubicTo(46.568542f, 0.0f, 60.0f, 13.4314575f, 60.0f, 30.0f);
                j.lineTo(60.0f, 30.0f);
                j.cubicTo(60.0f, 46.568542f, 46.568542f, 60.0f, 30.0f, 60.0f);
                j.lineTo(30.0f, 60.0f);
                j.cubicTo(13.4314575f, 60.0f, 0.0f, 46.568542f, 0.0f, 30.0f);
                j.lineTo(0.0f, 30.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-363518);
                float[] a2 = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(24.475742f, 18.70696f);
                j.cubicTo(23.12304f, 21.028156f, 19.575186f, 21.698137f, 16.551128f, 20.203268f);
                j.cubicTo(13.527069f, 18.70792f, 12.171762f, 15.61459f, 13.523946f, 13.292914f);
                j.cubicTo(14.876649f, 10.971719f, 18.425022f, 10.301737f, 21.449081f, 11.797086f);
                j.cubicTo(24.473139f, 13.291956f, 25.828445f, 16.385765f, 24.475742f, 18.70696f);
                j.moveTo(25.103931f, 10.635292f);
                j.cubicTo(18.385532f, 4.646929f, 8.63892f, 4.4326096f, 3.3347385f, 10.156823f);
                j.cubicTo(-1.969443f, 15.880552f, -0.82257956f, 25.375916f, 5.89582f, 31.364279f);
                j.cubicTo(12.614714f, 37.353127f, 22.360832f, 37.567448f, 27.665506f, 31.843233f);
                j.cubicTo(32.969196f, 26.119503f, 31.822824f, 16.62414f, 25.103931f, 10.635292f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(30.503237f, 0.13884006f);
                j.cubicTo(33.136944f, -0.56668025f, 35.94263f, 1.4859271f, 36.76932f, 4.722692f);
                j.cubicTo(37.59601f, 7.959457f, 36.13047f, 11.156124f, 33.49676f, 11.861136f);
                j.cubicTo(30.86256f, 12.566657f, 28.05737f, 10.514557f, 27.230679f, 7.2772846f);
                j.cubicTo(26.40399f, 4.0405197f, 27.86953f, 0.84486794f, 30.503237f, 0.13884006f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
