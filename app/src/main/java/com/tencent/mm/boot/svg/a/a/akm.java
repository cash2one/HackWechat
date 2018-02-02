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

public final class akm extends c {
    private final int height = 24;
    private final int width = 14;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 14;
            case 1:
                return 24;
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
                i2.setStrokeCap(Cap.SQUARE);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-7039852);
                a.setStrokeWidth(1.3333334f);
                e = c.a(e, 1.0f, 0.0f, -297.0f, 0.0f, 1.0f, -1097.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(309.1949f, 1109.0f);
                j.lineTo(309.33334f, 1108.8616f);
                j.lineTo(309.09744f, 1108.6256f);
                j.lineTo(298.70767f, 1098.2358f);
                j.lineTo(298.47177f, 1098.0f);
                j.lineTo(298.0f, 1098.4718f);
                j.lineTo(298.2359f, 1098.7076f);
                j.lineTo(308.52823f, 1109.0f);
                j.lineTo(298.2359f, 1119.2924f);
                j.lineTo(298.0f, 1119.5282f);
                j.lineTo(298.47177f, 1120.0f);
                j.lineTo(298.70767f, 1119.7642f);
                j.lineTo(309.09744f, 1109.3744f);
                j.lineTo(309.33334f, 1109.1384f);
                j.lineTo(309.1949f, 1109.0f);
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
