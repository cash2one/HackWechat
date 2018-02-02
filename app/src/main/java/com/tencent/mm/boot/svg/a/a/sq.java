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

public final class sq extends c {
    private final int height = 36;
    private final int width = 40;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 36;
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
                a.setColor(-11048043);
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2.95f, 1.02f);
                j.cubicTo(12.96f, 0.94f, 22.98f, 1.06f, 32.99f, 0.97f);
                j.cubicTo(34.31f, 1.13f, 36.14f, 0.52f, 36.9f, 2.0f);
                j.cubicTo(37.18f, 8.98f, 36.88f, 15.98f, 37.03f, 22.97f);
                j.cubicTo(36.86f, 24.28f, 37.48f, 26.12f, 36.02f, 26.9f);
                j.cubicTo(28.94f, 27.17f, 21.85f, 26.9f, 14.76f, 27.0f);
                j.cubicTo(12.19f, 28.76f, 9.6f, 30.48f, 7.0f, 32.2f);
                j.cubicTo(7.0f, 30.47f, 6.99f, 28.75f, 7.0f, 27.02f);
                j.cubicTo(5.09f, 26.72f, 2.45f, 27.83f, 1.1f, 26.03f);
                j.cubicTo(0.84f, 18.67f, 1.09f, 11.3f, 0.98f, 3.93f);
                j.cubicTo(0.79f, 2.67f, 1.23f, 0.69f, 2.95f, 1.02f);
                j.close();
                j.moveTo(5.0f, 5.0f);
                j.lineTo(5.0f, 23.0f);
                j.lineTo(9.99f, 23.0f);
                j.cubicTo(9.99f, 23.67f, 10.0f, 25.03f, 10.0f, 25.7f);
                j.cubicTo(10.93f, 24.8f, 11.84f, 23.9f, 12.75f, 22.99f);
                j.cubicTo(19.5f, 23.01f, 26.25f, 23.0f, 33.0f, 23.0f);
                j.lineTo(33.0f, 5.0f);
                j.lineTo(5.0f, 5.0f);
                j.lineTo(5.0f, 5.0f);
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
