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

public final class aeh extends c {
    private final int height = 44;
    private final int width = 54;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 44;
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
                e = c.a(e, 1.0f, 0.0f, 0.5f, 0.0f, 1.0f, 0.5f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.5f, 0.5f);
                j.lineTo(46.5f, 0.5f);
                j.lineTo(46.5f, 36.5f);
                j.lineTo(0.5f, 36.5f);
                j.lineTo(0.5f, 0.5f);
                j.close();
                j.moveTo(42.5f, 2.5f);
                j.lineTo(42.5f, 32.5f);
                j.lineTo(3.5f, 32.5f);
                j.lineTo(3.5f, 2.5f);
                j.lineTo(42.5f, 2.5f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(51.0f, 42.5f);
                j.lineTo(52.5f, 42.5f);
                j.lineTo(52.5f, 7.5f);
                j.lineTo(49.5f, 7.5f);
                j.lineTo(49.5f, 39.5f);
                j.lineTo(5.5f, 39.5f);
                j.lineTo(5.5f, 42.5f);
                j.lineTo(51.0f, 42.5f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(36.170597f, 14.009804f);
                j.lineTo(28.390347f, 19.793558f);
                j.lineTo(15.891026f, 9.5f);
                j.lineTo(0.5576923f, 22.578432f);
                j.lineTo(0.5576923f, 32.5f);
                j.lineTo(46.557693f, 32.5f);
                j.lineTo(46.557693f, 22.578432f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
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
