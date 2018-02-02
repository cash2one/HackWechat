package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
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

public final class ahr extends c {
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
                i2.setColor(-1973786);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(168.0f, 0.0f);
                j.lineTo(168.0f, 168.0f);
                j.lineTo(0.0f, 168.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                j.moveTo(0.0f, 11.997895f);
                j.cubicTo(0.0f, 5.3716407f, 5.3758125f, 0.0f, 11.997895f, 0.0f);
                j.lineTo(156.0021f, 0.0f);
                j.cubicTo(162.62836f, 0.0f, 168.0f, 5.3758125f, 168.0f, 11.997895f);
                j.lineTo(168.0f, 156.0021f);
                j.cubicTo(168.0f, 162.62836f, 162.62419f, 168.0f, 156.0021f, 168.0f);
                j.lineTo(11.997895f, 168.0f);
                j.cubicTo(5.3716407f, 168.0f, 0.0f, 162.62419f, 0.0f, 156.0021f);
                j.lineTo(0.0f, 11.997895f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
