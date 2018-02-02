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

public final class sr extends c {
    private final int height = 33;
    private final int width = 38;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 33;
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
                i2.setColor(-4547478);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(14.666667f, 23.0f);
                j.lineTo(33.0f, 23.0f);
                j.lineTo(33.0f, 5.0f);
                j.lineTo(5.0f, 5.0f);
                j.lineTo(5.0f, 23.0f);
                j.lineTo(11.0f, 23.0f);
                j.lineTo(11.0f, 26.0f);
                j.lineTo(14.666667f, 23.0f);
                j.close();
                j.moveTo(15.222222f, 27.0f);
                j.lineTo(35.000294f, 27.0f);
                j.cubicTo(36.110107f, 27.0f, 37.0f, 26.105911f, 37.0f, 25.002995f);
                j.lineTo(37.0f, 2.9970047f);
                j.cubicTo(37.0f, 1.8949789f, 36.104702f, 1.0f, 35.000294f, 1.0f);
                j.lineTo(2.9997072f, 1.0f);
                j.cubicTo(1.8898926f, 1.0f, 1.0f, 1.8940895f, 1.0f, 2.9970047f);
                j.lineTo(1.0f, 25.002995f);
                j.cubicTo(1.0f, 26.10502f, 1.8952994f, 27.0f, 2.9997072f, 27.0f);
                j.lineTo(8.0f, 27.0f);
                j.lineTo(8.0f, 32.0f);
                j.lineTo(15.222222f, 27.0f);
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
