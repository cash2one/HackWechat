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

public final class db extends c {
    private final int height = 57;
    private final int width = 45;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 57;
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
                a.setColor(-11184811);
                a.setStrokeWidth(3.0f);
                e = c.a(e, 1.0f, 0.0f, -1450.0f, 0.0f, 1.0f, -602.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1470.9163f, 655.8485f);
                j.cubicTo(1472.067f, 657.03674f, 1473.9164f, 657.02386f, 1475.0333f, 655.7881f);
                j.cubicTo(1475.0333f, 655.7881f, 1492.0f, 638.46387f, 1492.0f, 624.0f);
                j.cubicTo(1492.0f, 612.767f, 1483.2695f, 604.0f, 1473.0f, 604.0f);
                j.cubicTo(1461.7305f, 604.0f, 1453.0f, 612.767f, 1453.0f, 624.0f);
                j.cubicTo(1453.0f, 638.46387f, 1470.9163f, 655.8485f, 1470.9163f, 655.8485f);
                j.close();
                j.moveTo(1473.0f, 630.0f);
                j.cubicTo(1476.0898f, 630.0f, 1479.0f, 627.08984f, 1479.0f, 624.0f);
                j.cubicTo(1479.0f, 619.91016f, 1476.0898f, 617.0f, 1473.0f, 617.0f);
                j.cubicTo(1468.9102f, 617.0f, 1466.0f, 619.91016f, 1466.0f, 624.0f);
                j.cubicTo(1466.0f, 627.08984f, 1468.9102f, 630.0f, 1473.0f, 630.0f);
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
