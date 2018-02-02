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

public final class vx extends c {
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-12206054);
                e = c.a(e, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 27.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 21.0f);
                j.cubicTo(6.57101f, 9.043519f, 19.245094f, 0.23467484f, 33.0f, 0.0f);
                j.cubicTo(47.52035f, -0.5352242f, 61.110394f, 8.483593f, 68.0f, 21.0f);
                j.cubicTo(61.57833f, 32.60043f, 49.461784f, 41.279293f, 36.0f, 42.0f);
                j.cubicTo(21.216398f, 42.959072f, 7.0190334f, 33.850266f, 0.0f, 21.0f);
                j.lineTo(0.0f, 21.0f);
                j.close();
                j.moveTo(30.0f, 10.0f);
                j.cubicTo(25.925423f, 10.998532f, 22.441738f, 15.190254f, 22.0f, 20.0f);
                j.cubicTo(21.223944f, 26.657608f, 27.203108f, 33.174736f, 34.0f, 33.0f);
                j.cubicTo(40.80845f, 33.204678f, 46.76765f, 26.667587f, 46.0f, 20.0f);
                j.cubicTo(45.479984f, 12.565438f, 37.35471f, 7.156121f, 30.0f, 10.0f);
                j.lineTo(30.0f, 10.0f);
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
