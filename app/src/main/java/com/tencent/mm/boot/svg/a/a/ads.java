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

public final class ads extends c {
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
                e = c.a(e, 1.0f, 0.0f, 51.0f, 0.0f, 1.0f, 39.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(31.624044f, 90.34997f);
                j.cubicTo(32.383965f, 91.14044f, 33.629753f, 91.13373f, 34.386406f, 90.3389f);
                j.cubicTo(34.386406f, 90.3389f, 66.0f, 58.57656f, 66.0f, 33.461914f);
                j.cubicTo(66.0f, 14.90092f, 51.225395f, 0.0f, 33.47826f, 0.0f);
                j.cubicTo(14.774603f, 0.0f, 0.0f, 14.90092f, 0.0f, 33.461914f);
                j.cubicTo(0.0f, 58.57656f, 31.624044f, 90.34997f, 31.624044f, 90.34997f);
                j.close();
                j.moveTo(33.0f, 44.30819f);
                j.cubicTo(39.07513f, 44.30819f, 44.0f, 39.348827f, 44.0f, 33.231144f);
                j.cubicTo(44.0f, 27.113459f, 39.07513f, 22.154095f, 33.0f, 22.154095f);
                j.cubicTo(26.924868f, 22.154095f, 22.0f, 27.113459f, 22.0f, 33.231144f);
                j.cubicTo(22.0f, 39.348827f, 26.924868f, 44.30819f, 33.0f, 44.30819f);
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
