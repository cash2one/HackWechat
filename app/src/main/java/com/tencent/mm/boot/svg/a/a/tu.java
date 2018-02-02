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

public final class tu extends c {
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 43.0f, 0.0f, 1.0f, 20.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(5.0f, 10.0f);
                j.cubicTo(7.7614236f, 10.0f, 10.0f, 7.7614236f, 10.0f, 5.0f);
                j.cubicTo(10.0f, 2.2385762f, 7.7614236f, 0.0f, 5.0f, 0.0f);
                j.cubicTo(2.2385762f, 0.0f, 0.0f, 2.2385762f, 0.0f, 5.0f);
                j.cubicTo(0.0f, 7.7614236f, 2.2385762f, 10.0f, 5.0f, 10.0f);
                j.close();
                j.moveTo(5.0f, 33.0f);
                j.cubicTo(7.7614236f, 33.0f, 10.0f, 30.761423f, 10.0f, 28.0f);
                j.cubicTo(10.0f, 25.238577f, 7.7614236f, 23.0f, 5.0f, 23.0f);
                j.cubicTo(2.2385762f, 23.0f, 0.0f, 25.238577f, 0.0f, 28.0f);
                j.cubicTo(0.0f, 30.761423f, 2.2385762f, 33.0f, 5.0f, 33.0f);
                j.close();
                j.moveTo(5.0f, 56.0f);
                j.cubicTo(7.7614236f, 56.0f, 10.0f, 53.761425f, 10.0f, 51.0f);
                j.cubicTo(10.0f, 48.238575f, 7.7614236f, 46.0f, 5.0f, 46.0f);
                j.cubicTo(2.2385762f, 46.0f, 0.0f, 48.238575f, 0.0f, 51.0f);
                j.cubicTo(0.0f, 53.761425f, 2.2385762f, 56.0f, 5.0f, 56.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
