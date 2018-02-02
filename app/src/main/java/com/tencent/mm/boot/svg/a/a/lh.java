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

public final class lh extends c {
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 26.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(7.54f, 0.56f);
                j.cubicTo(9.03f, -0.52f, 11.01f, 0.49f, 11.71f, 2.02f);
                j.cubicTo(12.07f, 3.88f, 10.53f, 5.18f, 9.6f, 6.56f);
                j.cubicTo(5.87f, 11.22f, 4.8f, 17.83f, 6.84f, 23.44f);
                j.cubicTo(7.6f, 25.87f, 9.29f, 27.83f, 10.47f, 30.05f);
                j.cubicTo(11.03f, 31.94f, 9.0f, 33.56f, 7.24f, 32.92f);
                j.cubicTo(-1.92f, 24.68f, -1.65f, 8.7f, 7.54f, 0.56f);
                j.lineTo(7.54f, 0.56f);
                j.lineTo(7.54f, 0.56f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(16.63f, 7.39f);
                j.cubicTo(18.52f, 5.6f, 22.11f, 7.44f, 21.66f, 10.01f);
                j.cubicTo(21.07f, 12.61f, 18.21f, 14.23f, 18.25f, 17.08f);
                j.cubicTo(17.82f, 19.77f, 20.27f, 21.5f, 20.98f, 23.86f);
                j.cubicTo(21.37f, 26.54f, 17.58f, 28.31f, 15.8f, 26.27f);
                j.cubicTo(11.33f, 20.87f, 12.03f, 12.48f, 16.63f, 7.39f);
                j.lineTo(16.63f, 7.39f);
                j.lineTo(16.63f, 7.39f);
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
