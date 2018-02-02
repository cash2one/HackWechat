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

public final class ana extends c {
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
                a.setColor(-11286452);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(45.0f, 3.0f);
                j.lineTo(45.0f, 59.0f);
                j.lineTo(9.0f, 59.0f);
                j.lineTo(9.0f, 3.0f);
                j.lineTo(45.0f, 3.0f);
                j.close();
                j.moveTo(42.0f, 6.0f);
                j.lineTo(42.0f, 53.0f);
                j.lineTo(12.0f, 53.0f);
                j.lineTo(12.0f, 6.0f);
                j.lineTo(42.0f, 6.0f);
                j.close();
                j.moveTo(27.0f, 59.0f);
                j.cubicTo(28.10457f, 59.0f, 29.0f, 58.10457f, 29.0f, 57.0f);
                j.cubicTo(29.0f, 55.89543f, 28.10457f, 55.0f, 27.0f, 55.0f);
                j.cubicTo(25.89543f, 55.0f, 25.0f, 55.89543f, 25.0f, 57.0f);
                j.cubicTo(25.0f, 58.10457f, 25.89543f, 59.0f, 27.0f, 59.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(44.321014f, 3.0f);
                j.cubicTo(42.295044f, 1.3283027f, 35.97658f, 0.20756736f, 28.648415f, 0.025989328f);
                j.cubicTo(27.95361f, 0.008773398f, 27.24973f, 0.0f, 26.53957f, 0.0f);
                j.cubicTo(18.339287f, 0.0f, 10.921131f, 1.1698043f, 8.684801f, 3.0f);
                j.lineTo(44.321014f, 3.0f);
                j.close();
                j.moveTo(44.321014f, 59.0f);
                j.cubicTo(42.295044f, 60.671696f, 35.97658f, 61.79243f, 28.648415f, 61.97401f);
                j.cubicTo(27.95361f, 61.991226f, 27.24973f, 62.0f, 26.53957f, 62.0f);
                j.cubicTo(18.339287f, 62.0f, 10.921131f, 60.830196f, 8.684801f, 59.0f);
                j.lineTo(44.321014f, 59.0f);
                j.lineTo(44.321014f, 59.0f);
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
