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

public final class im extends c {
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
                j.moveTo(136.0f, 32.3276f);
                j.cubicTo(131.26967f, 34.436882f, 126.21149f, 35.84307f, 120.919136f, 36.452423f);
                j.cubicTo(126.352f, 33.218185f, 130.52031f, 28.062155f, 132.48738f, 21.921793f);
                j.cubicTo(127.4292f, 24.921665f, 121.809f, 27.124695f, 115.814125f, 28.29652f);
                j.cubicTo(111.03696f, 23.187365f, 104.19905f, 20.0f, 96.658615f, 20.0f);
                j.cubicTo(82.13977f, 20.0f, 70.38419f, 31.765121f, 70.38419f, 46.29575f);
                j.cubicTo(70.38419f, 48.358162f, 70.61837f, 50.3737f, 71.086716f, 52.295494f);
                j.cubicTo(49.261616f, 51.217415f, 29.91877f, 40.717865f, 16.94548f, 24.827919f);
                j.cubicTo(14.697402f, 28.718376f, 13.386023f, 33.218185f, 13.386023f, 38.046104f);
                j.cubicTo(13.386023f, 47.186337f, 18.022686f, 55.20162f, 25.094769f, 59.93579f);
                j.cubicTo(20.78595f, 59.795174f, 16.75814f, 58.62335f, 13.198683f, 56.654682f);
                j.lineTo(13.198683f, 56.98279f);
                j.cubicTo(13.198683f, 69.73225f, 22.237833f, 80.32555f, 34.274426f, 82.76294f);
                j.cubicTo(32.07318f, 83.37229f, 29.73143f, 83.7004f, 27.342846f, 83.7004f);
                j.cubicTo(25.656788f, 83.7004f, 24.017563f, 83.51291f, 22.378338f, 83.231674f);
                j.cubicTo(25.703623f, 93.68435f, 35.445297f, 101.27777f, 46.91987f, 101.51214f);
                j.cubicTo(37.92755f, 108.54309f, 26.593487f, 112.76166f, 14.2758875f, 112.76166f);
                j.cubicTo(12.168313f, 112.76166f, 10.0607395f, 112.62104f, 8.0f, 112.38667f);
                j.cubicTo(19.615074f, 119.83948f, 33.431393f, 124.19867f, 48.278084f, 124.19867f);
                j.cubicTo(96.61178f, 124.19867f, 123.02671f, 84.12226f, 123.02671f, 49.389366f);
                j.cubicTo(123.02671f, 48.264416f, 122.97987f, 47.09259f, 122.933044f, 45.96764f);
                j.cubicTo(128.03806f, 42.26467f, 132.48738f, 37.624245f, 136.0f, 32.3276f);
                j.lineTo(136.0f, 32.3276f);
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
