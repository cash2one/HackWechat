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

public final class abf extends c {
    private final int height = 38;
    private final int width = 24;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 38;
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
                i2.setColor(-3684404);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(24.0f, 18.928122f);
                j.cubicTo(17.76f, 25.30391f, 11.27f, 31.564438f, 5.0f, 37.856243f);
                j.cubicTo(3.9782472f, 37.015377f, 0.34215337f, 33.172558f, 0.0f, 32.87516f);
                j.cubicTo(4.52f, 28.130583f, 10.31f, 23.60038f, 15.0f, 18.928122f);
                j.cubicTo(10.89f, 14.514881f, 0.0f, 3.9848678f, 0.0f, 3.9848678f);
                j.cubicTo(0.046293356f, 3.965954f, 3.7586608f, 0.9880148f, 5.0f, 0.0f);
                j.cubicTo(5.0f, 0.0f, 18.55f, 13.568475f, 24.0f, 18.928122f);
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
