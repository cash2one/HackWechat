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

public final class ld extends c {
    private final int height = 50;
    private final int width = 50;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 50;
            case 1:
                return 50;
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
                i3 = c.a(i2, looper);
                i3.setColor(-8618884);
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(23.26f, 0.0f);
                j.lineTo(26.42f, 0.0f);
                j.cubicTo(38.63f, 0.57f, 49.24f, 11.0f, 50.0f, 23.21f);
                j.lineTo(50.0f, 26.5f);
                j.cubicTo(49.44f, 38.71f, 38.94f, 49.21f, 26.78f, 50.0f);
                j.lineTo(23.52f, 50.0f);
                j.cubicTo(11.33f, 49.41f, 0.78f, 38.99f, 0.0f, 26.81f);
                j.lineTo(0.0f, 23.43f);
                j.cubicTo(0.62f, 11.24f, 11.09f, 0.77f, 23.26f, 0.0f);
                j.lineTo(23.26f, 0.0f);
                j.close();
                j.moveTo(35.370926f, 15.0f);
                j.cubicTo(30.458647f, 20.306633f, 25.646616f, 25.703379f, 20.70426f, 30.989988f);
                j.cubicTo(18.659147f, 28.787233f, 16.654135f, 26.554443f, 14.609022f, 24.341677f);
                j.cubicTo(13.39599f, 25.673342f, 12.192983f, 27.005007f, 11.0f, 28.346684f);
                j.cubicTo(14.197995f, 31.931164f, 17.47619f, 35.435543f, 20.70426f, 39.0f);
                j.cubicTo(26.8396f, 32.371716f, 32.914787f, 25.683353f, 39.0f, 19.005007f);
                j.cubicTo(37.80702f, 17.653316f, 36.60401f, 16.321651f, 35.370926f, 15.0f);
                j.lineTo(35.370926f, 15.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-394759);
                float[] a2 = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 15.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(24.370928f, -1.7763568E-15f);
                j.cubicTo(25.60401f, 1.321652f, 26.807018f, 2.6533167f, 28.0f, 4.0050063f);
                j.cubicTo(21.914787f, 10.683354f, 15.839599f, 17.371716f, 9.704261f, 24.0f);
                j.cubicTo(6.4761906f, 20.435545f, 3.197995f, 16.931164f, 0.0f, 13.3466835f);
                j.cubicTo(1.1929824f, 12.005006f, 2.39599f, 10.673342f, 3.6090226f, 9.341677f);
                j.cubicTo(5.654135f, 11.554443f, 7.6591477f, 13.787234f, 9.704261f, 15.989987f);
                j.cubicTo(14.646617f, 10.70338f, 19.458647f, 5.3066335f, 24.370928f, -1.7763568E-15f);
                j.lineTo(24.370928f, -1.7763568E-15f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
