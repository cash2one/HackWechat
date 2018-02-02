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

public final class kq extends c {
    private final int height = 78;
    private final int width = 78;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 78;
            case 1:
                return 78;
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
                canvas.save();
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                e = c.a(e, 1.0f, 0.0f, -291.0f, 0.0f, 1.0f, -1375.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 291.0f, 0.0f, 1.0f, 1375.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(38.926277f, 0.0f);
                j.cubicTo(60.424667f, 0.0f, 77.852554f, 17.427887f, 77.852554f, 38.926277f);
                j.cubicTo(77.852554f, 60.424667f, 60.424667f, 77.852554f, 38.926277f, 77.852554f);
                j.cubicTo(17.427887f, 77.852554f, 0.0f, 60.424667f, 0.0f, 38.926277f);
                j.cubicTo(0.0f, 17.427887f, 17.427887f, 0.0f, 38.926277f, 0.0f);
                j.close();
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-5066062);
                a2.setStrokeWidth(4.0f);
                j = c.j(looper);
                j.moveTo(38.926277f, 2.0f);
                j.cubicTo(59.3201f, 2.0f, 75.852554f, 18.532457f, 75.852554f, 38.926277f);
                j.cubicTo(75.852554f, 59.3201f, 59.3201f, 75.852554f, 38.926277f, 75.852554f);
                j.cubicTo(18.532457f, 75.852554f, 2.0f, 59.3201f, 2.0f, 38.926277f);
                j.cubicTo(2.0f, 18.532457f, 18.532457f, 2.0f, 38.926277f, 2.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-5066062);
                j = c.j(looper);
                j.moveTo(27.0f, 30.0f);
                j.lineTo(46.0f, 30.0f);
                j.cubicTo(47.10457f, 30.0f, 48.0f, 30.89543f, 48.0f, 32.0f);
                j.lineTo(48.0f, 47.0f);
                j.cubicTo(48.0f, 48.10457f, 47.10457f, 49.0f, 46.0f, 49.0f);
                j.lineTo(27.0f, 49.0f);
                j.cubicTo(25.89543f, 49.0f, 25.0f, 48.10457f, 25.0f, 47.0f);
                j.lineTo(25.0f, 32.0f);
                j.cubicTo(25.0f, 30.89543f, 25.89543f, 30.0f, 27.0f, 30.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-5066062);
                j = c.j(looper);
                j.moveTo(49.0f, 40.87935f);
                j.cubicTo(51.016678f, 42.67975f, 55.407413f, 46.634834f, 56.0f, 47.0f);
                j.cubicTo(56.36772f, 47.168457f, 57.0f, 46.719242f, 57.0f, 46.0f);
                j.cubicTo(57.0f, 45.650093f, 57.0f, 32.528694f, 57.0f, 32.0f);
                j.cubicTo(57.0f, 31.189203f, 56.300804f, 30.866331f, 56.0f, 31.0f);
                j.cubicTo(55.26521f, 31.426785f, 50.978527f, 35.26523f, 49.0f, 37.070236f);
                j.lineTo(49.0f, 40.87935f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
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
