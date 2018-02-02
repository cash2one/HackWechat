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

public final class abv extends c {
    private final int height = 73;
    private final int width = 68;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 68;
            case 1:
                return 73;
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
                a.setColor(-757915);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 9.45f, 0.0f, 1.0f, 6.75f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 2.533342f);
                j.cubicTo(0.0f, 1.1342157f, 1.1371257f, 0.0f, 2.5456994f, 0.0f);
                j.lineTo(47.4043f, 0.0f);
                j.cubicTo(48.810253f, 0.0f, 49.95f, 1.1335528f, 49.95f, 2.533342f);
                j.lineTo(49.95f, 56.866657f);
                j.cubicTo(49.95f, 58.265785f, 48.812874f, 59.4f, 47.4043f, 59.4f);
                j.lineTo(2.5456994f, 59.4f);
                j.cubicTo(1.1397485f, 59.4f, 0.0f, 58.26645f, 0.0f, 56.866657f);
                j.lineTo(0.0f, 2.533342f);
                j.close();
                j.moveTo(4.2814283f, 4.242857f);
                j.lineTo(45.66857f, 4.242857f);
                j.lineTo(45.66857f, 55.157143f);
                j.lineTo(4.2814283f, 55.157143f);
                j.lineTo(4.2814283f, 4.242857f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(24.975f, 21.214287f);
                j.cubicTo(27.733664f, 21.214287f, 29.970001f, 23.430477f, 29.970001f, 26.164286f);
                j.cubicTo(29.970001f, 28.898094f, 27.733664f, 31.114285f, 24.975f, 31.114285f);
                j.cubicTo(22.216337f, 31.114285f, 19.98f, 28.898094f, 19.98f, 26.164286f);
                j.cubicTo(19.98f, 23.430477f, 22.216337f, 21.214287f, 24.975f, 21.214287f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(32.8229f, 26.016615f);
                j.cubicTo(42.771538f, 23.7808f, 49.95f, 17.410063f, 49.95f, 9.9f);
                j.cubicTo(49.95f, 7.916405f, 49.449215f, 6.0122924f, 48.528873f, 4.242857f);
                j.lineTo(45.262028f, 4.242857f);
                j.cubicTo(45.528664f, 5.0701585f, 45.66857f, 5.96271f, 45.66857f, 6.9225564f);
                j.cubicTo(45.66857f, 13.030636f, 40.002968f, 20.055094f, 32.067444f, 22.827524f);
                j.cubicTo(32.532673f, 23.796925f, 32.801483f, 24.876797f, 32.8229f, 26.016615f);
                j.close();
                j.moveTo(17.1271f, 26.016615f);
                j.cubicTo(7.178464f, 23.7808f, 0.0f, 17.410063f, 0.0f, 9.9f);
                j.cubicTo(0.0f, 7.916405f, 0.5007839f, 6.0122924f, 1.421125f, 4.242857f);
                j.lineTo(4.6879735f, 4.242857f);
                j.cubicTo(4.4213357f, 5.0701585f, 4.2814283f, 5.96271f, 4.2814283f, 6.9225564f);
                j.cubicTo(4.2814283f, 13.030636f, 9.947033f, 20.055094f, 17.882557f, 22.827524f);
                j.cubicTo(17.417328f, 23.796925f, 17.148516f, 24.876797f, 17.1271f, 26.016615f);
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
