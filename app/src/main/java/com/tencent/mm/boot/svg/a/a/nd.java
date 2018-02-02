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

public final class nd extends c {
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
                i3 = c.a(i2, looper);
                i3.setColor(-12206054);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(28.32f, 0.0f);
                j.lineTo(31.73f, 0.0f);
                j.cubicTo(46.52f, 0.66f, 59.35f, 13.49f, 60.0f, 28.28f);
                j.lineTo(60.0f, 31.52f);
                j.cubicTo(59.48f, 46.57f, 46.27f, 59.66f, 31.21f, 60.0f);
                j.lineTo(28.74f, 60.0f);
                j.cubicTo(13.88f, 59.63f, 0.87f, 46.88f, 0.0f, 32.07f);
                j.lineTo(0.0f, 28.48f);
                j.cubicTo(0.53f, 13.59f, 13.45f, 0.64f, 28.32f, 0.0f);
                j.lineTo(28.32f, 0.0f);
                j.close();
                j.moveTo(28.0f, 12.0f);
                j.lineTo(28.0f, 28.0f);
                j.lineTo(12.0f, 28.0f);
                j.lineTo(12.0f, 32.0f);
                j.lineTo(28.0f, 32.0f);
                j.lineTo(28.0f, 48.0f);
                j.lineTo(32.0f, 48.0f);
                j.lineTo(32.0f, 32.0f);
                j.lineTo(48.0f, 32.0f);
                j.lineTo(48.0f, 28.0f);
                j.lineTo(32.0f, 28.0f);
                j.lineTo(32.0f, 12.0f);
                j.lineTo(28.0f, 12.0f);
                j.lineTo(28.0f, 12.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                float[] a2 = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                i3 = c.a(i2, looper);
                Path j2 = c.j(looper);
                j2.moveTo(16.0f, 0.0f);
                j2.lineTo(20.0f, 0.0f);
                j2.lineTo(20.0f, 16.0f);
                j2.lineTo(36.0f, 16.0f);
                j2.lineTo(36.0f, 20.0f);
                j2.lineTo(20.0f, 20.0f);
                j2.lineTo(20.0f, 36.0f);
                j2.lineTo(16.0f, 36.0f);
                j2.lineTo(16.0f, 20.0f);
                j2.lineTo(0.0f, 20.0f);
                j2.lineTo(0.0f, 16.0f);
                j2.lineTo(16.0f, 16.0f);
                j2.lineTo(16.0f, 0.0f);
                j2.lineTo(16.0f, 0.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
