package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
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

public final class als extends c {
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
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a = c.a(i2, looper);
                a.setColor(-9473160);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(48.0f, 2.2325583f);
                j.cubicTo(22.722824f, 2.2325583f, 2.2325583f, 22.722431f, 2.2325583f, 48.0f);
                j.cubicTo(2.2325583f, 73.277565f, 22.722824f, 93.76744f, 48.0f, 93.76744f);
                j.cubicTo(73.277176f, 93.76744f, 93.76744f, 73.277565f, 93.76744f, 48.0f);
                j.cubicTo(93.76744f, 22.722431f, 73.277176f, 2.2325583f, 48.0f, 2.2325583f);
                j.lineTo(48.0f, 0.0f);
                j.cubicTo(74.50971f, 3.96582E-15f, 96.0f, 21.488955f, 96.0f, 48.0f);
                j.cubicTo(96.0f, 74.51105f, 74.50971f, 96.0f, 48.0f, 96.0f);
                j.cubicTo(21.490286f, 96.0f, 0.0f, 74.51105f, 0.0f, 48.0f);
                j.cubicTo(0.0f, 21.488955f, 21.490286f, 3.96582E-15f, 48.0f, 3.96582E-15f);
                j.lineTo(48.0f, 2.2325583f);
                j.close();
                j.moveTo(48.0f, 78.0f);
                j.cubicTo(31.26898f, 78.0f, 21.57295f, 68.294815f, 20.0f, 54.0f);
                j.lineTo(76.0f, 54.0f);
                j.cubicTo(74.426834f, 68.29482f, 64.72965f, 78.0f, 48.0f, 78.0f);
                j.close();
                j.moveTo(64.5f, 44.0f);
                j.cubicTo(67.53757f, 44.0f, 70.0f, 40.865993f, 70.0f, 37.0f);
                j.cubicTo(70.0f, 33.134007f, 67.53757f, 30.0f, 64.5f, 30.0f);
                j.cubicTo(61.462433f, 30.0f, 59.0f, 33.134007f, 59.0f, 37.0f);
                j.cubicTo(59.0f, 40.865993f, 61.462433f, 44.0f, 64.5f, 44.0f);
                j.close();
                j.moveTo(31.5f, 44.0f);
                j.cubicTo(34.537567f, 44.0f, 37.0f, 40.865993f, 37.0f, 37.0f);
                j.cubicTo(37.0f, 33.134007f, 34.537567f, 30.0f, 31.5f, 30.0f);
                j.cubicTo(28.462435f, 30.0f, 26.0f, 33.134007f, 26.0f, 37.0f);
                j.cubicTo(26.0f, 40.865993f, 28.462435f, 44.0f, 31.5f, 44.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(419430400);
                j = c.j(looper);
                j.moveTo(48.0f, 0.0f);
                j.cubicTo(74.509674f, 0.0f, 96.0f, 21.49033f, 96.0f, 48.0f);
                j.cubicTo(96.0f, 74.509674f, 74.509674f, 96.0f, 48.0f, 96.0f);
                j.cubicTo(21.49033f, 96.0f, 0.0f, 74.509674f, 0.0f, 48.0f);
                j.cubicTo(0.0f, 21.49033f, 21.49033f, 0.0f, 48.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
