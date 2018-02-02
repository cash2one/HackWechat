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

public final class ii extends c {
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
                j.moveTo(32.316944f, 114.45962f);
                j.cubicTo(17.49707f, 103.41242f, 8.0f, 86.3897f, 8.0f, 67.29348f);
                j.cubicTo(8.0f, 33.99431f, 36.877632f, 7.0f, 72.5f, 7.0f);
                j.cubicTo(108.12237f, 7.0f, 137.0f, 33.99431f, 137.0f, 67.29348f);
                j.cubicTo(137.0f, 100.59264f, 108.12237f, 127.58696f, 72.5f, 127.58696f);
                j.cubicTo(66.06798f, 127.58696f, 59.85585f, 126.70688f, 53.993908f, 125.06851f);
                j.lineTo(32.316944f, 136.89055f);
                j.lineTo(32.316944f, 114.45962f);
                j.close();
                j.moveTo(30.467037f, 88.38713f);
                j.lineTo(66.017456f, 50.875744f);
                j.lineTo(82.72663f, 68.6543f);
                j.lineTo(114.75198f, 50.19022f);
                j.lineTo(79.51087f, 88.32609f);
                j.lineTo(63.189262f, 70.64465f);
                j.lineTo(30.467037f, 88.38713f);
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
