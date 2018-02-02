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

public final class adt extends c {
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
                e = c.a(e, 1.0f, 0.0f, 45.0f, 0.0f, 1.0f, 46.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(42.0f, 2.0f);
                j.cubicTo(42.0f, 1.5267029f, 42.533726f, 1.0f, 43.0f, 1.0f);
                j.lineTo(66.0f, 1.0f);
                j.cubicTo(66.467674f, 1.0f, 67.0f, 1.5246713f, 67.0f, 2.0f);
                j.lineTo(67.0f, 20.0f);
                j.cubicTo(67.0f, 20.473297f, 66.46627f, 21.0f, 66.0f, 21.0f);
                j.lineTo(43.0f, 21.0f);
                j.cubicTo(42.532326f, 21.0f, 42.0f, 20.475328f, 42.0f, 20.0f);
                j.lineTo(42.0f, 2.0f);
                j.close();
                j.moveTo(77.0f, 23.0f);
                j.cubicTo(78.13144f, 23.242155f, 79.0f, 22.596409f, 79.0f, 22.0f);
                j.lineTo(79.0f, 1.0f);
                j.cubicTo(79.0f, 0.2719795f, 78.03951f, -0.19214992f, 77.0f, 0.0f);
                j.cubicTo(76.582535f, 0.55645734f, 72.14961f, 4.76049f, 69.0f, 8.0f);
                j.lineTo(69.0f, 15.0f);
                j.cubicTo(72.226425f, 18.18812f, 76.75826f, 22.516397f, 77.0f, 23.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(29.119242f, 46.28759f);
                j.cubicTo(36.86187f, 54.187935f, 44.198097f, 57.89348f, 46.911064f, 57.67648f);
                j.cubicTo(49.62403f, 57.459484f, 56.380077f, 52.718697f, 59.569485f, 52.781796f);
                j.cubicTo(61.10234f, 52.812122f, 71.11908f, 59.724438f, 72.331604f, 60.523617f);
                j.cubicTo(73.54413f, 61.322792f, 74.66841f, 62.256332f, 74.45701f, 63.437634f);
                j.cubicTo(74.245605f, 64.618935f, 69.84337f, 77.63094f, 58.60445f, 75.82908f);
                j.cubicTo(47.36554f, 74.027214f, 31.696922f, 61.664673f, 22.76856f, 52.767635f);
                j.lineTo(29.119242f, 46.28759f);
                j.lineTo(29.119242f, 46.28759f);
                j.close();
                j.moveTo(29.119242f, 46.28759f);
                j.cubicTo(21.376614f, 38.38724f, 17.74505f, 30.901573f, 17.957714f, 28.13334f);
                j.cubicTo(18.170378f, 25.365108f, 22.816525f, 18.47144f, 22.754683f, 15.217063f);
                j.cubicTo(22.72496f, 13.652983f, 15.950641f, 3.4322f, 15.1674185f, 2.1949737f);
                j.cubicTo(14.384195f, 0.95774764f, 13.469295f, -0.18943463f, 12.311576f, 0.0262743f);
                j.cubicTo(11.153858f, 0.24198322f, -1.5983826f, 4.7338996f, 0.16751018f, 16.201754f);
                j.cubicTo(1.9334029f, 27.66961f, 14.049142f, 43.6574f, 22.76856f, 52.767635f);
                j.lineTo(29.119242f, 46.28759f);
                j.lineTo(29.119242f, 46.28759f);
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
