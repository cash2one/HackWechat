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

public final class yr extends c {
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
                e = c.a(e, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 45.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(4.65f, 1.76f);
                j.cubicTo(9.01f, -0.47f, 14.83f, 2.41f, 15.78f, 7.19f);
                j.cubicTo(17.06f, 11.98f, 12.97f, 17.14f, 8.02f, 16.99f);
                j.cubicTo(4.06f, 17.14f, 0.96f, 13.96f, 0.0f, 10.33f);
                j.lineTo(0.0f, 7.82f);
                j.cubicTo(0.8f, 5.35f, 2.09f, 2.76f, 4.65f, 1.76f);
                j.lineTo(4.65f, 1.76f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(30.29f, 1.49f);
                j.cubicTo(34.28f, -0.09f, 39.2f, 2.27f, 40.52f, 6.32f);
                j.cubicTo(42.18f, 10.54f, 39.41f, 15.74f, 35.0f, 16.73f);
                j.cubicTo(31.13f, 17.86f, 26.72f, 15.45f, 25.47f, 11.65f);
                j.cubicTo(23.92f, 7.68f, 26.28f, 2.83f, 30.29f, 1.49f);
                j.lineTo(30.29f, 1.49f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(50.23f, 10.85f);
                j.cubicTo(48.89f, 6.03f, 53.07f, 0.83f, 58.04f, 1.01f);
                j.cubicTo(61.98f, 0.89f, 65.03f, 4.05f, 66.0f, 7.66f);
                j.lineTo(66.0f, 10.07f);
                j.cubicTo(65.25f, 12.58f, 63.98f, 15.22f, 61.39f, 16.23f);
                j.cubicTo(57.03f, 18.47f, 51.21f, 15.62f, 50.23f, 10.85f);
                j.lineTo(50.23f, 10.85f);
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
