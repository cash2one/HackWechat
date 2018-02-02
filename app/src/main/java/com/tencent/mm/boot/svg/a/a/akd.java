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

public final class akd extends c {
    private final int height = 30;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 30;
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
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 3.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(3.0f, 21.0f);
                j.lineTo(25.0f, 21.0f);
                j.lineTo(25.0f, 3.0f);
                j.lineTo(3.0f, 3.0f);
                j.lineTo(3.0f, 21.0f);
                j.close();
                j.moveTo(0.0f, 2.0049467f);
                j.cubicTo(0.0f, 0.8976452f, 0.8998975f, 0.0f, 1.9912443f, 0.0f);
                j.lineTo(26.008757f, 0.0f);
                j.cubicTo(27.10849f, 0.0f, 28.0f, 0.89702624f, 28.0f, 2.0049467f);
                j.lineTo(28.0f, 21.995054f);
                j.cubicTo(28.0f, 23.102354f, 27.100103f, 24.0f, 26.008757f, 24.0f);
                j.lineTo(1.9912443f, 24.0f);
                j.cubicTo(0.8915104f, 24.0f, 0.0f, 23.102974f, 0.0f, 21.995054f);
                j.lineTo(0.0f, 2.0049467f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(34.0f, 14.914493f);
                j.lineTo(39.0f, 18.323584f);
                j.lineTo(39.0f, 5.6764164f);
                j.lineTo(34.0f, 9.085507f);
                j.lineTo(34.0f, 14.914493f);
                j.close();
                j.moveTo(31.0f, 7.5f);
                j.lineTo(39.51767f, 1.692498f);
                j.cubicTo(40.888622f, 0.7577572f, 42.0f, 1.3417706f, 42.0f, 2.9910905f);
                j.lineTo(42.0f, 21.00891f);
                j.cubicTo(42.0f, 22.660843f, 40.884727f, 23.239586f, 39.51767f, 22.307503f);
                j.lineTo(31.0f, 16.5f);
                j.lineTo(31.0f, 7.5f);
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
