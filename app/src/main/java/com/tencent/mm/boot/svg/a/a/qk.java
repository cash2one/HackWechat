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

public final class qk extends c {
    private final int height = 15;
    private final int width = 15;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 15;
            case 1:
                return 15;
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
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-4868683);
                a2.setStrokeWidth(0.95454544f);
                Path j = c.j(looper);
                j.moveTo(13.193269f, 0.4773343f);
                j.lineTo(13.193239f, 0.4773343f);
                j.lineTo(8.75f, 0.4773343f);
                j.cubicTo(8.665613f, 0.4773343f, 8.584682f, 0.5108569f, 8.525011f, 0.57052755f);
                j.lineTo(0.57046604f, 8.525073f);
                j.cubicTo(0.4462083f, 8.649331f, 0.4462083f, 8.850792f, 0.57046705f, 8.975051f);
                j.lineTo(5.0136914f, 13.4183035f);
                j.cubicTo(5.13795f, 13.542562f, 5.3394117f, 13.54256f, 5.4636736f, 13.418298f);
                j.lineTo(13.417828f, 5.463724f);
                j.cubicTo(13.477489f, 5.40406f, 13.511009f, 5.3231416f, 13.511016f, 5.2387595f);
                j.lineTo(13.511421f, 0.7954792f);
                j.cubicTo(13.511435f, 0.61975574f, 13.369009f, 0.47732326f, 13.193269f, 0.4773343f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-4868683);
                j = c.j(looper);
                j.moveTo(10.181818f, 2.8181818f);
                j.cubicTo(10.734103f, 2.8181818f, 11.181818f, 3.265897f, 11.181818f, 3.8181818f);
                j.cubicTo(11.181818f, 4.3704667f, 10.734103f, 4.818182f, 10.181818f, 4.818182f);
                j.cubicTo(9.629533f, 4.818182f, 9.181818f, 4.3704667f, 9.181818f, 3.8181818f);
                j.cubicTo(9.181818f, 3.265897f, 9.629533f, 2.8181818f, 10.181818f, 2.8181818f);
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
