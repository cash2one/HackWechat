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

public final class sv extends c {
    private final int height = 40;
    private final int width = 40;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                a.setColor(-6710887);
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(10.040016f, 6.321322f);
                j.cubicTo(18.930199f, 4.4244156f, 27.83037f, 2.5874112f, 36.780487f, 1.0f);
                j.cubicTo(37.170055f, 9.995331f, 36.92033f, 19.020613f, 36.93032f, 28.025927f);
                j.cubicTo(36.83043f, 33.047737f, 29.95802f, 34.515343f, 26.801506f, 31.31057f);
                j.cubicTo(25.263205f, 29.473566f, 25.962433f, 26.388596f, 27.980204f, 25.200533f);
                j.cubicTo(30.037931f, 23.812798f, 32.625076f, 24.072374f, 34.97248f, 23.962553f);
                j.lineTo(34.97248f, 7.2398243f);
                j.cubicTo(27.310944f, 8.767333f, 19.659393f, 10.304826f, 11.997854f, 11.8323345f);
                j.cubicTo(11.8979645f, 19.180351f, 12.187645f, 26.528368f, 11.867998f, 33.8664f);
                j.cubicTo(11.06888f, 39.277576f, 1.319647f, 39.477253f, 1.0f, 33.8664f);
                j.cubicTo(1.0799117f, 29.293858f, 6.5238996f, 28.73477f, 10.000061f, 28.954412f);
                j.cubicTo(10.020039f, 21.406721f, 9.960105f, 13.85903f, 10.040016f, 6.321322f);
                j.lineTo(10.040016f, 6.321322f);
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
