package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.a;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class qu extends c {
    private final int height = a.CTRL_INDEX;
    private final int width = a.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return a.CTRL_INDEX;
            case 1:
                return a.CTRL_INDEX;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                i2 = c.a(i2, looper);
                i2.setColor(-9207928);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(64.62f, 0.0f);
                j.lineTo(69.82f, 0.0f);
                j.cubicTo(86.02f, 0.59f, 101.92f, 7.14f, 113.69f, 18.3f);
                j.cubicTo(126.52f, 30.19f, 134.21f, 47.23f, 135.0f, 64.67f);
                j.lineTo(135.0f, 69.7f);
                j.cubicTo(134.43f, 86.65f, 127.28f, 103.29f, 115.22f, 115.23f);
                j.cubicTo(103.44f, 127.13f, 87.1f, 134.22f, 70.39f, 135.0f);
                j.lineTo(65.13f, 135.0f);
                j.cubicTo(48.95f, 134.4f, 33.06f, 127.85f, 21.3f, 116.69f);
                j.cubicTo(8.38f, 104.71f, 0.66f, 87.49f, 0.0f, 69.9f);
                j.lineTo(0.0f, 65.25f);
                j.cubicTo(0.61f, 47.36f, 8.58f, 29.83f, 21.86f, 17.8f);
                j.cubicTo(33.42f, 7.05f, 48.87f, 0.76f, 64.62f, 0.0f);
                j.lineTo(64.62f, 0.0f);
                j.close();
                j.moveTo(52.09248f, 46.367477f);
                j.cubicTo(50.38364f, 46.545963f, 48.854675f, 48.04325f, 49.01457f, 49.81818f);
                j.cubicTo(48.98459f, 60.358685f, 49.01457f, 70.90911f, 49.004574f, 81.45953f);
                j.cubicTo(45.456978f, 81.57852f, 41.08994f, 83.49227f, 41.0f, 87.54784f);
                j.cubicTo(41.039974f, 91.2266f, 44.827404f, 93.12052f, 47.975273f, 93.755135f);
                j.cubicTo(52.24238f, 95.083855f, 56.28964f, 90.76056f, 55.98984f, 86.685165f);
                j.cubicTo(56.01982f, 76.54129f, 55.98984f, 66.397415f, 55.999832f, 56.25354f);
                j.cubicTo(64.66396f, 54.310043f, 73.31809f, 52.336796f, 81.97223f, 50.393295f);
                j.cubicTo(81.99222f, 59.109295f, 81.98222f, 67.825294f, 81.98222f, 76.54129f);
                j.cubicTo(78.14482f, 76.33305f, 73.078255f, 78.15757f, 72.978325f, 82.63951f);
                j.cubicTo(73.467995f, 89.87805f, 86.669044f, 91.0382f, 87.85824f, 83.59143f);
                j.cubicTo(88.158035f, 70.34391f, 87.86823f, 57.076553f, 87.998146f, 43.819115f);
                j.cubicTo(87.9082f, 42.420986f, 88.208f, 40.82454f, 87.27863f, 39.624725f);
                j.cubicTo(86.25932f, 38.662895f, 84.8103f, 39.039696f, 83.59113f, 39.267757f);
                j.cubicTo(73.09824f, 41.647552f, 62.595364f, 44.01743f, 52.09248f, 46.367477f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
