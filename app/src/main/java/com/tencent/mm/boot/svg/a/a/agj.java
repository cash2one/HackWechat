package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class agj extends c {
    private final int height = 270;
    private final int width = 270;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 270;
            case 1:
                return 270;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                i2 = c.a(i2, looper);
                i2.setColor(-12601288);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(131.16f, 0.0f);
                j.lineTo(138.59f, 0.0f);
                j.cubicTo(169.69f, 0.83f, 200.36f, 12.7f, 223.71f, 33.28f);
                j.cubicTo(251.77f, 57.44f, 268.83f, 93.6f, 270.0f, 130.59f);
                j.lineTo(270.0f, 137.53f);
                j.cubicTo(269.48f, 168.53f, 257.86f, 199.15f, 237.66f, 222.67f);
                j.cubicTo(213.11f, 251.69f, 175.86f, 269.39f, 137.83f, 270.0f);
                j.lineTo(132.41f, 270.0f);
                j.cubicTo(106.69f, 269.5f, 81.14f, 261.55f, 59.82f, 247.12f);
                j.cubicTo(35.24f, 230.72f, 16.33f, 205.99f, 7.01f, 177.95f);
                j.cubicTo(2.53f, 164.82f, 0.31f, 150.97f, 0.0f, 137.13f);
                j.lineTo(0.0f, 133.07f);
                j.cubicTo(0.36f, 94.51f, 18.29f, 56.6f, 47.89f, 31.9f);
                j.cubicTo(70.96f, 12.2f, 100.85f, 0.89f, 131.16f, 0.0f);
                j.lineTo(131.16f, 0.0f);
                j.close();
                j.moveTo(203.02f, 82.05f);
                j.cubicTo(171.35f, 113.7f, 139.71f, 145.38f, 108.03f, 177.02f);
                j.cubicTo(95.98f, 165.08f, 84.03f, 153.03f, 72.01f, 141.05f);
                j.cubicTo(71.22f, 140.01f, 69.44f, 139.34f, 68.41f, 140.39f);
                j.cubicTo(65.92f, 142.65f, 63.6f, 145.1f, 61.23f, 147.49f);
                j.cubicTo(59.98f, 148.45f, 60.3f, 150.46f, 61.49f, 151.33f);
                j.cubicTo(76.33f, 166.21f, 91.18f, 181.09f, 106.08f, 195.91f);
                j.cubicTo(107.0f, 197.16f, 108.96f, 197.19f, 109.91f, 195.94f);
                j.cubicTo(144.3f, 161.65f, 178.59f, 127.26f, 212.96f, 92.94f);
                j.cubicTo(214.03f, 91.97f, 215.05f, 90.77f, 214.44f, 89.23f);
                j.cubicTo(211.96f, 86.51f, 209.35f, 83.91f, 206.66f, 81.41f);
                j.cubicTo(205.59f, 80.26f, 203.84f, 81.02f, 203.02f, 82.05f);
                j.lineTo(203.02f, 82.05f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
