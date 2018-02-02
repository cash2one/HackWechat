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

public final class adq extends c {
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
                i2.setColor(-8617594);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(129.0f, 72.0f);
                j.lineTo(129.0f, 60.0f);
                j.cubicTo(129.0f, 58.343147f, 127.65685f, 57.0f, 126.0f, 57.0f);
                j.lineTo(83.51111f, 57.0f);
                j.lineTo(75.6f, 49.0f);
                j.lineTo(43.0f, 49.0f);
                j.lineTo(43.0f, 49.0f);
                j.cubicTo(41.343147f, 49.0f, 40.0f, 50.343147f, 40.0f, 52.0f);
                j.lineTo(40.0f, 52.0f);
                j.lineTo(40.0f, 60.5f);
                j.lineTo(40.0f, 72.0f);
                j.lineTo(129.0f, 72.0f);
                j.close();
                j.moveTo(129.0f, 77.0f);
                j.lineTo(129.0f, 117.0f);
                j.cubicTo(129.0f, 118.65685f, 127.65685f, 120.0f, 126.0f, 120.0f);
                j.lineTo(43.0f, 120.0f);
                j.cubicTo(41.343147f, 120.0f, 40.0f, 118.65685f, 40.0f, 117.0f);
                j.lineTo(40.0f, 77.0f);
                j.lineTo(129.0f, 77.0f);
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
