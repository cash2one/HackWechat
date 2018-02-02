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

public final class anm extends c {
    private final int height = 255;
    private final int width = 255;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 255;
            case 1:
                return 255;
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
                a.setColor(-1);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 74.0f, 0.0f, 1.0f, 65.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(98.000374f, 0.0f);
                j.lineTo(21.999622f, 0.0f);
                j.lineTo(24.0f, 0.0f);
                j.lineTo(12.0f, 12.0f);
                j.lineTo(12.0f, 10.000714f);
                j.lineTo(12.0f, 126.0f);
                j.lineTo(108.0f, 126.0f);
                j.lineTo(108.0f, 10.000714f);
                j.lineTo(108.0f, 12.0f);
                j.lineTo(96.0f, 0.0f);
                j.lineTo(98.000374f, 0.0f);
                j.close();
                j.moveTo(108.0f, 114.0f);
                j.lineTo(96.0f, 126.0f);
                j.lineTo(108.0f, 126.0f);
                j.lineTo(108.0f, 114.0f);
                j.close();
                j.moveTo(0.0f, 48.0f);
                j.lineTo(12.0f, 48.0f);
                j.lineTo(12.0f, 126.0f);
                j.lineTo(0.0f, 126.0f);
                j.lineTo(0.0f, 48.0f);
                j.close();
                j.moveTo(0.0f, 114.0f);
                j.lineTo(12.0f, 126.0f);
                j.lineTo(0.0f, 126.0f);
                j.lineTo(0.0f, 114.0f);
                j.close();
                j.moveTo(0.0f, 60.0f);
                j.lineTo(12.0f, 48.0f);
                j.lineTo(0.0f, 48.0f);
                j.lineTo(0.0f, 60.0f);
                j.close();
                j.moveTo(36.0f, 12.0f);
                j.lineTo(48.0f, 12.0f);
                j.lineTo(48.0f, 42.0f);
                j.lineTo(36.0f, 42.0f);
                j.lineTo(36.0f, 12.0f);
                j.close();
                j.moveTo(54.0f, 12.0f);
                j.lineTo(66.0f, 12.0f);
                j.lineTo(66.0f, 42.0f);
                j.lineTo(54.0f, 42.0f);
                j.lineTo(54.0f, 12.0f);
                j.close();
                j.moveTo(72.0f, 12.0f);
                j.lineTo(84.0f, 12.0f);
                j.lineTo(84.0f, 42.0f);
                j.lineTo(72.0f, 42.0f);
                j.lineTo(72.0f, 12.0f);
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
