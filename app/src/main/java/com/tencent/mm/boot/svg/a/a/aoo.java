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

public final class aoo extends c {
    private final int height = 102;
    private final int width = 102;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                a.setColor(-789517);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(102.0f, 0.0f);
                j.lineTo(102.0f, 102.0f);
                j.lineTo(0.0f, 102.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(j, c.a(a, looper));
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i3, looper);
                a2.setColor(-15616);
                a2.setStrokeWidth(6.0f);
                Path j2 = c.j(looper);
                j2.moveTo(27.0f, 25.0f);
                j2.cubicTo(27.0f, 22.790861f, 28.790861f, 21.0f, 31.0f, 21.0f);
                j2.lineTo(71.0f, 21.0f);
                j2.cubicTo(73.20914f, 21.0f, 75.0f, 22.790861f, 75.0f, 25.0f);
                j2.lineTo(75.0f, 77.0f);
                j2.cubicTo(75.0f, 79.20914f, 73.20914f, 81.0f, 71.0f, 81.0f);
                j2.lineTo(31.0f, 81.0f);
                j2.cubicTo(28.790861f, 81.0f, 27.0f, 79.20914f, 27.0f, 77.0f);
                j2.lineTo(27.0f, 25.0f);
                j2.close();
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-15616);
                Path j3 = c.j(looper);
                j3.moveTo(36.0f, 33.0f);
                j3.lineTo(60.0f, 33.0f);
                j3.lineTo(60.0f, 39.0f);
                j3.lineTo(36.0f, 39.0f);
                j3.lineTo(36.0f, 33.0f);
                j3.close();
                canvas.drawPath(j3, i3);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-15616);
                j3 = c.j(looper);
                j3.moveTo(36.0f, 45.0f);
                j3.lineTo(51.0f, 45.0f);
                j3.lineTo(51.0f, 51.0f);
                j3.lineTo(36.0f, 51.0f);
                j3.lineTo(36.0f, 45.0f);
                j3.close();
                canvas.drawPath(j3, i3);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
