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

public final class agq extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(57.74f, 0.0f);
                j.lineTo(61.88f, 0.0f);
                j.cubicTo(76.5f, 0.47f, 90.87f, 6.44f, 101.42f, 16.6f);
                j.cubicTo(112.63f, 27.2f, 119.36f, 42.25f, 120.0f, 57.65f);
                j.lineTo(120.0f, 62.03f);
                j.cubicTo(119.47f, 77.56f, 112.7f, 92.75f, 101.39f, 103.42f);
                j.cubicTo(90.95f, 113.49f, 76.75f, 119.41f, 62.28f, 120.0f);
                j.lineTo(58.1f, 120.0f);
                j.cubicTo(42.07f, 119.5f, 26.38f, 112.32f, 15.65f, 100.39f);
                j.cubicTo(6.15f, 90.08f, 0.61f, 76.34f, 0.0f, 62.36f);
                j.lineTo(0.0f, 57.99f);
                j.cubicTo(0.53f, 42.26f, 7.48f, 26.86f, 19.05f, 16.16f);
                j.cubicTo(29.45f, 6.34f, 43.46f, 0.59f, 57.74f, 0.0f);
                j.lineTo(57.74f, 0.0f);
                j.close();
                j.moveTo(50.53f, 4.81f);
                j.cubicTo(34.94f, 7.39f, 20.71f, 17.0f, 12.43f, 30.46f);
                j.cubicTo(4.17f, 43.58f, 1.85f, 60.21f, 6.07f, 75.11f);
                j.cubicTo(9.83f, 88.74f, 19.02f, 100.74f, 31.15f, 108.0f);
                j.cubicTo(44.42f, 116.08f, 61.13f, 118.16f, 76.0f, 113.67f);
                j.cubicTo(89.73f, 109.64f, 101.71f, 100.06f, 108.73f, 87.6f);
                j.cubicTo(115.52f, 75.74f, 117.64f, 61.35f, 114.7f, 48.02f);
                j.cubicTo(111.63f, 33.64f, 102.57f, 20.7f, 90.16f, 12.83f);
                j.cubicTo(78.57f, 5.32f, 64.13f, 2.44f, 50.53f, 4.81f);
                j.lineTo(50.53f, 4.81f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(42.0f, 32.01f);
                j.cubicTo(57.32f, 41.34f, 72.66f, 50.64f, 87.97f, 60.0f);
                j.cubicTo(72.67f, 69.37f, 57.32f, 78.66f, 42.01f, 88.0f);
                j.cubicTo(42.0f, 69.33f, 42.0f, 50.67f, 42.0f, 32.01f);
                j.lineTo(42.0f, 32.01f);
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
