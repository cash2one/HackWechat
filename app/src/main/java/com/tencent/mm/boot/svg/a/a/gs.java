package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
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

public final class gs extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = e.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return e.CTRL_INDEX;
            case 1:
                return e.CTRL_INDEX;
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
                a.setColor(-9276814);
                Path j = c.j(looper);
                j.moveTo(90.0f, 38.572f);
                j.cubicTo(90.0f, 40.466f, 91.536f, 42.0f, 93.428f, 42.0f);
                j.lineTo(122.0f, 42.0f);
                j.lineTo(90.0f, 10.0f);
                j.lineTo(90.0f, 38.572f);
                j.lineTo(90.0f, 38.572f);
                j.close();
                j.moveTo(84.0f, 10.0f);
                j.lineTo(40.0f, 10.0f);
                j.cubicTo(36.686f, 10.0f, 34.0f, 12.686f, 34.0f, 16.0f);
                j.lineTo(34.0f, 116.0f);
                j.cubicTo(34.0f, 119.314f, 36.686f, 122.0f, 40.0f, 122.0f);
                j.lineTo(116.0f, 122.0f);
                j.cubicTo(119.314f, 122.0f, 122.0f, 119.314f, 122.0f, 116.0f);
                j.lineTo(122.0f, 48.0f);
                j.lineTo(90.0f, 48.0f);
                j.cubicTo(86.686f, 48.002f, 84.0f, 45.316f, 84.0f, 42.0f);
                j.lineTo(84.0f, 10.0f);
                j.close();
                j.moveTo(28.0f, 34.0f);
                j.cubicTo(24.686f, 34.0f, 22.0f, 36.686f, 22.0f, 40.0f);
                j.lineTo(22.0f, 128.0f);
                j.cubicTo(22.0f, 131.314f, 24.686f, 134.0f, 28.0f, 134.0f);
                j.lineTo(96.0f, 134.0f);
                j.cubicTo(99.314f, 134.0f, 102.0f, 131.314f, 102.0f, 128.0f);
                j.lineTo(34.0f, 128.0f);
                j.cubicTo(30.686f, 128.0f, 28.0f, 125.314f, 28.0f, 122.0f);
                j.lineTo(28.0f, 34.0f);
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
