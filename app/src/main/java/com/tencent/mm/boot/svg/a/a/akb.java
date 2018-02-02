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

public final class akb extends c {
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
                a.setColor(-3487030);
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1.04f, 5.81f);
                j.cubicTo(0.91f, 1.08f, 7.16f, -1.81f, 10.71f, 1.3f);
                j.cubicTo(14.01f, 3.84f, 12.8f, 8.42f, 13.0f, 12.0f);
                j.cubicTo(18.34f, 12.05f, 23.69f, 11.9f, 29.04f, 12.06f);
                j.cubicTo(32.6f, 11.89f, 35.62f, 15.51f, 34.91f, 18.99f);
                j.cubicTo(34.51f, 21.75f, 31.93f, 24.02f, 29.12f, 23.95f);
                j.cubicTo(23.75f, 24.1f, 18.38f, 23.95f, 13.01f, 24.0f);
                j.cubicTo(13.22f, 27.54f, 11.9f, 32.22f, 15.35f, 34.62f);
                j.cubicTo(19.65f, 37.31f, 25.03f, 34.96f, 29.6f, 36.6f);
                j.cubicTo(33.23f, 38.19f, 34.16f, 43.54f, 31.23f, 46.24f);
                j.cubicTo(28.55f, 48.93f, 24.42f, 47.74f, 21.03f, 48.02f);
                j.cubicTo(15.1f, 48.47f, 8.72f, 46.94f, 4.53f, 42.5f);
                j.cubicTo(1.84f, 39.75f, 0.9f, 35.8f, 1.0f, 32.05f);
                j.cubicTo(1.03f, 23.3f, 0.94f, 14.55f, 1.04f, 5.81f);
                j.lineTo(1.04f, 5.81f);
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
