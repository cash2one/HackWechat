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

public final class agg extends c {
    private final int height = 180;
    private final int width = 180;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                a.setColor(-1315861);
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 20.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(171.0f, 90.18926f);
                j.lineTo(171.0f, 9.032258f);
                j.lineTo(9.0f, 9.032258f);
                j.lineTo(9.0f, 89.96034f);
                j.lineTo(60.553738f, 41.65066f);
                j.lineTo(121.92021f, 98.15694f);
                j.lineTo(113.13358f, 80.02691f);
                j.lineTo(138.16164f, 60.600388f);
                j.lineTo(171.0f, 90.18926f);
                j.lineTo(171.0f, 90.18926f);
                j.lineTo(171.0f, 90.18926f);
                j.close();
                j.moveTo(4.494371f, 0.0f);
                j.cubicTo(2.0121984f, 0.0f, 0.0f, 2.0194945f, 0.0f, 4.5191708f);
                j.lineTo(0.0f, 135.48083f);
                j.cubicTo(0.0f, 137.9767f, 2.0214844f, 140.0f, 4.494371f, 140.0f);
                j.lineTo(175.50563f, 140.0f);
                j.cubicTo(177.98781f, 140.0f, 180.0f, 137.9805f, 180.0f, 135.48083f);
                j.lineTo(180.0f, 4.5191708f);
                j.cubicTo(180.0f, 2.0233016f, 177.97852f, 0.0f, 175.50563f, 0.0f);
                j.lineTo(4.494371f, 0.0f);
                j.lineTo(4.494371f, 0.0f);
                j.lineTo(4.494371f, 0.0f);
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
