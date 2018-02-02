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

public final class sy extends c {
    private final int height = 33;
    private final int width = 38;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 33;
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, -480.0f, 0.0f, 1.0f, -190.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(504.54526f, 207.37386f);
                j.lineTo(481.53622f, 221.99107f);
                j.lineTo(481.53622f, 221.99107f);
                j.cubicTo(481.07007f, 222.28723f, 480.4521f, 222.1494f, 480.1559f, 221.68323f);
                j.cubicTo(480.05408f, 221.52292f, 480.0f, 221.33693f, 480.0f, 221.147f);
                j.lineTo(480.0f, 191.00273f);
                j.lineTo(480.0f, 191.00273f);
                j.cubicTo(480.0f, 190.45044f, 480.44772f, 190.00273f, 481.0f, 190.00273f);
                j.cubicTo(481.19934f, 190.00273f, 481.39413f, 190.0623f, 481.5594f, 190.17381f);
                j.lineTo(504.5684f, 205.70087f);
                j.cubicTo(505.02618f, 206.00981f, 505.14688f, 206.63136f, 504.83795f, 207.08916f);
                j.cubicTo(504.761f, 207.20319f, 504.66135f, 207.3001f, 504.54526f, 207.37386f);
                j.lineTo(504.54526f, 207.37386f);
                j.close();
                j.moveTo(511.0f, 190.00006f);
                j.lineTo(517.0f, 190.00006f);
                j.lineTo(517.0f, 190.00006f);
                j.cubicTo(517.5523f, 190.00006f, 518.0f, 190.44777f, 518.0f, 191.00006f);
                j.lineTo(518.0f, 221.0f);
                j.lineTo(518.0f, 221.0f);
                j.cubicTo(518.0f, 221.55229f, 517.5523f, 222.0f, 517.0f, 222.0f);
                j.lineTo(511.0f, 222.0f);
                j.lineTo(511.0f, 222.0f);
                j.cubicTo(510.44772f, 222.0f, 510.0f, 221.55229f, 510.0f, 221.0f);
                j.lineTo(510.0f, 191.00006f);
                j.lineTo(510.0f, 191.00006f);
                j.cubicTo(510.0f, 190.44777f, 510.44772f, 190.00006f, 511.0f, 190.00006f);
                j.lineTo(511.0f, 190.00006f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
