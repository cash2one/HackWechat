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

public final class alc extends c {
    private final int height = 46;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(21.72f, 0.0f);
                j.lineTo(24.06f, 0.0f);
                j.cubicTo(35.45f, 0.38f, 45.34f, 10.09f, 46.0f, 21.46f);
                j.lineTo(46.0f, 24.3f);
                j.cubicTo(45.5f, 35.7f, 35.65f, 45.5f, 24.26f, 46.0f);
                j.lineTo(21.93f, 46.0f);
                j.cubicTo(10.47f, 45.63f, 0.54f, 35.78f, 0.0f, 24.34f);
                j.lineTo(0.0f, 21.82f);
                j.cubicTo(0.44f, 10.39f, 10.3f, 0.51f, 21.72f, 0.0f);
                j.lineTo(21.72f, 0.0f);
                j.close();
                j.moveTo(17.58f, 13.59f);
                j.cubicTo(15.96f, 15.34f, 16.17f, 17.82f, 15.82f, 20.0f);
                j.lineTo(12.99f, 20.0f);
                j.cubicTo(13.0f, 24.34f, 13.0f, 28.67f, 13.0f, 33.0f);
                j.lineTo(33.0f, 33.0f);
                j.cubicTo(33.0f, 28.67f, 33.0f, 24.34f, 33.01f, 20.0f);
                j.lineTo(30.18f, 20.0f);
                j.cubicTo(29.83f, 17.83f, 30.07f, 15.34f, 28.43f, 13.6f);
                j.cubicTo(25.84f, 10.18f, 20.17f, 10.17f, 17.58f, 13.59f);
                j.lineTo(17.58f, 13.59f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(18.82f, 20.0f);
                j.cubicTo(18.8f, 17.38f, 19.71f, 13.9f, 22.99f, 14.0f);
                j.cubicTo(26.26f, 13.87f, 27.22f, 17.37f, 27.18f, 20.0f);
                j.lineTo(18.82f, 20.0f);
                j.lineTo(18.82f, 20.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                float[] a3 = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 11.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(5.58f, 2.59f);
                j.cubicTo(8.17f, -0.83f, 13.84f, -0.82f, 16.43f, 2.6f);
                j.cubicTo(18.07f, 4.34f, 17.83f, 6.83f, 18.18f, 9.0f);
                j.lineTo(21.01f, 9.0f);
                j.cubicTo(21.0f, 13.34f, 21.0f, 17.67f, 21.0f, 22.0f);
                j.lineTo(1.0f, 22.0f);
                j.cubicTo(1.0f, 17.67f, 1.0f, 13.34f, 0.99f, 9.0f);
                j.lineTo(3.82f, 9.0f);
                j.cubicTo(4.17f, 6.82f, 3.96f, 4.34f, 5.58f, 2.59f);
                j.lineTo(5.58f, 2.59f);
                j.close();
                j.moveTo(6.82f, 9.0f);
                j.lineTo(15.18f, 9.0f);
                j.cubicTo(15.22f, 6.37f, 14.26f, 2.87f, 10.99f, 3.0f);
                j.cubicTo(7.71f, 2.9f, 6.8f, 6.38f, 6.82f, 9.0f);
                j.lineTo(6.82f, 9.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
