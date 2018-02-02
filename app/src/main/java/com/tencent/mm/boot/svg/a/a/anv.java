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

public final class anv extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-10329502);
                e = c.a(e, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(21.0f, 4.0f);
                j.cubicTo(21.0f, 1.7908609f, 22.790861f, 0.0f, 25.0f, 0.0f);
                j.lineTo(26.0f, 0.0f);
                j.cubicTo(28.209139f, 0.0f, 30.0f, 1.7908609f, 30.0f, 4.0f);
                j.lineTo(30.0f, 42.0f);
                j.cubicTo(30.0f, 44.20914f, 28.209139f, 46.0f, 26.0f, 46.0f);
                j.lineTo(25.0f, 46.0f);
                j.cubicTo(22.790861f, 46.0f, 21.0f, 44.20914f, 21.0f, 42.0f);
                j.lineTo(21.0f, 4.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(0.0f, 4.0f);
                j.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                j.lineTo(5.0f, 0.0f);
                j.cubicTo(7.209139f, 0.0f, 9.0f, 1.7908609f, 9.0f, 4.0f);
                j.lineTo(9.0f, 42.0f);
                j.cubicTo(9.0f, 44.20914f, 7.209139f, 46.0f, 5.0f, 46.0f);
                j.lineTo(4.0f, 46.0f);
                j.cubicTo(1.7908609f, 46.0f, 0.0f, 44.20914f, 0.0f, 42.0f);
                j.lineTo(0.0f, 4.0f);
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
