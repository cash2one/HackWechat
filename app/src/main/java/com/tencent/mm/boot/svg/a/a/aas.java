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

public final class aas extends c {
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
                j.moveTo(14.949f, 5.8425765f);
                j.cubicTo(21.649f, 1.6792915f, 29.638f, -0.2605797f, 37.503f, 0.0289533f);
                j.cubicTo(45.468f, 0.29652175f, 53.408f, 2.8893397f, 59.778f, 7.714557f);
                j.cubicTo(62.781f, 9.984896f, 65.423f, 12.749436f, 67.47f, 15.911337f);
                j.cubicTo(69.411f, 18.899517f, 70.805f, 22.249115f, 71.491f, 25.74747f);
                j.cubicTo(72.316f, 29.922737f, 72.131f, 34.29269f, 70.953f, 38.38309f);
                j.cubicTo(69.294f, 44.209694f, 65.656f, 49.37037f, 61.004f, 53.215168f);
                j.cubicTo(55.825f, 57.515232f, 49.43f, 60.2638f, 42.799f, 61.347054f);
                j.cubicTo(33.676f, 62.845634f, 24.002f, 61.304123f, 15.968f, 56.670597f);
                j.cubicTo(10.646f, 58.412785f, 5.323f, 60.15697f, 0.0f, 61.90016f);
                j.cubicTo(2.104f, 57.420387f, 4.21f, 52.942608f, 6.312f, 48.461834f);
                j.cubicTo(3.922f, 45.468662f, 2.079f, 42.02522f, 1.034f, 38.337166f);
                j.cubicTo(-0.644f, 32.51755f, -0.26f, 26.141836f, 2.082f, 20.557842f);
                j.cubicTo(4.618f, 14.419743f, 9.327f, 9.31897f, 14.949f, 5.8425765f);
                j.lineTo(14.949f, 5.8425765f);
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
