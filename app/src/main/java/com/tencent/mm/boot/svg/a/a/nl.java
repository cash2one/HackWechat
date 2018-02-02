package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class nl extends c {
    private final int height = ar.CTRL_INDEX;
    private final int width = ar.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return ar.CTRL_INDEX;
            case 1:
                return ar.CTRL_INDEX;
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
                i3 = c.a(i2, looper);
                i3.setColor(-14187817);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(192.0f, 0.0f);
                j.lineTo(192.0f, 192.0f);
                j.lineTo(0.0f, 192.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(110.90694f, 140.57062f);
                j2.cubicTo(115.39648f, 133.81949f, 120.514946f, 125.826996f, 125.18189f, 117.83344f);
                j2.cubicTo(132.5147f, 105.2738f, 118.942276f, 91.864136f, 121.05859f, 88.2393f);
                j2.lineTo(133.6816f, 66.618614f);
                j2.lineTo(137.24696f, 68.6542f);
                j2.lineTo(140.59984f, 62.91139f);
                j2.lineTo(114.816216f, 48.190643f);
                j2.lineTo(111.46334f, 53.933456f);
                j2.lineTo(113.825035f, 55.28183f);
                j2.lineTo(113.825035f, 55.28183f);
                j2.cubicTo(110.083145f, 61.69095f, 102.824165f, 74.12414f, 101.20204f, 76.90253f);
                j2.cubicTo(98.99318f, 80.68586f, 81.064964f, 75.49447f, 73.554855f, 88.35781f);
                j2.cubicTo(67.73289f, 98.32967f, 53.740925f, 118.98361f, 48.758373f, 126.291245f);
                j2.cubicTo(59.07041f, 125.45091f, 74.24749f, 125.95091f, 88.1873f, 133.06181f);
                j2.cubicTo(96.19743f, 137.1479f, 103.822685f, 139.4944f, 110.90694f, 140.57062f);
                j2.lineTo(110.90694f, 140.57062f);
                j2.close();
                j2.moveTo(132.08064f, 36.41379f);
                j2.lineTo(124.87423f, 49.809467f);
                j2.lineTo(135.35979f, 56.026367f);
                j2.lineTo(149.97533f, 45.104786f);
                j2.lineTo(132.08064f, 36.41379f);
                j2.close();
                j2.moveTo(157.39185f, 138.754f);
                j2.cubicTo(157.39185f, 138.754f, 137.7422f, 158.59561f, 114.86281f, 158.59561f);
                j2.cubicTo(65.0383f, 158.59561f, 84.342834f, 136.6334f, 26.48276f, 134.37212f);
                j2.cubicTo(26.479265f, 134.37747f, 58.087933f, 125.80052f, 85.2693f, 138.754f);
                j2.cubicTo(126.68277f, 158.48987f, 157.39185f, 138.754f, 157.39185f, 138.754f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
