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

public final class aif extends c {
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
                float[] a = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(-1);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(26.43f, 1.68f);
                j.cubicTo(41.46f, -1.69f, 57.9f, 7.14f, 63.51f, 21.45f);
                j.cubicTo(69.44f, 35.22f, 64.39f, 52.55f, 51.99f, 60.97f);
                j.cubicTo(39.83f, 69.86f, 21.65f, 68.7f, 10.73f, 58.32f);
                j.cubicTo(-0.37f, 48.51f, -3.25f, 30.94f, 4.11f, 18.1f);
                j.cubicTo(8.68f, 9.71f, 17.05f, 3.53f, 26.43f, 1.68f);
                j.lineTo(26.43f, 1.68f);
                j.close();
                j.moveTo(20.27f, 23.38f);
                j.cubicTo(23.8f, 26.93f, 27.34f, 30.45f, 30.87f, 34.0f);
                j.cubicTo(27.35f, 37.54f, 23.8f, 41.06f, 20.28f, 44.61f);
                j.cubicTo(20.8f, 45.14f, 21.86f, 46.2f, 22.38f, 46.73f);
                j.cubicTo(25.94f, 43.21f, 29.45f, 39.65f, 33.0f, 36.13f);
                j.cubicTo(36.55f, 39.66f, 40.07f, 43.21f, 43.62f, 46.73f);
                j.cubicTo(44.14f, 46.2f, 45.2f, 45.14f, 45.72f, 44.61f);
                j.cubicTo(42.2f, 41.06f, 38.65f, 37.54f, 35.13f, 34.0f);
                j.cubicTo(38.65f, 30.46f, 42.2f, 26.93f, 45.73f, 23.39f);
                j.cubicTo(45.2f, 22.86f, 44.14f, 21.8f, 43.61f, 21.28f);
                j.cubicTo(40.06f, 24.79f, 36.55f, 28.35f, 33.0f, 31.87f);
                j.cubicTo(29.46f, 28.34f, 25.93f, 24.8f, 22.39f, 21.27f);
                j.cubicTo(21.86f, 21.8f, 20.8f, 22.86f, 20.27f, 23.38f);
                j.lineTo(20.27f, 23.38f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(a, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 21.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(0.27f, 2.38f);
                j.cubicTo(0.8f, 1.86f, 1.86f, 0.8f, 2.39f, 0.27f);
                j.cubicTo(5.93f, 3.8f, 9.46f, 7.34f, 13.0f, 10.87f);
                j.cubicTo(16.55f, 7.35f, 20.06f, 3.79f, 23.61f, 0.28f);
                j.cubicTo(24.14f, 0.8f, 25.2f, 1.86f, 25.73f, 2.39f);
                j.cubicTo(22.2f, 5.93f, 18.65f, 9.46f, 15.13f, 13.0f);
                j.cubicTo(18.65f, 16.54f, 22.2f, 20.06f, 25.72f, 23.61f);
                j.cubicTo(25.2f, 24.14f, 24.14f, 25.2f, 23.62f, 25.73f);
                j.cubicTo(20.07f, 22.21f, 16.55f, 18.66f, 13.0f, 15.13f);
                j.cubicTo(9.45f, 18.65f, 5.94f, 22.21f, 2.38f, 25.73f);
                j.cubicTo(1.86f, 25.2f, 0.8f, 24.14f, 0.28f, 23.61f);
                j.cubicTo(3.8f, 20.06f, 7.35f, 16.54f, 10.87f, 13.0f);
                j.cubicTo(7.34f, 9.45f, 3.8f, 5.93f, 0.27f, 2.38f);
                j.lineTo(0.27f, 2.38f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
