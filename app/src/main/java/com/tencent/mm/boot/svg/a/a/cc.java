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

public final class cc extends c {
    private final int height = 61;
    private final int width = 68;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 68;
            case 1:
                return 61;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, -296.0f, 0.0f, 1.0f, -485.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 295.0f, 0.0f, 1.0f, 485.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(53.0f, 31.0f);
                j.lineTo(59.0f, 31.0f);
                j.lineTo(38.0f, 9.956522f);
                j.lineTo(36.0f, 8.043478f);
                j.lineTo(12.0f, 31.0f);
                j.lineTo(17.0f, 31.0f);
                j.lineTo(17.0f, 55.04348f);
                j.lineTo(53.0f, 55.04348f);
                j.lineTo(53.0f, 31.0f);
                j.close();
                j.moveTo(59.0f, 37.0f);
                j.lineTo(59.0f, 59.001785f);
                j.cubicTo(59.0f, 60.10537f, 58.10506f, 61.0f, 56.99861f, 61.0f);
                j.lineTo(13.0013895f, 61.0f);
                j.cubicTo(11.896052f, 61.0f, 11.0f, 60.105663f, 11.0f, 59.001785f);
                j.lineTo(11.0f, 37.0f);
                j.lineTo(3.993048f, 37.0f);
                j.cubicTo(0.68317896f, 37.0f, -0.102572955f, 35.102573f, 2.2484722f, 32.75153f);
                j.lineTo(33.17487f, 1.825131f);
                j.cubicTo(34.735146f, 0.26485425f, 37.228786f, 0.29705298f, 38.750225f, 1.9030144f);
                j.lineTo(67.870346f, 32.640915f);
                j.cubicTo(70.15109f, 35.04837f, 69.322586f, 37.0f, 66.00695f, 37.0f);
                j.lineTo(59.0f, 37.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(40.0f, 42.0f);
                j2.lineTo(40.0f, 58.0f);
                j2.lineTo(30.0f, 58.0f);
                j2.lineTo(30.0f, 42.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
