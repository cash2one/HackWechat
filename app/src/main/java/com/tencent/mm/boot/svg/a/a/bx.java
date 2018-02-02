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

public final class bx extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-13871462);
                Path j = c.j(looper);
                j.moveTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.lineTo(68.0f, 87.0f);
                j.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                j.lineTo(3.0f, 90.0f);
                j.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                j.lineTo(0.0f, 3.0f);
                j.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                j.lineTo(46.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-14465925);
                j = c.j(looper);
                j.moveTo(68.0f, 22.0f);
                j.lineTo(49.0f, 22.0f);
                j.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                j.lineTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(33.91211f, 50.648438f);
                j2.lineTo(28.726562f, 69.0f);
                j2.lineTo(24.455078f, 69.0f);
                j2.lineTo(17.652344f, 43.634766f);
                j2.lineTo(22.363281f, 43.634766f);
                j2.lineTo(26.757812f, 62.847656f);
                j2.lineTo(26.898438f, 62.847656f);
                j2.lineTo(31.996094f, 43.634766f);
                j2.lineTo(36.003906f, 43.634766f);
                j2.lineTo(41.101562f, 62.847656f);
                j2.lineTo(41.242188f, 62.847656f);
                j2.lineTo(45.63672f, 43.634766f);
                j2.lineTo(50.347656f, 43.634766f);
                j2.lineTo(43.54492f, 69.0f);
                j2.lineTo(39.273438f, 69.0f);
                j2.lineTo(34.08789f, 50.648438f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
