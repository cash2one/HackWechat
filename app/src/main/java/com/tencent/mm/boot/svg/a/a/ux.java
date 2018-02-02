package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ux extends c {
    private final int height = 156;
    private final int width = 156;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 156;
            case 1:
                return 156;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                i2 = c.a(i2, looper);
                i2.setColor(-16139513);
                i2.setStrokeWidth(3.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(108.804146f, 97.68627f);
                j.cubicTo(107.96773f, 97.08867f, 99.06952f, 91.14659f, 97.824875f, 91.09063f);
                j.cubicTo(94.858475f, 91.06664f, 88.83385f, 95.10098f, 86.8456f, 95.487724f);
                j.cubicTo(83.99598f, 95.469734f, 77.45433f, 92.31682f, 70.376686f, 85.59425f);
                j.cubicTo(63.662365f, 78.50793f, 60.51331f, 71.95825f, 60.495342f, 69.10513f);
                j.cubicTo(60.881615f, 67.11444f, 64.911f, 61.083424f, 64.887054f, 58.112385f);
                j.cubicTo(64.831154f, 56.867207f, 58.957245f, 47.924107f, 58.299488f, 47.119637f);
                j.cubicTo(57.319336f, 45.788513f, 56.33819f, 44.814156f, 55.664463f, 45.030014f);
                j.cubicTo(54.35793f, 45.241875f, 43.738976f, 49.063354f, 45.12436f, 59.21166f);
                j.cubicTo(46.801193f, 69.13111f, 57.308357f, 83.11889f, 64.887054f, 91.09063f);
                j.cubicTo(72.84902f, 98.67962f, 86.82065f, 109.19868f, 96.726944f, 110.87757f);
                j.cubicTo(106.86381f, 112.264656f, 110.7894f, 101.4348f, 111.0f, 100.12666f);
                j.cubicTo(111.001f, 99.37716f, 109.640564f, 98.28388f, 108.804146f, 97.68627f);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
