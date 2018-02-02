package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class anu extends c {
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
                a.setColor(-12961222);
                e = c.a(e, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, d.CTRL_INDEX, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2.3605053f, 0.25534344f);
                j.cubicTo(3.921085f, -0.54583037f, 5.3216047f, 0.73604774f, 6.652099f, 1.3870015f);
                j.cubicTo(17.566153f, 7.8664947f, 28.590246f, 14.165724f, 39.47429f, 20.685276f);
                j.cubicTo(41.535053f, 21.50648f, 41.495037f, 24.560955f, 39.434273f, 25.352114f);
                j.cubicTo(28.110067f, 32.091988f, 16.705833f, 38.71169f, 5.331609f, 45.351414f);
                j.cubicTo(3.6209733f, 46.893677f, 0.579844f, 45.501637f, 1.0600222f, 43.108128f);
                j.cubicTo(0.94998145f, 30.379478f, 1.1000371f, 17.65083f, 1.0f, 4.922181f);
                j.cubicTo(1.140052f, 3.3398626f, 0.63986623f, 1.156664f, 2.3605053f, 0.25534344f);
                j.lineTo(2.3605053f, 0.25534344f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
