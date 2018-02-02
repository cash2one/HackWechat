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

public final class yz extends c {
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
                e = c.a(e, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 25.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(43.01f, 0.01f);
                j.cubicTo(50.34f, 6.17f, 57.67f, 12.34f, 65.0f, 18.5f);
                j.cubicTo(57.67f, 24.66f, 50.34f, 30.83f, 43.01f, 36.99f);
                j.cubicTo(42.99f, 33.32f, 43.0f, 29.65f, 43.0f, 25.98f);
                j.cubicTo(35.87f, 26.16f, 27.95f, 26.38f, 22.17f, 31.13f);
                j.cubicTo(18.72f, 33.96f, 16.83f, 38.11f, 14.96f, 42.04f);
                j.cubicTo(15.19f, 31.98f, 18.09f, 20.89f, 26.6f, 14.67f);
                j.cubicTo(31.25f, 11.05f, 37.35f, 10.71f, 43.0f, 11.03f);
                j.cubicTo(43.0f, 7.35f, 43.0f, 3.68f, 43.01f, 0.01f);
                j.lineTo(43.01f, 0.01f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.01f, 13.87f);
                j.cubicTo(0.7f, 12.07f, 1.92f, 9.92f, 3.93f, 10.05f);
                j.cubicTo(9.29f, 9.9f, 14.66f, 10.07f, 20.03f, 9.98f);
                j.cubicTo(17.95f, 12.03f, 16.26f, 14.42f, 14.9f, 16.99f);
                j.cubicTo(12.6f, 17.0f, 10.3f, 17.0f, 8.0f, 17.0f);
                j.lineTo(8.0f, 51.0f);
                j.lineTo(54.0f, 51.0f);
                j.cubicTo(54.01f, 46.52f, 53.98f, 42.04f, 54.02f, 37.57f);
                j.cubicTo(56.35f, 35.62f, 58.67f, 33.66f, 60.99f, 31.7f);
                j.cubicTo(60.97f, 39.49f, 61.08f, 47.28f, 60.95f, 55.06f);
                j.cubicTo(61.04f, 57.04f, 58.96f, 58.32f, 57.15f, 57.99f);
                j.cubicTo(39.39f, 57.97f, 21.62f, 58.07f, 3.86f, 57.95f);
                j.cubicTo(1.9f, 58.04f, 0.71f, 55.92f, 1.01f, 54.16f);
                j.cubicTo(0.99f, 40.73f, 1.0f, 27.3f, 1.01f, 13.87f);
                j.lineTo(1.01f, 13.87f);
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
