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

public final class ck extends c {
    private final int height = 40;
    private final int width = 40;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                e = c.a(e, 1.0f, 0.0f, -637.0f, 0.0f, 1.0f, -1392.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 637.0f, 0.0f, 1.0f, 1392.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-921103);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(40.0f, 0.0f);
                j.lineTo(40.0f, 40.0f);
                j.lineTo(0.0f, 40.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-3552823);
                Path j2 = c.j(looper);
                j2.moveTo(16.955261f, 20.434963f);
                j2.cubicTo(18.24053f, 22.476675f, 16.106638f, 23.401121f, 15.21541f, 23.914665f);
                j2.cubicTo(11.381262f, 26.095942f, 9.705882f, 26.912895f, 9.705882f, 27.974316f);
                j2.lineTo(9.705882f, 29.424192f);
                j2.cubicTo(9.705882f, 29.890316f, 10.054523f, 30.294117f, 10.575808f, 30.294117f);
                j2.lineTo(29.424192f, 30.294117f);
                j2.cubicTo(29.945477f, 30.294117f, 30.294117f, 29.890316f, 30.294117f, 29.424192f);
                j2.lineTo(30.294117f, 27.974316f);
                j2.cubicTo(30.294117f, 26.912895f, 28.618738f, 26.095942f, 24.78459f, 23.914665f);
                j2.cubicTo(23.893362f, 23.401121f, 21.75947f, 22.476675f, 23.044739f, 20.434963f);
                j2.cubicTo(24.186148f, 18.739943f, 25.076778f, 18.04949f, 25.074566f, 15.21541f);
                j2.cubicTo(25.076778f, 12.524936f, 23.08713f, 9.705882f, 20.144987f, 9.705882f);
                j2.cubicTo(16.91287f, 9.705882f, 14.923222f, 12.524936f, 14.925435f, 15.21541f);
                j2.cubicTo(14.923222f, 18.04949f, 15.813852f, 18.739943f, 16.955261f, 20.434963f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
