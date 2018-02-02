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

public final class yl extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                e = c.a(e, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 30.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2.38f, 1.48f);
                j.cubicTo(3.77f, 0.71f, 5.46f, 1.12f, 6.98f, 0.98f);
                j.cubicTo(25.36f, 1.07f, 43.74f, 0.9f, 62.12f, 1.06f);
                j.cubicTo(64.07f, 0.95f, 65.25f, 3.06f, 64.99f, 4.8f);
                j.cubicTo(65.01f, 17.57f, 65.0f, 30.35f, 64.99f, 43.12f);
                j.cubicTo(65.27f, 44.9f, 64.08f, 47.07f, 62.08f, 46.95f);
                j.cubicTo(43.01f, 47.07f, 23.94f, 46.97f, 4.88f, 47.0f);
                j.cubicTo(3.08f, 47.3f, 0.92f, 46.08f, 1.05f, 44.06f);
                j.cubicTo(0.91f, 31.37f, 1.06f, 18.67f, 0.98f, 5.98f);
                j.cubicTo(1.03f, 4.41f, 0.78f, 2.4f, 2.38f, 1.48f);
                j.lineTo(2.38f, 1.48f);
                j.close();
                j.moveTo(8.02f, 14.93f);
                j.cubicTo(15.36f, 19.28f, 22.81f, 23.46f, 30.16f, 27.78f);
                j.cubicTo(31.84f, 28.96f, 34.13f, 28.99f, 35.81f, 27.79f);
                j.cubicTo(43.18f, 23.46f, 50.65f, 19.28f, 58.0f, 14.92f);
                j.cubicTo(61.44f, 13.4f, 57.94f, 7.55f, 54.96f, 9.82f);
                j.cubicTo(47.6f, 13.96f, 40.33f, 18.27f, 33.0f, 22.46f);
                j.cubicTo(25.67f, 18.27f, 18.4f, 13.97f, 11.05f, 9.83f);
                j.cubicTo(8.06f, 7.54f, 4.56f, 13.41f, 8.02f, 14.93f);
                j.lineTo(8.02f, 14.93f);
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
