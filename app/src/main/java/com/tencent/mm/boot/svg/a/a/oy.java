package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class oy extends c {
    private final int height = 63;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                e = c.a(e, 0.70710677f, -0.70710677f, 31.39409f, 0.70710677f, 0.70710677f, -12.125177f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(25.405478f, 12.6148405f);
                j.lineTo(25.645857f, 54.121506f);
                j.lineTo(30.480642f, 63.385418f);
                j.lineTo(35.31543f, 54.121506f);
                j.lineTo(35.21498f, 12.6148405f);
                j.lineTo(25.405478f, 12.6148405f);
                j.close();
                j.moveTo(25.389639f, 9.879872f);
                j.lineTo(25.351372f, 3.272119f);
                j.cubicTo(25.341805f, 1.6204139f, 26.683146f, 0.28144225f, 28.343227f, 0.28144225f);
                j.lineTo(32.175957f, 0.28144225f);
                j.cubicTo(33.83788f, 0.28144225f, 35.188385f, 1.6257602f, 35.19237f, 3.272119f);
                j.lineTo(35.208363f, 9.879872f);
                j.lineTo(25.389639f, 9.879872f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
