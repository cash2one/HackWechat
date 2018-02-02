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

public final class aeb extends c {
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1711276033);
                Path j = c.j(looper);
                j.moveTo(0.0f, 36.0f);
                j.cubicTo(0.0f, 16.117748f, 16.117748f, 0.0f, 36.0f, 0.0f);
                j.lineTo(132.0f, 0.0f);
                j.cubicTo(151.88225f, 0.0f, 168.0f, 16.117748f, 168.0f, 36.0f);
                j.lineTo(168.0f, 132.0f);
                j.cubicTo(168.0f, 151.88225f, 151.88225f, 168.0f, 132.0f, 168.0f);
                j.lineTo(36.0f, 168.0f);
                j.cubicTo(16.117748f, 168.0f, 0.0f, 151.88225f, 0.0f, 132.0f);
                j.lineTo(0.0f, 36.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-2565928);
                j = c.j(looper);
                j.moveTo(0.0f, 36.00155f);
                j.cubicTo(0.0f, 16.118443f, 16.108547f, 0.0f, 36.00155f, 0.0f);
                j.lineTo(131.99844f, 0.0f);
                j.cubicTo(151.88156f, 0.0f, 168.0f, 16.108547f, 168.0f, 36.00155f);
                j.lineTo(168.0f, 131.99844f);
                j.cubicTo(168.0f, 151.88156f, 151.89145f, 168.0f, 131.99844f, 168.0f);
                j.lineTo(36.00155f, 168.0f);
                j.cubicTo(16.118443f, 168.0f, 0.0f, 151.89145f, 0.0f, 131.99844f);
                j.lineTo(0.0f, 36.00155f);
                j.close();
                j.moveTo(2.0f, 37.00608f);
                j.cubicTo(2.0f, 17.672756f, 17.66928f, 2.0f, 37.00608f, 2.0f);
                j.lineTo(130.99391f, 2.0f);
                j.cubicTo(150.32724f, 2.0f, 166.0f, 17.66928f, 166.0f, 37.00608f);
                j.lineTo(166.0f, 130.99391f);
                j.cubicTo(166.0f, 150.32724f, 150.33072f, 166.0f, 130.99391f, 166.0f);
                j.lineTo(37.00608f, 166.0f);
                j.cubicTo(17.672756f, 166.0f, 2.0f, 150.33072f, 2.0f, 130.99391f);
                j.lineTo(2.0f, 37.00608f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
