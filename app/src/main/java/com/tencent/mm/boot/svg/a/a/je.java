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

public final class je extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-3289392);
                Path j = c.j(looper);
                j.moveTo(17.0f, 48.02f);
                j.cubicTo(27.66f, 37.34f, 38.34f, 26.66f, 49.02f, 16.0f);
                j.cubicTo(50.92f, 17.88f, 52.82f, 19.78f, 54.7f, 21.68f);
                j.cubicTo(47.27f, 29.13f, 39.82f, 36.56f, 32.39f, 44.01f);
                j.cubicTo(48.6f, 44.03f, 64.81f, 44.01f, 81.02f, 44.02f);
                j.cubicTo(81.02f, 46.71f, 81.02f, 49.39f, 81.01f, 52.08f);
                j.cubicTo(64.83f, 52.1f, 48.64f, 52.07f, 32.45f, 52.09f);
                j.cubicTo(39.86f, 59.52f, 47.29f, 66.93f, 54.7f, 74.36f);
                j.cubicTo(52.82f, 76.26f, 50.92f, 78.16f, 49.02f, 80.04f);
                j.cubicTo(38.34f, 69.38f, 27.66f, 58.7f, 17.0f, 48.02f);
                j.lineTo(17.0f, 48.02f);
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
