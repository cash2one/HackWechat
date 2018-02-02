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

public final class agx extends c {
    private final int height = 138;
    private final int width = 138;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 138;
            case 1:
                return 138;
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
                e = c.a(e, 1.0f, 0.0f, -283.0f, 0.0f, 1.0f, -245.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                float[] a2 = c.a(e, 1.0f, 0.0f, 283.0f, 0.0f, 1.0f, 245.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                Paint a3 = c.a(i2, looper);
                a3.setColor(-13917627);
                canvas.save();
                Paint a4 = c.a(a3, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 6.0f);
                j.cubicTo(0.0f, 2.6862912f, 2.6862912f, 0.0f, 6.0f, 0.0f);
                j.lineTo(132.0f, 0.0f);
                j.cubicTo(135.3137f, 0.0f, 138.0f, 2.6862912f, 138.0f, 6.0f);
                j.lineTo(138.0f, 132.0f);
                j.cubicTo(138.0f, 135.3137f, 135.3137f, 138.0f, 132.0f, 138.0f);
                j.lineTo(6.0f, 138.0f);
                j.cubicTo(2.6862912f, 138.0f, 0.0f, 135.3137f, 0.0f, 132.0f);
                j.lineTo(0.0f, 6.0f);
                j.close();
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                e = c.a(a2, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 36.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a5 = c.a(a, looper);
                a5.setColor(-1);
                a5.setStrokeWidth(6.0f);
                j = c.j(looper);
                j.moveTo(23.239437f, 34.394367f);
                j.cubicTo(27.35964f, 40.93951f, 20.518991f, 43.903023f, 17.661972f, 45.549297f);
                j.cubicTo(5.370789f, 52.541847f, 0.0f, 55.160763f, 0.0f, 58.56338f);
                j.lineTo(0.0f, 63.21127f);
                j.cubicTo(0.0f, 64.70552f, 1.1176436f, 66.0f, 2.7887323f, 66.0f);
                j.lineTo(63.21127f, 66.0f);
                j.cubicTo(64.882355f, 66.0f, 66.0f, 64.70552f, 66.0f, 63.21127f);
                j.lineTo(66.0f, 58.56338f);
                j.cubicTo(66.0f, 55.160763f, 60.62921f, 52.541847f, 48.338028f, 45.549297f);
                j.cubicTo(45.481007f, 43.903023f, 38.64036f, 40.93951f, 42.760563f, 34.394367f);
                j.cubicTo(46.419594f, 28.960619f, 49.2747f, 26.747225f, 49.267605f, 17.661972f);
                j.cubicTo(49.2747f, 9.037081f, 42.896458f, 0.0f, 33.46479f, 0.0f);
                j.cubicTo(23.103542f, 0.0f, 16.7253f, 9.037081f, 16.732395f, 17.661972f);
                j.cubicTo(16.7253f, 26.747225f, 19.580408f, 28.960619f, 23.239437f, 34.394367f);
                j.close();
                canvas.drawPath(j, a5);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(69.0f, 30.0f);
                j2.lineTo(61.5f, 30.0f);
                j2.lineTo(61.5f, 34.5f);
                j2.lineTo(69.0f, 34.5f);
                j2.lineTo(69.0f, 42.0f);
                j2.lineTo(73.5f, 42.0f);
                j2.lineTo(73.5f, 34.5f);
                j2.lineTo(81.0f, 34.5f);
                j2.lineTo(81.0f, 30.0f);
                j2.lineTo(73.5f, 30.0f);
                j2.lineTo(73.5f, 22.5f);
                j2.lineTo(69.0f, 22.5f);
                j2.lineTo(69.0f, 30.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
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
