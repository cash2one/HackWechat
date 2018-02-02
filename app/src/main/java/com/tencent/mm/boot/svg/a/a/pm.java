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

public final class pm extends c {
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
                a.setColor(-8355712);
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 11.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(22.190649f, 1.994894f);
                j.cubicTo(22.902634f, -0.67163825f, 27.13443f, -0.6616137f, 27.836386f, 2.0049186f);
                j.cubicTo(28.277615f, 8.6512f, 27.886526f, 15.33758f, 28.01689f, 21.993885f);
                j.cubicTo(34.414722f, 22.074081f, 40.812557f, 21.843517f, 47.20036f, 22.074081f);
                j.cubicTo(50.379223f, 21.903666f, 51.091206f, 26.956041f, 48.08282f, 27.798105f);
                j.cubicTo(41.414234f, 28.309357f, 34.705532f, 27.858252f, 28.01689f, 28.008621f);
                j.cubicTo(27.876497f, 34.664925f, 28.297672f, 41.351307f, 27.826357f, 47.99759f);
                j.cubicTo(27.164513f, 50.66412f, 22.882578f, 50.66412f, 22.190649f, 48.017635f);
                j.cubicTo(21.719336f, 41.371357f, 22.140509f, 34.67495f, 22.000118f, 28.008621f);
                j.cubicTo(15.33153f, 27.868277f, 8.632857f, 28.289309f, 1.9742975f, 27.808128f);
                j.cubicTo(-0.6730819f, 27.116434f, -0.6530259f, 22.866022f, 2.0043814f, 22.184353f);
                j.cubicTo(8.652913f, 21.723223f, 15.33153f, 22.13423f, 22.000118f, 21.993885f);
                j.cubicTo(22.140509f, 15.327556f, 21.729362f, 8.641175f, 22.190649f, 1.994894f);
                j.lineTo(22.190649f, 1.994894f);
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
