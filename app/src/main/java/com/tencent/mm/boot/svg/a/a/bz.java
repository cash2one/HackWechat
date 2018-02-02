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

public final class bz extends c {
    private final int height = com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX;
    private final int width = com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX;
            case 1:
                return com.tencent.mm.plugin.appbrand.jsapi.map.c.CTRL_INDEX;
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
                a.setColor(-4605512);
                Path j = c.j(looper);
                j.moveTo(67.0f, 134.0f);
                j.cubicTo(104.003075f, 134.0f, 134.0f, 104.003075f, 134.0f, 67.0f);
                j.cubicTo(134.0f, 29.996922f, 104.003075f, 0.0f, 67.0f, 0.0f);
                j.cubicTo(29.996922f, 0.0f, 0.0f, 29.996922f, 0.0f, 67.0f);
                j.cubicTo(0.0f, 104.003075f, 29.996922f, 134.0f, 67.0f, 134.0f);
                j.close();
                j.moveTo(67.0f, 133.0f);
                j.cubicTo(103.45079f, 133.0f, 133.0f, 103.45079f, 133.0f, 67.0f);
                j.cubicTo(133.0f, 30.549206f, 103.45079f, 1.0f, 67.0f, 1.0f);
                j.cubicTo(30.549206f, 1.0f, 1.0f, 30.549206f, 1.0f, 67.0f);
                j.cubicTo(1.0f, 103.45079f, 30.549206f, 133.0f, 67.0f, 133.0f);
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
