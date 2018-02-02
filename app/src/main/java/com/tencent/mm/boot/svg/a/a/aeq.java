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

public final class aeq extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                Paint a = c.a(i2, looper);
                a.setColor(-6710887);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(33.88f, 0.0f);
                j.lineTo(37.99f, 0.0f);
                j.cubicTo(46.5f, 0.63f, 54.85f, 4.06f, 60.96f, 10.08f);
                j.cubicTo(67.43f, 16.24f, 71.33f, 24.85f, 72.0f, 33.73f);
                j.lineTo(72.0f, 37.97f);
                j.cubicTo(71.44f, 46.97f, 67.49f, 55.71f, 60.95f, 61.93f);
                j.cubicTo(54.91f, 67.87f, 46.69f, 71.3f, 38.29f, 72.0f);
                j.lineTo(34.16f, 72.0f);
                j.cubicTo(25.58f, 71.47f, 17.17f, 67.95f, 11.02f, 61.9f);
                j.cubicTo(4.53f, 55.72f, 0.62f, 47.06f, 0.0f, 38.14f);
                j.lineTo(0.0f, 34.2f);
                j.cubicTo(0.52f, 24.67f, 4.91f, 15.44f, 12.08f, 9.12f);
                j.cubicTo(18.04f, 3.69f, 25.89f, 0.64f, 33.88f, 0.0f);
                j.lineTo(33.88f, 0.0f);
                j.close();
                j.moveTo(29.41f, 3.66f);
                j.cubicTo(22.9f, 5.01f, 16.79f, 8.34f, 12.2f, 13.16f);
                j.cubicTo(1.73f, 23.69f, -0.01f, 41.47f, 8.24f, 53.82f);
                j.cubicTo(16.74f, 67.7f, 36.16f, 73.15f, 50.6f, 65.58f);
                j.cubicTo(65.28f, 58.72f, 72.84f, 40.21f, 67.13f, 25.04f);
                j.cubicTo(62.1f, 9.87f, 45.03f, 0.13f, 29.41f, 3.66f);
                j.lineTo(29.41f, 3.66f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(26.0f, 19.01f);
                j.cubicTo(35.33f, 24.67f, 44.66f, 30.33f, 53.99f, 36.0f);
                j.cubicTo(44.67f, 41.67f, 35.34f, 47.33f, 26.0f, 52.99f);
                j.lineTo(26.0f, 19.01f);
                j.lineTo(26.0f, 19.01f);
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
