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

public final class xf extends c {
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
                a.setColor(-1);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(44.5f, 40.321075f);
                j.lineTo(23.613749f, 19.430162f);
                j.cubicTo(23.041075f, 18.85736f, 22.09352f, 18.853842f, 21.511253f, 19.436235f);
                j.lineTo(19.44183f, 21.506123f);
                j.cubicTo(18.850626f, 22.097458f, 18.856846f, 23.030046f, 19.435757f, 23.609087f);
                j.lineTo(40.322006f, 44.5f);
                j.lineTo(19.435757f, 65.390915f);
                j.cubicTo(18.856846f, 65.969955f, 18.850626f, 66.90254f, 19.44183f, 67.49387f);
                j.lineTo(21.511253f, 69.56377f);
                j.cubicTo(22.09352f, 70.14616f, 23.041075f, 70.14264f, 23.613749f, 69.56984f);
                j.lineTo(44.5f, 48.678925f);
                j.lineTo(65.38625f, 69.56984f);
                j.cubicTo(65.95892f, 70.14264f, 66.90648f, 70.14616f, 67.48875f, 69.56377f);
                j.lineTo(69.558174f, 67.49387f);
                j.cubicTo(70.149376f, 66.90254f, 70.14316f, 65.969955f, 69.56425f, 65.390915f);
                j.lineTo(48.677994f, 44.5f);
                j.lineTo(69.56425f, 23.609087f);
                j.cubicTo(70.14316f, 23.030046f, 70.149376f, 22.097458f, 69.558174f, 21.506123f);
                j.lineTo(67.48875f, 19.436235f);
                j.cubicTo(66.90648f, 18.853842f, 65.95892f, 18.85736f, 65.38625f, 19.430162f);
                j.lineTo(44.5f, 40.321075f);
                j.lineTo(44.5f, 40.321075f);
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
