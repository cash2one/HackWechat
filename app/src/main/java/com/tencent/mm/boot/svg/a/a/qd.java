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

public final class qd extends c {
    private final int height = 84;
    private final int width = 84;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 84;
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
                a.setColor(-5460820);
                e = c.a(e, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(46.01f, 0.02f);
                j.cubicTo(53.35f, 6.17f, 60.67f, 12.34f, 68.0f, 18.5f);
                j.cubicTo(60.7f, 24.7f, 53.34f, 30.82f, 46.01f, 36.98f);
                j.cubicTo(45.99f, 33.31f, 46.0f, 29.65f, 46.0f, 25.98f);
                j.cubicTo(39.1f, 26.16f, 31.55f, 26.35f, 25.78f, 30.64f);
                j.cubicTo(21.98f, 33.45f, 19.95f, 37.86f, 17.97f, 42.0f);
                j.cubicTo(18.18f, 31.95f, 21.11f, 20.88f, 29.61f, 14.67f);
                j.cubicTo(34.25f, 11.05f, 40.35f, 10.71f, 46.0f, 11.03f);
                j.cubicTo(46.0f, 7.36f, 45.99f, 3.69f, 46.01f, 0.02f);
                j.lineTo(46.01f, 0.02f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.0f, 14.9f);
                j.cubicTo(0.7f, 13.12f, 1.87f, 10.94f, 3.88f, 11.05f);
                j.cubicTo(9.91f, 10.9f, 15.95f, 11.07f, 21.98f, 10.99f);
                j.cubicTo(20.17f, 13.1f, 18.65f, 15.45f, 17.47f, 17.98f);
                j.cubicTo(14.32f, 18.01f, 11.16f, 18.0f, 8.0f, 18.0f);
                j.lineTo(8.0f, 52.0f);
                j.lineTo(54.0f, 52.0f);
                j.lineTo(54.0f, 40.15f);
                j.cubicTo(56.32f, 38.16f, 58.65f, 36.2f, 60.99f, 34.24f);
                j.cubicTo(60.96f, 41.53f, 61.08f, 48.82f, 60.95f, 56.1f);
                j.cubicTo(61.01f, 58.07f, 58.92f, 59.33f, 57.12f, 59.0f);
                j.cubicTo(39.38f, 58.97f, 21.62f, 59.07f, 3.88f, 58.95f);
                j.cubicTo(1.87f, 59.05f, 0.69f, 56.86f, 1.0f, 55.07f);
                j.lineTo(1.0f, 14.9f);
                j.lineTo(1.0f, 14.9f);
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
