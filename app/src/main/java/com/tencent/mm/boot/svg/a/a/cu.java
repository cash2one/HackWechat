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

public final class cu extends c {
    private final int height = 58;
    private final int width = 58;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 58;
            case 1:
                return 58;
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
                e = c.a(e, 1.0f, 0.0f, -58.0f, 0.0f, 1.0f, -148.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 58.0f, 0.0f, 1.0f, 148.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(29.0f, 58.0f);
                j.cubicTo(45.01626f, 58.0f, 58.0f, 45.01626f, 58.0f, 29.0f);
                j.cubicTo(58.0f, 12.983743f, 45.01626f, 0.0f, 29.0f, 0.0f);
                j.cubicTo(12.983743f, 0.0f, 0.0f, 12.983743f, 0.0f, 29.0f);
                j.cubicTo(0.0f, 45.01626f, 12.983743f, 58.0f, 29.0f, 58.0f);
                j.close();
                j.moveTo(29.0f, 52.0f);
                j.cubicTo(41.70255f, 52.0f, 52.0f, 41.70255f, 52.0f, 29.0f);
                j.cubicTo(52.0f, 16.297451f, 41.70255f, 6.0f, 29.0f, 6.0f);
                j.cubicTo(16.297451f, 6.0f, 6.0f, 16.297451f, 6.0f, 29.0f);
                j.cubicTo(6.0f, 41.70255f, 16.297451f, 52.0f, 29.0f, 52.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(29.974895f, 27.246653f);
                j.lineTo(29.217737f, 14.251846f);
                j.cubicTo(29.19401f, 13.844625f, 28.835377f, 13.5f, 28.417751f, 13.5f);
                j.lineTo(27.1628f, 13.5f);
                j.cubicTo(26.745947f, 13.5f, 26.387007f, 13.836613f, 26.362814f, 14.251846f);
                j.lineTo(25.53224f, 28.506634f);
                j.cubicTo(25.501184f, 29.039612f, 25.755342f, 29.50647f, 26.163542f, 29.770678f);
                j.cubicTo(26.252584f, 30.036236f, 26.42348f, 30.280165f, 26.672367f, 30.466492f);
                j.lineTo(39.0047f, 39.69901f);
                j.cubicTo(39.340405f, 39.950333f, 39.827724f, 39.897633f, 40.089073f, 39.58617f);
                j.lineTo(40.949707f, 38.56051f);
                j.cubicTo(41.212883f, 38.24687f, 41.180317f, 37.76185f, 40.872528f, 37.47302f);
                j.lineTo(29.974895f, 27.246653f);
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
