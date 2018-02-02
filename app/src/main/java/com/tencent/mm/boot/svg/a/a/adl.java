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

public final class adl extends c {
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
                float[] a = c.a(e, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 21.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(-1);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(1.0493919f, 4.9551387f);
                j.cubicTo(0.73974586f, 3.1585698f, 1.9383756f, 0.9428011f, 3.976046f, 1.1024961f);
                j.cubicTo(22.345047f, 0.9727439f, 40.724033f, 1.0725534f, 59.093037f, 1.0525914f);
                j.cubicTo(60.89098f, 0.72322047f, 63.00856f, 1.970838f, 62.908672f, 3.9570448f);
                j.cubicTo(63.04851f, 17.002132f, 62.948627f, 30.04722f, 62.958614f, 43.092308f);
                j.cubicTo(63.238297f, 44.82899f, 62.07962f, 46.994858f, 60.11187f, 46.895046f);
                j.cubicTo(53.07991f, 47.05474f, 46.03796f, 46.90503f, 38.99601f, 46.954933f);
                j.lineTo(38.99601f, 50.95729f);
                j.cubicTo(42.32221f, 50.927345f, 45.658394f, 50.8475f, 48.984592f, 51.17687f);
                j.cubicTo(48.984592f, 52.274773f, 48.914673f, 54.400715f, 47.17666f, 53.93161f);
                j.cubicTo(37.068214f, 53.951572f, 26.95977f, 53.951572f, 16.851326f, 53.93161f);
                j.cubicTo(15.083348f, 54.410694f, 14.993451f, 52.25481f, 15.093336f, 51.136948f);
                j.cubicTo(18.389568f, 50.87744f, 21.705776f, 50.917366f, 25.011997f, 50.95729f);
                j.lineTo(25.011997f, 46.954933f);
                j.cubicTo(17.980036f, 46.90503f, 10.948075f, 47.05474f, 3.926103f, 46.895046f);
                j.cubicTo(1.9084098f, 47.0248f, 0.73974586f, 44.80903f, 1.0493919f, 43.032425f);
                j.cubicTo(1.0294148f, 30.336668f, 1.0294148f, 17.650894f, 1.0493919f, 4.9551387f);
                j.lineTo(1.0493919f, 4.9551387f);
                j.close();
                j.moveTo(5.0f, 5.0f);
                j.lineTo(5.0f, 39.0f);
                j.lineTo(59.0f, 39.0f);
                j.lineTo(59.0f, 5.0f);
                j.lineTo(5.0f, 5.0f);
                j.lineTo(5.0f, 5.0f);
                j.close();
                j.moveTo(31.225903f, 41.13082f);
                j.cubicTo(28.789328f, 42.126995f, 30.338081f, 45.77963f, 32.794384f, 44.84987f);
                j.cubicTo(35.201366f, 43.844208f, 33.65261f, 40.276962f, 31.225903f, 41.13082f);
                j.lineTo(31.225903f, 41.13082f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-15658735);
                e = c.a(a, 1.0f, 0.0f, 29.0f, 0.0f, 1.0f, 40.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, 17, 4);
                canvas.save();
                Paint a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(2.2259018f, 1.130823f);
                j.cubicTo(4.6526113f, 0.2769606f, 6.2013645f, 3.8442078f, 3.7943847f, 4.849868f);
                j.cubicTo(1.3380812f, 5.779629f, -0.21067229f, 2.1269958f, 2.2259018f, 1.130823f);
                j.lineTo(2.2259018f, 1.130823f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
