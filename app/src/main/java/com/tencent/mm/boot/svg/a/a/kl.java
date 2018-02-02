package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class kl extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 6.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-5066062);
                a2.setStrokeWidth(3.1751997f);
                Path j = c.j(looper);
                j.moveTo(1.5875999f, 2.1751997f);
                j.cubicTo(1.5875999f, 1.2983925f, 2.2983925f, 0.5875999f, 3.1751997f, 0.5875999f);
                j.lineTo(38.8248f, 0.5875999f);
                j.cubicTo(39.701607f, 0.5875999f, 40.4124f, 1.2983925f, 40.4124f, 2.1751997f);
                j.lineTo(40.4124f, 27.8248f);
                j.cubicTo(40.4124f, 28.701607f, 39.701607f, 29.412401f, 38.8248f, 29.412401f);
                j.lineTo(3.1751997f, 29.412401f);
                j.cubicTo(2.2983925f, 29.412401f, 1.5875999f, 28.701607f, 1.5875999f, 27.8248f);
                j.lineTo(1.5875999f, 2.1751997f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(i2, looper);
                a3.setColor(-5066062);
                Path j2 = c.j(looper);
                j2.moveTo(31.32f, 14.56f);
                j2.lineTo(26.1f, 19.735f);
                j2.lineTo(28.188f, 23.875f);
                j2.lineTo(13.572f, 10.42f);
                j2.lineTo(0.0f, 22.84f);
                j2.lineTo(0.0f, 29.05f);
                j2.lineTo(40.716f, 29.05f);
                j2.lineTo(40.716f, 22.84f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
