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

public final class kf extends c {
    private final int height = 115;
    private final int width = 115;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 115;
            case 1:
                return 115;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -1018.0f, 0.0f, 1.0f, -386.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 1018.0f, 0.0f, 1.0f, 386.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(1275068416);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(57.5f, 0.0f);
                j.cubicTo(89.25638f, 0.0f, 115.0f, 25.743626f, 115.0f, 57.5f);
                j.cubicTo(115.0f, 89.25638f, 89.25638f, 115.0f, 57.5f, 115.0f);
                j.cubicTo(25.743626f, 115.0f, 0.0f, 89.25638f, 0.0f, 57.5f);
                j.cubicTo(0.0f, 25.743626f, 25.743626f, 0.0f, 57.5f, 0.0f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setColor(-1);
                a3.setStrokeWidth(6.0f);
                j = c.j(looper);
                j.moveTo(57.5f, 3.0f);
                j.cubicTo(87.59952f, 3.0f, 112.0f, 27.40048f, 112.0f, 57.5f);
                j.cubicTo(112.0f, 87.59952f, 87.59952f, 112.0f, 57.5f, 112.0f);
                j.cubicTo(27.40048f, 112.0f, 3.0f, 87.59952f, 3.0f, 57.5f);
                j.cubicTo(3.0f, 27.40048f, 27.40048f, 3.0f, 57.5f, 3.0f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-1);
                j = c.j(looper);
                j.moveTo(41.0f, 43.0f);
                j.cubicTo(41.0f, 41.89543f, 41.89543f, 41.0f, 43.0f, 41.0f);
                j.lineTo(72.0f, 41.0f);
                j.cubicTo(73.10457f, 41.0f, 74.0f, 41.89543f, 74.0f, 43.0f);
                j.lineTo(74.0f, 72.0f);
                j.cubicTo(74.0f, 73.10457f, 73.10457f, 74.0f, 72.0f, 74.0f);
                j.lineTo(43.0f, 74.0f);
                j.cubicTo(41.89543f, 74.0f, 41.0f, 73.10457f, 41.0f, 72.0f);
                j.lineTo(41.0f, 43.0f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
