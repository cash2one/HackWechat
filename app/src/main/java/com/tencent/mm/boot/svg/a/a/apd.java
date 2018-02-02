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

public final class apd extends c {
    private final int height = 480;
    private final int width = 480;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 480;
            case 1:
                return 480;
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
                a.setColor(-2236963);
                e = c.a(e, 1.0f, 0.0f, 98.0f, 0.0f, 1.0f, 78.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(138.88869f, 0.0f);
                j.cubicTo(166.80278f, 17.73124f, 194.74689f, 35.43248f, 222.65099f, 53.18372f);
                j.cubicTo(194.72688f, 69.47486f, 166.81279f, 85.796f, 138.88869f, 102.08714f);
                j.cubicTo(138.86868f, 86.73607f, 138.89868f, 71.384995f, 138.86868f, 56.03392f);
                j.cubicTo(110.20447f, 56.683964f, 81.89031f, 67.48472f, 60.167118f, 86.21603f);
                j.cubicTo(38.493935f, 104.63732f, 23.331707f, 130.59914f, 18.18095f, 158.58109f);
                j.cubicTo(12.960182f, 186.033f, 17.110792f, 215.22505f, 30.112703f, 239.98679f);
                j.cubicTo(43.114613f, 265.19855f, 64.907814f, 285.74f, 90.861626f, 297.1908f);
                j.cubicTo(113.865005f, 307.4815f, 140.00885f, 310.49173f, 164.78249f, 305.9414f);
                j.cubicTo(194.64687f, 300.601f, 222.26093f, 283.87985f, 240.95367f, 259.99817f);
                j.cubicTo(257.82614f, 238.84671f, 267.42755f, 212.05482f, 267.95764f, 185.01294f);
                j.cubicTo(273.30844f, 185.01294f, 278.6492f, 184.99294f, 284.0f, 185.03294f);
                j.cubicTo(283.45993f, 212.18484f, 274.92868f, 239.11673f, 259.64642f, 261.5783f);
                j.cubicTo(242.84395f, 286.43002f, 218.0003f, 305.78137f, 189.70615f, 315.79208f);
                j.cubicTo(160.39185f, 326.2828f, 127.58702f, 326.73285f, 98.00268f, 317.0522f);
                j.cubicTo(69.78853f, 307.96155f, 44.704845f, 289.63025f, 27.252283f, 265.69858f);
                j.cubicTo(10.199777f, 242.43695f, 0.4983519f, 213.85495f, 0.048285786f, 185.00294f);
                j.cubicTo(-0.86184794f, 151.04056f, 11.129913f, 116.96818f, 33.003128f, 90.98637f);
                j.cubicTo(58.796917f, 59.824184f, 98.39273f, 40.662846f, 138.87868f, 40.0328f);
                j.cubicTo(138.88869f, 26.691866f, 138.86868f, 13.350934f, 138.88869f, 0.0f);
                j.lineTo(138.88869f, 0.0f);
                j.close();
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
