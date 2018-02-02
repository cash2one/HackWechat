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

public final class acn extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 16.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(24.45f, 1.72f);
                j.cubicTo(40.07f, -2.09f, 57.26f, 8.51f, 60.97f, 24.12f);
                j.cubicTo(65.19f, 38.86f, 56.54f, 55.72f, 42.15f, 60.92f);
                j.cubicTo(28.52f, 66.5f, 11.52f, 60.56f, 4.31f, 47.73f);
                j.cubicTo(-2.87f, 36.0f, -0.8f, 19.65f, 9.09f, 10.08f);
                j.cubicTo(13.27f, 5.9f, 18.67f, 2.96f, 24.45f, 1.72f);
                j.lineTo(24.45f, 1.72f);
                j.close();
                j.moveTo(17.17f, 17.07f);
                j.cubicTo(13.49f, 18.92f, 13.95f, 25.17f, 17.95f, 26.36f);
                j.cubicTo(21.46f, 27.53f, 24.61f, 23.5f, 23.56f, 20.23f);
                j.cubicTo(23.05f, 17.48f, 19.71f, 15.55f, 17.17f, 17.07f);
                j.lineTo(17.17f, 17.07f);
                j.close();
                j.moveTo(41.36f, 17.28f);
                j.cubicTo(38.2f, 19.32f, 38.58f, 24.76f, 42.09f, 26.21f);
                j.cubicTo(45.34f, 27.7f, 48.8f, 24.25f, 48.24f, 20.98f);
                j.cubicTo(48.14f, 17.74f, 44.14f, 15.22f, 41.36f, 17.28f);
                j.lineTo(41.36f, 17.28f);
                j.close();
                j.moveTo(10.9f, 36.58f);
                j.cubicTo(12.04f, 40.99f, 14.08f, 45.33f, 17.62f, 48.33f);
                j.cubicTo(23.73f, 53.55f, 32.94f, 54.15f, 40.17f, 51.04f);
                j.cubicTo(46.02f, 48.47f, 49.67f, 42.62f, 51.09f, 36.57f);
                j.cubicTo(44.43f, 35.73f, 37.76f, 34.82f, 31.03f, 34.74f);
                j.cubicTo(24.29f, 34.82f, 17.59f, 35.73f, 10.9f, 36.58f);
                j.lineTo(10.9f, 36.58f);
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
