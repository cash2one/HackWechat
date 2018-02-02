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

public final class er extends c {
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
                a.setColor(-3194563);
                Path j = c.j(looper);
                j.moveTo(28.0f, 0.0f);
                j.lineTo(31.91f, 0.0f);
                j.cubicTo(46.53f, 0.77f, 59.15f, 13.36f, 60.0f, 27.97f);
                j.lineTo(60.0f, 31.8f);
                j.cubicTo(59.3f, 46.69f, 46.27f, 59.57f, 31.35f, 60.0f);
                j.lineTo(28.48f, 60.0f);
                j.cubicTo(13.76f, 59.47f, 0.96f, 46.87f, 0.0f, 32.2f);
                j.lineTo(0.0f, 28.26f);
                j.cubicTo(0.67f, 13.56f, 13.33f, 0.84f, 28.0f, 0.0f);
                j.moveTo(13.35f, 25.51f);
                j.cubicTo(11.47f, 26.71f, 12.06f, 29.22f, 11.97f, 31.09f);
                j.cubicTo(11.7f, 32.88f, 12.89f, 35.05f, 14.89f, 34.94f);
                j.cubicTo(24.63f, 35.08f, 34.38f, 34.97f, 44.13f, 34.99f);
                j.cubicTo(45.92f, 35.31f, 47.97f, 34.09f, 47.96f, 32.14f);
                j.cubicTo(47.98f, 29.78f, 48.76f, 26.29f, 45.99f, 25.15f);
                j.cubicTo(36.69f, 24.77f, 27.35f, 25.14f, 18.04f, 24.98f);
                j.cubicTo(16.5f, 25.15f, 14.73f, 24.65f, 13.35f, 25.51f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-665128);
                j = c.j(looper);
                j.moveTo(13.35f, 25.51f);
                j.cubicTo(14.73f, 24.65f, 16.5f, 25.15f, 18.04f, 24.98f);
                j.cubicTo(27.35f, 25.14f, 36.69f, 24.77f, 45.99f, 25.15f);
                j.cubicTo(48.76f, 26.29f, 47.98f, 29.78f, 47.96f, 32.14f);
                j.cubicTo(47.97f, 34.09f, 45.92f, 35.31f, 44.13f, 34.99f);
                j.cubicTo(34.38f, 34.97f, 24.63f, 35.08f, 14.89f, 34.94f);
                j.cubicTo(12.89f, 35.05f, 11.7f, 32.88f, 11.97f, 31.09f);
                j.cubicTo(12.06f, 29.22f, 11.47f, 26.71f, 13.35f, 25.51f);
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
