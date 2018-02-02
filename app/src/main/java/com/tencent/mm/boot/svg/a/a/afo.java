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

public final class afo extends c {
    private final int height = 74;
    private final int width = 165;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 165;
            case 1:
                return 74;
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
                a.setColor(-14442031);
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 4.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(87.71f, 1.02f);
                j.cubicTo(97.18f, 0.98f, 106.65f, 1.01f, 116.11f, 1.0f);
                j.cubicTo(122.86f, 0.94f, 129.37f, 4.23f, 133.81f, 9.23f);
                j.cubicTo(138.87f, 14.77f, 141.51f, 22.18f, 142.0f, 29.61f);
                j.lineTo(142.0f, 36.95f);
                j.cubicTo(141.63f, 45.0f, 138.59f, 53.09f, 132.81f, 58.82f);
                j.cubicTo(128.22f, 63.52f, 121.67f, 66.29f, 115.07f, 66.0f);
                j.cubicTo(76.95f, 65.86f, 38.82f, 66.27f, 0.7f, 65.79f);
                j.cubicTo(14.4f, 65.13f, 27.91f, 61.47f, 40.08f, 55.19f);
                j.cubicTo(62.05f, 44.0f, 79.39f, 24.21f, 87.71f, 1.02f);
                j.lineTo(87.71f, 1.02f);
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
