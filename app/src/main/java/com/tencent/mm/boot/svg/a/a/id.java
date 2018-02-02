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

public final class id extends c {
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
                a.setColor(-8617594);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 9.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(73.0f, 34.00018f);
                j.lineTo(73.0f, 57.00018f);
                j.cubicTo(72.9f, 59.03468f, 71.0865f, 60.857323f, 69.0f, 61.00018f);
                j.lineTo(12.0f, 61.00018f);
                j.cubicTo(9.91305f, 60.857323f, 8.1f, 59.03468f, 8.0f, 57.00018f);
                j.lineTo(8.0f, 24.000181f);
                j.cubicTo(8.1f, 21.966133f, 9.91305f, 20.143038f, 12.0f, 20.000181f);
                j.lineTo(19.0f, 20.000181f);
                j.cubicTo(19.35f, 20.13399f, 21.7467f, 16.067085f, 29.0f, 12.00018f);
                j.lineTo(12.0f, 12.00018f);
                j.cubicTo(5.4396f, 12.00018f, 0.0f, 17.468561f, 0.0f, 24.000181f);
                j.lineTo(0.0f, 57.00018f);
                j.cubicTo(0.0f, 63.5318f, 5.4396f, 69.00018f, 12.0f, 69.00018f);
                j.lineTo(69.0f, 69.00018f);
                j.cubicTo(75.5604f, 69.00018f, 81.0f, 63.5318f, 81.0f, 57.00018f);
                j.lineTo(81.0f, 28.000181f);
                j.lineTo(73.0f, 34.00018f);
                j.close();
                j.moveTo(53.0f, 29.000181f);
                j.lineTo(53.0f, 41.00018f);
                j.lineTo(77.0f, 20.000181f);
                j.lineTo(53.0f, 1.8039216E-4f);
                j.lineTo(53.0f, 12.00018f);
                j.cubicTo(32.732662f, 12.273722f, 16.57688f, 28.172049f, 16.0f, 48.00018f);
                j.cubicTo(24.49405f, 36.795803f, 37.67185f, 29.378492f, 53.0f, 29.000181f);
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
