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

public final class aoz extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                i3 = c.a(i2, looper);
                i3.setColor(-7829368);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(90.0f, 0.0f);
                j.lineTo(90.0f, 90.0f);
                j.lineTo(0.0f, 90.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(4.0f);
                Path j2 = c.j(looper);
                j2.moveTo(40.0f, 50.0f);
                j2.cubicTo(40.0f, 51.162144f, 39.16621f, 52.0f, 38.0f, 52.0f);
                j2.lineTo(2.0f, 52.0f);
                j2.cubicTo(0.83545685f, 52.0f, 0.0f, 51.15074f, 0.0f, 50.0f);
                j2.lineTo(0.0f, 2.0f);
                j2.cubicTo(0.0f, 0.8378576f, 0.8337914f, 0.0f, 2.0f, 0.0f);
                j2.lineTo(27.0f, 0.0f);
                j2.lineTo(40.0f, 13.0f);
                j2.lineTo(40.0f, 50.0f);
                j2.close();
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(i2, looper);
                a3.setColor(-1);
                Path j3 = c.j(looper);
                j3.moveTo(23.0f, 0.0f);
                j3.lineTo(27.0f, 0.0f);
                j3.lineTo(27.0f, 16.0f);
                j3.lineTo(23.0f, 16.0f);
                j3.lineTo(23.0f, 0.0f);
                j3.close();
                canvas.drawPath(j3, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-1);
                j3 = c.j(looper);
                j3.moveTo(23.0f, 13.0f);
                j3.lineTo(40.0f, 13.0f);
                j3.lineTo(40.0f, 17.0f);
                j3.lineTo(23.0f, 17.0f);
                j3.lineTo(23.0f, 13.0f);
                j3.close();
                canvas.drawPath(j3, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
