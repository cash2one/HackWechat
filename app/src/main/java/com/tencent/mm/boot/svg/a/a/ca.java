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

public final class ca extends c {
    private final int height = 280;
    private final int width = 280;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 280;
            case 1:
                return 280;
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
                e = c.a(e, 1.0f, 0.0f, -10.0f, 0.0f, 1.0f, -10.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16896);
                Path j = c.j(looper);
                j.moveTo(289.5f, 151.72223f);
                j.cubicTo(289.5f, 72.954666f, 227.04533f, 10.5f, 148.27777f, 10.5f);
                j.cubicTo(72.954666f, 10.5f, 10.5f, 72.954666f, 10.5f, 151.72223f);
                j.cubicTo(10.5f, 227.04533f, 72.954666f, 289.5f, 148.27777f, 289.5f);
                j.cubicTo(227.04533f, 289.5f, 289.5f, 227.04533f, 289.5f, 151.72223f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(141.49457f, 85.5f);
                j.cubicTo(140.39299f, 85.5f, 139.53296f, 86.39243f, 139.57391f, 87.50098f);
                j.lineTo(142.96306f, 179.25606f);
                j.cubicTo(142.98346f, 179.80836f, 143.44995f, 180.2561f, 144.00685f, 180.2561f);
                j.lineTo(155.99315f, 180.2561f);
                j.cubicTo(156.54922f, 180.2561f, 157.01639f, 179.81255f, 157.03694f, 179.25606f);
                j.lineTo(160.42609f, 87.50098f);
                j.cubicTo(160.4669f, 86.39587f, 159.59766f, 85.5f, 158.50543f, 85.5f);
                j.lineTo(141.49457f, 85.5f);
                j.close();
                j.moveTo(150.0f, 214.5f);
                j.cubicTo(155.799f, 214.5f, 160.5f, 209.799f, 160.5f, 204.0f);
                j.cubicTo(160.5f, 198.201f, 155.799f, 193.5f, 150.0f, 193.5f);
                j.cubicTo(144.201f, 193.5f, 139.5f, 198.201f, 139.5f, 204.0f);
                j.cubicTo(139.5f, 209.799f, 144.201f, 214.5f, 150.0f, 214.5f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
