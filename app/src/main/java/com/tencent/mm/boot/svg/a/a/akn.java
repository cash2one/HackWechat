package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class akn extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = 111;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 111;
            case 1:
                return e.CTRL_INDEX;
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                Paint a2 = c.a(i3, looper);
                a.setColor(-3355444);
                a2.setColor(-3355444);
                a2.setStrokeWidth(2.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 40.0f, 0.0f, 1.0f, 52.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Paint a4 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(16.837944f, 33.589672f);
                j.cubicTo(7.7312255f, 33.589672f, 0.26877472f, 26.054348f, 0.26877472f, 16.858696f);
                j.cubicTo(0.26877472f, 7.6630435f, 7.7312255f, 0.12771739f, 16.837944f, 0.12771739f);
                j.cubicTo(25.944664f, 0.12771739f, 33.407116f, 7.6630435f, 33.407116f, 16.858696f);
                j.cubicTo(33.407116f, 26.182066f, 25.944664f, 33.589672f, 16.837944f, 33.589672f);
                j.close();
                j.moveTo(16.837944f, 1.4048913f);
                j.cubicTo(8.363636f, 1.4048913f, 1.5335969f, 8.30163f, 1.5335969f, 16.858696f);
                j.cubicTo(1.5335969f, 25.41576f, 8.363636f, 32.3125f, 16.837944f, 32.3125f);
                j.cubicTo(25.312254f, 32.3125f, 32.142292f, 25.41576f, 32.142292f, 16.858696f);
                j.cubicTo(32.142292f, 8.429348f, 25.18577f, 1.4048913f, 16.837944f, 1.4048913f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a = c.a(a2, looper);
                j = c.j(looper);
                j.moveTo(39.35178f, 40.23098f);
                j.cubicTo(39.225296f, 40.23098f, 38.972332f, 40.23098f, 38.845848f, 40.10326f);
                j.lineTo(27.841898f, 28.991848f);
                j.cubicTo(27.588932f, 28.736412f, 27.588932f, 28.35326f, 27.841898f, 28.097826f);
                j.cubicTo(28.094862f, 27.842392f, 28.474308f, 27.842392f, 28.727272f, 28.097826f);
                j.lineTo(39.731224f, 39.20924f);
                j.cubicTo(39.984188f, 39.464672f, 39.984188f, 39.847828f, 39.731224f, 40.10326f);
                j.cubicTo(39.604744f, 40.23098f, 39.47826f, 40.23098f, 39.35178f, 40.23098f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
