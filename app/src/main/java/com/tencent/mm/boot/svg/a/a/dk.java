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

public final class dk extends c {
    private final int height = 80;
    private final int width = 84;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 80;
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
                a.setColor(-13882324);
                e = c.a(e, 1.0f, 0.0f, -1347.0f, 0.0f, 1.0f, -215.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 1250.0f, 0.0f, 1.0f, 215.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(131.0f, 51.0f);
                j.lineTo(131.0f, 64.0f);
                j.cubicTo(131.0f, 65.044205f, 132.50389f, 66.62656f, 134.0f, 66.0f);
                j.lineTo(158.0f, 66.0f);
                j.lineTo(169.0f, 76.0f);
                j.cubicTo(169.0921f, 76.41986f, 169.86208f, 76.09059f, 170.0f, 74.0f);
                j.lineTo(170.0f, 66.0f);
                j.lineTo(177.0f, 66.0f);
                j.cubicTo(178.48862f, 66.62656f, 180.0f, 65.03394f, 180.0f, 64.0f);
                j.lineTo(180.0f, 29.0f);
                j.cubicTo(180.0f, 27.582346f, 178.4798f, 26.0f, 177.0f, 26.0f);
                j.lineTo(156.0f, 26.0f);
                j.lineTo(156.0f, 46.0f);
                j.cubicTo(154.65517f, 48.362537f, 152.38159f, 50.729206f, 150.0f, 51.0f);
                j.lineTo(131.0f, 51.0f);
                j.close();
                j.moveTo(149.02345f, 4.0f);
                j.cubicTo(150.66736f, 4.0f, 152.0f, 5.334057f, 152.0f, 6.97253f);
                j.lineTo(152.0f, 44.02747f);
                j.cubicTo(152.0f, 45.66915f, 150.66797f, 47.0f, 149.02759f, 47.0f);
                j.lineTo(121.0f, 47.0f);
                j.lineTo(110.64339f, 55.630512f);
                j.cubicTo(109.73577f, 56.38686f, 109.0f, 56.041157f, 109.0f, 54.854748f);
                j.lineTo(109.0f, 47.0f);
                j.lineTo(99.96629f, 47.0f);
                j.cubicTo(98.32806f, 47.0f, 97.0f, 45.665943f, 97.0f, 44.02747f);
                j.lineTo(97.0f, 6.97253f);
                j.cubicTo(97.0f, 5.330847f, 98.332306f, 4.0f, 99.97654f, 4.0f);
                j.lineTo(149.02345f, 4.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
