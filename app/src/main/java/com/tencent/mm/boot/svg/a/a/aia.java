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

public final class aia extends c {
    private final int height = 222;
    private final int width = 222;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 222;
            case 1:
                return 222;
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
                i3.setColor(-11286451);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(106.78f, 0.0f);
                j.lineTo(114.26f, 0.0f);
                j.cubicTo(143.67f, 0.83f, 172.5f, 13.86f, 192.4f, 35.56f);
                j.cubicTo(210.27f, 54.61f, 220.71f, 80.13f, 222.0f, 106.17f);
                j.lineTo(222.0f, 115.49f);
                j.cubicTo(220.85f, 140.93f, 210.93f, 165.91f, 193.85f, 184.84f);
                j.cubicTo(173.91f, 207.48f, 144.4f, 221.16f, 114.26f, 222.0f);
                j.lineTo(107.88f, 222.0f);
                j.cubicTo(78.88f, 221.22f, 50.43f, 208.59f, 30.55f, 187.44f);
                j.cubicTo(12.11f, 168.27f, 1.27f, 142.3f, 0.0f, 115.78f);
                j.lineTo(0.0f, 107.09f);
                j.cubicTo(1.01f, 80.27f, 11.92f, 53.95f, 30.53f, 34.57f);
                j.cubicTo(50.17f, 13.67f, 78.16f, 1.14f, 106.78f, 0.0f);
                j.lineTo(106.78f, 0.0f);
                j.close();
                j.moveTo(166.75f, 67.7f);
                j.cubicTo(141.11f, 93.18f, 115.52f, 118.69f, 89.88f, 144.16f);
                j.cubicTo(78.65f, 133.04f, 67.47f, 121.87f, 56.26f, 110.74f);
                j.cubicTo(55.32f, 109.66f, 53.84f, 108.99f, 52.43f, 109.53f);
                j.cubicTo(49.78f, 111.27f, 45.1f, 115.1f, 48.7f, 118.23f);
                j.cubicTo(60.56f, 130.06f, 72.47f, 141.86f, 84.32f, 153.7f);
                j.cubicTo(85.66f, 154.99f, 86.88f, 156.46f, 88.47f, 157.46f);
                j.cubicTo(90.13f, 158.14f, 91.93f, 157.42f, 93.02f, 156.09f);
                j.cubicTo(120.24f, 128.93f, 147.59f, 101.89f, 174.75f, 74.68f);
                j.cubicTo(177.24f, 72.17f, 174.1f, 69.35f, 172.21f, 67.69f);
                j.cubicTo(170.84f, 65.92f, 168.1f, 65.88f, 166.75f, 67.7f);
                j.lineTo(166.75f, 67.7f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                float[] a2 = c.a(e, 1.0f, 0.0f, 47.0f, 0.0f, 1.0f, 66.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(119.75f, 1.7f);
                j.cubicTo(121.1f, -0.12f, 123.84f, -0.08f, 125.21f, 1.69f);
                j.cubicTo(127.1f, 3.35f, 130.24f, 6.17f, 127.75f, 8.68f);
                j.cubicTo(100.59f, 35.89f, 73.24f, 62.93f, 46.02f, 90.09f);
                j.cubicTo(44.93f, 91.42f, 43.13f, 92.14f, 41.47f, 91.46f);
                j.cubicTo(39.88f, 90.46f, 38.66f, 88.99f, 37.32f, 87.7f);
                j.cubicTo(25.47f, 75.86f, 13.56f, 64.06f, 1.7f, 52.23f);
                j.cubicTo(-1.9f, 49.1f, 2.78f, 45.27f, 5.43f, 43.53f);
                j.cubicTo(6.84f, 42.99f, 8.32f, 43.66f, 9.26f, 44.74f);
                j.cubicTo(20.47f, 55.87f, 31.65f, 67.04f, 42.88f, 78.16f);
                j.cubicTo(68.52f, 52.69f, 94.11f, 27.18f, 119.75f, 1.7f);
                j.lineTo(119.75f, 1.7f);
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
