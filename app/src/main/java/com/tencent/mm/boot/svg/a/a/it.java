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

public final class it extends c {
    private final int height = 50;
    private final int width = 47;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 47;
            case 1:
                return 50;
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
                a.setColor(-3355444);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(25.0f, 0.0f);
                j.cubicTo(32.22f, 3.53f, 39.56f, 5.91f, 47.0f, 8.0f);
                j.lineTo(47.0f, 17.0f);
                j.cubicTo(45.57f, 25.23f, 44.335155f, 42.1625f, 23.5f, 50.0f);
                j.cubicTo(2.3484375f, 42.671486f, 1.27f, 23.62f, 0.0f, 16.0f);
                j.lineTo(0.0f, 8.0f);
                j.cubicTo(7.48f, 5.95f, 14.89f, 3.62f, 22.0f, 0.0f);
                j.lineTo(25.0f, 0.0f);
                j.close();
                j.moveTo(13.723477f, 35.03351f);
                j.cubicTo(15.033922f, 34.624176f, 18.0f, 33.0f, 18.0f, 33.0f);
                j.cubicTo(18.0f, 33.0f, 21.632812f, 34.032497f, 24.0f, 33.91982f);
                j.cubicTo(29.694897f, 34.032497f, 37.07939f, 29.353098f, 37.03392f, 22.234169f);
                j.cubicTo(37.001835f, 17.474546f, 31.714815f, 12.0f, 24.0f, 12.0f);
                j.cubicTo(17.745829f, 12.0f, 11.291461f, 15.644713f, 11.042147f, 22.234169f);
                j.cubicTo(11.042147f, 26.79235f, 12.733758f, 29.797903f, 14.712788f, 31.306128f);
                j.cubicTo(14.712788f, 31.306128f, 14.148407f, 33.51768f, 13.723477f, 35.03351f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(20.0f, 23.0f);
                j.cubicTo(21.10457f, 23.0f, 22.0f, 22.10457f, 22.0f, 21.0f);
                j.cubicTo(22.0f, 19.89543f, 21.10457f, 19.0f, 20.0f, 19.0f);
                j.cubicTo(18.89543f, 19.0f, 18.0f, 19.89543f, 18.0f, 21.0f);
                j.cubicTo(18.0f, 22.10457f, 18.89543f, 23.0f, 20.0f, 23.0f);
                j.lineTo(20.0f, 23.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(29.0f, 23.0f);
                j.cubicTo(30.10457f, 23.0f, 31.0f, 22.10457f, 31.0f, 21.0f);
                j.cubicTo(31.0f, 19.89543f, 30.10457f, 19.0f, 29.0f, 19.0f);
                j.cubicTo(27.89543f, 19.0f, 27.0f, 19.89543f, 27.0f, 21.0f);
                j.cubicTo(27.0f, 22.10457f, 27.89543f, 23.0f, 29.0f, 23.0f);
                j.lineTo(29.0f, 23.0f);
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
