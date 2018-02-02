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

public final class iw extends c {
    private final int height = 102;
    private final int width = 102;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(51.0f, 102.0f);
                j.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                j.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                j.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                j.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                j.close();
                j.moveTo(51.0f, 98.0f);
                j.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                j.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                j.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                j.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 6.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                a3 = c.a(a3, 1.0f, 0.0f, 12.65625f, 0.0f, 1.0f, 21.515625f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.8785756f, 23.757034f);
                j.cubicTo(1.2973921f, 23.163979f, 1.223493f, 22.150276f, 1.7250522f, 21.477392f);
                j.lineTo(3.0639734f, 19.681114f);
                j.cubicTo(3.5603683f, 19.015158f, 4.4945054f, 18.877115f, 5.1620426f, 19.381565f);
                j.lineTo(18.21077f, 29.242313f);
                j.cubicTo(18.873106f, 29.742832f, 19.922352f, 29.727772f, 20.574799f, 29.191858f);
                j.lineTo(54.486485f, 1.3371443f);
                j.cubicTo(55.12977f, 0.8087597f, 56.12762f, 0.8442794f, 56.730663f, 1.4314854f);
                j.lineTo(57.70836f, 2.3835058f);
                j.cubicTo(58.304504f, 2.9639935f, 58.30409f, 3.9039125f, 57.71406f, 4.4764366f);
                j.lineTo(20.482594f, 40.603558f);
                j.cubicTo(19.889599f, 41.178963f, 18.940239f, 41.167206f, 18.356556f, 40.5716f);
                j.lineTo(1.8785756f, 23.757034f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
