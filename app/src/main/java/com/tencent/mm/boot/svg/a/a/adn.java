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

public final class adn extends c {
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
                j.moveTo(42.9994f, 66.0f);
                j.cubicTo(41.342876f, 66.0f, 40.0f, 67.33791f, 40.0f, 68.99988f);
                j.lineTo(40.0f, 114.00012f);
                j.cubicTo(40.0f, 115.656906f, 41.34472f, 117.0f, 42.9994f, 117.0f);
                j.lineTo(126.0006f, 117.0f);
                j.cubicTo(127.65712f, 117.0f, 129.0f, 115.66209f, 129.0f, 114.00012f);
                j.lineTo(129.0f, 68.99988f);
                j.cubicTo(129.0f, 67.343094f, 127.65528f, 66.0f, 126.0006f, 66.0f);
                j.lineTo(42.9994f, 66.0f);
                j.close();
                j.moveTo(58.95212f, 66.0f);
                j.cubicTo(65.85957f, 66.0f, 69.57021f, 52.0f, 76.2964f, 52.0f);
                j.lineTo(85.0f, 52.0f);
                j.lineTo(85.0f, 66.0f);
                j.lineTo(58.95212f, 66.0f);
                j.close();
                j.moveTo(111.047874f, 66.0f);
                j.cubicTo(104.14043f, 66.0f, 100.42979f, 52.0f, 93.7021f, 52.0f);
                j.lineTo(85.0f, 52.0f);
                j.lineTo(85.0f, 66.0f);
                j.lineTo(111.047874f, 66.0f);
                j.close();
                j.moveTo(84.5f, 70.0f);
                j.cubicTo(95.27f, 70.0f, 104.0f, 78.73f, 104.0f, 89.5f);
                j.cubicTo(104.0f, 100.27f, 95.27f, 109.0f, 84.5f, 109.0f);
                j.cubicTo(73.73f, 109.0f, 65.0f, 100.27f, 65.0f, 89.5f);
                j.cubicTo(65.0f, 78.73f, 73.73f, 70.0f, 84.5f, 70.0f);
                j.close();
                j.moveTo(84.5f, 74.0f);
                j.cubicTo(93.06065f, 74.0f, 100.0f, 80.93935f, 100.0f, 89.5f);
                j.cubicTo(100.0f, 98.06065f, 93.06065f, 105.0f, 84.5f, 105.0f);
                j.cubicTo(75.93935f, 105.0f, 69.0f, 98.06065f, 69.0f, 89.5f);
                j.cubicTo(69.0f, 80.93935f, 75.93935f, 74.0f, 84.5f, 74.0f);
                j.close();
                j.moveTo(47.0f, 58.0f);
                j.lineTo(58.0f, 58.0f);
                j.lineTo(58.0f, 63.0f);
                j.lineTo(47.0f, 63.0f);
                j.lineTo(47.0f, 58.0f);
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
