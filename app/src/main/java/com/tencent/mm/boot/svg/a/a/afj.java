package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class afj extends c {
    private final int height = 125;
    private final int width = 1080;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 1080;
            case 1:
                return 125;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                i2 = c.a(i2, looper);
                i2.setColor(-2664127);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(0.08785249f, -2.7755576E-16f);
                j.cubicTo(0.029366853f, 0.41979796f, 0.0f, 0.8405075f, 0.0f, 1.2620968f);
                j.cubicTo(0.0f, 39.514496f, 150.4436f, 125.0f, 540.0f, 125.0f);
                j.cubicTo(929.5564f, 125.0f, 1080.0f, 39.514496f, 1080.0f, 1.2620968f);
                j.cubicTo(1080.0f, 0.8405075f, 1079.9706f, 0.41979796f, 1079.9121f, 2.220446E-16f);
                j.lineTo(0.08785249f, 0.0f);
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
