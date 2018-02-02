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

public final class aew extends c {
    private final int height = 76;
    private final int width = 76;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                a.setColor(-789517);
                Path j = c.j(looper);
                j.moveTo(0.0f, 4.0f);
                j.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                j.lineTo(72.0f, 0.0f);
                j.cubicTo(74.20914f, 0.0f, 76.0f, 1.7908609f, 76.0f, 4.0f);
                j.lineTo(76.0f, 72.0f);
                j.cubicTo(76.0f, 74.20914f, 74.20914f, 76.0f, 72.0f, 76.0f);
                j.lineTo(4.0f, 76.0f);
                j.cubicTo(1.7908609f, 76.0f, 0.0f, 74.20914f, 0.0f, 72.0f);
                j.lineTo(0.0f, 4.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-5658199);
                float[] a2 = c.a(e, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 14.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(3.077093f, 0.40822864f);
                j.cubicTo(6.376807f, -1.1489923f, 10.591013f, 1.994287f, 9.93107f, 5.6854773f);
                j.cubicTo(9.553961f, 9.520855f, 4.528967f, 11.36645f, 1.7572072f, 8.838369f);
                j.cubicTo(-1.1371136f, 6.6563373f, -0.28861567f, 1.590563f, 3.077093f, 0.40822864f);
                j.lineTo(3.077093f, 0.40822864f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(23.623188f, 16.071012f);
                j.cubicTo(26.064592f, 14.068773f, 28.851942f, 12.245839f, 32.093967f, 12.086457f);
                j.cubicTo(38.943733f, 11.219816f, 45.90223f, 16.98746f, 45.93188f, 24.050083f);
                j.cubicTo(46.07026f, 31.361742f, 45.95165f, 38.6734f, 45.971416f, 45.985058f);
                j.cubicTo(42.976498f, 46.004982f, 39.971695f, 46.004982f, 36.976776f, 45.985058f);
                j.cubicTo(36.8977f, 39.330853f, 37.075615f, 32.676643f, 36.927353f, 26.022438f);
                j.cubicTo(37.085503f, 22.396492f, 33.73475f, 19.238733f, 30.196198f, 19.418037f);
                j.cubicTo(26.677414f, 19.28854f, 23.465042f, 22.436338f, 23.553999f, 25.992554f);
                j.cubicTo(23.326662f, 32.656723f, 23.563883f, 39.32089f, 23.455156f, 45.995018f);
                j.lineTo(16.04199f, 45.995018f);
                j.cubicTo(16.170485f, 35.127148f, 15.755347f, 24.249311f, 16.249557f, 13.391398f);
                j.cubicTo(18.52293f, 13.431244f, 20.7963f, 13.441206f, 23.079557f, 13.431244f);
                j.cubicTo(23.208052f, 14.088696f, 23.48481f, 15.403599f, 23.623188f, 16.071012f);
                j.lineTo(23.623188f, 16.071012f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(1.0f, 13.019893f);
                j.cubicTo(3.6736567f, 12.989608f, 6.336828f, 12.989608f, 9.0f, 13.050178f);
                j.cubicTo(8.968545f, 24.023357f, 9.010485f, 34.996536f, 8.979031f, 45.97981f);
                j.cubicTo(6.3263435f, 45.989906f, 3.6841416f, 46.0f, 1.0314548f, 46.0f);
                j.cubicTo(1.0f, 35.00663f, 1.0524247f, 24.013262f, 1.0f, 13.019893f);
                j.lineTo(1.0f, 13.019893f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
