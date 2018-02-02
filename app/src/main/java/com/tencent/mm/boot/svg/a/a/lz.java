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

public final class lz extends c {
    private final int height = 80;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
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
                i2.setColor(-12206054);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(46.16f, 67.69f);
                j.cubicTo(68.72f, 45.13f, 91.28f, 22.57f, 113.84f, 0.01f);
                j.cubicTo(115.9f, 2.05f, 117.95f, 4.1f, 119.99f, 6.16f);
                j.cubicTo(95.39f, 30.78f, 70.77f, 55.38f, 46.16f, 79.99f);
                j.cubicTo(30.77f, 64.62f, 15.38f, 49.24f, 0.01f, 33.85f);
                j.cubicTo(2.05f, 31.79f, 4.1f, 29.74f, 6.16f, 27.71f);
                j.cubicTo(19.5f, 41.02f, 32.81f, 54.37f, 46.16f, 67.69f);
                j.lineTo(46.16f, 67.69f);
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
