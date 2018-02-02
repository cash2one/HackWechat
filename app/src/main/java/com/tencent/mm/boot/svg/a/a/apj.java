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

public final class apj extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                e = c.a(e, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 4.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 31.994999f);
                j.cubicTo(10.501568f, 21.323332f, 21.023138f, 10.661666f, 31.534706f, 0.0f);
                j.cubicTo(33.36498f, 1.830286f, 35.185253f, 3.6805751f, 36.99552f, 5.5308642f);
                j.cubicTo(29.674429f, 13.022035f, 22.323332f, 20.493202f, 15.002239f, 27.994373f);
                j.lineTo(67.0f, 27.994373f);
                j.lineTo(67.0f, 35.995625f);
                j.cubicTo(49.66741f, 35.995625f, 32.334827f, 35.985622f, 15.002239f, 36.005627f);
                j.cubicTo(22.333334f, 43.486794f, 29.664427f, 50.967964f, 37.005524f, 58.44913f);
                j.cubicTo(35.185253f, 60.299423f, 33.36498f, 62.14971f, 31.534706f, 64.0f);
                j.cubicTo(21.023138f, 53.32833f, 10.501568f, 42.666668f, 0.0f, 31.994999f);
                j.lineTo(0.0f, 31.994999f);
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
