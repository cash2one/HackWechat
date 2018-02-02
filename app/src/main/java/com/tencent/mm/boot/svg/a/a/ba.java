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

public final class ba extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                i3 = c.a(i2, looper);
                i3.setColor(-855310);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(90.0f, 0.0f);
                j.lineTo(90.0f, 90.0f);
                j.lineTo(0.0f, 90.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(29.25f, 16.59649f);
                j2.cubicTo(29.25f, 9.496691f, 23.53672f, 3.75f, 16.5f, 3.75f);
                j2.cubicTo(9.46328f, 3.75f, 3.75f, 9.496691f, 3.75f, 16.59649f);
                j2.cubicTo(3.75f, 23.03143f, 7.8978143f, 30.246017f, 16.5f, 38.14612f);
                j2.cubicTo(25.102188f, 30.246014f, 29.25f, 23.031427f, 29.25f, 16.59649f);
                j2.close();
                j2.moveTo(17.825495f, 41.99967f);
                j2.cubicTo(17.068739f, 42.66942f, 15.931266f, 42.66942f, 15.174507f, 41.999672f);
                j2.cubicTo(5.058169f, 33.046417f, 0.0f, 24.578691f, 0.0f, 16.59649f);
                j2.cubicTo(4.3587476E-16f, 7.4305024f, 7.3873014f, 0.0f, 16.5f, 0.0f);
                j2.cubicTo(25.612698f, 0.0f, 33.0f, 7.4305024f, 33.0f, 16.59649f);
                j2.cubicTo(33.0f, 24.57869f, 27.941832f, 33.046417f, 17.825495f, 41.99967f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(16.5f, 19.614035f);
                j2.cubicTo(18.156855f, 19.614035f, 19.5f, 18.263035f, 19.5f, 16.59649f);
                j2.cubicTo(19.5f, 14.929948f, 18.156855f, 13.578947f, 16.5f, 13.578947f);
                j2.cubicTo(14.843145f, 13.578947f, 13.5f, 14.929948f, 13.5f, 16.59649f);
                j2.cubicTo(13.5f, 18.263035f, 14.843145f, 19.614035f, 16.5f, 19.614035f);
                j2.close();
                j2.moveTo(16.5f, 23.364035f);
                j2.cubicTo(12.767167f, 23.364035f, 9.75f, 20.329224f, 9.75f, 16.59649f);
                j2.cubicTo(9.75f, 12.863759f, 12.767167f, 9.828947f, 16.5f, 9.828947f);
                j2.cubicTo(20.232832f, 9.828947f, 23.25f, 12.863759f, 23.25f, 16.59649f);
                j2.cubicTo(23.25f, 20.329224f, 20.232832f, 23.364035f, 16.5f, 23.364035f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
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
