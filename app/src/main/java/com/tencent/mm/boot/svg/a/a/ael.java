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

public final class ael extends c {
    private final int height = 44;
    private final int width = 44;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 44;
            case 1:
                return 44;
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
                a.setColor(-219617);
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(21.0f, 0.02f);
                j.cubicTo(23.3f, 4.18f, 25.62f, 8.33f, 27.86f, 12.53f);
                j.cubicTo(32.55f, 13.51f, 37.27f, 14.36f, 41.98f, 15.27f);
                j.cubicTo(38.77f, 18.7f, 35.63f, 22.2f, 32.3f, 25.52f);
                j.cubicTo(32.59f, 30.38f, 33.47f, 35.17f, 33.97f, 40.0f);
                j.cubicTo(29.65f, 37.97f, 25.33f, 35.93f, 21.0f, 33.91f);
                j.cubicTo(16.67f, 35.93f, 12.35f, 37.97f, 8.03f, 40.0f);
                j.cubicTo(8.54f, 35.18f, 9.38f, 30.39f, 9.71f, 25.56f);
                j.cubicTo(6.39f, 22.22f, 3.24f, 18.7f, 0.01f, 15.28f);
                j.cubicTo(4.72f, 14.34f, 9.47f, 13.54f, 14.16f, 12.5f);
                j.cubicTo(16.38f, 8.31f, 18.72f, 4.18f, 21.0f, 0.02f);
                j.lineTo(21.0f, 0.02f);
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
