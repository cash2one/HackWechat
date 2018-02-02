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

public final class ady extends c {
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
                e = c.a(e, 1.0f, 0.0f, 50.0f, 0.0f, 1.0f, 38.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(12.770331f, 24.77644f);
                j.lineTo(7.3576727f, 21.65144f);
                j.lineTo(4.84934f, 25.995998f);
                j.cubicTo(-3.6885855f, 40.78412f, -0.6132603f, 59.150406f, 11.409091f, 69.63418f);
                j.lineTo(5.4629607f, 79.933174f);
                j.lineTo(16.288279f, 86.183174f);
                j.lineTo(22.23441f, 75.88418f);
                j.lineTo(22.23441f, 75.88418f);
                j.cubicTo(37.324795f, 81.053955f, 54.768127f, 74.53412f, 63.306053f, 59.746f);
                j.lineTo(65.814384f, 55.40144f);
                j.lineTo(60.40173f, 52.27644f);
                j.lineTo(57.893394f, 56.621f);
                j.cubicTo(49.83918f, 70.57131f, 32.80783f, 75.44613f, 20.184023f, 68.157776f);
                j.cubicTo(6.501737f, 60.2583f, 2.207783f, 43.07131f, 10.261999f, 29.120998f);
                j.lineTo(12.770331f, 24.77644f);
                j.lineTo(12.770331f, 24.77644f);
                j.close();
                j.moveTo(57.279774f, 2.683821f);
                j.cubicTo(47.713924f, -2.8390265f, 35.48474f, 0.43392453f, 29.959208f, 10.004432f);
                j.lineTo(16.459326f, 33.386913f);
                j.cubicTo(10.936446f, 42.95282f, 14.21182f, 55.18346f, 23.779776f, 60.707523f);
                j.cubicTo(33.345627f, 66.23037f, 45.574806f, 62.95742f, 51.10034f, 53.386913f);
                j.lineTo(64.60023f, 30.00443f);
                j.cubicTo(70.12311f, 20.438522f, 66.84773f, 8.207883f, 57.279774f, 2.683821f);
                j.lineTo(57.279774f, 2.683821f);
                j.close();
                j.moveTo(4.351049f, 83.59714f);
                j.cubicTo(4.272484f, 82.7733f, 4.7908106f, 82.44148f, 5.5145807f, 82.85935f);
                j.lineTo(13.728326f, 87.60156f);
                j.cubicTo(14.4494915f, 88.01793f, 14.420938f, 88.635574f, 13.671152f, 88.9781f);
                j.lineTo(6.5948305f, 92.21079f);
                j.cubicTo(5.8420887f, 92.55467f, 5.167873f, 92.16235f, 5.089617f, 91.34176f);
                j.lineTo(4.351049f, 83.59714f);
                j.lineTo(4.351049f, 83.59714f);
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
