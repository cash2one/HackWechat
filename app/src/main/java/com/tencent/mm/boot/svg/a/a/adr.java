package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class adr extends c {
    private final int height = JsApiSetClipboardData.CTRL_INDEX;
    private final int width = JsApiSetClipboardData.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiSetClipboardData.CTRL_INDEX;
            case 1:
                return JsApiSetClipboardData.CTRL_INDEX;
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
                Paint a = c.a(i2, looper);
                a.setColor(-8617594);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 44.0f, 0.0f, 1.0f, 46.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(22.687244f, 25.113926f);
                j.lineTo(22.687244f, 17.929688f);
                j.cubicTo(22.687244f, 8.027395f, 30.660164f, 0.0f, 40.500088f, 0.0f);
                j.cubicTo(50.33785f, 0.0f, 58.31293f, 8.029507f, 58.31293f, 17.929688f);
                j.lineTo(58.31293f, 25.113926f);
                j.cubicTo(58.31293f, 30.056797f, 55.683815f, 37.087967f, 52.44355f, 40.815125f);
                j.lineTo(50.540165f, 43.004528f);
                j.cubicTo(47.94651f, 45.987915f, 48.729496f, 49.78213f, 52.28948f, 51.47937f);
                j.lineTo(74.85725f, 62.23866f);
                j.cubicTo(77.52539f, 63.510708f, 80.02758f, 66.93197f, 80.44377f, 69.86416f);
                j.lineTo(80.96394f, 73.529015f);
                j.cubicTo(81.243225f, 75.49664f, 79.869606f, 77.09172f, 77.89612f, 76.99588f);
                j.lineTo(3.1040568f, 76.99588f);
                j.cubicTo(1.1304631f, 77.09172f, -0.24384984f, 75.50228f, 0.036229156f, 73.529015f);
                j.lineTo(0.55640864f, 69.86416f);
                j.cubicTo(0.97361827f, 66.92476f, 3.480438f, 63.507545f, 6.1249685f, 62.246185f);
                j.lineTo(28.7107f, 51.473454f);
                j.cubicTo(32.27047f, 49.775547f, 33.05514f, 45.98354f, 30.460012f, 42.999973f);
                j.lineTo(28.556623f, 40.811687f);
                j.cubicTo(25.315056f, 37.084923f, 22.687244f, 30.056068f, 22.687244f, 25.113926f);
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
