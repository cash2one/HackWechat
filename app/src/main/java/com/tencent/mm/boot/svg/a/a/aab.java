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

public final class aab extends c {
    private final int height = 240;
    private final int width = 180;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
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
                i2 = c.a(i3, looper);
                i2.setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                a.setStrokeWidth(4.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 44.0f, 0.0f, 1.0f, 63.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 4.9965324f);
                j.cubicTo(0.0f, 3.3415933f, 1.3449905f, 2.0f, 2.9962382f, 2.0f);
                j.lineTo(60.00376f, 2.0f);
                j.cubicTo(61.65854f, 2.0f, 63.0f, 3.3373792f, 63.0f, 4.9965324f);
                j.lineTo(63.0f, 49.003468f);
                j.cubicTo(63.0f, 50.658405f, 61.65501f, 52.0f, 60.00376f, 52.0f);
                j.lineTo(2.9962382f, 52.0f);
                j.cubicTo(1.3414615f, 52.0f, 0.0f, 50.66262f, 0.0f, 49.003468f);
                j.lineTo(0.0f, 4.9965324f);
                j.close();
                j.moveTo(87.5f, 53.797123f);
                j.cubicTo(89.91545f, 54.568535f, 92.0f, 53.05244f, 92.0f, 50.732754f);
                j.lineTo(92.0f, 3.235053f);
                j.cubicTo(92.0f, 0.6385606f, 89.694824f, -0.4511346f, 87.5f, 0.17068519f);
                j.cubicTo(86.19809f, 1.3064651f, 75.559074f, 11.176803f, 68.0f, 18.05712f);
                j.lineTo(68.0f, 35.728115f);
                j.cubicTo(75.74342f, 42.702545f, 86.61983f, 52.864586f, 87.5f, 53.797123f);
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
