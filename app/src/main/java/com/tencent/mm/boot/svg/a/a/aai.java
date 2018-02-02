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

public final class aai extends c {
    private final int height = 107;
    private final int width = 107;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 107;
            case 1:
                return 107;
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
                j.moveTo(29.0f, 22.005177f);
                j.cubicTo(29.0f, 20.897749f, 29.90195f, 20.0f, 31.00853f, 20.0f);
                j.lineTo(38.99147f, 20.0f);
                j.cubicTo(40.10075f, 20.0f, 41.0f, 20.89647f, 41.0f, 22.005177f);
                j.lineTo(41.0f, 84.99482f);
                j.cubicTo(41.0f, 86.10225f, 40.09805f, 87.0f, 38.99147f, 87.0f);
                j.lineTo(31.00853f, 87.0f);
                j.cubicTo(29.89925f, 87.0f, 29.0f, 86.10353f, 29.0f, 84.99482f);
                j.lineTo(29.0f, 22.005177f);
                j.close();
                j.moveTo(66.0f, 22.005177f);
                j.cubicTo(66.0f, 20.897749f, 66.90195f, 20.0f, 68.00853f, 20.0f);
                j.lineTo(75.99147f, 20.0f);
                j.cubicTo(77.10075f, 20.0f, 78.0f, 20.89647f, 78.0f, 22.005177f);
                j.lineTo(78.0f, 84.99482f);
                j.cubicTo(78.0f, 86.10225f, 77.09805f, 87.0f, 75.99147f, 87.0f);
                j.lineTo(68.00853f, 87.0f);
                j.cubicTo(66.89925f, 87.0f, 66.0f, 86.10353f, 66.0f, 84.99482f);
                j.lineTo(66.0f, 22.005177f);
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
