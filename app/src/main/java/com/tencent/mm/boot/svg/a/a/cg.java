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

public final class cg extends c {
    private final int height = 96;
    private final int width = 130;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 130;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 1.0f, 0.0f, -238.0f, 0.0f, 1.0f, -408.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 238.0f, 0.0f, 1.0f, 408.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(85.0f, 62.0f);
                j.lineTo(85.0f, 35.0f);
                j.cubicTo(85.0f, 33.81324f, 84.190865f, 33.0f, 83.0f, 33.0f);
                j.lineTo(49.0f, 33.0f);
                j.cubicTo(47.811264f, 33.0f, 47.0f, 33.81639f, 47.0f, 35.0f);
                j.lineTo(47.0f, 62.0f);
                j.cubicTo(47.0f, 63.18676f, 47.809135f, 64.0f, 49.0f, 64.0f);
                j.lineTo(83.0f, 64.0f);
                j.cubicTo(84.188736f, 64.0f, 85.0f, 63.18361f, 85.0f, 62.0f);
                j.close();
                j.moveTo(89.0f, 43.0f);
                j.cubicTo(93.40946f, 38.83027f, 99.615555f, 32.798397f, 100.0f, 32.0f);
                j.cubicTo(101.65531f, 31.724306f, 103.0f, 32.390232f, 103.0f, 34.0f);
                j.lineTo(103.0f, 63.0f);
                j.cubicTo(103.0f, 64.42094f, 101.78401f, 65.34744f, 100.0f, 65.0f);
                j.cubicTo(99.861565f, 64.30614f, 93.517f, 58.096f, 89.0f, 53.0f);
                j.lineTo(89.0f, 43.0f);
                j.lineTo(89.0f, 43.0f);
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
