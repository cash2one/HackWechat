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

public final class za extends c {
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
                a.setColor(-10526881);
                e = c.a(e, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 25.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(43.01f, 0.01f);
                j.cubicTo(50.34f, 6.17f, 57.67f, 12.34f, 65.0f, 18.51f);
                j.lineTo(43.01f, 36.99f);
                j.cubicTo(42.99f, 33.32f, 43.01f, 29.65f, 42.99f, 25.98f);
                j.cubicTo(35.87f, 26.15f, 27.95f, 26.39f, 22.17f, 31.13f);
                j.cubicTo(18.73f, 33.94f, 16.85f, 38.08f, 14.97f, 42.0f);
                j.cubicTo(15.17f, 31.93f, 18.12f, 20.84f, 26.65f, 14.64f);
                j.cubicTo(31.29f, 11.04f, 37.37f, 10.72f, 42.99f, 11.02f);
                j.cubicTo(43.01f, 7.35f, 42.99f, 3.68f, 43.01f, 0.01f);
                j.lineTo(43.01f, 0.01f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.0f, 13.88f);
                j.cubicTo(0.68f, 12.08f, 1.93f, 9.91f, 3.94f, 10.05f);
                j.cubicTo(9.3f, 9.91f, 14.66f, 10.06f, 20.02f, 9.99f);
                j.cubicTo(17.95f, 12.03f, 16.26f, 14.42f, 14.9f, 16.99f);
                j.cubicTo(12.6f, 16.99f, 10.3f, 17.01f, 8.0f, 17.0f);
                j.lineTo(8.0f, 51.0f);
                j.lineTo(54.0f, 51.0f);
                j.cubicTo(54.04f, 46.48f, 53.9f, 41.96f, 54.08f, 37.45f);
                j.cubicTo(56.43f, 35.59f, 58.69f, 33.62f, 60.99f, 31.71f);
                j.cubicTo(60.97f, 39.5f, 61.07f, 47.29f, 60.95f, 55.08f);
                j.cubicTo(61.04f, 57.06f, 58.93f, 58.34f, 57.12f, 58.0f);
                j.lineTo(4.86f, 58.0f);
                j.cubicTo(3.09f, 58.32f, 0.95f, 57.09f, 1.05f, 55.12f);
                j.cubicTo(0.93f, 41.38f, 1.03f, 27.62f, 1.0f, 13.88f);
                j.lineTo(1.0f, 13.88f);
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
