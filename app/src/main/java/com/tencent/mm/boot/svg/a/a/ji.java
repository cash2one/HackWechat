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

public final class ji extends c {
    private final int height = 48;
    private final int width = 66;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 48;
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
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-15683841);
                Path j = c.j(looper);
                j.moveTo(0.1875f, 2.88f);
                j.cubicTo(0.1875f, 1.2894199f, 1.4769199f, 0.0f, 3.0675f, 0.0f);
                j.lineTo(62.9325f, 0.0f);
                j.cubicTo(64.52308f, 0.0f, 65.8125f, 1.2894199f, 65.8125f, 2.88f);
                j.lineTo(65.8125f, 45.12f);
                j.cubicTo(65.8125f, 46.71058f, 64.52308f, 48.0f, 62.9325f, 48.0f);
                j.lineTo(3.0675f, 48.0f);
                j.cubicTo(1.4769199f, 48.0f, 0.1875f, 46.71058f, 0.1875f, 45.12f);
                j.lineTo(0.1875f, 2.88f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(14.4375f, 9.081081f);
                j.cubicTo(17.854763f, 9.081081f, 20.625f, 11.69477f, 20.625f, 14.918919f);
                j.cubicTo(20.625f, 18.143068f, 17.854763f, 20.756756f, 14.4375f, 20.756756f);
                j.cubicTo(11.020238f, 20.756756f, 8.25f, 18.143068f, 8.25f, 14.918919f);
                j.cubicTo(8.25f, 11.69477f, 11.020238f, 9.081081f, 14.4375f, 9.081081f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(8.25f, 29.837837f);
                j2.lineTo(55.0f, 29.837837f);
                j2.lineTo(55.0f, 36.705883f);
                j2.lineTo(8.25f, 36.705883f);
                j2.lineTo(8.25f, 29.837837f);
                j2.close();
                canvas.drawPath(j2, i3);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
