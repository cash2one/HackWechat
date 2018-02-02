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

public final class jf extends c {
    private final int height = 28;
    private final int width = 36;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 28;
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
                i2 = c.a(i3, looper);
                i2.setStrokeWidth(1.0f);
                i2.setStrokeCap(Cap.ROUND);
                i2.setStrokeJoin(Join.MITER);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-10258787);
                a.setStrokeWidth(2.0f);
                e = c.a(e, 1.0f, 0.0f, -573.0f, 0.0f, 1.0f, -727.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 140.0f, 0.0f, 1.0f, 722.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                float[] a2 = c.a(e, 1.0f, 0.0f, 434.0f, 0.0f, 1.0f, 6.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(4.5945945f, 13.324325f);
                j.cubicTo(4.5945945f, 6.4324327f, 10.2f, 0.827027f, 17.091892f, 0.827027f);
                j.cubicTo(21.962162f, 0.827027f, 26.18919f, 3.5837839f, 28.302702f, 7.718919f);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(10.383783f, 9.372973f);
                j2.lineTo(4.5945945f, 13.324325f);
                j2.lineTo(0.64324325f, 7.5351353f);
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a4);
                canvas.restore();
                canvas.save();
                e = c.a(a2, 1.0f, 0.0f, 5.513514f, 0.0f, 1.0f, 12.864865f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a5 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(24.075676f, 0.0f);
                j.cubicTo(24.075676f, 6.891892f, 18.47027f, 12.497297f, 11.578379f, 12.497297f);
                j.cubicTo(6.708108f, 12.497297f, 2.3891892f, 9.648648f, 0.36756757f, 5.5135136f);
                canvas.drawPath(j, a5);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(18.194595f, 3.9513514f);
                j2.lineTo(24.075676f, 0.0f);
                j2.lineTo(28.027027f, 5.881081f);
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
