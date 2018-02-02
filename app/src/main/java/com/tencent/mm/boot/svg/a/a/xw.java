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

public final class xw extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                a.setColor(-855310);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 30.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(4.0f, 56.998116f);
                j.cubicTo(4.0f, 56.9978f, 73.99772f, 57.0f, 73.99772f, 57.0f);
                j.cubicTo(74.00232f, 57.0f, 74.0f, 14.001884f, 74.0f, 14.001884f);
                j.cubicTo(74.0f, 14.004772f, 56.5f, 14.0f, 56.5f, 14.0f);
                j.lineTo(49.0f, 4.0f);
                j.lineTo(29.0f, 4.0f);
                j.lineTo(21.5f, 14.0f);
                j.lineTo(3.999805f, 14.0f);
                j.cubicTo(3.9999309f, 14.00048f, 4.0f, 56.998116f, 4.0f, 56.998116f);
                j.close();
                j.moveTo(3.993171f, 10.0f);
                j.lineTo(19.5f, 10.0f);
                j.lineTo(27.0f, 0.0f);
                j.lineTo(51.0f, 0.0f);
                j.lineTo(58.5f, 10.0f);
                j.lineTo(74.00683f, 10.0f);
                j.cubicTo(76.20044f, 10.0f, 78.0f, 11.791705f, 78.0f, 14.001884f);
                j.lineTo(78.0f, 56.998116f);
                j.cubicTo(78.0f, 59.214787f, 76.20812f, 61.0f, 73.99772f, 61.0f);
                j.lineTo(4.002278f, 61.0f);
                j.cubicTo(1.7944237f, 61.0f, 0.0f, 59.208294f, 0.0f, 56.998116f);
                j.lineTo(0.0f, 14.001884f);
                j.cubicTo(0.0f, 11.785213f, 1.7878035f, 10.0f, 3.993171f, 10.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(21.0f, 33.0f);
                j.cubicTo(21.0f, 42.941124f, 29.058874f, 51.0f, 39.0f, 51.0f);
                j.cubicTo(44.03602f, 51.0f, 48.588997f, 48.93187f, 51.855957f, 45.598595f);
                j.lineTo(49.027344f, 42.769985f);
                j.cubicTo(46.484406f, 45.379486f, 42.931446f, 47.0f, 39.0f, 47.0f);
                j.cubicTo(31.268013f, 47.0f, 25.0f, 40.731987f, 25.0f, 33.0f);
                j.lineTo(30.5f, 33.0f);
                j.lineTo(22.5f, 25.0f);
                j.lineTo(14.5f, 33.0f);
                j.lineTo(21.0f, 33.0f);
                j.close();
                j.moveTo(57.0f, 33.0f);
                j.cubicTo(57.0f, 23.058874f, 48.941124f, 15.0f, 39.0f, 15.0f);
                j.cubicTo(33.96398f, 15.0f, 29.411005f, 17.068129f, 26.144045f, 20.401403f);
                j.lineTo(28.972656f, 23.230017f);
                j.cubicTo(31.515596f, 20.620514f, 35.068554f, 19.0f, 39.0f, 19.0f);
                j.cubicTo(46.731987f, 19.0f, 53.0f, 25.268013f, 53.0f, 33.0f);
                j.lineTo(47.5f, 33.0f);
                j.lineTo(55.5f, 41.0f);
                j.lineTo(63.5f, 33.0f);
                j.lineTo(57.0f, 33.0f);
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
