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

public final class aee extends c {
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
                e = c.a(e, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-5592406);
                Path j = c.j(looper);
                j.moveTo(3.8078494f, 11.822346f);
                j.cubicTo(8.404776f, 4.3013563f, 17.218054f, -0.42926627f, 26.051363f, 0.030794242f);
                j.cubicTo(35.185123f, 0.3208324f, 43.81813f, 6.141598f, 47.61385f, 14.432689f);
                j.cubicTo(51.018982f, 21.393604f, 50.488182f, 29.64469f, 47.854214f, 36.76563f);
                j.cubicTo(43.167152f, 49.54731f, 34.35387f, 60.318726f, 24.989763f, 70.0f);
                j.cubicTo(15.275126f, 59.908672f, 6.0412145f, 48.637188f, 1.6045299f, 35.145412f);
                j.cubicTo(-0.95933306f, 27.51441f, -0.60880494f, 18.713253f, 3.8078494f, 11.822346f);
                j.lineTo(3.8078494f, 11.822346f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(25.084106f, 24.087467f);
                j2.lineTo(16.49832f, 15.50168f);
                j2.lineTo(13.669893f, 18.330107f);
                j2.lineTo(22.25568f, 26.915894f);
                j2.lineTo(13.669893f, 35.50168f);
                j2.lineTo(16.49832f, 38.33011f);
                j2.lineTo(25.084106f, 29.74432f);
                j2.lineTo(33.66989f, 38.33011f);
                j2.lineTo(36.49832f, 35.50168f);
                j2.lineTo(27.912533f, 26.915894f);
                j2.lineTo(36.49832f, 18.330107f);
                j2.lineTo(33.66989f, 15.50168f);
                j2.lineTo(25.084106f, 24.087467f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
