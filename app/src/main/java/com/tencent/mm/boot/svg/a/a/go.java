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

public final class go extends c {
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
                a.setColor(-2697514);
                e = c.a(e, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(18.307041f, 16.743668f);
                j.cubicTo(20.848019f, 11.149101f, 23.42901f, 5.5745506f, 25.989996f, 0.0f);
                j.cubicTo(28.641016f, 5.5545344f, 31.141977f, 11.189134f, 33.752983f, 16.773693f);
                j.cubicTo(39.83532f, 17.174019f, 45.91766f, 17.574347f, 52.0f, 17.984682f);
                j.cubicTo(47.568295f, 22.03799f, 43.07657f, 26.03125f, 38.66487f, 30.104576f);
                j.cubicTo(40.075413f, 36.399715f, 41.475952f, 42.694855f, 42.87649f, 48.98999f);
                j.cubicTo(37.25433f, 45.867443f, 31.64217f, 42.724876f, 26.010004f, 39.622345f);
                j.cubicTo(20.377838f, 42.734886f, 14.765679f, 45.867443f, 9.143517f, 49.0f);
                j.cubicTo(10.544055f, 42.694855f, 11.954597f, 36.399715f, 13.355137f, 30.104576f);
                j.cubicTo(9.113505f, 26.24142f, 4.921893f, 22.338236f, 0.58022314f, 18.59518f);
                j.cubicTo(0.4401693f, 18.59518f, 0.15005772f, 18.58517f, 0.0f, 18.575163f);
                j.lineTo(0.0f, 18.324959f);
                j.cubicTo(6.03232f, 17.22406f, 12.214698f, 17.354166f, 18.307041f, 16.743668f);
                j.lineTo(18.307041f, 16.743668f);
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
