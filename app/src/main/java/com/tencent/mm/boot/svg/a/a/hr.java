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

public final class hr extends c {
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
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 40.0f, 0.0f, 1.0f, 8.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-8617851);
                Path j = c.j(looper);
                j.moveTo(8.0f, 65.0f);
                j.cubicTo(3.5817778f, 65.0f, 0.0f, 68.58178f, 0.0f, 73.0f);
                j.cubicTo(0.0f, 77.41822f, 3.5817778f, 81.0f, 8.0f, 81.0f);
                j.cubicTo(12.418222f, 81.0f, 16.0f, 77.41822f, 16.0f, 73.0f);
                j.cubicTo(16.0f, 68.58178f, 12.418222f, 65.0f, 8.0f, 65.0f);
                j.moveTo(8.0f, 32.0f);
                j.cubicTo(3.5817778f, 32.0f, 0.0f, 35.58178f, 0.0f, 40.0f);
                j.cubicTo(0.0f, 44.41822f, 3.5817778f, 48.0f, 8.0f, 48.0f);
                j.cubicTo(12.418222f, 48.0f, 16.0f, 44.41822f, 16.0f, 40.0f);
                j.cubicTo(16.0f, 35.58178f, 12.418222f, 32.0f, 8.0f, 32.0f);
                j.moveTo(16.0f, 8.0f);
                j.cubicTo(16.0f, 3.5817778f, 12.418222f, 0.0f, 8.0f, 0.0f);
                j.cubicTo(3.5817778f, 0.0f, 0.0f, 3.5817778f, 0.0f, 8.0f);
                j.cubicTo(0.0f, 12.418222f, 3.5817778f, 16.0f, 8.0f, 16.0f);
                j.cubicTo(12.418222f, 16.0f, 16.0f, 12.418222f, 16.0f, 8.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
