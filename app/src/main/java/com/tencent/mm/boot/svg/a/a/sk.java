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

public final class sk extends c {
    private final int height = 54;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 54;
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
                e = c.a(e, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1.0513232f, 4.9491887f);
                j.cubicTo(0.73179597f, 3.1712198f, 1.9300232f, 0.9937079f, 3.9270685f, 1.1035824f);
                j.cubicTo(19.633831f, 0.9837193f, 35.35058f, 1.0836052f, 51.05734f, 1.0536394f);
                j.cubicTo(52.844696f, 0.724016f, 54.961563f, 1.9426237f, 54.901653f, 3.9103754f);
                j.cubicTo(55.041443f, 14.298506f, 54.931606f, 24.696625f, 54.951576f, 35.084755f);
                j.cubicTo(55.26112f, 36.872715f, 54.062893f, 39.09018f, 52.035892f, 38.960327f);
                j.cubicTo(42.370193f, 39.080193f, 32.694508f, 38.970318f, 23.028807f, 39.010273f);
                j.cubicTo(18.685234f, 41.99686f, 14.36163f, 45.003426f, 10.028042f, 48.0f);
                j.lineTo(10.028042f, 39.010273f);
                j.cubicTo(7.152297f, 38.59075f, 2.8187084f, 40.328766f, 1.2011017f, 37.05251f);
                j.cubicTo(0.83164823f, 26.36472f, 1.1312051f, 15.646965f, 1.0513232f, 4.9491887f);
                j.lineTo(1.0513232f, 4.9491887f);
                j.close();
                j.moveTo(7.0f, 7.0f);
                j.lineTo(7.0f, 33.0f);
                j.lineTo(15.0f, 33.0f);
                j.lineTo(15.0f, 38.0f);
                j.cubicTo(17.34f, 36.33f, 19.68f, 34.66f, 22.02f, 32.99f);
                j.cubicTo(31.01f, 33.01f, 40.01f, 33.0f, 49.0f, 33.0f);
                j.lineTo(49.0f, 7.0f);
                j.lineTo(7.0f, 7.0f);
                j.lineTo(7.0f, 7.0f);
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
