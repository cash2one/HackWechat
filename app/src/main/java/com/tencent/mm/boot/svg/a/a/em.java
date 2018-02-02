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

public final class em extends c {
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
                i2 = c.a(i2, looper);
                i2.setColor(-8421505);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(101.0f, 91.0f);
                j.lineTo(101.0f, 55.997814f);
                j.cubicTo(101.0f, 54.350853f, 99.65671f, 53.0f, 97.99967f, 53.0f);
                j.lineTo(94.00033f, 53.0f);
                j.cubicTo(92.34865f, 53.0f, 91.0f, 54.342167f, 91.0f, 55.997814f);
                j.lineTo(91.0f, 91.0f);
                j.lineTo(55.997814f, 91.0f);
                j.cubicTo(54.350853f, 91.0f, 53.0f, 92.34329f, 53.0f, 94.00033f);
                j.lineTo(53.0f, 97.99967f);
                j.cubicTo(53.0f, 99.65135f, 54.342167f, 101.0f, 55.997814f, 101.0f);
                j.lineTo(91.0f, 101.0f);
                j.lineTo(91.0f, 136.00218f);
                j.cubicTo(91.0f, 137.64914f, 92.34329f, 139.0f, 94.00033f, 139.0f);
                j.lineTo(97.99967f, 139.0f);
                j.cubicTo(99.65135f, 139.0f, 101.0f, 137.65784f, 101.0f, 136.00218f);
                j.lineTo(101.0f, 101.0f);
                j.lineTo(136.00218f, 101.0f);
                j.cubicTo(137.64914f, 101.0f, 139.0f, 99.65671f, 139.0f, 97.99967f);
                j.lineTo(139.0f, 94.00033f);
                j.cubicTo(139.0f, 92.34865f, 137.65784f, 91.0f, 136.00218f, 91.0f);
                j.lineTo(101.0f, 91.0f);
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
