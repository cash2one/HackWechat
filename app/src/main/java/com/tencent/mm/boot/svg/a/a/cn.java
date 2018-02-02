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

public final class cn extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                e = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 23.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1.0f, 25.019958f);
                j.cubicTo(9.014991f, 17.016632f, 17.029982f, 9.003326f, 25.054966f, 1.0f);
                j.cubicTo(26.47408f, 2.4370062f, 27.893192f, 3.8740125f, 29.292316f, 5.3209977f);
                j.cubicTo(23.73579f, 10.869439f, 18.179262f, 16.4079f, 12.63273f, 21.95634f);
                j.cubicTo(24.755154f, 21.96632f, 36.877575f, 21.95634f, 49.0f, 21.96632f);
                j.lineTo(49.0f, 28.013721f);
                j.lineTo(12.582761f, 28.013721f);
                j.cubicTo(18.129293f, 33.612057f, 23.725796f, 39.15052f, 29.292316f, 44.728897f);
                j.cubicTo(27.873203f, 46.155926f, 26.444098f, 47.57297f, 25.01499f, 49.0f);
                j.cubicTo(17.009995f, 41.006653f, 9.004997f, 33.013306f, 1.0f, 25.019958f);
                j.lineTo(1.0f, 25.019958f);
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
