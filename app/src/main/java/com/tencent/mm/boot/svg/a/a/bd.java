package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class bd extends c {
    private final int height = 80;
    private final int width = 80;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(32.10879f, 26.734407f);
                j.lineTo(32.10879f, 56.345825f);
                j.lineTo(32.10879f, 59.81005f);
                j.cubicTo(32.10879f, 63.036148f, 30.576809f, 66.21981f, 27.572372f, 67.575066f);
                j.cubicTo(27.01386f, 67.827f, 23.48564f, 68.58973f, 23.024942f, 68.679375f);
                j.cubicTo(18.598322f, 69.540695f, 15.1971445f, 67.022964f, 15.009837f, 63.314568f);
                j.cubicTo(14.82253f, 59.606167f, 17.336971f, 57.663437f, 20.254364f, 57.095776f);
                j.lineTo(26.388245f, 55.79136f);
                j.cubicTo(27.481236f, 55.558926f, 28.347324f, 54.479134f, 28.347324f, 53.37434f);
                j.lineTo(28.347324f, 25.242409f);
                j.cubicTo(28.341309f, 25.10356f, 28.354797f, 24.967648f, 28.385284f, 24.836742f);
                j.lineTo(28.385284f, 21.949265f);
                j.cubicTo(28.385284f, 21.397732f, 28.814762f, 20.83892f, 29.348425f, 20.700115f);
                j.lineTo(63.430626f, 11.835335f);
                j.cubicTo(63.962555f, 11.69698f, 64.39377f, 12.039573f, 64.39377f, 12.589663f);
                j.lineTo(64.39377f, 17.198563f);
                j.cubicTo(64.40323f, 17.2652f, 64.40813f, 17.333122f, 64.40813f, 17.402126f);
                j.lineTo(64.40813f, 48.572945f);
                j.lineTo(64.40813f, 52.037174f);
                j.cubicTo(64.40813f, 55.263268f, 62.876144f, 58.44693f, 59.871708f, 59.802193f);
                j.cubicTo(59.313194f, 60.054127f, 55.784973f, 60.816853f, 55.32428f, 60.906494f);
                j.cubicTo(50.89766f, 61.767815f, 47.49648f, 59.250088f, 47.309174f, 55.541687f);
                j.cubicTo(47.121864f, 51.83329f, 49.636307f, 49.890556f, 52.5537f, 49.3229f);
                j.lineTo(58.68758f, 48.01848f);
                j.cubicTo(59.78057f, 47.786045f, 60.64666f, 46.706253f, 60.64666f, 45.601463f);
                j.lineTo(60.64666f, 19.191336f);
                j.lineTo(32.10879f, 26.734407f);
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
