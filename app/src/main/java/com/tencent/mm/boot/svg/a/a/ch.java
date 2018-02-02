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

public final class ch extends c {
    private final int height = 96;
    private final int width = 130;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 130;
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
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 1.0f, 0.0f, -238.0f, 0.0f, 1.0f, -292.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 238.0f, 0.0f, 1.0f, 292.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(61.0f, 44.0f);
                j.lineTo(61.0f, 50.0f);
                j.cubicTo(61.0f, 58.22929f, 67.93958f, 65.0f, 77.0f, 65.0f);
                j.cubicTo(85.06042f, 65.0f, 92.0f, 58.22929f, 92.0f, 50.0f);
                j.lineTo(92.0f, 44.0f);
                j.lineTo(94.99676f, 44.0f);
                j.cubicTo(95.56201f, 44.0f, 96.0f, 44.45037f, 96.0f, 45.005928f);
                j.lineTo(96.0f, 50.25f);
                j.cubicTo(96.0f, 60.017532f, 88.3659f, 67.91314f, 79.0f, 68.89677f);
                j.lineTo(79.0f, 72.0f);
                j.lineTo(91.003685f, 72.0f);
                j.cubicTo(91.561775f, 72.0f, 92.0f, 72.45191f, 92.0f, 73.00937f);
                j.lineTo(92.0f, 74.99063f);
                j.cubicTo(92.0f, 75.55665f, 91.55393f, 76.0f, 91.003685f, 76.0f);
                j.lineTo(61.996315f, 76.0f);
                j.cubicTo(61.438225f, 76.0f, 61.0f, 75.54809f, 61.0f, 74.99063f);
                j.lineTo(61.0f, 73.00937f);
                j.cubicTo(61.0f, 72.44335f, 61.446064f, 72.0f, 61.996315f, 72.0f);
                j.lineTo(74.0f, 72.0f);
                j.lineTo(74.0f, 68.796776f);
                j.cubicTo(64.20818f, 67.464806f, 57.0f, 59.741146f, 57.0f, 50.25f);
                j.lineTo(57.0f, 44.997505f);
                j.cubicTo(57.0f, 44.447468f, 57.449165f, 44.0f, 58.003242f, 44.0f);
                j.lineTo(61.0f, 44.0f);
                j.close();
                j.moveTo(76.5f, 21.0f);
                j.cubicTo(82.30026f, 21.0f, 87.0f, 25.705276f, 87.0f, 31.50953f);
                j.lineTo(87.0f, 50.49047f);
                j.cubicTo(87.0f, 56.29387f, 82.29899f, 61.0f, 76.5f, 61.0f);
                j.cubicTo(70.69974f, 61.0f, 66.0f, 56.294724f, 66.0f, 50.49047f);
                j.lineTo(66.0f, 31.50953f);
                j.cubicTo(66.0f, 25.706133f, 70.70101f, 21.0f, 76.5f, 21.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
