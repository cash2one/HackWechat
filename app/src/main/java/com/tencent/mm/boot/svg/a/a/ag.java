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

public final class ag extends c {
    private final int height = 24;
    private final int width = 24;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
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
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-5066062);
                e = c.a(e, 1.0f, 0.0f, -54.0f, 0.0f, 1.0f, -710.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 254.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 432.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(34.0f, 34.0f);
                j.lineTo(26.004946f, 34.0f);
                j.cubicTo(24.897026f, 34.0f, 24.0f, 34.89543f, 24.0f, 36.0f);
                j.cubicTo(24.0f, 37.11227f, 24.897646f, 38.0f, 26.004946f, 38.0f);
                j.lineTo(34.0f, 38.0f);
                j.lineTo(34.0f, 45.995052f);
                j.cubicTo(34.0f, 47.102974f, 34.89543f, 48.0f, 36.0f, 48.0f);
                j.cubicTo(37.11227f, 48.0f, 38.0f, 47.102356f, 38.0f, 45.995052f);
                j.lineTo(38.0f, 38.0f);
                j.lineTo(45.995052f, 38.0f);
                j.cubicTo(47.102974f, 38.0f, 48.0f, 37.10457f, 48.0f, 36.0f);
                j.cubicTo(48.0f, 34.88773f, 47.102356f, 34.0f, 45.995052f, 34.0f);
                j.lineTo(38.0f, 34.0f);
                j.lineTo(38.0f, 26.004946f);
                j.cubicTo(38.0f, 24.897026f, 37.10457f, 24.0f, 36.0f, 24.0f);
                j.cubicTo(34.88773f, 24.0f, 34.0f, 24.897646f, 34.0f, 26.004946f);
                j.lineTo(34.0f, 34.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
