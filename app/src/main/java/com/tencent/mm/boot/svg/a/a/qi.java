package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.g.g;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class qi extends c {
    private final int height = i.CTRL_INDEX;
    private final int width = g.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return g.CTRL_INDEX;
            case 1:
                return i.CTRL_INDEX;
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
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 25, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(228.0f, 94.73752f);
                j.lineTo(228.0f, 12.0f);
                j.lineTo(12.0f, 12.0f);
                j.lineTo(12.0f, 119.51874f);
                j.lineTo(80.73831f, 55.335876f);
                j.lineTo(162.56027f, 130.40851f);
                j.lineTo(150.84477f, 106.321465f);
                j.lineTo(184.2155f, 80.51195f);
                j.lineTo(206.87204f, 100.85361f);
                j.cubicTo(187.48631f, 110.75349f, 174.0f, 131.23582f, 174.0f, 155.24074f);
                j.cubicTo(174.0f, 166.45111f, 177.2164f, 176.99875f, 182.76556f, 186.00002f);
                j.lineTo(5.9924946f, 186.0f);
                j.cubicTo(2.6953125f, 186.0f, 0.0f, 183.3119f, 0.0f, 179.99596f);
                j.lineTo(0.0f, 6.004041f);
                j.cubicTo(0.0f, 2.6830428f, 2.6829312f, 1.364242E-12f, 5.9924946f, 1.364242E-12f);
                j.lineTo(234.0075f, 1.364242E-12f);
                j.cubicTo(237.30469f, 1.364242E-12f, 240.0f, 2.6881008f, 240.0f, 6.004041f);
                j.lineTo(240.0f, 94.85917f);
                j.cubicTo(237.78893f, 94.62174f, 235.54f, 94.5f, 233.25926f, 94.5f);
                j.cubicTo(231.48848f, 94.5f, 229.73422f, 94.58025f, 228.0f, 94.73752f);
                j.lineTo(228.0f, 94.73752f);
                j.close();
                j.moveTo(283.0f, 155.11111f);
                j.cubicTo(283.0f, 127.16133f, 260.83865f, 105.0f, 232.88889f, 105.0f);
                j.cubicTo(206.16133f, 105.0f, 184.0f, 127.16133f, 184.0f, 155.11111f);
                j.cubicTo(184.0f, 181.83867f, 206.16133f, 204.0f, 232.88889f, 204.0f);
                j.cubicTo(260.83865f, 204.0f, 283.0f, 181.83867f, 283.0f, 155.11111f);
                j.close();
                j.moveTo(233.5f, 178.58653f);
                j.cubicTo(235.98528f, 178.58653f, 238.0f, 176.55244f, 238.0f, 174.04327f);
                j.cubicTo(238.0f, 171.53409f, 235.98528f, 169.5f, 233.5f, 169.5f);
                j.cubicTo(231.01472f, 169.5f, 229.0f, 171.53409f, 229.0f, 174.04327f);
                j.cubicTo(229.0f, 176.55244f, 231.01472f, 178.58653f, 233.5f, 178.58653f);
                j.close();
                j.moveTo(230.34857f, 129.0f);
                j.cubicTo(229.52448f, 129.0f, 228.88528f, 129.6712f, 228.92096f, 130.50104f);
                j.lineTo(230.32753f, 163.21475f);
                j.cubicTo(230.36992f, 164.20071f, 231.20103f, 165.0f, 232.19511f, 165.0f);
                j.lineTo(234.80493f, 165.0f);
                j.cubicTo(235.79398f, 165.0f, 236.63025f, 164.19762f, 236.67252f, 163.21475f);
                j.lineTo(238.07909f, 130.50104f);
                j.cubicTo(238.11473f, 129.67204f, 237.47571f, 129.0f, 236.65147f, 129.0f);
                j.lineTo(230.34857f, 129.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
