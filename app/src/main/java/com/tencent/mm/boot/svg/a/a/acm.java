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

public final class acm extends c {
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
                e = c.a(e, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(12.0f, 3.0f);
                j.cubicTo(19.75098f, -0.9802127f, 29.384819f, -1.1502612f, 37.0f, 3.0f);
                j.cubicTo(44.480835f, 7.07208f, 49.64289f, 15.314427f, 50.0f, 24.0f);
                j.cubicTo(50.31316f, 31.679087f, 47.391994f, 39.1012f, 44.0f, 46.0f);
                j.cubicTo(38.73855f, 54.72565f, 32.14592f, 62.677914f, 25.0f, 70.0f);
                j.cubicTo(18.02029f, 62.857967f, 11.607736f, 55.07575f, 7.0f, 46.0f);
                j.cubicTo(3.1143513f, 40.12149f, 0.28322318f, 33.219524f, -3.5527137E-15f, 26.0f);
                j.cubicTo(-0.28700405f, 16.934889f, 4.5849376f, 7.9323254f, 12.0f, 3.0f);
                j.lineTo(12.0f, 3.0f);
                j.close();
                j.moveTo(14.0f, 18.0f);
                j.cubicTo(16.561224f, 21.426405f, 19.785715f, 24.075825f, 23.0f, 27.0f);
                j.cubicTo(19.82653f, 29.8653f, 16.67347f, 32.495094f, 14.0f, 36.0f);
                j.cubicTo(14.928572f, 36.439785f, 15.72449f, 37.2248f, 17.0f, 38.0f);
                j.cubicTo(19.84694f, 35.56646f, 22.571428f, 32.504906f, 26.0f, 30.0f);
                j.cubicTo(28.37755f, 32.465656f, 31.214285f, 35.16414f, 34.0f, 38.0f);
                j.cubicTo(35.367348f, 37.3818f, 36.336735f, 36.439785f, 37.0f, 35.0f);
                j.cubicTo(34.07143f, 32.455845f, 31.255102f, 29.71811f, 28.0f, 27.0f);
                j.cubicTo(31.285715f, 24.12489f, 34.459183f, 21.504906f, 37.0f, 18.0f);
                j.cubicTo(36.204082f, 17.550402f, 35.39796f, 16.7752f, 35.0f, 16.0f);
                j.cubicTo(31.265306f, 18.433542f, 28.55102f, 21.495094f, 26.0f, 24.0f);
                j.cubicTo(22.72449f, 21.514719f, 19.867348f, 18.79661f, 17.0f, 16.0f);
                j.cubicTo(16.020409f, 16.765388f, 15.020409f, 17.491526f, 14.0f, 18.0f);
                j.lineTo(14.0f, 18.0f);
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
