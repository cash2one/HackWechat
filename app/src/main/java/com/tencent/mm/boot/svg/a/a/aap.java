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

public final class aap extends c {
    private final int height = 84;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 84;
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
                a.setColor(-12206054);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 11.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(25.547518f, 1.161f);
                j.cubicTo(28.447489f, -0.117f, 31.792843f, -0.355f, 34.835617f, 0.539f);
                j.cubicTo(38.583412f, 1.605f, 41.733036f, 4.275f, 43.799168f, 7.537f);
                j.cubicTo(47.82957f, 13.897f, 48.094204f, 22.41f, 44.610043f, 29.065f);
                j.cubicTo(43.556503f, 31.072f, 42.14846f, 32.898f, 40.436836f, 34.386f);
                j.cubicTo(39.878613f, 34.913f, 39.258472f, 35.477f, 39.083717f, 36.258f);
                j.cubicTo(39.007824f, 36.803f, 39.05975f, 37.358f, 39.04577f, 37.907f);
                j.cubicTo(39.0228f, 38.278f, 39.238503f, 38.604f, 39.481167f, 38.863f);
                j.cubicTo(39.943523f, 39.353f, 40.524715f, 39.706f, 41.103912f, 40.04f);
                j.cubicTo(46.27273f, 43.266f, 51.43057f, 46.512f, 56.603386f, 49.732f);
                j.cubicTo(58.01742f, 50.372f, 59.28666f, 51.347f, 60.21437f, 52.598f);
                j.cubicTo(61.355785f, 54.114f, 61.99889f, 55.999f, 62.01187f, 57.899f);
                j.cubicTo(62.016865f, 59.266f, 62.01187f, 60.633f, 62.01387f, 62.0f);
                j.lineTo(0.0998613f, 62.0f);
                j.cubicTo(0.0998613f, 60.634f, 0.09886269f, 59.268f, 0.10085992f, 57.903f);
                j.cubicTo(0.116837725f, 56.075f, 0.707018f, 54.26f, 1.770541f, 52.775f);
                j.cubicTo(2.7082386f, 51.443f, 4.027406f, 50.402f, 5.507351f, 49.734f);
                j.cubicTo(10.640222f, 46.538f, 15.760111f, 43.319f, 20.888987f, 40.115f);
                j.cubicTo(21.515118f, 39.728f, 22.132261f, 39.313f, 22.645548f, 38.78f);
                j.cubicTo(22.865242f, 38.541f, 23.090929f, 38.252f, 23.06796f, 37.907f);
                j.cubicTo(23.052982f, 37.357f, 23.10591f, 36.802f, 23.030014f, 36.256f);
                j.cubicTo(22.84627f, 35.454f, 22.201164f, 34.879f, 21.625963f, 34.34f);
                j.cubicTo(19.084494f, 32.121f, 17.246048f, 29.16f, 16.188517f, 25.967f);
                j.cubicTo(14.192288f, 19.915f, 14.880333f, 12.951f, 18.310568f, 7.544f);
                j.cubicTo(20.055145f, 4.792f, 22.548683f, 2.472f, 25.547518f, 1.161f);
                j.lineTo(25.547518f, 1.161f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(56.02219f, 17.0f);
                j2.lineTo(72.0f, 17.0f);
                j2.lineTo(72.0f, 21.0f);
                j2.lineTo(56.02219f, 21.0f);
                j2.lineTo(56.02219f, 17.0f);
                j2.lineTo(56.02219f, 17.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(52.02774f, 29.0f);
                j2.lineTo(72.0f, 29.0f);
                j2.lineTo(72.0f, 33.0f);
                j2.lineTo(52.02774f, 33.0f);
                j2.lineTo(52.02774f, 29.0f);
                j2.lineTo(52.02774f, 29.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(56.02219f, 41.0f);
                j2.lineTo(72.0f, 41.0f);
                j2.lineTo(72.0f, 45.0f);
                j2.lineTo(56.02219f, 45.0f);
                j2.lineTo(56.02219f, 41.0f);
                j2.lineTo(56.02219f, 41.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
