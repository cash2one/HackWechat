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

public final class dl extends c {
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, -1250.0f, 0.0f, 1.0f, -215.0f);
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
                j.moveTo(34.0f, 51.0f);
                j.lineTo(34.0f, 64.0f);
                j.cubicTo(34.0f, 65.044205f, 35.50389f, 66.62656f, 37.0f, 66.0f);
                j.lineTo(61.0f, 66.0f);
                j.lineTo(72.0f, 76.0f);
                j.cubicTo(72.0921f, 76.41986f, 72.86207f, 76.09059f, 73.0f, 74.0f);
                j.lineTo(73.0f, 66.0f);
                j.lineTo(80.0f, 66.0f);
                j.cubicTo(81.48861f, 66.62656f, 83.0f, 65.03394f, 83.0f, 64.0f);
                j.lineTo(83.0f, 29.0f);
                j.cubicTo(83.0f, 27.582346f, 81.4798f, 26.0f, 80.0f, 26.0f);
                j.lineTo(59.0f, 26.0f);
                j.lineTo(59.0f, 46.0f);
                j.cubicTo(57.655174f, 48.362537f, 55.381588f, 50.729206f, 53.0f, 51.0f);
                j.lineTo(34.0f, 51.0f);
                j.close();
                j.moveTo(52.02346f, 4.0f);
                j.cubicTo(53.66736f, 4.0f, 55.0f, 5.334057f, 55.0f, 6.97253f);
                j.lineTo(55.0f, 44.02747f);
                j.cubicTo(55.0f, 45.66915f, 53.66797f, 47.0f, 52.027588f, 47.0f);
                j.lineTo(24.0f, 47.0f);
                j.lineTo(13.643388f, 55.630512f);
                j.cubicTo(12.735769f, 56.38686f, 12.0f, 56.041157f, 12.0f, 54.854748f);
                j.lineTo(12.0f, 47.0f);
                j.lineTo(2.9662929f, 47.0f);
                j.cubicTo(1.3280545f, 47.0f, 0.0f, 45.665943f, 0.0f, 44.02747f);
                j.lineTo(0.0f, 6.97253f);
                j.cubicTo(0.0f, 5.330847f, 1.332306f, 4.0f, 2.97654f, 4.0f);
                j.lineTo(52.02346f, 4.0f);
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
