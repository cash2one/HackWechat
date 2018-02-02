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

public final class afu extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                e = c.a(e, 1.0f, 0.0f, -392.0f, 0.0f, 1.0f, -141.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 392.0f, 0.0f, 1.0f, 141.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(60.0f, 0.0f);
                j.lineTo(60.0f, 60.0f);
                j.lineTo(0.0f, 60.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-5592406);
                j = c.j(looper);
                j.moveTo(30.0f, 16.0f);
                j.cubicTo(22.16f, 16.0f, 16.0f, 22.16f, 16.0f, 30.0f);
                j.cubicTo(16.0f, 37.84f, 22.16f, 44.0f, 30.0f, 44.0f);
                j.cubicTo(37.84f, 44.0f, 44.0f, 37.84f, 44.0f, 30.0f);
                j.cubicTo(44.0f, 22.16f, 37.84f, 16.0f, 30.0f, 16.0f);
                j.lineTo(30.0f, 16.0f);
                j.close();
                j.moveTo(30.0f, 6.0f);
                j.cubicTo(16.8f, 6.0f, 6.0f, 16.8f, 6.0f, 30.0f);
                j.cubicTo(6.0f, 43.2f, 16.8f, 54.0f, 30.0f, 54.0f);
                j.cubicTo(43.2f, 54.0f, 54.0f, 43.2f, 54.0f, 30.0f);
                j.cubicTo(54.0f, 16.8f, 43.2f, 6.0f, 30.0f, 6.0f);
                j.lineTo(30.0f, 6.0f);
                j.close();
                j.moveTo(10.0f, 30.0f);
                j.cubicTo(10.0f, 19.0f, 19.0f, 10.0f, 30.0f, 10.0f);
                j.cubicTo(41.0f, 10.0f, 50.0f, 19.0f, 50.0f, 30.0f);
                j.cubicTo(50.0f, 41.0f, 41.0f, 50.0f, 30.0f, 50.0f);
                j.cubicTo(19.0f, 50.0f, 10.0f, 41.0f, 10.0f, 30.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
