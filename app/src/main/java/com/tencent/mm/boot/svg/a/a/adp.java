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

public final class adp extends c {
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
                e = c.a(e, 1.0f, 0.0f, 43.0f, 0.0f, 1.0f, 39.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(3.0570092f, 20.547123f);
                j.lineTo(37.885f, 40.385174f);
                j.cubicTo(39.32787f, 41.20703f, 41.674564f, 41.20285f, 43.11009f, 40.385174f);
                j.lineTo(77.93808f, 20.547123f);
                j.cubicTo(79.38094f, 19.725264f, 79.35191f, 18.46529f, 77.860435f, 17.726551f);
                j.lineTo(43.187733f, 0.5529894f);
                j.cubicTo(41.70198f, -0.18291019f, 39.298836f, -0.18574806f, 37.807354f, 0.5529894f);
                j.lineTo(3.1346543f, 17.726551f);
                j.cubicTo(1.6489038f, 18.462452f, 1.6214863f, 19.729448f, 3.0570092f, 20.547123f);
                j.close();
                j.moveTo(45.611893f, 45.124817f);
                j.cubicTo(44.169384f, 45.93633f, 43.0f, 47.939342f, 43.0f, 49.58943f);
                j.lineTo(43.0f, 86.19463f);
                j.cubicTo(43.0f, 87.84886f, 44.158012f, 88.49412f, 45.56714f, 87.64748f);
                j.lineTo(78.43286f, 67.90081f);
                j.cubicTo(79.850655f, 67.048965f, 81.0f, 65.01293f, 81.0f, 63.366447f);
                j.lineTo(81.0f, 28.208572f);
                j.cubicTo(81.0f, 26.55616f, 79.82107f, 25.879847f, 78.38811f, 26.685984f);
                j.lineTo(45.611893f, 45.124817f);
                j.close();
                j.moveTo(35.388107f, 45.124817f);
                j.cubicTo(36.830616f, 45.93633f, 38.0f, 47.939342f, 38.0f, 49.58943f);
                j.lineTo(38.0f, 86.19463f);
                j.cubicTo(38.0f, 87.84886f, 36.841988f, 88.49412f, 35.43286f, 87.64748f);
                j.lineTo(2.5671375f, 67.90081f);
                j.cubicTo(1.1493466f, 67.048965f, 0.0f, 65.01293f, 0.0f, 63.366447f);
                j.lineTo(0.0f, 28.208572f);
                j.cubicTo(0.0f, 26.55616f, 1.1789339f, 25.879847f, 2.611894f, 26.685984f);
                j.lineTo(35.388107f, 45.124817f);
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
