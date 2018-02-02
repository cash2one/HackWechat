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

public final class gz extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                i2.setColor(-8617851);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(88.0f, 74.0f);
                j.lineTo(88.0f, 74.0f);
                j.lineTo(56.0f, 15.0f);
                j.lineTo(56.0f, 15.0f);
                j.cubicTo(54.97f, 11.577649f, 51.78977f, 9.0f, 48.0f, 9.0f);
                j.cubicTo(44.21023f, 9.0f, 41.029545f, 11.577649f, 40.0f, 15.0f);
                j.lineTo(40.0f, 15.0f);
                j.lineTo(8.0f, 74.0f);
                j.lineTo(8.0f, 74.0f);
                j.cubicTo(7.5070333f, 75.54358f, 7.0f, 77.10677f, 7.0f, 79.0f);
                j.cubicTo(7.0f, 83.32397f, 10.671322f, 87.0f, 15.0f, 87.0f);
                j.cubicTo(15.497933f, 87.0f, 15.791311f, 86.98221f, 16.0f, 87.0f);
                j.lineTo(16.0f, 87.0f);
                j.lineTo(48.0f, 87.0f);
                j.lineTo(48.0f, 79.0f);
                j.lineTo(44.0f, 79.0f);
                j.lineTo(44.0f, 71.0f);
                j.lineTo(48.0f, 71.0f);
                j.lineTo(48.0f, 62.0f);
                j.lineTo(44.0f, 62.0f);
                j.lineTo(42.0f, 34.0f);
                j.lineTo(48.0f, 34.0f);
                j.lineTo(48.0f, 25.0f);
                j.lineTo(48.0f, 25.0f);
                j.lineTo(48.0f, 25.0f);
                j.lineTo(48.0f, 34.0f);
                j.lineTo(54.0f, 34.0f);
                j.lineTo(52.0f, 62.0f);
                j.lineTo(48.0f, 62.0f);
                j.lineTo(48.0f, 71.0f);
                j.lineTo(52.0f, 71.0f);
                j.lineTo(52.0f, 79.0f);
                j.lineTo(48.0f, 79.0f);
                j.lineTo(48.0f, 87.0f);
                j.lineTo(80.0f, 87.0f);
                j.lineTo(80.0f, 87.0f);
                j.cubicTo(80.20824f, 86.98221f, 80.50207f, 87.0f, 81.0f, 87.0f);
                j.cubicTo(85.328674f, 87.0f, 89.0f, 83.32397f, 89.0f, 79.0f);
                j.cubicTo(89.0f, 77.10677f, 88.49251f, 75.54358f, 88.0f, 74.0f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
