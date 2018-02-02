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

public final class my extends c {
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
                a.setColor(-9538696);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(50.83f, 1.1693f);
                j.cubicTo(50.65f, 0.9883f, 50.452f, 0.8253f, 50.239f, 0.6813f);
                j.cubicTo(49.814f, 0.3943f, 49.331f, 0.1873f, 48.811f, 0.0813f);
                j.cubicTo(48.551f, 0.0283f, 48.282f, 3.0E-4f, 48.006f, 3.0E-4f);
                j.lineTo(3.994f, 3.0E-4f);
                j.cubicTo(3.443f, 3.0E-4f, 2.918f, 0.1123f, 2.44f, 0.3143f);
                j.cubicTo(1.007f, 0.9213f, 0.0f, 2.3433f, 0.0f, 4.0003f);
                j.lineTo(0.0f, 58.9993f);
                j.cubicTo(0.0f, 61.2163f, 1.788f, 63.0003f, 3.994f, 63.0003f);
                j.lineTo(48.006f, 63.0003f);
                j.cubicTo(50.21f, 63.0003f, 52.0f, 61.2093f, 52.0f, 58.9993f);
                j.lineTo(52.0f, 4.0003f);
                j.cubicTo(52.0f, 2.8923f, 51.553f, 1.8923f, 50.83f, 1.1693f);
                j.close();
                j.moveTo(49.0f, 58.9993f);
                j.cubicTo(49.0f, 59.5513f, 48.554f, 60.0003f, 48.006f, 60.0003f);
                j.lineTo(3.994f, 60.0003f);
                j.cubicTo(3.446f, 60.0003f, 3.0f, 59.5513f, 3.0f, 58.9993f);
                j.lineTo(3.0f, 4.0003f);
                j.cubicTo(3.0f, 3.5093f, 3.329f, 3.1963f, 3.611f, 3.0763f);
                j.cubicTo(3.731f, 3.0253f, 3.86f, 3.0003f, 3.994f, 3.0003f);
                j.lineTo(48.006f, 3.0003f);
                j.cubicTo(48.076f, 3.0003f, 48.145f, 3.0073f, 48.211f, 3.0203f);
                j.cubicTo(48.336f, 3.0463f, 48.453f, 3.0953f, 48.56f, 3.1673f);
                j.cubicTo(48.613f, 3.2033f, 48.663f, 3.2443f, 48.708f, 3.2903f);
                j.cubicTo(48.841f, 3.4233f, 49.0f, 3.6543f, 49.0f, 4.0003f);
                j.lineTo(49.0f, 58.9993f);
                j.close();
                j.moveTo(6.0f, 52.0f);
                j.lineTo(46.0f, 52.0f);
                j.lineTo(46.0f, 10.0f);
                j.lineTo(6.0f, 10.0f);
                j.lineTo(6.0f, 52.0f);
                j.close();
                j.moveTo(9.0f, 49.0f);
                j.lineTo(43.0f, 49.0f);
                j.lineTo(43.0f, 13.0f);
                j.lineTo(9.0f, 13.0f);
                j.lineTo(9.0f, 49.0f);
                j.close();
                j.moveTo(26.0f, 54.0f);
                j.cubicTo(24.895f, 54.0f, 24.0f, 54.895f, 24.0f, 56.0f);
                j.cubicTo(24.0f, 57.105f, 24.895f, 58.0f, 26.0f, 58.0f);
                j.cubicTo(27.105f, 58.0f, 28.0f, 57.105f, 28.0f, 56.0f);
                j.cubicTo(28.0f, 54.895f, 27.105f, 54.0f, 26.0f, 54.0f);
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
