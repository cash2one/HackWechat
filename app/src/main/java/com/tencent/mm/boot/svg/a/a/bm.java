package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class bm extends c {
    private final int height = 80;
    private final int width = 80;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
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
                i2 = c.a(i3, looper);
                i2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                a.setStrokeWidth(4.0f);
                e = c.a(e, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 16.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(36.925568f, 47.054665f);
                j.cubicTo(56.11064f, 47.054665f, 71.45919f, 26.668798f, 71.45919f, 26.668798f);
                j.cubicTo(72.148895f, 25.817219f, 72.17743f, 24.403841f, 71.5037f, 23.523014f);
                j.cubicTo(71.5037f, 23.523014f, 55.69043f, 0.96764195f, 36.505352f, 0.96764195f);
                j.cubicTo(17.320274f, 0.96764195f, 1.4598377f, 23.541723f, 1.4598377f, 23.541723f);
                j.cubicTo(0.8014887f, 24.417181f, 0.84271175f, 25.819351f, 1.5628284f, 26.651388f);
                j.cubicTo(1.5628284f, 26.651388f, 17.740492f, 47.054665f, 36.925568f, 47.054665f);
                j.lineTo(36.925568f, 47.054665f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(22.42774f, 20.499218f);
                j.cubicTo(22.148413f, 21.58994f, 22.0f, 22.732264f, 22.0f, 23.908884f);
                j.cubicTo(22.0f, 31.55521f, 28.267693f, 37.75321f, 36.0f, 37.75321f);
                j.cubicTo(43.732307f, 37.75321f, 50.0f, 31.55521f, 50.0f, 23.908884f);
                j.cubicTo(50.0f, 16.262556f, 43.732307f, 10.064558f, 36.0f, 10.064558f);
                j.cubicTo(34.347454f, 10.064558f, 32.76181f, 10.347658f, 31.289946f, 10.867492f);
                j.lineTo(34.60256f, 20.195063f);
                j.lineTo(31.98528f, 23.138868f);
                j.lineTo(22.42774f, 20.499218f);
                j.lineTo(22.42774f, 20.499218f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
