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

public final class aen extends c {
    private final int height = 79;
    private final int width = 66;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 79;
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
                j.moveTo(10.536117f, 55.789783f);
                j.cubicTo(4.649229f, 49.98656f, 1.0f, 41.91944f, 1.0f, 33.0f);
                j.cubicTo(1.0f, 15.326888f, 15.326888f, 1.0f, 33.0f, 1.0f);
                j.cubicTo(50.67311f, 1.0f, 65.0f, 15.326888f, 65.0f, 33.0f);
                j.cubicTo(65.0f, 41.959976f, 61.317528f, 50.059868f, 55.383484f, 55.868763f);
                j.lineTo(55.435028f, 55.92031f);
                j.lineTo(32.92031f, 78.43503f);
                j.lineTo(10.405592f, 55.92031f);
                j.lineTo(10.536117f, 55.789783f);
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
