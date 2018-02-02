package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class zn extends c {
    private final int height = 240;
    private final int width = 180;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 240;
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
                i2.setColor(-1);
                canvas.saveLayerAlpha(null, bs.CTRL_INDEX, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(90.0f, 180.0f);
                j.cubicTo(139.70563f, 180.0f, 180.0f, 139.70563f, 180.0f, 90.0f);
                j.cubicTo(180.0f, 40.294373f, 139.70563f, 0.0f, 90.0f, 0.0f);
                j.cubicTo(40.294373f, 0.0f, 0.0f, 40.294373f, 0.0f, 90.0f);
                j.cubicTo(0.0f, 139.70563f, 40.294373f, 180.0f, 90.0f, 180.0f);
                j.close();
                j.moveTo(62.0f, 100.0f);
                j.lineTo(84.0f, 115.0f);
                j.lineTo(84.0f, 65.0f);
                j.lineTo(62.0f, 80.0f);
                j.lineTo(48.0f, 80.0f);
                j.lineTo(48.0f, 100.0f);
                j.lineTo(62.0f, 100.0f);
                j.close();
                j.moveTo(123.00751f, 126.117966f);
                j.cubicTo(128.96204f, 115.445175f, 132.35507f, 103.14832f, 132.35507f, 90.05898f);
                j.cubicTo(132.35507f, 76.96964f, 128.96204f, 64.67279f, 123.00751f, 54.0f);
                j.lineTo(123.00751f, 54.0f);
                j.lineTo(119.0f, 56.9666f);
                j.cubicTo(124.36485f, 66.79643f, 127.413895f, 78.07163f, 127.413895f, 90.05898f);
                j.cubicTo(127.413895f, 102.04633f, 124.36485f, 113.32154f, 119.0f, 123.15137f);
                j.lineTo(123.00751f, 126.117966f);
                j.close();
                j.moveTo(110.93931f, 117.29133f);
                j.cubicTo(115.135056f, 109.15772f, 117.50414f, 99.92836f, 117.50414f, 90.14567f);
                j.cubicTo(117.50414f, 80.36297f, 115.135056f, 71.133606f, 110.93931f, 63.0f);
                j.lineTo(110.93931f, 63.0f);
                j.lineTo(107.0f, 65.916115f);
                j.cubicTo(110.71647f, 73.27225f, 112.81003f, 81.588f, 112.81003f, 90.39272f);
                j.cubicTo(112.81003f, 99.05392f, 110.78417f, 107.24194f, 107.180466f, 114.508804f);
                j.lineTo(110.93931f, 117.29133f);
                j.lineTo(110.93931f, 117.29133f);
                j.close();
                j.moveTo(99.07929f, 108.3367f);
                j.cubicTo(101.56525f, 102.78967f, 102.947845f, 96.64047f, 102.947845f, 90.16835f);
                j.cubicTo(102.947845f, 83.69623f, 101.56525f, 77.54703f, 99.07929f, 72.0f);
                j.lineTo(99.07929f, 72.0f);
                j.lineTo(95.0f, 75.01974f);
                j.cubicTo(96.93729f, 79.68519f, 98.00667f, 84.80189f, 98.00667f, 90.16835f);
                j.cubicTo(98.00667f, 95.53481f, 96.93729f, 100.65151f, 95.0f, 105.31697f);
                j.lineTo(99.07929f, 108.3367f);
                j.lineTo(99.07929f, 108.3367f);
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
