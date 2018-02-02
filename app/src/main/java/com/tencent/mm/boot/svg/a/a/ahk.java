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

public final class ahk extends c {
    private final int height = 79;
    private final int width = 78;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 78;
            case 1:
                return 79;
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
                a.setColor(-11184811);
                e = c.a(e, 1.0f, 0.0f, -98.0f, 0.0f, 1.0f, -237.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 98.0f, 0.0f, 1.0f, 237.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(39.0f, 78.49056f);
                j.cubicTo(60.539104f, 78.49056f, 78.0f, 60.919853f, 78.0f, 39.24528f);
                j.cubicTo(78.0f, 17.570711f, 60.539104f, 0.0f, 39.0f, 0.0f);
                j.cubicTo(17.460896f, 0.0f, 0.0f, 17.570711f, 0.0f, 39.24528f);
                j.cubicTo(0.0f, 60.919853f, 17.460896f, 78.49056f, 39.0f, 78.49056f);
                j.close();
                j.moveTo(39.0f, 49.81132f);
                j.cubicTo(44.79899f, 49.81132f, 49.5f, 45.080746f, 49.5f, 39.24528f);
                j.cubicTo(49.5f, 33.40982f, 44.79899f, 28.679245f, 39.0f, 28.679245f);
                j.cubicTo(33.20101f, 28.679245f, 28.5f, 33.40982f, 28.5f, 39.24528f);
                j.cubicTo(28.5f, 45.080746f, 33.20101f, 49.81132f, 39.0f, 49.81132f);
                j.close();
                j.moveTo(5.5411763f, 25.559748f);
                j.lineTo(39.42353f, 25.559748f);
                j.lineTo(21.635294f, 7.280799f);
                j.cubicTo(14.510319f, 11.176246f, 8.756289f, 17.502306f, 5.5411763f, 25.559748f);
                j.close();
                j.moveTo(38.623528f, 3.018868f);
                j.cubicTo(42.618313f, 3.018868f, 46.231693f, 3.5782247f, 49.4f, 4.7236404f);
                j.lineTo(49.4f, 30.295227f);
                j.lineTo(25.07059f, 5.5760264f);
                j.cubicTo(29.332592f, 3.9696975f, 33.99222f, 3.018868f, 38.623528f, 3.018868f);
                j.close();
                j.moveTo(3.0f, 39.671474f);
                j.cubicTo(3.0f, 44.320057f, 3.949455f, 49.015682f, 5.55f, 53.309654f);
                j.lineTo(30.2f, 28.779875f);
                j.lineTo(4.7f, 28.779875f);
                j.cubicTo(3.5547369f, 32.009815f, 3.0f, 35.63943f, 3.0f, 39.671474f);
                j.close();
                j.moveTo(25.4f, 72.91454f);
                j.lineTo(25.4f, 38.81909f);
                j.lineTo(7.2352943f, 56.7192f);
                j.cubicTo(11.105359f, 63.90108f, 17.385756f, 69.68455f, 25.4f, 72.91454f);
                j.close();
                j.moveTo(39.42353f, 75.471695f);
                j.cubicTo(44.037518f, 75.471695f, 48.70667f, 74.51502f, 52.97647f, 72.91454f);
                j.lineTo(28.6f, 48.19534f);
                j.lineTo(28.6f, 73.76692f);
                j.cubicTo(31.807348f, 74.91449f, 35.411324f, 75.471695f, 39.42353f, 75.471695f);
                j.close();
                j.moveTo(72.458824f, 52.83019f);
                j.lineTo(38.57647f, 52.83019f);
                j.lineTo(56.364704f, 71.20977f);
                j.cubicTo(63.50134f, 67.31788f, 69.24691f, 61.003838f, 72.458824f, 52.83019f);
                j.close();
                j.moveTo(75.0f, 39.671474f);
                j.cubicTo(75.0f, 35.01675f, 74.04735f, 30.324898f, 72.45f, 26.033297f);
                j.lineTo(47.8f, 49.81132f);
                j.lineTo(73.3f, 49.81132f);
                j.cubicTo(74.441315f, 47.329823f, 75.0f, 43.696667f, 75.0f, 39.671474f);
                j.close();
                j.moveTo(52.6f, 6.381058f);
                j.lineTo(52.6f, 40.47651f);
                j.lineTo(70.76471f, 22.576397f);
                j.cubicTo(66.89496f, 15.407206f, 60.61241f, 9.61857f, 52.6f, 6.381058f);
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
