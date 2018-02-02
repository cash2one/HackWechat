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

public final class um extends c {
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
                a.setColor(-4868683);
                e = c.a(e, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 23.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(20.43f, 0.56f);
                j.cubicTo(26.75f, -0.88f, 33.58f, 0.53f, 38.89f, 4.21f);
                j.cubicTo(47.37f, 10.01f, 51.78f, 21.3f, 49.26f, 31.28f);
                j.cubicTo(47.01f, 40.43f, 39.16f, 47.82f, 29.91f, 49.59f);
                j.cubicTo(17.72f, 51.88f, 4.26f, 44.13f, 0.95f, 32.0f);
                j.cubicTo(-3.19f, 18.46f, 6.49f, 2.93f, 20.43f, 0.56f);
                j.lineTo(20.43f, 0.56f);
                j.close();
                j.moveTo(20.46f, 3.53f);
                j.cubicTo(11.63f, 5.29f, 4.4f, 13.0f, 3.28f, 21.94f);
                j.cubicTo(2.12f, 29.59f, 5.43f, 37.68f, 11.58f, 42.35f);
                j.cubicTo(17.99f, 47.43f, 27.32f, 48.37f, 34.62f, 44.71f);
                j.cubicTo(41.38f, 41.48f, 46.2f, 34.55f, 46.83f, 27.08f);
                j.cubicTo(47.61f, 19.72f, 44.29f, 12.11f, 38.4f, 7.64f);
                j.cubicTo(33.4f, 3.72f, 26.66f, 2.21f, 20.46f, 3.53f);
                j.lineTo(20.46f, 3.53f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(24.26f, 11.33f);
                j.cubicTo(27.01f, 9.64f, 29.55f, 14.15f, 26.77f, 15.67f);
                j.cubicTo(24.01f, 17.4f, 21.42f, 12.82f, 24.26f, 11.33f);
                j.lineTo(24.26f, 11.33f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(21.0f, 19.0f);
                j.cubicTo(23.29f, 19.0f, 25.58f, 19.0f, 27.87f, 19.01f);
                j.cubicTo(27.86f, 25.15f, 27.86f, 31.3f, 27.86f, 37.45f);
                j.cubicTo(28.91f, 37.46f, 29.95f, 37.47f, 31.0f, 37.48f);
                j.lineTo(31.0f, 38.99f);
                j.cubicTo(27.67f, 39.0f, 24.33f, 39.0f, 21.0f, 38.99f);
                j.lineTo(21.0f, 37.49f);
                j.cubicTo(22.05f, 37.47f, 23.1f, 37.44f, 24.15f, 37.4f);
                j.cubicTo(24.12f, 31.78f, 24.15f, 26.17f, 24.14f, 20.55f);
                j.cubicTo(23.09f, 20.54f, 22.05f, 20.53f, 21.0f, 20.53f);
                j.lineTo(21.0f, 19.0f);
                j.lineTo(21.0f, 19.0f);
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
