package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class abk extends c {
    private final int height = b.CTRL_INDEX;
    private final int width = 888;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 888;
            case 1:
                return b.CTRL_INDEX;
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                Paint a2 = c.a(i3, looper);
                a.setColor(-855638017);
                a2.setColor(419430400);
                a2.setStrokeWidth(2.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                a = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(487.3696f, 158.0f);
                j.lineTo(865.59595f, 158.0f);
                j.cubicTo(873.5463f, 158.0f, 880.0f, 151.55057f, 880.0f, 143.5948f);
                j.lineTo(880.0f, 14.405201f);
                j.cubicTo(880.0f, 6.4388275f, 873.5511f, 0.0f, 865.59595f, 0.0f);
                j.lineTo(14.404071f, 0.0f);
                j.cubicTo(6.4536805f, 0.0f, 0.0f, 6.449428f, 0.0f, 14.405201f);
                j.lineTo(0.0f, 143.5948f);
                j.cubicTo(0.0f, 151.56117f, 6.448922f, 158.0f, 14.404071f, 158.0f);
                j.lineTo(391.99994f, 158.0f);
                j.cubicTo(401.8239f, 158.0f, 416.78622f, 166.02438f, 429.78192f, 186.76418f);
                j.cubicTo(442.77762f, 207.50397f, 454.39465f, 186.99791f, 454.39465f, 186.99791f);
                j.cubicTo(454.39465f, 186.99791f, 474.19223f, 158.00002f, 487.3696f, 158.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
