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

public final class eq extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1158579);
                Path j = c.j(looper);
                j.moveTo(28.12f, 0.0f);
                j.lineTo(31.27f, 0.0f);
                j.cubicTo(46.17f, 0.38f, 59.22f, 13.21f, 60.0f, 28.08f);
                j.lineTo(60.0f, 31.41f);
                j.cubicTo(59.54f, 46.48f, 46.34f, 59.63f, 31.27f, 60.0f);
                j.lineTo(28.62f, 60.0f);
                j.cubicTo(13.75f, 59.56f, 0.77f, 46.74f, 0.0f, 31.91f);
                j.lineTo(0.0f, 28.41f);
                j.cubicTo(0.57f, 13.61f, 13.35f, 0.76f, 28.12f, 0.0f);
                j.moveTo(13.33f, 25.52f);
                j.cubicTo(11.45f, 26.76f, 12.08f, 29.29f, 11.98f, 31.17f);
                j.cubicTo(11.71f, 32.93f, 12.93f, 35.04f, 14.88f, 34.94f);
                j.cubicTo(24.96f, 35.04f, 35.06f, 35.05f, 45.14f, 34.93f);
                j.cubicTo(47.09f, 35.04f, 48.25f, 32.9f, 48.02f, 31.17f);
                j.cubicTo(48.05f, 29.08f, 48.46f, 26.07f, 46.0f, 25.17f);
                j.cubicTo(36.68f, 24.75f, 27.32f, 25.15f, 17.99f, 24.97f);
                j.cubicTo(16.46f, 25.14f, 14.7f, 24.67f, 13.33f, 25.52f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(13.33f, 25.52f);
                j.cubicTo(14.7f, 24.67f, 16.46f, 25.14f, 17.99f, 24.97f);
                j.cubicTo(27.32f, 25.15f, 36.68f, 24.75f, 46.0f, 25.17f);
                j.cubicTo(48.46f, 26.07f, 48.05f, 29.08f, 48.02f, 31.17f);
                j.cubicTo(48.25f, 32.9f, 47.09f, 35.04f, 45.14f, 34.93f);
                j.cubicTo(35.06f, 35.05f, 24.96f, 35.04f, 14.88f, 34.94f);
                j.cubicTo(12.93f, 35.04f, 11.71f, 32.93f, 11.98f, 31.17f);
                j.cubicTo(12.08f, 29.29f, 11.45f, 26.76f, 13.33f, 25.52f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
