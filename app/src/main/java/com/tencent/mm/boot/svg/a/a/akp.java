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

public final class akp extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                Paint a2 = c.a(i3, looper);
                a.setColor(-4210753);
                a2.setColor(-4210753);
                a2.setStrokeWidth(0.5f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                a = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(20.0f, 40.0f);
                j.cubicTo(8.954305f, 40.0f, 0.0f, 31.045694f, 0.0f, 20.0f);
                j.cubicTo(0.0f, 8.954305f, 8.954305f, 0.0f, 20.0f, 0.0f);
                j.cubicTo(31.045694f, 0.0f, 40.0f, 8.954305f, 40.0f, 20.0f);
                j.cubicTo(40.0f, 31.045694f, 31.045694f, 40.0f, 20.0f, 40.0f);
                j.close();
                j.moveTo(20.0f, 25.384615f);
                j.cubicTo(22.97384f, 25.384615f, 25.384615f, 22.97384f, 25.384615f, 20.0f);
                j.cubicTo(25.384615f, 17.02616f, 22.97384f, 14.615385f, 20.0f, 14.615385f);
                j.cubicTo(17.02616f, 14.615385f, 14.615385f, 17.02616f, 14.615385f, 20.0f);
                j.cubicTo(14.615385f, 22.97384f, 17.02616f, 25.384615f, 20.0f, 25.384615f);
                j.close();
                j.moveTo(2.841629f, 13.025641f);
                j.lineTo(20.217196f, 13.025641f);
                j.lineTo(11.095022f, 3.7104073f);
                j.cubicTo(7.4411893f, 5.695587f, 4.4904046f, 8.919444f, 2.841629f, 13.025641f);
                j.close();
                j.moveTo(19.806938f, 1.5384616f);
                j.cubicTo(17.431908f, 1.5384616f, 15.042355f, 2.0230188f, 12.856712f, 2.841629f);
                j.lineTo(25.333334f, 15.438914f);
                j.lineTo(25.333334f, 2.40724f);
                j.cubicTo(23.70856f, 1.8235183f, 21.855545f, 1.5384616f, 19.806938f, 1.5384616f);
                j.close();
                j.moveTo(1.5384616f, 20.217196f);
                j.cubicTo(1.5384616f, 22.586182f, 2.0253615f, 24.979147f, 2.8461537f, 27.167421f);
                j.lineTo(15.48718f, 14.666667f);
                j.lineTo(2.4102564f, 14.666667f);
                j.cubicTo(1.8229419f, 16.312695f, 1.5384616f, 18.162403f, 1.5384616f, 20.217196f);
                j.close();
                j.moveTo(13.025641f, 37.15837f);
                j.lineTo(13.025641f, 19.782804f);
                j.lineTo(3.7104073f, 28.904978f);
                j.cubicTo(5.695056f, 32.564972f, 8.915772f, 35.512318f, 13.025641f, 37.15837f);
                j.close();
                j.moveTo(20.217196f, 38.46154f);
                j.cubicTo(22.583342f, 38.46154f, 24.97778f, 37.974f, 27.167421f, 37.15837f);
                j.lineTo(14.666667f, 24.561087f);
                j.lineTo(14.666667f, 37.592762f);
                j.cubicTo(16.31146f, 38.177578f, 18.159653f, 38.46154f, 20.217196f, 38.46154f);
                j.close();
                j.moveTo(37.15837f, 26.923077f);
                j.lineTo(19.782804f, 26.923077f);
                j.lineTo(28.904978f, 36.289593f);
                j.cubicTo(32.56479f, 34.306225f, 35.51124f, 31.088493f, 37.15837f, 26.923077f);
                j.close();
                j.moveTo(38.46154f, 20.217196f);
                j.cubicTo(38.46154f, 17.845076f, 37.973f, 15.454035f, 37.153847f, 13.266969f);
                j.lineTo(24.512821f, 25.384615f);
                j.lineTo(37.589745f, 25.384615f);
                j.cubicTo(38.175034f, 24.120005f, 38.46154f, 22.268494f, 38.46154f, 20.217196f);
                j.close();
                j.moveTo(26.97436f, 3.2518854f);
                j.lineTo(26.97436f, 20.62745f);
                j.lineTo(36.289593f, 11.505279f);
                j.cubicTo(34.305107f, 7.851749f, 31.083288f, 4.901771f, 26.97436f, 3.2518854f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
