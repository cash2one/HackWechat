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

public final class aea extends c {
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
                e = c.a(e, 1.0f, 0.0f, 46.0f, 0.0f, 1.0f, 41.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(58.04338f, 85.02192f);
                j.cubicTo(68.83248f, 74.17345f, 75.5f, 59.221767f, 75.5f, 42.712807f);
                j.cubicTo(75.5f, 25.998095f, 68.66525f, 10.879722f, 57.638073f, 5.1184834E-11f);
                j.lineTo(50.21325f, 7.424826f);
                j.cubicTo(59.340397f, 16.404242f, 65.0f, 28.897589f, 65.0f, 42.712807f);
                j.cubicTo(65.0f, 56.322273f, 59.507717f, 68.64895f, 50.618725f, 77.59726f);
                j.lineTo(58.04338f, 85.02192f);
                j.close();
                j.moveTo(40.01204f, 66.99058f);
                j.cubicTo(46.186604f, 60.7568f, 50.0f, 52.180138f, 50.0f, 42.712807f);
                j.cubicTo(50.0f, 33.039722f, 46.01905f, 24.29644f, 39.606136f, 18.031939f);
                j.lineTo(32.18078f, 25.457294f);
                j.cubicTo(36.693905f, 29.821022f, 39.5f, 35.939213f, 39.5f, 42.712807f);
                j.cubicTo(39.5f, 49.280643f, 36.86179f, 55.232292f, 32.587296f, 59.565834f);
                j.lineTo(40.01204f, 66.99058f);
                j.close();
                j.moveTo(13.0f, 55.5f);
                j.cubicTo(20.1797f, 55.5f, 26.0f, 49.679703f, 26.0f, 42.5f);
                j.cubicTo(26.0f, 35.320297f, 20.1797f, 29.5f, 13.0f, 29.5f);
                j.cubicTo(5.820298f, 29.5f, 0.0f, 35.320297f, 0.0f, 42.5f);
                j.cubicTo(0.0f, 49.679703f, 5.820298f, 55.5f, 13.0f, 55.5f);
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
