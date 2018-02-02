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

public final class pg extends c {
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
                a.setColor(-2565928);
                e = c.a(e, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(18.11f, 25.83f);
                j.cubicTo(26.56f, 17.39f, 35.0f, 8.92f, 43.47f, 0.49f);
                j.cubicTo(44.61f, 1.63f, 45.83f, 2.71f, 46.84f, 3.98f);
                j.cubicTo(46.51f, 5.07f, 45.35f, 5.72f, 44.65f, 6.58f);
                j.cubicTo(35.76f, 15.37f, 26.97f, 24.25f, 18.11f, 33.07f);
                j.cubicTo(12.07f, 27.04f, 6.03f, 21.01f, 0.0f, 14.97f);
                j.cubicTo(1.21f, 13.76f, 2.42f, 12.56f, 3.62f, 11.35f);
                j.cubicTo(8.45f, 16.18f, 13.28f, 21.01f, 18.11f, 25.83f);
                j.lineTo(18.11f, 25.83f);
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
