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

public final class aes extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                a.setColor(-6710887);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(34.0f, 0.0f);
                j.lineTo(37.77f, 0.0f);
                j.cubicTo(46.83f, 0.56f, 55.72f, 4.44f, 61.96f, 11.09f);
                j.cubicTo(67.89f, 17.18f, 71.41f, 25.42f, 72.0f, 33.88f);
                j.lineTo(72.0f, 37.76f);
                j.cubicTo(71.52f, 46.61f, 67.74f, 55.23f, 61.42f, 61.47f);
                j.cubicTo(55.3f, 67.71f, 46.82f, 71.34f, 38.15f, 72.0f);
                j.lineTo(34.35f, 72.0f);
                j.cubicTo(25.49f, 71.52f, 16.81f, 67.81f, 10.58f, 61.46f);
                j.cubicTo(4.3f, 55.27f, 0.55f, 46.73f, 0.0f, 37.95f);
                j.lineTo(0.0f, 34.45f);
                j.cubicTo(0.43f, 24.82f, 4.87f, 15.48f, 12.1f, 9.1f);
                j.cubicTo(18.08f, 3.66f, 25.97f, 0.6f, 34.0f, 0.0f);
                j.lineTo(34.0f, 0.0f);
                j.close();
                j.moveTo(29.41f, 3.66f);
                j.cubicTo(18.26f, 5.87f, 8.62f, 14.23f, 4.9f, 24.97f);
                j.cubicTo(0.62f, 36.67f, 3.76f, 50.63f, 12.68f, 59.33f);
                j.cubicTo(22.99f, 69.98f, 40.66f, 72.12f, 53.18f, 64.16f);
                j.cubicTo(66.79f, 56.23f, 72.81f, 37.9f, 66.52f, 23.45f);
                j.cubicTo(60.91f, 9.13f, 44.44f, 0.29f, 29.41f, 3.66f);
                j.lineTo(29.41f, 3.66f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                i2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(24.0f, 24.0f);
                j2.lineTo(48.0f, 24.0f);
                j2.lineTo(48.0f, 48.0f);
                j2.lineTo(24.0f, 48.0f);
                j2.lineTo(24.0f, 24.0f);
                j2.lineTo(24.0f, 24.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
