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

public final class rv extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                e = c.a(e, 1.0f, 0.0f, -2815.0f, 0.0f, 1.0f, -1426.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 2744.0f, 0.0f, 1.0f, 1222.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 71.0f, 0.0f, 1.0f, 204.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-15028967);
                Path j = c.j(looper);
                j.moveTo(120.0f, 60.415924f);
                j.cubicTo(120.0f, 26.718575f, 93.13778f, 0.0f, 59.25926f, 0.0f);
                j.cubicTo(26.862223f, 0.0f, 0.0f, 26.718575f, 0.0f, 60.415924f);
                j.cubicTo(0.0f, 92.63972f, 26.862223f, 119.35829f, 59.25926f, 119.35829f);
                j.cubicTo(93.13778f, 119.35829f, 120.0f, 92.63972f, 120.0f, 60.415924f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(29.1438f, 64.33318f);
                j.cubicTo(28.75939f, 63.93746f, 28.708668f, 63.263554f, 29.03661f, 62.819717f);
                j.lineTo(31.330149f, 59.71563f);
                j.cubicTo(31.655361f, 59.275486f, 32.276066f, 59.19089f, 32.720627f, 59.5298f);
                j.lineTo(48.21306f, 71.34036f);
                j.cubicTo(48.65579f, 71.67787f, 49.36143f, 71.66416f, 49.780098f, 71.317245f);
                j.lineTo(88.357925f, 39.350655f);
                j.cubicTo(88.78065f, 39.000374f, 89.44368f, 39.031097f, 89.842575f, 39.42294f);
                j.lineTo(91.87533f, 41.419743f);
                j.cubicTo(92.27255f, 41.809944f, 92.26884f, 42.44513f, 91.874504f, 42.831135f);
                j.lineTo(49.733486f, 84.082405f);
                j.cubicTo(49.3358f, 84.471695f, 48.706734f, 84.47158f, 48.31737f, 84.07076f);
                j.lineTo(29.1438f, 64.33318f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
