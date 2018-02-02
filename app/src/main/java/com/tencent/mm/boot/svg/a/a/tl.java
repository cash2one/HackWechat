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

public final class tl extends c {
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
                c.a(i3, looper).setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 32.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(28.0f, 38.0f);
                j.cubicTo(33.522846f, 38.0f, 38.0f, 33.522846f, 38.0f, 28.0f);
                j.cubicTo(38.0f, 22.477152f, 33.522846f, 18.0f, 28.0f, 18.0f);
                j.cubicTo(22.477152f, 18.0f, 18.0f, 22.477152f, 18.0f, 28.0f);
                j.cubicTo(18.0f, 33.522846f, 22.477152f, 38.0f, 28.0f, 38.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(26.0f, 0.0f);
                j2.lineTo(30.0f, 0.0f);
                j2.lineTo(30.0f, 9.0f);
                j2.lineTo(26.0f, 9.0f);
                j2.lineTo(26.0f, 0.0f);
                j2.close();
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(26.0f, 47.0f);
                j2.lineTo(30.0f, 47.0f);
                j2.lineTo(30.0f, 56.0f);
                j2.lineTo(26.0f, 56.0f);
                j2.lineTo(26.0f, 47.0f);
                j2.close();
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(47.0f, 25.0f);
                j2.lineTo(56.0f, 25.0f);
                j2.lineTo(56.0f, 29.0f);
                j2.lineTo(47.0f, 29.0f);
                j2.lineTo(47.0f, 25.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(-1.9984014E-16f, 25.0f);
                j2.lineTo(9.0f, 25.0f);
                j2.lineTo(9.0f, 29.0f);
                j2.lineTo(-1.9984014E-16f, 29.0f);
                j2.lineTo(-1.9984014E-16f, 25.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
