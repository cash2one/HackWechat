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

public final class bj extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-892609);
                Path j = c.j(looper);
                j.moveTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.lineTo(68.0f, 87.0f);
                j.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                j.lineTo(3.0f, 90.0f);
                j.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                j.lineTo(0.0f, 3.0f);
                j.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                j.lineTo(46.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-4109006);
                j = c.j(looper);
                j.moveTo(68.0f, 22.0f);
                j.lineTo(49.0f, 22.0f);
                j.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                j.lineTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(25.37793f, 43.634766f);
                j.lineTo(35.239258f, 43.634766f);
                j.cubicTo(40.28418f, 43.634766f, 43.782227f, 47.0625f, 43.782227f, 52.125f);
                j.cubicTo(43.782227f, 57.1875f, 40.17871f, 60.615234f, 35.0459f, 60.615234f);
                j.lineTo(29.913086f, 60.615234f);
                j.lineTo(29.913086f, 69.0f);
                j.lineTo(25.37793f, 69.0f);
                j.lineTo(25.37793f, 43.634766f);
                j.close();
                j.moveTo(29.913086f, 47.34375f);
                j.lineTo(29.913086f, 56.958984f);
                j.lineTo(34.026367f, 56.958984f);
                j.cubicTo(37.27832f, 56.958984f, 39.176758f, 55.20117f, 39.176758f, 52.125f);
                j.cubicTo(39.176758f, 49.083984f, 37.2959f, 47.34375f, 34.043945f, 47.34375f);
                j.lineTo(29.913086f, 47.34375f);
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
