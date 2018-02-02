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

public final class uq extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                i3 = c.a(i2, looper);
                i3.setColor(-14187817);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(108.0f, 0.0f);
                j.lineTo(108.0f, 108.0f);
                j.lineTo(0.0f, 108.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 32.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(60.154037f, 3.58796f);
                j2.lineTo(60.154037f, 40.412003f);
                j2.lineTo(3.845964f, 40.40884f);
                j2.lineTo(3.845964f, 3.58796f);
                j2.lineTo(60.154037f, 3.58796f);
                j2.close();
                j2.moveTo(0.0f, 2.3516667f);
                j2.lineTo(0.0f, 41.64496f);
                j2.cubicTo(0.0f, 42.94329f, 1.0471251f, 43.996597f, 2.3367088f, 43.99667f);
                j2.lineTo(61.66312f, 44.0f);
                j2.cubicTo(62.953594f, 44.000072f, 64.0f, 42.948074f, 64.0f, 41.64831f);
                j2.lineTo(64.0f, 2.3517354f);
                j2.cubicTo(64.0f, 1.0533575f, 62.95285f, 0.0f, 61.663208f, 0.0f);
                j2.lineTo(2.3367934f, 0.0f);
                j2.cubicTo(1.046383f, 0.0f, 0.0f, 1.0519472f, 0.0f, 2.3516667f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j3 = c.j(looper);
                j3.moveTo(2.9155135f, 0.0f);
                j3.lineTo(-3.5527137E-15f, 2.9199913f);
                j3.lineTo(32.030815f, 35.0f);
                j3.lineTo(62.492252f, 4.491779f);
                j3.lineTo(63.02122f, 2.0014334f);
                j3.lineTo(61.084488f, 0.061725732f);
                j3.lineTo(32.030815f, 29.160017f);
                j3.close();
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                canvas.drawPath(j3, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j3 = c.j(looper);
                j3.moveTo(2.874115f, 43.0f);
                j3.lineTo(23.0f, 22.874115f);
                j3.lineTo(20.125885f, 20.0f);
                j3.lineTo(0.0f, 40.125885f);
                j3.close();
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                canvas.drawPath(j3, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j3 = c.j(looper);
                j3.moveTo(63.0f, 41.125885f);
                j3.lineTo(42.874115f, 21.0f);
                j3.lineTo(40.0f, 23.874115f);
                j3.lineTo(60.125885f, 44.0f);
                j3.close();
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                canvas.drawPath(j3, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
