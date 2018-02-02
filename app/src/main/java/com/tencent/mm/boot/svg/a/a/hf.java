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

public final class hf extends c {
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
                e = c.a(e, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-8617851);
                Path j = c.j(looper);
                j.moveTo(40.5001f, 1.0E-4f);
                j.cubicTo(16.1941f, 1.0E-4f, 1.0E-4f, 14.5371f, 1.0E-4f, 32.4701f);
                j.cubicTo(1.0E-4f, 42.0741f, 4.6671f, 50.7011f, 12.7231f, 56.6461f);
                j.lineTo(8.1001f, 69.0001f);
                j.lineTo(23.6971f, 62.3011f);
                j.cubicTo(28.6931f, 63.9971f, 34.3371f, 64.9411f, 40.5001f, 64.9411f);
                j.cubicTo(64.7401f, 64.9411f, 81.0001f, 50.4031f, 81.0001f, 32.4701f);
                j.cubicTo(81.0001f, 14.5371f, 64.8061f, 1.0E-4f, 40.5001f, 1.0E-4f);
                j.close();
                j.moveTo(70.6401f, 39.7451f);
                j.lineTo(68.6931f, 45.4211f);
                j.cubicTo(66.3191f, 44.6061f, 61.0241f, 42.3231f, 56.2901f, 37.0491f);
                j.cubicTo(49.8301f, 45.3031f, 42.3131f, 46.0001f, 40.0001f, 46.0001f);
                j.cubicTo(37.6871f, 46.0001f, 30.1701f, 45.3031f, 23.7101f, 37.0491f);
                j.cubicTo(18.9761f, 42.3231f, 13.6811f, 44.6061f, 11.3071f, 45.4211f);
                j.lineTo(9.3601f, 39.7451f);
                j.cubicTo(11.3931f, 39.0471f, 16.1241f, 36.9871f, 20.1311f, 32.0001f);
                j.cubicTo(16.1241f, 27.0121f, 11.3931f, 24.9531f, 9.3601f, 24.2551f);
                j.lineTo(11.3071f, 18.5791f);
                j.cubicTo(13.6811f, 19.3941f, 18.9761f, 21.6771f, 23.7101f, 26.9511f);
                j.cubicTo(30.1701f, 18.6971f, 37.6871f, 18.0001f, 40.0001f, 18.0001f);
                j.cubicTo(42.3131f, 18.0001f, 49.8301f, 18.6971f, 56.2901f, 26.9511f);
                j.cubicTo(61.0241f, 21.6771f, 66.3191f, 19.3941f, 68.6931f, 18.5791f);
                j.lineTo(70.6401f, 24.2551f);
                j.cubicTo(68.6071f, 24.9531f, 63.8751f, 27.0121f, 59.8681f, 32.0001f);
                j.cubicTo(63.8751f, 36.9871f, 68.6071f, 39.0471f, 70.6401f, 39.7451f);
                j.close();
                j.moveTo(40.0f, 24.0f);
                j.cubicTo(38.298f, 24.0f, 32.505f, 24.612f, 27.463f, 32.0f);
                j.cubicTo(32.505f, 39.388f, 38.298f, 40.0f, 40.0f, 40.0f);
                j.cubicTo(41.702f, 40.0f, 47.495f, 39.388f, 52.537f, 32.0f);
                j.cubicTo(47.495f, 24.612f, 41.702f, 24.0f, 40.0f, 24.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
