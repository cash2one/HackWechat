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

public final class aef extends c {
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
                a.setColor(-1);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 15.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(8.001439f, 18.0f);
                j.cubicTo(3.5823665f, 18.0f, 0.0f, 21.582798f, 0.0f, 25.997679f);
                j.lineTo(0.0f, 82.00232f);
                j.cubicTo(0.0f, 86.41932f, 3.5913615f, 90.0f, 8.001439f, 90.0f);
                j.lineTo(111.99856f, 90.0f);
                j.cubicTo(116.41763f, 90.0f, 120.0f, 86.4172f, 120.0f, 82.00232f);
                j.lineTo(120.0f, 25.997679f);
                j.cubicTo(120.0f, 21.580683f, 116.40864f, 18.0f, 111.99856f, 18.0f);
                j.lineTo(8.001439f, 18.0f);
                j.close();
                j.moveTo(47.750492f, 0.0f);
                j.lineTo(60.0f, 0.0f);
                j.lineTo(60.0f, 18.0f);
                j.lineTo(23.340025f, 18.0f);
                j.cubicTo(33.061623f, 18.0f, 38.284004f, 0.0f, 47.750492f, 0.0f);
                j.close();
                j.moveTo(96.65997f, 18.0f);
                j.cubicTo(86.93838f, 18.0f, 81.715996f, 0.0f, 72.2474f, 0.0f);
                j.lineTo(60.0f, 0.0f);
                j.lineTo(60.0f, 18.0f);
                j.lineTo(96.65997f, 18.0f);
                j.close();
                j.moveTo(60.0f, 27.0f);
                j.cubicTo(74.91231f, 27.0f, 87.0f, 39.087692f, 87.0f, 54.0f);
                j.cubicTo(87.0f, 68.91231f, 74.91231f, 81.0f, 60.0f, 81.0f);
                j.cubicTo(45.087692f, 81.0f, 33.0f, 68.91231f, 33.0f, 54.0f);
                j.cubicTo(33.0f, 39.087692f, 45.087692f, 27.0f, 60.0f, 27.0f);
                j.close();
                j.moveTo(78.0f, 54.0f);
                j.cubicTo(78.0f, 63.9414f, 69.9414f, 72.0f, 60.0f, 72.0f);
                j.cubicTo(50.0586f, 72.0f, 42.0f, 63.9414f, 42.0f, 54.0f);
                j.cubicTo(42.0f, 44.0586f, 50.0586f, 36.0f, 60.0f, 36.0f);
                j.cubicTo(69.9414f, 36.0f, 78.0f, 44.0586f, 78.0f, 54.0f);
                j.close();
                j.moveTo(5.4545455f, 6.4315085f);
                j.lineTo(21.818182f, 6.4315085f);
                j.lineTo(21.818182f, 12.407947f);
                j.lineTo(5.4545455f, 12.407947f);
                j.lineTo(5.4545455f, 6.4315085f);
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
