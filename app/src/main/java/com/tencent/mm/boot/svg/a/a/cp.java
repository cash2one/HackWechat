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

public final class cp extends c {
    private final int height = 150;
    private final int width = 150;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 150;
            case 1:
                return 150;
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
                e = c.a(e, 1.0f, 0.0f, -239.0f, 0.0f, 1.0f, -739.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 239.0f, 0.0f, 1.0f, 739.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16139513);
                Path j = c.j(looper);
                j.moveTo(75.0f, 0.0f);
                j.cubicTo(116.42136f, 0.0f, 150.0f, 33.57864f, 150.0f, 75.0f);
                j.cubicTo(150.0f, 116.42136f, 116.42136f, 150.0f, 75.0f, 150.0f);
                j.cubicTo(33.57864f, 150.0f, 0.0f, 116.42136f, 0.0f, 75.0f);
                j.cubicTo(0.0f, 33.57864f, 33.57864f, 0.0f, 75.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(40.333332f, 110.27027f);
                j.cubicTo(37.63287f, 110.70741f, 36.316177f, 109.3305f, 37.133335f, 107.076164f);
                j.lineTo(41.4f, 94.29975f);
                j.cubicTo(37.380486f, 88.30855f, 35.0f, 83.169525f, 35.0f, 76.19984f);
                j.cubicTo(35.0f, 56.08848f, 52.9088f, 40.0f, 75.53333f, 40.0f);
                j.cubicTo(97.0912f, 40.0f, 115.0f, 56.08848f, 115.0f, 76.19984f);
                j.cubicTo(115.0f, 95.78047f, 97.0912f, 110.27027f, 75.53333f, 110.27027f);
                j.cubicTo(67.61395f, 110.27027f, 60.69544f, 108.47199f, 55.266666f, 104.94676f);
                j.lineTo(40.333332f, 110.27027f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
