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

public final class ahb extends c {
    private final int height = 78;
    private final int width = 78;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 78;
            case 1:
                return 78;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -326.0f, 0.0f, 1.0f, -362.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 98.0f, 0.0f, 1.0f, 362.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 228.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-11184811);
                a2.setStrokeWidth(3.0f);
                Path j = c.j(looper);
                j.moveTo(28.72093f, 39.7907f);
                j.cubicTo(33.18872f, 47.180103f, 26.14078f, 50.233418f, 22.39535f, 52.44186f);
                j.cubicTo(10.53354f, 59.134026f, 5.0f, 61.832302f, 5.0f, 65.093025f);
                j.lineTo(5.0f, 69.83721f);
                j.cubicTo(5.0f, 71.6663f, 6.1515117f, 73.0f, 8.16279f, 73.0f);
                j.lineTo(69.83721f, 73.0f);
                j.cubicTo(71.84849f, 73.0f, 73.0f, 71.6663f, 73.0f, 69.83721f);
                j.lineTo(73.0f, 65.093025f);
                j.cubicTo(73.0f, 61.832302f, 67.46646f, 59.134026f, 55.604652f, 52.44186f);
                j.cubicTo(51.859222f, 50.233418f, 44.81128f, 47.180103f, 49.279068f, 39.7907f);
                j.cubicTo(52.82625f, 34.83821f, 55.76787f, 32.557747f, 55.604652f, 23.976744f);
                j.cubicTo(55.76787f, 14.310931f, 49.19635f, 5.0f, 39.7907f, 5.0f);
                j.cubicTo(28.803648f, 5.0f, 22.232128f, 14.310931f, 22.39535f, 23.976744f);
                j.cubicTo(22.232128f, 32.557747f, 25.173754f, 34.83821f, 28.72093f, 39.7907f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-11184811);
                j = c.j(looper);
                j.moveTo(33.032784f, 62.02452f);
                j.cubicTo(32.495216f, 63.592533f, 33.032784f, 65.79082f, 34.231796f, 66.93293f);
                j.lineTo(37.862457f, 70.39129f);
                j.cubicTo(38.465904f, 70.9661f, 39.44163f, 70.9806f, 40.061115f, 70.40576f);
                j.lineTo(43.83273f, 66.90594f);
                j.cubicTo(45.048244f, 65.778015f, 45.590824f, 63.605457f, 45.03445f, 62.02452f);
                j.lineTo(38.955097f, 44.75f);
                j.lineTo(33.032784f, 62.02452f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
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
