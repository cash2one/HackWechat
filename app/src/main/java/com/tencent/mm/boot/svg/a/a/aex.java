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

public final class aex extends c {
    private final int height = 76;
    private final int width = 76;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                a.setColor(-789517);
                Path j = c.j(looper);
                j.moveTo(0.0f, 4.0f);
                j.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                j.lineTo(72.0f, 0.0f);
                j.cubicTo(74.20914f, 0.0f, 76.0f, 1.7908609f, 76.0f, 4.0f);
                j.lineTo(76.0f, 72.0f);
                j.cubicTo(76.0f, 74.20914f, 74.20914f, 76.0f, 72.0f, 76.0f);
                j.lineTo(4.0f, 76.0f);
                j.cubicTo(1.7908609f, 76.0f, 0.0f, 74.20914f, 0.0f, 72.0f);
                j.lineTo(0.0f, 4.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-5658199);
                float[] a2 = c.a(e, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(3.7070117f, 6.412617f);
                j.cubicTo(6.3475637f, 3.0910726f, 10.084194f, -0.36092544f, 14.617972f, 0.03043481f);
                j.cubicTo(16.40159f, 5.1482224f, 19.90904f, 9.844545f, 19.92897f, 15.433972f);
                j.cubicTo(17.168846f, 17.22018f, 12.874211f, 18.815727f, 13.252857f, 22.849749f);
                j.cubicTo(14.059969f, 27.385513f, 16.501234f, 31.840998f, 19.958862f, 34.871532f);
                j.cubicTo(23.376635f, 37.169518f, 26.385868f, 33.416473f, 28.398664f, 31.048243f);
                j.cubicTo(29.494743f, 31.028173f, 30.580858f, 31.018139f, 31.676935f, 31.018139f);
                j.cubicTo(35.134563f, 33.908184f, 38.651978f, 36.727985f, 42.0f, 39.74848f);
                j.cubicTo(41.15303f, 41.805634f, 40.993603f, 44.49498f, 38.891125f, 45.72927f);
                j.cubicTo(35.463387f, 48.288162f, 31.447756f, 50.736675f, 26.973764f, 49.793396f);
                j.cubicTo(17.358168f, 48.248024f, 10.452875f, 40.14988f, 5.7297745f, 32.15208f);
                j.cubicTo(1.4251761f, 24.545643f, -1.3249838f, 14.320102f, 3.7070117f, 6.412617f);
                j.lineTo(3.7070117f, 6.412617f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
