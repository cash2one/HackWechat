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

public final class jc extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 24.019958f);
                j.cubicTo(8.014991f, 16.016632f, 16.029982f, 8.003326f, 24.054966f, 0.0f);
                j.cubicTo(25.47408f, 1.4370062f, 26.893192f, 2.8740125f, 28.292316f, 4.3209977f);
                j.cubicTo(22.73579f, 9.869439f, 17.179262f, 15.4079f, 11.63273f, 20.95634f);
                j.cubicTo(23.755154f, 20.96632f, 35.877575f, 20.95634f, 48.0f, 20.96632f);
                j.lineTo(48.0f, 27.013721f);
                j.lineTo(11.582761f, 27.013721f);
                j.cubicTo(17.129293f, 32.612057f, 22.725796f, 38.15052f, 28.292316f, 43.728897f);
                j.cubicTo(26.873203f, 45.155926f, 25.444098f, 46.57297f, 24.01499f, 48.0f);
                j.cubicTo(16.009995f, 40.006653f, 8.004997f, 32.013306f, 0.0f, 24.019958f);
                j.lineTo(0.0f, 24.019958f);
                j.lineTo(0.0f, 24.019958f);
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
