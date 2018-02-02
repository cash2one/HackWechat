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

public final class aaj extends c {
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
                a.setColor(-9473160);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 16.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(53.0f, 46.7158f);
                j.cubicTo(53.0f, 48.5108f, 51.705f, 50.4728f, 49.974f, 51.3188f);
                j.cubicTo(49.355f, 51.5178f, 46.938f, 52.0728f, 46.36f, 52.1898f);
                j.cubicTo(45.499f, 52.3608f, 44.713f, 52.1748f, 44.02f, 51.6328f);
                j.cubicTo(43.17f, 50.9718f, 42.587f, 49.8498f, 42.534f, 48.7778f);
                j.cubicTo(42.435f, 46.7368f, 43.718f, 45.0968f, 44.979f, 44.8438f);
                j.lineTo(50.365f, 43.7648f);
                j.cubicTo(51.329f, 43.5708f, 52.227f, 43.1428f, 53.0f, 42.5478f);
                j.lineTo(53.0f, 46.7158f);
                j.close();
                j.moveTo(13.471f, 55.4638f);
                j.cubicTo(13.471f, 57.2588f, 12.174f, 59.2228f, 10.446f, 60.0668f);
                j.cubicTo(9.822f, 60.2678f, 7.39f, 60.8258f, 6.832f, 60.9378f);
                j.cubicTo(5.972f, 61.1088f, 5.185f, 60.9208f, 4.489f, 60.3808f);
                j.cubicTo(3.641f, 59.7188f, 3.058f, 58.5988f, 3.006f, 57.5248f);
                j.cubicTo(2.906f, 55.4858f, 4.187f, 53.8458f, 5.449f, 53.5928f);
                j.lineTo(10.835f, 52.5128f);
                j.cubicTo(11.8f, 52.3198f, 12.697f, 51.8908f, 13.471f, 51.2958f);
                j.lineTo(13.471f, 55.4638f);
                j.close();
                j.moveTo(13.161f, 9.3678f);
                j.lineTo(13.161f, 13.2228f);
                j.lineTo(13.178f, 13.2188f);
                j.lineTo(13.178f, 45.9798f);
                j.cubicTo(13.178f, 47.6388f, 11.86f, 49.2478f, 10.245f, 49.5708f);
                j.lineTo(4.859f, 50.6508f);
                j.cubicTo(2.161f, 51.1918f, -0.164f, 54.1378f, 0.009f, 57.6718f);
                j.cubicTo(0.182f, 61.2058f, 3.328f, 64.6998f, 7.421f, 63.8788f);
                j.cubicTo(7.847f, 63.7938f, 11.11f, 63.0668f, 11.626f, 62.8268f);
                j.cubicTo(14.405f, 61.5358f, 16.471f, 58.5378f, 16.471f, 55.4638f);
                j.lineTo(16.471f, 52.1628f);
                j.lineTo(16.471f, 12.4988f);
                j.lineTo(52.708f, 4.5748f);
                j.lineTo(52.708f, 37.2318f);
                j.cubicTo(52.708f, 38.8898f, 51.389f, 40.4988f, 49.775f, 40.8228f);
                j.lineTo(44.388f, 41.9028f);
                j.cubicTo(41.691f, 42.4438f, 39.365f, 45.3898f, 39.539f, 48.9238f);
                j.cubicTo(39.712f, 52.4568f, 42.857f, 55.9518f, 46.951f, 55.1308f);
                j.cubicTo(47.377f, 55.0448f, 50.639f, 54.3188f, 51.156f, 54.0788f);
                j.cubicTo(53.934f, 52.7868f, 56.0f, 49.7898f, 56.0f, 46.7158f);
                j.lineTo(56.0f, 43.4148f);
                j.lineTo(56.0f, 3.3078f);
                j.lineTo(56.0f, -2.0E-4f);
                j.lineTo(13.161f, 9.3678f);
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
