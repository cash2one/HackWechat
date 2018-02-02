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

public final class afs extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.9f, 0.0f);
                j.lineTo(34.1f, 0.0f);
                j.cubicTo(33.86f, 7.5f, 29.44f, 14.06f, 24.1f, 19.0f);
                j.cubicTo(29.21f, 23.71f, 33.38f, 29.87f, 34.09f, 36.94f);
                j.cubicTo(23.03f, 37.05f, 11.96f, 37.01f, 0.9f, 36.97f);
                j.cubicTo(1.62f, 29.89f, 5.78f, 23.72f, 10.9f, 19.01f);
                j.cubicTo(5.57f, 14.06f, 1.14f, 7.5f, 0.9f, 0.0f);
                j.lineTo(0.9f, 0.0f);
                j.close();
                j.moveTo(8.27f, 6.01f);
                j.cubicTo(10.16f, 10.93f, 16.03f, 13.56f, 16.48f, 19.02f);
                j.cubicTo(16.19f, 24.12f, 10.8f, 26.53f, 8.87f, 30.95f);
                j.cubicTo(14.62f, 31.03f, 20.37f, 31.03f, 26.12f, 30.94f);
                j.cubicTo(24.2f, 26.52f, 18.8f, 24.11f, 18.52f, 19.01f);
                j.cubicTo(18.99f, 13.55f, 24.84f, 10.93f, 26.73f, 6.01f);
                j.cubicTo(20.58f, 6.0f, 14.42f, 6.0f, 8.27f, 6.01f);
                j.lineTo(8.27f, 6.01f);
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
