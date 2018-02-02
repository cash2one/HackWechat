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

public final class op extends c {
    private final int height = 8;
    private final int width = 242;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 242;
            case 1:
                return 8;
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
                e = c.a(e, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-1498304079);
                Path j = c.j(looper);
                j.moveTo(119.5f, 0.0f);
                j.cubicTo(121.433f, 0.0f, 123.0f, 1.5670033f, 123.0f, 3.5f);
                j.cubicTo(123.0f, 5.4329967f, 121.433f, 7.0f, 119.5f, 7.0f);
                j.cubicTo(117.567f, 7.0f, 116.0f, 5.4329967f, 116.0f, 3.5f);
                j.cubicTo(116.0f, 1.5670033f, 117.567f, 0.0f, 119.5f, 0.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                a3.setColor(-1716407887);
                a3.setStrokeCap(Cap.SQUARE);
                Path j2 = c.j(looper);
                j2.moveTo(130.5f, 3.5f);
                j2.lineTo(238.51852f, 3.5f);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setColor(-1716407887);
                a3.setStrokeCap(Cap.SQUARE);
                j2 = c.j(looper);
                j2.moveTo(0.5f, 3.5f);
                j2.lineTo(108.51852f, 3.5f);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
