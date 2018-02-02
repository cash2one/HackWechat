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

public final class tq extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-4187622);
                e = c.a(e, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(20.0f, 1.0f);
                j.cubicTo(29.125349f, -1.4006271f, 38.745907f, 1.5796907f, 45.0f, 8.0f);
                j.cubicTo(51.066624f, 14.551074f, 53.526768f, 24.332117f, 51.0f, 33.0f);
                j.cubicTo(48.626484f, 42.064007f, 40.82603f, 49.454796f, 32.0f, 51.0f);
                j.cubicTo(22.374956f, 53.495228f, 12.184362f, 50.06486f, 6.0f, 43.0f);
                j.cubicTo(0.45367983f, 36.153378f, -1.5164348f, 26.532352f, 1.0f, 18.0f);
                j.cubicTo(3.8838794f, 9.480534f, 11.474321f, 2.50979f, 20.0f, 1.0f);
                j.lineTo(20.0f, 1.0f);
                j.close();
                j.moveTo(24.0f, 11.0f);
                j.lineTo(24.0f, 34.0f);
                j.lineTo(28.0f, 34.0f);
                j.lineTo(28.0f, 11.0f);
                j.lineTo(24.0f, 11.0f);
                j.lineTo(24.0f, 11.0f);
                j.close();
                j.moveTo(24.0f, 37.0f);
                j.lineTo(24.0f, 41.0f);
                j.cubicTo(25.330078f, 41.000427f, 26.670155f, 41.000427f, 28.0f, 41.0f);
                j.cubicTo(28.000233f, 39.670284f, 28.000233f, 38.330143f, 28.0f, 37.0f);
                j.lineTo(24.0f, 37.0f);
                j.lineTo(24.0f, 37.0f);
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
