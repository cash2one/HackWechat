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
import com.tencent.wcdb.FileUtils;

public final class adc extends c {
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
                a.setColor(-8355712);
                e = c.a(e, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(37.83f, 1.16f);
                j.cubicTo(38.08f, 1.4f, 38.59f, 1.9f, 38.84f, 2.14f);
                j.cubicTo(39.24f, 10.42f, 38.88f, 18.72f, 39.0f, 27.0f);
                j.cubicTo(42.66f, 26.99f, 46.33f, 27.01f, 49.99f, 27.01f);
                j.cubicTo(44.0f, 33.01f, 38.0f, 39.0f, 32.0f, 45.0f);
                j.cubicTo(26.0f, 39.0f, 20.0f, 33.01f, 14.01f, 27.0f);
                j.cubicTo(17.67f, 27.01f, 21.34f, 26.99f, 25.0f, 27.0f);
                j.cubicTo(25.12f, 18.73f, 24.77f, 10.45f, 25.16f, 2.2f);
                j.cubicTo(25.4f, 1.94f, 25.87f, 1.42f, 26.11f, 1.17f);
                j.cubicTo(30.0f, 0.87f, 33.93f, 0.86f, 37.83f, 1.16f);
                j.lineTo(37.83f, 1.16f);
                j.lineTo(37.83f, 1.16f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.0f, 42.0f);
                j.lineTo(8.0f, 42.0f);
                j.cubicTo(7.99f, 45.67f, 8.01f, 49.33f, 8.0f, 53.0f);
                j.lineTo(56.0f, 53.0f);
                j.cubicTo(55.99f, 49.33f, 56.01f, 45.67f, 56.0f, 42.0f);
                j.lineTo(63.0f, 42.0f);
                j.cubicTo(62.93f, 47.03f, 63.14f, 52.07f, 62.93f, 57.11f);
                j.cubicTo(63.02f, 59.09f, 60.92f, 60.29f, 59.13f, 59.99f);
                j.cubicTo(41.05f, 60.01f, 22.97f, 60.01f, 4.89f, 59.99f);
                j.cubicTo(3.1f, 60.29f, 0.95f, 59.11f, 1.07f, 57.1f);
                j.cubicTo(0.86f, 52.07f, 1.07f, 47.03f, 1.0f, 42.0f);
                j.lineTo(1.0f, 42.0f);
                j.lineTo(1.0f, 42.0f);
                j.lineTo(1.0f, 42.0f);
                j.lineTo(1.0f, 42.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
