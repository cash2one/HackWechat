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

public final class ua extends c {
    private final int height = 13;
    private final int width = 22;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 22;
            case 1:
                return 13;
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
                e = c.a(e, 1.0f, 0.0f, -1097.0f, 0.0f, 1.0f, -2690.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 988.0f, 0.0f, 1.0f, 2659.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, 0.70710677f, 0.70710677f, 11.626389f, -0.70710677f, 0.70710677f, 94.94632f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(115.736046f, 38.224194f);
                j.lineTo(115.736046f, 35.24749f);
                j.lineTo(115.736046f, 27.069532f);
                j.cubicTo(115.736046f, 26.204807f, 115.03649f, 25.504086f, 114.173546f, 25.504086f);
                j.cubicTo(113.30458f, 25.504086f, 112.611046f, 26.20479f, 112.611046f, 27.069153f);
                j.lineTo(112.611046f, 39.180725f);
                j.cubicTo(112.53231f, 39.367065f, 112.48876f, 39.571815f, 112.48876f, 39.786694f);
                j.cubicTo(112.48876f, 40.57306f, 113.06137f, 41.215767f, 113.80943f, 41.33084f);
                j.cubicTo(113.92626f, 41.358826f, 114.04818f, 41.37365f, 114.173546f, 41.37365f);
                j.cubicTo(114.268715f, 41.37365f, 114.36178f, 41.365265f, 114.45206f, 41.349194f);
                j.lineTo(118.61492f, 41.349194f);
                j.lineTo(126.79288f, 41.349194f);
                j.cubicTo(127.65761f, 41.349194f, 128.35832f, 40.64964f, 128.35832f, 39.786694f);
                j.cubicTo(128.35832f, 38.917732f, 127.65762f, 38.224194f, 126.79326f, 38.224194f);
                j.lineTo(115.736046f, 38.224194f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
