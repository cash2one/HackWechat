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

public final class ado extends c {
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
                e = c.a(e, 1.0f, 0.0f, 49.0f, 0.0f, 1.0f, 46.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.9448406f, 3.0f);
                j.cubicTo(0.42301953f, 3.0f, 0.0f, 3.4298856f, 0.0f, 3.9448407f);
                j.lineTo(0.0f, 36.05516f);
                j.cubicTo(0.0f, 36.57698f, 0.42988563f, 37.0f, 0.9448406f, 37.0f);
                j.lineTo(33.05516f, 37.0f);
                j.cubicTo(33.57698f, 37.0f, 34.0f, 36.570114f, 34.0f, 36.05516f);
                j.lineTo(34.0f, 3.9448407f);
                j.cubicTo(34.0f, 3.4230196f, 33.570114f, 3.0f, 33.05516f, 3.0f);
                j.lineTo(0.9448406f, 3.0f);
                j.lineTo(0.9448406f, 3.0f);
                j.close();
                j.moveTo(0.0f, 42.94484f);
                j.lineTo(0.0f, 75.05516f);
                j.cubicTo(0.0f, 75.57698f, 0.42988563f, 76.0f, 0.9448406f, 76.0f);
                j.lineTo(33.05516f, 76.0f);
                j.cubicTo(33.57698f, 76.0f, 34.0f, 75.570114f, 34.0f, 75.05516f);
                j.lineTo(34.0f, 42.94484f);
                j.cubicTo(34.0f, 42.42302f, 33.570114f, 42.0f, 33.05516f, 42.0f);
                j.lineTo(0.9448406f, 42.0f);
                j.cubicTo(0.42301953f, 42.0f, 0.0f, 42.429886f, 0.0f, 42.94484f);
                j.close();
                j.moveTo(39.94484f, 42.0f);
                j.cubicTo(39.42302f, 42.0f, 39.0f, 42.429886f, 39.0f, 42.94484f);
                j.lineTo(39.0f, 75.05516f);
                j.cubicTo(39.0f, 75.57698f, 39.429886f, 76.0f, 39.94484f, 76.0f);
                j.lineTo(72.05516f, 76.0f);
                j.cubicTo(72.57698f, 76.0f, 73.0f, 75.570114f, 73.0f, 75.05516f);
                j.lineTo(73.0f, 42.94484f);
                j.cubicTo(73.0f, 42.42302f, 72.570114f, 42.0f, 72.05516f, 42.0f);
                j.lineTo(39.94484f, 42.0f);
                j.lineTo(39.94484f, 42.0f);
                j.close();
                j.moveTo(39.461056f, 36.24942f);
                j.cubicTo(39.497868f, 34.750427f, 41.87496f, 16.05255f, 53.198692f, 10.63516f);
                j.cubicTo(64.52242f, 5.217771f, 71.405556f, 7.708689f, 76.82161f, 1.0075728f);
                j.cubicTo(78.15621f, -0.6436917f, 79.45604f, 12.767504f, 74.10915f, 24.23966f);
                j.cubicTo(68.76226f, 35.711815f, 57.2631f, 32.031345f, 51.075695f, 31.984705f);
                j.cubicTo(44.88829f, 31.938068f, 39.42424f, 37.74841f, 39.461056f, 36.24942f);
                j.lineTo(39.461056f, 36.24942f);
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
