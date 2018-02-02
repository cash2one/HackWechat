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

public final class aep extends c {
    private final int height = 180;
    private final int width = 180;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.saveLayerAlpha(null, 179, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(87.28f, 0.0f);
                j.lineTo(92.51f, 0.0f);
                j.cubicTo(113.57f, 0.61f, 134.34f, 8.79f, 149.99f, 22.93f);
                j.cubicTo(168.12f, 38.95f, 179.11f, 62.56f, 180.0f, 86.72f);
                j.lineTo(180.0f, 92.68f);
                j.cubicTo(179.38f, 113.25f, 171.51f, 133.48f, 157.98f, 148.99f);
                j.cubicTo(141.79f, 167.8f, 117.59f, 179.28f, 92.78f, 180.0f);
                j.lineTo(87.53f, 180.0f);
                j.cubicTo(66.65f, 179.42f, 46.09f, 171.37f, 30.47f, 157.49f);
                j.cubicTo(12.08f, 141.44f, 0.89f, 117.65f, 0.0f, 93.27f);
                j.lineTo(0.0f, 87.28f);
                j.cubicTo(0.7f, 63.65f, 11.08f, 40.48f, 28.42f, 24.38f);
                j.cubicTo(44.21f, 9.43f, 65.56f, 0.68f, 87.28f, 0.0f);
                j.lineTo(87.28f, 0.0f);
                j.close();
                j.moveTo(78.54f, 6.79f);
                j.cubicTo(52.9f, 10.12f, 29.4f, 26.19f, 16.83f, 48.75f);
                j.cubicTo(5.72f, 68.22f, 3.03f, 92.22f, 9.41f, 113.7f);
                j.cubicTo(14.51f, 131.23f, 25.57f, 146.95f, 40.32f, 157.72f);
                j.cubicTo(54.3f, 168.06f, 71.59f, 173.82f, 88.98f, 173.98f);
                j.cubicTo(107.05f, 174.25f, 125.16f, 168.48f, 139.68f, 157.72f);
                j.cubicTo(153.56f, 147.57f, 164.19f, 133.06f, 169.63f, 116.75f);
                j.cubicTo(176.1f, 97.62f, 175.35f, 76.15f, 167.48f, 57.54f);
                j.cubicTo(160.07f, 39.76f, 146.32f, 24.72f, 129.28f, 15.75f);
                j.cubicTo(113.87f, 7.52f, 95.83f, 4.4f, 78.54f, 6.79f);
                j.lineTo(78.54f, 6.79f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(66.01f, 49.0f);
                j.cubicTo(88.67f, 62.68f, 111.34f, 76.33f, 134.0f, 90.01f);
                j.cubicTo(111.33f, 103.67f, 88.67f, 117.33f, 66.01f, 131.0f);
                j.cubicTo(66.0f, 103.67f, 66.0f, 76.34f, 66.01f, 49.0f);
                j.lineTo(66.01f, 49.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
