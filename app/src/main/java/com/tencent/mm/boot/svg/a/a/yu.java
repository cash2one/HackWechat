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

public final class yu extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                i2.setColor(-15683841);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(86.0f, 81.0f);
                j.lineTo(23.0f, 81.0f);
                j.cubicTo(21.344f, 81.0f, 20.0f, 79.657f, 20.0f, 78.0f);
                j.lineTo(20.0f, 31.0f);
                j.cubicTo(20.0f, 29.343f, 21.344f, 28.0f, 23.0f, 28.0f);
                j.lineTo(86.0f, 28.0f);
                j.cubicTo(87.656f, 28.0f, 89.0f, 29.343f, 89.0f, 31.0f);
                j.lineTo(89.0f, 78.0f);
                j.cubicTo(89.0f, 79.657f, 87.656f, 81.0f, 86.0f, 81.0f);
                j.lineTo(86.0f, 81.0f);
                j.close();
                j.moveTo(24.0f, 32.0f);
                j.lineTo(24.0f, 68.031f);
                j.lineTo(43.951f, 48.001f);
                j.lineTo(68.0f, 68.706f);
                j.lineTo(64.273f, 61.914f);
                j.lineTo(71.0f, 54.0f);
                j.lineTo(85.0f, 70.471f);
                j.lineTo(85.0f, 32.0f);
                j.lineTo(24.0f, 32.0f);
                j.lineTo(24.0f, 32.0f);
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
