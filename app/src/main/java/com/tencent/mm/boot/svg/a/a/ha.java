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

public final class ha extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-8683387);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(44.0f, 26.0f);
                j.lineTo(38.0f, 32.0f);
                j.cubicTo(38.86063f, 32.18764f, 39.391327f, 32.618652f, 40.0f, 33.0f);
                j.cubicTo(43.856228f, 37.084045f, 43.856228f, 43.524426f, 40.0f, 47.0f);
                j.lineTo(25.0f, 62.0f);
                j.cubicTo(21.528116f, 65.855446f, 15.087992f, 65.855446f, 11.0f, 62.0f);
                j.cubicTo(7.1437726f, 57.91035f, 7.1437726f, 51.469517f, 11.0f, 47.0f);
                j.lineTo(16.0f, 43.0f);
                j.cubicTo(14.604678f, 39.43273f, 14.147989f, 35.501705f, 15.0f, 32.0f);
                j.lineTo(5.0f, 42.0f);
                j.cubicTo(-1.7873816f, 48.893364f, -1.7873816f, 60.486504f, 5.0f, 68.0f);
                j.cubicTo(12.512122f, 74.787575f, 24.103985f, 74.787575f, 31.0f, 68.0f);
                j.lineTo(46.0f, 53.0f);
                j.cubicTo(52.78738f, 46.10103f, 52.78738f, 34.507442f, 46.0f, 27.0f);
                j.cubicTo(45.151382f, 26.870602f, 44.642796f, 26.420181f, 44.0f, 26.0f);
                j.moveTo(68.0f, 5.0f);
                j.cubicTo(60.488327f, -1.7875781f, 48.896015f, -1.7875781f, 42.0f, 5.0f);
                j.lineTo(27.0f, 20.0f);
                j.cubicTo(20.212618f, 26.898972f, 20.212618f, 38.492558f, 27.0f, 46.0f);
                j.cubicTo(27.848618f, 46.1294f, 28.357655f, 46.57982f, 29.0f, 47.0f);
                j.lineTo(35.0f, 41.0f);
                j.cubicTo(34.13982f, 40.81236f, 33.608673f, 40.381348f, 33.0f, 40.0f);
                j.cubicTo(29.143772f, 35.915955f, 29.143772f, 29.475574f, 33.0f, 26.0f);
                j.lineTo(48.0f, 11.0f);
                j.cubicTo(51.472336f, 7.144558f, 57.91201f, 7.144558f, 62.0f, 11.0f);
                j.cubicTo(65.856224f, 15.08965f, 65.856224f, 21.530483f, 62.0f, 26.0f);
                j.lineTo(57.0f, 30.0f);
                j.cubicTo(58.395775f, 33.56727f, 58.852013f, 37.498295f, 58.0f, 41.0f);
                j.lineTo(68.0f, 31.0f);
                j.cubicTo(74.787384f, 24.106634f, 74.787384f, 12.513497f, 68.0f, 5.0f);
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
