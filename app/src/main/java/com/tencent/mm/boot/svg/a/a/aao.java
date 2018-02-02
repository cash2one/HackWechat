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

public final class aao extends c {
    private final int height = 279;
    private final int width = 279;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 279;
            case 1:
                return 279;
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
                e = c.a(e, 1.0f, 0.0f, -17.0f, 0.0f, 1.0f, -250.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                float[] a = c.a(e, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 250.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-15683841);
                Path j = c.j(looper);
                j.moveTo(279.0f, 141.22223f);
                j.cubicTo(279.0f, 62.454666f, 216.54533f, 0.0f, 137.77777f, 0.0f);
                j.cubicTo(62.454666f, 0.0f, 0.0f, 62.454666f, 0.0f, 141.22223f);
                j.cubicTo(0.0f, 216.54533f, 62.454666f, 279.0f, 137.77777f, 279.0f);
                j.cubicTo(216.54533f, 279.0f, 279.0f, 216.54533f, 279.0f, 141.22223f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                e = c.a(a, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 279.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(134.99942f, 70.5f);
                j.lineTo(144.00058f, 70.5f);
                j.cubicTo(145.65565f, 70.5f, 147.03334f, 71.843925f, 147.07448f, 73.50175f);
                j.lineTo(149.42552f, 168.25435f);
                j.cubicTo(149.46655f, 169.90797f, 148.15945f, 171.2561f, 146.5058f, 171.2561f);
                j.lineTo(132.4942f, 171.2561f);
                j.cubicTo(130.8433f, 171.2561f, 129.53334f, 169.91217f, 129.57448f, 168.25435f);
                j.lineTo(131.92552f, 73.50175f);
                j.cubicTo(131.96655f, 71.84813f, 133.34288f, 70.5f, 134.99942f, 70.5f);
                j.close();
                j.moveTo(139.5f, 208.5f);
                j.cubicTo(132.87259f, 208.5f, 127.5f, 203.12741f, 127.5f, 196.5f);
                j.cubicTo(127.5f, 189.87259f, 132.87259f, 184.5f, 139.5f, 184.5f);
                j.cubicTo(146.12741f, 184.5f, 151.5f, 189.87259f, 151.5f, 196.5f);
                j.cubicTo(151.5f, 203.12741f, 146.12741f, 208.5f, 139.5f, 208.5f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
