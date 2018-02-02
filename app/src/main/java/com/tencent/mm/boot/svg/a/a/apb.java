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

public final class apb extends c {
    private final int height = 67;
    private final int width = 84;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 67;
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
                e = c.a(e, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-9538696);
                Path j = c.j(looper);
                j.moveTo(66.83f, 3.1693f);
                j.cubicTo(66.65f, 2.9883f, 66.452f, 2.8253f, 66.239f, 2.6813f);
                j.cubicTo(65.814f, 2.3943f, 65.331f, 2.1873f, 64.811f, 2.0813f);
                j.cubicTo(64.551f, 2.0283f, 64.282f, 2.0003f, 64.006f, 2.0003f);
                j.lineTo(19.994f, 2.0003f);
                j.cubicTo(19.443f, 2.0003f, 18.918f, 2.1123f, 18.44f, 2.3143f);
                j.cubicTo(17.007f, 2.9213f, 16.0f, 4.3433f, 16.0f, 6.0003f);
                j.lineTo(16.0f, 60.9993f);
                j.cubicTo(16.0f, 63.2163f, 17.788f, 65.0003f, 19.994f, 65.0003f);
                j.lineTo(64.006f, 65.0003f);
                j.cubicTo(66.21f, 65.0003f, 68.0f, 63.2093f, 68.0f, 60.9993f);
                j.lineTo(68.0f, 6.0003f);
                j.cubicTo(68.0f, 4.8923f, 67.553f, 3.8923f, 66.83f, 3.1693f);
                j.close();
                j.moveTo(65.0f, 60.9993f);
                j.cubicTo(65.0f, 61.5513f, 64.554f, 62.0003f, 64.006f, 62.0003f);
                j.lineTo(19.994f, 62.0003f);
                j.cubicTo(19.446f, 62.0003f, 19.0f, 61.5513f, 19.0f, 60.9993f);
                j.lineTo(19.0f, 6.0003f);
                j.cubicTo(19.0f, 5.5093f, 19.329f, 5.1963f, 19.611f, 5.0763f);
                j.cubicTo(19.731f, 5.0253f, 19.86f, 5.0003f, 19.994f, 5.0003f);
                j.lineTo(64.006f, 5.0003f);
                j.cubicTo(64.076f, 5.0003f, 64.145f, 5.0073f, 64.211f, 5.0203f);
                j.cubicTo(64.336f, 5.0463f, 64.453f, 5.0953f, 64.56f, 5.1673f);
                j.cubicTo(64.613f, 5.2033f, 64.663f, 5.2443f, 64.708f, 5.2903f);
                j.cubicTo(64.841f, 5.4233f, 65.0f, 5.6543f, 65.0f, 6.0003f);
                j.lineTo(65.0f, 60.9993f);
                j.close();
                j.moveTo(27.0f, 12.0f);
                j.cubicTo(25.3425f, 12.0f, 24.0f, 13.3425f, 24.0f, 15.0f);
                j.cubicTo(24.0f, 16.6575f, 25.3425f, 18.0f, 27.0f, 18.0f);
                j.cubicTo(28.6575f, 18.0f, 30.0f, 16.6575f, 30.0f, 15.0f);
                j.cubicTo(30.0f, 13.3425f, 28.6575f, 12.0f, 27.0f, 12.0f);
                j.close();
                j.moveTo(24.0f, 42.0f);
                j.lineTo(39.0f, 42.0f);
                j.lineTo(39.0f, 45.0f);
                j.lineTo(24.0f, 45.0f);
                j.lineTo(24.0f, 42.0f);
                j.close();
                j.moveTo(24.0f, 33.0f);
                j.lineTo(39.0f, 33.0f);
                j.lineTo(39.0f, 36.0f);
                j.lineTo(24.0f, 36.0f);
                j.lineTo(24.0f, 33.0f);
                j.close();
                j.moveTo(24.0f, 24.0f);
                j.lineTo(51.0f, 24.0f);
                j.lineTo(51.0f, 27.0f);
                j.lineTo(24.0f, 27.0f);
                j.lineTo(24.0f, 24.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
