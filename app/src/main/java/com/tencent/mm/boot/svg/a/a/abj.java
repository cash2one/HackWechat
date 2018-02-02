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

public final class abj extends c {
    private final int height = 36;
    private final int width = 36;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 36;
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
                Paint a = c.a(i2, looper);
                a.setColor(-15028967);
                a.setStrokeWidth(2.0f);
                canvas.save();
                float[] a2 = c.a(e, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2.0306435f, 11.052016f);
                j.cubicTo(0.7812371f, 9.886849f, 0.0f, 8.226148f, 0.0f, 6.382979f);
                j.cubicTo(0.0f, 2.8577569f, 2.8577569f, 0.0f, 6.382979f, 0.0f);
                j.cubicTo(8.40088f, 0.0f, 10.200077f, 0.93637973f, 11.3697605f, 2.3983283f);
                j.cubicTo(7.022729f, 3.5833154f, 3.5322874f, 6.84528f, 2.0306435f, 11.052016f);
                j.close();
                j.moveTo(18.629875f, 2.3987827f);
                j.cubicTo(19.799551f, 0.9365738f, 21.598911f, 0.0f, 23.617022f, 0.0f);
                j.cubicTo(27.142242f, 0.0f, 30.0f, 2.8577569f, 30.0f, 6.382979f);
                j.cubicTo(30.0f, 8.226897f, 29.218128f, 9.8882f, 27.967833f, 11.053436f);
                j.cubicTo(26.46666f, 6.8465524f, 22.976622f, 3.5842826f, 18.629875f, 2.3987827f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(15.0f, 1.9148932f);
                j.cubicTo(22.226706f, 1.9148932f, 28.085106f, 7.7732944f, 28.085106f, 15.0f);
                j.cubicTo(28.085106f, 22.226706f, 22.226706f, 28.085106f, 15.0f, 28.085106f);
                j.cubicTo(7.7732944f, 28.085106f, 1.9148932f, 22.226706f, 1.9148932f, 15.0f);
                j.cubicTo(1.9148932f, 7.7732944f, 7.7732944f, 1.9148932f, 15.0f, 1.9148932f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = c.a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                Path j2 = c.j(looper);
                j2.moveTo(23.0f, 26.0f);
                j2.lineTo(26.19149f, 29.19149f);
                canvas.drawPath(j2, a4);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setStrokeCap(Cap.SQUARE);
                e = c.a(a2, -1.0f, 0.0f, 10.553192f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(4.0f, 26.0f);
                j.lineTo(6.5531917f, 29.829786f);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                j2 = c.j(looper);
                j2.moveTo(15.0f, 6.1363635f);
                j2.lineTo(15.0f, 15.0f);
                canvas.drawPath(j2, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                j2 = c.j(looper);
                j2.moveTo(15.0f, 15.0f);
                j2.lineTo(20.74468f, 18.40909f);
                canvas.drawPath(j2, a4);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
