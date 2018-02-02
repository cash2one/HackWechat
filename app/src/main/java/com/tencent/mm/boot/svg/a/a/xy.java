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

public final class xy extends c {
    private final int height = 240;
    private final int width = 240;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                a.setColor(-15028967);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 68.0f, 0.0f, 1.0f, 85.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(13.540069f, 40.015434f);
                j.cubicTo(12.961421f, 39.417805f, 12.934421f, 38.432583f, 13.489049f, 37.804356f);
                j.lineTo(15.936921f, 35.03166f);
                j.cubicTo(16.48739f, 34.408142f, 17.474325f, 34.316227f, 18.125168f, 34.814026f);
                j.lineTo(37.615322f, 49.72111f);
                j.cubicTo(38.273388f, 50.224434f, 39.324657f, 50.21021f, 39.97293f, 49.68157f);
                j.lineTo(89.95811f, 8.920589f);
                j.cubicTo(90.60211f, 8.395429f, 91.602684f, 8.439274f, 92.19417f, 9.019729f);
                j.lineTo(93.4955f, 10.296785f);
                j.cubicTo(94.08643f, 10.876699f, 94.083435f, 11.820237f, 93.50139f, 12.391867f);
                j.lineTo(39.869316f, 65.06429f);
                j.cubicTo(39.28163f, 65.64146f, 38.337345f, 65.62612f, 37.75749f, 65.027245f);
                j.lineTo(13.540069f, 40.015434f);
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
