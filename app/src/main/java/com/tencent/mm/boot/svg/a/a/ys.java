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

public final class ys extends c {
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
                e = c.a(e, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 45.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 7.83f);
                j.cubicTo(0.89f, 2.48f, 7.3f, -0.87f, 12.02f, 2.1f);
                j.cubicTo(17.5f, 4.94f, 17.11f, 13.88f, 11.39f, 16.23f);
                j.cubicTo(6.72f, 18.62f, 1.07f, 15.3f, 0.0f, 10.37f);
                j.lineTo(0.0f, 7.83f);
                j.lineTo(0.0f, 7.83f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(30.31f, 1.49f);
                j.cubicTo(35.95f, -0.88f, 42.51f, 5.02f, 40.75f, 10.88f);
                j.cubicTo(39.68f, 16.46f, 32.09f, 18.97f, 27.89f, 15.13f);
                j.cubicTo(23.15f, 11.55f, 24.63f, 3.24f, 30.31f, 1.49f);
                j.lineTo(30.31f, 1.49f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(50.23f, 10.86f);
                j.cubicTo(48.77f, 5.72f, 53.66f, 0.24f, 58.93f, 1.07f);
                j.cubicTo(62.53f, 1.34f, 65.02f, 4.36f, 66.0f, 7.62f);
                j.lineTo(66.0f, 10.09f);
                j.cubicTo(65.21f, 12.6f, 63.97f, 15.24f, 61.35f, 16.25f);
                j.cubicTo(56.99f, 18.45f, 51.22f, 15.61f, 50.23f, 10.86f);
                j.lineTo(50.23f, 10.86f);
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
