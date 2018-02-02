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

public final class dn extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-13882324);
                e = c.a(e, 1.0f, 0.0f, -333.0f, 0.0f, 1.0f, -317.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 333.0f, 0.0f, 1.0f, 317.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(67.0f, 69.0f);
                j.lineTo(21.0f, 69.0f);
                j.lineTo(21.0f, 35.0f);
                j.lineTo(30.521f, 35.0f);
                j.cubicTo(31.823f, 32.063f, 33.368f, 29.769f, 35.079f, 28.0f);
                j.lineTo(17.0f, 28.0f);
                j.cubicTo(15.343f, 28.0f, 14.0f, 29.343f, 14.0f, 31.0f);
                j.lineTo(14.0f, 73.0f);
                j.cubicTo(14.0f, 74.657f, 15.343f, 76.0f, 17.0f, 76.0f);
                j.lineTo(71.0f, 76.0f);
                j.cubicTo(72.656f, 76.0f, 74.0f, 74.657f, 74.0f, 73.0f);
                j.lineTo(74.0f, 51.22f);
                j.lineTo(67.0f, 57.13f);
                j.lineTo(67.0f, 69.0f);
                j.lineTo(67.0f, 69.0f);
                j.close();
                j.moveTo(59.0f, 17.0f);
                j.lineTo(59.0f, 28.019f);
                j.cubicTo(57.325f, 28.008f, 55.583f, 28.0f, 54.0f, 28.0f);
                j.cubicTo(40.334f, 28.0f, 31.055f, 41.333f, 31.055f, 59.0f);
                j.cubicTo(35.721f, 48.16f, 40.284f, 43.0f, 59.0f, 43.0f);
                j.lineTo(59.0f, 54.0f);
                j.lineTo(73.452f, 41.848f);
                j.lineTo(74.0f, 42.357f);
                j.lineTo(74.0f, 41.386f);
                j.lineTo(81.0f, 35.5f);
                j.lineTo(59.0f, 17.0f);
                j.lineTo(59.0f, 17.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
