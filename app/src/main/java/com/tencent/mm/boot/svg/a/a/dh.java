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

public final class dh extends c {
    private final int height = 75;
    private final int width = 57;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 57;
            case 1:
                return 75;
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
                e = c.a(e, 1.0f, 0.0f, -1448.0f, 0.0f, 1.0f, -685.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1474.4348f, 755.2621f);
                j.cubicTo(1475.5754f, 756.4586f, 1477.4377f, 756.46204f, 1478.5652f, 755.2621f);
                j.cubicTo(1478.5652f, 755.2621f, 1502.0f, 731.94885f, 1502.0f, 712.67706f);
                j.cubicTo(1502.0f, 698.43427f, 1490.5833f, 687.0f, 1476.8696f, 687.0f);
                j.cubicTo(1462.4167f, 687.0f, 1451.0f, 698.43427f, 1451.0f, 712.67706f);
                j.cubicTo(1451.0f, 731.94885f, 1474.4348f, 755.2621f, 1474.4348f, 755.2621f);
                j.close();
                j.moveTo(1476.5f, 721.0f);
                j.cubicTo(1481.1945f, 721.0f, 1485.0f, 717.1944f, 1485.0f, 712.5f);
                j.cubicTo(1485.0f, 707.8056f, 1481.1945f, 704.0f, 1476.5f, 704.0f);
                j.cubicTo(1471.8055f, 704.0f, 1468.0f, 707.8056f, 1468.0f, 712.5f);
                j.cubicTo(1468.0f, 717.1944f, 1471.8055f, 721.0f, 1476.5f, 721.0f);
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
