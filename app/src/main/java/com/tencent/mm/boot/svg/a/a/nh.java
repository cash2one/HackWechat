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

public final class nh extends c {
    private final int height = 63;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                a.setColor(-14624737);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(51.0f, 0.0f);
                j.lineTo(51.0f, 3.0f);
                j.lineTo(0.0f, 3.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(9.0f, 0.0f);
                j.lineTo(9.0f, 41.0f);
                j.lineTo(0.0f, 41.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                j.moveTo(3.0f, 18.0f);
                j.lineTo(3.0f, 24.074074f);
                j.lineTo(6.0f, 24.074074f);
                j.lineTo(6.0f, 18.0f);
                j.lineTo(3.0f, 18.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(42.0f, 0.0f);
                j.lineTo(51.0f, 0.0f);
                j.lineTo(51.0f, 41.0f);
                j.lineTo(42.0f, 41.0f);
                j.lineTo(42.0f, 0.0f);
                j.close();
                j.moveTo(45.0f, 18.0f);
                j.lineTo(45.0f, 24.074074f);
                j.lineTo(48.0f, 24.074074f);
                j.lineTo(48.0f, 18.0f);
                j.lineTo(45.0f, 18.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(0.0f, 38.0f);
                j.lineTo(51.0f, 38.0f);
                j.lineTo(51.0f, 41.0f);
                j.lineTo(0.0f, 41.0f);
                j.lineTo(0.0f, 38.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
