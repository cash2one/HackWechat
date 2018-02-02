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

public final class ff extends c {
    private final int height = 100;
    private final int width = 100;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                a.setColor(-9473160);
                a.setStrokeWidth(6.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 59.0f, 0.0f, 1.0f, 38.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 1.9734219f);
                j.cubicTo(0.0f, 0.8835311f, 0.8835311f, 0.0f, 1.9734219f, 0.0f);
                j.lineTo(28.026579f, 0.0f);
                j.cubicTo(29.11647f, 0.0f, 30.0f, 0.8835311f, 30.0f, 1.9734219f);
                j.lineTo(30.0f, 46.026577f);
                j.cubicTo(30.0f, 47.116467f, 29.11647f, 48.0f, 28.026579f, 48.0f);
                j.lineTo(1.9734219f, 48.0f);
                j.cubicTo(0.8835311f, 48.0f, 0.0f, 47.116467f, 0.0f, 46.026577f);
                j.lineTo(0.0f, 1.9734219f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(69.0f, 35.0f);
                j.lineTo(69.0f, 15.980916f);
                j.cubicTo(69.0f, 14.886887f, 68.12216f, 14.0f, 67.02344f, 14.0f);
                j.lineTo(24.976562f, 14.0f);
                j.cubicTo(23.884937f, 14.0f, 23.0f, 14.88437f, 23.0f, 15.981961f);
                j.lineTo(23.0f, 84.018036f);
                j.cubicTo(23.0f, 85.11265f, 23.873781f, 86.0f, 24.969942f, 86.0f);
                j.lineTo(56.0f, 86.0f);
                canvas.drawPath(j, a2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
