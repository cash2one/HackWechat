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

public final class gt extends c {
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
                j.moveTo(8.0f, 32.0f);
                j.cubicTo(8.0f, 28.68629f, 10.686291f, 26.0f, 14.0f, 26.0f);
                j.lineTo(130.0f, 26.0f);
                j.cubicTo(133.3137f, 26.0f, 136.0f, 28.68629f, 136.0f, 32.0f);
                j.lineTo(136.0f, 112.0f);
                j.cubicTo(136.0f, 115.313705f, 133.3137f, 118.0f, 130.0f, 118.0f);
                j.lineTo(14.0f, 118.0f);
                j.cubicTo(10.686291f, 118.0f, 8.0f, 115.313705f, 8.0f, 112.0f);
                j.lineTo(8.0f, 32.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(71.88509f, 65.0309f);
                j.lineTo(27.494259f, 39.401836f);
                j.cubicTo(26.058262f, 38.57276f, 24.230272f, 39.068474f, 23.401754f, 40.50351f);
                j.lineTo(21.402084f, 43.967037f);
                j.cubicTo(20.576242f, 45.39744f, 21.06255f, 47.23549f, 22.494259f, 48.062088f);
                j.lineTo(70.312874f, 75.67018f);
                j.cubicTo(70.809265f, 75.95677f, 71.3525f, 76.08506f, 71.88509f, 76.07097f);
                j.cubicTo(72.417694f, 76.08506f, 72.96093f, 75.95677f, 73.45732f, 75.67018f);
                j.lineTo(121.27593f, 48.062088f);
                j.cubicTo(122.70764f, 47.23549f, 123.19395f, 45.39744f, 122.36811f, 43.967037f);
                j.lineTo(120.36844f, 40.50351f);
                j.cubicTo(119.53992f, 39.068474f, 117.71193f, 38.57276f, 116.27593f, 39.401836f);
                j.lineTo(71.88509f, 65.0309f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
